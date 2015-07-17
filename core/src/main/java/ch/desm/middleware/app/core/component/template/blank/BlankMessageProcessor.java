package ch.desm.middleware.app.core.component.template.blank;

import ch.desm.middleware.app.core.component.ComponentMessageProcessorBase;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class BlankMessageProcessor extends ComponentMessageProcessorBase<BlankService> {

    private static Logger LOGGER = Logger.getLogger(BlankMessageProcessor.class);

    /**
     * @param messages
     */
    public void processBrokerMessage(BlankService service, LinkedList<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(service, message);
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    public void processBrokerMessage(BlankService service, MessageMiddleware message){

        switch(message.getTopic()){
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM):{
                //TODO implementation
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_CABINE_RE420):{
                processBrokerMessageCabineRe420(service, message);
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT):{
                //TODO implementation
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_MANAGEMENT):{
                processBrokerMessageManagament(service, message);
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT):{
                processBrokerMessagePetrinetOm(service, message);
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_PETRINET_CABINE_RE420):{
                processBrokerMessagePetrinetRe420(service, message);
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL):{
                //TODO implementation
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232):{
                //TODO implementation
                break;
            }
            default:{
                try {
                    throw new Exception("unsupported topic, broker message delegation skipped: " + message.toString());
                } catch (Exception e) {
                    LOGGER.log(Level.ERROR, e);
                }
            };
        }

    }

    /**
     *
     * @param service
     * @param message
     */
    private void processBrokerMessageManagament(BlankService service, MessageMiddleware message){
        //TODO implementation, but only messages with zusi topic (take control in gui)
    }

    /**
     *
     * @param service
     * @param message
     */
    private void processBrokerMessageCabineRe420(BlankService service, MessageMiddleware message){

    }

    /**
     *
     * @param service
     * @param message
     */
    protected void processBrokerMessagePetrinetOm(BlankService service, MessageMiddleware message){

    }

    /**
     *
     * @param service
     * @param message
     */
    protected void processBrokerMessagePetrinetRe420(BlankService service, MessageMiddleware message){

    }

    /**
     *
     * @param endpoint
     * @param message
     */
    private void delegateToEndpoint(BlankEndpointTcpClient endpoint, String message){

    }

    /**
     *
     * @param endpoint
     * @param element
     */
    private void processInitEndpoint(BlankEndpointTcpClient endpoint, MessageMiddleware element){

        switch (element.getParameter()) {
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
    public synchronized void processEndpointMessage(BlankService service, LinkedList<String> messages, String topic){
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
    public void processEndpointMessage(BlankService service, String message, String topic){

    }

}
