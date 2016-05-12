package ch.desm.middleware.module.automation.web;

import ch.desm.middleware.core.server.ServerJettyHttp;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class AutomationWebServer {

    public static void start(){

        ServerJettyHttp serverJettyHttp = new ServerJettyHttp(
                AutomationWebServerConfig.JETTY_DEPLOYMENT_PATH_DIR,
                AutomationWebServerConfig.JETTY_LISTEN_PORT,
                AutomationWebServerConfig.JETTY_LISTEN_IP);

        serverJettyHttp.startServer();
    }
}
