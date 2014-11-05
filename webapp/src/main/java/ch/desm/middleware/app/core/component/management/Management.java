package ch.desm.middleware.app.core.component.management;

import java.util.ArrayList;

import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import ch.desm.middleware.app.core.communication.message.MessageWebsocket;
import ch.desm.middleware.app.core.communication.message.converter.MessageConverter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import javax.websocket.DecodeException;
import javax.websocket.EncodeException;

public class Management extends ManagementBase{

	private static Logger LOGGER = Logger.getLogger(Management.class);
	
	private ManagementMessageTranslator translator;
	private ManagementMessageProcessor processor;
	private EndpointWebsocketMessageEncoder encoder;
    private MessageConverter converter;

	public Management(Broker broker, ManagementEndpoint endpoint) {
		super(broker, endpoint);
		translator = new ManagementMessageTranslator();
		processor = new ManagementMessageProcessor();
        encoder = new EndpointWebsocketMessageEncoder();
        converter = new MessageConverter();
	}

	@Override
	public void onIncomingEndpointMessage(String message) {
		LOGGER.log(Level.TRACE, "receive endpoint message: " + message);

        try {
            //check message syntax
            EndpointWebsocketMessageDecoder decoder = new EndpointWebsocketMessageDecoder();
            MessageWebsocket messageWebsocket = decoder.decode(message);
            //publish message
            processor.processEndpointMessage(this, messageWebsocket.getPayload(), messageWebsocket.getTopic());
        } catch (DecodeException e) {
            LOGGER.log(Level.ERROR, "wrong format of endpoint message: " + message, e);
        }

	}

	@Override
	protected void onIncomingBrokerMessage(String message) {
		LOGGER.log(Level.TRACE, "receive broker message: " + message);
		
		//translation
		ArrayList<MessageMiddleware> messageList = translator.toMiddlewareMessageList(message);
		
		//send all messages
		for(MessageMiddleware element: messageList){
            try {
                String messageWebsocket = encoder.encode(converter.toCharacterStream(element));
                ManagementEndpointWebsocketClient.sendMessage(messageWebsocket);
            } catch (EncodeException e) {
                LOGGER.log(Level.ERROR, e);
            }

		}
	}

	@Override
	protected void intializeSignedTopic() {
		signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420);
		signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420_FABISCH);
		signForTopic(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU);
		signForTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
		signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM);
		signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
		signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232);
	}

}
