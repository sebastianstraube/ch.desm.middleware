package sebastianstraube.connectx.core.module.server;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

/**
 * Created by Sebastian on 12.05.2016.
 */
public class ServerConfig {



    private String DEFAULT_HOST;
    private Integer PORT_HTTP;
    private Integer PORT_WEBSOCKET;
    private String TYRUS_WEBSOCKET_CONTEXT_WEBSOCKET;
    private String TYRUS_WEBSOCKET_CONTEXT_GUI;

    public String getDEFAULT_HOST() {
        return DEFAULT_HOST;
    }
    public Integer getPORT_HTTP() {
        return PORT_HTTP;
    }

    public Integer getPORT_WEBSOCKET() {
        return PORT_WEBSOCKET;
    }

    public String getTyrusServerWebsocketUrl(){

        return String.format(
                "ws://%s:%d%s%s",
                DEFAULT_HOST,
                PORT_WEBSOCKET,
                TYRUS_WEBSOCKET_CONTEXT_WEBSOCKET,
                TYRUS_WEBSOCKET_CONTEXT_GUI);
    }

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

    public static ServerConfig readConfigFile(String configPath){

        ServerConfig config = null;

        try {
            config = new Gson().fromJson(new FileReader(configPath), ServerConfig.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return config;
    }


}
