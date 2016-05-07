package ch.desm.middleware.app.module.gui;

import ch.desm.middleware.app.common.FrequencyLimiter;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessage;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.DecodeException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sebastian on 30.10.2014.
 */
public class ManagementEndpointThread extends Thread {

    private static final Logger LOGGER = Logger.getLogger(ManagementEndpoint.class);

    private static final float DEFAULT_POLLING_FREQUENCY = 25;

    private ManagementEndpoint endpoint;

    private static final List<String> pendingMessageQueue = new LinkedList<>();
    private static Object pendingMessageQueueLock = new Object();

    public ManagementEndpointThread(ManagementEndpoint endpoint){
        this.endpoint = endpoint;
        this.start();
    }

    public static void addMessages(String message){
        synchronized (pendingMessageQueueLock){
            pendingMessageQueue.add(message);
        }
    }

    private void checkMessages(){
        LinkedList<String> pendingMessageQueueCopy = new LinkedList<>();
        synchronized (pendingMessageQueueLock) {
            pendingMessageQueueCopy.addAll(pendingMessageQueue);
            pendingMessageQueue.clear();
        }

        // TODO: refactor to service.getDecoder() again
        final EndpointWebsocketMessageDecoder decoder = new EndpointWebsocketMessageDecoder();

        for(String rawMessage : pendingMessageQueueCopy){
            try {
                final EndpointWebsocketMessage message = decoder.decode(rawMessage);
                endpoint.onIncomingEndpointMessage(message);
            } catch (DecodeException e) {
                LOGGER.log(Level.ERROR, "wrong format of endpoint message: " + rawMessage, e);
            }
        }
    }

    public void run(){
        final FrequencyLimiter frequencyLimiter = new FrequencyLimiter(DEFAULT_POLLING_FREQUENCY);

        while(!isInterrupted()){
            final long startMillis = System.currentTimeMillis();

            checkMessages();

            try {
                frequencyLimiter.ensureLimit(startMillis);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
                break;
            }
        }
    }
}
