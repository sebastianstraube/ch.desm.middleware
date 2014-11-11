package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;

abstract class OMLBrokerClientBase extends ComponentBrokerClientBase {

	private static Logger LOGGER = Logger.getLogger(OMLBrokerClientBase.class);

	protected OMLEndpointUbw32 endpoint;

	public OMLBrokerClientBase(Broker broker, OMLEndpointUbw32 endpoint) {
		super(broker);
		this.endpoint = endpoint;

        //TODO refactoring
		//this.registerEndpointListener(endpoint);
	}

	public OMLEndpointUbw32 getEndpoint() {
		return this.endpoint;
	}

}
