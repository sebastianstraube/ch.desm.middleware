package ch.desm.middleware.app.core.component.management;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketServer;

@Stateless
public class ManagementEndpoint {
	
	private static Queue<String> messages = new ConcurrentLinkedQueue<>();
	 
	public void onIncomingEndpointMessage(String message){
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
	
	@AroundInvoke
    public Object manageTransaction(InvocationContext ctx) throws Exception {
        EndpointWebsocketServer.addListener(this);
        return ctx.proceed();
    }
}
