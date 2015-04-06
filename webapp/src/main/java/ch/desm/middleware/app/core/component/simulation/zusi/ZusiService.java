package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.common.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.common.ComponentServiceBase;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapFahrpultAusbildung;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.*;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeDecoder;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeEncoder;

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
        this.endpointAusbildung = new ZusiEndpointTcpClient(this, ip, port, MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG);
        this.endpointFahrpult = new ZusiEndpointTcpClient(this, ip, port, MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT);
    }

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
    public ZusiProtocolCommand getCommand(){
        return new ZusiProtocolCommand();
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeEncoder getEncoder(){
        return new ZusiProtocolNodeEncoder();
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeDecoder getDecoder(){
        return new ZusiProtocolNodeDecoder();
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
    public ZusiMapFahrpultAusbildung getMap(){
        return new ZusiMapFahrpultAusbildung();
    }

}
