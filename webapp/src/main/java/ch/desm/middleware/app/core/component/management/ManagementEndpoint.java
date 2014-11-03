package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
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

public class ManagementEndpoint extends EndpointCommon {

    private static final Logger LOGGER = Logger
            .getLogger(ManagementEndpoint.class);

    private Session webSocketSession;
    private WebSocketContainer container;
    private ManagementEndpointThread thread;

    public ManagementEndpoint(){
        thread = new ManagementEndpointThread(this);
        this.startWebsocketClient("ws://Heisenberg:80/gui/management");
    }

    public void startWebsocketClient(String uri) {
        try {
            container = ContainerProvider.getWebSocketContainer();
            // Attempt Connect
            webSocketSession = container.connectToServer(ManagementEndpointWebsocketClient.class, URI.create(uri));
            // Send a message
            //webSocketSession.getBasicRemote().sendText("{\"payload\":\"websocket client started ...\", \"topic\":\"EndpointWebsocketClient\"}");

        } catch (DeploymentException e) {
            LOGGER.log(Level.ERROR, e);
            stopWebsocketClient();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
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
            LOGGER.log(Level.ERROR, e);
        } catch (IllegalStateException e){
            LOGGER.log(Level.WARN,e);
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
