package ch.desm.middleware.app.core.component.petrinet.re420;

import ch.desm.middleware.app.common.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.common.petrinet.PetrinetMessageDecoder;
import ch.desm.middleware.app.common.petrinet.PetrinetMessageEncoder;
import ch.desm.middleware.app.core.component.petrinet.re420.map.PetrinetRe420MapInterlockingOm;
import ch.desm.middleware.app.core.component.petrinet.re420.map.PetrinetRe420MapCabineRe420;
import ch.desm.middleware.app.core.component.petrinet.re420.map.PetrinetRe420MapSimZusiFahrpult;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class PetrinetRe420Service {

    private MessageTranslatorMiddleware translator;
    private PetrinetRe420MessageProcessor processor;
    private PetrinetMessageEncoder encoder;
    private PetrinetMessageDecoder decoder;
    private ComponentMapMiddleware componentMapMiddleware;
    private PetrinetRe420MapInterlockingOm mapInterlockingOm;
    private PetrinetRe420BrokerClient client;
    private PetrinetRe420Endpoint endpoint;


    public PetrinetRe420Service(Broker broker){
        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new PetrinetRe420MessageProcessor();
        this.encoder = new PetrinetMessageEncoder();
        this.decoder = new PetrinetMessageDecoder();
        this.mapInterlockingOm = new PetrinetRe420MapInterlockingOm();

        this.client = new PetrinetRe420BrokerClient(broker, this);
        this.endpoint = new PetrinetRe420Endpoint(this);
    }


    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public PetrinetRe420MessageProcessor getProcessor(){
        return processor;
    }

    public PetrinetMessageEncoder getEncoder(){
        return encoder;
    }

    public PetrinetMessageDecoder getDecoder(){
        return decoder;
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
        return this.mapInterlockingOm;
    }

    public PetrinetRe420MapCabineRe420 getMapCabineRe420(){
        return new PetrinetRe420MapCabineRe420();
    }

    public PetrinetRe420MapSimZusiFahrpult getMapZusi(){
        return new PetrinetRe420MapSimZusiFahrpult();
    }

}
