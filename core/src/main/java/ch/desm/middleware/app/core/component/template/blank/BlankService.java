package ch.desm.middleware.app.core.component.template.blank;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.broker.BrokerClient;
import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.ComponentServiceBase;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.*;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeCodec;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class BlankService extends ComponentServiceBase {

    private BrokerClient broker;
    private String ip;
    private int port;
    private EndpointTcpClient endpoint;

    /**
     *
     * @param broker
     * @param ip
     * @param port
     */
    public BlankService(Broker broker, String ip, int port){
        this.ip = ip;
        this.port = port;
        this.broker = new BlankBrokerClient(broker, this);
        this.endpoint = new BlankEndpointTcpClient(this, ip, port, MessageBase.MESSAGE_TOPIC_ETCS_TIU, "ETCS_Blank");

    }

    /**
     *
     * @return
     */
    public ComponentMapMiddleware getComponentMapMiddleware(){
        return new ComponentMapMiddleware();
    }

    /**
     *
     * @return
     */
    public BlankMessageProcessor getMessageProcessor(){
        return new BlankMessageProcessor();
    }

    @Override
    public EndpointTcpClient getEndpoint() {
        return endpoint;
    }


    /**
     *
     * @return
     */
    public ZusiProtocolMessageHelper getMessageCheck(){
        return new ZusiProtocolMessageHelper();
    }


    /**
     *
     * @return
     */
    public MessageTranslatorMiddleware getTranslator(){
        return new MessageTranslatorMiddleware();
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeCodec getCodec(){
        return new ZusiProtocolNodeCodec();
    }


}
