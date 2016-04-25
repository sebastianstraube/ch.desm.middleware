package ch.desm.middleware.app.module.gui;

import java.util.List;

import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;

import javax.websocket.EncodeException;

public class ManagementBrokerClient extends ComponentBrokerClientBase {

	private static Logger LOGGER = Logger.getLogger(ManagementBrokerClient.class);

    private ManagementService service;

	public ManagementBrokerClient(Broker broker, ManagementService service) {
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
                String messageWebsocket = service.getEncoder().encode(service.getConverter().toCharacterStream(element));
				ManagementEndpointClientWebsocket.sendMessage(messageWebsocket);
            } catch (EncodeException e) {
                LOGGER.log(Level.ERROR, e);
            }

		}
	}

	@Override
	protected void initializeTopicSubscriptions() {
		subscribeToTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420);
		subscribeToTopic(MessageBase.MESSAGE_TOPIC_PETRINET_CABINE_RE420);
		subscribeToTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT);
        subscribeToTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT);
        subscribeToTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG);
        subscribeToTopic(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT);
	}

}
