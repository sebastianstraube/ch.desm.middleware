package ch.desm.middleware.module.obermatt;

import java.util.List;
import java.util.NoSuchElementException;

import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32Message;
import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32MessageAnalog;
import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32MessageDigital;
import ch.desm.middleware.core.communication.message.BadParameterTypeCastException;
import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.component.ComponentMessageProcessorUbw32Base;
import ch.desm.middleware.module.obermatt.map.OmMapUbw32Analog;
import ch.desm.middleware.module.obermatt.map.OmMapUbw32Digital;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ch.desm.middleware.module.obermatt.logic.OmLogicFahrstrassenSchalter;

public class OmMessageProcessor extends ComponentMessageProcessorUbw32Base<OmService> {

	private static Logger LOGGER = Logger.getLogger(OmMessageProcessor.class);

	private OmLogicFahrstrassenSchalter fahrStrassenSchalter = new OmLogicFahrstrassenSchalter();
    private OmMapUbw32Digital mapDigital = new OmMapUbw32Digital();
    private OmMapUbw32Analog mapAnalog = new OmMapUbw32Analog();

    /**
     * @param messages
     */
    public void processBrokerMessage(OmService service, List<MessageCommon> messages) {
        for(MessageCommon message : messages){
            processBrokerMessage(service, message);
        }
    }

    private void processBrokerMessage(OmService service, MessageCommon element){
        switch(element.getTopic()) {
            case MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT:
                processBrokerMessagePetrinetObermatt(service, element);
                break;
            case MessageCommon.MESSAGE_TOPIC_MANAGEMENT:
                processBrokerMessageManagement(service, element);
                break;
            default:
                LOGGER.log(Level.WARN, "unsupported topic, broker message delegation skipped: " + element.toString());
        }
    }

    private void processBrokerMessagePetrinetObermatt(OmService service, MessageCommon element) {
        try {
            final String globalId = element.getGlobalId();
            final String key = service.getMapPetrinet().mapBrokerToEndpointMessage(globalId);

            delegateToEndpoint(service.getEndpoint(), mapDigital, mapAnalog, key, element);
        } catch (NoSuchElementException e) {
            //LOGGER.log(Level.WARN, e.getMessage());
        }
    }

    private void processBrokerMessageManagement(OmService service, MessageCommon element) {
        if (isInitProcessMessage(element)) {
            processInitEndpoint(service.getEndpoint(), element);
            return;
        }
    }

    private void processInitEndpoint(OmEndpointUbw32 endpoint, MessageCommon element){

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
        if (element.getGlobalId().equalsIgnoreCase("mgmt.stellwerk.obermattlangnau")) return true;
        return false;
    }

    public void processEndpointMessage(OmService service, EndpointUbw32Message ubw32Message) {
        final String pinName = ubw32Message.getRegister().name();

        final String globalId;
        final String parameterValue;
        if (ubw32Message instanceof EndpointUbw32MessageAnalog) {
            // TODO: remove hard coded fahrstrassenschalter logic
            Double pinValue = ((EndpointUbw32MessageAnalog) ubw32Message).getRegisterValue();
            globalId = fahrStrassenSchalter.getglobalId(pinValue);
            parameterValue = String.valueOf(((EndpointUbw32MessageAnalog) ubw32Message).getRegisterValue());
        } else if (ubw32Message instanceof EndpointUbw32MessageDigital) {
            globalId = mapDigital.getKeyForValue(pinName);
            Boolean pinValue = ((EndpointUbw32MessageDigital) ubw32Message).getRegisterValue();
            parameterValue = MessageCommon.mapBoolToOnOffParameter(pinValue);
        } else {
            throw new RuntimeException("uhm. unknown message!");
        }

        String middlewareMessage = service.getComponentMapMiddleware().getValueForKey(globalId);
        middlewareMessage = middlewareMessage.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, parameterValue);

        processEndpointMessage(service.getBrokerClient(), middlewareMessage, MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT);
    }

}
