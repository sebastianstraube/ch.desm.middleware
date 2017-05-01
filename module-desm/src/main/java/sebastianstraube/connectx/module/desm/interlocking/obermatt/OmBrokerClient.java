package sebastianstraube.connectx.module.desm.interlocking.obermatt;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import sebastianstraube.connectx.core.communication.broker.Broker;

public class OmBrokerClient extends ComponentBrokerClientBase {

	private static Logger LOGGER = Logger.getLogger(OmBrokerClient.class);

    private OmBrokerClientMessageQueue thread;
    private OmService service;

	public OmBrokerClient(Broker broker, OmService service) {
		super(broker);
        this.service = service;
        this.thread = new OmBrokerClientMessageQueue(service);
	}

    /**
     *
     */
    @Override
    protected void initializeTopicSubscriptions() {
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_MANAGEMENT);
    }

    @Override
	protected void onIncomingBrokerMessage(String message) {
		LOGGER.log(Level.TRACE, "broker (" + this.getClass() + ") received message: " + message);
		thread.addMessages(service.getTranslator().toMiddlewareMessageList(message));
	}
}
