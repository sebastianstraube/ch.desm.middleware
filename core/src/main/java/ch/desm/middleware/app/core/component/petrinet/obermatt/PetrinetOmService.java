package ch.desm.middleware.app.core.component.petrinet.obermatt;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.common.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageDecoder;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageEncoder;
import ch.desm.middleware.app.core.component.petrinet.obermatt.map.PetrinetOmMapInterlockingOml;
import ch.desm.middleware.app.core.component.petrinet.obermatt.map.PetrinetOmMapZusi;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class PetrinetOmService {

    private MessageTranslatorMiddleware translator;
    private PetrinetOmMessageProcessor processor;
    private PetrinetMessageEncoder encoder;
    private PetrinetMessageDecoder decoder;
    private ComponentMapMiddleware componentMapMiddleware;
    private PetrinetOmBrokerClient client;
    private PetrinetOmEndpoint endpoint;
    private PetrinetOmMapInterlockingOml map;

    public PetrinetOmService(Broker broker){
        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new PetrinetOmMessageProcessor();
        this.encoder = new PetrinetMessageEncoder();
        this.decoder = new PetrinetMessageDecoder();
        this.map = new PetrinetOmMapInterlockingOml();

        this.client = new PetrinetOmBrokerClient(broker, this);
        this.endpoint = new PetrinetOmEndpoint(this);
    }


    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public PetrinetOmMessageProcessor getProcessor(){
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

    public PetrinetOmEndpoint getEndpoint(){
        return endpoint;
    }

    public PetrinetOmBrokerClient getBrokerClient(){
        return client;
    }

    public PetrinetOmMapInterlockingOml getMap(){
        return this.map;
    }

    public PetrinetOmMapZusi getMapZusi(){
        return new PetrinetOmMapZusi();
    }

}
