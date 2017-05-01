package sebastianstraube.connectx.core.component;

import sebastianstraube.connectx.core.common.FrequencyLimiter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 08.11.2014.
 */
public abstract class ComponentMessageProcessorThreadBase<T> extends Thread {

    private static Logger LOGGER = Logger.getLogger(ComponentMessageProcessorThreadBase.class);

    private static final float DEFAULT_POLLING_FREQUENCY = 25;

    private Object pendingMessagesLock;
    private List<T> pendingMessages;

    public abstract void processPendingMessages(List<T> messages);

    public ComponentMessageProcessorThreadBase() {
        pendingMessages = new ArrayList<T>();
        pendingMessagesLock = new Object();
        this.start();
    }

    private List<T> getMessages(){
        synchronized (pendingMessagesLock){
            if(pendingMessages.isEmpty()) return new ArrayList<T>();
            List<T> messages = new ArrayList<>(pendingMessages);
            pendingMessages.clear();
            return messages;
        }
    }

    public void addMessages(List<T> messagesList){
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
        final FrequencyLimiter frequencyLimiter = new FrequencyLimiter(DEFAULT_POLLING_FREQUENCY);

        while (!interrupted()) {
            final long startMillis = System.currentTimeMillis();

            List<T> messages = getMessages();
            if(!messages.isEmpty())processPendingMessages(messages);

            try {
                frequencyLimiter.ensureLimit(startMillis);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
                break;
            }
        }
    }
}
