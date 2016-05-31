package sebastianstraube.connectx.module.ihome;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import sebastianstraube.connectx.core.module.CoreModuleServiceStart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AutomationServiceStart {

    private static Logger LOGGER = Logger.getLogger(AutomationServiceStart.class);

    public static void main(String[] args) {
        AutomationServiceStart.start();
    }

    public static void start(){
        LOGGER.log(Level.INFO, "initialise middleware...");
        LOGGER.log(Level.INFO, "starting directory: " + System.getProperty("user.dir"));
        CoreModuleServiceStart.start();

        final AutomationModuleConfig config = new AutomationModuleConfig();

        LOGGER.log(Level.INFO, "Starting middleware with configuration: " + config);
        final AutomationModuleService automation = new AutomationModuleService(config);

        LOGGER.log(Level.INFO, "starting middleware...");
        automation.start();

        LOGGER.log(Level.INFO, "Press any key to close middleware...");
        waitForAnyKey();

        LOGGER.log(Level.INFO, "shutting down middleware...");
        System.exit(0);
    }

    private static void waitForAnyKey() {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(isr);
        try {
            br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
