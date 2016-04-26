package ch.desm.middleware.app.module.re420;

import java.util.List;

import ch.desm.middleware.app.core.communication.endpoint.ubw32.EndpointUbw32;
import ch.desm.middleware.app.core.communication.endpoint.ubw32.EndpointUbw32MessageProcessor;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Analog;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterComplete;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterSingle;
import ch.desm.middleware.app.core.component.ComponentMapBase;
import ch.desm.middleware.app.core.component.ComponentMessageProcessorBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Re420MessageProcessor extends ComponentMessageProcessorBase<Re420Service> {

	private static Logger LOGGER = Logger.getLogger(Re420MessageProcessor.class);

	/**
	 * @param messages
	 */
	@Override
	public void processBrokerMessage(Re420Service service, List<MessageCommon> messages) {
		for(MessageCommon message : messages){
			processBrokerMessage(service, message);
		}
	}

	public void processEndpointMessage(Re420Service service, String message){
		MessageUbw32Base ubw32Message = service.getTranslator()
				.decodeUbw32EndpointMessage(message,
						MessageBase.MESSAGE_TOPIC_CABINE_RE420);

		//processable message
		if(ubw32Message != null){
			String messages = service.getMessageProcessor().convertToMiddlewareMessage(service, ubw32Message);
			processEndpointMessage(service.getBrokerClient(), messages, ubw32Message.getTopic());
		}
	}

	private void processBrokerMessage(Re420Service service, MessageCommon element){
		switch(element.getTopic()){
			case (MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT):{
				processBrokerMessageZusiFahrpult(service, element);
				break;
			}
			case (MessageBase.MESSAGE_TOPIC_PETRINET_CABINE_RE420):{
				processBrokerMessagePetrinetRe420(service, element);
				break;
			}
			case (MessageBase.MESSAGE_TOPIC_MANAGEMENT):{
                processBrokerMessageManagement(service, element);
				break;
			}
		}
	}

	private void processInitEndpoint(Re420EndpointUbw32 endpoint, MessageCommon element){
		final String parameter;
		try {
			parameter = element.getParameterAsString();
		} catch (MessageCommon.BadParameterTypeCastException e) {
			LOGGER.log(Level.ERROR, "Received init message with type " + element.getTypeName() + " but expected String");
			return;
		}

		switch (parameter) {
			case ("init"): {
				endpoint.init();
				break;
			}
			case ("start"): {
				endpoint.start();
				break;
			}
			case ("stop"): {
				endpoint.stop();
				break;
			}
		}
	}

	private void processBrokerMessageZusiFahrpult(Re420Service service, MessageCommon message) {
        String globalId = message.getGlobalId();
        String key = service.getMapZusi().getKeyForValue(globalId);
		delegateToEndpoint(service.getEndpoint(), service.getMapDigital(), service.getMapAnalog(), key, message, true);
	}

	private void processBrokerMessagePetrinetRe420(Re420Service service, MessageCommon message) {
		String globalId = message.getGlobalId();
		String key = service.getMapPetrinetRe420().getKeyForValue(globalId);
		delegateToEndpoint(service.getEndpoint(), service.getMapDigital(), service.getMapAnalog(), key, message, true);
	}

	private void processBrokerMessageManagement(Re420Service service, MessageCommon message) {
		try {
			if (isInitProcessMessage(message)) {
				processInitEndpoint(service.getEndpoint(), message);
			} else {

				// Todo implementation
				// activate this, when gui taken controle over this endpoint
			}
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	//TODO refactoring
	public boolean isInitProcessMessage(MessageCommon element){
		if (element.getGlobalId().equalsIgnoreCase("mgmt.cabine.re420.ubw32")) return true;
		return false;
	}

	/**
	 *
	 * @param message
	 * @return
	 */
	public String convertToMiddlewareMessage(Re420Service service, MessageUbw32Base message) {

		String middlewareMessagesInput = "";
		if (message instanceof MessageUbw32DigitalRegisterSingle) {
            middlewareMessagesInput = EndpointUbw32MessageProcessor.getUbwSingleRegisterValues(service, service.getEndpoint(), (MessageUbw32DigitalRegisterSingle) message);
        }
		else if (message instanceof MessageUbw32DigitalRegisterComplete){
            middlewareMessagesInput = EndpointUbw32MessageProcessor.getUbwAllRegisterValues(service, service.getEndpoint(), (MessageUbw32DigitalRegisterComplete) message);
        }
		else if (message instanceof MessageUbw32Analog){
            middlewareMessagesInput = EndpointUbw32MessageProcessor.getUbwAnalogRegisterValues(service, service.getEndpoint(), (MessageUbw32Analog) message);
        }

		LOGGER.log(Level.TRACE,"processing middleware message: " + middlewareMessagesInput);
		return middlewareMessagesInput;
	}
}
