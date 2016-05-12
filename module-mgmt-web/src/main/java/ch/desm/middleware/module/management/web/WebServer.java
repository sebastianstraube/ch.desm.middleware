package ch.desm.middleware.module.management.web;

import ch.desm.middleware.core.server.ServerJettyHttp;

import static ch.desm.middleware.module.management.web.WebServerConfig.*;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class WebServer {

    public static void start(){

        ServerJettyHttp serverJettyHttp = new ServerJettyHttp(
                WebServerConfig.JETTY_DEPLOYMENT_PATH_DIR,
                WebServerConfig.JETTY_DEPLOYMENT_NAME_WAR,
                WebServerConfig.JETTY_LISTEN_PORT,
                WebServerConfig.JETTY_LISTEN_IP);

        serverJettyHttp.startServer();

    }
}
