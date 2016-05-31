package sebastianstraube.connectx.module.desm;

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
    private String obermattUbw32ComPort = "COM3"; // linux: dev/ttyACM0

    // Cabine
    private String cabineUbw32ComPort = "COM15";

    // Zusi
    private String zusiHost = "127.0.0.1";
    private Integer zusiPort = 1436;

    // DLR ETCS
    private String etcsHost = "127.0.0.1";
    private Integer etcsPortTiu = 50000;
    private Integer etcsPortOdo = 50002;

    public void enableModule(String module) {
        enabledModules.add(module);
    }

    public void setEnabledModules(String[] modules) {
        enabledModules = Arrays.asList(modules);
    }

    public List<String> getEnabledModules() {
        return enabledModules;
    }

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

    public String getZusiHost() {
        return zusiHost;
    }

    public void setZusiHost(String zusiHost) {
        this.zusiHost = zusiHost;
    }

    public Integer getZusiPort() {
        return zusiPort;
    }

    public void setZusiPort(Integer zusiPort) {
        this.zusiPort = zusiPort;
    }

    public String getEtcsHost() {
        return etcsHost;
    }

    public void setEtcsHost(String etcsHost) {
        this.etcsHost = etcsHost;
    }

    public Integer getEtcsPortTiu() {
        return etcsPortTiu;
    }

    public void setEtcsPortTiu(Integer etcsPortTiu) {
        this.etcsPortTiu = etcsPortTiu;
    }

    public Integer getEtcsPortOdo() {
        return etcsPortOdo;
    }

    public void setEtcsPortOdo(Integer etcsPortOdo) {
        this.etcsPortOdo = etcsPortOdo;
    }

    @Override
    public String toString() {
        return "MiddlewareConfig{" +
                "enabledModules=" + enabledModules +
                ", obermattUbw32ComPort='" + obermattUbw32ComPort + '\'' +
                ", cabineUbw32ComPort='" + cabineUbw32ComPort + '\'' +
                ", zusiHost='" + zusiHost + '\'' +
                ", zusiPort=" + zusiPort +
                ", etcsHost='" + etcsHost + '\'' +
                ", etcsPortTiu=" + etcsPortTiu +
                ", etcsPortOdo=" + etcsPortOdo +
                '}';
    }
}
