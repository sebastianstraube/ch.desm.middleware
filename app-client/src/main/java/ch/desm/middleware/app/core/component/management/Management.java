package ch.desm.middleware.app.core.component.management;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessor;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

public class Management extends ManagementBase{

	private static Logger LOGGER = Logger.getLogger(Management.class);
	
	private MessageTranslatorMiddleware translator;
	private MessageProcessor processor;
	private ManagementEndpointMessageFetch endpointThread;
	
	public Management(Broker broker, ManagementEndpoint endpoint) {
		super(broker);
		translator = new MessageTranslatorMiddleware();
		processor = new MessageProcessor();
		endpointThread = new ManagementEndpointMessageFetch(this, endpoint);
	}

	@Override
	public void onIncomingEndpointMessage(String message) {
		// TODO Auto-generated method stub
		LOGGER.log(Level.INFO, "receive endpoint message: " + message);
		
		processor.processEndpointMessage(this, message, MessageBase.MESSAGE_TOPIC_MANAGEMENT);		
	}

	@Override
	protected void onIncomingBrokerMessage(String message) {
		// TODO Auto-generated method stub
		LOGGER.log(Level.INFO, "receive broker message: " + message);
		
		//translation
		ArrayList<MessageMiddleware> messageList = translator.toMiddlewareMessageList(message);
		
		//send all messages
		/*for(MessageMiddleware element: messageList){
			EndpointWebsocketServer.sendMessage(element.getPayload());
		}
		*/
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
