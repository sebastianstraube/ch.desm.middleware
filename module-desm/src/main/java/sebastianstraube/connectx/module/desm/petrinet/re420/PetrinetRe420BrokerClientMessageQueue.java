package sebastianstraube.connectx.module.desm.petrinet.re420;

import sebastianstraube.connectx.core.component.ComponentMessageProcessorThreadBase;
import sebastianstraube.connectx.core.communication.message.MessageCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class PetrinetRe420BrokerClientMessageQueue extends ComponentMessageProcessorThreadBase<MessageCommon> {

    private static Logger LOGGER = Logger.getLogger(PetrinetRe420BrokerClientMessageQueue.class);
    private PetrinetRe420Service service;

    public PetrinetRe420BrokerClientMessageQueue(PetrinetRe420Service service){
        this.service = service;
    }

    @Override
    public void processPendingMessages(List<MessageCommon> messages) {
        LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
        service.getProcessor().processBrokerMessage(service, messages);
    }
}
