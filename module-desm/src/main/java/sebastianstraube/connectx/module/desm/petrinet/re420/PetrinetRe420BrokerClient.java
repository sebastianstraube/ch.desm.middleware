package sebastianstraube.connectx.module.desm.petrinet.re420;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentBrokerClientBase;
import sebastianstraube.connectx.core.communication.broker.Broker;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by max on 06/08/14.
 */
public class PetrinetRe420BrokerClient extends ComponentBrokerClientBase {
    private static Logger LOGGER = Logger.getLogger(PetrinetRe420BrokerClient.class);

    private PetrinetRe420BrokerClientThreadMessage thread;
    private PetrinetRe420Service service;

    public PetrinetRe420BrokerClient(Broker broker, PetrinetRe420Service service) {
        super(broker);
        this.service = service;

        this.thread = new PetrinetRe420BrokerClientThreadMessage(service);
        this.thread.start();
    }

    @Override
    protected void onIncomingBrokerMessage(String message) {
        LOGGER.log(Level.TRACE, "broker (" + this.getClass() + ") received message: " + message);

        if(!message.isEmpty())  thread.addMessages(service.getTranslator().toMiddlewareMessageList(message));
        else LOGGER.log(Level.INFO, "incoming broker message is empty " + getClass().getSimpleName());
    }

    @Override
    protected void initializeTopicSubscriptions() {
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_CABINE_RE420);
        subscribeToTopic(MessageCommon.MESSAGE_TOPIC_MANAGEMENT);
    }
}
