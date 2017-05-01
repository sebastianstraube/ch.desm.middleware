package sebastianstraube.connectx.module.desm.interlocking.obermatt;

import java.util.List;
import java.util.NoSuchElementException;

import sebastianstraube.connectx.core.communication.endpoint.ubw32.EndpointUbw32Message;
import sebastianstraube.connectx.core.communication.endpoint.ubw32.EndpointUbw32MessageAnalog;
import sebastianstraube.connectx.core.communication.endpoint.ubw32.EndpointUbw32MessageDigital;
import sebastianstraube.connectx.core.communication.endpoint.ubw32.EndpointUbw32Register;
import sebastianstraube.connectx.core.communication.message.BadParameterTypeCastException;
import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorUbw32Base;
import sebastianstraube.connectx.module.desm.interlocking.obermatt.map.OmMapUbw32Digital;
import sebastianstraube.connectx.module.desm.interlocking.obermatt.map.OmMapUbw32Analog;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import sebastianstraube.connectx.module.desm.interlocking.obermatt.logic.OmLogicFahrstrassenSchalter;

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

    //TODO CHECK hard coding
    private void processBrokerMessageManagement(OmService service, MessageCommon element) {
         if(initEndpoint(service, element)) return;
    }

    @Override
    protected boolean initEndpoint(OmService service, MessageCommon element){

        //TODO CHECK hard coding
        //if init message skip message processing
        if (!element.getGlobalId().equals("mgmt.stellwerk.obermattlangnau")) return false;
        if(element.getType().equals(MessageCommon.ParameterType.STRING)){
            final String parameter;
            try {
                parameter = element.getParameterAsString();
            } catch (BadParameterTypeCastException e) {
                LOGGER.log(Level.ERROR, "Received init message with type " + element.getTypeName() + " but expected String");
                return false;
            }

            switch (parameter) {
                case ("init"): {
                    service.getEndpoint().init();
                    return true;
                }
                case ("start"): {
                    service.getEndpoint().start();
                    return true;
                }
                case ("stop"): {
                    service.getEndpoint().stop();
                    return true;
                }
            }
        }

        return false;
    }

    public void processEndpointMessage(OmService service, EndpointUbw32Message ubw32Message) {
        final String pinName = ubw32Message.getRegister().name();

        final String globalId;
        final String parameterValue;
        if (ubw32Message instanceof EndpointUbw32MessageAnalog) {

            //Fahrstrassenschalter impl
            //TODO register should be configurable
            if (ubw32Message.getRegister() == EndpointUbw32Register.B0) {
                Double pinValue = ((EndpointUbw32MessageAnalog) ubw32Message).getRegisterValue();
                String enabledGlobalId = fahrStrassenSchalter.getEnabledGlobalId(pinValue);
                if (enabledGlobalId == null) {
                    throw new RuntimeException("fahrStrassenSchalter.getEnabledGlobalId(pinValue);" + "register: B0" + "pinValue :" + pinValue + "pinValue :" + pinName);
                }
                List<String> disabledGlobalIdList = fahrStrassenSchalter.getDisabledGlobalIdList(enabledGlobalId);
                disabledGlobalIdList.stream().forEach(s-> sendEndpointMessage(service,s, MessageCommon.MESSAGE_PARAMETER_OFF));
                sendEndpointMessage(service, enabledGlobalId, MessageCommon.MESSAGE_PARAMETER_ON);
                // TODO: emit bool message with parameter set to off for all other fahrstrassenschalter stellungen
            } else {
                // TODO: check whether it works!
                globalId = mapAnalog.getKeyForValue(ubw32Message.getRegister().toString());
                if (globalId == null) {
                    throw new RuntimeException("mapAnalog.getKeyForValue(ubw32Message.getRegister().toString());" + pinName);
                }
                parameterValue = String.valueOf(((EndpointUbw32MessageAnalog) ubw32Message).getRegisterValue());
                sendEndpointMessage(service, globalId, parameterValue);
            }
        } else if (ubw32Message instanceof EndpointUbw32MessageDigital) {
            globalId = mapDigital.getKeyForValue(pinName);
            if (globalId == null) {
                throw new RuntimeException("mapDigital.getKeyForValue(pinName)" + pinName);
            }
            Boolean pinValue = ((EndpointUbw32MessageDigital) ubw32Message).getRegisterValue();
            parameterValue = MessageCommon.mapBoolToOnOffParameter(pinValue);
            sendEndpointMessage(service, globalId, parameterValue);
        } else {
            throw new RuntimeException("uhm. unknown message!");
        }
    }

    private void sendEndpointMessage(OmService service, String globalId, String parameterValue){
        String middlewareMessage = service.getComponentMapMiddleware().getValueForKey(globalId);
        middlewareMessage = middlewareMessage.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, parameterValue);
        processEndpointMessage(service.getBrokerClient(), middlewareMessage, MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT);

    }

}
