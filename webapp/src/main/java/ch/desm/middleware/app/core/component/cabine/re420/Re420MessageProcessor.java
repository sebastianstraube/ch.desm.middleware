package ch.desm.middleware.app.core.component.cabine.re420;

import java.util.ArrayList;
import java.util.Map.Entry;

import ch.desm.middleware.app.core.communication.message.*;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorBase;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ch.desm.middleware.app.core.component.cabine.re420.elements.Re420ElementFahrschalter;
import ch.desm.middleware.app.core.component.cabine.re420.maps.Re420MapBinding;
import ch.desm.middleware.app.core.component.cabine.re420.maps.Re420MapFabischValue;

public class Re420MessageProcessor extends MessageProcessorBase {

	private static Logger LOGGER = Logger.getLogger(Re420MessageProcessor.class);

	private Re420ElementFahrschalter fahrschalter;
	private Re420MapBinding binding;
	private Re420MapFabischValue mapValues;
    private MessageProcessorUtil util;

	public Re420MessageProcessor() {
		fahrschalter = new Re420ElementFahrschalter();
		binding = new Re420MapBinding();
		mapValues = new Re420MapFabischValue();
        this.util = new MessageProcessorUtil();
	}

	public String handleMessageFahrschalter(String key, boolean isEnabled) {

		String fahrschalterKey = fahrschalter.getMessagePositionFahrschalter(
				key, isEnabled);

		return fahrschalterKey;
	}

