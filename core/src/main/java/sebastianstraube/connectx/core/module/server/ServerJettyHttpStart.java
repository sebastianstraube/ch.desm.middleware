package sebastianstraube.connectx.core.module.server;

import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketServerGui;

import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ServerJettyHttpStart {

    public static void start(){


        ServerJettyHttp serverJettyHttp = new ServerJettyHttp(
                ServerJettyHttpStart.getWarLocation(), ServerConfig.PORT_HTTP, "0.0.0.0");


        serverJettyHttp.startServer();

    }

    /**
     * Returns the location of the war (a trick, which is necessary for executable
     * wars please see: <a target="_blank" href=
     * "http://uguptablog.blogspot.de/2012/09/embedded-jetty-executable-war-with.html"
     * >Embedded Jetty with executable WAR</a>).
     *
     * @return The war location.
     */
    protected static String getWarLocation() {
        ProtectionDomain protectionDomain = ServerJettyHttp.class.getProtectionDomain();
        URL location = protectionDomain.getCodeSource().getLocation();
        return location.toExternalForm();
    }
}
