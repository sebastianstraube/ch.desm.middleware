package ch.desm.middleware.module.management;

import ch.desm.middleware.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.core.communication.endpoint.websocket.EndpointWebsocketMessage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.*;
import java.io.IOException;

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
        client = new ManagementEndpointClientConnector();
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
