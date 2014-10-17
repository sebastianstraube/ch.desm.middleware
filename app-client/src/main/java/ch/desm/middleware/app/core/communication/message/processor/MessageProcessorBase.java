package ch.desm.middleware.app.core.communication.message.processor;

import java.util.ArrayList;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentBase;
import ch.desm.middleware.app.core.component.cabine.re420.Re420;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OML;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.OMLPetriNet;
import ch.desm.middleware.app.core.component.simulation.locsim.Locsim;


abstract class MessageProcessorBase {
		
	/**
	 * 
	 * @param component
	 * @param message
	 */
	public void processEndpointMessage(ComponentBase component, String message,
			String topic) {
		if (message != null && !message.isEmpty()) {
			component.publish(message, topic);
		}
	}

	/**
	 * 
	 * @param impl
	 * @param messages
	 */
	public void processBrokerMessage(Locsim impl,
			ArrayList<MessageMiddleware> messages) {

		for (MessageMiddleware message : messages) {
			this.processBrokerMessage(impl, message);
		}
	}

	/**
	 * 
	 * @param impl
	 * @param messages
	 */
	public void processBrokerMessage(OMLPetriNet impl,
			ArrayList<MessageMiddleware> messages) {

		for (MessageMiddleware message : messages) {
			this.processBrokerMessage(impl, message);
		}
	}

	/**
	 * 
	 * @param impl
	 * @param messages
	 */
	public void processBrokerMessage(Re420 impl,
			ArrayList<MessageMiddleware> messages) {

		for (MessageMiddleware message : messages) {
			this.processBrokerMessage(impl, message);
		}
	}

	/**
	 * 
	 * @param impl
	 * @param messages
	 */
	public void processBrokerMessage(OML impl,
			ArrayList<MessageMiddleware> messages) {

		for (MessageMiddleware message : messages) {
			this.processBrokerMessage(impl, message);
		}
	}
	
	protected abstract void processBrokerMessage(Locsim impl, MessageMiddleware message);
	protected abstract void processBrokerMessage(Re420 impl, MessageMiddleware message);
	protected abstract void processBrokerMessage(OML impl, MessageMiddleware message);
	protected abstract void processBrokerMessage(OMLPetriNet impl, MessageMiddleware message);
}
