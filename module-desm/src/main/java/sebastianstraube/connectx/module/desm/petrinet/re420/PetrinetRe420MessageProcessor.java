package sebastianstraube.connectx.module.desm.petrinet.re420;

import sebastianstraube.connectx.core.communication.message.BadParameterTypeCastException;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorBase;
import sebastianstraube.connectx.core.communication.message.MessageCommon;
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
        if (initEndpoint(service, message)) return;

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

    @Override
    protected boolean initEndpoint(PetrinetRe420Service service, MessageCommon element){

        if(!element.getGlobalId().equals("mgmt.petrinet.re420")) return false;
        if(element.getType().equals(MessageCommon.ParameterType.STRING)){
            final String parameter;
            try {
                parameter = element.getParameterAsString();
            } catch (BadParameterTypeCastException e) {
                LOGGER.log(Level.ERROR, "Received init message with type " + element.getTypeName() + " but expected String");
                return false;
            }

            switch (parameter) {
                case ("init"): {
                    service.getEndpoint().init();
                    return true;
                }
                case ("start"): {
                    service.getEndpoint().start();
                    return true;
                }
                case ("stop"): {
                    service.getEndpoint().stop();
                    return true;
                }
            }
        }

        return false;

    }

    private void delegateToEndpoint(PetrinetRe420Endpoint endpoint, String sensorName, int sensorValue){
        LOGGER.log(Level.INFO, "processing endpoint sensor name: " + sensorName + ", value: " + sensorValue);
        endpoint.setSensor(sensorName, sensorValue);
    }

}
