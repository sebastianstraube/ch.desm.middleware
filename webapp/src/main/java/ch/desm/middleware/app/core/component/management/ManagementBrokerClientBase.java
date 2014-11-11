package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;

abstract class ManagementBrokerClientBase extends ComponentBrokerClientBase {

    private ManagementEndpoint endpoint;

	public ManagementBrokerClientBase(Broker broker, ManagementEndpoint endpoint) {
		super(broker);
        this.endpoint = endpoint;
        this.registerEndpointListener(endpoint);
	}

    public ManagementEndpoint getEndpoint(){
        return this.endpoint;
    }

}
