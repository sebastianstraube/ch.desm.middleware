package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.LinkedList;

public class ZusiEndpointTcpClient extends EndpointTcpClient {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);

    private ZusiService service;
    private ZusiEndpointTcpClientThread messageHandler;

	public ZusiEndpointTcpClient(ZusiService service, String ip, int port, String topic, String name) {
		super(ip, port, name);
        this.registerEndpointListener();
        this.service = service;
        this.messageHandler = new ZusiEndpointTcpClientThread(service, topic);
        messageHandler.start();
    }

    @Override
    public void onIncomingEndpointMessage(String stream){
        LOGGER.log(Level.TRACE, "client receive message: " + stream);
        messageHandler.addZusiStream(stream);
    }

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void disconnect(String reason){
        try {
            stop();
            socket.close();
            LOGGER.log(Level.INFO, "socket closed: " + socket.toString() + ", reason: " + reason);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void connect(){

        LOGGER.log(Level.INFO, "connecting to Server ...");
        try {
            socket.connect(socketAddress);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }

        LOGGER.log(Level.INFO, "connected to Server with address:" + socket.getInetAddress() + ", remote port: " + socket.getPort()+ ", locale port: " + socket.getLocalPort());
    }

    /**
     *
     */
    public void sendCommandRegisterClientAusbildung(){
        try {
            ZusiProtocolNode registerClient = service.getZusiProtocolCommand().getRegisterClient(
                   ZusiProtocolConstants.CLIENT_TYPE + "(Ausbildung)"
                    , ZusiProtocolConstants.CLIENT_VERSION,
                    ZusiProtocolConstants.CLIENT_TYPE_AUSBILDUNG);
            String stream = service.getCodec().encode(registerClient);
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     *
     */
    public void sendCommandRegisterClientFahrpult(){
        try {
            ZusiProtocolNode registerClient = service.getZusiProtocolCommand().getRegisterClient(
                    ZusiProtocolConstants.CLIENT_TYPE + "(Fahrpult)"
                    , ZusiProtocolConstants.CLIENT_VERSION,
                    ZusiProtocolConstants.CLIENT_TYPE_FAHRPULT);
            String stream = service.getCodec().encode(registerClient);
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     *
     */
    public void sendCommandNeededDataAusbildung(){
        try {
            String stream = service.getCodec().encode(service.getZusiProtocolCommand().getAusbildungNeededData());
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     *
     */
    public void sendCommandNeededDataFahrpult(){
        try {
            String stream = service.getCodec().encode(service.getZusiProtocolCommand().getFahrpultNeededData());
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     * TODO bugfixing - node hierharchie
     */
    public void sendCommandSignalDirect(){
        try {
            //String streckenModul, float referenzNrSignal, double signalBegriff, int zulGeschwSignal, float ereignisWert
            ZusiProtocolNode signalCommand = service.getZusiProtocolCommand().getSignalDirect(
                    //"\\Daten\\Routes\\Schweiz\\32T_0004_0052\\000406_005201_Obermatt\\130918-EMM-OM-LN.st3",
                    "\\Routes\\Schweiz\\32T_0004_0052\\000406_005201_Obermatt\\130918-EMM-OM-LN.st3",
                    73,
                    9703,
                    0,
                    0);
            String stream = service.getCodec().encode(signalCommand);

            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }


    /**
     *
     */
    public void sendCommandSignalAspect(){
        try {
            //String streckenModul, int referenzNrSignal, int signalModus, String signalMatrixSpalte, String signalMatrixZeile
            ZusiProtocolNode signalCommand = service.getZusiProtocolCommand().getSignalAspect(
                    //"\\Daten\\Routes\\Schweiz\\32T_0004_0052\\000406_005201_Obermatt\\130918-EMM-OM-LN.st3",
                    "Routes\\Schweiz\\32T_0004_0052\\000406_005201_Obermatt\\130918-EMM-OM-LN.st3",
                    73, //int 73
                    0,
                    2,
                    0);
            String stream = service.getCodec().encode(signalCommand);

            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}