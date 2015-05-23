package ch.desm.middleware.app.common;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;

/**
 * Created by Sebastian on 03.04.2015.
 */
public abstract class ComponentServiceBase {

    ComponentMapMiddleware componentMapMiddleware;

    public ComponentServiceBase(){
        componentMapMiddleware = new ComponentMapMiddleware();
    }

    public abstract ComponentMessageProcessorBase getMessageProcessor();

    public abstract EndpointCommon getEndpoint();

    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }
}
