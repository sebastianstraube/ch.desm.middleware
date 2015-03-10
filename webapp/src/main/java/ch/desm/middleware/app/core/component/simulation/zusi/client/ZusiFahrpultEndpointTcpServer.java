package ch.desm.middleware.app.core.component.simulation.zusi.client;

import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpServer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ZusiFahrpultEndpointTcpServer extends EndpointTcpServer {

    private static Logger LOGGER = Logger.getLogger(ZusiFahrpultEndpointTcpServer.class);

	public ZusiFahrpultEndpointTcpServer(String ip, int port) {
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
