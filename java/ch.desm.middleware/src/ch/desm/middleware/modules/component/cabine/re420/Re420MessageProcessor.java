package ch.desm.middleware.modules.component.cabine.re420;

import java.util.Map.Entry;

import org.apache.log4j.Logger;

import ch.desm.middleware.modules.communication.message.MessageCommon;
import ch.desm.middleware.modules.communication.message.MessageFabischAnalog;
import ch.desm.middleware.modules.communication.message.MessageUbw32Analog;
import ch.desm.middleware.modules.communication.message.MessageUbw32Base;
import ch.desm.middleware.modules.communication.message.MessageUbw32DigitalRegisterComplete;
import ch.desm.middleware.modules.communication.message.MessageUbw32DigitalRegisterSingle;
import ch.desm.middleware.modules.communication.message.processor.MessageProcessorBase;
import ch.desm.middleware.modules.component.cabine.re420.elements.Re420ElementFahrschalter;
import ch.desm.middleware.modules.component.cabine.re420.maps.Re420MapBinding;
import ch.desm.middleware.modules.component.cabine.re420.maps.Re420MapMiddleware;

public class Re420MessageProcessor extends MessageProcessorBase {

	private static Logger log = Logger.getLogger(Re420MessageProcessor.class);

	private Re420ElementFahrschalter fahrschalter;
	private Re420MapBinding binding;
	
	public Re420MessageProcessor() {
		fahrschalter = new Re420ElementFahrschalter();
		binding = new Re420MapBinding();
	}

	public String handleMessageFahrschalter(
			String key,
			boolean isEnabled) {
		
		String fahrschalterKey = fahrschalter.getMessagePositionFahrschalter(
				key, isEnabled);

		
		return fahrschalterKey;
	}

	/**
	 * 
	 * @param impl
	 * @param message
	 * @param mapMiddlewareMessages
	 * @return
	 */
	public String convertToMiddlewareMessage(Re420BaseImpl impl,
			MessageUbw32Base message, Re420MapMiddleware mapMiddlewareMessages) {

		String middlewareMessagesInput = "";
		
		if (message instanceof MessageUbw32DigitalRegisterSingle) {
			
			for (Entry<String, String> entry : impl.getEndpointUbw32().re420MapDigital
					.getMap().entrySet()) {


				if(entry.getValue().equals(((MessageUbw32DigitalRegisterSingle) message).getPort())){
					
					String key = entry.getKey();
					
					boolean isInputEnabled = message.getInputValue(
							entry.getValue().substring(0),
							entry.getValue().substring(1)).contains("1");
					String parameter = ((MessageUbw32DigitalRegisterSingle) message)
							.isEnabled() == true ? "on" : "off";
					
					String stream = null;
					
					//handle Fahrschalter
					if(fahrschalter.keyListFahrschalter.contains(key)){
						
						String fahrschalterKey = fahrschalter.getMessagePositionFahrschalter(
								key, isInputEnabled);
						
						if(!fahrschalterKey.isEmpty()){
							parameter = "on";						
							stream = fahrschalter.getMap().get(fahrschalterKey);
							stream = stream.replaceAll(
									MessageCommon.PARAMETER_PLACEHOLDER, parameter);
							middlewareMessagesInput = middlewareMessagesInput
									.concat(stream);
						}
						
					}
					
					else {
						stream = mapMiddlewareMessages.getMap().get(key);
						
						if (stream == null) {
							try {
								throw new Exception(
										"mapping error found no global id in middleware message with key: "
												+ entry.getKey() + " and value: "
												+ entry.getValue()
												+ " in message: " + message);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
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
				
				//handle Fahrschalter
				if(fahrschalter.keyListFahrschalter.contains(key)){
					
					String fahrschalterKey = fahrschalter.getMessagePositionFahrschalter(
							key, isInputEnabled);
					
					if(!fahrschalterKey.isEmpty()){
						parameter = "on";						
						stream = fahrschalter.getMap().get(fahrschalterKey);
						stream = stream.replaceAll(
								MessageCommon.PARAMETER_PLACEHOLDER, parameter);
						middlewareMessagesInput = middlewareMessagesInput
								.concat(stream);
					}
					
				}
				
				else{
					
					//lookup for binding key
					if(binding.isKeyAvailable(entry.getKey())){
						key = binding.getValue(entry.getKey());
						
						//02 = on, 01 = off
						parameter = message.getInputValue(
								entry.getValue().substring(0),
								entry.getValue().substring(1));
						
						log.info("convert message with key: " + entry.getKey() + " with binding key: " + key);
						
						String value = impl.getEndpointFabisch().mapDigital.getValue(key);
						String[] a = value.split("#");
						value = a[0];
						
						if(parameter.equals("0")){
							parameter = a[1];
						}else if(parameter.equals("1")){
							parameter = a[2];
						}else{
							//TODO check analog values!
						}
						
						if(!value.isEmpty()){
							impl.getEndpointFabisch().sendStream(value+parameter);
						}
					}else{
						
						stream = mapMiddlewareMessages.getMap().get(key);

						if (stream == null) {
							try {
								throw new Exception(
										"mapping error found no global id in middleware message with key: "
												+ entry.getKey() + " and value: "
												+ entry.getValue()
												+ " in message: " + message);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
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
							e.printStackTrace();
						}
					}

					// convert input to common parameter
					String parameter = message.getInputValue(entry.getValue(), "");
					
					stream = stream.replaceAll(
							MessageCommon.PARAMETER_PLACEHOLDER, parameter);
					middlewareMessagesInput = middlewareMessagesInput
							.concat(stream);
				}
			}
		}
		
		log.trace("processing middleware message: " + middlewareMessagesInput);

		return middlewareMessagesInput;
	}
	
	/**
	 * 
	 * @param impl
	 * @param message
	 * @param mapMiddlewareMessages
	 * @return String concatenated stream
	 */
	public String convertToMiddlewareMessage(Re420BaseImpl impl,
			MessageFabischAnalog message, Re420MapMiddleware mapMiddlewareMessages) {

		
		if(message instanceof MessageFabischAnalog)
		
		for (Entry<String, String> entry : impl.getEndpointFabisch().mapAnalog
				.getMap().entrySet()) {
			
		}
		
		return "";
	}
}