package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.handle.DaemonThreadBase;

public class ManagementEndpointMessageFetch extends DaemonThreadBase {

	private ManagementEndpoint endpoint;
	private Management management;

	public ManagementEndpointMessageFetch(Management management,
			ManagementEndpoint endpoint) {
		this.management = management;
		this.endpoint = endpoint;
//		this.run();
	}

	public void checkMessages() {
		if (endpoint.hasMessages()) {
			for (String message : endpoint.getMessages()) {
				management.onIncomingEndpointMessage(message);
			}
		}
	}

	public void run() {
		while (!isInterrupted()) {

			try {

				checkMessages();
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
