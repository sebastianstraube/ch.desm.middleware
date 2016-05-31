package sebastianstraube.connectx.core.module.websocket.client;

import sebastianstraube.connectx.core.communication.broker.BrokerInstance;
import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import sebastianstraube.connectx.core.communication.message.translator.MessageTranslatorWebsocket;
import sebastianstraube.connectx.core.communication.message.translator.MessageTranslatorMiddleware;
import sebastianstraube.connectx.core.component.ComponentMapBase;

/**
 * Created by Sebastian on 11.11.2014.
 */
abstract class WebsocketClientServiceBase {

    private WebsocketClientMessageTranslator translator = new WebsocketClientMessageTranslator();
    private WebsocketClientMessageProcessor processor = new WebsocketClientMessageProcessor();
    private EndpointWebsocketMessageEncoder encoder = new EndpointWebsocketMessageEncoder();
    private EndpointWebsocketMessageDecoder decoder = new EndpointWebsocketMessageDecoder();
    private MessageTranslatorWebsocket converter = new MessageTranslatorWebsocket();
    private WebsocketClientBrokerClient client;
    private WebsocketClientEndpointCreator endpoint;


    public WebsocketClientServiceBase(){
        this.client = new WebsocketClientBrokerClient(BrokerInstance.getSingleton(), this);
        this.endpoint = new WebsocketClientEndpointCreator(this);
    }

    public abstract ComponentMapBase getComponentMapMiddleware();

    public WebsocketClientMessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public WebsocketClientBrokerClient getBrokerClient(){
        return client;
    }

    public WebsocketClientEndpointCreator getEndpoint(){
        return endpoint;
    }

    public EndpointWebsocketMessageEncoder getEncoder(){
        return encoder;
    }

    public EndpointWebsocketMessageDecoder getDecoder(){
        return decoder;
    }

    public MessageTranslatorWebsocket getConverter(){
        return converter;
    }

}
