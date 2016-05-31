package sebastianstraube.connectx.module.desm;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: move all default values into external config file (json, ini or xml)
 */
public class DesmServiceConfig {

    public static final List<String> DEFAULT_MODULES = Arrays.asList("stellwerk_petrinet");

    // list of modules that should be connected to the middleware
    private List<String> enabledModules = new ArrayList<>(DEFAULT_MODULES);

    // Obermatt
    // linux: dev/ttyACM0
    private String obermattUbw32ComPort;

    // Cabine
    private String cabineUbw32ComPort;

    // Zusi
    private String zusiHostIp;
    private Integer zusiPort;

    private Integer DEFAULT_POLLING_FREQUENCY;

    public String getObermattUbw32ComPort() {
        return obermattUbw32ComPort;
    }

    public void setObermattUbw32ComPort(String obermattUbw32ComPort) {
        this.obermattUbw32ComPort = obermattUbw32ComPort;
    }

    public String getCabineUbw32ComPort() {
        return cabineUbw32ComPort;
    }

    public void setCabineUbw32ComPort(String cabineUbw32ComPort) {
        this.cabineUbw32ComPort = cabineUbw32ComPort;
    }

    public String getZusiHostIp() {
        return zusiHostIp;
    }

    public void setZusiHostIp(String zusiHostIp) {
        this.zusiHostIp = zusiHostIp;
    }

    public Integer getZusiPort() {
        return zusiPort;
    }

    public void setZusiPort(Integer zusiPort) {
        this.zusiPort = zusiPort;
    }

    public Integer getDEFAULT_POLLING_FREQUENCY() {
        return DEFAULT_POLLING_FREQUENCY;
    }

    public void setDEFAULT_POLLING_FREQUENCY(Integer DEFAULT_POLLING_FREQUENCY) {
        this.DEFAULT_POLLING_FREQUENCY = DEFAULT_POLLING_FREQUENCY;
    }

    public List<String> getEnabledModules() {
        return enabledModules;
    }

    public void setEnabledModules(List<String> enabledModules) {
        this.enabledModules = enabledModules;
    }

    public static DesmServiceConfig readConfigFile(String configPath){
        DesmServiceConfig config = null;

        try {
            config = new Gson().fromJson(new FileReader(configPath), DesmServiceConfig.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return config;
    }

    @Override
    public String toString() {
        return "MiddlewareConfig{" +
                "enabledModules=" + enabledModules +
                ", obermattUbw32ComPort='" + obermattUbw32ComPort + '\'' +
                ", cabineUbw32ComPort='" + cabineUbw32ComPort + '\'' +
                ", zusiPort=" + zusiPort +
                '}';
    }

}
