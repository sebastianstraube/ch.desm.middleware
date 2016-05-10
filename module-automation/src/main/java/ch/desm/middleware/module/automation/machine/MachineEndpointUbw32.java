package ch.desm.middleware.module.automation.machine;

import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32;
import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32Message;
import ch.desm.middleware.module.automation.machine.map.MachineMapUbw32Analog;
import ch.desm.middleware.module.automation.machine.map.MachineMapUbw32Digital;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MachineEndpointUbw32 extends EndpointUbw32 {

    private static Logger LOGGER = Logger.getLogger(MachineEndpointUbw32.class);

	protected MachineMapUbw32Digital re420MapDigital;
	protected MachineMapUbw32Analog re420MapAnalog;
	protected MachineService service;
	
	public MachineEndpointUbw32(MachineService service, String port) {
		super(port, MachineMapUbw32Digital.PINBITMASK_CONFIGURATION_DIGITAL, MachineMapUbw32Analog.PINBITMASK_INPUT_ANALOG);
		this.registerEndpointListener();

		this.service = service;
		re420MapDigital = new MachineMapUbw32Digital();
		re420MapAnalog = new MachineMapUbw32Analog();
	}

	public MachineMapUbw32Analog getMapAnalog(){
		return re420MapAnalog;
	}

	public MachineMapUbw32Digital getMapDigital(){
		return re420MapDigital;
	}

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

	/**
	 *
	 * @param message
	 */
	@Override
	public void onIncomingEndpointMessage(EndpointUbw32Message message) {
		LOGGER.log(Level.TRACE, "endpoint (" + getSerialPortName() + ") received message: " + message);

		service.getMessageProcessor().processEndpointMessage(service, message);
	}
}
