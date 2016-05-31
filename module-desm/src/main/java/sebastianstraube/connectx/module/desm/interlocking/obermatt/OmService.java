package sebastianstraube.connectx.module.desm.interlocking.obermatt;

import sebastianstraube.connectx.core.communication.broker.Broker;
import sebastianstraube.connectx.core.communication.message.translator.MessageTranslatorMiddleware;
import sebastianstraube.connectx.module.desm.DesmServiceMapMiddleware;
import sebastianstraube.connectx.module.desm.interlocking.obermatt.map.OmMapPetrinet;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class OmService {

    private MessageTranslatorMiddleware translator;
    private OmMessageProcessor processor;
    private DesmServiceMapMiddleware componentMapMiddleware;
    private OmBrokerClient client;
    private OmEndpointUbw32 endpoint;
    private OmMapPetrinet map;

    public OmService(Broker broker, String port){
        this.componentMapMiddleware = new DesmServiceMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new OmMessageProcessor();
        this.map = new OmMapPetrinet();

        this.client = new OmBrokerClient(broker, this);
        this.endpoint = new OmEndpointUbw32(port, this);
    }

    public DesmServiceMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public OmMessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public OmBrokerClient getBrokerClient(){
        return client;
    }

    public OmEndpointUbw32 getEndpoint(){
        return endpoint;
    }

    public OmMapPetrinet getMapPetrinet(){
        return this.map;
    }
}
