package ch.desm.middleware.app.core.server;

import ch.desm.middleware.app.core.StartAppMain;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketServer;
import ch.desm.middleware.app.core.common.DaemonThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.websocket.jsr356.server.ServerContainer;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Created by Sebastian on 21.10.2014.
 */
public class JettyServer extends DaemonThreadBase {

    private InetSocketAddress inetSocketAddress;
    private String projectDir;
    public JettyServer(String projectDir){
        this.inetSocketAddress = new InetSocketAddress("0.0.0.0", 80);
        this.projectDir = projectDir;
    }

    private static Logger LOGGER = Logger.getLogger(JettyServer.class);
    private Server server;

    public void run(){
        LOGGER.log(Level.TRACE, "Jetty Webserver is starting ...");
        //int port = Integer.parseInt(System.getProperty("port", port));
        this.server = new Server(inetSocketAddress);

        ProtectionDomain domain = StartAppMain.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setDescriptor(projectDir + "/target/webapp-0.1/WEB-INF/web.xml");//location.toExternalForm() + "WEB-INF/web.xml");
        context.setServer(server);
        context.setWar(projectDir + "/target/webapp-0.1");//);

        // (Optional) Set the directory the war will extract to.
        // If not set, java.io.tmpdir will be used, which can cause problems
        // if the temp directory gets cleaned periodically.
        // Your build scripts should remove this directory between deployments
        context.setTempDirectory(new File(projectDir + "/target/webapp-0.1/tmp"));

        server.setHandler(context);
        try {
            // Initialize javax.websocket layer
            ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);

            // Add WebSocket endpoint to javax.websocket layer
            wscontainer.addEndpoint(EndpointWebsocketServer.class);
//            wscontainer.addEndpoint(EndpointWebsocketClient.class);

            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isStarted(){
        if(server != null){
            return server.isStarted();
        }
        return false;
    }
}
