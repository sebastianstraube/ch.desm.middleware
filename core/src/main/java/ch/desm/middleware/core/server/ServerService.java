package ch.desm.middleware.core.server;

import ch.desm.middleware.core.communication.endpoint.websocket.EndpointWebsocketServerGui;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ServerService {

    ServerTyrusWebsocket serverTyrusWebsocket;
    ServerJettyHttp serverJettyHttp;

    public ServerService(){

        serverJettyHttp = new ServerJettyHttp(
                ServerConfig.SERVER_CONTEXT_PATH,
                ServerConfig.JETTY_DEPLOYMENT_WAR_NAME,
                ServerConfig.JETTY_DEPLOYMENT_MODULE_NAME,
                ServerConfig.JETTY_LISTEN_PORT,
                ServerConfig.JETTY_LISTEN_IP);

        serverTyrusWebsocket = new ServerTyrusWebsocket(
                ServerConfig.DEFAULT_HOST,
                ServerConfig.DEFAULT_PORT,
                ServerConfig.TYRUS_WEBSOCKET_CONTEXT_WEBSOCKET,
                EndpointWebsocketServerGui.class);
    }

    public void startTyrus(){
        serverTyrusWebsocket.startServer();
    }

    public void startJetty(){
        serverJettyHttp.startServer();
    }


}
