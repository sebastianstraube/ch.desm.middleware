package ch.desm.middleware.module.management;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static ch.desm.middleware.core.server.ServerConfig.SERVER_WEBSOCKET_URL;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ManagementEndpointClientConnector {

    private static final Logger LOGGER = Logger.getLogger(ManagementEndpointClientConnector.class);

    WebSocketContainer container=null;//
    Session session=null;

    public ManagementEndpointClientConnector(){
        LOGGER.log(Level.INFO, "ManagementEndpointClientService instantiated");
    }

    public void connect() {

        try {

            //URI uri = new URI(SERVER_WEBSOCKET_URL);
            URI uri = new URI("ws://localhost:8025/websocket/echo");

            LOGGER.log(Level.INFO, "ManagementEndpointClientService connects to server: " + uri);
            container = ContainerProvider.getWebSocketContainer();
            session = container.connectToServer(ManagementEndpointClient.class, uri);
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
