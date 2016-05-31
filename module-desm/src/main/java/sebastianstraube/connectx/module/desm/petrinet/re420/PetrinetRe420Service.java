package sebastianstraube.connectx.module.desm.petrinet.re420;

import sebastianstraube.connectx.core.communication.broker.Broker;
import sebastianstraube.connectx.core.communication.message.translator.MessageTranslatorMiddleware;
import sebastianstraube.connectx.module.desm.DesmServiceMapMiddleware;
import sebastianstraube.connectx.module.desm.petrinet.re420.map.PetrinetRe420MapInterlockingOm;
import sebastianstraube.connectx.module.desm.petrinet.re420.map.PetrinetRe420MapCabineRe420;
import sebastianstraube.connectx.module.desm.petrinet.re420.map.PetrinetRe420MapZusiFahrpult;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class PetrinetRe420Service {

    private MessageTranslatorMiddleware translator;
    private PetrinetRe420MessageProcessor processor;
    private DesmServiceMapMiddleware componentMapMiddleware;
    private PetrinetRe420MapInterlockingOm mapInterlockingOm;
    private PetrinetRe420BrokerClient client;
    private PetrinetRe420Endpoint endpoint;
    private PetrinetRe420MapCabineRe420 mapCabineRe420 = new PetrinetRe420MapCabineRe420();
    private PetrinetRe420MapZusiFahrpult mapZusi = new PetrinetRe420MapZusiFahrpult();



    public PetrinetRe420Service(Broker broker){
        this.componentMapMiddleware = new DesmServiceMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new PetrinetRe420MessageProcessor();
        this.mapInterlockingOm = new PetrinetRe420MapInterlockingOm();

        this.client = new PetrinetRe420BrokerClient(broker, this);
        this.endpoint = new PetrinetRe420Endpoint(this);
    }


    public DesmServiceMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public PetrinetRe420MessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public PetrinetRe420Endpoint getEndpoint(){
        return endpoint;
    }

    public PetrinetRe420BrokerClient getBrokerClient(){
        return client;
    }

    public PetrinetRe420MapInterlockingOm getMapInterlockingOm(){
        return mapInterlockingOm;
    }

    public PetrinetRe420MapCabineRe420 getMapCabineRe420(){
        return mapCabineRe420;
    }

    public PetrinetRe420MapZusiFahrpult getMapZusi(){
        return mapZusi;
    }

}
