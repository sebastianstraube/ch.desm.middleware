package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentBrokerClientThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class OMLPetrinetBrokerClientThread extends ComponentBrokerClientThreadBase {

    private static Logger LOGGER = Logger.getLogger(OMLPetrinetBrokerClientThread.class);
    private OMLPetrinetBrokerClient petrinet;
    private Object processMessagesLock;

    public OMLPetrinetBrokerClientThread(OMLPetrinetBrokerClient petrinet){
        this.petrinet = petrinet;
        this.processMessagesLock = new Object();
    }

    @Override
    public void processMessages() {
        synchronized (processMessagesLock){
            LinkedList<MessageMiddleware> messages = getMessages();
            LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
            petrinet.getProcessor().processBrokerMessage(petrinet.getEndpoint(), messages);
        }

    }
}
