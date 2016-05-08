package ch.desm.middleware.module.desm.petrinet.obermatt;

import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.core.communication.broker.Broker;

/**
 * Created by max on 06/08/14.
 */
public class PetrinetOmBrokerClient extends ComponentBrokerClientBase {
    private static Logger LOGGER = Logger.getLogger(PetrinetOmBrokerClient.class);

    private PetrinetOmBrokerClientThreadMessage thread;
    private PetrinetOmService service;

    public PetrinetOmBrokerClient(Broker broker, PetrinetOmService service) {
        super(broker);
        this.service = service;

        this.thread = new PetrinetOmBrokerClientThreadMessage(service);
        this.thread.start();
    }

    @Override
    protected void onIncomingBrokerMessage(String message) {
        LOGGER.log(Level.TRACE, "broker (" + this.getClass() + ") received message: " + message);
        thread.addMessages(service.getTranslator().toMiddlewareMessageList(message));
    }

    @Override
    protected void initializeTopicSubscriptions() {
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_MANAGEMENT);
    }
}
