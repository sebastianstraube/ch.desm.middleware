package sebastianstraube.connectx.module.desm;

import com.google.gson.Gson;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import sebastianstraube.connectx.core.common.Utils;
import sebastianstraube.connectx.core.module.CoreModuleServiceStart;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DesmServiceStart {

    private static Logger LOGGER = Logger.getLogger(DesmServiceStart.class);

    public static void main(String[] args) {
        start(args[0], args[1]);
    }

    public static void start(String configPathServer, String configPathDesm){
        LOGGER.log(Level.INFO, "initialise middleware...");
        LOGGER.log(Level.INFO, "Starting middleware with server config: " + configPathServer);
        CoreModuleServiceStart.start(configPathServer);

        LOGGER.log(Level.INFO, "Starting middleware with desm config: " + configPathDesm);
        final DesmServiceConfig config = DesmServiceConfig.readConfigFile(configPathDesm);

        LOGGER.log(Level.INFO, "Starting middleware with configuration: " + config);
        final DesmService middleware = new DesmService(config);

        LOGGER.log(Level.INFO, "starting middleware...");
        middleware.start();

        LOGGER.log(Level.INFO, "Press any key to close middleware...");
        Utils.waitForAnyKey();

        LOGGER.log(Level.INFO, "shutting down middleware...");
        System.exit(0);

    }


}
