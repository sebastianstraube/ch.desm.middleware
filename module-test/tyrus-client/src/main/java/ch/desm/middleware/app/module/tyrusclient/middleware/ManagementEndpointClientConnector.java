package ch.desm.middleware.app.module.tyrusclient.middleware;

import ch.desm.middleware.app.module.tyrusclient.reference.TyrusClientAnnotated;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ManagementEndpointClientConnector {

    private static final Logger LOGGER = Logger.getLogger(ManagementEndpointClientCreator.class);

    WebSocketContainer container=null;//
    Session session=null;

    public ManagementEndpointClientConnector(){
        LOGGER.log(Level.INFO, "ManagementEndpointClientService instantiated");
    }

    public void connect() {

        try {
            URI uri = new URI("ws://localhost:8070/websocket/gui");
            container = ContainerProvider.getWebSocketContainer();

            //ManagementEndpointClientWebsocket
            session = container.connectToServer(ManagementEndpointClientWebsocket.class, uri);
            LOGGER.log(Level.INFO, "ManagementEndpointClientService connected to server: " + uri);
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
