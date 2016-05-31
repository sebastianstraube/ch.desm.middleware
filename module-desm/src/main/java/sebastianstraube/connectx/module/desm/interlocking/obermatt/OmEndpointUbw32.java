package sebastianstraube.connectx.module.desm.interlocking.obermatt;

import sebastianstraube.connectx.core.communication.endpoint.ubw32.EndpointUbw32;
import sebastianstraube.connectx.core.communication.endpoint.ubw32.EndpointUbw32Message;
import sebastianstraube.connectx.module.desm.interlocking.obermatt.map.OmMapUbw32Digital;
import sebastianstraube.connectx.module.desm.interlocking.obermatt.map.OmMapUbw32Analog;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class OmEndpointUbw32 extends EndpointUbw32 {

    private static Logger LOGGER = Logger.getLogger(OmBrokerClient.class);

	private OmService service;

	public OmEndpointUbw32(String port, OmService service) {
		super(port,
				OmMapUbw32Digital.PINBITMASK_CONFIGURATION_DIGITAL,
				OmMapUbw32Analog.PINBITMASK_INPUT_ANALOG);

        this.registerEndpointListener();
        this.service = service;
    }

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void onIncomingEndpointMessage(EndpointUbw32Message message) {
        LOGGER.log(Level.TRACE, "endpoint (" + getSerialPortName() + ") received message: " + message);

        service.getProcessor().processEndpointMessage(service, message);
    }
}
