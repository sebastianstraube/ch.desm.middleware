package ch.desm.middleware.app.core;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class StartApp {

    private static Logger LOGGER = Logger.getLogger(StartApp.class);

    public static void main(String[] args) {

        LOGGER.log(Level.TRACE, "StartApp");
        StartAppThread.getSingleton().run();
    }
}
