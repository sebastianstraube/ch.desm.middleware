package ch.desm.middleware.module.automation;

import java.util.List;

import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32Message;
import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32MessageAnalog;
import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32MessageDigital;
import ch.desm.middleware.core.communication.message.BadParameterTypeCastException;
import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.component.ComponentMapBase;
import ch.desm.middleware.core.component.ComponentMessageProcessorUbw32Base;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class AutomationMessageProcessor extends ComponentMessageProcessorUbw32Base<AutomationService> {

	private static Logger LOGGER = Logger.getLogger(AutomationMessageProcessor.class);

	/**
	 * @param messages
	 */
	@Override
	public void processBrokerMessage(AutomationService service, List<MessageCommon> messages) {
		for(MessageCommon message : messages){
			processBrokerMessage(service, message);
		}
	}

	public void processEndpointMessage(AutomationService service, EndpointUbw32Message ubw32Message){
		final ComponentMapBase map;
		final String parameterValue;
		if (ubw32Message instanceof EndpointUbw32MessageAnalog) {
			map = service.getMapAnalog();
			parameterValue = String.valueOf(((EndpointUbw32MessageAnalog)ubw32Message).getRegisterValue());

		} else if (ubw32Message instanceof EndpointUbw32MessageDigital) {
			map = service.getMapDigital();
			Boolean pinValue = ((EndpointUbw32MessageDigital)ubw32Message).getRegisterValue();
			parameterValue = MessageCommon.mapBoolToOnOffParameter(pinValue);
		} else {
			throw new RuntimeException("uhm. unknown message!");
		}

		String pinName = ubw32Message.getRegister().name();
		String globalId = map.getKeyForValue(pinName);
		if(globalId.isEmpty()){
			LOGGER.log(Level.ERROR, String.format("mapping missing for message: %s", ubw32Message));
			return;
		}

		String middlewareMessage = service.getAutomationMapMiddleware().getValueForKey(globalId);
		middlewareMessage = middlewareMessage.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, parameterValue);

		processEndpointMessage(service.getBrokerClient(), middlewareMessage, MessageCommon.MESSAGE_TOPIC_AUTOMATION);
	}

	private void processBrokerMessage(AutomationService service, MessageCommon element){
		switch(element.getTopic()){
			case (MessageCommon.MESSAGE_TOPIC_MANAGEMENT):{
                processBrokerMessageManagement(service, element);
				break;
			}
		}
	}

	private void processBrokerMessageManagement(AutomationService service, MessageCommon message) {
		if (isInitProcessMessage(message)) {
			processInitEndpoint(service.getEndpoint(), message);
			return;
		}

		String globalId = message.getGlobalId();
		delegateToEndpoint(service.getEndpoint(), service.getMapDigital(), service.getMapAnalog(), globalId, message);
	}

	private void processInitEndpoint(AutomationEndpointUbw32 endpoint, MessageCommon element){
		final String parameter;
		try {
			parameter = element.getParameterAsString();
		} catch (BadParameterTypeCastException e) {
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

	//TODO REFACTORING isInitProcessMessage
	public boolean isInitProcessMessage(MessageCommon element){
		LOGGER.log(Level.WARN, "REFACTORING isInitProcessMessage");
		//if (element.getGlobalId().equalsIgnoreCase("")) return true;
		return false;
	}
}
