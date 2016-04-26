package ch.desm.middleware.app.module.obermatt;

import java.util.List;
import java.util.Map.Entry;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Analog;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterComplete;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterSingle;
import ch.desm.middleware.app.core.component.ComponentMessageProcessorBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ch.desm.middleware.app.module.obermatt.logic.OmLogicFahrstrassenSchalter;

public class OmMessageProcessor extends ComponentMessageProcessorBase<OmService> {

	private static Logger LOGGER = Logger.getLogger(OmMessageProcessor.class);

	private OmLogicFahrstrassenSchalter fahrStrassenSchalter;
    private OmService service;

    public OmMessageProcessor(OmService service) {
		this.fahrStrassenSchalter = new OmLogicFahrstrassenSchalter();
        this.service = service;
	}

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
            case MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT:
                processBrokerMessagePetrinetObermatt(service, element);
                break;
            case MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT:
                processBrokerMessageInterlockingObermatt(service, element);
                break;
            case MessageBase.MESSAGE_TOPIC_MANAGEMENT:
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
            final boolean isInput = element.isInputMessage();

            delegateToEndpoint(service.getEndpoint(), service.getEndpoint().getMapDigital(), service.getEndpoint().getMapAnalog(), key, element, isInput);
        } catch (Exception e) {
            //LOGGER.log(Level.WARN, e.getMessage());
        }
    }

    private void processBrokerMessageInterlockingObermatt(OmService service, MessageCommon element) {
        try {
            final String globalId = element.getGlobalId();
            // TODO: no mapping required here?
            //final String key = service.getMapPetrinet().mapBrokerToEndpointMessage(globalId);
            final boolean isInput = element.isInputMessage();

            delegateToEndpoint(service.getEndpoint(), service.getEndpoint().getMapDigital(), service.getEndpoint().getMapAnalog(), globalId, element, isInput);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    private void processBrokerMessageManagement(OmService service, MessageCommon element) {
        if (isInitProcessMessage(element)) {
            processInitEndpoint(service.getEndpoint(), element);
            return;
        }

        try {
            // Todo implementation
            // activate this, when gui taken controle over this endpoint
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    private void processInitEndpoint(OmEndpointUbw32 endpoint, MessageCommon element){

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

    //TODO refactoring
    public boolean isInitProcessMessage(MessageCommon element){
        if (element.getGlobalId().equalsIgnoreCase("mgmt.stellwerk.obermattlangnau")) return true;
        return false;
    }

    private String getUbwSingleRegisterValues(OmEndpointUbw32 endpoint, MessageUbw32DigitalRegisterSingle message) {

        String messageInput = "";

        for (Entry<String, String> entry : endpoint.getMapDigital()
                .getMap().entrySet()) {

            if (entry.getValue()
                    .equals(((MessageUbw32DigitalRegisterSingle) message)
                            .getPort())) {

                String key = entry.getKey();

                boolean isEnabled = ((MessageUbw32DigitalRegisterSingle) message).isEnabled();
                String parameter = isEnabled ? MessageBase.MESSAGE_PARAMETER_ON : MessageBase.MESSAGE_PARAMETER_OFF;

                if (isEnabled) {
                    LOGGER.log(Level.INFO, "key: " + key);
                }

                String stream = null;

                stream = service.getComponentMapMiddleware().getMap().get(key);

                if (stream == null) {
                    try {
                        throw new Exception(
                                "mapping error no global id in middleware message with key: "
                                        + entry.getKey() + " and value: "
                                        + entry.getValue()
                                        + " in message: " + message);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        LOGGER.log(Level.ERROR, e);
                    }
                }
                stream = stream.replace(MessageBase.MESSAGE_PARAMETER_PLACEHOLDER, parameter);
                messageInput = messageInput.concat(stream);
            }
        }

        return messageInput;

    }

    private String getUbwAllRegisterValues(OmEndpointUbw32 endpoint, MessageUbw32DigitalRegisterComplete message){

        String messageInput = "";

        for (Entry<String, String> entry : endpoint.getMapDigital()
                .getMap().entrySet()) {

            // convert input to common parameter
            boolean isEnabled = message.getInputValue(entry.getValue().substring(0),entry.getValue().substring(1)).contains("1");
            String parameter = isEnabled ? MessageBase.MESSAGE_PARAMETER_ON : MessageBase.MESSAGE_PARAMETER_OFF;
            String key = entry.getKey();

            if(service.getEndpoint().getState().hasChanged(key, parameter)){

                //find the middleware message of the changed key
                String stream =  service.getComponentMapMiddleware().getValue(key);

                if (stream == null) {
                    try {
                        throw new Exception(
                                "mapping error no global id in middleware message with key: "
                                        + entry.getKey() + " and value: "
                                        + entry.getValue()
                                        + " in message: " + message);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        LOGGER.log(Level.ERROR, e);
                    }
                }

                stream = stream.replace(MessageBase.MESSAGE_PARAMETER_PLACEHOLDER, parameter);
                messageInput = messageInput.concat(stream);
            }
        }
        return messageInput;
    }

    private String getUbwAnalogRegisterValues(OmEndpointUbw32 endpoint, MessageUbw32Analog message){

        String messageInput = "";

        for (Entry<String, String> entry : endpoint.getMapAnalog()
                .getMap().entrySet()) {

            String key = entry.getKey();

            if (!key.isEmpty()) {
                String stream = service.getComponentMapMiddleware().getMap().get(key);

                if (stream == null) {
                    try {
                        throw new Exception(
                                "mapping error found no global id in middleware message with key: "
                                        + entry.getKey() + " and value: "
                                        + entry.getValue()
                                        + " in message: " + message);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        LOGGER.log(Level.ERROR, e);
                    }
                }

                // convert input to common parameter
                String parameter = message.getInputValue(entry.getValue(),"");
                // handle Fahrstrassenschalter (FSS)
                String FSSidEnabled = fahrStrassenSchalter.getglobalId(Integer.valueOf(parameter));

                if(key.equals(FSSidEnabled)){
                    stream = stream.replace(MessageBase.MESSAGE_PARAMETER_PLACEHOLDER, MessageBase.MESSAGE_PARAMETER_ON);

                    LOGGER.log(Level.INFO, "FSS enabled contact: " + stream);

                }else{
                    stream = stream.replace(MessageBase.MESSAGE_PARAMETER_PLACEHOLDER, MessageBase.MESSAGE_PARAMETER_OFF);
                }
                messageInput = messageInput.concat(stream);
            }
        }

        return messageInput;
    }


	/**
	 *
	 * @param endpoint
	 * @param message
	 * @return
	 */
	public String convertToMiddlewareMessage(OmEndpointUbw32 endpoint,
			MessageUbw32Base message) {

		String middlewareMessagesInput = "";

		if (message instanceof MessageUbw32DigitalRegisterSingle) {

            middlewareMessagesInput = getUbwSingleRegisterValues(endpoint, (MessageUbw32DigitalRegisterSingle)message);

		}

		else if (message instanceof MessageUbw32DigitalRegisterComplete) {

            middlewareMessagesInput = getUbwAllRegisterValues(endpoint, (MessageUbw32DigitalRegisterComplete)message);

		} else if (message instanceof MessageUbw32Analog) {

            middlewareMessagesInput = getUbwAnalogRegisterValues(endpoint, (MessageUbw32Analog)message);

		}

		LOGGER.log(Level.TRACE,"processing middleware message: " + middlewareMessagesInput);

		return middlewareMessagesInput;
	}
}
