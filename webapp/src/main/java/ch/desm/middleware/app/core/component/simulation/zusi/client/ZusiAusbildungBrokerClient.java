package ch.desm.middleware.app.core.component.simulation.zusi.client;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;


public class ZusiAusbildungBrokerClient extends ComponentBrokerClientBase {
    private static Logger LOGGER = Logger.getLogger(ZusiAusbildungBrokerClient.class);

    private ZusiAusbildungBrokerClientThread thread;
    private ZusiService service;

    public ZusiAusbildungBrokerClient(Broker broker, ZusiService service) {
        super(broker);
        this.service = service;

        this.thread = new ZusiAusbildungBrokerClientThread(service);
        this.thread.start();
    }

	@Override
	protected void onIncomingBrokerMessage(String message) {
		LOGGER.log(Level.INFO, "zusi (" + this.getClass() + ") received broker message: " + message);

        LinkedList<MessageMiddleware> l = service.getTranslator().toMiddlewareMessageList(message);
        service.getProcessor().processBrokerMessage(service, l);
    }

	@Override
	protected void intializeSignedTopic() {
        signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420);
        signForTopic(MessageBase.MESSAGE_TOPIC_CABINE_RE420_FABISCH);
        signForTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
        signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
	}

}
