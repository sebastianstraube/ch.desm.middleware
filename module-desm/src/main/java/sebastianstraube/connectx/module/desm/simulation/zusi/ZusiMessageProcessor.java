package sebastianstraube.connectx.module.desm.simulation.zusi;

import sebastianstraube.connectx.core.communication.message.BadParameterTypeCastException;
import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorBase;;
import sebastianstraube.connectx.module.desm.simulation.zusi.map.ZusiMapParameterRe420;
import sebastianstraube.connectx.module.desm.simulation.zusi.message.ZusiMessageEndpoint;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.ZusiProtocolConstants;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.node.ZusiProtocolNode;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMessageProcessor extends ComponentMessageProcessorBase<ZusiService> {

    private static Logger LOGGER = Logger.getLogger(ZusiMessageProcessor.class);

    /**
     * @param messages
     */
    public void processBrokerMessage(ZusiService service, List<MessageCommon> messages) {
        for(MessageCommon message : messages){
            processBrokerMessage(service, message);
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    public void processBrokerMessage(ZusiService service, MessageCommon message){

        switch(message.getTopic()){
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
     * @param globalId
     */
    private void processBrokerMessageZusiFahrpult(ZusiService service, String globalId){
        ZusiProtocolNode root = service.getZusiProtocolNodeHelper().getRoot(globalId);

        try {
            String zusiStream = service.getCodec().encode(root);
            delegateToEndpoint(service.getEndpointFahrpult(), zusiStream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     *
     * @param service
     * @param globalId
     */
    private void processBrokerMessageZusiAusbildung(ZusiService service, String globalId){
        ZusiProtocolNode root = service.getZusiProtocolNodeHelper().getRoot(globalId);

        try {
            String zusiStream = service.getCodec().encode(root);
            LOGGER.log(Level.INFO, "delegating message with globalId: " + globalId + "\n stream: " + zusiStream + "\n node:" +root+ "\n\n");
            delegateToEndpoint(service.getEndpointAusbildung(), zusiStream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    private void processBrokerMessageManagament(ZusiService service, MessageCommon message){
        //if init message skip message processing
        if (initEndpoint(service, message)) {
            return;
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    protected void processBrokerMessagePetrinetOm(ZusiService service, MessageCommon message){
        final Boolean isParameterOn;
        final String parameterAsOnOff;
        try {
            isParameterOn = message.getParameterAsBoolean();
            parameterAsOnOff = message.getParameterAsOnOff();
        } catch (BadParameterTypeCastException e) {
            LOGGER.log(Level.ERROR, "Received broker message with type " + message.getTypeName() + " but expected Boolean");
            return;
        }

        if (!isParameterOn) {
            LOGGER.log(Level.INFO, "petrinet broker message processing skipped cause parameter off: " + message);
            return;
        }

        String key = service.getZusiMapPetrinet().getKeyForValue(message.getGlobalId());
        if(key.isEmpty()) {
            LOGGER.log(Level.INFO, "petrinet broker message processing skipped: " + message);
            return;
        }

        String mwmStream = service.getComponentMapMiddleware().getValueForKey(key);
        // TODO: improve how parameter replacement is done
        mwmStream = MessageCommon.replaceMiddlewareMessageDelimiter(mwmStream, parameterAsOnOff);
        MessageCommon mwm = service.getTranslator().toMiddlewareMessage(mwmStream);
        if (mwm == null) {
            LOGGER.log(Level.ERROR, "Unable to translate message " + mwmStream);
        }

        switch (mwm.getTopic().toLowerCase()) {
            case MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG:
                processBrokerMessageZusiAusbildung(service, mwm.getGlobalId());
                break;
            case MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT:
                processBrokerMessageZusiFahrpult(service, mwm.getGlobalId());
                break;
            default:
                LOGGER.log(Level.WARN, "Received message for topic we did not subscribe to: " + mwm.getTopic());
                break;
        }
    }

    /**
     *
     * @param service
     * @param message
     */
    protected void processBrokerMessagePetrinetRe420(ZusiService service, MessageCommon message){
        final Boolean isParameterOn;
        final String parameterAsOnOff;
        try {
            isParameterOn = message.getParameterAsBoolean();
            parameterAsOnOff = message.getParameterAsOnOff();
        } catch (BadParameterTypeCastException e) {
            LOGGER.log(Level.ERROR, "Received broker message with type " + message.getTypeName() + " but expected Boolean");
            return;
        }

        if (!isParameterOn) {
            LOGGER.log(Level.INFO, "petrinet broker message processing skipped cause parameter off: " + message);
            return;
        }

        String key = service.getZusiMapPetrinetRe420().getKeyForValue(message.getGlobalId());
        if(key.isEmpty()) {
            LOGGER.log(Level.INFO, "petrinet broker message processing skipped: " + message);
            return;
        }

        String mwmStream = service.getComponentMapMiddleware().getValueForKey(key);
        // TODO: improve how parameter replacement is done
        mwmStream = MessageCommon.replaceMiddlewareMessageDelimiter(mwmStream, parameterAsOnOff);
        MessageCommon mwm = service.getTranslator().toMiddlewareMessage(mwmStream);

        if(mwm.getTopic().equalsIgnoreCase(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG)){
            processBrokerMessageZusiAusbildung(service, mwm.getGlobalId());
        } else if(mwm.getTopic().equalsIgnoreCase(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT)){
            processBrokerMessageZusiFahrpult(service, mwm.getGlobalId());
        }

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
     * @param service
     * @param messages
     * @param topic
     */
    public synchronized void processEndpointMessage(ZusiService service, List<String> messages, String topic){
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
            List<String> globalIds = service.getZusiProtocolNodeHelper().getGlobalId(message);

            for(String globalId : globalIds){
                ZusiMessageEndpoint zusiMessage = new ZusiMessageEndpoint(globalId);
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
        for(Map.Entry<String, String> p: zusiMessage.getParameterList().entrySet()){
            String globalId = getGlobalId(zusiMessage, p.getKey());
            String mwm = service.getMap(topic).getStartWithKey(globalId);
            if(mwm.isEmpty()) mwm = service.getComponentMapMiddleware().getValueForKey(globalId);
            String parameterValue = service.getZusiParameterConverter().getNumber(globalId, p.getValue());
            parameterValue = parameterValue.isEmpty() ? p.getValue() : parameterValue;

            ZusiMapParameterRe420.OnOffState state = service.getZusiMapParameterMiddleware().getValue(globalId);
            if(state!=null){
                // TODO: fix parameter value deduction
                if(state.getOnState().equals(parameterValue)) parameterValue = MessageCommon.MESSAGE_PARAMETER_ON;
                else if(state.getOffState().equals(parameterValue)) parameterValue = MessageCommon.MESSAGE_PARAMETER_OFF;
            }
            mwm = MessageCommon.replaceMiddlewareMessageDelimiter(mwm, parameterValue);

            if(!mwm.isEmpty()){
                processLogicParameter(service, globalId, parameterValue);
                super.processEndpointMessage(service.getBrokerClient(), mwm, topic);
            }else{
                LOGGER.log(Level.WARN, "global id not found: "+globalId+", parameter: " + p.getValue() + ", topic: " + topic + "  ("+zusiMessage+")");
            }
        }
    }

    @Override
    protected boolean initEndpoint(ZusiService service, MessageCommon element) {

        if(element.getType().equals(MessageCommon.ParameterType.STRING)){
            final String parameter;
            try {
                parameter = element.getParameterAsString();
            } catch (BadParameterTypeCastException e) {
                LOGGER.log(Level.ERROR, "Received init message with type " + element.getTypeName() + " but expected String");
                return false;
            }

            switch (parameter) {
                case ("init"): {
                    service.getEndpoint().init();
                    return true;
                }
                case ("start"): {
                    service.getEndpoint().start();
                    return true;
                }
                case ("stop"): {
                    service.getEndpoint().stop();
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     * @param service
     * @param globalId
     * @param parameterValue
     */
    protected void processLogicParameter(ZusiService service, String globalId, String parameterValue){
        for(String mwm : service.getZusiEndpointLogic().getIsoMwmFromParameter(service, globalId, parameterValue)){
            super.processEndpointMessage(service.getBrokerClient(), mwm, MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG);
        }
    }

    private String getGlobalId(ZusiMessageEndpoint zusiMessage, String name){
        return zusiMessage.getGroupId()+ZusiProtocolConstants.DELIMITER_GROUP+name;
    }
}
