package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.common.DaemonThreadBase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Sebastian on 30.10.2014.
 */
public class ManagementEndpointThread extends DaemonThreadBase {

    private ManagementEndpoint endpoint;


    private static final LinkedList<String> pendingMessageQueue = new LinkedList<String>();
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
        ArrayList<String> pendingMessageQueueCopy = new ArrayList<String>();

        synchronized (pendingMessageQueueLock){
            pendingMessageQueueCopy.addAll(pendingMessageQueue);
            pendingMessageQueue.clear();
        }
        if(!pendingMessageQueueCopy.isEmpty()){
            for(String element : pendingMessageQueueCopy){
                endpoint.onIncomingEndpointMessage(element);
            }
        }
    }

    public void run(){

        while(!isInterrupted()){
            try {
                checkMessages();
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
