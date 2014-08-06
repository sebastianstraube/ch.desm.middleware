package ch.desm.middleware.modules.component.interlocking.obermattlangnau;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import ch.desm.middleware.modules.communication.broker.Broker;
import ch.desm.middleware.modules.communication.endpoint.EndpointCommon;
import ch.desm.middleware.modules.communication.endpoint.serial.ubw32.EndpointUbw32ListenerInterface;
import ch.desm.middleware.modules.communication.message.MessageBase;
import ch.desm.middleware.modules.communication.message.MessageMiddleware;
import ch.desm.middleware.modules.communication.message.MessageUbw32Analog;
import ch.desm.middleware.modules.communication.message.MessageUbw32DigitalRegisterComplete;
import ch.desm.middleware.modules.communication.message.router.MessageRouter;
import ch.desm.middleware.modules.communication.message.translator.MessageTranslatorMiddleware;

public class OMLBaseImpl extends OMLBase implements
		EndpointUbw32ListenerInterface {

	private static Logger log = Logger.getLogger(OMLBaseImpl.class);

	MessageTranslatorMiddleware translator;
	MessageRouter router;
	
	public OMLBaseImpl(Broker broker, EndpointCommon communicationEndpointUbw32) {
		super(broker, communicationEndpointUbw32);
		
		translator = new MessageTranslatorMiddleware();
		router = new MessageRouter();
	}

	protected void onIncomingBrokerMessage(String message) {
		
		log.trace("broker (" + this.getClass() + ") received message: " + message);
		
		ArrayList<MessageMiddleware> messageCommon = translator
				.translateToCommonMiddlewareMessageList(message);

		router.processBrokerMessage(this, messageCommon);
	}

	/**
	 * TODO implementation
	 * 
	 * @param message
	 */
	public void onIncomingEndpointMessage(String message) {
		log.trace("endpoint (" + getEndpoint().getSerialPortName() + ") received message: " + message);
		
		//TODO implementation
	}

	/**
	 * TODO implementation
	 * 
	 * @param message
	 */
	public String processInputs(MessageUbw32DigitalRegisterComplete message) {

		String middlewareMessagesInput = "";


		return middlewareMessagesInput;
	}

	/**
	 * TODO implementation
	 * 
	 * @param message
	 */
	public String processInputs(MessageUbw32Analog message) {

		String middlewareMessagesInput = "";

		return middlewareMessagesInput;
	}

	/**
	 * 
	 */
	@Override
	public boolean hasTopicSigned(String topic) {
		return signedTopic.contains(topic);
	}

	/**
	 * 
	 */
	@Override
	protected void intializeSignedTopic() {
		signedTopic.add(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
	}

}
