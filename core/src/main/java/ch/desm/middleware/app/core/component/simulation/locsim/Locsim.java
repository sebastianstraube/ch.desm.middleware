package ch.desm.middleware.app.core.component.simulation.locsim;

import java.util.LinkedList;

import ch.desm.middleware.app.core.component.simulation.locsim.messages.LocsimMessageTranslatorRs232;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.dll.EndpointDllListenerInterface;
import ch.desm.middleware.app.core.communication.endpoint.rs232.EndpointRs232ListenerInterface;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.simulation.locsim.messages.LocsimMessageDll;

public class Locsim extends LocsimBrokerClientBase implements
		EndpointDllListenerInterface, EndpointRs232ListenerInterface {

	private static Logger LOGGER = Logger.getLogger(Locsim.class);

	public LocsimMessageTranslatorRs232 translatorRs232;
	public LocsimMessageProcessor processor;
	public MessageTranslatorMiddleware translator;
	
	boolean initialisiert;

	public Locsim(Broker broker, LocsimEndpointRs232 endpointRs232,
			LocsimEndpointDll endpointDll) {
		super(broker, endpointRs232, endpointDll);

		translatorRs232 = new LocsimMessageTranslatorRs232();
		processor = new LocsimMessageProcessor();
		translator = new MessageTranslatorMiddleware();
	}


	public void onIncomingEndpointMessage(String message) {

		if(!message.isEmpty()){
			if (isLocsimDllMessage(message)) {
				LOGGER.log(Level.TRACE, "endpoint (" + this.getClass() + ") received message DLL: " + message);
				processor.processIncomingDataDll(this, message);

			} else {
				LOGGER.log(Level.TRACE, "endpoint (" + this.getClass() + ") received message RS232: " + message);
				processor.processIncomingDataRs232(this, message);
			}
		}
	}

	/**
	 * TODO implementation
	 */
	@Override
	protected void onIncomingBrokerMessage(String message) {
		
		LOGGER.log(Level.TRACE, "broker (" + this.getClass() + ") received message: " + message);

		LinkedList<MessageMiddleware> messageList = translator
				.toMiddlewareMessageList(message);

		processor.processBrokerMessage(this, messageList);
	}


	public boolean isLocsimDllMessage(String message) {

		if (message.startsWith(LocsimMessageDll.DLL_MESSAGE_GLEISLIST)
				|| message.startsWith(LocsimMessageDll.DLL_MESSAGE_SIGNAL)
				|| message.startsWith(LocsimMessageDll.DLL_MESSAGE_TRACK)
				|| message
						.startsWith(LocsimMessageDll.DLL_MESSAGE_TRAINPOSITION)
				|| message.startsWith(LocsimMessageDll.DLL_MESSAGE_WEICHE)) {
			return true;
		}

		return false;
	}

	@Override
	protected void intializeSignedTopic() {
        signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420);
        signForTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
	}

}
