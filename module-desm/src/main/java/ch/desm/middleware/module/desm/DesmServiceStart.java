package ch.desm.middleware.module.desm;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ch.desm.middleware.common.Utils.waitForAnyKey;

public class DesmServiceStart {

    private static Logger LOGGER = Logger.getLogger(DesmServiceStart.class);

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "initialise middleware...");
        LOGGER.log(Level.INFO, "starting directory: " + System.getProperty("user.dir"));

        final DesmServiceConfig config = new DesmServiceConfig();
        //String host, String port, String websocketContextPath, String serverEndpointContextPath, String jettyPath
        if (args.length > 0 && args.length <= 4) {
            config.setManagementHost(args[0]);
            config.setManagementPort(Integer.parseInt(args[1]));
            config.setTyrusWebsocketContextPath(args[2]);
            config.setServerEndpointContextPath(args[3]);
            config.setServerJettyPath(args[4]);
        }

        LOGGER.log(Level.INFO, "Starting middleware with configuration: " + config);
        final DesmService middleware = new DesmService(config);

        LOGGER.log(Level.INFO, "starting middleware...");
        middleware.start();

        LOGGER.log(Level.INFO, "Press any key to close middleware...");
        waitForAnyKey();

        LOGGER.log(Level.INFO, "shutting down middleware...");
        System.exit(0);
    }


}
