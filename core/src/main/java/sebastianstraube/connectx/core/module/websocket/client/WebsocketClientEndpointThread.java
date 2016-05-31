package sebastianstraube.connectx.core.module.websocket.client;

import sebastianstraube.connectx.core.common.FrequencyLimiter;
import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketMessage;
import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.DecodeException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sebastian on 30.10.2014.
 */
class WebsocketClientEndpointThread extends Thread {

    private static final Logger LOGGER = Logger.getLogger(WebsocketClientEndpointCreator.class);
    private WebsocketClientEndpointCreator endpoint;
    private static final List<String> pendingMessageQueue = new LinkedList<>();
    private static Object pendingMessageQueueLock = new Object();

    public WebsocketClientEndpointThread(WebsocketClientEndpointCreator endpoint){
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
            if(pendingMessageQueue.isEmpty()) return;

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
        final FrequencyLimiter frequencyLimiter = new FrequencyLimiter(25f);
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
