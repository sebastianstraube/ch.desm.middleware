package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.component.LifeCycle;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

public class ManagementEndpoint extends EndpointCommon {

    private static final Logger LOGGER = Logger
            .getLogger(ManagementEndpoint.class);

    private Session webSocketSession;
    private WebSocketContainer container;
    private ManagementEndpointThread thread;
    private URI serverUri;

    public ManagementEndpoint(){
        thread = new ManagementEndpointThread(this);
        serverUri = URI.create("ws://Heisenberg:80/gui/management");
        this.start();
    }

    @Override
    public void start() {
        try {
            container = ContainerProvider.getWebSocketContainer();
            webSocketSession = container.connectToServer(ManagementEndpointWebsocketClient.class, serverUri);
        } catch (DeploymentException e) {
            LOGGER.log(Level.ERROR, e);
            stop();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
            stop();
        }
    }

    /**
     * close Websocket Session
     */
    @Override
    public void stop(){
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

    @Override
    public void init() {

    }

}
