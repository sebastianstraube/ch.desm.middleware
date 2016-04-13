package ch.desm.middleware.app.core.communication.broker;

import java.util.LinkedList;


public abstract class BrokerClient {

	protected ch.desm.middleware.app.core.communication.broker.Broker broker;
	private LinkedList<String> subscribedTopics;

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
		subscribedTopics = new LinkedList<String>();
		init();
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
