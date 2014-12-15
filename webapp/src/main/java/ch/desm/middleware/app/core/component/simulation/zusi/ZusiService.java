package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OmlBrokerClient;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OmlEndpointUbw32;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OmlEndpointUbw32Cache;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OmlMessageProcessor;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapPetrinet;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapLocsim;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiService {

    private MessageTranslatorMiddleware translator;
    private ZusiMessageProcessor processor;
    private ComponentMapMiddleware componentMapMiddleware;
    private ZusiBrokerClient client;
    private ZusiEndpoint endpoint;
    private ZusiMapLocsim map;

    public ZusiService(Broker broker, String ip, int port){

        this.componentMapMiddleware = new ComponentMapMiddleware();
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new ZusiMessageProcessor();
        this.map = new ZusiMapLocsim();

        this.client = new ZusiBrokerClient(broker, this);
        this.endpoint = new ZusiEndpoint(ip, port);

    }
    public ComponentMapMiddleware getComponentMapMiddleware(){
        return componentMapMiddleware;
    }

    public ZusiMessageProcessor getProcessor(){
        return processor;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    public ZusiEndpoint getEndpoint(){
        return endpoint;
    }

    public ZusiBrokerClient getBrokerClient(){
        return client;
    }

    public ZusiMapLocsim getMap(){
        return this.map;
    }
}
