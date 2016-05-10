package ch.desm.middleware.app.module.tyrusclient.middleware;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

class ManagementEndpointClientCreator {

    private static final Logger LOGGER = Logger.getLogger(ManagementEndpointClientCreator.class);

    ManagementEndpointClientConnector websocketClient;

    public void init() {
        websocketClient = new ManagementEndpointClientConnector();
    }

    public void start(){
        if(websocketClient == null){
            LOGGER.log(Level.TRACE, "Endpoint is not initialized.");
            return;
        }
        websocketClient.connect();
    }



}
