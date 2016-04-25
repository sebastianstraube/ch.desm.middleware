package ch.desm.middleware.app.module.petrinet.re420;

import ch.desm.middleware.app.core.component.ComponentMessageProcessorBase;
import ch.desm.middleware.app.core.communication.message.MessageBase;
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
        String sensorName = "";
        int sensorValue = 0;

        if(element.getTopic().equalsIgnoreCase(MessageBase.MESSAGE_TOPIC_CABINE_RE420)){
            try {
                sensorName = service.getMapCabineRe420().getKey(element.getGlobalId());
                sensorValue = element.getParameter().equalsIgnoreCase(MessageBase.MESSAGE_PARAMETER_ON) ? 1 : 0;//element.getParameter().equals("on") ? 1 : 0;
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        } else if(element.getTopic().equalsIgnoreCase(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT)){
            try {
                sensorName = service.getMapZusi().getKey(element.getGlobalId());
                sensorValue = element.getParameter().equalsIgnoreCase(MessageBase.MESSAGE_PARAMETER_ON) ? 1 : 0;//element.getParameter().equals("on") ? 1 : 0;
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        } else if(element.getTopic().equalsIgnoreCase(MessageBase.MESSAGE_TOPIC_MANAGEMENT)){
            try {
                if (isInitProcessMessage(element)) {
                    processInitEndpoint(service.getEndpoint(), element);
                }else{

                    // Todo implementation
                    // activate this, when gui taken controle over this endpoint
                    if(service.getComponentMapMiddleware().isKeyAvailable(element.getGlobalId())){
                        sensorName =element.getGlobalId();
                        sensorValue = element.getParameter().equals("on") ? 1 : 0;
                    }
                }
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }else{
            try {
                throw new Exception("unsupported topic, broker message delegation skipped: " + element.toString());
            } catch (Exception e) {
                LOGGER.log(Level.WARN, e);
            }
        }

        if(!sensorName.isEmpty()){
            delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
        }
    }

    private void processInitEndpoint(PetrinetRe420Endpoint endpoint, MessageCommon element){

        switch (element.getParameter()) {
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
