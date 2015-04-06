package ch.desm.middleware.app.core;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import ch.desm.middleware.app.core.component.simulation.zusi.zusi.ZusiServiceTest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StartAppMainTest {

	private static Logger LOGGER = Logger.getLogger(StartAppMainTest.class);

    private ZusiServiceTest service;

    public static void main(String args[]){

    }

    @Before
    public void setUp() throws Exception {
        service = new ZusiServiceTest(Broker.getInstance(), "7.94.80.35", 1436);
    }

    @Test
    public void testDecodeGetNodeStream() throws Exception{
        String stream = "06000000010031323334";
        boolean encapsulation = false;
        ZusiProtocolNode node = new ZusiProtocolNode(stream);
        boolean b = service.getZusiProtocolNodeDecoderTest().testGetNodeStream(stream, encapsulation, node);
        LOGGER.log(Level.INFO, "(true) test decode get node stream: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testEncodeGetNodeStream() throws Exception{
        String stream = "06000000010031323334";
        boolean encapsulation = false;
        ZusiProtocolNode node = new ZusiProtocolNode(stream);
        boolean b = service.getZusiProtocolNodeEncoderTest().testGetNodeStream(stream, encapsulation, node);
        LOGGER.log(Level.INFO, "(true) test encode get node stream: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testGetGlobalId() throws Exception{
        String stream = "0000000001000000000002000b000000010020332e302e362e32360c00000002003137333335323236363703000000030000ffffffffffffffff";
        boolean b = service.getZusiProtocolNodeHelperTest().testGetGlobalId(stream, service);
        LOGGER.log(Level.INFO, "(true)test get global id: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testGetGetRoot() throws Exception{
        String stream = "0100-0200::0100:20332e302e362e3236,0200:31373333353232363637,0300:00";
        boolean b = service.getZusiProtocolNodeHelperTest().testGetRoot(stream);
        LOGGER.log(Level.INFO, "(true)test get root: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testGetRootIntegrated() throws Exception{
        String stream = "0100-0200::0100:20332e302e362e3236,0200:31373333353232363637,0300:00";
        boolean b = service.getZusiProtocolNodeHelperTest().testGetRootIntegrated(stream);
        LOGGER.log(Level.INFO, "(true)test get root with integegrated en- and decoding: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
         public void testEncodeDecode() throws Exception{
        String streamConnect = "000000000100"+"000000000100"+"0400000001000200"+"0400000002000200"+"0A00000003004661687270756C74"+"050000000400322E30"+"FFFFFFFF"+"FFFFFFFF";
        boolean b = service.getZusiProtocolNodeHelperTest().testEncodeDecode(service, streamConnect);
        LOGGER.log(Level.INFO, "(true)test encode decode: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testIntegratedStream() throws Exception{
        String stream = "000000000300000000000d0006000000010074657374060000000200de22a044060000000300e4ded6c4060000000400fe3f28440600000005006b1a1840060000000600ba58a640060000000700e1ef1442060000000900002a2447060000000a00d817003f060000000b008078a144060000000c00c526d8c4060000000d00fe3f2844060000000e00331b1840ffffffffffffffff";
        boolean b = service.getZusiProtocolNodeHelperTest().testIntegratedStream(service, stream);
        LOGGER.log(Level.INFO, "(true)test integrated stream: " + b);
        Assert.assertEquals(true, b);
    }


    @Test
    public void testEncodeDecodeNeededData() throws Exception{
        String streamConnect = "000000000200"+"000000000300"+"000000000A00"+"0400000001000100"+"FFFFFFFF"+"FFFFFFFF"+"FFFFFFFF";
        boolean b = service.getZusiProtocolNodeHelperTest().testEncodeDecodeNeededData(service, streamConnect);
        LOGGER.log(Level.INFO, "(true)test encode decode: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testGetConvertToInputCommand() throws Exception{
        String middlewareMessage = "0200-0A01-0100::0100:11,0200:00,0300:01,0400:00,0500:00;;;hauptschalter;aus;taste n;?;zusi;#";
        boolean b = service.getZusiProtocolNodeHelperTest().testIntegratedMiddlewareMessage(service, middlewareMessage);
        LOGGER.log(Level.INFO, "(true)test encode decode: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testCmpZusiProtocolNodeBase() throws Exception{
        boolean b = service.getZusiProtocolNodeHelperTest().testCmpZusiProtocolNodeBase();
        LOGGER.log(Level.INFO, "(true)test compare identical ZusiProtocolNodes: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testCmpZusiProtocolNode() throws Exception{
        boolean b = service.getZusiProtocolNodeHelperTest().testCmpZusiProtocolNode();
        LOGGER.log(Level.INFO, "(false)test compare different ZusiProtocolNodes: " + b);
        Assert.assertEquals(false, b);
    }

}
