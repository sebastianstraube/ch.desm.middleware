package ch.desm.middleware.module.desm.cabine.re420;

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

public class Re420MessageProcessor extends ComponentMessageProcessorUbw32Base<Re420Service> {

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

	public void processEndpointMessage(Re420Service service, EndpointUbw32Message ubw32Message){
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
		String middlewareMessage = service.getComponentMapMiddleware().getValueForKey(globalId);
		middlewareMessage = middlewareMessage.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, parameterValue);

		processEndpointMessage(service.getBrokerClient(), middlewareMessage, MessageCommon.MESSAGE_TOPIC_CABINE_RE420);
	}

	private void processBrokerMessage(Re420Service service, MessageCommon element){
		switch(element.getTopic()){
			case (MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT):{
				processBrokerMessageZusiFahrpult(service, element);
				break;
			}
			case (MessageCommon.MESSAGE_TOPIC_PETRINET_CABINE_RE420):{
				processBrokerMessagePetrinetRe420(service, element);
				break;
			}
			case (MessageCommon.MESSAGE_TOPIC_MANAGEMENT):{
                processBrokerMessageManagement(service, element);
				break;
			}
		}
	}

	private void processBrokerMessageZusiFahrpult(Re420Service service, MessageCommon message) {
		String globalId = message.getGlobalId();
		String key = service.getMapZusi().getKeyForValue(globalId);
		delegateToEndpoint(service.getEndpoint(), service.getMapDigital(), service.getMapAnalog(), key, message);
	}

	private void processBrokerMessagePetrinetRe420(Re420Service service, MessageCommon message) {
		String globalId = message.getGlobalId();
		String key = service.getMapPetrinetRe420().getKeyForValue(globalId);
		delegateToEndpoint(service.getEndpoint(), service.getMapDigital(), service.getMapAnalog(), key, message);
	}

	private void processBrokerMessageManagement(Re420Service service, MessageCommon message) {
		if (isInitProcessMessage(message)) {
			processInitEndpoint(service.getEndpoint(), message);
		}
	}

	private void processInitEndpoint(Re420EndpointUbw32 endpoint, MessageCommon element){
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

	//TODO refactoring
	public boolean isInitProcessMessage(MessageCommon element){
		if (element.getGlobalId().equalsIgnoreCase("management.cabine.re420.ubw32")) return true;
		return false;
	}
}
