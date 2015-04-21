package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.component.common.ComponentThreadMessageProcessorBase;
import ch.desm.middleware.app.core.component.simulation.zusi.message.ZusiMessageProtocolStream;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiEndpointTcpClientThread extends ComponentThreadMessageProcessorBase {

    private Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClientThread.class);
    private ZusiService service;
    private Object processMessagesLock;
    private Object addZusiStreamLock;
    private ZusiMessageProtocolStream stream;
    private String topic;

    public ZusiEndpointTcpClientThread(ZusiService service, String topic){
        this.service = service;
        this.processMessagesLock = new Object();
        this.addZusiStreamLock = new Object();
        this.stream = new ZusiMessageProtocolStream();
        this.topic = topic;
    }

    @Override
    public void processPendingMessages() {
        synchronized (processMessagesLock){
            LinkedList<String> messages = getMessages();

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
    public void addZusiStream(String subStream){
        synchronized (addZusiStreamLock){

        this.stream.addStream(subStream);
        String extractedMessage = getSingleMessage();

        while(!extractedMessage.isEmpty()){
            this.stream.cutStream(extractedMessage.length());
            this.addMessage(extractedMessage);
            extractedMessage = getSingleMessage();
            }
        }
    }

    /**
     *
     * @return
     */
    private String getSingleMessage() {
        return service.getMessageCheck().getSingleZusiMessage(this.stream.getStream());
    }
}
