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
    }


    /**
     *
     */
    public ZusiService() {}

    /**
     *
     * @return
     */
    public ComponentMapMiddleware getComponentMapMiddleware(){
        return new ComponentMapMiddleware();
    }

    /**
     *
     * @return
     */
    public ZusiMessageProcessor getMessageProcessor(){
        return new ZusiMessageProcessor();
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
        return new ZusiProtocolMessageHelper();
    }


    /**
     *
     * @return
     */
    public MessageTranslatorMiddleware getTranslator(){
        return new MessageTranslatorMiddleware();
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeCodec getCodec(){
        return new ZusiProtocolNodeCodec();
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
            return new ZusiMapAusbildungInit();
        }else if(topic.equals(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT)){
            return new ZusiMapFahrpultInit();
        }

        return null;
    }

    /**
     *
     * @return
     */
    public ZusiMapParameterDataType getZusiMapParameterDataType(){
        return new ZusiMapParameterDataType();
    }

    /**
     *
     * @return
     */
    public ZusiMapParameter getZusiMapParameter(){
        return new ZusiMapParameter();
    }


    /**
     *
     * @return
     */
    public ZusiMessageParameterHelper getZusiParameterConverter(){
        return new ZusiMessageParameterHelper(this);
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeHelper getZusiProtocolNodeHelper(){
        return new ZusiProtocolNodeHelper(this);
    }

    /**
     *
     * @return
     */
    public ZusiMapParameterRe420 getZusiMapParameterMiddleware(){
        return new ZusiMapParameterRe420();
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeCommand getZusiProtocolCommand(){
        return new ZusiProtocolNodeCommand();
    }

    /**
     *
     * @return
     */
    public ZusiMapPetrinetOm getZusiMapPetrinet(){
        return new ZusiMapPetrinetOm();
    }

    /**
     *
     * @return
     */
    public ZusiLogicIsolierung getZusiLogicIsolierung(){
        return new ZusiLogicIsolierung();
    }

    /**
     *
     * @return
     */
    public ZusiEndpointLogic getZusiEndpointLogic(){
        return new ZusiEndpointLogic();
    }

    /**
     *
     * @return
     */
    public ZusiMapCabineRe420 getZusiMapRe420(){
        return new ZusiMapCabineRe420();
    }

    public ZusiMapPetrinetRe420 getZusiMapPetrinetRe420(){
        return new ZusiMapPetrinetRe420();
    }
}
