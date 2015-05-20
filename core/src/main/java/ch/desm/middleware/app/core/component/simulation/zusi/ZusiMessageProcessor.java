package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.common.Pair;
import ch.desm.middleware.app.common.utility.UtilityMessageProcessor;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.common.ComponentMessageProcessorBase;;
import ch.desm.middleware.app.core.component.simulation.zusi.message.ZusiMessageEndpoint;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
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
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_CABINE_RE420):{
                //TODO implementation
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_CABINE_RE420_FABISCH):{
                //TODO implementation
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU):{
                //TODO implementation
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_MANAGEMENT):{
                processBrokerMessageManagament(service, message);
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU):{
                processBrokerMessagePetrinet(service, message);
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
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT):{
                processBrokerMessageZusiFahrpult(service, message);
                break;
            }
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG):{
                processBrokerMessageZusiAusbildung(service, message);
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
     * @param message = 0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi;#
     */
    private void processBrokerMessageZusiFahrpult(ZusiService service, MessageMiddleware message){
        if(message.getParameter().equalsIgnoreCase("on")){
            ZusiProtocolNode root = service.getZusiProtocolNodeHelper().getRoot(message.getGlobalId());

            try {
                String zusiStream = service.getCodec().encode(root);
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
            ZusiProtocolNode root = service.getZusiProtocolNodeHelper().getRoot(message.getGlobalId());

            try {
                String zusiStream = service.getCodec().encode(root);
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
        //TODO implementation, but only messages with zusi topic (take control in gui)
    }

    /**
     *
     * @param service
     * @param message
     */
    protected void processBrokerMessagePetrinet(ZusiService service, MessageMiddleware message){
        String key = service.getZusiMapPetrinet().getKey(message.getGlobalId());
        if(!key.isEmpty()){
            String mwmStream = service.getComponentMapMiddleware().getValue(key);
            mwmStream = UtilityMessageProcessor.replaceMiddlewareMessageDelimiter(mwmStream, message.getParameter());
            MessageMiddleware mwm = service.getTranslator().toMiddlewareMessage(mwmStream);
            mwm.setParameter(message.getParameter());

            if(mwm.getTopic().equalsIgnoreCase(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG)){
                processBrokerMessageZusiAusbildung(service, mwm);
            }
            else if(mwm.getTopic().equalsIgnoreCase(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT)){
                processBrokerMessageZusiFahrpult(service, mwm);
            }
        }else LOGGER.log(Level.TRACE, "petrinet mapping non-existent with message: " + message);
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
        LinkedList<String> globalIds;
        ZusiMessageEndpoint zusiMessage;
        try {
            LOGGER.log(Level.INFO, "process endpoint message: " + message + ", topic: " + topic);
            globalIds = service.getZusiProtocolNodeHelper().getGlobalId(message);

            for(String globalId : globalIds){
                zusiMessage = new ZusiMessageEndpoint(globalId);
                processEndpointFahrpultMessage(service, zusiMessage, topic);
            }
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
    private void processEndpointFahrpultMessage(ZusiService service, ZusiMessageEndpoint zusiMessage, String topic){

        //send message for every parameter
        for(Pair<String, String> p: zusiMessage.getParameterList()){
            String globalId = getGlobalId(zusiMessage, p);
            String mwm = service.getMap(topic).getStartWithKey(globalId);
            if(mwm.isEmpty()) mwm = service.getComponentMapMiddleware().getValue(globalId);
            String parameterValue = service.getZusiParameterConverter().getNumber(globalId, p.getRight());
            parameterValue = parameterValue.isEmpty() ? p.getRight() : parameterValue;

            Pair<String, String> parameter = service.getZusiMapParameterMiddleware().getValue(globalId);
            if(parameter!=null){
                if(parameter.getLeft().equals(parameterValue)) parameterValue = "on";
                else if(parameter.getRight().equals(parameterValue)) parameterValue = "off";
            }
            mwm = UtilityMessageProcessor.replaceMiddlewareMessageDelimiter(mwm, parameterValue);

            if(!mwm.isEmpty()){
                processLogicParameter(service, globalId, parameterValue);
                super.processEndpointMessage(service.getBrokerClient(), mwm, topic);
            }else{
                LOGGER.log(Level.WARN, "global id not found: "+globalId+", parameter: " + p.getRight() + ", topic: " + topic + "  ("+zusiMessage+")");
            }
        }
    }

    /**
     *
     * @param service
     * @param globalId
     * @param parameterValue
     */
    protected void processLogicParameter(ZusiService service, String globalId, String parameterValue){
        ArrayList<String> l = service.getZusiEndpointLogic().getIsoMwmFromParameter(service, globalId, parameterValue);
        for(String mwm : l){
            super.processEndpointMessage(service.getBrokerClient(), mwm, service.getZusiEndpointLogic().getIsolierungTopic());
        }
    }

    private String getGlobalId(ZusiMessageEndpoint zusiMessage, Pair p){
        return zusiMessage.getGroupId()+ZusiProtocolConstants.DELIMITER_GROUP+p.getLeft();
    }
}
