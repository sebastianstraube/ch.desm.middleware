package ch.desm.middleware.app.module.simulation.locsim;

import java.util.LinkedList;

import ch.desm.middleware.app.module.simulation.locsim.message.LocsimMessageTranslatorRs232;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.rs232.EndpointRs232ListenerInterface;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

public class Locsim extends LocsimBrokerClientBase implements EndpointRs232ListenerInterface {

	private static Logger LOGGER = Logger.getLogger(Locsim.class);

	public LocsimMessageTranslatorRs232 translatorRs232;
	public LocsimMessageProcessor processor;
	public MessageTranslatorMiddleware translator;
	
	boolean initialisiert;

	public Locsim(Broker broker, LocsimEndpointRs232 endpointRs232) {
		super(broker, endpointRs232);

		translatorRs232 = new LocsimMessageTranslatorRs232();
		processor = new LocsimMessageProcessor();
		translator = new MessageTranslatorMiddleware();
	}


	public void onIncomingEndpointMessage(String message) {

		if(!message.isEmpty()){
			LOGGER.log(Level.TRACE, "endpoint (" + this.getClass() + ") received message RS232: " + message);
			processor.processIncomingDataRs232(this, message);
		}
	}

	/**
	 * TODO implementation
	 */
	@Override
	protected void onIncomingBrokerMessage(String message) {
		
		LOGGER.log(Level.TRACE, "broker (" + this.getClass() + ") received message: " + message);

		LinkedList<MessageMiddleware> messageList = translator
				.toMiddlewareMessageList(message);

		processor.processBrokerMessage(this, messageList);
	}

	@Override
	protected void initializeTopicSubscriptions() {
        subscribeToTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420);
        subscribeToTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT);
	}

}
