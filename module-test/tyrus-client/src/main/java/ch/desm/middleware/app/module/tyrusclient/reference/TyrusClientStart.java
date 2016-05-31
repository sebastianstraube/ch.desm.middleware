package ch.desm.middleware.app.module.tyrusclient.reference;

import ch.desm.middleware.app.module.tyrusclient.middleware.ManagementEndpointClientConnector;
import ch.desm.middleware.app.module.tyrusclient.middleware.ManagementEndpointClientWebsocket;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Sebastian on 10.05.2016.
 */
public class TyrusClientStart {

    public static void connect(){
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        try {
            //URI uri = new URI("ws://localhost:8025/websocket/echo");
            URI uri = new URI("ws://localhost:8025/websocket/echo");

            container.connectToServer(ManagementEndpointClientWebsocket.class, uri);
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please press a key to stop the client.");
            reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
