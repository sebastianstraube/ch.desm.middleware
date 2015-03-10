package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultBrokerClient;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultEndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapOml;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocol;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolTest;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService {

    private MessageTranslatorMiddleware translator;
    private ZusiMessageProcessor processor;
    private ComponentMapMiddleware componentMapMiddleware;
    private ZusiFahrpultBrokerClient brokerClientFahrpult;
    private ZusiFahrpultEndpointTcpClient endpointFahrpult;
    private ZusiProtocol protocolService;
    private ZusiProtocolTest protocolServiceTest;
    private ZusiMapOml map;

    public ZusiService(Broker broker, String ip, int port){

        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new ZusiMessageProcessor();
        this.map = new ZusiMapOml();
        this.protocolService = new ZusiProtocol();

        this.brokerClientFahrpult = new ZusiFahrpultBrokerClient(broker, this);
        this.endpointFahrpult = new ZusiFahrpultEndpointTcpClient(this, ip, port);
        this.protocolServiceTest = new ZusiProtocolTest();

    }
    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public ZusiMessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public ZusiFahrpultEndpointTcpClient getEndpointFahrpult(){
        return endpointFahrpult;
    }

    public ZusiFahrpultBrokerClient getBrokerClient(){
        return brokerClientFahrpult;
    }

    public ZusiMapOml getMap(){
        return this.map;
    }

    public ZusiProtocolTest getProtocolServiceTest(){
        return protocolServiceTest;
    }

    public ZusiProtocol getProtocolService(){
        return protocolService;
    }


}
