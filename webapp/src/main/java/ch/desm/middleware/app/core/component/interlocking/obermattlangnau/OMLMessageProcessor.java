package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import java.util.Map.Entry;

import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Analog;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterComplete;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterSingle;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessor;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.elements.OMLElementFahrstrassenSchalter;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapMiddleware;

public class OMLMessageProcessor extends MessageProcessor {

	private static Logger LOGGER = Logger.getLogger(OMLMessageProcessor.class);

	private OMLElementFahrstrassenSchalter fahrStrassenSchalter;

	public OMLMessageProcessor() {
		fahrStrassenSchalter = new OMLElementFahrstrassenSchalter();
	}

	/**
	 * 
	 * @param impl
	 * @param message
	 * @param mapMiddlewareMessages
	 * @return
	 */
	public String convertToMiddlewareMessage(OML impl,
			MessageUbw32Base message, OMLMapMiddleware mapMiddlewareMessages) {

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

					stream = mapMiddlewareMessages.getMap().get(key);

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

				stream = mapMiddlewareMessages.getMap().get(key);

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
					String stream = mapMiddlewareMessages.getMap().get(key);

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

		LOGGER.trace("processing middleware message: " + middlewareMessagesInput);

		return middlewareMessagesInput;
	}
}
