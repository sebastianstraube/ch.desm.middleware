package sebastianstraube.connectx.core.module.server;

import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketServerGui;

import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ServerTyrusWebsocketStart {

    public static void start(){

        ServerTyrusWebsocket serverTyrusWebsocket = new ServerTyrusWebsocket(
                "0.0.0.0", ServerConfig.PORT_WEBSOCKET, "/websocket", EndpointWebsocketServerGui.class);


        serverTyrusWebsocket.startServer();
    }

}
