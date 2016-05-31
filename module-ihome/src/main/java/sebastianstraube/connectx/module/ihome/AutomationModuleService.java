package sebastianstraube.connectx.module.ihome;

import org.apache.log4j.Logger;

public class AutomationModuleService {

    private static Logger LOGGER = Logger.getLogger(AutomationModuleService.class);

    private final AutomationModuleConfig config;

    public AutomationModuleService(AutomationModuleConfig config) {
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
                startAutomation();
                break;
            default:
                throw new IllegalArgumentException("Unknown module " + name);
        }
    }

    public void startAutomation() {
        AutomationService service = new AutomationService("COM9");
        service.getEndpoint().init();
        service.getEndpoint().start();
    }

}
