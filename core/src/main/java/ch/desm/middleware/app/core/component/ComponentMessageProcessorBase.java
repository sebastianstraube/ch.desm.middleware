package ch.desm.middleware.app.core.component;

import ch.desm.middleware.app.core.communication.endpoint.rs232.ubw32.EndpointUbw32;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

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
    public abstract void processBrokerMessage(T1 service, LinkedList<MessageMiddleware> messages);

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

    public void delegateToEndpoint(EndpointUbw32 endpoint, ComponentMapBase mapDigital, ComponentMapBase mapAnalog, String key, String parameter, boolean isInput){

        // is ubw digital message
        if (mapDigital.isKeyAvailable(key)) {

            String endpointRegister = mapDigital.getMap().get(key);
            String registerName = String
                    .valueOf(endpointRegister.charAt(0));
            String pin = String.valueOf(endpointRegister.substring(1));

            if (isInput) {
                endpoint.getPinInputDigital(registerName,
                        pin);
            } else {
                endpoint.setPinOutputDigital(registerName, pin, parameter);
            }
        }
        // is ubw analog message
        else if (mapAnalog.isKeyAvailable(key)) {

            String endpointRegister = mapAnalog.getMap().get(key);

            if (isInput) {
                endpoint.getPinInputAnalog(endpointRegister);
            }
        }
    }
}
