package ch.desm.middleware.app.module.petrinet.obermatt;

import ch.desm.middleware.app.core.communication.message.BadParameterTypeCastException;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.component.ComponentMessageProcessorBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 04.11.2014.
 */
public class PetrinetOmMessageProcessor extends ComponentMessageProcessorBase<PetrinetOmService> {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmBrokerClient.class);

    /**
     * @param messages
     */
    public void processBrokerMessage(PetrinetOmService service, List<MessageCommon> messages) {
        for(MessageCommon message : messages){
            processBrokerMessage(service, message);
        }
    }

    private void processBrokerMessage(PetrinetOmService service, MessageCommon element){
        switch(element.getTopic().toLowerCase()) {
            case MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT:
                processBrokerMessageObermatt(service, element);
                break;
            case MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG:
                processBrokerMessageZusiAusbildung(service, element);
                break;
            case MessageCommon.MESSAGE_TOPIC_MANAGEMENT:
                processBrokerMessageManagement(service, element);
                break;
            default:
                LOGGER.log(Level.WARN, "unsupported topic, broker message delegation skipped: " + element.toString());
                return;
        }
    }

    private void processBrokerMessageObermatt(PetrinetOmService service, MessageCommon message) {
        final boolean sensorValue;
        try {
            sensorValue = message.getParameterAsBoolean();
        } catch (BadParameterTypeCastException e) {
            LOGGER.log(Level.ERROR, "Received broker message with type " + message.getTypeName() + " but expected Boolean");
            return;
        }

        try {
            String sensorName = service.getMap().mapBrokerToEndpointMessage(message.getGlobalId());
            delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
        } catch (Exception e) {
            //LOGGER.log(Level.ERROR, e);
        }
    }

    private void processBrokerMessageZusiAusbildung(PetrinetOmService service, MessageCommon message) {
        final boolean sensorValue;
        try {
            sensorValue = message.getParameterAsBoolean();
        } catch (BadParameterTypeCastException e) {
            LOGGER.log(Level.ERROR, "Received broker message with type " + message.getTypeName() + " but expected Boolean");
            return;
        }

        try {
            String sensorName = service.getMapZusi().getKeyForValue(message.getGlobalId());
            delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
        } catch (Exception e) {
            //LOGGER.log(Level.ERROR, e);
        }
    }

    private void processBrokerMessageManagement(PetrinetOmService service, MessageCommon message) {
        if (isInitProcessMessage(message)) {
            processInitEndpoint(service.getEndpoint(), message);
            return;
        }

        // Todo implementation
        // activate this, when gui taken controle over this endpoint
        if (service.getMap().isKeyAvailable(message.getGlobalId())) {
            final String sensorName = message.getGlobalId();

            final Boolean sensorValue;
            try {
                sensorValue = message.getParameterAsBoolean();
            } catch (BadParameterTypeCastException e) {
                LOGGER.log(Level.ERROR, "Received broker message with type " + message.getTypeName() + " but expected Boolean");
                return;
            }

            try {
                delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }

    private void processInitEndpoint(PetrinetOmEndpoint endpoint, MessageCommon element){

        final String parameter;
        try {
            parameter = element.getParameterAsString();
        } catch (BadParameterTypeCastException e) {
            LOGGER.log(Level.ERROR, "Received init message with type " + element.getTypeName() + " but expected String");
            return;
        }

        switch (parameter) {
            case ("init"): {
                endpoint.init();
                break;
            }
            case ("start"): {
                endpoint.start();
                break;
            }
            case ("stop"): {
                endpoint.stop();
                break;
            }
        }
    }

    private void delegateToEndpoint(PetrinetOmEndpoint endpoint, String sensorName, boolean sensorValue){
        LOGGER.log(Level.INFO, "processing endpoint sensor name: " + sensorName + ", value: " + sensorValue);
        endpoint.setSensor(sensorName, sensorValue);
    }

    public boolean isInitProcessMessage(MessageCommon element){
        return element.getGlobalId().equalsIgnoreCase("mgmt.petrinet.obermatlangnau");
    }
}
