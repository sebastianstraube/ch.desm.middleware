package sebastianstraube.connectx.module.desm;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import sebastianstraube.connectx.core.module.CoreModuleServiceStart;
import sebastianstraube.connectx.core.common.Utils;

public class DesmServiceStart {

    private static Logger LOGGER = Logger.getLogger(DesmServiceStart.class);

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "initialise middleware...");
        CoreModuleServiceStart.start();

        final DesmServiceConfig config = new DesmServiceConfig();

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
