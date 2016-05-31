package sebastianstraube.connectx.core.module.websocket.client;

import sebastianstraube.connectx.core.communication.broker.Broker;
import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketMessage;
import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.EncodeException;
import java.util.List;

class WebsocketClientBrokerClient extends ComponentBrokerClientBase {

	private static Logger LOGGER = Logger.getLogger(WebsocketClientBrokerClient.class);

    private final WebsocketClientServiceBase service;

	public WebsocketClientBrokerClient(Broker broker, WebsocketClientServiceBase service) {
		super(broker);
        this.service = service;
	}

	@Override
	protected void onIncomingBrokerMessage(String message) {
		LOGGER.log(Level.INFO, "receive broker message: " + message);
		
		//translation
		List<MessageCommon> messageList = service.getTranslator().toMiddlewareMessageList(message);
		
		//send all messages
		for(MessageCommon element: messageList){
            try {
				EndpointWebsocketMessage endpointWebsocketMessage = service.getConverter().toCharacterStream(element);
				String encodedMessageWebsocket = service.getEncoder().encode(endpointWebsocketMessage);

				//TODO fix implementation for indirect messaging
				LOGGER.log(Level.INFO, "ManagementBrokerClient receive broker message: " + message);
				WebsocketClientEndpoint.sendMessage(encodedMessageWebsocket);
            } catch (EncodeException e) {
                LOGGER.log(Level.ERROR, e);
            }
		}
	}

	@Override
	protected void initializeTopicSubscriptions() {
		//TODO refactoring for dyanmical login of a specific module
		subscribeToTopic(MessageCommon.MESSAGE_TOPIC_CABINE_RE420);
		subscribeToTopic(MessageCommon.MESSAGE_TOPIC_PETRINET_CABINE_RE420);
		subscribeToTopic(MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT);
		subscribeToTopic(MessageCommon.MESSAGE_TOPIC_AUTOMATION);
	}

}
