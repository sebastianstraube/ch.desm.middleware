package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapPetrinet;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageDecoder;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageEncoder;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.PetrinetOmlMessageProcessor;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class OmlService {

    private MessageTranslatorMiddleware translator;
    private OmlMessageProcessor processor;
    private ComponentMapMiddleware componentMapMiddleware;
    private OmlBrokerClient client;
    private OmlEndpointUbw32 endpoint;
    private OmlEndpointUbw32Cache cache;
    private OMLMapPetrinet map;



    public OmlService(Broker broker, EndpointRs232.EnumSerialPorts port){
        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new OmlMessageProcessor(this);
        this.cache = new OmlEndpointUbw32Cache();
        this.map = new OMLMapPetrinet();

        this.client = new OmlBrokerClient(broker, this);
        this.endpoint = new OmlEndpointUbw32(port, this);
    }


    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public OmlMessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public OmlBrokerClient getBrokerClient(){
        return client;
    }

    public OmlEndpointUbw32 getEndpoint(){
        return endpoint;
    }

    public OmlEndpointUbw32Cache getCache(){
        return cache;
    }

    public OMLMapPetrinet getMap(){
        return this.map;
    }
}
