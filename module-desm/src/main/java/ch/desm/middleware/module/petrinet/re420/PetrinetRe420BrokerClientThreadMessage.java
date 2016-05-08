package ch.desm.middleware.module.petrinet.re420;

import ch.desm.middleware.core.component.ComponentMessageProcessorThreadBase;
import ch.desm.middleware.core.communication.message.MessageCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class PetrinetRe420BrokerClientThreadMessage extends ComponentMessageProcessorThreadBase<MessageCommon> {

    private static Logger LOGGER = Logger.getLogger(PetrinetRe420BrokerClientThreadMessage.class);
    private PetrinetRe420Service service;
    private Object processMessagesLock;

    public PetrinetRe420BrokerClientThreadMessage(PetrinetRe420Service service){
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
