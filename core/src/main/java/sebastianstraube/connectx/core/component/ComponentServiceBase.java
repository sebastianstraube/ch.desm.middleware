package sebastianstraube.connectx.core.component;

/**
 * Created by Sebastian on 03.04.2015.
 */
public abstract class ComponentServiceBase<ENDPOINT_TYPE> {

    public abstract ComponentMessageProcessorBase getMessageProcessor();

    public abstract ENDPOINT_TYPE getEndpoint();

    public abstract ComponentMapBase getComponentMapMiddleware();
}
