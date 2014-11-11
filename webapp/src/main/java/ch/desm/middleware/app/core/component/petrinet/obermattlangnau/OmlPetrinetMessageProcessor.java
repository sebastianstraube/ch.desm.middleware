package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentMessageProcessor;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map.OMLMapPetrinetOml;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 04.11.2014.
 */
public class OmlPetrinetMessageProcessor extends ComponentMessageProcessor {

    private static Logger LOGGER = Logger.getLogger(OMLPetrinetBrokerClient.class);

    private OMLMapPetrinetOml map;

    public OmlPetrinetMessageProcessor(){
        map = new OMLMapPetrinetOml();
    }

    /**
     * @param endpoint
     * @param messages
     */
    public void processBrokerMessage(OMLPetrinetEndpoint endpoint, LinkedList<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(endpoint, message);
        }
    }

    private void processBrokerMessage(OMLPetrinetEndpoint endpoint, MessageMiddleware element){

        if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU)){
            try {
                String sensorName = map.mapBrokerToEndpointMessage(element.getGlobalId());
                int sensorValue = Integer.valueOf(util.getParameterValueMiddleware(element.getParameter()));//element.getParameter().equals("on") ? 1 : 0;
                delegateToEndpoint(endpoint, sensorName, sensorValue);
            } catch (Exception e) {
                //LOGGER.log(Level.ERROR, e);
            }
        }else if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_MANAGEMENT)){
            try {
                if (isInitProcessMessage(element)) {
                    if (element.getGlobalId().equalsIgnoreCase("mgmt.petrinet.obermatlangnau")) {
                        processInitEndpoint(endpoint, element);
                    }
                }else{
                    element.setTopic(element.getTopic().replace(MessageBase.MESSAGE_TOPIC_MANAGEMENT,MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU));
                    int sensorValue = Integer.valueOf(util.getParameterValueMiddleware(element.getParameter()));//element.getParameter().equals("on") ? 1 : 0;

                    delegateToEndpoint(endpoint, element.getGlobalId(), sensorValue);

                    //throw new Exception("unsupported "+MessageBase.MESSAGE_TOPIC_MANAGEMENT+" message: " + element.toString());
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

    private void processInitEndpoint(OMLPetrinetEndpoint endpoint, MessageMiddleware element){

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

    private void delegateToEndpoint(OMLPetrinetEndpoint endpoint, String sensorName, int sensorValue){
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
