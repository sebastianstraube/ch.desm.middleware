package sebastianstraube.connectx.module.desm.interlocking.obermatt;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class OmGenericClientThreadMessage extends ComponentMessageProcessorThreadBase {

    private static Logger LOGGER = Logger.getLogger(OmGenericClientThreadMessage.class);
    private OmService service;
    private Object processMessagesLock;

    public OmGenericClientThreadMessage(OmService service){
        this.service = service;
        this.processMessagesLock = new Object();
    }

    @Override
    public void processPendingMessages() {
        synchronized (processMessagesLock){
            List<MessageCommon> messages = this.getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
                service.getProcessor().processBrokerMessage(service, messages);
            }
        }
    }
}
