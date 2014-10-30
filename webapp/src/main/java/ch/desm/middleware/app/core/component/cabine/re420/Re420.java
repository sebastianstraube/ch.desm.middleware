package ch.desm.middleware.app.core.component.cabine.re420;

import java.util.ArrayList;

import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorUtil;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.fabisch.EndpointFabischListenerInterface;
import ch.desm.middleware.app.core.communication.endpoint.serial.ubw32.EndpointUbw32ListenerInterface;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

public class Re420 extends Re420Base implements
		EndpointUbw32ListenerInterface, EndpointFabischListenerInterface {

	private static Logger LOGGER = Logger.getLogger(Re420.class);

	private Re420MessageProcessor processor;
	private MessageTranslatorMiddleware translator;


	public Re420(Broker broker, Re420EndpointUbw32 endpoint,
			Re420EndpointFabisch endpointFabisch) {
		super(broker, endpoint, endpointFabisch);

		this.processor = new Re420MessageProcessor();
		this.translator = new MessageTranslatorMiddleware();

	}

	/**
	 * 
	 */
	protected void onIncomingBrokerMessage(String message) {

		LOGGER.trace("broker (" + this.getClass() + ") received message: "
				+ message);

		ArrayList<MessageMiddleware> messageCommon = translator
				.toMiddlewareMessageList(message);

		processor.processBrokerMessage(this, messageCommon);
	}

	/**
	 * TODO implementation
	 * 
	 * @param message
	 */
	public void onIncomingEndpointMessage(String message) {

		LOGGER.trace("endpoint (" + this.getClass() + ") received message: "
				+ message.replaceAll("\n", ""));

		if (!message.isEmpty()) {
			
			if(message.startsWith("#fabisch#")){
				
				LOGGER.trace("endpoint (" + this.getClass()
						+ ") received message fabisch: " + message);
				
				//do nothing
			}else{
			
				LOGGER.debug("endpoint (" + this.getClass()
						+ ") received message RS232: " + message);
				
				processIncomingUbw32(message);
			}
			
		}
	}
	
	private void processIncomingUbw32(String message){

		MessageUbw32Base ubw32Message = translator
				.decodeUbw32EndpointMessage(message,
						MessageCommon.MESSAGE_TOPIC_CABINE_RE420);

		if(ubw32Message != null){
			
			String messages = processor.convertToMiddlewareMessage(this, ubw32Message);
			
			processor.processEndpointMessage(this, messages,
					MessageBase.MESSAGE_TOPIC_CABINE_RE420);
		}		
	}

	/**
	 * 
	 */
	@Override
	protected void intializeSignedTopic() {
		signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM);
		signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232);
		signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420_FABISCH);
		signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
	}



}
