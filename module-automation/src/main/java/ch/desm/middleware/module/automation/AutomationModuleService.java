package ch.desm.middleware.module.automation;

import ch.desm.middleware.module.automation.web.AutomationWebServiceStart;
import ch.desm.middleware.module.management.web.ManagementServiceStart;
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
            case "automation-web":
                startAutomationWeb();
                break;
            case "mgmt":
                startManagement();
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

    public void startAutomationWeb() {
        AutomationWebServiceStart.start();
    }

    public void startManagement(){
        ManagementServiceStart.start();
    }

}
