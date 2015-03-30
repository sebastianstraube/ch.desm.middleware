package ch.desm.middleware.app.core;

import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.server.JettyServer;
import org.apache.log4j.Logger;

public class StartAppMain {

    private static Logger LOGGER = Logger.getLogger(StartAppMain.class);

    public static void main(String[] args){
        StartAppSingleton.getSingleton().start();
        while(StartAppSingleton.getSingleton().isAlive()){
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
