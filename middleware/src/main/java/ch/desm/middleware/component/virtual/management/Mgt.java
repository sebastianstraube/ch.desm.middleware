package ch.desm.middleware.component.virtual.management;

import ch.desm.middleware.communication.broker.Broker;
import ch.desm.middleware.communication.endpoint.websocket.EndpointWebsocket;
import ch.desm.middleware.communication.message.MessageBase;

public class Mgt extends MgtBase{

	public Mgt(Broker broker, EndpointWebsocket endpoint) {
		super(broker);
		this.endpoint = endpoint;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onIncomingEndpointMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onIncomingBrokerMessage(String message) {
		// TODO Auto-generated method stub
		
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
