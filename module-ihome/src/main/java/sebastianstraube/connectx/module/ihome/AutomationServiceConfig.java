package sebastianstraube.connectx.module.ihome;

import com.google.gson.Gson;
import sebastianstraube.connectx.module.ihome.AutomationService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: move all default values into external config file (json, ini or xml)
 */
public class AutomationServiceConfig {

    // list of modules that should be connected to the middleware
    private List<String> enabledModules;

    // linux: dev/ttyACM0
    private String ubw32ComPort;

    public static AutomationServiceConfig readConfigFile(String configPath){
        AutomationServiceConfig config = null;

        try {
            config = new Gson().fromJson(new FileReader(configPath), AutomationServiceConfig.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return config;
    }

    public String getUbw32ComPort() {
        return ubw32ComPort;
    }

    public List<String> getEnabledModules() {
        return enabledModules;
    }

    @Override
    public String toString() {
        return "MiddlewareConfig{" +
                "enabledModules=" + enabledModules +
                ", obermattUbw32ComPort='" + ubw32ComPort + '\'' +
                '}';
    }

}
