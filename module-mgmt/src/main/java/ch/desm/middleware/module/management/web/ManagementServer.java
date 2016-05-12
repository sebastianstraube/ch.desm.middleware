package ch.desm.middleware.module.management.web;

import ch.desm.middleware.core.communication.endpoint.websocket.EndpointWebsocketServerGui;
import ch.desm.middleware.core.server.ServerTyrusWebsocket;

/**
 * Created by Sebastian on 12.05.2016.
 */
public class ManagementServer {

    public static void start(){

        ServerTyrusWebsocket serverTyrusWebsocket = new ServerTyrusWebsocket(
                ManagementServerConfig.DEFAULT_HOST,
                ManagementEndpointClientConfigurator.TYRUS_WEBSOCKET_PORT,
                ManagementEndpointClientConfigurator.TYRUS_WEBSOCKET_CONTEXT_WEBSOCKET,
                EndpointWebsocketServerGui.class);

        serverTyrusWebsocket.startServer();


    }
}
