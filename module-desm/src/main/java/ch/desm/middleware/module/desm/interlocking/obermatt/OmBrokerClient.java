package ch.desm.middleware.module.desm.interlocking.obermatt;

import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.core.communication.broker.Broker;

public class OmBrokerClient extends ComponentBrokerClientBase {

	private static Logger LOGGER = Logger.getLogger(OmBrokerClient.class);

    private OmGenericClientThreadMessage thread;
    private OmService service;

	public OmBrokerClient(Broker broker, OmService service) {
		super(broker);
        this.service = service;
        this.thread = new OmGenericClientThreadMessage(service);
        this.thread.start();
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
