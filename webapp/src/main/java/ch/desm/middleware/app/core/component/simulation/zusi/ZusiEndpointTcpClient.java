package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

public class ZusiEndpointTcpClient extends EndpointTcpClient {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);

    ZusiEndpointMessageService messageService;

	public ZusiEndpointTcpClient(String ip, int port) {
		super(ip, port);
        this.registerEndpointListener();
        messageService = new ZusiEndpointMessageService();
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
    public void disconnect(){
        try {
            stop();
            socket.close();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void connect(){

        try {
            socket.connect(socketAddress);

            System.out.print("Address:" + socket.getInetAddress() + ", remote port: " + socket.getPort()+ ", locale port: " + socket.getLocalPort());
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }

        sendTestStream();

    }

    public void sendTestStream(){

        try {
            String stream = messageService.getConnectMessageStreamTest();
            this.send(stream);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

}