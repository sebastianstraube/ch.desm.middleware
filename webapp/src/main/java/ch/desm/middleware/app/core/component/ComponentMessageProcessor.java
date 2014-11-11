package ch.desm.middleware.app.core.component;

import ch.desm.middleware.app.core.communication.endpoint.serial.ubw32.EndpointUbw32;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorBase;

/**
 * Created by Sebastian on 04.11.2014.
 */
public class ComponentMessageProcessor extends MessageProcessorBase {

    /**
     *
     * @param component
     * @param message
     */
    public void processEndpointMessage(ComponentBrokerClientBase component, String message, String topic) {
        if (message != null && !message.isEmpty()) {
            component.publish(message, topic);
        }
    }

    public void delegateToEndpoint(EndpointUbw32 endpoint, ComponentMap mapDigital, ComponentMap mapAnalog, String key, String parameter, boolean isInput){

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
                endpoint.setPinOutputDigital(registerName,
                        pin, parameter);
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
