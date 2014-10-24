package ch.desm.middleware.app.core;

import ch.desm.middleware.app.core.server.JettyServer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class StartApp {

    private static Logger LOGGER = Logger.getLogger(StartApp.class);

    public static void main(String[] args){

        StartAppSingleton.getSingleton().start();
        JettyServer server = new JettyServer();
        server.start();

        while(!server.isStarted()){
            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        StartAppSingleton.getSingleton().startHangout(10000000);
    }
}
