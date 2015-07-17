package ch.desm.middleware.app.core.component;

import ch.desm.middleware.app.common.ThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 08.11.2014.
 */
public abstract class ComponentThreadMessageProcessorBase<T> extends ThreadBase {

    private static Logger LOGGER = Logger.getLogger(ComponentThreadMessageProcessorBase.class);

    private Object pendingMessagesLock;
    private LinkedList<T> pendingMessages;

    public abstract void processPendingMessages();

    public ComponentThreadMessageProcessorBase() {
        pendingMessages = new LinkedList<T>();
        pendingMessagesLock = new Object();
    }

    public LinkedList<T> getMessages(){
        synchronized (pendingMessagesLock){
            LinkedList<T> messages = new LinkedList<T>();
            messages.addAll(pendingMessages);
            pendingMessages.clear();

            return messages;
        }
    }

    public void addMessages(LinkedList<T> messagesList){
        synchronized (pendingMessagesLock){
            pendingMessages.addAll(messagesList);
        }
    }

    public void addMessage(T message){
        synchronized (pendingMessagesLock){
            pendingMessages.add(message);
        }
    }

    public void run(){

        while(!interrupted()){
               processPendingMessages();
            try {
                doHangout();
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }



}
