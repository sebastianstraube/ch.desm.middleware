package ch.desm.middleware.app;

import ch.desm.middleware.app.core.RunAppSingleton;
import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class StartAppMain {

    private static Logger LOGGER = Logger.getLogger(StartAppMain.class);

    public static void main(String[] args){
        RunAppSingleton main = RunAppSingleton.getSingleton();

        if(args.length >0 && args.length <= 4) main.setConfiguration(args[0], args[1], args[2], args[3], args[4]);
        else if(SystemUtils.IS_OS_UNIX) main.setConfiguration("localhost", "8080", "/websocket", "/gui", "/opt/desm/middleware/webapp");
        else main.setConfiguration("localhost", "8080", "/websocket", "/gui", "C:/svn.it-hotspot.de/share/Dropbox/Dropbox/DESM-Verein/Projekte/DESM-Middleware/code/ch.desm.middleware.app/core");

        if(main.isConfigured()){
            main.start();
        }else{
            LOGGER.log(Level.ERROR, "configuration error: " + Arrays.asList(args));
        }

        main.doHangout();
    }
}
