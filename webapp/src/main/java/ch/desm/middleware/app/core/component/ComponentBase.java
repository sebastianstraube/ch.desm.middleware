package ch.desm.middleware.app.core.component;

import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.broker.BrokerClient;
import ch.desm.middleware.app.core.communication.endpoint.EndpointBase;
import ch.desm.middleware.app.core.communication.endpoint.EndpointCommonListenerInterface;

/**
 * 
 * @author Sebastian
 * 
 */
public abstract class ComponentBase extends BrokerClient
	implements EndpointCommonListenerInterface {
	
	private static Logger LOGGER = Logger.getLogger(ComponentBase.class);
	
	public ComponentBase(Broker broker) {
		super(broker);
	}
	
	protected void registerEndpointListener(EndpointBase listener) {
        try {
            listener.addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public void emulateBrokerMessage(String message) {
        onIncomingBrokerMessage(message);
    }

	
}
