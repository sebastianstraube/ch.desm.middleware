package ch.desm.middleware.app.core.communication.message.processor;

import java.util.ArrayList;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.app.core.communication.endpoint.serial.ubw32.EndpointUbw32;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentBase;
import ch.desm.middleware.app.core.component.ComponentMap;
import ch.desm.middleware.app.core.component.ComponentMapBase;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.cabine.re420.Re420;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OML;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OMLEndpointUbw32;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapUbw32Analog;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapUbw32Digital;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.OMLPetriNet;
import ch.desm.middleware.app.core.component.simulation.locsim.Locsim;


public abstract class MessageProcessorBase {

    public MessageProcessorUtil util = new MessageProcessorUtil();

   	/**
	 * 
	 * @param component
	 * @param message
	 */
	public void processEndpointMessage(ComponentBase component, String message, String topic) {
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
