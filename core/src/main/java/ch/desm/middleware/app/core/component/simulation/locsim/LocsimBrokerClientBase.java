package ch.desm.middleware.app.core.component.simulation.locsim;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.common.ComponentBrokerClientBase;

abstract class LocsimBrokerClientBase extends ComponentBrokerClientBase {

	protected LocsimEndpointRs232 endpointRs232;
	protected LocsimEndpointDll endpointDll;
	
	public LocsimBrokerClientBase(Broker broker,
                                  LocsimEndpointRs232 endpointRs232,
                                  LocsimEndpointDll endpointDll) {
		super(broker);
		
		this.endpointRs232 = endpointRs232;
		this.endpointDll = endpointDll;
	}	
	
	public LocsimEndpointRs232 getEndpointRs232(){
		return this.endpointRs232;
	}
	
	public LocsimEndpointDll getEndpointDll(){
		return this.endpointDll;
	}
	
}
