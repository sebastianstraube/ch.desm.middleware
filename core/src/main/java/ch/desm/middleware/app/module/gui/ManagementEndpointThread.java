package ch.desm.middleware.app.module.gui;

import java.util.LinkedList;

/**
 * Created by Sebastian on 30.10.2014.
 */
public class ManagementEndpointThread extends Thread {

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
        synchronized (pendingMessageQueueLock){
            LinkedList<String> pendingMessageQueueCopy = new LinkedList<String>();
            pendingMessageQueueCopy.addAll(pendingMessageQueue);
            pendingMessageQueue.clear();

            if(!pendingMessageQueueCopy.isEmpty()){
                for(String element : pendingMessageQueueCopy){
                    endpoint.onIncomingEndpointMessage(element);
                }
            }
        }
    }

    public void run(){

        while(!isInterrupted()){
            try {
                checkMessages();
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
