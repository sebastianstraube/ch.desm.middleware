package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiAusbildungBrokerClient;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiAusbildungEndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultBrokerClient;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultEndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapAusbildung;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapFahrpult;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.*;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService {

    private MessageTranslatorMiddleware translator;
    private ComponentMapMiddleware componentMapMiddleware;

    private ZusiMessageProcessor messageProcessor;
    private ZusiProtocolUtilMessageCheck messageCheck;

    private ZusiProtocolNodeProcessor protocolNodeProcessor;
    private ZusiProtocolUtilCommand protocolCommand;
    private ZusiProtocolClientMessage protocolClientMessage;
    private ZusiProtocolUtilEncoder encoder;
    private ZusiProtocolUtilDecoder decoder;

    private ZusiFahrpultBrokerClient brokerClientFahrpult;
    private ZusiFahrpultEndpointTcpClient endpointFahrpult;
    private ZusiMapFahrpult mapFahrpult;

    private ZusiAusbildungBrokerClient brokerClientAusbildung;
    private ZusiAusbildungEndpointTcpClient endpointAusbildung;
    private ZusiMapAusbildung mapAusbildung;

    /**
     *
     * @param broker
     * @param ip
     * @param port
     */
    public ZusiService(Broker broker, String ip, int port){
        this.translator = new MessageTranslatorMiddleware();
        this.componentMapMiddleware = new ComponentMapMiddleware();

        this.messageProcessor = new ZusiMessageProcessor();
        this.messageCheck = new ZusiProtocolUtilMessageCheck();

        this.protocolNodeProcessor = new ZusiProtocolNodeProcessor(this);
        this.protocolCommand = new ZusiProtocolUtilCommand(this);
        this.protocolClientMessage = new ZusiProtocolClientMessage();
        this.decoder = new ZusiProtocolUtilDecoder();
        this.encoder= new ZusiProtocolUtilEncoder();

        this.brokerClientFahrpult = new ZusiFahrpultBrokerClient(broker, this);
        this.mapFahrpult = new ZusiMapFahrpult();
        this.endpointFahrpult = new ZusiFahrpultEndpointTcpClient(this, ip, port);

        this.brokerClientAusbildung = new ZusiAusbildungBrokerClient(broker, this);
        this.mapAusbildung = new ZusiMapAusbildung();
        this.endpointAusbildung = new ZusiAusbildungEndpointTcpClient(this, ip, port);
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
    public ZusiProtocolUtilMessageCheck getMessageCheck(){
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
    public ZusiProtocolUtilCommand getCommand(){
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
    public ZusiFahrpultEndpointTcpClient getEndpointFahrpult(){
        return endpointFahrpult;
    }

    /**
     *
     * @return
     */
    public ZusiFahrpultBrokerClient getBrokerClientFahrpult(){
        return brokerClientFahrpult;
    }

    /**
     *
     * @return
     */
    public ZusiMapFahrpult getMapFahrpult(){
        return this.mapFahrpult;
    }

    /**
     *
     * @return
     */
    public ZusiAusbildungEndpointTcpClient getEndpointAusbildung(){
        return endpointAusbildung;
    }

    /**
     *
     * @return
     */
    public ZusiAusbildungBrokerClient getBrokerClientAusbildung(){
        return brokerClientAusbildung;
    }

    /**
     *
     * @return
     */
    public ZusiMapAusbildung getMapAusbildung(){
        return this.mapAusbildung;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolClientMessage getZusiProtocolClientMessage(){
        return this.protocolClientMessage;
    }
}
