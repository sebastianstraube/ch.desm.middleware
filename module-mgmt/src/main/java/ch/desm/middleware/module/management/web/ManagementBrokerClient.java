package ch.desm.middleware.module.management.web;

import ch.desm.middleware.core.communication.broker.Broker;
import ch.desm.middleware.core.communication.endpoint.websocket.EndpointWebsocketMessage;
import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.EncodeException;
import java.util.List;

class ManagementBrokerClient extends ComponentBrokerClientBase {

	private static Logger LOGGER = Logger.getLogger(ManagementBrokerClient.class);

    private final ManagementServiceBase service;

	public ManagementBrokerClient(Broker broker, ManagementServiceBase service) {
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
				ManagementEndpointClient.sendMessage(encodedMessageWebsocket);
            } catch (EncodeException e) {
                LOGGER.log(Level.ERROR, e);
            }
		}
	}

	@Override
	protected void initializeTopicSubscriptions() {
		subscribeToTopic(MessageCommon.MESSAGE_TOPIC_CABINE_RE420);
		subscribeToTopic(MessageCommon.MESSAGE_TOPIC_PETRINET_CABINE_RE420);
		subscribeToTopic(MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT);
	}

}
