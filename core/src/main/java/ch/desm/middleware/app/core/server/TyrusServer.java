package ch.desm.middleware.app.core.server;

import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketServer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.glassfish.tyrus.server.Server;

/**
 * Created by Sebastian on 21.10.2014.
 */
public class TyrusServer extends DaemonThreadBase {

    private static Logger LOGGER = Logger.getLogger(TyrusServer.class);
    private boolean isRunning = false;
    private String ip;
    private int port;
    private String path;

    public TyrusServer(String ip, int port, String path){
        this.ip = ip;
        this.port = port;
        this.path = path;
    }

    public void run(){
        LOGGER.log(Level.TRACE, "Jetty Websocket Server is starting ...");
        Server server = new Server(ip, port, path, null, EndpointWebsocketServer.class);

        try {
            server.start();
            doHangout(2000);
            isRunning = true;
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "Jetty Websocket Server start failed:" + e.getMessage());
            isRunning = false;
        }
    }

    public boolean isRunning(){
        return isRunning;
    }
}
