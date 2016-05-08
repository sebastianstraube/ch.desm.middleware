package ch.desm.middleware.module.desm.simulation.etcs;

import ch.desm.middleware.core.communication.broker.Broker;
import ch.desm.middleware.core.communication.broker.BrokerClient;
import ch.desm.middleware.core.communication.endpoint.tcp.EndpointTcpClient;
import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.core.component.ComponentServiceBase;
import ch.desm.middleware.module.DesmMapMiddleware;
import ch.desm.middleware.module.desm.simulation.zusi.protocol.*;
import ch.desm.middleware.module.desm.simulation.zusi.protocol.node.ZusiProtocolNodeCodec;

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
        this.endpoint = new EtcsEndpointTcpClient(this, ip, port, MessageCommon.MESSAGE_TOPIC_ETCS_TIU, "ETCS_TIU");

    }

    /**
     *
     * @return
     */
    public DesmMapMiddleware getComponentMapMiddleware(){
        return new DesmMapMiddleware();
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
