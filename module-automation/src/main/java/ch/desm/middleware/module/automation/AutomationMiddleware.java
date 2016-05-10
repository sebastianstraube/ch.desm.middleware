package ch.desm.middleware.module.automation;

import ch.desm.middleware.core.communication.broker.Broker;
import org.apache.log4j.Logger;

public class AutomationMiddleware {

    private static Logger LOGGER = Logger.getLogger(AutomationMiddleware.class);

    private final Broker broker = new Broker();
    private final AutomationMiddlewareConfig config;

    public AutomationMiddleware(AutomationMiddlewareConfig config) {
        this.config = config;
    }

    public void start() {
        for (String module : config.getEnabledModules()) {
            startModule(module);
        }
    }

    private void startModule(String name) {
        switch (name) {
            case "machine":
                startMachine();
                break;
            default:
                throw new IllegalArgumentException("Unknown module " + name);
        }
    }



    public void startMachine() {

    }

}
