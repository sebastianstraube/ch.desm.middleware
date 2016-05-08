package ch.desm.middleware.core.component;

import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32;
import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.communication.message.processor.MessageProcessorBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 04.11.2014.
 */
public abstract class ComponentMessageProcessorBase<T1> extends MessageProcessorBase {

    private static Logger LOGGER = Logger.getLogger(ComponentMessageProcessorBase.class);

    /**
     *
     * @param service
     * @param messages
     */
    public abstract void processBrokerMessage(T1 service, List<MessageCommon> messages);

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
}
