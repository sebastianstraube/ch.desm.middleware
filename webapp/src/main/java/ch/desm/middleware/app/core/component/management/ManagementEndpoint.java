package ch.desm.middleware.app.core.component.management;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ManagementEndpoint {

    private static final Logger LOGGER = Logger
            .getLogger(ManagementEndpoint.class);

	private static Queue<String> messages = new ConcurrentLinkedQueue<>();

    public ManagementEndpoint(){
        this.startWebsocketClient("ws://localhost:8080/gui/management");
    }

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

    private Session webSocketSession;
    private WebSocketContainer container = null;

    public void startWebsocketClient(String uri) {
        try {
            container = ContainerProvider.getWebSocketContainer();
            // Attempt Connect
            webSocketSession = container.connectToServer(ManagementEndpointWebsocketClient.class, URI.create(uri));
            // Send a message
            webSocketSession.getBasicRemote().sendText("{\"payload\":\"websocket client started ...\", \"topic\":\"EndpointWebsocketClient\"}");

        } catch (DeploymentException e) {
            LOGGER.error(e);
            stopWebsocketClient();
        } catch (IOException e) {
            LOGGER.error(e);
            stopWebsocketClient();
        }
    }

    /**
     * close Websocket Session
     */
    public void stopWebsocketClient(){
        try {
            if(webSocketSession != null){
                webSocketSession.close();
            }else{
                throw new IllegalStateException("Websocket Client is null.");
            }
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (IllegalStateException e){
            LOGGER.warn(e);
        } finally {
            // Force lifecycle stop when done with container.
            // This is to free up threads and resources that the
            // JSR-356 container allocates. But unfortunately
            // the JSR-356 spec does not handle lifecycles (yet)
            if (container instanceof LifeCycle) {
                try {
                    ((LifeCycle) container).stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
