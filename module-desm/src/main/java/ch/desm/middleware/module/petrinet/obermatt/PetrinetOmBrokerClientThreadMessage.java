package ch.desm.middleware.module.petrinet.obermatt;

import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class PetrinetOmBrokerClientThreadMessage extends ComponentMessageProcessorThreadBase<MessageCommon> {

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
            List<MessageCommon> messages = getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
                service.getProcessor().processBrokerMessage(service, messages);
            }
        }
    }
}
