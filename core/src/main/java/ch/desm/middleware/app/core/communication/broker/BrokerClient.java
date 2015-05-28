package ch.desm.middleware.app.core.communication.broker;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public abstract class BrokerClient {

	protected ch.desm.middleware.app.core.communication.broker.Broker broker;
	private LinkedList<String> signedTopics;

    abstract protected void intializeSignedTopic();

	abstract protected void onIncomingBrokerMessage(String message);

    protected void signForTopic(String topic) {
        signedTopics.add(topic);
    }

    public boolean hasTopicSigned(String topic) {
        return signedTopics.contains(topic);
    }

	public BrokerClient(Broker broker) {		
		this.broker = broker;
		signedTopics = new LinkedList<String>();
		init();
	}

	private void init() {
		this.intializeSignedTopic();
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
