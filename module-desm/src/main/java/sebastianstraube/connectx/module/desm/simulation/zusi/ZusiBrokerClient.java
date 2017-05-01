package sebastianstraube.connectx.module.desm.simulation.zusi;

import sebastianstraube.connectx.core.communication.broker.Broker;
import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;


public class ZusiBrokerClient extends ComponentBrokerClientBase {
    private static Logger LOGGER = Logger.getLogger(ZusiBrokerClient.class);

    private ZusiService service;
    //private ZusiBrokerClientMessageQueue zusiBrokerClientMessageQueue;

    public ZusiBrokerClient(Broker broker, ZusiService service) {
        super(broker);
        this.service = service;
        //this.zusiBrokerClientMessageQueue = new ZusiBrokerClientMessageQueue(service);
    }

	@Override
	protected void onIncomingBrokerMessage(String message) {
		LOGGER.log(Level.INFO, this.getClass().getSimpleName() + " received broker message: " + message);

        List<MessageCommon> messages = service.getTranslator().toMiddlewareMessageList(message);
        service.getMessageProcessor().processBrokerMessage(service, messages);

        //ToDo Thread optimization?!
        //zusiBrokerClientMessageQueue.addMessages(messages);
    }

	@Override
	protected void initializeTopicSubscriptions() {
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_CABINE_RE420);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_PETRINET_CABINE_RE420);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_MANAGEMENT);
	}

}
