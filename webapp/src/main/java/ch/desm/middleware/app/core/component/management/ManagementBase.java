package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.ComponentBase;

abstract class ManagementBase extends ComponentBase {

	public ManagementBase(Broker broker) {
		super(broker);
//		this.registerEndpointListener(endpoint);
	}

}
