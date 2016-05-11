package ch.desm.middleware.module.management.web;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ManagementEndpointClientConnector {

    private static final Logger LOGGER = Logger.getLogger(ManagementEndpointClientConnector.class);

    private WebSocketContainer container=null;//
    private Session session=null;
    private URI uri;


    public ManagementEndpointClientConnector(URI uri){
        LOGGER.log(Level.INFO, "ManagementEndpointClientService instantiated");
        this.uri = uri;
    }

    public void connect() {
        try {
            LOGGER.log(Level.INFO, "ManagementEndpointClientService connects to server: " + uri);
            container = ContainerProvider.getWebSocketContainer();
            session = container.connectToServer(ManagementEndpointClient.class, uri);
            LOGGER.log(Level.INFO, "ManagementEndpointClientService connected to server: " + uri);
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
