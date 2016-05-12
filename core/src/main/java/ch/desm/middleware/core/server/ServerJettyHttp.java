package ch.desm.middleware.core.server;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.net.InetSocketAddress;

/**
 * Created by Sebastian on 21.10.2014.
 */
public class ServerJettyHttp extends ServerBase {

    private final InetSocketAddress inetSocketAddress;
    private final int listenPort;
    private String contextPath;
    private final String tempDir;
    private final String descriptorDir;

    public ServerJettyHttp(String contextPath, int listenPort, String listenIp){
        this.listenPort = listenPort;
        this.contextPath = contextPath;
        this.tempDir = contextPath + File.separator+"tmp";
        this.descriptorDir = contextPath +File.separator+"WEB-INF"+File.separator+"web.xml";
        this.inetSocketAddress = new InetSocketAddress(listenIp, listenPort);

        LOGGER.log(Level.INFO, " Jetty Configuration");
        LOGGER.log(Level.INFO, "contextPath: " + contextPath);
        LOGGER.log(Level.INFO, "tempDir: " + tempDir);
        LOGGER.log(Level.INFO, "descriptorDir: " + descriptorDir);
        LOGGER.log(Level.INFO, "inetSocketAddress: " + inetSocketAddress);
    }

    private static Logger LOGGER = Logger.getLogger(ServerJettyHttp.class);
    private Server server;

    public void run(){

        LOGGER.log(Level.TRACE, "Jetty Webserver is starting ...");

        this.server = new Server(listenPort);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setDescriptor(descriptorDir);//location.toExternalForm() + "WEB-INF/web.xml");
        context.setServer(server);
        //TODO refactor for dynamic path
        context.setWar(contextPath);//C:\Users\Sebastian\Dropbox\DESM-Verein\Projekte\DESM-Middleware\code\ch.desm.middleware\module-mgmt-web\target\module-mgmt-web-0.1

        // (Optional) Set the directory the war will extract to.
        // If not set, java.io.tmpdir will be used, which can cause problems
        // if the temp directory gets cleaned periodically.
        // Your build scripts should remove this directory between deployments
        context.setTempDirectory(new File(tempDir));
        server.setHandler(context);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "Jetty Webserver start failed:" + e);
        }
    }

    @Override
    public ServerBase startServer() {
        this.start();
        waitUntilServerStarted();
        return this;
    }

    @Override
    public boolean isStarted(){
        if(server != null){
            return server.isStarted();
        }
        return false;
    }
}
