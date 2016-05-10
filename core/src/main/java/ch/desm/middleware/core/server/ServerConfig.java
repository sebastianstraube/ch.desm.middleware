package ch.desm.middleware.core.server;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * TODO: move all default values into external config file (json, ini or xml)
 */
public final class ServerConfig {

    public static final String DEFAULT_HOST = "localhost";
    public static final Integer DEFAULT_PORT = 8070;

    // server config
    public static final String SERVER_CONTEXT_PATH = System.getProperty("user.dir");
    public static final String JETTY_DEPLOYMENT_MODULE_NAME = "";
    public static final String JETTY_DEPLOYMENT_WAR_NAME = "module-mgmt-0.1.war";
    public static final String JETTY_LISTEN_IP = getHostAddress();
    public static final int JETTY_LISTEN_PORT = 8071;
    public static final String TYRUS_WEBSOCKET_CONTEXT_WEBSOCKET = "/websocket";
    public static final String TYRUS_WEBSOCKET_ENDPOINT_GUI = "/gui";

    public static final String SERVER_WEBSOCKET_URL = String.format(
            "ws://%s:%d%s%s",
            ServerConfig.DEFAULT_HOST,
            ServerConfig.DEFAULT_PORT,
            ServerConfig.TYRUS_WEBSOCKET_CONTEXT_WEBSOCKET,
            ServerConfig.TYRUS_WEBSOCKET_ENDPOINT_GUI);

    //TODO LOGGER
    private static String getHostname(){
        String hostName = "";
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return hostName;
    }

    //TODO LOGGER
    private static String getHostAddress(){
        String hostAddress = "";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return hostAddress;
    }
}
