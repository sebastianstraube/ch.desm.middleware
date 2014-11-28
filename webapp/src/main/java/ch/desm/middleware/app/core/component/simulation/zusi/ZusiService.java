package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapLocsim;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService {

    private MessageTranslatorMiddleware translator;
    private ZusiMessageProcessor processor;
    private ComponentMapMiddleware componentMapMiddleware;
    private ZusiBrokerClient client;
    private ZusiEndpoint endpoint;
    private ZusiMapLocsim map;

    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public ZusiMessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public ZusiEndpoint getEndpoint(){
        return endpoint;
    }

    public ZusiBrokerClient getBrokerClient(){
        return client;
    }

    public ZusiMapLocsim getMap(){
        return this.map;
    }
}
