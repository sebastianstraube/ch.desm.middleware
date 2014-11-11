package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import java.util.LinkedList;

import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;

public class OmlBrokerClient extends ComponentBrokerClientBase {

	private static Logger LOGGER = Logger.getLogger(OmlBrokerClient.class);

    private OmlBrokerClientThread thread;
    private OmlService service;

	public OmlBrokerClient(Broker broker, OmlService service) {
		super(broker);
        this.service = service;
        this.thread = new OmlBrokerClientThread(service);
	}

    /**
     *
     */
    @Override
    protected void intializeSignedTopic() {
        signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
        signForTopic(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
        signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
    }

	protected void onIncomingBrokerMessage(String message) {
		LOGGER.log(Level.TRACE, "broker (" + this.getClass() + ") received message: " + message);
		thread.addMessages(service.getTranslator().toMiddlewareMessageList(message));
	}
}
