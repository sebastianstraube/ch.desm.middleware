package ch.desm.middleware.app.module.petrinet.obermatt;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class PetrinetOmBrokerClientThreadMessage extends ComponentMessageProcessorThreadBase<MessageMiddleware> {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmBrokerClientThreadMessage.class);
    private PetrinetOmService service;
    private Object processMessagesLock;

    public PetrinetOmBrokerClientThreadMessage(PetrinetOmService service){
        this.service = service;
        this.processMessagesLock = new Object();
    }

    @Override
    public void processPendingMessages() {
        synchronized (processMessagesLock){
            LinkedList<MessageMiddleware> messages = getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
                service.getProcessor().processBrokerMessage(service, messages);
            }
        }
    }
}
