package ch.desm.middleware.app.core.component.simulation.zusi.client;

import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiCommonEndpointThread;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ZusiEndpointTcpClient extends EndpointTcpClient {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);

    private ZusiService service;
    private ZusiCommonEndpointThread tcpThread;

	public ZusiEndpointTcpClient(ZusiService service, String ip, int port) {
		super(ip, port);
        this.registerEndpointListener();
        this.service = service;

        this.tcpThread = new ZusiCommonEndpointThread(service);
        tcpThread.start();
    }

    @Override
    public void onIncomingEndpointMessage(String stream){
        LOGGER.log(Level.TRACE, "client receive message: " + stream);
        tcpThread.addZusiStream(stream);
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
            String stream = service.getZusiProtocolClientMessage().getMessageConnectAusbildung();
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
            String stream = service.getZusiProtocolClientMessage().getMessageNeededDataAusbildung();
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     * TODO move to own client
     */
    public void sendMessageRegisterClient(){

        try {
            String stream = service.getZusiProtocolClientMessage().getMessageConnectFahrpult();
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     * TODO move to own client
     */
    public void sendMessageNeededData(){

        try {
            String stream = service.getZusiProtocolClientMessage().getMessageNeededDataFahrpult();
            this.send(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }



}