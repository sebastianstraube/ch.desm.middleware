package ch.desm.middleware.modules.communication.broker;

import ch.desm.middleware.modules.communication.message.type.component.MessageComponentBase;


public abstract class BrokerClient implements BrokerClientInterface {

    protected static Broker broker;

    public BrokerClient(Broker broker) {
        BrokerClient.broker = broker;
        
        initialize();
    }
    
    private void initialize(){
    	broker.connect(this);
    }

    /**
     * util to forward message to broker
     * @param message
     */
    protected void publish(MessageComponentBase message) {
        broker.publish(this, message);
    }

    /**
     * called by Broker with incoming message
     * @param message
     */
    protected void receive(MessageComponentBase message) {
        this.onIncomingBrokerMessage(message);
    }

    /**
     * must be implemented with message handling functionality
     * @param message
     */
    protected abstract void onIncomingBrokerMessage(MessageComponentBase message);

}
