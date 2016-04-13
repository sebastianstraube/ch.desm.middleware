package ch.desm.middleware.app.module.re420;

import java.util.LinkedList;

import ch.desm.middleware.app.core.communication.endpoint.ubw32.EndpointUbw32MessageProcessor;
import ch.desm.middleware.app.core.component.ComponentMessageProcessorBase;
import ch.desm.middleware.app.core.communication.message.*;
import ch.desm.middleware.app.common.utility.UtilityMessageProcessor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Re420MessageProcessor extends ComponentMessageProcessorBase<Re420Service> {

	private static Logger LOGGER = Logger.getLogger(Re420MessageProcessor.class);

	public Re420MessageProcessor() {
        this.util = new UtilityMessageProcessor();
	}

	/**
	 * @param messages
	 */
	@Override
	public void processBrokerMessage(Re420Service service, LinkedList<MessageMiddleware> messages) {
		for(MessageMiddleware message : messages){
			processBrokerMessage(service, message);
		}
	}

	public void processEndpointMessage(Re420Service service, String message){
		MessageUbw32Base ubw32Message = service.getTranslator()
				.decodeUbw32EndpointMessage(message,
						MessageCommon.MESSAGE_TOPIC_CABINE_RE420);

		//processable message
		if(ubw32Message != null){
			String messages = service.getMessageProcessor().convertToMiddlewareMessage(service, ubw32Message);
			processEndpointMessage(service.getBrokerClient(), messages, ubw32Message.getTopic());
		}
	}

	private void processBrokerMessage(Re420Service service, MessageMiddleware element){
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

	private void processInitEndpoint(Re420EndpointUbw32 endpoint, MessageMiddleware element){
		switch (element.getParameter()) {
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

	private void processBrokerMessageZusiFahrpult(Re420Service service, MessageMiddleware message) {
        String globalId = message.getGlobalId();
        String key = service.getMapZusi().getKey(globalId);
        delegateToEndpoint(service.getEndpoint(), service.getMapDigital(), service.getMapAnalog(), key, message.getParameter(), true);
	}

	private void processBrokerMessagePetrinetRe420(Re420Service service, MessageMiddleware message) {
		String globalId = message.getGlobalId();
		String key = service.getMapPetrinetRe420().getKey(globalId);
		delegateToEndpoint(service.getEndpoint(), service.getMapDigital(), service.getMapAnalog(), key, message.getParameter(), true);
	}

	private void processBrokerMessageManagement(Re420Service service, MessageMiddleware message) {
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
	public boolean isInitProcessMessage(MessageMiddleware element){
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
