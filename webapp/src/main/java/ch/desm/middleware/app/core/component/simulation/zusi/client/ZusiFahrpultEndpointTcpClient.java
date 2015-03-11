package ch.desm.middleware.app.core.component.simulation.zusi.client;

import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolMessage;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolStream;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ZusiFahrpultEndpointTcpClient extends EndpointTcpClient {

    private static Logger LOGGER = Logger.getLogger(ZusiFahrpultEndpointTcpClient.class);

    private ZusiService service;
    private ZusiProtocolStream zusiMessage;

	public ZusiFahrpultEndpointTcpClient(ZusiService service, String ip, int port) {
		super(ip, port);
        this.registerEndpointListener();
        this.service = service;
        this.zusiMessage = new ZusiProtocolStream();
    }

    @Override
    public void onIncomingEndpointMessage(String hexMessage){
        LOGGER.log(Level.TRACE, "client receive message: " + hexMessage);

        zusiMessage.addStream(hexMessage);
        String extractedMessage = service.getProtocolService().extractSingleZusiMessage(zusiMessage.getStream());
        zusiMessage.cutStream(extractedMessage.length());

        if(!extractedMessage.isEmpty()){
            LOGGER.log(Level.INFO, "client receive buffered message: " + extractedMessage);

            try {

                String globalId = service.getProtocolService().getGlobalId(extractedMessage);
                ZusiProtocolMessage zusiProtocolMessage = new ZusiProtocolMessage(globalId);

                //TODO Map lookup !
                String message = service.getComponentMapMiddleware().getValue(globalId);

                //TODO send middleware message to broker clients
                //service.getProcessor().processEndpointMessage(service.getBrokerClient(), message, MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI);
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }

        }else{
            LOGGER.log(Level.TRACE, "buffered message is incomplete: " + zusiMessage.getStream());
        }

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

    public void sendMessageRegisterClientFahrpult(){

        try {
            String stream = service.getProtocolService().getMessageConnectFahrpult();
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public void sendMessageFahrpultNeededData(){

        try {
            String stream = service.getProtocolService().getMessageNeededDataFahrpult();
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     * TODO move to own client
     */
    public void sendMessageRegisterClientAusbildung(){

        try {
            String stream = service.getProtocolService().getMessageConnectAusbildung();
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     * TODO move to own client
     */
    public void sendMessageAusbildungNeededData(){

        try {
            String stream = service.getProtocolService().getMessageNeededDataAusbildung();
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

}