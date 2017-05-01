package sebastianstraube.connectx.module.desm.petrinet.obermatt;

import sebastianstraube.connectx.core.communication.broker.Broker;
import sebastianstraube.connectx.core.communication.message.translator.MessageTranslatorMiddleware;
import sebastianstraube.connectx.core.component.ComponentServiceBase;
import sebastianstraube.connectx.module.desm.DesmServiceMapMiddleware;
import sebastianstraube.connectx.module.desm.petrinet.obermatt.map.PetrinetOmMapInterlockingOm;
import sebastianstraube.connectx.module.desm.petrinet.obermatt.map.PetrinetOmMapZusi;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class PetrinetOmService extends ComponentServiceBase<PetrinetOmEndpoint> {

    private MessageTranslatorMiddleware translator;
    private PetrinetOmMessageProcessor processor;
    private DesmServiceMapMiddleware componentMapMiddleware;
    private PetrinetOmBrokerClient client;
    private PetrinetOmEndpoint endpoint;
    private PetrinetOmMapInterlockingOm mapInterlockingOm;
    private PetrinetOmMapZusi mapZusi = new PetrinetOmMapZusi();

    public PetrinetOmService(Broker broker){
        this.componentMapMiddleware = new DesmServiceMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new PetrinetOmMessageProcessor();
        this.mapInterlockingOm = new PetrinetOmMapInterlockingOm();

        this.client = new PetrinetOmBrokerClient(broker, this);
        this.endpoint = new PetrinetOmEndpoint(this);
    }


    @Override
    public DesmServiceMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    @Override
    public PetrinetOmMessageProcessor getMessageProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    @Override
    public PetrinetOmEndpoint getEndpoint(){
        return endpoint;
    }

    public PetrinetOmBrokerClient getBrokerClient(){
        return client;
    }

    public PetrinetOmMapInterlockingOm getMapInterlockingOm(){
        return mapInterlockingOm;
    }

    public PetrinetOmMapZusi getMapZusi(){
        return mapZusi;
    }

}
