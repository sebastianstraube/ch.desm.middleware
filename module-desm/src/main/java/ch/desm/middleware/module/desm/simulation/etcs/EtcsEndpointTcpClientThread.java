package ch.desm.middleware.module.desm.simulation.etcs;

import ch.desm.middleware.core.component.ComponentMessageProcessorThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class EtcsEndpointTcpClientThread extends ComponentMessageProcessorThreadBase<String> {

    private Logger LOGGER = Logger.getLogger(EtcsEndpointTcpClientThread.class);
    private EtcsService service;
    private Object processMessagesLock;
    private String topic;

    public EtcsEndpointTcpClientThread(EtcsService service, String topic){
        this.service = service;
        this.processMessagesLock = new Object();
        this.topic = topic;
    }

    @Override
    public void processPendingMessages() {
        synchronized (processMessagesLock){
            LinkedList<String> messages = new LinkedList<>();

            if(!messages.isEmpty()){
                LOGGER.log(Level.INFO, "process pending endpoint message: " + messages.toString());
                service.getMessageProcessor().processEndpointMessage(service, messages, topic);
            }
        }
    }

    /**
     *
     * @param subStream
     */
    public void addEtcsStream(String subStream){

    }

}
