package sebastianstraube.connectx.module.desm.petrinet.obermatt;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class PetrinetOmBrokerClientMessageQueue extends ComponentMessageProcessorThreadBase<MessageCommon> {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmBrokerClientMessageQueue.class);
    private Object processMessagesLock;
    private PetrinetOmService service;

    public PetrinetOmBrokerClientMessageQueue(PetrinetOmService service){
        this.service = service;
        this.processMessagesLock = new Object();
    }

    @Override
    public void processPendingMessages(List<MessageCommon> messages) {
        LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
        service.getMessageProcessor().processBrokerMessage(service, messages);
    }
}
