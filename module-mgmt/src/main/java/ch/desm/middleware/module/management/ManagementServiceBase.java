package ch.desm.middleware.module.management;

import ch.desm.middleware.core.communication.broker.BrokerInstance;
import ch.desm.middleware.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import ch.desm.middleware.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import ch.desm.middleware.core.communication.message.translator.MessageTranslatorWebsocket;
import ch.desm.middleware.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.core.component.ComponentMapBase;

/**
 * Created by Sebastian on 11.11.2014.
 */
abstract class ManagementServiceBase {

    private ManagementMessageTranslator translator = new ManagementMessageTranslator();
    private ManagementMessageProcessor processor = new ManagementMessageProcessor();
    private EndpointWebsocketMessageEncoder encoder = new EndpointWebsocketMessageEncoder();
    private EndpointWebsocketMessageDecoder decoder = new EndpointWebsocketMessageDecoder();
    private MessageTranslatorWebsocket converter = new MessageTranslatorWebsocket();
    private ManagementBrokerClient client;
    private ManagementEndpointClientCreator endpoint;


    public ManagementServiceBase(){
        this.client = new ManagementBrokerClient(BrokerInstance.getSingleton(), this);
        this.endpoint = new ManagementEndpointClientCreator(this);
    }

    public abstract ComponentMapBase getComponentMapMiddleware();

    public ManagementMessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public ManagementBrokerClient getBrokerClient(){
        return client;
    }

    public ManagementEndpointClientCreator getEndpoint(){
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
