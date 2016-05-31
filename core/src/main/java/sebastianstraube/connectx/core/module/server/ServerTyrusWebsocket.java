package sebastianstraube.connectx.core.module.server;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.glassfish.tyrus.server.Server;

/**
 * Created by Sebastian on 21.10.2014.
 */
public class ServerTyrusWebsocket extends ServerBase {

    private static Logger LOGGER = Logger.getLogger(ServerTyrusWebsocket.class);

    private boolean isStarted = false;
    private String ip;
    private int port;
    private String contextPath;
    private Server server;
    private Class serverEndpoint;

    public ServerTyrusWebsocket(String ip, int port, String contextPath, Class serverEndpoint){
        this.ip = ip;
        this.port = port;
        this.contextPath = contextPath;
        this.serverEndpoint = serverEndpoint;
    }

    public void run(){
        LOGGER.log(Level.INFO, "Tyrus Websocket Server is starting ...");
        server = new Server(ip, port, contextPath, null, serverEndpoint);

        try {
            server.start();
            sleep(2000);
            isStarted = true;
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "Tyrus Websocket Server start failed:" + e);
            isStarted = false;
        }
    }

    @Override
    public ServerBase startServer() {
        this.start();
        this.waitUntilServerStarted();

        return this;
    }

    @Override
    public boolean isStarted() {
        return isStarted;
    }
}
