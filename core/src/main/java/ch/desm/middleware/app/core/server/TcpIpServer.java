package ch.desm.middleware.app.core.server;

import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpServer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TcpIpServer extends EndpointTcpServer {

    private static Logger LOGGER = Logger.getLogger(TcpIpServer.class);

	public TcpIpServer(String ip, int port) {
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
    public void onIncomingEndpointMessage(String message){
        LOGGER.log(Level.INFO, "received endpont message: " + message);

    }
}
