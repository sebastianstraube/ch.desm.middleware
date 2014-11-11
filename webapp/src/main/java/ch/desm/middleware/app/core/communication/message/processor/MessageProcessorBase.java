package ch.desm.middleware.app.core.communication.message.processor;

import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;


public abstract class MessageProcessorBase {

    public MessageProcessorUtil util = new MessageProcessorUtil();

   	/**
	 * 
	 * @param component
	 * @param message
	 */
	public void processEndpointMessage(ComponentBrokerClientBase component, String message, String topic) {
		if (message != null && !message.isEmpty()) {
			component.publish(message, topic);
		}
	}
}
