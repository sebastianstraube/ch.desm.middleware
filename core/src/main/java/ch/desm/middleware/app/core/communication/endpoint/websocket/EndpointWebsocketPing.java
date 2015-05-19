package ch.desm.middleware.app.core.communication.endpoint.websocket;

import ch.desm.middleware.app.core.common.DaemonThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 23.10.2014.
 */
public class EndpointWebsocketPing extends DaemonThreadBase{

    private static final Logger LOGGER = Logger
            .getLogger(EndpointWebsocketPing.class);

    private static int SLEEP_TIME = 5000;

    private EndpointWebsocketServer server;

    public EndpointWebsocketPing(EndpointWebsocketServer server){
        this.server = server;
        this.start();
    }


    public void run(){

        while(!isInterrupted()){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
            }
            server.sendPing();
        }
    }

}
