package ch.desm.middleware.module.simulation.etcs;

import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

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
            List<MessageCommon> messages = getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
                service.getMessageProcessor().processBrokerMessage(service, messages);
            }
        }
    }
}
