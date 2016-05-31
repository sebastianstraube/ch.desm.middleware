package sebastianstraube.connectx.module.desm.simulation.zusi;

import sebastianstraube.connectx.core.communication.broker.Broker;
import sebastianstraube.connectx.core.communication.endpoint.EndpointCommon;
import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.communication.message.translator.MessageTranslatorMiddleware;
import sebastianstraube.connectx.core.component.ComponentMapBase;
import sebastianstraube.connectx.core.component.ComponentServiceBase;
import sebastianstraube.connectx.module.desm.DesmServiceMapMiddleware;
import sebastianstraube.connectx.module.desm.simulation.zusi.logic.ZusiLogicIsolierung;
import sebastianstraube.connectx.module.desm.simulation.zusi.map.*;
import sebastianstraube.connectx.module.desm.simulation.zusi.message.ZusiMessageParameterHelper;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.ZusiProtocolMessageHelper;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.node.ZusiProtocolNodeCommand;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.node.ZusiProtocolNodeCodec;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.node.ZusiProtocolNodeHelper;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService extends ComponentServiceBase {

    private ZusiBrokerClient broker;
    private String ip;
    private int port;
    private ZusiEndpointTcpClient endpointAusbildung;
    private ZusiEndpointTcpClient endpointFahrpult;
    private final DesmServiceMapMiddleware middleware = new DesmServiceMapMiddleware();
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
        this.endpointAusbildung = new ZusiEndpointTcpClient(this, ip, port, MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG, ZusiEndpointTcpClient.class.getSimpleName() + "(Ausbildung)");
        this.endpointFahrpult = new ZusiEndpointTcpClient(this, ip, port, MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT, ZusiEndpointTcpClient.class.getSimpleName() + "(Fahrpult)");
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
    public DesmServiceMapMiddleware getComponentMapMiddleware(){
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
        if(topic.equals(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG)){
            return mapAusbildungInit;
        }else if(topic.equals(MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT)){
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
