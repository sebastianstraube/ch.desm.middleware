package sebastianstraube.connectx.core.module.server;

import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketServerGui;

import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ServerTyrusWebsocketStart {

    public static void start(ServerConfig config){

        ServerTyrusWebsocket serverTyrusWebsocket = new ServerTyrusWebsocket(
                config.getDEFAULT_HOST(), config.getPORT_WEBSOCKET(), "/websocket", EndpointWebsocketServerGui.class);


        serverTyrusWebsocket.startServer();
    }

}
