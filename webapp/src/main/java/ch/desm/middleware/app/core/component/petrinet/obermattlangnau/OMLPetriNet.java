package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import java.util.ArrayList;

import ch.desm.middleware.app.core.communication.message.processor.MessageProcessorUtil;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageDecoder;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map.OMLMapPetrinetOml;
import ch.desm.middleware.app.core.utility.Pair;
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

    private MessageTranslatorMiddleware translator;
    private PetrinetMessageDecoder decoder;
    private OmlPetrinetMessageProcessor processor;

    public OMLPetriNet(Broker broker, OMLPetriNetEndpoint endpoint) {
        super(broker, endpoint);
        this.registerEndpointListener(endpoint);

        translator = new MessageTranslatorMiddleware();
        decoder = new PetrinetMessageDecoder();
        processor = new OmlPetrinetMessageProcessor();
    }

    @Override
    protected void onIncomingBrokerMessage(String message) {
    	LOGGER.log(Level.TRACE, "petrinet (" + this.getClass() + ") received broker message: " + message);
    	
        ArrayList<MessageMiddleware> messages = translator.toMiddlewareMessageList(message);

        for(MessageMiddleware element : messages){
            processor.processBrokerMessage(getEndpoint(), element);
        }
    }

    @Override
    public void onIncomingEndpointMessage(String jsonMessagePlace) {
        try {
            Pair<String, Integer> pair = decoder.decode(jsonMessagePlace);
            String message = getMiddlewareMessages().getValue(pair.getLeft());
            if(!message.isEmpty()){
                String parameter = pair.getRight() == 0? "off" : "on";
                message = message.replaceAll("\\?", parameter);
                processor.processEndpointMessage(this,
                        message, MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
            }
        } catch (ClassCastException e) {
            LOGGER.log(Level.ERROR, "Error on message: " + jsonMessagePlace + "with: " + e);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    protected void intializeSignedTopic() {
        signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
        signForTopic(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU);
        signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
    }
}
