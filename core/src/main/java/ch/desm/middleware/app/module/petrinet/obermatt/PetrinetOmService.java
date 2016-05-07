package ch.desm.middleware.app.module.petrinet.obermatt;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.module.petrinet.obermatt.map.PetrinetOmMapInterlockingOm;
import ch.desm.middleware.app.module.petrinet.obermatt.map.PetrinetOmMapZusi;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class PetrinetOmService {

    private MessageTranslatorMiddleware translator;
    private PetrinetOmMessageProcessor processor;
    private ComponentMapMiddleware componentMapMiddleware;
    private PetrinetOmBrokerClient client;
    private PetrinetOmEndpoint endpoint;
    private PetrinetOmMapInterlockingOm map;
    private PetrinetOmMapZusi mapZusi = new PetrinetOmMapZusi();

    public PetrinetOmService(Broker broker){
        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new PetrinetOmMessageProcessor();
        this.map = new PetrinetOmMapInterlockingOm();

        this.client = new PetrinetOmBrokerClient(broker, this);
        this.endpoint = new PetrinetOmEndpoint(this);
    }


    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public PetrinetOmMessageProcessor getProcessor(){
        return processor;
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

    public PetrinetOmMapInterlockingOm getMap(){
        return map;
    }

    public PetrinetOmMapZusi getMapZusi(){
        return mapZusi;
    }

}
