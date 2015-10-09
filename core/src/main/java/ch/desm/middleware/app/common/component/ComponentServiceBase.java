package ch.desm.middleware.app.common.component;

/**
 * Created by Sebastian on 03.04.2015.
 */
public abstract class ComponentServiceBase<ENDPOINT_TYPE> {

    ComponentMapMiddleware componentMapMiddleware;

    public ComponentServiceBase(){
        componentMapMiddleware = new ComponentMapMiddleware();
    }

    public abstract ComponentMessageProcessorBase getMessageProcessor();

    public abstract ENDPOINT_TYPE getEndpoint();

    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }
}
