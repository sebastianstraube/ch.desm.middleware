package ch.desm.middleware.module.simulation.etcs;

import ch.desm.middleware.core.communication.message.BadParameterTypeCastException;
import ch.desm.middleware.core.component.ComponentMessageProcessorBase;
import ch.desm.middleware.core.communication.message.MessageCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class EtcsMessageProcessor extends ComponentMessageProcessorBase<EtcsService> {

    private static Logger LOGGER = Logger.getLogger(EtcsMessageProcessor.class);

    /**
     * @param messages
     */
    public void processBrokerMessage(EtcsService service, List<MessageCommon> messages) {
        for(MessageCommon message : messages){
            processBrokerMessage(service, message);
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    public void processBrokerMessage(EtcsService service, MessageCommon message){

        switch(message.getTopic()){
            case(MessageCommon.MESSAGE_TOPIC_CABINE_RE420):{
                processBrokerMessageCabineRe420(service, message);
                break;
            }
            case(MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT):{
                //TODO implementation
                break;
            }
            case(MessageCommon.MESSAGE_TOPIC_MANAGEMENT):{
                processBrokerMessageManagament(service, message);
                break;
            }
            case(MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT):{
                processBrokerMessagePetrinetOm(service, message);
                break;
            }
            case(MessageCommon.MESSAGE_TOPIC_PETRINET_CABINE_RE420):{
                processBrokerMessagePetrinetRe420(service, message);
                break;
            }
            default:{
                try {
                    throw new Exception("unsupported topic, broker message delegation skipped: " + message.toString());
                } catch (Exception e) {
                    LOGGER.log(Level.WARN, e);
                }
            };
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    private void processBrokerMessageManagament(EtcsService service, MessageCommon message){
        //TODO implementation, but only messages with zusi topic (take control in gui)
    }

    /**
     *
     * @param service
     * @param message
     */
    private void processBrokerMessageCabineRe420(EtcsService service, MessageCommon message){

    }

    /**
     *
     * @param service
     * @param message
     */
    protected void processBrokerMessagePetrinetOm(EtcsService service, MessageCommon message){

    }

    /**
     *
     * @param service
     * @param message
     */
    protected void processBrokerMessagePetrinetRe420(EtcsService service, MessageCommon message){

    }

    /**
     *
     * @param endpoint
     * @param message
     */
    private void delegateToEndpoint(EtcsEndpointTcpClient endpoint, String message){

    }

    /**
     *
     * @param endpoint
     * @param element
     */
    private void processInitEndpoint(EtcsEndpointTcpClient endpoint, MessageCommon element){

        final String parameter;
        try {
            parameter = element.getParameterAsString();
        } catch (BadParameterTypeCastException e) {
            LOGGER.log(Level.ERROR, "Received init message with type " + element.getTypeName() + " but expected String");
            return;
        }

        switch (parameter) {
            case ("init"): {
                endpoint.init();
                break;
            }
            case ("start"): {
                endpoint.start();
                break;
            }
            case ("stop"): {
                endpoint.stop();
                break;
            }
        }
    }

    /**
     *
     * @param service
     * @param messages
     * @param topic
     */
    public synchronized void processEndpointMessage(EtcsService service, List<String> messages, String topic){
        for(String s : messages){
            processEndpointMessage(service, s, topic);
        }
    }

    /**
     *
     * @param service
     * @param message
     * @param topic
     */
    public void processEndpointMessage(EtcsService service, String message, String topic){
        LOGGER.log(Level.DEBUG, "received endpoint ETCS "+ service.getEndpoint().toString() +" received message: " + message + " with topic: " + topic);
    }

}
