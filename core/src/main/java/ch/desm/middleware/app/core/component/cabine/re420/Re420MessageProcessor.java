package ch.desm.middleware.app.core.component.cabine.re420;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import ch.desm.middleware.app.common.ComponentMessageProcessorBase;
import ch.desm.middleware.app.core.communication.message.*;
import ch.desm.middleware.app.common.utility.UtilityMessageProcessor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ch.desm.middleware.app.core.component.cabine.re420.logic.Re420LogicFahrschalter;

public class Re420MessageProcessor extends ComponentMessageProcessorBase<Re420Service> {

	private static Logger LOGGER = Logger.getLogger(Re420MessageProcessor.class);
	private Re420LogicFahrschalter fahrschalter;

	public static final String INIT_MESSAGE = "mgmt.stellwerk.obermattlangnau";

	public Re420MessageProcessor() {
		this.fahrschalter = new Re420LogicFahrschalter();
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

	private void processBrokerMessageManagement(Re420Service service, MessageMiddleware message) {
		try {
			if (isInitProcessMessage(message)) {
				if (message.getGlobalId().equalsIgnoreCase(INIT_MESSAGE)) {
					processInitEndpoint(service.getEndpoint(), message);
				}
			} else {

				// Todo implementation
				// activate this, when gui taken controle over this endpoint
			}
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

	public boolean isInitProcessMessage(MessageMiddleware element){
		return element.getGlobalId().equalsIgnoreCase(INIT_MESSAGE);
	}

	/**
	 *
	 * @param message
	 * @return
	 */
	public String convertToMiddlewareMessage(Re420Service service, MessageUbw32Base message) {

		String middlewareMessagesInput = "";
		if (message instanceof MessageUbw32DigitalRegisterSingle) {
            middlewareMessagesInput = service.getEndpointMessageProcessor().getUbwSingleRegisterValues(service, service.getEndpoint(), (MessageUbw32DigitalRegisterSingle) message);
        }
		else if (message instanceof MessageUbw32DigitalRegisterComplete){
            middlewareMessagesInput = service.getEndpointMessageProcessor().getUbwAllRegisterValues(service, service.getEndpoint(), (MessageUbw32DigitalRegisterComplete) message);
        }
		else if (message instanceof MessageUbw32Analog){
            middlewareMessagesInput = service.getEndpointMessageProcessor().getUbwAnalogRegisterValues(service, service.getEndpoint(), (MessageUbw32Analog) message);
        }

		if(!middlewareMessagesInput.isEmpty() && ((message instanceof MessageUbw32DigitalRegisterSingle) ||
				(message instanceof MessageUbw32DigitalRegisterComplete))) middlewareMessagesInput += getFahrschalterMwms(service, middlewareMessagesInput);

		LOGGER.log(Level.TRACE,"processing middleware message: " + middlewareMessagesInput);
		return middlewareMessagesInput;
	}

    public String getFahrschalterMwms(Re420Service service, String message) {
		ArrayList<String> l = new ArrayList<>(Arrays.asList(message.split(MessageBase.MESSAGE_MESSAGE_CUT)));
		String mwMessages= "";

		for (String el : l){
            if(Re420LogicFahrschalter.UBW_KEYS.contains(el.split(MessageBase.MESSAGE_ELEMENT_CUT)[0])){
                MessageMiddleware mwm = service.getTranslator().toMiddlewareMessage(el);
                boolean isEnabled = mwm.getParameter().equalsIgnoreCase("on");
                String key = fahrschalter.getFahrschalterKey(service, mwm.getGlobalId(), isEnabled);
                mwMessages = service.getMapFahrschalterLogic().getValue(key);
                mwMessages = UtilityMessageProcessor.replaceMiddlewareMessageDelimiter(mwMessages, MessageBase.MESSAGE_PARAMETER_ON);
                break;
			}
		}
        return mwMessages;
    }
}
