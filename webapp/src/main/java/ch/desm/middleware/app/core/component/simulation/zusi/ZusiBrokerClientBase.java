package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;

abstract class ZusiBrokerClientBase extends ComponentBrokerClientBase {

	protected ZusiEndpointTcp endpoint;

	public ZusiBrokerClientBase(Broker broker, ZusiEndpointTcp endpoint) {
		super(broker);
		this.endpoint = endpoint;
	}

	public ZusiEndpointTcp getEndpoint() {
		return this.endpoint;
	}
}
