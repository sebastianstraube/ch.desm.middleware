package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.ComponentServiceBase;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiBrokerClient;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiEndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapFahrpultAusbildung;
import ch.desm.middleware.app.core.component.simulation.zusi.message.ZusiProtocolClientMessage;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.*;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeProcessor;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService extends ComponentServiceBase {

    private MessageTranslatorMiddleware translator;
    private ComponentMapMiddleware componentMapMiddleware;

    private ZusiMessageProcessor messageProcessor;
    private ZusiProtocolMessageProcessor messageCheck;

    private ZusiProtocolNodeProcessor protocolNodeProcessor;
    private ZusiProtocolCommand protocolCommand;
    private ZusiProtocolClientMessage protocolClientMessage;
    private ZusiProtocolUtilEncoder encoder;
    private ZusiProtocolUtilDecoder decoder;

    private ZusiBrokerClient brokerClientFahrpult;
    private ZusiEndpointTcpClient endpointFahrpult;

    private ZusiBrokerClient brokerClientAusbildung;
    private ZusiEndpointTcpClient endpointAusbildung;
    private ZusiMapFahrpultAusbildung map;

    /**
     *
     * @param broker
     * @param ip
     * @param port
     */
    public ZusiService(Broker broker, String ip, int port){
        this.translator = new MessageTranslatorMiddleware();
        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.map = new ZusiMapFahrpultAusbildung();

        this.messageProcessor = new ZusiMessageProcessor();
        this.messageCheck = new ZusiProtocolMessageProcessor();

        this.protocolNodeProcessor = new ZusiProtocolNodeProcessor(this);
        this.protocolCommand = new ZusiProtocolCommand();
        this.protocolClientMessage = new ZusiProtocolClientMessage(this);
        this.decoder = new ZusiProtocolUtilDecoder();
        this.encoder= new ZusiProtocolUtilEncoder();

        this.brokerClientFahrpult = new ZusiBrokerClient(broker, this);
        this.brokerClientAusbildung = new ZusiBrokerClient(broker, this);
        this.endpointFahrpult = new ZusiEndpointTcpClient(this, ip, port);
        this.endpointAusbildung = new ZusiEndpointTcpClient(this, ip, port);
    }

    /**
     *
     * @return
     */
    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    /**
     *
     * @return
     */
    public ZusiMessageProcessor getMessageProcessor(){
        return messageProcessor;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolMessageProcessor getMessageCheck(){
        return messageCheck;
    }


    /**
     *
     * @return
     */
    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeProcessor getProtocolNodeProcessor(){
        return protocolNodeProcessor;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolCommand getCommand(){
        return protocolCommand;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolUtilEncoder getEncoder(){
        return this.encoder;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolUtilDecoder getDecoder(){
        return this.decoder;
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
    public ZusiBrokerClient getBrokerClientFahrpult(){
        return brokerClientFahrpult;
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
    public ZusiBrokerClient getBrokerClientAusbildung(){
        return brokerClientAusbildung;
    }

    /**
     *
     * @return
     */
    public ZusiMapFahrpultAusbildung getMap(){
        return this.map;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolClientMessage getZusiProtocolClientMessage(){
        return this.protocolClientMessage;
    }
}
