package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentBrokerClientThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 08.11.2014.
 */
public class OmlBrokerClientThread extends ComponentBrokerClientThreadBase {

    private static Logger LOGGER = Logger.getLogger(OmlBrokerClientThread.class);
    private OmlService service;
    private Object processMessagesLock;

    public OmlBrokerClientThread(OmlService service){
        this.service = service;
        this.processMessagesLock = new Object();
    }

    @Override
    public void processBrokerMessages() {
        synchronized (processMessagesLock){
            LinkedList<MessageMiddleware> messages = this.getMessages();
            LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
            service.getProcessor().processBrokerMessage(service.getEndpoint(), messages);
        }
    }
}
