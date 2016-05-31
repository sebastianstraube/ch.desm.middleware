package sebastianstraube.connectx.core.component;

import org.apache.log4j.Logger;

import sebastianstraube.connectx.core.communication.broker.Broker;
import sebastianstraube.connectx.core.communication.broker.BrokerClient;

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
