package sebastianstraube.connectx.module.ihome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: move all default values into external config file (json, ini or xml)
 */
public class AutomationModuleConfig {

    public static final List<String> DEFAULT_MODULES = Arrays.asList("automation");

    // list of modules that should be connected to the middleware
    private List<String> enabledModules = new ArrayList<>(DEFAULT_MODULES);

    // Obermatt
    private String ubw32ComPort = "COM3"; // linux: dev/ttyACM0


    public void enableModule(String module) {
        enabledModules.add(module);
    }

    public void setEnabledModules(String[] modules) {
        enabledModules = Arrays.asList(modules);
    }

    public List<String> getEnabledModules() {
        return enabledModules;
    }

    public String getUbw32ComPort() {
        return ubw32ComPort;
    }

    public void setUbw32ComPort(String obermattUbw32ComPort) {
        this.ubw32ComPort = obermattUbw32ComPort;
    }

    @Override
    public String toString() {
        return "MiddlewareConfig{" +
                "enabledModules=" + enabledModules +
                ", ubw32ComPort='" + ubw32ComPort + '\'' +
                '}';
    }
}
