package ch.desm.middleware.app.core.communication.broker;

import java.util.HashSet;
import java.util.Set;

public class Broker {
	
	private static Broker singleton = new Broker();
	private Object lockClients = new Object();
	/**
	 * 
	 */
    private Set<BrokerClient> clients = new HashSet<BrokerClient>();

    private Broker(){}
    
    /**
     * @param client
     */
    public void connect(BrokerClient client) {
        synchronized (lockClients){
            clients.add(client);
        }
    }

    /**
     *
     * @param message
     */
    protected void publish(String message, String topic) {
        synchronized (lockClients){
            for(BrokerClient client : clients) {

                if(client.isSubscribedToTopic(topic)) {
                    client.receive(message);
                }
            }
        }
    }
    
    public static Broker getInstance(){
    	return Broker.singleton;
    }

}
