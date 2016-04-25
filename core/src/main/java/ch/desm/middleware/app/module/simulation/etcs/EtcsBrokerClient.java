package ch.desm.middleware.app.module.simulation.etcs;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;


public class EtcsBrokerClient extends ComponentBrokerClientBase {
    private static Logger LOGGER = Logger.getLogger(EtcsBrokerClient.class);

    private EtcsBrokerClientThread thread;
    private EtcsService service;

    public EtcsBrokerClient(Broker broker, EtcsService service) {
        super(broker);
        this.service = service;

        this.thread = new EtcsBrokerClientThread(service);
        this.thread.start();
    }

	@Override
	protected void onIncomingBrokerMessage(String message) {
		LOGGER.log(Level.INFO, this.getClass().getSimpleName() + " received broker message: " + message);

        List<MessageCommon> l = service.getTranslator().toMiddlewareMessageList(message);
        thread.addMessages(l);
    }

	@Override
	protected void initializeTopicSubscriptions() {
        subscribeToTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420);
        subscribeToTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT);
        subscribeToTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
	}

}
