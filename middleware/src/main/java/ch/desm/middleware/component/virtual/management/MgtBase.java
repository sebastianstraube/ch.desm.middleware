package ch.desm.middleware.component.virtual.management;

import ch.desm.middleware.communication.broker.Broker;
import ch.desm.middleware.communication.endpoint.websocket.EndpointWebsocket;
import ch.desm.middleware.component.ComponentBase;

abstract class MgtBase extends ComponentBase {

	EndpointWebsocket endpoint;

	public MgtBase(Broker broker) {
		super(broker);
	}

}
