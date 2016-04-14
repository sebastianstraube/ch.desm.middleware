package ch.desm.middleware.app.module.simulation.etcs;

import ch.desm.middleware.app.core.component.ComponentMessageProcessorBase;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
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
    public void processBrokerMessage(EtcsService service, List<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(service, message);
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    public void processBrokerMessage(EtcsService service, MessageMiddleware message){

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
    private void processBrokerMessageManagament(EtcsService service, MessageMiddleware message){
        //TODO implementation, but only messages with zusi topic (take control in gui)
    }

    /**
     *
     * @param service
     * @param message
     */
    private void processBrokerMessageCabineRe420(EtcsService service, MessageMiddleware message){

    }

    /**
     *
     * @param service
     * @param message
     */
    protected void processBrokerMessagePetrinetOm(EtcsService service, MessageMiddleware message){

    }

    /**
     *
     * @param service
     * @param message
     */
    protected void processBrokerMessagePetrinetRe420(EtcsService service, MessageMiddleware message){

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
    private void processInitEndpoint(EtcsEndpointTcpClient endpoint, MessageMiddleware element){

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
