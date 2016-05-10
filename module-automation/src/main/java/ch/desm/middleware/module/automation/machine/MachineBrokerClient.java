package ch.desm.middleware.module.automation.machine;

import ch.desm.middleware.core.communication.broker.Broker;
import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

public class MachineBrokerClient extends ComponentBrokerClientBase {

	private static Logger LOGGER = Logger.getLogger(MachineBrokerClient.class);

    MachineService service;
	private MachineMessageProcessor processor;
	private MessageTranslatorMiddleware translator;


	public MachineBrokerClient(Broker broker, MachineService service) {
		super(broker);
        this.service = service;
		this.processor = new MachineMessageProcessor();
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
