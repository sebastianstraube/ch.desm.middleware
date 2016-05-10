package ch.desm.middleware.module.management;

import ch.desm.middleware.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.core.communication.endpoint.websocket.EndpointWebsocketMessage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static ch.desm.middleware.core.server.ServerConfig.SERVER_WEBSOCKET_URL;

class ManagementEndpointClientCreator extends EndpointCommon<EndpointWebsocketMessage> {

    private static final Logger LOGGER = Logger.getLogger(ManagementEndpointClientCreator.class);

    private ManagementEndpointThread thread;
    private ManagementServiceBase service;
    private ManagementEndpointClientConnector client;

    public ManagementEndpointClientCreator(ManagementServiceBase service){
        super();
        this.registerEndpointListener();
        this.thread = new ManagementEndpointThread(this);
        this.service = service;
    }

    @Override
    public void onIncomingEndpointMessage(EndpointWebsocketMessage message) {
        LOGGER.log(Level.TRACE, "receive endpoint message: " + message);

        service.getProcessor().processEndpointMessage(service.getBrokerClient(), message.getPayload(), message.getTopic());
    }

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void init() {
        try {
            client = new ManagementEndpointClientConnector(new URI(SERVER_WEBSOCKET_URL));
        } catch (URISyntaxException e) {
            LOGGER.log(Level.ERROR, "Endpoint init failed: " + SERVER_WEBSOCKET_URL  + e);
        }
    }

    @Override
    public void start(){
        if(client == null){
            LOGGER.log(Level.TRACE, "Endpoint is not initialized.");
            return;
        }
        client.connect();
    }

    /**
     *
     */
    @Override
    public void reset(){
        //TODO reset implementation
    }

    /**
     * close Websocket Session
     */
    @Override
    public void stop(){

    }
}
