package ch.desm.middleware.app;


import ch.desm.middleware.app.core.communication.broker.Broker;
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

public class RunApp extends Thread {

	private static Logger LOGGER = Logger.getLogger(RunApp.class);

    private String host;
    private int port;
    private String tyrusWebsocketContextPath;
    private String serverEndpointContextPath;
    private String serverJettyPath;
    private boolean isConfigured = false;

    private Broker broker = new Broker();

    public void setConfiguration(String host, String port, String websocketContextPath, String serverEndpointContextPath, String jettyPath){
        this.host = host;
        this.port = Integer.valueOf(port);
        this.tyrusWebsocketContextPath = websocketContextPath;
        this.serverEndpointContextPath = serverEndpointContextPath;
        this.serverJettyPath = jettyPath;
        isConfigured = true;

        LOGGER.log(Level.INFO, "set configuration:"+
                "\nhost: "+this.host +
                "\nport: "+this.port +
                "\ntyrusWebsocketContextPath: " + this.tyrusWebsocketContextPath +
                "\nserverEndpointContextPath: " + this.serverEndpointContextPath +
                "\nserverJettyPath: " + this.serverJettyPath +
                "\nisConfigured: " + isConfigured);
    }

    public boolean isConfigured(){
        return isConfigured;
    }

	public void run(){

        /************************** Start Server ************************************/
        TyrusServer tyrusServer = startServerTyrus(host, port, tyrusWebsocketContextPath);
        JettyServer jettyServer = startJettyServer(serverJettyPath);
        startManagement(jettyServer, "ws://" + host + ":" + port + tyrusWebsocketContextPath + serverEndpointContextPath);
        /***************************************************************************/

        startOm();
        startZusi();
        //startCabine();
    }

    private void startOm(){
        startOmStellwerk("COM3");
        startPetrinetOm();
    }

    private void startCabine(){
        startCabineRe420("COM15"); //linux: dev/ttyACM0
        startPetrinetRe420();
    }

    private void startZusi(){
        // lokal: 192.168.1.20, vpn : 7.94.80.35
        ZusiService service = new ZusiService(broker, "7.94.80.35", 1436);
        startZusiFahrpult(service); //new ZusiService(broker, "7.94.80.35", 1436));
        startZusiAusbildung(service); //new ZusiService(broker, "7.94.80.35", 1436));
    }

    private void startEtcs(){
        startEtcsTiu("192.168.200.21", 50000);
        startEtcsOdo("192.168.200.21", 50002);
    }

    private void startEtcsTiu(String ip, int port){
        EtcsService tiu = new EtcsService(broker, ip, port);
    }

    private void startEtcsOdo(String ip, int port){
        EtcsService tiu = new EtcsService(broker, ip, port);
    }

    private JettyServer startJettyServer(String path){
        JettyServer server = new JettyServer(path);
        server.start();

        return server;
    }

    private TyrusServer startServerTyrus(String ip, int port, String path){
        TyrusServer server = new TyrusServer(ip, port, path);
        server.start();

        return server;
    }

	public void startManagement(JettyServer server, String uri){
        ManagementService management = isServerStarted(server) ? new ManagementService(broker, uri) : null;
	}

	public PetrinetOmService startPetrinetOm(){
        return new PetrinetOmService(broker);
	}

    public void startPetrinetRe420(){
        PetrinetRe420Service petrinet = new PetrinetRe420Service(broker);
    }

    public void startOmStellwerk(String port){
        OmService oml = new OmService(broker, port);
	}

    public void startCabineRe420(String port){
        Re420Service service = new Re420Service(broker, port);
    }

    public void startZusiFahrpult(ZusiService service){
        service.getEndpointFahrpult().init();
        service.getEndpointFahrpult().start();
        service.getEndpointFahrpult().sendCommandRegisterClientFahrpult();
        service.getEndpointFahrpult().sendCommandNeededDataFahrpult();
    }


    public void startZusiAusbildung(ZusiService service){
        service.getEndpointAusbildung().init();
        service.getEndpointAusbildung().start();
        service.getEndpointAusbildung().sendCommandRegisterClientAusbildung();
        service.getEndpointAusbildung().sendCommandNeededDataAusbildung();
    }

    private boolean isServerStarted(JettyServer server){
        while(!server.isStarted()){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
