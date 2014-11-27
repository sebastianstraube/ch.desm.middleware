package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import java.util.LinkedList;
import java.util.Map.Entry;

import ch.desm.middleware.app.core.communication.message.*;
import ch.desm.middleware.app.core.component.ComponentMessageProcessor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.elements.OMLElementFahrstrassenSchalter;

public class OmlMessageProcessor extends ComponentMessageProcessor {

	private static Logger LOGGER = Logger.getLogger(OmlMessageProcessor.class);

	private OMLElementFahrstrassenSchalter fahrStrassenSchalter;
    private OmlService service;

    public OmlMessageProcessor(OmlService service) {
		this.fahrStrassenSchalter = new OMLElementFahrstrassenSchalter();

        this.service = service;
	}

    /**
     * @param messages
     */
    public void processBrokerMessage(OmlService service, LinkedList<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(service, message);
        }
    }

    private void processBrokerMessage(OmlService service, MessageMiddleware element){

        //incoming message with OML topic
        if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU)){
            try {
                String globalId = element.getGlobalId();
                String parameter = util.getParameterValueEndpoint(element.getParameter());
                boolean isInput = element.getOutputInput().equals(MessageUbw32Base.MESSAGE_CHAR_INPUT);

                String key = service.getMap().mapBrokerToEndpointMessage(globalId);
                delegateToEndpoint(service.getEndpoint(), service.getEndpoint().getMapDigital(),  service.getEndpoint().getMapAnalog(), key, parameter, isInput);
            } catch (Exception e) {
                //LOGGER.log(Level.WARN, e.getMessage());
            }
        }else if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_MANAGEMENT)){
            try {
                if (isInitProcessMessage(element)) {
                    if (element.getGlobalId().equalsIgnoreCase("mgmt.stellwerk.obermattlangnau")) {
                        processInitEndpoint(service.getEndpoint(), element);
                    }
                }else{

                    // Todo implementation
                    // activate this, when gui taken controle over this endpoint
                }
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }else if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU)){
            try {
                String globalId = element.getGlobalId();
                String parameter = util.getParameterValueEndpoint(element.getParameter());
                boolean isInput = element.getOutputInput().equals(MessageUbw32Base.MESSAGE_CHAR_INPUT);

                delegateToEndpoint(service.getEndpoint(), service.getEndpoint().getMapDigital(), service.getEndpoint().getMapAnalog(), globalId, parameter, isInput);
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }else{
            try {
                throw new Exception("unsupported topic, broker message delegation skipped: " + element.toString());
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }

    private void processInitEndpoint(OmlEndpointUbw32 endpoint, MessageMiddleware element){

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

    //TODO refactoring
    public boolean isInitProcessMessage(MessageMiddleware element){

        if (element.getGlobalId().equalsIgnoreCase("mgmt.stellwerk.obermattlangnau")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.petrinet.obermatlangnau")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.cabine.re420.fabisch")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.cabine.re420.ubw32")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.simulation.locsim.rs232")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.simulation.locsim.dll")) {
            return true;
        }

        return false;
    }

    private String getUbwSingleRegisterValues(OmlEndpointUbw32 endpoint, MessageUbw32DigitalRegisterSingle message) {

        String messageInput = "";

        for (Entry<String, String> entry : endpoint.getMapDigital()
                .getMap().entrySet()) {

            if (entry.getValue()
                    .equals(((MessageUbw32DigitalRegisterSingle) message)
                            .getPort())) {

                String key = entry.getKey();

                boolean isEnabled = ((MessageUbw32DigitalRegisterSingle) message).isEnabled();
                String parameter = isEnabled == true ? "on" : "off";

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
                stream = stream.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, parameter);
                messageInput = messageInput.concat(stream);
            }
        }

        return messageInput;

    }

    private String getUbwAllRegisterValues(OmlEndpointUbw32 endpoint, MessageUbw32DigitalRegisterComplete message){

        String messageInput = "";

        for (Entry<String, String> entry : endpoint.getMapDigital()
                .getMap().entrySet()) {

            // convert input to common parameter
            boolean isEnabled = message.getInputValue(entry.getValue().substring(0),entry.getValue().substring(1)).contains("1");
            String parameter = isEnabled == true ? "on" : "off";
            String key = entry.getKey();

            if(service.getCache().isStateChanged(key, parameter)){

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

                stream = stream.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, parameter);
                messageInput = messageInput.concat(stream);
            }
        }
        return messageInput;
    }

    private String getUbwAnalogRegisterValues(OmlEndpointUbw32 endpoint, MessageUbw32Analog message){

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
                    stream = stream.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, MessageCommon.MESSAGE_PARAMETER_ON);

                    LOGGER.log(Level.INFO, "FSS enabled contact: " + stream);

                }else{
                    stream = stream.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, MessageCommon.MESSAGE_PARAMETER_OFF);
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
	public String convertToMiddlewareMessage(OmlEndpointUbw32 endpoint,
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