	/**
	 * 
	 * @param impl
	 * @param message
	 * @return
	 */
	public String convertToMiddlewareMessage(Re420 impl,
			MessageUbw32Base message) {

		String middlewareMessagesInput = "";

		if (message instanceof MessageUbw32DigitalRegisterSingle) {

			for (Entry<String, String> entry : impl.getEndpointUbw32().re420MapDigital
					.getMap().entrySet()) {

				if (entry.getValue()
						.equals(((MessageUbw32DigitalRegisterSingle) message)
								.getPort())) {

					String key = entry.getKey();
					boolean isInputEnabled = message.getInputValue(
							entry.getValue().substring(0),
							entry.getValue().substring(1)).contains("1");
					String parameter = ((MessageUbw32DigitalRegisterSingle) message)
							.isEnabled() == true ? "on" : "off";
					
					String stream = null;

					// handle Fahrschalter
					if (fahrschalter.keyListFahrschalter.contains(key)) {

						String fahrschalterKey = fahrschalter
								.getMessagePositionFahrschalter(key,
										isInputEnabled);

						if (!fahrschalterKey.isEmpty()) {
							parameter = "on";
							stream = fahrschalter.getMap().getValue(fahrschalterKey);
							stream = stream.replaceAll(
									MessageCommon.PARAMETER_PLACEHOLDER,
									parameter);
							middlewareMessagesInput = middlewareMessagesInput
									.concat(stream);
						}

					}

					else {
						stream = impl.getMapMiddlewareMessages().get(key);
						
						if (stream == null) {
							try {
								throw new Exception(
										"mapping error found no global id in middleware message with key: "
												+ entry.getKey()
												+ " and value: "
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
		}

		else if (message instanceof MessageUbw32DigitalRegisterComplete) {

			for (Entry<String, String> entry : impl.getEndpointUbw32().re420MapDigital
					.getMap().entrySet()) {

				// convert input to common parameter
				boolean isInputEnabled = message.getInputValue(
						entry.getValue().substring(0),
						entry.getValue().substring(1)).contains("1");
				String parameter = isInputEnabled == true ? "on" : "off";
				String key = entry.getKey();

				String stream = null;

				// handle Fahrschalter
				if (fahrschalter.keyListFahrschalter.contains(key)) {

					String fahrschalterKey = fahrschalter
							.getMessagePositionFahrschalter(key, isInputEnabled);

					if (!fahrschalterKey.isEmpty()) {
						parameter = "on";
						stream = fahrschalter.getMap().getValue(fahrschalterKey);
						stream = stream.replaceAll(
								MessageCommon.PARAMETER_PLACEHOLDER, parameter);
						middlewareMessagesInput = middlewareMessagesInput
								.concat(stream);
					}

				} else {

					// lookup for binding key to send directly
					if (binding.isKeyAvailable(entry.getKey())) {
						key = binding.getValue(entry.getKey());

						
						parameter = message.getInputValue(entry.getValue()
								.substring(0), entry.getValue().substring(1));
						
						String value = impl.getEndpointFabisch().mapDigital.getValue(key);

						if (!value.isEmpty()) {
							
							parameter = convertParameter(value, parameter);
							
							impl.getEndpointFabisch().sendStream(
									value + parameter);
						}
					} else {

						stream = impl.getMapMiddlewareMessages().get(key);
						
						if (stream == null) {
							try {
								throw new Exception(
										"mapping error found no global id in middleware message with key: "
												+ entry.getKey()
												+ " and value: "
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

		} else if (message instanceof MessageUbw32Analog) {

			for (Entry<String, String> entry : impl.getEndpointUbw32().re420MapAnalog
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

					stream = stream.replaceAll(
							MessageCommon.PARAMETER_PLACEHOLDER, parameter);
					middlewareMessagesInput = middlewareMessagesInput
							.concat(stream);
				}
			}
		}

		LOGGER.log(Level.TRACE,"processing middleware message: " + middlewareMessagesInput);

		return middlewareMessagesInput;
	}
	
	private String convertParameter(String channelKey, String parameter) {

		if (mapValues.getMap().containsKey(channelKey)) {

			for (Entry<String, String> element : mapValues.getMap().entrySet()) {
				if (element.getKey().equals(channelKey)) {
					// has values
					if (!element.getValue().isEmpty()) {

						// has switch elements
						if (element.getValue().contains("#")) {
							if (parameter.equals("0")) {
								// set off value as new parameter
								parameter = element.getValue().split("#")[0];
								break;
							} else if (parameter.equals("1")) {
								// set on value as new parameter
								parameter = element.getValue().split("#")[1];
								break;
							}
						}
					}
				}
			}
		}

		return parameter;

	}

    public void processBrokerMessage(Re420 impl, ArrayList<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            this.processBrokerMessage(impl, message);
        }
    }
    /**
     * @param impl
     * @param message
     */
    public void processBrokerMessage(Re420 impl, MessageMiddleware message) {

        // is fabisch endpoint digital message
        if (impl.getEndpointFabisch().getMapDigital()
                .isKeyAvailable(message.getGlobalId())) {

            String channel = impl.getEndpointFabisch().getMapDigital()
                    .getValue(message.getGlobalId());
            String data = message.getParameter();

            data = util.convertParameter(channel, data);

            impl.getEndpointFabisch().sendStream(channel + data);

            // is fabisch endpoint analog message
        } else if (impl.getEndpointFabisch().getMapAnalog()
                .isKeyAvailable(message.getGlobalId())) {
            String channel = impl.getEndpointFabisch().getMapAnalog()
                    .getValue(message.getGlobalId());
            String data = message.getParameter();

            // TODO convert from locsim values to fabisch values

            impl.getEndpointFabisch().sendStream(channel + data);
        }

        // is software message
        else if (MessageProcessorUtil.isSoftwareMessage(message.getOutputInput())) {

            if (message.getGlobalId().equalsIgnoreCase(
                    "locsim.initialization.ready.ini1")
                    && !util.init1) {
                impl.getEndpointUbw32().setCacheEnabled(false);
                impl.getEndpointUbw32().start();
                util.init1 = true;
            }

            else if (message.getGlobalId().equalsIgnoreCase(
                    "locsim.initialization.ready.ini2")) {
                // nothing to do
            }

            else if (message.getGlobalId().equalsIgnoreCase(
                    "locsim.initialization.ready.ini7")) {
                impl.getEndpointUbw32().pollingCommand();
                impl.getEndpointUbw32().setCacheEnabled(false);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    LOGGER.log(Level.ERROR, e);
                }
                impl.getEndpointUbw32().setCacheEnabled(true);
            }

            else if (message.getGlobalId().equalsIgnoreCase(
                    "locsim.initialization.ready.ini8")) {
                // nothing to do
            }

            else if (message.getGlobalId().equalsIgnoreCase(
                    "mgmt.cabine.re420.fabisch")) {

                switch (message.getParameter()) {
                    case ("init"): {
                        impl.getEndpointFabisch().init();
                        break;
                    }
                    case ("start"): {
                        //nothing to do
                        break;
                    }
                    case ("stop"): {
                        //nothing to do
                        break;
                    }
                }
            }

            else if (message.getGlobalId().equalsIgnoreCase(
                    "mgmt.cabine.re420.ubw32")) {

                switch (message.getParameter()) {
                    case ("init"): {
                        impl.getEndpointUbw32().init();
                        break;
                    }
                    case ("start"): {
                        impl.getEndpointUbw32().start();
                        break;
                    }
                    case ("stop"): {
                        impl.getEndpointUbw32().stop();
                        break;
                    }
                }
            }

            // is hardware message
        } else {

            String value = util.getParameterValueRe420(message.getParameter());
            boolean isInput = message.getOutputInput().equals(
                    MessageUbw32Base.MESSAGE_CHAR_INPUT);

            // is ubw message
            if (impl.getEndpointUbw32().getMapDigital()
                    .isKeyAvailable(message.getGlobalId())) {

                String endpointRegister = impl.getEndpointUbw32()
                        .getMapDigital().getMap().get(message.getGlobalId());
                String registerName = String
                        .valueOf(endpointRegister.charAt(0));
                String pin = String.valueOf(endpointRegister.substring(1));

                if (isInput) {
                    impl.getEndpointUbw32().getPinInputDigital(registerName,
                            pin);
                } else {
                    impl.getEndpointUbw32().setPinOutputDigital(registerName,
                            pin, value);
                }

                // is analog message
            } else if (impl.getEndpointUbw32().getMapAnalog()
                    .isKeyAvailable(message.getGlobalId())) {

                String endpointRegister = impl.getEndpointUbw32()
                        .getMapAnalog().getMap().get(message.getGlobalId());

                if (isInput) {
                    impl.getEndpointUbw32().getPinInputAnalog(endpointRegister);
                }

            } else {
                LOGGER.log(Level.WARN, impl.getClass() + "> processBrokerMessage skipped:"
                        + message);
            }
        }
    }
}
