package sebastianstraube.connectx.module.desm.simulation.zusi;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class ZusiBrokerClientMessageQueue extends ComponentMessageProcessorThreadBase {

    private static Logger LOGGER = Logger.getLogger(ZusiBrokerClientMessageQueue.class);
    private ZusiService service;
    private Object processMessagesLock;

    public ZusiBrokerClientMessageQueue(ZusiService service){
        this.service = service;
        this.processMessagesLock = new Object();
        this.start();
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
