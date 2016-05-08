package ch.desm.middleware.module.desm.petrinet.obermatt;

import ch.desm.middleware.core.communication.broker.Broker;
import ch.desm.middleware.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.module.DesmMapMiddleware;
import ch.desm.middleware.module.desm.petrinet.obermatt.map.PetrinetOmMapInterlockingOm;
import ch.desm.middleware.module.desm.petrinet.obermatt.map.PetrinetOmMapZusi;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class PetrinetOmService {

    private MessageTranslatorMiddleware translator;
    private PetrinetOmMessageProcessor processor;
    private DesmMapMiddleware componentMapMiddleware;
    private PetrinetOmBrokerClient client;
    private PetrinetOmEndpoint endpoint;
    private PetrinetOmMapInterlockingOm map;
    private PetrinetOmMapZusi mapZusi = new PetrinetOmMapZusi();

    public PetrinetOmService(Broker broker){
        this.componentMapMiddleware = new DesmMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new PetrinetOmMessageProcessor();
        this.map = new PetrinetOmMapInterlockingOm();

        this.client = new PetrinetOmBrokerClient(broker, this);
        this.endpoint = new PetrinetOmEndpoint(this);
    }


    public DesmMapMiddleware getComponentMapMiddleware(){
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
