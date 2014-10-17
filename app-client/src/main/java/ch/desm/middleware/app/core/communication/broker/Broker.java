package ch.desm.middleware.app.core.communication.broker;

import java.util.HashSet;
import java.util.Set;

public class Broker {
	
	private static Broker singleton = new Broker();
	
	/**
	 * 
	 */
    private Set<BrokerClient> clients = new HashSet<BrokerClient>();

    private Broker(){}
    
    /**
     * @param client
     */
    public void connect(BrokerClient client) {
    	clients.add(client);
    }

    /**
     * 
     * @param sendingClient
     * @param message
     */
    protected void publish(BrokerClient sendingClient, String message, String topic) {
        for(BrokerClient client : clients) {
            
        	if(client.hasTopicSigned(topic)) {
            	client.receive(message);
            }
        }
    }
    
    public static Broker getInstance(){
    	return Broker.singleton;
    }

}
