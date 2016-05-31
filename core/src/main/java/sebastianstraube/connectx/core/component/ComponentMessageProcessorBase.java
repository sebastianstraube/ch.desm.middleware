package sebastianstraube.connectx.core.component;

import sebastianstraube.connectx.core.communication.endpoint.EndpointCommon;
import sebastianstraube.connectx.core.communication.message.BadParameterTypeCastException;
import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.communication.message.processor.MessageProcessorBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 04.11.2014.
 */
public abstract class ComponentMessageProcessorBase<SERVICE_TYPE> extends MessageProcessorBase {

    private static Logger LOGGER = Logger.getLogger(ComponentMessageProcessorBase.class);

    /**
     *
     * @param service
     * @param messages
     */
    public abstract void processBrokerMessage(SERVICE_TYPE service, List<MessageCommon> messages);

    /**
     *
     * @param component
     * @param message
     */
    public void processEndpointMessage(ComponentBrokerClientBase component, String message, String topic) {
        if (message != null && !message.isEmpty()) {
            LOGGER.log(Level.INFO, "processing endpoint message: " + message + ", component: " + component + ", topic: " +topic);
            component.publish(message, topic);
        }else{
            LOGGER.log(Level.TRACE, "skipped processing endpoint message.");
        }
    }

    protected abstract boolean initEndpoint(SERVICE_TYPE service, MessageCommon element);

}
