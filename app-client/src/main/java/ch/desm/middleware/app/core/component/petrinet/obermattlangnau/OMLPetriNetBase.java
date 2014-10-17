package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.ComponentBase;

abstract class OMLPetriNetBase extends ComponentBase {

	private OMLPetriNetEndpoint endpoint;
	
    public OMLPetriNetBase(Broker broker, OMLPetriNetEndpoint endpoint) {
		super(broker);
		this.endpoint = endpoint;
	}

	public OMLPetriNetEndpoint getEndpoint(){
		return this.endpoint;
	}

    
}
