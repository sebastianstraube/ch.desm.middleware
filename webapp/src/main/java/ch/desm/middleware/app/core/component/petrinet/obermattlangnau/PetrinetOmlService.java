package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.common.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageDecoder;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageEncoder;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map.PetrinetMapOml;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map.PetrinetMapZusi;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class PetrinetOmlService {

    private MessageTranslatorMiddleware translator;
    private PetrinetOmlMessageProcessor processor;
    private PetrinetMessageEncoder encoder;
    private PetrinetMessageDecoder decoder;
    private ComponentMapMiddleware componentMapMiddleware;
    private PetrinetOmlBrokerClient client;
    private PetrinetOmlEndpoint endpoint;
    private PetrinetMapOml map;

    public PetrinetOmlService(Broker broker){
        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new PetrinetOmlMessageProcessor();
        this.encoder = new PetrinetMessageEncoder();
        this.decoder = new PetrinetMessageDecoder();
        this.map = new PetrinetMapOml();

        this.client = new PetrinetOmlBrokerClient(broker, this);
        this.endpoint = new PetrinetOmlEndpoint(this);
    }


    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public PetrinetOmlMessageProcessor getProcessor(){
        return processor;
    }

    public PetrinetMessageEncoder getEncoder(){
        return encoder;
    }

    public PetrinetMessageDecoder getDecoder(){
        return decoder;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public PetrinetOmlEndpoint getEndpoint(){
        return endpoint;
    }

    public PetrinetOmlBrokerClient getBrokerClient(){
        return client;
    }

    public PetrinetMapOml getMap(){
        return this.map;
    }

    public PetrinetMapZusi getMapZusi(){
        return new PetrinetMapZusi();
    }

}
