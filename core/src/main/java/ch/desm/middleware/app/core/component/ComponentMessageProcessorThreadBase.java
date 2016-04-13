package ch.desm.middleware.app.core.component;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 08.11.2014.
 */
public abstract class ComponentMessageProcessorThreadBase<T> extends Thread {

    private static Logger LOGGER = Logger.getLogger(ComponentMessageProcessorThreadBase.class);

    private Object pendingMessagesLock;
    private LinkedList<T> pendingMessages;

    public ComponentMessageProcessorThreadBase() {
        pendingMessages = new LinkedList<T>();
        pendingMessagesLock = new Object();
    }

    public abstract void processPendingMessages();

    public LinkedList<T> getMessages(){
        synchronized (pendingMessagesLock){
            LinkedList<T> messages = new LinkedList<T>();
            messages.addAll(pendingMessages);
            pendingMessages.clear();

            return messages;
        }
    }

    public void addMessages(LinkedList<T> messagesList){
        synchronized (pendingMessagesLock) {
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
                Thread.sleep(40);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }



}
