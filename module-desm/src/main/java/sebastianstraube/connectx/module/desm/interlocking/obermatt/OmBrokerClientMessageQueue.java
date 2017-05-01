package sebastianstraube.connectx.module.desm.interlocking.obermatt;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class OmBrokerClientMessageQueue extends ComponentMessageProcessorThreadBase<MessageCommon> {

    private static Logger LOGGER = Logger.getLogger(OmBrokerClientMessageQueue.class);
    private OmService service;

    public OmBrokerClientMessageQueue(OmService service){
        this.service = service;
    }

    @Override
    public void processPendingMessages(List<MessageCommon> messages) {
        LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
        service.getProcessor().processBrokerMessage(service, messages);
    }
}
