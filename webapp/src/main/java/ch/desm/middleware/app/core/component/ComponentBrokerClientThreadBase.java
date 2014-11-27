package ch.desm.middleware.app.core.component;

import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 08.11.2014.
 */
public abstract class ComponentBrokerClientThreadBase extends DaemonThreadBase {

    private static Logger LOGGER = Logger.getLogger(ComponentBrokerClientThreadBase.class);

    private Object pendingMessagesLock;
    private LinkedList<MessageMiddleware> pendingMessages;

    public abstract void processBrokerMessages();

    public ComponentBrokerClientThreadBase() {
        pendingMessages = new LinkedList<>();
        pendingMessagesLock = new Object();
    }

    public LinkedList<MessageMiddleware> getMessages(){
        synchronized (pendingMessagesLock){
            LinkedList<MessageMiddleware> messages = new LinkedList<>();
            messages.addAll(pendingMessages);
            pendingMessages.clear();

            return messages;
        }
    }

    public void addMessages(LinkedList<MessageMiddleware> messagesList){
        synchronized (pendingMessagesLock){
            pendingMessages.addAll(messagesList);
        }
    }

    public void run(){

        while(!interrupted()){
               processBrokerMessages();
            try {
                doHangout();
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }



}
