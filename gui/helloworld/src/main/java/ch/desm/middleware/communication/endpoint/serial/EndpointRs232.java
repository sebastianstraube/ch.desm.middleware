package ch.desm.middleware.communication.endpoint.serial;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import org.apache.log4j.Logger;

import ch.desm.middleware.communication.endpoint.EndpointCommon;

public abstract class EndpointRs232 extends EndpointCommon implements
		SerialPortEventListener {

	private static Logger log = Logger.getLogger(EndpointRs232.class);
	
	protected SerialPort serialPort;
	
	public static enum EnumSerialPorts {
		COM1, COM2, COM3, COM4, COM5, COM6, COM7, COM8, COM9, COM10, COM11, COM12, COM13, COM14, COM15, COM16, COM17, COM18, COM19, COM20, COM21, COM22, COM23, COM24, COM25, COM26, COM27, COM28, COM29, COM30, COM31, COM32, COM33
	}

	public EndpointRs232(EnumSerialPorts enumSerialPort, EndpointRs232Config config) {
		this.serialPort = new SerialPort(enumSerialPort.name());
		
		this.initializeSerialPort(serialPort, config);
	}

	/**
	 * 
	 */
	public void testSeriaPort() {
		try {
			serialPort.writeString("Write Test to Serialport ..."
					+ serialPort.getPortName() + "\r\n");
		} catch (SerialPortException e) {
			log.error(e);
		}
	}

	/**
	 * 
	 */
	public String getSerialPortName() {
		return serialPort.getPortName();
	}

	/**
	 * 
	 */
	private void initializeSerialPort(SerialPort port, EndpointRs232Config config) {
		log.trace("intialize serial port:" + port.getPortName());

		try {
			port.openPort();
			port.setParams(config.getBaudRate(), config.getDataBits(), config.getStopBits(),
					config.getParity(), config.isRTS(), config.isDTR());
			port.setFlowControlMode(config.getFlowControl());
			port.setEventsMask(config.getEventMask());
			port.addEventListener(this);

			log.trace("...ready.");
			
		} catch (SerialPortException e) {
			log.error(e);
		}
	}

	/**
	 * 
	 */
	public void disconnectSerialPorts() {
		
		log.trace("disconnecting all opened serial ports :" );
		try {
			if (serialPort.isOpened()) {
				log.trace("disconnecting all opened serial ports :" + serialPort.getPortName());
				
				serialPort.purgePort(SerialPort.PURGE_RXABORT);
				serialPort.purgePort(SerialPort.PURGE_TXABORT);
				serialPort.closePort();
			}
		} catch (SerialPortException e) {
			log.error(e);
		}
	}

	/**
	 * sending a stream to serial port
	 * 
	 * @param stream
	 * @throws SerialPortException
	 */
	protected void sendStream(String stream) throws SerialPortException {
		
		if (stream != null && !stream.isEmpty() && serialPort.writeString(stream)) {
			
			log.trace(serialPort.getPortName() + " send stream: [" + stream + "]");
		}else{
			log.error(serialPort.getPortName() + " stream not send: " + stream);
		}
	}
	
	/**
	 * sending a stream to serial port
	 * 
	 * @param stream
	 * @throws SerialPortException
	 */
	protected void sendStream(byte[] stream) throws SerialPortException {
		
		if (stream!=null && serialPort.writeBytes(stream)) {
			
			log.trace(serialPort.getPortName() + " send stream:" + stream.toString());
		}else{
			log.error(serialPort.getPortName() + " stream not send: " + stream.toString());
		}
	}
	
	/**
	 * sending a stream to serial port
	 * 
	 * @param stream
	 * @throws SerialPortException
	 */
	protected void sendStream(int[] stream) throws SerialPortException {
		
		if (stream!=null && serialPort.writeIntArray(stream)) {
			
			log.trace(serialPort.getPortName() + " send stream:" + stream.toString());
		}else{
			log.error(serialPort.getPortName() + " stream not send: " + stream.toString());
		}
	}

	@Override
	/**
	 * this listener receives a command from UBW32
	 * 
	 * @param SerialPortEvent event
	 */
	public synchronized void serialEvent(SerialPortEvent event) {
		String message = this.getSerialPortMessage(event);
		
		log.debug("received serial port message on port: " + this.serialPort.getPortName() + " with message: " + message);
		
		super.onIncomingEndpointMessage(message);
	}

	protected String getSerialPortMessage(SerialPortEvent event) {
		String message = "";

		if (event.isRXCHAR()) {

			if (event.getEventValue() > 1) {
				try {
					byte buffer[] = serialPort.readBytes();

					for (int i = 0; i < buffer.length; i++) {
						message += (char) buffer[i];
					}
					
				} catch (SerialPortException ex) {
					ex.printStackTrace();
				}
			}
		}

		// If the CTS line status has changed, then the method
		// event.getEventValue() returns 1 if the line is ON and 0 if it is OFF.
		else if (event.isCTS()) {
			if (event.getEventValue() == 1) {
				log.trace(this.serialPort.getClass() + ": CTS - ON");
			} else {
				log.trace(this.serialPort.getClass() + ":CTS - OFF");
			}
		} else if (event.isDSR()) {
			if (event.getEventValue() == 1) {
				log.trace(this.serialPort.getClass() + ":DSR - ON");
			} else {
				log.trace(this.serialPort.getClass() + ":DSR - OFF");
			}
		}

		return message;
	}
}
