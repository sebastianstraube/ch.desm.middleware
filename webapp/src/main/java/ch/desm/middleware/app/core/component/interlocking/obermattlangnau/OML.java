package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import java.util.ArrayList;

import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapInterlockingPetrinet;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.ubw32.EndpointUbw32ListenerInterface;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

public class OML extends OMLBase implements
		EndpointUbw32ListenerInterface {

	private static Logger LOGGER = Logger.getLogger(OML.class);

	private MessageTranslatorMiddleware translator;
	private OMLMessageProcessor processor;

	public OML(Broker broker, OMLEndpointUbw32 endpoint) {
		super(broker, endpoint);
		
		this.translator = new MessageTranslatorMiddleware();
		this.processor = new OMLMessageProcessor();
	}

	protected void onIncomingBrokerMessage(String message) {
		
		LOGGER.log(Level.TRACE, "broker (" + this.getClass() + ") received message: " + message);
		
		ArrayList<MessageMiddleware> messageList = translator
				.toMiddlewareMessageList(message);

		processor.processBrokerMessage(getEndpoint(), messageList);
	}

	/**
	 * TODO implementation
	 * 
	 * @param message
	 */
	public void onIncomingEndpointMessage(String message) {
		LOGGER.log(Level.TRACE, "endpoint (" + getEndpoint().getSerialPortName() + ") received message: " + message);

		MessageUbw32Base ubw32Message = translator
				.decodeUbw32EndpointMessage(message,
						MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU);

		//processable message
		if(ubw32Message != null){
			String messages = processor.convertToMiddlewareMessage(this, ubw32Message);
			processor.processEndpointMessage(this, messages, MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU);
		}
	}

	/**
	 * 
	 */
	@Override
	protected void intializeSignedTopic() {
		signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
		signForTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
		signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
	}

}
