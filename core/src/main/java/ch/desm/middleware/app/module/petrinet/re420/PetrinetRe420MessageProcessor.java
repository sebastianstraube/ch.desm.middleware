package ch.desm.middleware.app.module.petrinet.re420;

import ch.desm.middleware.app.core.communication.message.BadParameterTypeCastException;
import ch.desm.middleware.app.core.component.ComponentMessageProcessorBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sebastian on 04.11.2014.
 */
public class PetrinetRe420MessageProcessor extends ComponentMessageProcessorBase<PetrinetRe420Service> {

    private static Logger LOGGER = Logger.getLogger(PetrinetRe420BrokerClient.class);

    /**
     * @param messages
     */
    public void processBrokerMessage(PetrinetRe420Service service, List<MessageCommon> messages) {
        for(MessageCommon message : messages){
            processBrokerMessage(service, message);
        }
    }

    private void processBrokerMessage(PetrinetRe420Service service, MessageCommon element){
        switch(element.getTopic().toLowerCase()) {
            case MessageCommon.MESSAGE_TOPIC_CABINE_RE420:
                processBrokerMessageCabineRe420(service, element);
                break;
            case MessageCommon.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT:
                processBrokerMessageZusiFahrpult(service, element);
                break;
            case MessageCommon.MESSAGE_TOPIC_MANAGEMENT:
                processBrokerMessageManagement(service, element);
                break;
            default:
                LOGGER.log(Level.WARN, "unsupported topic, broker message delegation skipped: " + element.toString());
                return;
        }
    }

    private void processBrokerMessageCabineRe420(PetrinetRe420Service service, MessageCommon message) {
        final String sensorName = service.getMapCabineRe420().getKeyForValue(message.getGlobalId());
        final int sensorValue;

        try {
            sensorValue = message.getParameterAsBoolean() ? 1 : 0;
        } catch (BadParameterTypeCastException e) {
            LOGGER.log(Level.ERROR, "Received broker message with type " + message.getTypeName() + " but expected Boolean");
            return;
        }

        try {
            delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
            return;
        }
    }

    private void processBrokerMessageZusiFahrpult(PetrinetRe420Service service, MessageCommon message) {
        final String sensorName = service.getMapZusi().getKeyForValue(message.getGlobalId());
        final int sensorValue;

        try {
            sensorValue = message.getParameterAsBoolean() ? 1 : 0;
        } catch (BadParameterTypeCastException e) {
            LOGGER.log(Level.ERROR, "Received broker message with type " + message.getTypeName() + " but expected Boolean");
            return;
        }

        try {
            delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
            return;
        }
    }

    private void processBrokerMessageManagement(PetrinetRe420Service service, MessageCommon message) {
        if (isInitProcessMessage(message)) {
            processInitEndpoint(service.getEndpoint(), message);
            return;
        }

        // Todo implementation
        // activate this, when gui taken controle over this endpoint
        if(service.getComponentMapMiddleware().isKeyAvailable(message.getGlobalId())){
            final String sensorName = message.getGlobalId();
            final int sensorValue;

            try {
                sensorValue = message.getParameterAsBoolean() ? 1 : 0;
            } catch (BadParameterTypeCastException e) {
                LOGGER.log(Level.ERROR, "Received broker message with type " + message.getTypeName() + " but expected Boolean");
                return;
            }

            delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
        }
    }

    private void processInitEndpoint(PetrinetRe420Endpoint endpoint, MessageCommon element){

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

    private void delegateToEndpoint(PetrinetRe420Endpoint endpoint, String sensorName, int sensorValue){
        LOGGER.log(Level.INFO, "processing endpoint sensor name: " + sensorName + ", value: " + sensorValue);
        endpoint.setSensor(sensorName, sensorValue);
    }

    //TODO refactoring
    public boolean isInitProcessMessage(MessageCommon element){
        if (element.getGlobalId().equalsIgnoreCase("mgmt.petrinet.re420")) return true;
        return false;
    }
}
