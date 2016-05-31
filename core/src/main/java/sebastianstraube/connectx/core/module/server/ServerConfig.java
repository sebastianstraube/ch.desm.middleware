package sebastianstraube.connectx.core.module.server;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Sebastian on 12.05.2016.
 */
public class ServerConfig {

    public static final String DEFAULT_HOST = "192.168.1.4";
    public static final Integer PORT_HTTP = 8080;
    public static final Integer PORT_WEBSOCKET = 8070;

    //TODO LOGGER
    public static String getHostAddress(){
        String hostAddress = "";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return hostAddress;
    }

    //TODO LOGGER
    public static String getHostName(){
        String hostAddress = "";
        try {
            hostAddress = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return hostAddress;
    }


}
