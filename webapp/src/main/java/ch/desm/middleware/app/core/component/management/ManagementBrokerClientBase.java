package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;

abstract class ManagementBrokerClientBase extends ComponentBrokerClientBase {

	public ManagementBrokerClientBase(Broker broker, ManagementEndpoint endpoint) {
		super(broker);
	}
}
