package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorBase;
import ch.desm.middleware.app.core.component.ComponentMessageProcessor;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map.OMLMapPetrinetOml;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 04.11.2014.
 */
public class OmlPetrinetMessageProcessor extends ComponentMessageProcessor {

    private static Logger LOGGER = Logger.getLogger(OMLPetriNet.class);
    private OMLMapPetrinetOml petriNetMap;

    public OmlPetrinetMessageProcessor(){
        petriNetMap = new OMLMapPetrinetOml();
    }

    public void processBrokerMessage(OMLPetriNetEndpoint endpoint, MessageMiddleware element){

        String globalId = element.getGlobalId();
        String sensorName = null;
        int sensorValue = element.getParameter().equals("on") ? 1 : 0;

        if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU)){
            try {
                sensorName = petriNetMap.mapBrokerToEndpointMessage(globalId);
                delegateToEndpoint(endpoint, sensorName, sensorValue);
            } catch (Exception e) {
                LOGGER.log(Level.ERROR, e);
            }
        }else if(element.getTopic().equals(MessageBase.MESSAGE_TOPIC_MANAGEMENT)){
            try {
                if (isInitProcessMessage(element)) {
                    initEndpoint(endpoint, element);
                }else{
                    sensorName = element.getGlobalId();
                    delegateToEndpoint(endpoint, sensorName, sensorValue);
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
