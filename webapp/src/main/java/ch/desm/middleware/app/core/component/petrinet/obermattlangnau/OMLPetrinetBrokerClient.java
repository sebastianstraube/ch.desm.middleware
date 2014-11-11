package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.component.ComponentBrokerClientBase;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageDecoder;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageEncoder;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

/**
 * Created by max on 06/08/14.
 */
public class OMLPetrinetBrokerClient extends ComponentBrokerClientBase {
    private static Logger LOGGER = Logger.getLogger(OMLPetrinetBrokerClient.class);

    private OMLPetrinetBrokerClientThread oMLPetriNetThread;
    private MessageTranslatorMiddleware translator;
    private OmlPetrinetMessageProcessor processor;
    private OMLPetrinetEndpoint endpoint;
    private PetrinetMessageEncoder encoder;
    private PetrinetMessageDecoder decoder;
    private ComponentMapMiddleware componentMapMiddleware;

    public OMLPetrinetBrokerClient(Broker broker, OMLPetrinetEndpoint endpoint) {
        super(broker);
        this.oMLPetriNetThread = new OMLPetrinetBrokerClientThread(this);
        this.oMLPetriNetThread.start();

        this.translator = new MessageTranslatorMiddleware();
        this.endpoint = endpoint;
        this.processor = new OmlPetrinetMessageProcessor();
        this.encoder = new PetrinetMessageEncoder();
        this.decoder = new PetrinetMessageDecoder();
        this.componentMapMiddleware = new ComponentMapMiddleware();
    }

    @Override
    protected void onIncomingBrokerMessage(String message) {
            oMLPetriNetThread.addMessages(translator.toMiddlewareMessageList(message));
    }

    @Override
    protected void intializeSignedTopic() {
        signForTopic(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
        signForTopic(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU);
        signForTopic(MessageBase.MESSAGE_TOPIC_MANAGEMENT);
    }

    public OmlPetrinetMessageProcessor getProcessor(){
        return processor;
    }

    public OMLPetrinetEndpoint getEndpoint(){
        return endpoint;
    }

    public PetrinetMessageEncoder getEncoder(){
        return encoder;
    }

    public PetrinetMessageDecoder getDecoder(){
        return decoder;
    }

    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }
}
