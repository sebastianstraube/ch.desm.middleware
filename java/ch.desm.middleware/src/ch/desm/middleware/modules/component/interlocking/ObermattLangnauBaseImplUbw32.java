package ch.desm.middleware.modules.component.interlocking;

import java.util.Map.Entry;

import ch.desm.middleware.modules.communication.broker.Broker;
import ch.desm.middleware.modules.communication.endpoint.EndpointCommon;
import ch.desm.middleware.modules.communication.endpoint.serial.ubw32.EndpointUbw32PortAnalog.EnumEndpointUbw32RegisterAnalog;
import ch.desm.middleware.modules.communication.endpoint.serial.ubw32.EndpointUbw32PortDigital.EnumEndpointUbw32RegisterDigital;
import ch.desm.middleware.modules.communication.message.MessageBase.EnumMessageTopic;
import ch.desm.middleware.modules.communication.message.router.MessageRouter;
import ch.desm.middleware.modules.communication.message.translator.MessageTranslator;
import ch.desm.middleware.modules.communication.message.type.MessageCommon;
import ch.desm.middleware.modules.communication.message.type.MessageUbw32;

public class ObermattLangnauBaseImplUbw32 extends ObermattLangnauBase {

	private ObermattLangnauFunctionMessages functionMessages;
	
	public ObermattLangnauBaseImplUbw32(Broker broker,
			EndpointCommon communicationEndpointUbw32) {
		super(broker, communicationEndpointUbw32);
		// TODO Auto-generated constructor stub
		
		this.functionMessages = new ObermattLangnauFunctionMessages();
	}

	protected void onIncomingBrokerMessage(String message) {
		System.out.println("received a broker message:" + message
				+ " from component " + this.getClass());

		MessageTranslator translator = new MessageTranslator();
		MessageCommon messageCommon = translator.translateMiddlewareMessageStreamToCommonMessageObject(message, EnumMessageTopic.INTERLOCKING);
		
		// TODO route and transmit to endpoint
		MessageRouter router = new MessageRouter();
		router.processBrokerMessage(this.getEndpoint(), messageCommon);
	}

	/**
	 * TODO implementation
	 * 
	 * @param message
	 */
	public void onIncomingEndpointMessage(String message) {
		System.out.println("received an endpoint message :\"" + message
				+ " from endpoint " + this.getClass());

		MessageCommon messageCommon = null;

		MessageTranslator translator = new MessageTranslator();
		MessageUbw32 ubw32Message = translator.decodeUbw32EndpointMessage(
				message, EnumMessageTopic.INTERLOCKING);

		String messages = processInputs(ubw32Message);

		MessageRouter router = new MessageRouter();
		router.processEndpointMessage(this, messages);
	}

	/**
	 * TODO multiple analog message
	 * @param message
	 */
	public String processInputs(MessageUbw32 message) {

		String middlewareMessagesInput = "";
		
		//Digital messages
		if (message.isDigital) {
			for(Entry<EnumEndpointUbw32RegisterDigital, String> entry : this.getEndpoint().getConfiguration().mapDigital.entrySet()){
				
				String stream = functionMessages.messages.get(entry.getValue());
				if(message.getInputDigitalValue(entry.getKey())){
					stream = stream.replaceAll(ObermattLangnauFunctionMessages.PARAMETER_PLACEHOLDER, "on");
				}else{
					stream = stream.replaceAll(ObermattLangnauFunctionMessages.PARAMETER_PLACEHOLDER, "off");
				}
				
				middlewareMessagesInput = middlewareMessagesInput.concat(stream);
			}
		
		//Analog messages
		} else {

			for(Entry<EnumEndpointUbw32RegisterAnalog, String> entry : this.getEndpoint().getConfiguration().mapAnalog.entrySet()){
				
				String stream = functionMessages.messages.get(entry.getValue());
				int analogValue = Integer.parseInt(message.getInputAnalogValue(entry.getKey()));
				
				//lookup global id from analog value
				String globalId = this.getEndpoint().getConfiguration().getGlobalIdFSS(entry.getKey(), analogValue);
				
				//if FSS id is equal map entry,
				//then set message stream parameter on else off
				if(entry.getValue().equals(globalId)){
					stream.replaceAll(ObermattLangnauFunctionMessages.PARAMETER_PLACEHOLDER, "on");
				}else{
					stream.replaceAll(ObermattLangnauFunctionMessages.PARAMETER_PLACEHOLDER, "off");
				}
				
				middlewareMessagesInput = middlewareMessagesInput.concat(stream);
			}		
		}
		return middlewareMessagesInput;
	}
}