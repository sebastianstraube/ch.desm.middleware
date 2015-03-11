package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultBrokerClient;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultEndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapOml;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolNodeConverter;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolCommand;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService {

    private MessageTranslatorMiddleware translator;
    private ZusiMessageProcessor processor;
    private ComponentMapMiddleware componentMapMiddleware;
    private ZusiFahrpultBrokerClient brokerClientFahrpult;
    private ZusiFahrpultEndpointTcpClient endpointFahrpult;
    private ZusiProtocolNodeConverter protocolService;
    private ZusiProtocolCommand protocolCommand;
    private ZusiMapOml map;

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
        this.map = new ZusiMapOml();
        this.protocolService = new ZusiProtocolNodeConverter();

        this.brokerClientFahrpult = new ZusiFahrpultBrokerClient(broker, this);
        this.endpointFahrpult = new ZusiFahrpultEndpointTcpClient(this, ip, port);
        this.protocolCommand = new ZusiProtocolCommand();

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
    public ZusiFahrpultEndpointTcpClient getEndpointFahrpult(){
        return endpointFahrpult;
    }

    /**
     *
     * @return
     */
    public ZusiFahrpultBrokerClient getBrokerClient(){
        return brokerClientFahrpult;
    }

    /**
     *
     * @return
     */
    public ZusiMapOml getMap(){
        return this.map;
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
    public ZusiProtocolCommand getProtocolCommand(){
        return protocolCommand;
    }


}
