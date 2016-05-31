package sebastianstraube.connectx.core.module.server;

import sebastianstraube.connectx.core.module.CoreModuleServiceStart;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ServerJettyHttpStart {

    public static void start(ServerConfig config){

        ServerJettyHttp serverJettyHttp = new ServerJettyHttp(
                ServerJettyHttpStart.getArchiveLocation(), config.getPORT_HTTP());

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
    protected static String getArchiveLocation() {
        URL location = CoreModuleServiceStart.class.getProtectionDomain().getCodeSource().getLocation();
        String path = "";
        try {
            path = URLDecoder.decode(location.getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return path;
    }

}
