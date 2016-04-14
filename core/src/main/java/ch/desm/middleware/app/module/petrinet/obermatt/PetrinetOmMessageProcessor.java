package ch.desm.middleware.app.module.petrinet.obermatt;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
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
    public void processBrokerMessage(PetrinetOmService service, List<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(service, message);
        }
    }

    private void processBrokerMessage(PetrinetOmService service, MessageMiddleware element){

        if(element.getTopic().equalsIgnoreCase(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT)){
            try {
                String sensorName = service.getMap().mapBrokerToEndpointMessage(element.getGlobalId());
                int sensorValue = Integer.valueOf(MessageBase.getParameterValueEndpoint(element.getParameter()));//element.getParameter().equals("on") ? 1 : 0;
                delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
            } catch (Exception e) {
                //LOGGER.log(Level.ERROR, e);
            }
        } else if(element.getTopic().equalsIgnoreCase(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG)){
            try {
                String sensorName = service.getMapZusi().getKey(element.getGlobalId());
                int sensorValue = Integer.valueOf(MessageBase.getParameterValueEndpoint(element.getParameter()));//element.getParameter().equals("on") ? 1 : 0;
                delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
            } catch (Exception e) {
                //LOGGER.log(Level.ERROR, e);
            }
        } else if(element.getTopic().equalsIgnoreCase(MessageBase.MESSAGE_TOPIC_MANAGEMENT)){
            try {
                if (isInitProcessMessage(element)) {
                    processInitEndpoint(service.getEndpoint(), element);
                }else{

                    // Todo implementation
                    // activate this, when gui taken controle over this endpoint
                    if(service.getComponentMapMiddleware().isKeyAvailable(element.getGlobalId())){
                        String sensorName =element.getGlobalId();
                        int sensorValue = element.getParameter().equals("on") ? 1 : 0;
                        delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
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
    }

    private void processInitEndpoint(PetrinetOmEndpoint endpoint, MessageMiddleware element){

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

    private void delegateToEndpoint(PetrinetOmEndpoint endpoint, String sensorName, int sensorValue){
        LOGGER.log(Level.INFO, "processing endpoint sensor name: " + sensorName + ", value: " + sensorValue);
        endpoint.setSensor(sensorName, sensorValue);
    }

    //TODO refactoring
    public boolean isInitProcessMessage(MessageMiddleware element){
        if (element.getGlobalId().equalsIgnoreCase("mgmt.petrinet.obermatlangnau")) return true;
        return false;
    }
}
