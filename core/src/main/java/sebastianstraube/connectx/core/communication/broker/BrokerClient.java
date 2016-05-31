package sebastianstraube.connectx.core.communication.broker;

import java.util.LinkedList;
import java.util.List;


public abstract class BrokerClient {

	protected Broker broker;
	private List<String> subscribedTopics;

    abstract protected void initializeTopicSubscriptions();

	abstract protected void onIncomingBrokerMessage(String message);

    protected void subscribeToTopic(String topic) {
        subscribedTopics.add(topic);
    }

    public boolean isSubscribedToTopic(String topic) {
        return subscribedTopics.contains(topic);
    }

	public BrokerClient(Broker broker) {		
		this.broker = broker;
		this.subscribedTopics = new LinkedList<String>();
		this.init();
	}

	private void init() {
		this.initializeTopicSubscriptions();
		broker.connect(this);
	}

	/**
	 * util to forward message to broker
	 * 
	 * @param message
	 */
	public synchronized void publish(String message, String topic) {
		if (message != null && !message.isEmpty()) {
			broker.publish(message, topic);
		}
	}

	/**
	 * called by Broker with incoming message
	 * 
	 * @param message
	 */
	protected void receive(String message) {
		if (message != null && !message.isEmpty()) {
			this.onIncomingBrokerMessage(message);
		}
	}

}
