package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import ch.desm.middleware.app.core.communication.message.converter.MessageConverter;
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
    private MessageConverter converter;
    private ManagementBrokerClient client;
    private ManagementEndpoint endpoint;

    public ManagementService(Broker broker, String uri){
        this.client = new ManagementBrokerClient(broker, this);
        this.endpoint = new ManagementEndpoint(this, uri);

        componentMapMiddleware = new ComponentMapMiddleware();
        translator = new ManagementMessageTranslator();
        processor = new ManagementMessageProcessor();
        encoder = new EndpointWebsocketMessageEncoder();
        converter = new MessageConverter();
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

    public MessageConverter getConverter(){
        return converter;
    }
}
