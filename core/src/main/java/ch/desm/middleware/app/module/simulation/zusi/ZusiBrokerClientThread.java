package ch.desm.middleware.app.module.simulation.zusi;

import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class ZusiBrokerClientThread extends ComponentMessageProcessorThreadBase {

    private static Logger LOGGER = Logger.getLogger(ZusiBrokerClientThread.class);
    private ZusiService service;
    private Object processMessagesLock;

    public ZusiBrokerClientThread(ZusiService service){
        this.service = service;
        this.processMessagesLock = new Object();
    }

    public void processPendingMessages() {
        synchronized (processMessagesLock){
            List<MessageCommon> messages = getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
                service.getMessageProcessor().processBrokerMessage(service, messages);
            }
        }
    }
}
