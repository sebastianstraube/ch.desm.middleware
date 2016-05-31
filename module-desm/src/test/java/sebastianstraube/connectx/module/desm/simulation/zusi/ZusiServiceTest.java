package sebastianstraube.connectx.module.desm.simulation.zusi;

import sebastianstraube.connectx.core.communication.broker.Broker;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.ZusiProtocolMessageHelperTest;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.node.ZusiProtocolNodeHelperTest;
import sebastianstraube.connectx.module.desm.simulation.zusi.message.ZusiProtocolStreamTest;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.node.ZusiProtocolNodeCodecTest;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiServiceTest extends ZusiService {

    private ZusiProtocolStreamTest zusiProtocolStreamTest;
    private ZusiProtocolNodeCodecTest zusiProtocolNodeCodecTest;
    private ZusiProtocolNodeHelperTest zusiProtocolNodeHelperTest;
    private ZusiProtocolMessageHelperTest zusiProtocolMessageHelperTest;
    private ZusiMessageProcessorTest zusiMessageProcessorTest;

    /**
     *
     * @param broker
     * @param ip
     * @param port
     */
    public ZusiServiceTest(Broker broker, String ip, int port){
        super(broker, ip, port);
        this.zusiProtocolStreamTest = new ZusiProtocolStreamTest();
        this.zusiProtocolNodeCodecTest = new ZusiProtocolNodeCodecTest();
        this.zusiProtocolNodeHelperTest = new ZusiProtocolNodeHelperTest(this);
        this.zusiProtocolMessageHelperTest = new ZusiProtocolMessageHelperTest();
        this.zusiMessageProcessorTest = new ZusiMessageProcessorTest();
    }

    public ZusiProtocolStreamTest getZusiProtocolStreamTest(){
        return zusiProtocolStreamTest;
    }

    public ZusiProtocolNodeCodecTest getZusiProtocolNodeCodecTest(){
        return this.zusiProtocolNodeCodecTest;
    }

    public ZusiProtocolNodeHelperTest getZusiProtocolNodeHelperTest(){
        return this.zusiProtocolNodeHelperTest;
    }

    public ZusiProtocolMessageHelperTest getZusiProtocolMessageHelperTest(){
        return this.zusiProtocolMessageHelperTest;
    }

    public ZusiMessageProcessorTest getZusiMessageProcessorTest(){
        return this.zusiMessageProcessorTest;
    }
}
