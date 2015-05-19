package ch.desm.middleware.app.core.component.cabine.re420;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.common.ComponentBrokerClientBase;

abstract class Re420BrokerClientBase extends ComponentBrokerClientBase {

	protected Re420EndpointUbw32 endpoint;
	protected Re420EndpointFabisch endpointFabisch;
	
	public Re420BrokerClientBase(Broker broker,
                                 Re420EndpointUbw32 endpoint, Re420EndpointFabisch endpointFabisch) {
		super(broker);
		
		this.endpoint = endpoint;
		this.endpointFabisch = endpointFabisch;
	}
	
	public Re420EndpointUbw32 getEndpointUbw32(){
		return this.endpoint;
	}
	
	public Re420EndpointFabisch getEndpointFabisch(){
		return this.endpointFabisch;
	}


}
