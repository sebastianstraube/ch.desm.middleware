package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.endpoint.EndpointBase;
import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ZusiEndpoint extends EndpointTcpClient {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpoint.class);
	
	public ZusiEndpoint(String ip, int port) {
		super(ip, port);
        this.registerEndpointListener();
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
            // TODO Auto-generated catch block
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void connect(){

        try {
            socket.connect(socketAddress);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            LOGGER.log(Level.ERROR, e);
        }
    }

}
