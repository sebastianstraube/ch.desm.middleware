package sebastianstraube.connectx.module.desm;

import com.google.gson.Gson;
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

import java.io.FileNotFoundException;
import java.io.FileReader;
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
            case "stellwerk":
                startOm();
                break;
            case "stellwerk_ubw32":
                startOmStellwerk();
                break;
            case "stellwerk_petrinet":
                startPetrinetOm();
                break;
            case "cabine":
                startCabine();
                break;
            case "zusi":
                startZusi();
                break;
            default:
                throw new IllegalArgumentException("Unknown module " + name);
        }
    }

    private void startOm() {
        startOmStellwerk();
        startPetrinetOm();
    }

    private void startCabine() {
        startCabineRe420();
        startPetrinetRe420();
    }

    private void startZusi() {
        // TODO: do they need separate services or can they share one?
        ZusiService service = new ZusiService(BrokerInstance.getSingleton(),
        config.getZusiHostIp(),
        config.getZusiPort());

        startZusiFahrpult(service);
        startZusiAusbildung(service);
    }

    public PetrinetOmService startPetrinetOm() {
        return new PetrinetOmService(BrokerInstance.getSingleton());
    }

    public void startPetrinetRe420() {
        PetrinetRe420Service petrinet = new PetrinetRe420Service(BrokerInstance.getSingleton());
    }

    public void startOmStellwerk() {
        OmService oml = new OmService(BrokerInstance.getSingleton(), config.getObermattUbw32ComPort());
    }

    public void startCabineRe420() {
        Re420Service service = new Re420Service(BrokerInstance.getSingleton(), config.getCabineUbw32ComPort());
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
