package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;

/**
 * Created by max on 06/08/14.
 */
public class PetrinetOmlBrokerClient extends ComponentBrokerClientBase {
    private static Logger LOGGER = Logger.getLogger(PetrinetOmlBrokerClient.class);

    private PetrinetOmlBrokerClientThread thread;
    private PetrinetOmlService service;

    public PetrinetOmlBrokerClient(Broker broker, PetrinetOmlService service) {
        super(broker);
        this.service = service;

        this.thread = new PetrinetOmlBrokerClientThread(service);
        this.thread.start();
    }

    @Override
    protected void onIncomingBrokerMessage(String message) {
            thread.addMessages(service.getTranslator().toMiddlewareMessageList(message));
    }

    @Override
    protected void intializeSignedTopic() {
        signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
        signForTopic(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU);
        signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
    }
}
