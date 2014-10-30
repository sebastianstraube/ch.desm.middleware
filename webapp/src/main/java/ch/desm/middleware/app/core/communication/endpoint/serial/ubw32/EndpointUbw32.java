package ch.desm.middleware.app.core.communication.endpoint.serial.ubw32;

import jssc.SerialPortEvent;
import jssc.SerialPortException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232Config;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232ConfigBuilder;

/**
 * 
 * @author Sebastian
 * 
 *         You end a command by sending a <CR> or <LF> or some combination of
 *         the two. This is how all commands must be terminated to be considered
 *         valid.
 * 
 *         The total number of bytes of each command, counting from the very
 *         first byte of the command name up to and including the <CR> at the
 *         end of the command must be 64 bytes or less. If it is longer than 64
 *         bytes, the command will be ignored, and other bad things may or may
 *         not happen.
 * 
 *         You can string together as many commands as you want into one string,
 *         and then send that string all at once to the UBW32. As long as each
 *         individual command is not more than 64 bytes, this will work well. By
 *         putting many commands together (each with their own terminating <CR>)
 *         and sending it all to the UBW32 at once, you make the most efficient
 *         use of the USB bandwidth.
 * 
 *         After successful reception of a command, the UBW32 will always send
 *         back an OK packet, which will consist of "OK<CR><LF>". For just
 *         testing things out with a terminal emulator, this is very useful
 *         because it tells you that the UBW32 understood your command. However,
 *         it does add extra communications overhead that may not be appreciated
 *         in a higher speed application. You can use the CU command to turn off
 *         the sending of "OK" packets. Errors will still be sent, but not any
 *         "OK" packets.
 * 
 *         All command names ("C", "BC", etc.) are case sensitive. In other
 *         words, "BC" is a different command from "bc".
 * 
 *         All port names ("A", "B", "C") are case insensitive. You can use "B"
 *         or "b" for port names.
 */
public class EndpointUbw32 extends EndpointUbw32Base {

	private static Logger LOGGER = Logger.getLogger(EndpointUbw32.class);

	protected String configurationDigital;
	private String pinbitMaskInputAnalog;
	private EndpointUbw32Thread thread;
	private EndpointUbw32Cache cache;

	/**
	 * 
	 * @param enumSerialPort
	 */
	public EndpointUbw32(EnumSerialPorts enumSerialPort,
			String configurationDigital, String pinbitMaskInputAnalog) {
		super(enumSerialPort, new EndpointRs232ConfigBuilder()
				.setBaudRate(EndpointRs232Config.BAUDRATE_9600)
				.setDataBits(EndpointRs232Config.DATABITS_8)
				.setStopBits(EndpointRs232Config.STOPBITS_1)
				.setParity(EndpointRs232Config.PARITY_NONE)
				.setEventMask(EndpointRs232Config.MASK_RXCHAR)
				.setFlowControl(EndpointRs232Config.FLOWCONTROL_NONE).build());

		this.pinbitMaskInputAnalog = pinbitMaskInputAnalog;
		this.configurationDigital = configurationDigital;
		this.thread = new EndpointUbw32Thread(this);
		this.cache = new EndpointUbw32Cache();
	}

	public String getPinBitMaskInputAnalog() {
		return this.pinbitMaskInputAnalog;
	}

	public void setCacheEnabled(boolean isEnabled) {
		cache.setCacheEnabled(isEnabled);
	}

	/**
	 * do work to initialze the controller
	 */
	public void initialize() {
        super.initialize();
        this.sendCommandReset();

//		this.sendCommandConfigureUbw32(); //OK Packet OFF

        this.sendCommandVersion();

        if (isConfigurationDigitalAvailable()) {
            this.sendCommandConfigure(configurationDigital);
        }

        if (isPinBitMaskAnalogAvailable()) {
            this.sendCommandConfigureAnalogInputs(pinbitMaskInputAnalog);
        }
        setCacheEnabled(true);
    }

	/**
	 * send digital and analog state to ubw
	 */
	public void pollingCommand() {
		if (isConfigurationDigitalAvailable()) {
			sendCommandInputState();
		}

		if (isPinBitMaskAnalogAvailable()) {
			sendCommandInputAnalog(getPinBitMaskInputAnalog());
		}
	}

	public void run() {
		
		if (!thread.isAlive()) {
			this.thread.start();
		}
	}

	public void interrupt() {
		if (!thread.isInterrupted()) {
			this.thread.interrupt();
		}
	}

	public boolean isConfigurationDigitalAvailable() {
		if (configurationDigital != null && !configurationDigital.isEmpty()) {
			return true;
		}

		return false;
	}

	public boolean isPinBitMaskAnalogAvailable() {
		if (pinbitMaskInputAnalog != null && !pinbitMaskInputAnalog.isEmpty()
				&& !pinbitMaskInputAnalog.equals("0")) {
			return true;
		}
		return false;
	}

	@Override
	/**
	 * this listener receives a command from UBW32
	 * 
	 * @param SerialPortEvent event
	 */
	public synchronized void serialEvent(SerialPortEvent event) {
		String message = super.getSerialPortMessage(event);
				
		if (!message.trim().isEmpty()) {
			if (!message.contains("!")) {

				String[] messages = message.split("\r\r\n");
				String singleMessage = "";
				for(
					int i=0; i < messages.length; i++){
					
					singleMessage = messages[i];
					singleMessage = singleMessage.replaceAll("\r\r\n", "");
					
					if(!singleMessage.isEmpty() && !singleMessage.equals("OK")){
						
						if (cache.isStateChanged(singleMessage, this.serialPort)) {
							
							LOGGER.log(Level.TRACE, "received message on ubw(" + serialPort.getPortName()
                                    + "), cache enabled: " + cache.isCacheEnabled() + ", message: " + singleMessage.replaceAll("\n", ""));
							
							super.onIncomingEndpointMessage(singleMessage);
						}
						else {
							LOGGER.log(Level.TRACE, "skipped received message on ubw(" + serialPort.getPortName()
                                    + "), cache enabled: " + cache.isCacheEnabled() + ", message: " + singleMessage.replaceAll("\n", ""));
						}
					}

				}
			} else {
				LOGGER.error("error message received on ubw("
						+ serialPort.getPortName() + "): " + message);

			}
		} else {

			LOGGER.log(Level.TRACE, "empty message received on ubw("
                    + serialPort.getPortName() + "): " + message);
		}
	}

	/**
	 * @param command
	 */
	@Override
	protected void sendStream(String command) {
		try {

			Thread.sleep(EndpointUbw32Config.SLEEP_SENDING);
			command += EndpointUbw32Config.MESSAGE_TERMINATOR;
			
			LOGGER.log(Level.TRACE, "message send to ubw(" + serialPort.getPortName()
                    + "): " + command.replaceAll("\n", ""));
			
			super.sendStream(command);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e);
		}
	}

	/**
	 * 
	 * @param port
	 * @param pin
	 * @param value
	 */
	@Override
	public void setPinOutputDigital(String port, String pin, String value) {
		this.sendCommandPinOutput(port, pin, value);
	}

	/**
	 * 
	 * @param port
	 * @param pin
	 */
	@Override
	public void getPinInputDigital(String port, String pin) {
		this.sendCommandPinInput(port, pin);
	}

	/**
	 * 
	 */
	@Override
	public void getPinInputAnalog(String register) {

		String pinBitMask = "";
		if (register.equals("B0")) {
			pinBitMask = "1";
		} else if (register.equals("B1")) {
			pinBitMask = "2";
		}

		this.sendCommandInputAnalog(pinBitMask);
	}

}