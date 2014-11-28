package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.endpoint.EndpointBase;
import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;

public class ZusiEndpoint extends EndpointTcpClient {

	
	public ZusiEndpoint(String threadName, String ip, int port) {
		super(threadName, ip, port);
		// TODO Auto-generated constructor stub
	}

    @Override
    protected void registerEndpointListener(EndpointBase listener) {

    }
}
