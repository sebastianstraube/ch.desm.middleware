package ch.desm.middleware.app.core;

import ch.desm.middleware.app.core.common.Pair;
import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import ch.desm.middleware.app.core.component.simulation.zusi.zusi.ZusiServiceTest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

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
    public void testEncodeDecodeNodeGlobalId() throws Exception{
        LinkedList<String> streamList = new LinkedList<>();
        streamList.add("0000000001000000000002000b000000010020332e302e362e32360c00000002003137333335323236363703000000030000ffffffffffffffff");
        streamList.add("000000000300000000000d0006000000010074657374060000000200de22a044060000000300e4ded6c4060000000400fe3f28440600000005006b1a1840060000000600ba58a640060000000700e1ef1442060000000900002a2447060000000a00d817003f060000000b008078a144060000000c00c526d8c4060000000d00fe3f2844060000000e00331b1840ffffffffffffffff");
        streamList.add("00000000030000000000040003000000010000ffffffffffffffff");
        streamList.add("000000000300000000001400000000000100060000000100313233340600000002000000000006000000030000000000060000000400000000000600000005000000000006000000060000000000060000000700000000000600000008000000000006000000090000000000060000000a0000000000ffffffff00000000010006000000010074657374060000000200ae2caa4406000000030067fcdfc4060000000400fe3f2844060000000500f9201b40060000000600000000000600000007005f91ab44060000000800ed33e1c4060000000900fe3f2844060000000a00cd1d1b40ffffffffffffffffffffffff");

        boolean b = true;
        for (String stream : streamList){
            b = b && service.getZusiProtocolNodeHelperTest().testEncodeDecodeNodeGlobalId(stream, service);
            if(!b) break;
        }
        LOGGER.log(Level.INFO, "(true)test get global id: " + b);
        Assert.assertEquals(true, b);
    }



    @Test
    public void testEncodeDecode() throws Exception{
        LinkedList<String> streamList = new LinkedList<>();
        streamList.add("000000000300000000001400000000000100060000000100313233340600000002000000000006000000030000000000060000000400000000000600000005000000000006000000060000000000060000000700000000000600000008000000000006000000090000000000060000000a0000000000ffffffff00000000010006000000010074657374060000000200ae2caa4406000000030067fcdfc4060000000400fe3f2844060000000500f9201b40060000000600000000000600000007005f91ab44060000000800ed33e1c4060000000900fe3f2844060000000a00cd1d1b40ffffffffffffffffffffffff");
        streamList.add("0000000001000000000002000b000000010020332e302e362e32360c00000002003137333335323236363703000000030000ffffffffffffffff");
        streamList.add("000000000300000000000d0006000000010074657374060000000200de22a044060000000300e4ded6c4060000000400fe3f28440600000005006b1a1840060000000600ba58a640060000000700e1ef1442060000000900002a2447060000000a00d817003f060000000b008078a144060000000c00c526d8c4060000000d00fe3f2844060000000e00331b1840ffffffffffffffff");
        streamList.add("00000000030000000000040003000000010000ffffffffffffffff");

        boolean b = true;
        for (String stream : streamList){
            b = b && service.getZusiProtocolNodeHelperTest().testEncodeDecode(stream, service);
            if(!b) break;
        }
        LOGGER.log(Level.INFO, "(true)test encode decode stream: " + b);
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
         public void testEncodeDecodeRegisterFahrpult() throws Exception{
        String streamConnect = "000000000100"+"000000000100"+"0400000001000200"+"0400000002000200"+"0A00000003004661687270756C74"+"050000000400322E30"+"FFFFFFFF"+"FFFFFFFF";
        boolean b = service.getZusiProtocolNodeHelperTest().testEncodeDecodeRegisterFahrpult(service, streamConnect);
        LOGGER.log(Level.INFO, "(true)test encode decode: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testIntegratedInputStream() throws Exception{
        String stream = "000000000300000000000d0006000000010074657374060000000200de22a044060000000300e4ded6c4060000000400fe3f28440600000005006b1a1840060000000600ba58a640060000000700e1ef1442060000000900002a2447060000000a00d817003f060000000b008078a144060000000c00c526d8c4060000000d00fe3f2844060000000e00331b1840ffffffffffffffff";
        boolean b = service.getZusiProtocolNodeHelperTest().testIntegratedInputStream(service, stream);
        LOGGER.log(Level.INFO, "(true)test integrated input stream: " + b);
        Assert.assertEquals(true, b);
    }


    @Test
    public void testEncodeDecodeNeededDataFahrpult() throws Exception{
        String streamConnect = "000000000200"+"000000000300"+"000000000A00"+"0400000001000100"+"FFFFFFFF"+"FFFFFFFF"+"FFFFFFFF";
        boolean b = service.getZusiProtocolNodeHelperTest().testEncodeDecodeNeededDataFahrpult(service, streamConnect);
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

    @Test
    public void testZusiProtocolMessageHelper() throws Exception{
        LinkedList<Pair<String, String>> streamList = new LinkedList<>();
        streamList.add(new Pair("00000000030000000000140000000000010006000000010031323334060000000200937874c4060000000300f44d04c40600000004001b9f224406000000050085de3c3e060000000600000000000600000007006b1a78c4060000000800210205c4060000000900ab9d2244060000000a00c6d84f3effffffff00000000010006000000010074657374060000000200ae2caa4406000000030067fcdfc4060000000400fe3f2844060000000500f9201b40060000000600000000000600000007005f91ab44060000000800ed33e1c4060000000900fe3f2844060000000a00cd1d1b40ffffffffffffffffffffffff" + "000000000100000000000200020000000100FF", "00000000030000000000140000000000010006000000010031323334060000000200937874c4060000000300f44d04c40600000004001b9f224406000000050085de3c3e060000000600000000000600000007006b1a78c4060000000800210205c4060000000900ab9d2244060000000a00c6d84f3effffffff00000000010006000000010074657374060000000200ae2caa4406000000030067fcdfc4060000000400fe3f2844060000000500f9201b40060000000600000000000600000007005f91ab44060000000800ed33e1c4060000000900fe3f2844060000000a00cd1d1b40ffffffffffffffffffffffff"));

        boolean b = true;
        for (Pair<String, String> stream : streamList){
            b = b && service.getZusiProtocolMessageHelperTest().testGetSingleZusiMessage(stream.getLeft(), stream.getRight());
            if(!b) break;
        }
        LOGGER.log(Level.INFO, "(true)test get global id: " + b);
        Assert.assertEquals(true, b);
    }

    @Test
    public void testGetGlobalId() throws Exception {
        LinkedList<Pair<String, String>> streamList = new LinkedList<>();
        streamList.add(new Pair("000000000300000000001400000000000100060000000100313233340600000002009b7874c4060000000300f54d04c40600000004001b9f224406000000050085de3c3e060000000600000000000600000007006a1a78c4060000000800210205c4060000000900ab9d2244060000000a00c6d84f3effffffff0000000001000600000001007465737406000000020042c8dcc2060000000300e40289c4060000000400d6cb2444060000000500b0052740060000000600a4cbd241060000000700c845c3c206000000080010f389c406000000090067d42444060000000a00b0052740ffffffffffffffffffffffff", "0300-1400-0100::0100:31323334,0200:9b7874c4,0300:f54d04c4,0400:1b9f2244,0500:85de3c3e,0600:00000000,0700:6a1a78c4,0800:210205c4,0900:ab9d2244,0a00:c6d84f3e#0300-1400-0100::0100:74657374,0200:42c8dcc2,0300:e40289c4,0400:d6cb2444,0500:b0052740,0600:a4cbd241,0700:c845c3c2,0800:10f389c4,0900:67d42444,0a00:b0052740#"));

        boolean b = true;
        for (Pair<String, String> stream : streamList){
            b = b && service.getZusiProtocolNodeHelperTest().testGetGlobalId(stream.getLeft(), stream.getRight());
            if(!b) break;
        }
        LOGGER.log(Level.INFO, "(true)test encode decode stream: " + b);
        Assert.assertEquals(true, b);
    }

}
