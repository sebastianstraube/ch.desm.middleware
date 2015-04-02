package ch.desm.middleware.app.core;

import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.server.JettyServer;
import org.apache.log4j.Logger;

public class StartAppMain extends DaemonThreadBase{

    private static Logger LOGGER = Logger.getLogger(StartAppMain.class);

    public static boolean isHangout = true;

    public static void main(String[] args){
        StartAppSingleton.getSingleton().start();

    }


}
