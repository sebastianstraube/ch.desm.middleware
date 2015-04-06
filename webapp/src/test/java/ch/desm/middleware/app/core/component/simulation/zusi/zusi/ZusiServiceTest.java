package ch.desm.middleware.app.core.component.simulation.zusi.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelper;
import ch.desm.middleware.app.core.component.simulation.zusi.zusi.message.ZusiProtocolStreamTest;
import ch.desm.middleware.app.core.component.simulation.zusi.zusi.protocol.node.ZusiProtocolNodeDecoderTest;
import ch.desm.middleware.app.core.component.simulation.zusi.zusi.protocol.node.ZusiProtocolNodeEncoderTest;
import ch.desm.middleware.app.core.component.simulation.zusi.zusi.protocol.node.ZusiProtocolNodeHelperTest;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiServiceTest extends ZusiService {

    private ZusiProtocolStreamTest zusiProtocolStreamTest;
    private ZusiProtocolNodeDecoderTest zusiProtocolNodeDecoderTest;
    private ZusiProtocolNodeEncoderTest zusiProtocolNodeEncoderTest;
    private ZusiProtocolNodeHelperTest zusiProtocolNodeHelperTest;

    /**
     *
     * @param broker
     * @param ip
     * @param port
     */
    public ZusiServiceTest(Broker broker, String ip, int port){
        super(broker, ip, port);
        this.zusiProtocolStreamTest = new ZusiProtocolStreamTest();
        this.zusiProtocolNodeDecoderTest = new ZusiProtocolNodeDecoderTest();
        this.zusiProtocolNodeEncoderTest = new ZusiProtocolNodeEncoderTest();
        this.zusiProtocolNodeHelperTest = new ZusiProtocolNodeHelperTest();
    }

    public ZusiProtocolStreamTest getZusiProtocolStreamTest(){
        return zusiProtocolStreamTest;
    }

    public ZusiProtocolNodeDecoderTest getZusiProtocolNodeDecoderTest(){
        return this.zusiProtocolNodeDecoderTest;
    }

    public ZusiProtocolNodeEncoderTest getZusiProtocolNodeEncoderTest(){
        return this.zusiProtocolNodeEncoderTest;
    }

    public ZusiProtocolNodeHelperTest getZusiProtocolNodeHelperTest(){
        return this.zusiProtocolNodeHelperTest;
    }
}
