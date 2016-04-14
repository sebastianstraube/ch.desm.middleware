package ch.desm.middleware.app.module.petrinet.re420;

import ch.desm.middleware.app.core.component.ComponentMessageProcessorThreadBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class PetrinetRe420BrokerClientThreadMessage extends ComponentMessageProcessorThreadBase<MessageMiddleware> {

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
            List<MessageMiddleware> messages = getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
                service.getProcessor().processBrokerMessage(service, messages);
            }
        }

    }
}
