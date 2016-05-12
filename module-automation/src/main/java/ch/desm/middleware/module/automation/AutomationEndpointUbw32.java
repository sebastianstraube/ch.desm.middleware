package ch.desm.middleware.module.automation;

import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32;
import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32Message;
import ch.desm.middleware.module.automation.map.AutomationMapUbw32Analog;
import ch.desm.middleware.module.automation.map.AutomationMapUbw32Digital;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class AutomationEndpointUbw32 extends EndpointUbw32 {

    private static Logger LOGGER = Logger.getLogger(AutomationEndpointUbw32.class);

	protected AutomationMapUbw32Digital re420MapDigital;
	protected AutomationMapUbw32Analog re420MapAnalog;
	protected AutomationService service;
	
	public AutomationEndpointUbw32(AutomationService service, String port) {
		super(port, AutomationMapUbw32Digital.PINBITMASK_CONFIGURATION_DIGITAL, AutomationMapUbw32Analog.PINBITMASK_INPUT_ANALOG);
		this.registerEndpointListener();

		this.service = service;
		re420MapDigital = new AutomationMapUbw32Digital();
		re420MapAnalog = new AutomationMapUbw32Analog();
	}

	public AutomationMapUbw32Analog getMapAnalog(){
		return re420MapAnalog;
	}

	public AutomationMapUbw32Digital getMapDigital(){
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
