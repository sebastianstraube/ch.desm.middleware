package sebastianstraube.connectx.core.communication.endpoint.rs232;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

// TODO: is not a real endpoint any longer!
public class EndpointRs232 implements SerialPortEventListener {

	private static Logger LOGGER = Logger.getLogger(EndpointRs232.class);
	
	protected SerialPort serialPort;
	protected EndpointRs232Config config;
	private Object writeLock = new Object();
	private List<EndpointRs232ListenerInterface> listenerList = new ArrayList<>();

	public EndpointRs232(String port, EndpointRs232Config config) {
		this.serialPort = new SerialPort(port);
		this.config = config;
	}

	/**
	 *
	 */
	public String getSerialPortName() {
		return serialPort.getPortName();
	}

	// TODO: wrap the listener interface!
	public void addSerialPortEventListener(EndpointRs232ListenerInterface listener) {
		listenerList.add(listener);

	}

	/**
	 *
	 */
	public void init() {

		try {
			serialPort.openPort();
			serialPort.setParams(config.getBaudRate(), config.getDataBits(), config.getStopBits(),
					config.getParity(), config.isRTS(), config.isDTR());
			serialPort.setFlowControlMode(config.getFlowControl());
			serialPort.setEventsMask(config.getEventMask());
			serialPort.addEventListener(this);

			LOGGER.log(Level.TRACE, "serial port: "+ serialPort.getPortName()+" is initialized.");
			
		} catch (SerialPortException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	/**
	 * 
	 */
	public void closePort() {
		
		try {
			if (serialPort.isOpened()) {
				LOGGER.log(Level.TRACE,"disconnecting serial port:" + serialPort.getPortName());
				
				serialPort.purgePort(SerialPort.PURGE_RXABORT);
				serialPort.purgePort(SerialPort.PURGE_TXABORT);
				serialPort.closePort();
			}
		} catch (SerialPortException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	/**
	 * sending a stream to serial port
	 * 
	 * @param stream
	 * @throws SerialPortException
	 */
	public void sendStream(String stream) throws SerialPortException {
		synchronized (writeLock){
            if (stream != null && !stream.isEmpty() && serialPort.writeString(stream)) {

                LOGGER.log(Level.TRACE, serialPort.getPortName() + " send stream: [" + stream + "]");
            }else{
                LOGGER.log(Level.ERROR, serialPort.getPortName() + " stream not send: " + stream);
            }
        }
	}
	
	/**
	 * sending a stream to serial port
	 * 
	 * @param stream
	 * @throws SerialPortException
	 */
	public void sendStream(byte[] stream) throws SerialPortException {
        synchronized (writeLock) {
            if (stream != null && serialPort.writeBytes(stream)) {

                LOGGER.log(Level.TRACE, serialPort.getPortName() + " send stream:" + stream.toString());
            } else {
                LOGGER.log(Level.ERROR, serialPort.getPortName() + " stream not send: " + stream.toString());
            }
        }
	}
	
	/**
	 * sending a stream to serial port
	 * 
	 * @param stream
	 * @throws SerialPortException
	 */
	public void sendStream(int[] stream) throws SerialPortException {
        synchronized (writeLock) {
            if (stream != null && serialPort.writeIntArray(stream)) {

                LOGGER.log(Level.TRACE, serialPort.getPortName() + " send stream:" + stream.toString());
            } else {
                LOGGER.log(Level.ERROR, serialPort.getPortName() + " stream not send: " + stream.toString());
            }
        }
	}

	protected String readDataFromSerialPort(SerialPortEvent event) {
		if (event.isRXCHAR()) {
			final int numAvailableBytes = event.getEventValue();
			if (numAvailableBytes > 0) {
				try {
					return new String(serialPort.readBytes());
				} catch (SerialPortException ex) {
					LOGGER.log(Level.ERROR, ex);
				}
			}
		}

		// If the CTS line status has changed, then the method
		// event.getEventValue() returns 1 if the line is ON and 0 if it is OFF.
		else if (event.isCTS()) {
			if (event.getEventValue() == 1) {
				LOGGER.log(Level.TRACE,this.serialPort.getClass() + ": CTS - ON");
			} else {
				LOGGER.log(Level.TRACE,this.serialPort.getClass() + ":CTS - OFF");
			}
		} else if (event.isDSR()) {
			if (event.getEventValue() == 1) {
				LOGGER.log(Level.TRACE,this.serialPort.getClass() + ":DSR - ON");
			} else {
				LOGGER.log(Level.TRACE,this.serialPort.getClass() + ":DSR - OFF");
			}
		}

		return null;
	}

	@Override
	/**
	 * this listener receives a command from UBW32
	 *
	 * @param SerialPortEvent event
	 */
	public void serialEvent(SerialPortEvent event) {
		final String data = readDataFromSerialPort(event);
		if (data == null || data.isEmpty()) {
			return;
		}

		for (EndpointRs232ListenerInterface listener : listenerList) {
			listener.onData(data);
		}
	}
}
