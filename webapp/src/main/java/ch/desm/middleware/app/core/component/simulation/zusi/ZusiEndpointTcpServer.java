package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpServer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ZusiEndpointTcpServer extends EndpointTcpServer {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpServer.class);

    ZusiEndpointMessageService messageService;

	public ZusiEndpointTcpServer(String ip, int port) {
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
}
