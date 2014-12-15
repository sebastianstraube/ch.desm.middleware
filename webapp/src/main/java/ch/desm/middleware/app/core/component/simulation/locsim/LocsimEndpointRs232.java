package ch.desm.middleware.app.core.component.simulation.locsim;

import ch.desm.middleware.app.core.communication.endpoint.EndpointBase;
import jssc.SerialPortException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232Config;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232ConfigBuilder;

public class LocsimEndpointRs232 extends EndpointRs232 {
	
	private static Logger LOGGER = Logger.getLogger(LocsimEndpointRs232.class);
		
	public LocsimEndpointRs232Parser parser;
	public boolean isLocsimInitialized;
	public boolean isLocsimReadyToInitialize;
	
	public LocsimEndpointRs232(EnumSerialPorts enumSerialPort) {		
		super(enumSerialPort, new EndpointRs232ConfigBuilder()
			.setBaudRate(EndpointRs232Config.BAUDRATE_38400)
			.setDataBits(EndpointRs232Config.DATABITS_8)
			.setStopBits(EndpointRs232Config.STOPBITS_1)
			.setParity(EndpointRs232Config.PARITY_NONE)
			.setEventMask(EndpointRs232Config.MASK_RXCHAR)
			.setFlowControl(EndpointRs232Config.FLOWCONTROL_XONXOFF_IN | EndpointRs232Config.FLOWCONTROL_XONXOFF_OUT)
			.build());
		this.registerEndpointListener();

		this.parser = new LocsimEndpointRs232Parser();
		this.isLocsimInitialized = false;
		this.isLocsimReadyToInitialize = false;
	}
	
	public void sendMessage(String command){
		try {
			super.sendStream(command);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.ERROR, e);
		}
	}

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
