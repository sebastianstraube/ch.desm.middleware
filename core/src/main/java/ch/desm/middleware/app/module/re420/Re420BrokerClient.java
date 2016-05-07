package ch.desm.middleware.app.module.re420;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

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

		List<MessageCommon> messageCommon = translator
				.toMiddlewareMessageList(message);

		processor.processBrokerMessage(service, messageCommon);
	}

	/**
	 * 
	 */
	@Override
	protected void initializeTopicSubscriptions() {
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT);
		subscribeToTopic(MessageCommon.MESSAGE_TOPIC_PETRINET_CABINE_RE420);
		subscribeToTopic(MessageCommon.MESSAGE_TOPIC_MANAGEMENT);
	}



}
