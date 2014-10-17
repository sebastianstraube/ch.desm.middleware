package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessor;
import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorUtil;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapMiddleware;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map.OMLPetriNetMap;

/**
 * Created by max on 06/08/14.
 */
public class OMLPetriNet extends OMLPetriNetBase {

    protected static Logger LOGGER = Logger.getLogger(OMLPetriNet.class);

    OMLPetriNetMap petriNetMap = new OMLPetriNetMap();
    MessageTranslatorMiddleware translator = new MessageTranslatorMiddleware();
    MessageProcessor processor = new MessageProcessor();

    public OMLPetriNet(Broker broker, OMLPetriNetEndpoint endpoint) {
        super(broker, endpoint);
        this.registerEndpointListener(endpoint);
    }

    @Override
    protected void onIncomingBrokerMessage(String message) {
    	LOGGER.info("petrinet (" + this.getClass() + ") received broker message: " + message);
    	
        ArrayList<MessageMiddleware> messageCommon = translator.toMiddlewareMessageList(message);
        processor.processBrokerMessage(this, messageCommon);
    }
    
    public void processBrokerMessage(MessageMiddleware message) {
        try {
        	
        	if (MessageProcessorUtil.isSoftwareMessage(message.getOutputInput())) {

    			if (message.getGlobalId().equalsIgnoreCase(
    					"mgmt.petrinet.obermatlangnau")) {

    				switch (message.getParameter()) {
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
        		String globalId = message.getGlobalId();
                String sensorName = petriNetMap.mapBrokerToEndpointMessage(globalId);
                int sensorValue = message.getParameter().equals("on") ? 1 : 0;            
                getEndpoint().setSensor(sensorName, sensorValue);
        	}
        } catch (Exception e) {
        	LOGGER.warn(e);
        }
    }

    @Override
    public void onIncomingEndpointMessage(String firedTransition) {
        try {
        	LOGGER.info("petrinet (" + this.getClass() + ") received endpoint message: " + firedTransition);
        	
        	OMLMapMiddleware map = new OMLMapMiddleware();
            String globalId = petriNetMap.mapEndpointToBrokerMessage(firedTransition);
            String message = map.getValue(globalId);
            
            //TODO refactoring
        	message = message.replaceAll("\\?", "on");
            
            processor.processEndpointMessage(this, message, MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
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
