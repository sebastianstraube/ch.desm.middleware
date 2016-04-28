package ch.desm.middleware.app;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartAppMain {

    private static Logger LOGGER = Logger.getLogger(StartAppMain.class);

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "initialise middleware...");
        LOGGER.log(Level.INFO, "starting directory: " + System.getProperty("user.dir"));

        final MiddlewareConfig config = new MiddlewareConfig();
        //String host, String port, String websocketContextPath, String serverEndpointContextPath, String jettyPath
        if (args.length > 0 && args.length <= 4) {
            config.setManagementHost(args[0]);
            config.setManagementPort(Integer.parseInt(args[1]));
            config.setTyrusWebsocketContextPath(args[2]);
            config.setServerEndpointContextPath(args[3]);
            config.setServerJettyPath(args[4]);
        }

        LOGGER.log(Level.INFO, "Starting middleware with configuration: " + config);
        final Middleware middleware = new Middleware(config);

        LOGGER.log(Level.INFO, "starting middleware...");
        middleware.start();

        LOGGER.log(Level.INFO, "Press any key to close middleware...");
        waitForAnyKey();

        LOGGER.log(Level.INFO, "shutting down middleware...");
        System.exit(0);
    }

    private static void waitForAnyKey() {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(isr);
        try {
            br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
