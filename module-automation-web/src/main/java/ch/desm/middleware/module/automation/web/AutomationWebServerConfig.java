package ch.desm.middleware.module.automation.web;

import ch.desm.middleware.core.server.ServerConfigBase;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Sebastian on 12.05.2016.
 */
public class AutomationWebServerConfig {

    // server config
    public static final String JETTY_DEPLOYMENT_PATH_DIR = "C:\\Users\\Sebastian\\Dropbox\\DESM-Verein\\Projekte\\DESM-Middleware\\code\\ch.desm.middleware\\module-automation-web" + File.separator +"target" + File.separator + AutomationWebServerConfig.JETTY_DEPLOYMENT_MODULE_NAME ;
    public static final String JETTY_DEPLOYMENT_MODULE_NAME = "module-automation-web-0.1";
    public static final int JETTY_LISTEN_PORT = 80;
    public static final String JETTY_LISTEN_IP = ServerConfigBase.DEFAULT_HOST;


}
