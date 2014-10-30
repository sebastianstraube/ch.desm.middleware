package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import java.util.ArrayList;

import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorUtil;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map.OMLMapPetrinetOml;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

/**
 * Created by max on 06/08/14.
 */
public class OMLPetriNet extends OMLPetriNetBase {

    private static Logger LOGGER = Logger.getLogger(OMLPetriNet.class);

    OMLMapPetrinetOml petriNetMap;
    MessageTranslatorMiddleware translator;

    public OMLPetriNet(Broker broker, OMLPetriNetEndpoint endpoint) {
        super(broker, endpoint);
        this.registerEndpointListener(endpoint);

        petriNetMap = new OMLMapPetrinetOml();
        translator = new MessageTranslatorMiddleware();
    }

    @Override
    protected void onIncomingBrokerMessage(String message) {
    	LOGGER.info("petrinet (" + this.getClass() + ") received broker message: " + message);
    	
        ArrayList<MessageMiddleware> messages = translator.toMiddlewareMessageList(message);

        for(MessageMiddleware element : messages){
            if (MessageProcessorUtil.isSoftwareMessage(element.getOutputInput())) {

                if (element.getGlobalId().equalsIgnoreCase(
                        "mgmt.petrinet.obermatlangnau")) {

                    switch (element.getParameter()) {
                        case ("init"): {
                            getEndpoint().init();
                            break;
                        }
                        case ("start"): {
                            getEndpoint().start();
                            break;
                        }
                        case ("stop"): {
                            getEndpoint().stop();
                            break;
                        }
                    }
                }
            }else{
                String globalId = element.getGlobalId();
                String sensorName = null;
                try {
                    sensorName = petriNetMap.mapBrokerToEndpointMessage(globalId);
                } catch (Exception e) {
                    LOGGER.log(Level.ERROR, e);
                }
                int sensorValue = element.getParameter().equals("on") ? 1 : 0;
                getEndpoint().setSensor(sensorName, sensorValue);
            }
        }
    }

    @Override
    public void onIncomingEndpointMessage(String firedTransition) {
        try {
        	LOGGER.info("petrinet (" + this.getClass() + ") received endpoint message: " + firedTransition);
            String globalId;
            try{
                globalId = petriNetMap.mapEndpointToBrokerMessage(firedTransition);
            }catch(Exception e){
                globalId = firedTransition;
                LOGGER.warn("forwarding transition: "+ firedTransition + " as middleware message.");
            }
            String message = getMiddlewareMessages().getValue(globalId);
            
            //TODO refactoring
        	message = message.replaceAll("\\?", "on");
            
            this.publish(message, MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);

        } catch (Exception e) {
        	LOGGER.error(e.getMessage());
        }
    }

    @Override
    protected void intializeSignedTopic() {
        signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
        signForTopic(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU);
        signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
    }
}
