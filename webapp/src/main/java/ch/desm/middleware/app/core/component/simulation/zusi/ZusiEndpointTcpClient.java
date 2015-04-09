package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelperHex;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeRoot;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

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
     * TODO move to own client
     */
    public void sendMessageRegisterClientAusbildung(){

        try {

            ZusiProtocolNodeRoot root = new ZusiProtocolNodeRoot();
            ZusiProtocolNode start = new ZusiProtocolNode("0100", "");
            ZusiProtocolNode hello = new ZusiProtocolNode("0100", "");
            ZusiProtocolNode protocolVersion = new ZusiProtocolNode("0100", "0200");
            ZusiProtocolNode clientType = new ZusiProtocolNode("0200", "0300");

            String dataClientAusbildung = ZusiProtocolNodeHelperHex.toHex(ZusiProtocolConstants.CLIENT_TYPE + "(Ausbildung)");
            String dataClientVersion = ZusiProtocolNodeHelperHex.toHex(ZusiProtocolConstants.CLIENT_VERSION);

            ZusiProtocolNode text = new ZusiProtocolNode("0300", dataClientAusbildung);
            ZusiProtocolNode version = new ZusiProtocolNode("0400", dataClientVersion);

            root.addNode(start);
            start.addNode(hello);
            hello.addNode(protocolVersion);
            hello.addNode(clientType);
            hello.addNode(text);
            hello.addNode(version);

            String stream = service.getEncoder().encode(root);
            this.send(stream);

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     * TODO move to own client
     */
    public void sendMessageNeededDataAusbildung(){
        try {
            ZusiProtocolNodeRoot root = new ZusiProtocolNodeRoot();
            ZusiProtocolNode client_ausbilder = new ZusiProtocolNode("0300", "");
            ZusiProtocolNode needed_data = new ZusiProtocolNode("0300", "");

            /*
            12.3.4.6. Befehl 00 0D – TRAINPOS (Zusi  Client) → Der TRAINPOS-Befehl überträgt die aktuelle Zugpositionen von Zusi an den Client.
             */
            ZusiProtocolNode trainpos = new ZusiProtocolNode("0100", "1400");

            root.addNode(client_ausbilder);
            client_ausbilder.addNode(needed_data);
            needed_data.addNode(trainpos);

            String stream = service.getEncoder().encode(root);
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     * TODO move to own client
     */
    public void sendMessageRegisterClientFahrpult(){

        try {
            ZusiProtocolNodeRoot root = new ZusiProtocolNodeRoot();
            ZusiProtocolNode start = new ZusiProtocolNode("0100", "");
            ZusiProtocolNode hello = new ZusiProtocolNode("0100", "");
            ZusiProtocolNode protocolVersion = new ZusiProtocolNode("0100", "0200");
            ZusiProtocolNode clientType = new ZusiProtocolNode("0200", "0200");

            String dataType = ZusiProtocolNodeHelperHex.toHex(ZusiProtocolConstants.CLIENT_TYPE + "(Fahrpult)");
            String dataClient = ZusiProtocolNodeHelperHex.toHex(ZusiProtocolConstants.CLIENT_VERSION);
            ZusiProtocolNode text = new ZusiProtocolNode("0300", dataType);
            ZusiProtocolNode version = new ZusiProtocolNode("0400", dataClient);

            root.addNode(start);
            start.addNode(hello);
            hello.addNode(protocolVersion);
            hello.addNode(clientType);
            hello.addNode(text);
            hello.addNode(version);

            String stream = service.getEncoder().encode(root);
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     * TODO move to own client
     */
    public void sendMessageNeededDataFahrpult(){

        try {
            ZusiProtocolNodeRoot root = new ZusiProtocolNodeRoot();
            ZusiProtocolNode client_fahrpult = new ZusiProtocolNode("0200", "");
            ZusiProtocolNode needed_data = new ZusiProtocolNode("0300", "");
            ZusiProtocolNode fuehrerstandsAnzeigen = new ZusiProtocolNode("0A00", "");
            ZusiProtocolNode geschwindigkeit = new ZusiProtocolNode("0100", "0100");

            root.addNode(client_fahrpult);
            client_fahrpult.addNode(needed_data);
            needed_data.addNode(fuehrerstandsAnzeigen);
            fuehrerstandsAnzeigen.addNode(geschwindigkeit);

            String stream = service.getEncoder().encode(root);
            this.send(stream);

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }



}