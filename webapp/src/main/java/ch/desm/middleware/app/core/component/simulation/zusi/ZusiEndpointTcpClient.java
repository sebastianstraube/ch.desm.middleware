package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolMessage;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolStream;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ZusiEndpointTcpClient extends EndpointTcpClient {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);

    private ZusiService service;
    private ZusiProtocolStream zusiMessage;

	public ZusiEndpointTcpClient(ZusiService service, String ip, int port) {
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

                //is ack_needed_data command?
                if(zusiProtocolMessage.hasGroupId("0001-0002") &&
                        zusiProtocolMessage.hasParameter("0001", "00200033002e0030002e0036002e00320036") &&
                        zusiProtocolMessage.hasParameter("0002", "0031003700330033003500320032003600360037") &&
                        zusiProtocolMessage.hasParameter("0003", "0000")){
                    sendMessageNeededData();

                    //sendMessageRegisterClientAusbildung();
                }

                //TODO Map lookup !
                String message = service.getComponentMapMiddleware().getValue(globalId);

                service.getProcessor().processEndpointMessage(service.getBrokerClient(), message, MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI);
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

    public void sendMessageRegisterClientAusbildung(){

        try {
            String stream = service.getProtocolService().getMessageConnectAusbildungssteuerung();
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public void sendMessageNeededData(){

        try {
            String stream = service.getProtocolService().getMessageNeededData();
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

}