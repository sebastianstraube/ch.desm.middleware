package ch.desm.middleware.module.obermatt;

import ch.desm.middleware.core.communication.broker.Broker;
import ch.desm.middleware.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.module.DesmMapMiddleware;
import ch.desm.middleware.module.obermatt.map.OmMapPetrinet;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class OmService {

    private MessageTranslatorMiddleware translator;
    private OmMessageProcessor processor;
    private DesmMapMiddleware componentMapMiddleware;
    private OmBrokerClient client;
    private OmEndpointUbw32 endpoint;
    private OmMapPetrinet map;

    public OmService(Broker broker, String port){
        this.componentMapMiddleware = new DesmMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new OmMessageProcessor();
        this.map = new OmMapPetrinet();

        this.client = new OmBrokerClient(broker, this);
        this.endpoint = new OmEndpointUbw32(port, this);
    }

    public DesmMapMiddleware getComponentMapMiddleware(){
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

    public OmMapPetrinet getMapPetrinet(){
        return this.map;
    }
}
