package ch.desm.middleware.core.server;

import org.eclipse.jetty.server.Server;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * TODO: move all default values into external config file (json, ini or xml)
 */
public abstract class ServerConfigBase {

    public static final String DEFAULT_HOST = "192.168.1.7";

    //TODO LOGGER
    private static String getHostAddress(){
        String hostName = "";
        try {
            hostName = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return hostName;
    }

}
