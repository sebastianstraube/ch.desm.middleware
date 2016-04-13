package ch.desm.middleware.app.module.simulation.locsim;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;

abstract class LocsimBrokerClientBase extends ComponentBrokerClientBase {

	protected LocsimEndpointRs232 endpointRs232;

	public LocsimBrokerClientBase(Broker broker, LocsimEndpointRs232 endpointRs232) {
		super(broker);
		
		this.endpointRs232 = endpointRs232;
	}
	
	public LocsimEndpointRs232 getEndpointRs232(){
		return this.endpointRs232;
	}

}
