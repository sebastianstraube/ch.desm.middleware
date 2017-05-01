package sebastianstraube.connectx.module.desm.simulation.zusi;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class ZusiBrokerClientMessageQueue extends ComponentMessageProcessorThreadBase<MessageCommon> {

    private static Logger LOGGER = Logger.getLogger(ZusiBrokerClientMessageQueue.class);
    private ZusiService service;

    public ZusiBrokerClientMessageQueue(ZusiService service){
        this.service = service;
    }

    public void processPendingMessages(List<MessageCommon> messages) {
        LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
        service.getMessageProcessor().processBrokerMessage(service, messages);
        }
}
