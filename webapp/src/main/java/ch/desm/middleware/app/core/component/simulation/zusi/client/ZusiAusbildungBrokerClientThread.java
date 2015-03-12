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
public class ZusiAusbildungBrokerClientThread extends ComponentBrokerClientThreadBase {

    private static Logger LOGGER = Logger.getLogger(ZusiAusbildungBrokerClientThread.class);
    private ZusiService service;
    private Object processMessagesLock;

    public ZusiAusbildungBrokerClientThread(ZusiService service){
        this.service = service;
        this.processMessagesLock = new Object();
    }

    @Override
    public void processBrokerMessages() {
        synchronized (processMessagesLock){
            LinkedList<MessageMiddleware> messages = getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing broker message: " + messages.toString());
                service.getProcessor().processBrokerMessage(service, messages);
            }
        }

    }
}
