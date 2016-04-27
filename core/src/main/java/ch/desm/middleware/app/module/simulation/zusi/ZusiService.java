package ch.desm.middleware.app.module.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapBase;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.ComponentServiceBase;
import ch.desm.middleware.app.module.simulation.zusi.logic.ZusiLogicIsolierung;
import ch.desm.middleware.app.module.simulation.zusi.map.*;
import ch.desm.middleware.app.module.simulation.zusi.message.ZusiMessageParameterHelper;
import ch.desm.middleware.app.module.simulation.zusi.protocol.*;
import ch.desm.middleware.app.module.simulation.zusi.protocol.node.ZusiProtocolNodeCommand;
import ch.desm.middleware.app.module.simulation.zusi.protocol.node.ZusiProtocolNodeCodec;
import ch.desm.middleware.app.module.simulation.zusi.protocol.node.ZusiProtocolNodeHelper;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService extends ComponentServiceBase {

    private ZusiBrokerClient broker;
    private String ip;
    private int port;
    private ZusiEndpointTcpClient endpointAusbildung;
    private ZusiEndpointTcpClient endpointFahrpult;
    private final ComponentMapMiddleware middleware = new ComponentMapMiddleware();
    private final ZusiMessageProcessor messageProcessor = new ZusiMessageProcessor();
    private final ZusiProtocolMessageHelper protocolMessageHelper = new ZusiProtocolMessageHelper();
    private final MessageTranslatorMiddleware messageTranslatorMiddleware = new MessageTranslatorMiddleware();
    private final ZusiProtocolNodeCodec protocolNodeCodec = new ZusiProtocolNodeCodec();
    private final ZusiMapParameterDataType mapParameterDataType = new ZusiMapParameterDataType();
    private final ZusiMapParameter mapParameter = new ZusiMapParameter();
    private final ZusiMapParameterRe420 mapParameterRe420 = new ZusiMapParameterRe420();
    private final ZusiProtocolNodeCommand protocolNodeCommand = new ZusiProtocolNodeCommand();
    private final ZusiMapPetrinetOm mapPetrinetOm = new ZusiMapPetrinetOm();
    private final ZusiLogicIsolierung logicIsolierung = new ZusiLogicIsolierung();
    private final ZusiEndpointLogic endpointLogic = new ZusiEndpointLogic();
    private final ZusiMapPetrinetRe420 mapPetrinetRe420 = new ZusiMapPetrinetRe420();
    private final ZusiMapAusbildungInit mapAusbildungInit = new ZusiMapAusbildungInit();
    private final ZusiMapFahrpultInit mapFahrpultInit = new ZusiMapFahrpultInit();
    private final ZusiMessageParameterHelper messageParameterHelper;
    private final ZusiProtocolNodeHelper protocolNodeHelper;

    /**
     *
     * @param broker
     * @param ip
     * @param port
     */
    public ZusiService(Broker broker, String ip, int port){
        this.ip = ip;
        this.port = port;
        this.broker = new ZusiBrokerClient(broker, this);
        this.endpointAusbildung = new ZusiEndpointTcpClient(this, ip, port, MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG, ZusiEndpointTcpClient.class.getSimpleName() + "(Ausbildung)");
        this.endpointFahrpult = new ZusiEndpointTcpClient(this, ip, port, MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT, ZusiEndpointTcpClient.class.getSimpleName() + "(Fahrpult)");
        this.messageParameterHelper = new ZusiMessageParameterHelper(this);
        this.protocolNodeHelper = new ZusiProtocolNodeHelper(this);
    }

    public ZusiService() {
        this.messageParameterHelper = new ZusiMessageParameterHelper(this);
        this.protocolNodeHelper = new ZusiProtocolNodeHelper(this);
    }

    /**
     *
     * @return
     */
    public ComponentMapMiddleware getComponentMapMiddleware(){
        return middleware;
    }

    /**
     *
     * @return
     */
    public ZusiMessageProcessor getMessageProcessor(){
        return messageProcessor;
    }

    @Override
    public EndpointCommon getEndpoint() {
        return null;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolMessageHelper getMessageCheck(){
        return protocolMessageHelper;
    }


    /**
     *
     * @return
     */
    public MessageTranslatorMiddleware getTranslator(){
        return messageTranslatorMiddleware;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeCodec getCodec(){
        return protocolNodeCodec;
    }

    /**
     *
     * @return
     */
    public ZusiEndpointTcpClient getEndpointFahrpult(){
        return endpointFahrpult;
    }

    /**
     *
     * @return
     */
    public ZusiEndpointTcpClient getEndpointAusbildung(){
        return endpointAusbildung;
    }

    /**
     *
     * @return
     */
    public ZusiBrokerClient getBrokerClient(){
        return broker;
    }

    /**
     *
     * @return
     */
    public ComponentMapBase getMap(String topic){
        if(topic.equals(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG)){
            return mapAusbildungInit;
        }else if(topic.equals(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT)){
            return mapFahrpultInit;
        }

        return null;
    }

    /**
     *
     * @return
     */
    public ZusiMapParameterDataType getZusiMapParameterDataType(){
        return mapParameterDataType;
    }

    /**
     *
     * @return
     */
    public ZusiMapParameter getZusiMapParameter(){
        return mapParameter;
    }


    /**
     *
     * @return
     */
    public ZusiMessageParameterHelper getZusiParameterConverter(){
        return messageParameterHelper;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeHelper getZusiProtocolNodeHelper(){
        return protocolNodeHelper;
    }

    /**
     *
     * @return
     */
    public ZusiMapParameterRe420 getZusiMapParameterMiddleware(){
        return mapParameterRe420;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeCommand getZusiProtocolCommand(){
        return protocolNodeCommand;
    }

    /**
     *
     * @return
     */
    public ZusiMapPetrinetOm getZusiMapPetrinet(){
        return mapPetrinetOm;
    }

    /**
     *
     * @return
     */
    public ZusiLogicIsolierung getZusiLogicIsolierung(){
        return logicIsolierung;
    }

    /**
     *
     * @return
     */
    public ZusiEndpointLogic getZusiEndpointLogic(){
        return endpointLogic;
    }

    public ZusiMapPetrinetRe420 getZusiMapPetrinetRe420(){
        return mapPetrinetRe420;
    }
}
