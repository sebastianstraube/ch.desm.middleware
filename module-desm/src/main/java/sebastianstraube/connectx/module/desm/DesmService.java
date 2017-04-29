package sebastianstraube.connectx.module.desm;

import sebastianstraube.connectx.core.communication.broker.BrokerInstance;
import sebastianstraube.connectx.core.communication.replay.ReplayFilter;
import sebastianstraube.connectx.core.communication.replay.ReplayFilterAllowEverything;
import sebastianstraube.connectx.core.communication.replay.ReplayLoader;
import sebastianstraube.connectx.module.desm.cabine.re420.Re420Service;
import sebastianstraube.connectx.module.desm.interlocking.obermatt.OmService;
import sebastianstraube.connectx.module.desm.petrinet.obermatt.PetrinetOmService;
import sebastianstraube.connectx.module.desm.petrinet.re420.PetrinetRe420Service;
import sebastianstraube.connectx.module.desm.simulation.zusi.ZusiService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

public class DesmService {

    private static Logger LOGGER = Logger.getLogger(DesmService.class);

    private DesmServiceConfig config;

    public DesmService(DesmServiceConfig config){
        this.config = config;
    }

    public void start() {
        for (String module : config.getEnabledModules()) {
            startModule(module);
        }
    }

    private void startModule(String name) {
        switch (name) {
            case "stellwerk_ubw32":
                startOmStellwerk();
                break;
            case "stellwerk_petrinet":
                startOmPetrinet();
                break;
            case "re420":
                startRe420Cabine();
                break;
            case "re420_petrinet":
                startRe420Petrinet();
                break;
            case "zusi":
                startZusi();
                break;
            default:
                throw new IllegalArgumentException("Unknown module " + name);
        }
    }

    private void startZusi() {
        // TODO: do they need separate services or can they share one?
        ZusiService service = new ZusiService(BrokerInstance.getSingleton(),
        config.getZusiHostIp(),
        config.getZusiPort());

        startZusiFahrpult(service);
        startZusiAusbildung(service);
    }

    public PetrinetOmService startOmPetrinet() {
        return new PetrinetOmService(BrokerInstance.getSingleton());
    }

    public PetrinetRe420Service startRe420Petrinet() {
        PetrinetRe420Service service = new PetrinetRe420Service(BrokerInstance.getSingleton());
        return service;
    }

    public OmService startOmStellwerk() {
        OmService oml = new OmService(BrokerInstance.getSingleton(), config.getObermattUbw32ComPort());
        return oml;
    }

    public Re420Service startRe420Cabine() {
        Re420Service service = new Re420Service(BrokerInstance.getSingleton(), config.getCabineUbw32ComPort());
        return service;
    }

    public void startZusiFahrpult(ZusiService service) {
        service.getEndpointFahrpult().init();
        service.getEndpointFahrpult().start();
        service.getEndpointFahrpult().sendCommandRegisterClientFahrpult();
        service.getEndpointFahrpult().sendCommandNeededDataFahrpult();
    }


    public void startZusiAusbildung(ZusiService service) {
        service.getEndpointAusbildung().init();
        service.getEndpointAusbildung().start();
        service.getEndpointAusbildung().sendCommandRegisterClientAusbildung();
        service.getEndpointAusbildung().sendCommandNeededDataAusbildung();
    }

    public void runReplay(String file) {
        runReplay(file, new ReplayFilterAllowEverything());
    }

    public void runReplay(String file, ReplayFilter filter) {
        try {
            final ReplayLoader loader = new ReplayLoader();
            loader.loadFromLogFile(file).run(BrokerInstance.getSingleton(), filter);
            LOGGER.log(Level.INFO, "==================== DONE REPLAYING ====================" + file);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Error while running replay from " + file + ": " + e);
        }
    }
}
