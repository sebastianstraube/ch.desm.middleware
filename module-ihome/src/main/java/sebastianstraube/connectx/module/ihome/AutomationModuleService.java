package sebastianstraube.connectx.module.ihome;

import org.apache.log4j.Logger;

public class AutomationModuleService {

    private static Logger LOGGER = Logger.getLogger(AutomationModuleService.class);

    private final AutomationServiceConfig config;

    public AutomationModuleService(AutomationServiceConfig config) {
        this.config = config;
    }

    public void start() {
        for (String module : config.getEnabledModules()) {
            startModule(module);
        }
    }

    private void startModule(String name) {
        switch (name) {
            case "automation":
                startAutomation(config.getUbw32ComPort());
                break;
            default:
                throw new IllegalArgumentException("Unknown module " + name);
        }
    }

    public void startAutomation(String comPort) {
        AutomationService service = new AutomationService(comPort);
        service.getEndpoint().init();
        service.getEndpoint().start();
    }

}
