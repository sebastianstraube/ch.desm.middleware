package ch.desm.middleware.core.component;

import org.apache.log4j.Logger;

import ch.desm.middleware.core.communication.broker.Broker;
import ch.desm.middleware.core.communication.broker.BrokerClient;

/**
 * 
 * @author Sebastian
 * 
 */
public abstract class ComponentBrokerClientBase extends BrokerClient {

    private static Logger LOGGER = Logger.getLogger(ComponentBrokerClientBase.class);

	public ComponentBrokerClientBase(Broker broker) {
		super(broker);
	}

    public void emulateBrokerMessage(String message) {
        onIncomingBrokerMessage(message);
    }

}
