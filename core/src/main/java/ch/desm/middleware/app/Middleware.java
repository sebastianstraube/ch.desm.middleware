package ch.desm.middleware.app;


import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.replay.ReplayFilter;
import ch.desm.middleware.app.core.communication.replay.ReplayFilterAllowEverything;
import ch.desm.middleware.app.core.communication.replay.ReplayLoader;
import ch.desm.middleware.app.module.re420.Re420Service;
import ch.desm.middleware.app.module.obermatt.OmService;
import ch.desm.middleware.app.module.gui.ManagementService;
import ch.desm.middleware.app.module.petrinet.obermatt.PetrinetOmService;
import ch.desm.middleware.app.module.petrinet.re420.PetrinetRe420Service;
import ch.desm.middleware.app.module.simulation.etcs.EtcsService;
import ch.desm.middleware.app.module.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.server.JettyServer;
import ch.desm.middleware.app.core.server.TyrusServer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Middleware {

    private static Logger LOGGER = Logger.getLogger(Middleware.class);

    private final Broker broker = new Broker();
    private final MiddlewareConfig config;

    public Middleware(MiddlewareConfig config) {
        this.config = config;
    }

    public void start() {
        for (String module : config.getEnabledModules()) {
            startModule(module);
        }
    }

    private void startModule(String name) {
        switch (name) {
            case "management":
                startManagement();
                break;
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
        ZusiService service = new ZusiService(broker, config.getZusiHost(), config.getZusiPort());
        startZusiFahrpult(service);
        startZusiAusbildung(service);
    }

    private void startEtcs() {
        startEtcsTiu();
        startEtcsOdo();
    }

    private void startEtcsTiu() {
        EtcsService tiu = new EtcsService(broker, config.getEtcsHost(), config.getEtcsPortTiu());
    }

    private void startEtcsOdo() {
        EtcsService tiu = new EtcsService(broker, config.getEtcsHost(), config.getEtcsPortOdo());
    }

    public void startManagement() {
        final String host = config.getManagementHost();
        final Integer port = config.getManagementPort();
        final String jettyPath = config.getServerJettyPath();
        final String tyrusPath = config.getTyrusWebsocketContextPath();
        final String serverPath = config.getServerEndpointContextPath();
        final TyrusServer tyrusServer = startServerTyrus(host, port, tyrusPath);
        final JettyServer jettyServer = startJettyServer(jettyPath);
        if (waitUntilServerStarted(jettyServer)) {
            final String url = String.format("ws://%s:%d%s%s", host, port, tyrusPath, serverPath);
            final ManagementService management = new ManagementService(broker, url);
        }
    }

    private JettyServer startJettyServer(String path) {
        JettyServer server = new JettyServer(path);
        server.start();

        return server;
    }

    private TyrusServer startServerTyrus(String ip, int port, String path) {
        TyrusServer server = new TyrusServer(ip, port, path);
        server.start();

        return server;
    }

    public PetrinetOmService startPetrinetOm() {
        return new PetrinetOmService(broker);
    }

    public void startPetrinetRe420() {
        PetrinetRe420Service petrinet = new PetrinetRe420Service(broker);
    }

    public void startOmStellwerk() {
        OmService oml = new OmService(broker, config.getObermattUbw32ComPort());
    }

    public void startCabineRe420() {
        Re420Service service = new Re420Service(broker, config.getCabineUbw32ComPort());
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

    private boolean waitUntilServerStarted(JettyServer server) {
        while (!server.isStarted()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    public void runReplay(String file) {
        runReplay(file, new ReplayFilterAllowEverything());
    }

    public void runReplay(String file, ReplayFilter filter) {
        try {
            final ReplayLoader loader = new ReplayLoader();
            loader.loadFromLogFile(file).run(broker, filter);
            LOGGER.log(Level.INFO, "==================== DONE REPLAYING " + file);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Error while running replay from " + file + ": " + e);
        }
    }
}
