package ch.desm.middleware.app.module.gui;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorWebsocket;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;

/**
 * Created by Sebastian on 11.11.2014.
 */
public class ManagementService {

    private ComponentMapMiddleware componentMapMiddleware;
    private ManagementMessageTranslator translator;
    private ManagementMessageProcessor processor;
    private EndpointWebsocketMessageEncoder encoder;
    private EndpointWebsocketMessageDecoder decoder;
    private MessageTranslatorWebsocket converter;
    private ManagementBrokerClient client;
    private ManagementEndpoint endpoint;

    public ManagementService(Broker broker, String uri){
        this.client = new ManagementBrokerClient(broker, this);
        this.endpoint = new ManagementEndpoint(this, uri);

        componentMapMiddleware = new ComponentMapMiddleware();
        translator = new ManagementMessageTranslator();
        processor = new ManagementMessageProcessor();
        encoder = new EndpointWebsocketMessageEncoder();
        decoder = new EndpointWebsocketMessageDecoder();
        converter = new MessageTranslatorWebsocket();
    }


    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public ManagementMessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public ManagementBrokerClient getBrokerClient(){
        return client;
    }

    public ManagementEndpoint getEndpoint(){
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
