package ch.desm.middleware.app.module.re420;

import java.util.LinkedList;

import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

public class Re420BrokerClient extends ComponentBrokerClientBase {

	private static Logger LOGGER = Logger.getLogger(Re420BrokerClient.class);

    Re420Service service;
	private Re420MessageProcessor processor;
	private MessageTranslatorMiddleware translator;


	public Re420BrokerClient(Broker broker, Re420Service service) {
		super(broker);
        this.service = service;
		this.processor = new Re420MessageProcessor();
		this.translator = new MessageTranslatorMiddleware();

	}

	/**
	 * 
	 */
	protected void onIncomingBrokerMessage(String message) {

		LOGGER.log(Level.TRACE, "broker (" + this.getClass() + ") received message: "
                + message);

		LinkedList<MessageMiddleware> messageCommon = translator
				.toMiddlewareMessageList(message);

		processor.processBrokerMessage(service, messageCommon);
	}

	/**
	 * 
	 */
	@Override
	protected void intializeSignedTopic() {
        signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT);
		signForTopic(MessageBase.MESSAGE_TOPIC_PETRINET_CABINE_RE420);
		signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
	}



}
