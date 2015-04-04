package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.component.ComponentClientThreadBaseGeneric;
import ch.desm.middleware.app.core.component.simulation.zusi.message.ZusiProtocolStream;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiCommonEndpointThread extends ComponentClientThreadBaseGeneric {

    private static Logger LOGGER = Logger.getLogger(ZusiCommonEndpointThread.class);
    private ZusiService service;
    private Object processMessagesLock;
    private Object addZusiStreamLock;
    private ZusiProtocolStream zusiMessage;

    public ZusiCommonEndpointThread(ZusiService service){
        this.service = service;
        this.processMessagesLock = new Object();
        this.addZusiStreamLock = new Object();
        this.zusiMessage = new ZusiProtocolStream();
    }

    @Override
    public void processPendingMessages() {
        synchronized (processMessagesLock){
            LinkedList<String> messages = getMessages();

            if(!messages.isEmpty()){
                LOGGER.log(Level.TRACE, "processing endpoint message: " + messages.toString());
                service.getMessageProcessor().processEndpointMessage(service, messages, MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG);
            }
        }
    }

    public void addZusiStream(String stream){
        synchronized (addZusiStreamLock){

            boolean processing = true;

            while(processing){
                zusiMessage.addStream(stream);
                String extractedMessage = service.getMessageCheck().extractSingleZusiMessage(zusiMessage.getStream());
                if(extractedMessage.isEmpty()){
                    processing = false;
                }else{
                    zusiMessage.cutStream(extractedMessage.length());
                    this.addMessage(extractedMessage);
                }
            }
        }
    }
}
