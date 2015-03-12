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
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolNodeConverter;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolCommandTo;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService {

    private MessageTranslatorMiddleware translator;
    private ComponentMapMiddleware componentMapMiddleware;

    private ZusiMessageProcessor processor;
    private ZusiProtocolNodeConverter protocolService;
    private ZusiProtocolCommandTo protocolCommandTo;

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
        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new ZusiMessageProcessor();
        this.protocolService = new ZusiProtocolNodeConverter();
        this.protocolCommandTo = new ZusiProtocolCommandTo();

        this.brokerClientFahrpult = new ZusiFahrpultBrokerClient(broker, this);
        this.mapFahrpult = new ZusiMapFahrpult();
        this.endpointFahrpult = new ZusiFahrpultEndpointTcpClient(this, ip, port);

        this.brokerClientAusbildung = new ZusiAusbildungBrokerClient(broker, this);
        this.endpointAusbildung = new ZusiAusbildungEndpointTcpClient(this, ip, port);
        this.mapAusbildung = new ZusiMapAusbildung();
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
    public ZusiMessageProcessor getProcessor(){
        return processor;
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
    public ZusiProtocolNodeConverter getProtocolService(){
        return protocolService;
    }

    /**
     *
     * @return
     */
    public ZusiProtocolCommandTo getProtocolCommandTo(){
        return protocolCommandTo;
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

}
