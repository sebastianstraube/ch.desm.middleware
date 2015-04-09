package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.common.Pair;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.common.ComponentMessageProcessorBase;;
import ch.desm.middleware.app.core.component.simulation.zusi.message.ZusiEndpointMessage;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelper;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMessageProcessor extends ComponentMessageProcessorBase<ZusiService> {

    private static Logger LOGGER = Logger.getLogger(ZusiMessageProcessor.class);

    /**
     * @param messages
     */
    public void processBrokerMessage(ZusiService service, LinkedList<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(service, message);
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    public void processBrokerMessage(ZusiService service, MessageMiddleware message){

        switch(message.getTopic()){
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_CABINE_RE420):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_CABINE_RE420_FABISCH):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_MANAGEMENT):{
                processBrokerMessageManagament(service, message);
            };
            case(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT):{
                processBrokerMessageZusiFahrpult(service, message);
            };
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG):{
                processBrokerMessageZusiAusbildung(service, message);
            };

            standard:{
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
     * @param message = 0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi;#
     */
    private void processBrokerMessageZusiFahrpult(ZusiService service, MessageMiddleware message){
        if(message.getParameter().equalsIgnoreCase("on")){
            ZusiEndpointMessage z = new ZusiEndpointMessage(message.getGlobalId());

            try {
                String zusiStream = service.getCommand().getStreamToZusi(service, message.getGlobalId());
                delegateToEndpoint(service.getEndpointFahrpult(), zusiStream);
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }

    /**
     *
     * @param service
     * @param message = 0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi;#
     */
    private void processBrokerMessageZusiAusbildung(ZusiService service, MessageMiddleware message){
        if(message.getParameter().equalsIgnoreCase("on")){
            ZusiEndpointMessage z = new ZusiEndpointMessage(message.getGlobalId());

            try {
                String zusiStream = service.getCommand().getStreamToZusi(service, message.getGlobalId());
                delegateToEndpoint(service.getEndpointAusbildung(), zusiStream);
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    private void processBrokerMessageManagament(ZusiService service, MessageMiddleware message){
        //TODO implementation
    }

    /**
     *
     * @param endpoint
     * @param message
     */
    private void delegateToEndpoint(ZusiEndpointTcpClient endpoint, String message){
        LOGGER.log(Level.INFO, "processing endpoint message: " + message);

        try {
            endpoint.send(message);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     *
     * @param endpoint
     * @param element
     */
    private void processInitEndpoint(ZusiEndpointTcpClient endpoint, MessageMiddleware element){

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
    public synchronized void processEndpointMessage(ZusiService service, LinkedList<String> messages, String topic){
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
    public void processEndpointMessage(ZusiService service, String message, String topic){
        try {
            LOGGER.log(Level.INFO, "process endpoint message: " + message + ", topic: " + topic);
            String globalId = service.getZusiProtocolNodeHelper().getGlobalId(message, service);
            ZusiEndpointMessage zusiMessage = new ZusiEndpointMessage(globalId);
            processEndpointParameterMessage(service, zusiMessage, topic);

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     *
     * @param service
     * @param zusiMessage
     * @param topic
     */
    private void processEndpointParameterMessage(ZusiService service, ZusiEndpointMessage zusiMessage, String topic){

        //send message for every parameter
        for(Pair<String, String> p: zusiMessage.getParameterList()){
            String globalId = zusiMessage.getGroupId()+ZusiProtocolConstants.DELIMITER_GROUP+p.getLeft();
            String middlewareMessage = service.getMap(topic).getStartWithValue(globalId);
            String parameterValue = service.getZusiParameterConverter().getNumber(globalId, p.getRight());
            parameterValue = parameterValue.isEmpty() ? p.getRight() : parameterValue;
            middlewareMessage = middlewareMessage.replace("?", parameterValue);
            if(!middlewareMessage.isEmpty()){
                //send middleware message to broker clients
                super.processEndpointMessage(service.getBrokerClient(), middlewareMessage, topic);
            }else{
                LOGGER.log(Level.WARN, "global id not found: "+globalId+", parameter: " + p.getRight() + ", topic: " + topic + "  ("+zusiMessage+")");
            }

        }
    }
}
