package ch.desm.middleware.app.core.component;

import ch.desm.middleware.app.core.communication.endpoint.ubw32.EndpointUbw32;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorBase;
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

    // TODO: move to some place where it belongs to UBW32 endpoints only!
    public void delegateToEndpoint(EndpointUbw32 endpoint, ComponentMapBase mapDigital, ComponentMapBase mapAnalog, String key, MessageCommon message, boolean isInput){
        // TODO: can isInput be determined from messageCommon.isInput()?
        if (isInput != message.isInputMessage()) {
            final String inputOutput = isInput ? "input" : "output";
            throw new RuntimeException("The provided message is not configured as an " + inputOutput + " message!");
        }

        switch(message.getType()) {
            case BOOLEAN: {
                // TODO: get rid of the maps?
                if (!mapDigital.isKeyAvailable(key)) {
                    throw new RuntimeException("Digital pin must be controlled through message of type boolean!");
                }

                final String endpointRegister = mapDigital.getMap().get(key);
                final String registerName = String.valueOf(endpointRegister.charAt(0));
                final Integer pin = Integer.valueOf(endpointRegister.substring(1));

                if (isInput) {
                    endpoint.getPinInputDigital(registerName, pin);
                } else {
                    try {
                        endpoint.setPinOutputDigital(registerName, pin, message.getParameterAsBoolean());
                    } catch (MessageCommon.BadParameterTypeCastException e) {
                        // should not happen as we checked for bool type above already
                    }
                }
                break;
            }
            case DOUBLE: {
                // TODO: get rid of the maps?
                if (!mapAnalog.isKeyAvailable(key)) {
                    throw new RuntimeException("Analog pin must be controlled through message of type double!");
                }

                final String endpointRegister = mapAnalog.getMap().get(key);

                if (isInput) {
                    endpoint.getPinInputAnalog(endpointRegister);
                } else {
                    // TODO: implement
                    throw new RuntimeException("setting analog pins not implemented yet");
                }

                break;
            }
            default:
                throw new RuntimeException("Unable to map message of type " + message.getTypeName() + " to UBW32 pin");
        }
    }
}
