package ch.desm.middleware.app.core.component.management;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ManagementEndpoint {

    private static final Logger LOGGER = Logger
            .getLogger(ManagementEndpoint.class);

	private static Queue<String> messages = new ConcurrentLinkedQueue<>();


	public static void onIncomingEndpointMessage(String message){
		messages.add(message);
	}
	
	public boolean hasMessages(){
		return !messages.isEmpty();
	}
	
	public Queue<String> getMessages(){
		final Queue<String> tmp = new LinkedList<String>(messages);
		messages.clear();
		return tmp;
	}
}
