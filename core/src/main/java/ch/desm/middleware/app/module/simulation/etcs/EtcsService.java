package ch.desm.middleware.app.module.simulation.etcs;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.broker.BrokerClient;
import ch.desm.middleware.app.core.communication.endpoint.tcp.EndpointTcpClient;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.ComponentServiceBase;
import ch.desm.middleware.app.module.simulation.zusi.protocol.*;
import ch.desm.middleware.app.module.simulation.zusi.protocol.node.ZusiProtocolNodeCodec;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class EtcsService extends ComponentServiceBase {

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
    public EtcsService(Broker broker, String ip, int port){
        this.ip = ip;
        this.port = port;
        this.broker = new EtcsBrokerClient(broker, this);
        this.endpoint = new EtcsEndpointTcpClient(this, ip, port, MessageBase.MESSAGE_TOPIC_ETCS_TIU, "ETCS_TIU");

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
    public EtcsMessageProcessor getMessageProcessor(){
        return new EtcsMessageProcessor();
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
