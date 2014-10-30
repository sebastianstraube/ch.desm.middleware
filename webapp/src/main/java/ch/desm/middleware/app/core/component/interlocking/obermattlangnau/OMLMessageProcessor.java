package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import java.util.ArrayList;
import java.util.Map.Entry;

import ch.desm.middleware.app.core.communication.message.*;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorBase;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorUtil;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapInterlockingPetrinet;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.elements.OMLElementFahrstrassenSchalter;

public class OMLMessageProcessor extends MessageProcessorBase {

	private static Logger LOGGER = Logger.getLogger(OMLMessageProcessor.class);

	private OMLElementFahrstrassenSchalter fahrStrassenSchalter;

    public OMLMessageProcessor() {
		fahrStrassenSchalter = new OMLElementFahrstrassenSchalter();
	}

    /**
     * @param impl
     * @param messages
     */
    public void processBrokerMessage(OML impl, ArrayList<MessageMiddleware> messages, OMLMapInterlockingPetrinet mapPetrinet) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(impl, message, mapPetrinet);
        }
    }

    public void processBrokerMessage(OML impl, MessageMiddleware message, OMLMapInterlockingPetrinet mapPetrinet) {
        LOGGER.log(Level.TRACE, "OML processing Broker Message: " + message);

        if (MessageProcessorUtil.isSoftwareMessage(message.getOutputInput())) {

            if (message.getGlobalId().equalsIgnoreCase(
                    "mgmt.stellwerk.obermattlangnau")) {

                switch (message.getParameter()) {
                    case ("init"): {
                        //impl.getEndpoint().initialize();
                        //impl.getEndpoint().testDigitalMapSetAll("1");
                        break;
                    }
                    case ("start"): {
                        impl.getEndpoint().run();
                        //impl.getEndpoint().testDigitalMapSetAll("0");
                        break;
                    }
                    case ("stop"): {
                        impl.getEndpoint().interrupt();
                        break;
                    }
                }
            }
        }
        //is hardware message
        else{
            String parameter = util.getParameterValueMiddleware(message.getParameter());
            boolean isInput = message.getOutputInput().equals(
                    MessageUbw32Base.MESSAGE_CHAR_INPUT);

            //is mapped message from petrinet
            String omlKey = mapPetrinet.getValue(message.getGlobalId());
            if(!omlKey.isEmpty()){
                // is ubw digital message
                if (impl.getEndpoint().getMapDigital()
                        .isKeyAvailable(omlKey)) {

                    String endpointRegister = impl.getEndpoint()
                            .getMapDigital().getMap().get(omlKey);
                    String registerName = String
                            .valueOf(endpointRegister.charAt(0));
                    String pin = String.valueOf(endpointRegister.substring(1));

                    if (isInput) {
                        impl.getEndpoint().getPinInputDigital(registerName,
                                pin);
                    } else {
                        impl.getEndpoint().setPinOutputDigital(registerName,
                                pin, parameter);
                    }
                }
                // is ubw analog message
                else if (impl.getEndpoint().getMapAnalog()
                        .isKeyAvailable(omlKey)) {

                    String endpointRegister = impl.getEndpoint()
                            .getMapAnalog().getMap().get(omlKey);

                    if (isInput) {
                        impl.getEndpoint().getPinInputAnalog(endpointRegister);
                    }
                }
            }
        }
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
							LOGGER.error(e);
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
						LOGGER.error(e);
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
							LOGGER.error(e);
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
