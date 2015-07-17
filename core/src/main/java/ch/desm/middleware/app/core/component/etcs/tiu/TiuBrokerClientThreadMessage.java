package ch.desm.middleware.app.core.component.etcs.tiu;

import ch.desm.middleware.app.core.component.ComponentThreadMessageProcessorBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class TiuBrokerClientThreadMessage extends ComponentThreadMessageProcessorBase<MessageMiddleware> {

    private static Logger LOGGER = Logger.getLogger(TiuBrokerClientThreadMessage.class);
    private TiuService service;
    private Object processMessagesLock;

    public TiuBrokerClientThreadMessage(TiuService service){
        this.service = service;
        this.processMessagesLock = new Object();
    }

    @Override
    public void processPendingMessages() {
        synchronized (processMessagesLock){
            LinkedList<MessageMiddleware> messages = getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
                service.getMessageProcessor().processBrokerMessage(service, messages);
            }
        }

    }
}
