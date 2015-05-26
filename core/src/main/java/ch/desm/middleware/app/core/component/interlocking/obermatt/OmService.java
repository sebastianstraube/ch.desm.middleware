package ch.desm.middleware.app.core.component.interlocking.obermatt;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.rs232.EndpointRs232;
import ch.desm.middleware.app.core.communication.endpoint.rs232.ubw32.EndpointUbw32State;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.common.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.interlocking.obermatt.map.OmMapPetrinet;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class OmService {

    private MessageTranslatorMiddleware translator;
    private OmMessageProcessor processor;
    private ComponentMapMiddleware componentMapMiddleware;
    private OmBrokerClient client;
    private OmEndpointUbw32 endpoint;
    private OmMapPetrinet map;

    //TODO refactor move to common ubw
    private EndpointUbw32State state;




    public OmService(Broker broker, String port){
        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new OmMessageProcessor(this);
        this.state = new EndpointUbw32State();
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

    public EndpointUbw32State getState(){
        return state;
    }

    public OmMapPetrinet getMapPetrinet(){
        return this.map;
    }
}
