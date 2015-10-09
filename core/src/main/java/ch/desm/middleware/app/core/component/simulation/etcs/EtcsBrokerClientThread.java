package ch.desm.middleware.app.core.component.simulation.etcs;

import ch.desm.middleware.app.common.component.ComponentMessageProcessorThreadBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class EtcsBrokerClientThread extends ComponentMessageProcessorThreadBase {

    private static Logger LOGGER = Logger.getLogger(EtcsBrokerClientThread.class);
    private EtcsService service;
    private Object processMessagesLock;

    public EtcsBrokerClientThread(EtcsService service){
        this.service = service;
        this.processMessagesLock = new Object();
    }

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
