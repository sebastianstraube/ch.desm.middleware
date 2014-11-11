package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import java.util.LinkedList;
import java.util.Map.Entry;

import ch.desm.middleware.app.core.communication.message.*;
import ch.desm.middleware.app.core.component.ComponentMessageProcessor;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapInterlockingPetrinet;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.elements.OMLElementFahrstrassenSchalter;

public class OMLMessageProcessor extends ComponentMessageProcessor {

	private static Logger LOGGER = Logger.getLogger(OMLMessageProcessor.class);

	private OMLElementFahrstrassenSchalter fahrStrassenSchalter;
    private OMLMapInterlockingPetrinet map;

    public OMLMessageProcessor() {
		fahrStrassenSchalter = new OMLElementFahrstrassenSchalter();
        map = new OMLMapInterlockingPetrinet();
	}

    /**
     * @param endpoint
     * @param messages
     */
    public void processBrokerMessage(OMLEndpointUbw32 endpoint, LinkedList<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(endpoint, message);
        }
    }

    private void processBrokerMessage(OMLEndpointUbw32 endpoint, MessageMiddleware element){

        //incoming message with OML topic
        if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU)){
            try {
                String globalId = element.getGlobalId();
                String parameter = util.getParameterValueMiddleware(element.getParameter());
                boolean isInput = element.getOutputInput().equals(MessageUbw32Base.MESSAGE_CHAR_INPUT);

                String key = map.mapBrokerToEndpointMessage(globalId);
                delegateToEndpoint(endpoint, endpoint.getMapDigital(), endpoint.getMapAnalog(), key, parameter, isInput);
            } catch (Exception e) {
                //LOGGER.log(Level.WARN, e.getMessage());
            }
        }else if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_MANAGEMENT)){
            try {
                if (isInitProcessMessage(element)) {
                    if (element.getGlobalId().equalsIgnoreCase("mgmt.stellwerk.obermattlangnau")) {
                        processInitEndpoint(endpoint, element);
                    }
                }else{
                    throw new Exception("unsupported "+MessageBase.MESSAGE_TOPIC_MANAGEMENT+" message: " + element.toString());
                }
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }else if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU)){
            try {
                String globalId = element.getGlobalId();
                String parameter = util.getParameterValueMiddleware(element.getParameter());
                boolean isInput = element.getOutputInput().equals(MessageUbw32Base.MESSAGE_CHAR_INPUT);

                delegateToEndpoint(endpoint, endpoint.getMapDigital(), endpoint.getMapAnalog(), globalId, parameter, isInput);
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

    private void processInitEndpoint(OMLEndpointUbw32 endpoint, MessageMiddleware element){

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

	/**
	 * 
	 * @param impl
	 * @param message
	 * @return
	 */
	public String convertToMiddlewareMessage(OML impl,
			MessageUbw32Base message) {

		String middlewareMessagesInput = "";

		if (message instanceof MessageUbw32DigitalRegisterSingle) {

			for (Entry<String, String> entry : impl.getEndpoint().getMapDigital()
					.getMap().entrySet()) {

				if (entry.getValue()
						.equals(((MessageUbw32DigitalRegisterSingle) message)
								.getPort())) {

					String key = entry.getKey();
					String parameter = ((MessageUbw32DigitalRegisterSingle) message)
							.isEnabled() == true ? "on" : "off";

					String stream = null;

					stream = impl.getMapMiddlewareMessages().get(key);

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

					stream = stream.replaceAll(
							MessageCommon.PARAMETER_PLACEHOLDER, parameter);
					middlewareMessagesInput = middlewareMessagesInput
							.concat(stream);

				}
			}
		}

		else if (message instanceof MessageUbw32DigitalRegisterComplete) {

			for (Entry<String, String> entry : impl.getEndpoint().getMapDigital()
					.getMap().entrySet()) {

				// convert input to common parameter
				boolean isInputEnabled = message.getInputValue(
						entry.getValue().substring(0),
						entry.getValue().substring(1)).contains("1");
				String parameter = isInputEnabled == true ? "on" : "off";
				String key = entry.getKey();

				String stream = null;

				stream = impl.getMapMiddlewareMessages().get(key);

				if (stream == null) {
					try {
						throw new Exception(
								"mapping error found no global id in middleware message with key: "
										+ entry.getKey() + " and value: "
										+ entry.getValue() + " in message: "
										+ message);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						LOGGER.log(Level.ERROR, e);
					}
				}else{
					
					stream = stream.replaceAll(MessageCommon.PARAMETER_PLACEHOLDER,
							parameter);

					middlewareMessagesInput = middlewareMessagesInput
							.concat(stream);
				}
			}

		} else if (message instanceof MessageUbw32Analog) {

			for (Entry<String, String> entry : impl.getEndpoint().getMapAnalog()
					.getMap().entrySet()) {

				String key = entry.getKey();

				if (!key.isEmpty()) {
					String stream = impl.getMapMiddlewareMessages().get(key);

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
					String parameter = message.getInputValue(entry.getValue(),
							"");

					// handle Fahrstrassenschalter (FSS)
					String globalIdFSS = fahrStrassenSchalter
							.getglobalId(Integer.valueOf(parameter));

					if (!globalIdFSS.isEmpty()) {
						stream = fahrStrassenSchalter.getStream(parameter);
						stream = stream.replaceAll(
								MessageCommon.PARAMETER_PLACEHOLDER, parameter);
						middlewareMessagesInput = middlewareMessagesInput
								.concat(stream);

					} else {
						stream = stream.replaceAll(
								MessageCommon.PARAMETER_PLACEHOLDER, parameter);
					}

					middlewareMessagesInput = middlewareMessagesInput
							.concat(stream);
				}
			}
		}

		LOGGER.log(Level.TRACE,"processing middleware message: " + middlewareMessagesInput);

		return middlewareMessagesInput;
	}
}
