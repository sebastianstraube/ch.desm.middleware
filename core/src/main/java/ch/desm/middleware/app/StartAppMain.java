package ch.desm.middleware.app;

import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StartAppMain {

    private static Logger LOGGER = Logger.getLogger(StartAppMain.class);

    public static void main(String[] args){
        LOGGER.log(Level.INFO, "initialise middleware...");
        LOGGER.log(Level.INFO, "starting directory: "+ System.getProperty("user.dir"));

        RunAppSingleton main = RunAppSingleton.getSingleton();

        //String host, String port, String websocketContextPath, String serverEndpointContextPath, String jettyPath
        if(args.length >0 && args.length <= 4){
            main.setConfiguration(args[0], args[1], args[2], args[3], args[4]);
        } else {
            if(SystemUtils.IS_OS_UNIX){
                main.setConfiguration("192.168.1.19", "8080", "/websocket", "/gui", System.getProperty("user.dir"));//"/opt/desm/middleware/core");
            }
            else if(SystemUtils.IS_OS_WINDOWS){
                main.setConfiguration("192.168.1.19", "8080", "/websocket", "/gui", System.getProperty("user.dir"));//"C:/Users/Sebastian/Dropbox/DESM-Verein/Projekte/DESM-Middleware/code/ch.desm.middleware.app/core");
            } else{
                LOGGER.log(Level.ERROR, "unsupported OS");
            }
        }

        if(main.isConfigured()){
            LOGGER.log(Level.INFO, "starting middleware...");
            main.start();
        }else{
            LOGGER.log(Level.ERROR, "configuration error: " + Arrays.asList(args));
        }

        LOGGER.log(Level.INFO, "Press any key to close middleware...");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LOGGER.log(Level.INFO, "shutting down middleware...");
        System.exit(0);
    }
}
