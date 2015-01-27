package ch.desm.middleware.app.core;

import ch.desm.middleware.app.core.server.JettyServer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class StartApp {

    private static Logger LOGGER = Logger.getLogger(StartApp.class);

    public static void main(String[] args){

        JettyServer server = new JettyServer("C:/svn.it-hotspot.de/share/Dropbox/Dropbox/DESM-Verein/Projekte/DESM-Middleware/code/ch.desm.middleware.app/webapp");
        server.start();

        while(!server.isStarted()){
            try {
                Thread.sleep(125);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        StartAppSingleton.getSingleton().start();
    }
}
