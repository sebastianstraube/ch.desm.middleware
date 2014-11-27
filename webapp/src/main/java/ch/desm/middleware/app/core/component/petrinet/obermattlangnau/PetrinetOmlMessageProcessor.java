package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentMessageProcessor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 04.11.2014.
 */
public class PetrinetOmlMessageProcessor extends ComponentMessageProcessor {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmlBrokerClient.class);

    /**
     * @param messages
     */
    public void processBrokerMessage(PetrinetOmlService service, LinkedList<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(service, message);
        }
    }

    private void processBrokerMessage(PetrinetOmlService service, MessageMiddleware element){

        if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU)){
            try {
                String sensorName = service.getMap().mapBrokerToEndpointMessage(element.getGlobalId());
                int sensorValue = Integer.valueOf(util.getParameterValueEndpoint(element.getParameter()));//element.getParameter().equals("on") ? 1 : 0;
                delegateToEndpoint(service.getEndpoint(), sensorName, sensorValue);
            } catch (Exception e) {
                //LOGGER.log(Level.ERROR, e);
            }
        }else if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_MANAGEMENT)){
            try {
                if (isInitProcessMessage(element)) {
                    if (element.getGlobalId().equalsIgnoreCase("mgmt.petrinet.obermatlangnau")) {
                        processInitEndpoint(service.getEndpoint(), element);
                    }
                }else{

                    //only one endpoint is allowed to receive messages from endpoint
                    //BUG1
                    if(service.getMap().isKeyAvailable(element.getGlobalId())){
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
                LOGGER.log(Level.ERROR, e);
            }
        }
    }

    private void processInitEndpoint(PetrinetOmlEndpoint endpoint, MessageMiddleware element){

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

    private void delegateToEndpoint(PetrinetOmlEndpoint endpoint, String sensorName, int sensorValue){

        //if(sensorValue != 0){
            LOGGER.log(Level.INFO, "processing endpoint sensor name: " + sensorName + ", value: " + sensorValue);
        //}

        endpoint.setSensor(sensorName, sensorValue);
    }

    public boolean isInitProcessMessage(MessageMiddleware element){

        if (element.getGlobalId().equalsIgnoreCase("mgmt.stellwerk.obermattlangnau")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.petrinet.obermatlangnau")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.cabine.re420.fabisch")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.cabine.re420.ubw32")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.simulation.locsim.rs232")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.simulation.locsim.dll")) {
            return true;
        }

        return false;
    }
}
