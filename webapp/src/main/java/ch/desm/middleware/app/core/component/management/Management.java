package ch.desm.middleware.app.core.component.management;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import ch.desm.middleware.app.core.communication.message.MessageWebsocket;
import ch.desm.middleware.app.core.communication.message.converter.MessageConverter;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessor;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

import javax.json.JsonObjectBuilder;
import javax.websocket.DecodeException;
import javax.websocket.EncodeException;

public class Management extends ManagementBase{

	private static Logger LOGGER = Logger.getLogger(Management.class);
	
	private ManagementMessageTranslator translator;
	private MessageProcessor processor;
	private ManagementEndpointMessageFetch endpointThread;
	private EndpointWebsocketMessageEncoder encoder;
    private MessageConverter converter;

	public Management(Broker broker, ManagementEndpoint endpoint) {
		super(broker);
		translator = new ManagementMessageTranslator();
		processor = new MessageProcessor();
		endpointThread = new ManagementEndpointMessageFetch(this, endpoint);
        encoder = new EndpointWebsocketMessageEncoder();
        converter = new MessageConverter();
	}

	@Override
	public void onIncomingEndpointMessage(String message) {
		LOGGER.log(Level.INFO, "receive endpoint message: " + message);

        try {
            //check message syntax
            EndpointWebsocketMessageDecoder decoder = new EndpointWebsocketMessageDecoder();
            MessageWebsocket messageWebsocket = decoder.decode(message);
            //publish message
            processor.processEndpointMessage(this, messageWebsocket.getPayload(), messageWebsocket.getTopic());
        } catch (DecodeException e) {
            LOGGER.error("wrong format of endpoint message: " + message, e);
        }

	}

	@Override
	protected void onIncomingBrokerMessage(String message) {
		// TODO Auto-generated method stub
		LOGGER.log(Level.INFO, "receive broker message: " + message);
		
		//translation
		ArrayList<MessageMiddleware> messageList = translator.toMiddlewareMessageList(message);
		
		//send all messages
		for(MessageMiddleware element: messageList){
            try {
                String messageWebsocket = encoder.encode(converter.convertToMessageWebsocket(element));
                ManagementEndpointWebsocketClient.sendMessage(messageWebsocket);
            } catch (EncodeException e) {
                LOGGER.error(e);
            }

		}
	}

	@Override
	protected void intializeSignedTopic() {
		// TODO Auto-generated method stub
		signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420);
		signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420_FABISCH);
		signForTopic(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU);
		signForTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
		signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM);
		signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
		signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232);
	}

}
