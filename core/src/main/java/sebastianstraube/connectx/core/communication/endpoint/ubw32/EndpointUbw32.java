package sebastianstraube.connectx.core.communication.endpoint.ubw32;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import sebastianstraube.connectx.core.communication.endpoint.rs232.EndpointRs232Config;
import sebastianstraube.connectx.core.communication.endpoint.rs232.EndpointRs232ConfigBuilder;

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
public abstract class EndpointUbw32 extends EndpointUbw32Base {

	private static Logger LOGGER = Logger.getLogger(EndpointUbw32.class);

	private EndpointUbw32Thread thread;
	private Thread handlerThread;

	/**
	 * 
	 * @param port
	 */
	public EndpointUbw32(String port, String configurationDigital, String pinbitMaskInputAnalog) {
		super(port, new EndpointRs232ConfigBuilder()
				.setBaudRate(EndpointRs232Config.BAUDRATE_9600)
				.setDataBits(EndpointRs232Config.DATABITS_8)
				.setStopBits(EndpointRs232Config.STOPBITS_1)
				.setParity(EndpointRs232Config.PARITY_NONE)
				.setEventMask(EndpointRs232Config.MASK_RXCHAR)
				.setFlowControl(EndpointRs232Config.FLOWCONTROL_NONE).build(),
				configurationDigital, pinbitMaskInputAnalog);
		this.thread = new EndpointUbw32Thread(this);
		this.handlerThread = new Thread(handler);
	}

    @Override
    public void init() {
        super.init();
		if (!handlerThread.isAlive()) {
			handlerThread.start();
		}
		reset();
    }

    @Override
    public void start() {

        if (!thread.isAlive()) {
            this.thread.start();
        }
    }

    @Override
    public void stop() {
        if (!thread.isInterrupted()) {
            this.thread.interrupt();
        }
		if (!handlerThread.isInterrupted()) {
			handlerThread.interrupt();
		}
    }

	public void reset() {
		this.boardState.reset();
		this.sendCommandReset();
		//		this.sendCommandConfigureUbw32(); //OK Packet OFF
		this.sendCommandVersion();
		if (isConfigurationDigitalAvailable()) this.sendCommandConfigure(configurationDigital);
		if (isPinBitMaskAnalogAvailable()) this.sendCommandConfigureAnalogInputs(pinbitMaskInputAnalog);
	}

	public String getPinBitMaskInputAnalog() {
		return this.pinbitMaskInputAnalog;
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

}