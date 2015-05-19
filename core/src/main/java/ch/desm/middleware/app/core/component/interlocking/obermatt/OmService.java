package ch.desm.middleware.app.core.component.interlocking.obermatt;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.common.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.interlocking.obermatt.maps.OmMapPetrinet;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class OmService {

    private MessageTranslatorMiddleware translator;
    private OmMessageProcessor processor;
    private ComponentMapMiddleware componentMapMiddleware;
    private OmBrokerClient client;
    private OmEndpointUbw32 endpoint;
    private OmEndpointUbw32Cache cache;
    private OmMapPetrinet map;



    public OmService(Broker broker, EndpointRs232.EnumSerialPorts port){
        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new OmMessageProcessor(this);
        this.cache = new OmEndpointUbw32Cache();
        this.map = new OmMapPetrinet();

        this.client = new OmBrokerClient(broker, this);
        this.endpoint = new OmEndpointUbw32(port, this);
    }


    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public OmMessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public OmBrokerClient getBrokerClient(){
        return client;
    }

    public OmEndpointUbw32 getEndpoint(){
        return endpoint;
    }

    public OmEndpointUbw32Cache getCache(){
        return cache;
    }

    public OmMapPetrinet getMap(){
        return this.map;
    }
}
