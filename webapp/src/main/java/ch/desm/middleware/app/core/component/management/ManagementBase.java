package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.ComponentBase;

abstract class ManagementBase extends ComponentBase {

    private ManagementEndpoint endpoint;

	public ManagementBase(Broker broker, ManagementEndpoint endpoint) {
		super(broker);
        this.endpoint = endpoint;
        this.registerEndpointListener(endpoint);
	}

    public ManagementEndpoint getEndpoint(){
        return this.endpoint;
    }

}
