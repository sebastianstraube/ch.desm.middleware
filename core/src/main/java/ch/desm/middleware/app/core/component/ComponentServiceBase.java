package ch.desm.middleware.app.core.component;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;

/**
 * Created by Sebastian on 03.04.2015.
 */
public abstract class ComponentServiceBase<TYPE_ENDPOINT> {

    ComponentMapMiddleware componentMapMiddleware;

    public ComponentServiceBase(){
        componentMapMiddleware = new ComponentMapMiddleware();
    }

    public abstract ComponentMessageProcessorBase getMessageProcessor();

    public abstract TYPE_ENDPOINT getEndpoint();

    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }
}
