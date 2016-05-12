package ch.desm.middleware.module.management.web;

import ch.desm.middleware.core.server.ServerConfigBase;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static ch.desm.middleware.core.server.ServerConfigBase.DEFAULT_HOST;

/**
 * Created by Sebastian on 12.05.2016.
 */
public class WebServerConfig extends ServerConfigBase {

    public static final String JETTY_DEPLOYMENT_PATH_DIR = System.getProperty("user.dir") + File.separator +"target" + File.separator + WebServerConfig.JETTY_DEPLOYMENT_MODULE_NAME ;
    public static final String JETTY_DEPLOYMENT_MODULE_NAME = "module-automation-web-0.1";
    public static final int JETTY_LISTEN_PORT = 8071;
    public static final String JETTY_DEPLOYMENT_NAME_WAR = WebServerConfig.JETTY_DEPLOYMENT_MODULE_NAME + ".war";
    public static final String JETTY_LISTEN_IP = WebServerConfig.getHostName();


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
