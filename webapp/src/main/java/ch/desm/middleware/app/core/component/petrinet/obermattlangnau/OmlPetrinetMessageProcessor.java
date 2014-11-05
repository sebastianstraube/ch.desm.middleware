package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentMessageProcessor;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OMLEndpointUbw32;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map.OMLMapPetrinetOml;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Sebastian on 04.11.2014.
 */
public class OmlPetrinetMessageProcessor extends ComponentMessageProcessor {

    private static Logger LOGGER = Logger.getLogger(OMLPetriNet.class);
    private OMLMapPetrinetOml map;

    public OmlPetrinetMessageProcessor(){
        map = new OMLMapPetrinetOml();
    }

    /**
     * @param endpoint
     * @param messages
     */
    public void processBrokerMessage(OMLPetriNetEndpoint endpoint, ArrayList<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(endpoint, message);
        }
    }

    private void processBrokerMessage(OMLPetriNetEndpoint endpoint, MessageMiddleware element){

        if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU)){
            try {
                String sensorName = map.mapBrokerToEndpointMessage(element.getGlobalId());
                int sensorValue = Integer.valueOf(util.getParameterValueMiddleware(element.getParameter()));//element.getParameter().equals("on") ? 1 : 0;
                delegateToEndpoint(endpoint, sensorName, sensorValue);
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }else if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_MANAGEMENT)){
            try {
                if (isInitProcessMessage(element)) {
                    initEndpoint(endpoint, element);
                }else{
                    throw new Exception("unsupported "+MessageBase.MESSAGE_TOPIC_MANAGEMENT+" message: " + element.toString());
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

    private void initEndpoint(OMLPetriNetEndpoint endpoint, MessageMiddleware element){

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

    private void delegateToEndpoint(OMLPetriNetEndpoint endpoint, String sensorName, int sensorValue){
        endpoint.setSensor(sensorName, sensorValue);
    }

    public boolean isInitProcessMessage(MessageMiddleware element){
        if (element.getGlobalId().equalsIgnoreCase("mgmt.petrinet.obermatlangnau")) {
            return true;
        }
        return false;
    }
}
