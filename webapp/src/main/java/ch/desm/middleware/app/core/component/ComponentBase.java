package ch.desm.middleware.app.core.component;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.broker.BrokerClient;
import ch.desm.middleware.app.core.communication.endpoint.EndpointBase;
import ch.desm.middleware.app.core.communication.endpoint.EndpointCommonListenerInterface;

import java.util.Map;

/**
 * 
 * @author Sebastian
 * 
 */
public abstract class ComponentBase extends BrokerClient
	implements EndpointCommonListenerInterface {
	
	private static Logger LOGGER = Logger.getLogger(ComponentBase.class);
    private static final ComponentMapMiddleware mapMiddlewareMessages = new ComponentMapMiddleware();

	public ComponentBase(Broker broker) {
		super(broker);
	}
	
	protected void registerEndpointListener(EndpointBase listener) {
        try {
            listener.addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public Map<String, String> getMapMiddlewareMessages(){
        return this.mapMiddlewareMessages.getMap();
    }

    public ComponentMapMiddleware getMiddlewareMessages(){
        return this.mapMiddlewareMessages;
    }

    public void emulateBrokerMessage(String message) {
        onIncomingBrokerMessage(message);
    }

	
}
