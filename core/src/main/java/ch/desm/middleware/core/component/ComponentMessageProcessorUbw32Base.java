package ch.desm.middleware.core.component;

import ch.desm.middleware.core.communication.endpoint.ubw32.EndpointUbw32;
import ch.desm.middleware.core.communication.message.BadParameterTypeCastException;
import ch.desm.middleware.core.communication.message.MessageCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract class ComponentMessageProcessorUbw32Base<T1> extends ComponentMessageProcessorBase<T1> {

    private static Logger LOGGER = Logger.getLogger(ComponentMessageProcessorUbw32Base.class);

    public void delegateToEndpoint(EndpointUbw32 endpoint, ComponentMapBase mapDigital, ComponentMapBase mapAnalog, String key, MessageCommon message){
        switch(message.getType()) {
            case BOOLEAN: {
                if (!mapDigital.isKeyAvailable(key)) {
                    LOGGER.log(Level.INFO, "No mapping available for digital key " + key);
                    return;
                }

                final String endpointRegister = mapDigital.getValueForKey(key);
                final String registerName = String.valueOf(endpointRegister.charAt(0));
                final Integer pin = Integer.valueOf(endpointRegister.substring(1));

                if (message.isInputMessage()) {
                    throw new RuntimeException("Message should not trigger an input on the UBW32");
                    //endpoint.getPinInputDigital(registerName, pin);
                }

                try {
                    endpoint.setPinOutputDigital(registerName, pin, message.getParameterAsBoolean());
                } catch (BadParameterTypeCastException e) {
                    // should not happen as we checked for bool type above already
                }
                break;
            }
            case DOUBLE: {
                // TODO: get rid of the maps?
                if (!mapAnalog.isKeyAvailable(key)) {
                    throw new RuntimeException("Analog pin must be controlled through message of type double!");
                }

                final String endpointRegister = mapAnalog.getValueForKey(key);

                if (message.isInputMessage()) {
                    throw new RuntimeException("Message should not trigger an input on the UBW32");
                    // endpoint.getPinInputAnalog(endpointRegister);
                }

                // TODO: implement through PWM
                throw new RuntimeException("setting analog pins not implemented yet");
                //break;
            }
            default:
                throw new RuntimeException("Unable to map message of type " + message.getTypeName() + " to UBW32 pin");
        }
    }

}
