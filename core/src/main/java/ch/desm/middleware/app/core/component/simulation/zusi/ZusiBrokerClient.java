package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;
import ch.desm.middleware.app.core.component.ComponentThreadMessageProcessor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;


public class ZusiBrokerClient extends ComponentBrokerClientBase {
    private static Logger LOGGER = Logger.getLogger(ZusiBrokerClient.class);

    private ComponentThreadMessageProcessor thread;
    private ZusiService service;

    public ZusiBrokerClient(Broker broker, ZusiService service) {
        super(broker);
        this.service = service;

        this.thread = new ComponentThreadMessageProcessor(service);
        this.thread.start();
    }

	@Override
	protected void onIncomingBrokerMessage(String message) {
		LOGGER.log(Level.INFO, this.getClass().getSimpleName()+" received broker message: " + message);

        LinkedList<MessageMiddleware> l = service.getTranslator().toMiddlewareMessageList(message);
        service.getMessageProcessor().processBrokerMessage(service, l);
    }

	@Override
	protected void intializeSignedTopic() {
        signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420);
        signForTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT);
        signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
	}

}
