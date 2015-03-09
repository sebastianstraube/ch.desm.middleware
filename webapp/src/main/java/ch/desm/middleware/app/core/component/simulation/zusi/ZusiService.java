package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapOml;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolService;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolServiceTest;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService {

    private MessageTranslatorMiddleware translator;
    private ZusiMessageProcessor processor;
    private ComponentMapMiddleware componentMapMiddleware;
    private ZusiBrokerClient client;
    private ZusiEndpointTcpClient endpoint;
    private ZusiMapOml map;
    private ZusiProtocolService protocolService;
    private ZusiProtocolServiceTest protocolServiceTest;


    public ZusiService(Broker broker, String ip, int port){

        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new ZusiMessageProcessor();
        this.map = new ZusiMapOml();
        this.protocolService = new ZusiProtocolService();

        this.client = new ZusiBrokerClient(broker, this);
        this.endpoint = new ZusiEndpointTcpClient(this, ip, port);
        this.protocolServiceTest = new ZusiProtocolServiceTest();

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

    public ZusiEndpointTcpClient getEndpoint(){
        return endpoint;
    }

    public ZusiBrokerClient getBrokerClient(){
        return client;
    }

    public ZusiMapOml getMap(){
        return this.map;
    }

    public ZusiProtocolServiceTest getProtocolServiceTest(){
        return protocolServiceTest;
    }

    public ZusiProtocolService getProtocolService(){
        return protocolService;
    }


}
