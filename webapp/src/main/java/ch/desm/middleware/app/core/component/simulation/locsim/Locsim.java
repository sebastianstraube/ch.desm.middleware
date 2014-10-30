package ch.desm.middleware.app.core.component.simulation.locsim;

import java.util.ArrayList;

import ch.desm.middleware.app.core.component.simulation.locsim.messages.LocsimMessageTranslatorRs232;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.dll.EndpointDllListenerInterface;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232ListenerInterface;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.simulation.locsim.messages.LocsimMessageDll;

public class Locsim extends LocsimBase implements
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

	@Override
	public void onIncomingEndpointMessage(String message) {

		if(!message.isEmpty()){
			if (isLocsimDllMessage(message)) {
				LOGGER.trace("endpoint (" + this.getClass() + ") received message DLL: " + message);
				processor.processIncomingDataDll(this, message);

			} else {
				LOGGER.trace("endpoint (" + this.getClass() + ") received message RS232: " + message);
				processor.processIncomingDataRs232(this, message);
			}
		}
	}

	/**
	 * TODO implementation
	 */
	@Override
	protected void onIncomingBrokerMessage(String message) {
		
		LOGGER.trace("broker (" + this.getClass() + ") received message: " + message);

		ArrayList<MessageMiddleware> messageList = translator
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
        signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420_FABISCH);
        signForTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
	}

}