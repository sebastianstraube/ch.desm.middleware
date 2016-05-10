package ch.desm.middleware.core.server;

import ch.desm.middleware.core.communication.endpoint.websocket.EndpointWebsocketServerGui;
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
    private final String targetDir;
    private final String tempDir;
    private final String warDir;
    private final String descriptorDir;
    private final String contextPath;

    public ServerJettyHttp(String projectDir, String warDeploymentName, String warModuleName, int listenPort, String listenIp){
        this.inetSocketAddress = new InetSocketAddress(listenIp, listenPort);

        String moduleName = "";
        if(warModuleName != null && !warModuleName.isEmpty()) moduleName = File.separator+warModuleName;
        targetDir = projectDir + moduleName+ File.separator+"target"+File.separator+warDeploymentName;
        tempDir = projectDir+ File.separator+"tmp";
        warDir = targetDir;
        descriptorDir = targetDir+File.separator+"WEB-INF"+File.separator+"web.xml";
        contextPath = File.separator;
    }

    private static Logger LOGGER = Logger.getLogger(ServerJettyHttp.class);
    private Server server;

    public void run(){

        LOGGER.log(Level.TRACE, "Jetty Webserver is starting ...");

        this.server = new Server(inetSocketAddress);

        WebAppContext context = new WebAppContext();
        context.setContextPath(contextPath);
        context.setDescriptor(descriptorDir);//location.toExternalForm() + "WEB-INF/web.xml");
        context.setServer(server);
        context.setWar(warDir);//);

        // (Optional) Set the directory the war will extract to.
        // If not set, java.io.tmpdir will be used, which can cause problems
        // if the temp directory gets cleaned periodically.
        // Your build scripts should remove this directory between deployments
        context.setTempDirectory(new File(tempDir));
        server.setHandler(context);
        try {
            // Initialize javax.websocket layer
            //ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);
            // Add WebSocket endpoint to javax.websocket layer
            //wscontainer.addEndpoint(EndpointWebsocketServer.class);
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
