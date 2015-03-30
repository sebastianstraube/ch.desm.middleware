package ch.desm.middleware.app.core.component.simulation.zusi.client;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentBrokerClientThreadBase;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiFahrpultBrokerClientThread extends ComponentBrokerClientThreadBase {

    private static Logger LOGGER = Logger.getLogger(ZusiFahrpultBrokerClientThread.class);
    private ZusiService service;
    private Object processMessagesLock;

    public ZusiFahrpultBrokerClientThread(ZusiService service){
        this.service = service;
        this.processMessagesLock = new Object();
    }

    @Override
    public void processBrokerMessages() {
        synchronized (processMessagesLock){
            LinkedList<MessageMiddleware> messages = getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
                service.getMessageProcessor().processBrokerMessage(service, messages);
            }
        }

    }
}
