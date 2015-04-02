package ch.desm.middleware.app.core;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.component.cabine.re420.Re420BrokerClient;
import ch.desm.middleware.app.core.component.cabine.re420.Re420EndpointFabisch;
import ch.desm.middleware.app.core.component.cabine.re420.Re420EndpointUbw32;
import ch.desm.middleware.app.core.component.simulation.zusi.zusi.ZusiServiceTest;
import ch.desm.middleware.app.core.component.simulation.zusi.zusi.client.ZusiFahrpultEndpointTcpClientTest;
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
    public void testZusiService() throws Exception {

        try {
            boolean b = service.getZusiProtocolNodeConverterTest().testGetConvertToInputCommand("0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi;#");
            LOGGER.log(Level.INFO, "(true)test encode decode from middleware message: " + b);
            Assert.assertEquals(true, b);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceTransferedMessageComplete() throws Exception {

        try {
            boolean b = service.getProtocolMessageChecker().isMessageComplete(service.getZusiProtocolNodeConverterTest().getMessageNeededDataFahrpult());
            LOGGER.log(Level.INFO, "(true)test transferred message is complete: " + b);
            Assert.assertEquals(true, b);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceTransferedMessageComplete1() throws Exception {

        try {
            boolean b = service.getProtocolMessageChecker().isMessageComplete(service.getZusiProtocolNodeConverterTest().getStream1());
            LOGGER.log(Level.INFO, "(false)test transferred message is complete: " + b);
            Assert.assertEquals(false, b);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceEncodeDecodeGlobalId() throws Exception {

        try {
            boolean b = service.getZusiProtocolNodeConverterTest().testGetGlobalId(service.getZusiProtocolNodeConverterTest().getStream3());
            LOGGER.log(Level.INFO, "(true)test globale id encode and decode is successful: " + b);
            Assert.assertEquals(true, b);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceEncodeDecode() throws Exception {

        try {
            boolean b = service.getZusiProtocolNodeConverterTest().testEncodeDecode();
            LOGGER.log(Level.INFO, "(true)test encode decode is successful: " + b);
            Assert.assertEquals(true, b);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceNoDataPackage() throws Exception {

        try {
            boolean b = service.getProtocolMessageChecker().isMessageComplete(service.getZusiProtocolNodeConverterTest().getStreamNoData());
            LOGGER.log(Level.INFO, "(true)test no data package: " + b);
            Assert.assertEquals(true, b);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceEncodeNoDataPackage() throws Exception {

        try {
            boolean b = service.getZusiProtocolNodeConverterTest().testEncode(service.getZusiProtocolNodeConverterTest().getStreamNoData());
            LOGGER.log(Level.INFO, "(true)test encode no data package: " + b);
            Assert.assertEquals(true, b);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceEncodeNoDataPackage1() throws Exception {

        try {
            boolean b = service.getZusiProtocolNodeConverterTest().testEncode(service.getZusiProtocolNodeConverterTest().getStream1());
            LOGGER.log(Level.INFO, "(false)test encode is successful: " + b);
            Assert.assertEquals(false, b);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceEncode() throws Exception {

        try {
            boolean b = service.getZusiProtocolNodeConverterTest().testEncode(service.getZusiProtocolNodeConverterTest().getStream2());
            LOGGER.log(Level.INFO, "(false)test encode is successful: " + b);
            Assert.assertEquals(false, b);

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceEncode1() throws Exception {

        try {
            boolean b = service.getZusiProtocolNodeConverterTest().testEncode(service.getZusiProtocolNodeConverterTest().getStream3());
            LOGGER.log(Level.INFO, "(true)test encode is successful: " + b);
            Assert.assertEquals(true, b);

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }


    @Test
    public void testZusiServiceBaseNodeFromGlobalId() throws Exception {

        try {
            boolean b = service.getZusiProtocolNodeConverterTest().testGetRoot("0003-0113-0001::0001:2B,0002:00,0003:07,0004:1,0005:0");
            LOGGER.log(Level.INFO, "(true)test get base node from global id is successful: " + b);
            Assert.assertEquals(true, b);

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceEncodeDecodedNeededDataPackage() throws Exception {

        try {
            boolean b = service.getZusiProtocolNodeConverterTest().testEncodeDecodeNeededData();
            LOGGER.log(Level.INFO, "(true)test encode decode needed data packet is complete: " + b);
            Assert.assertEquals(true, b);

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiServiceEncodeDecodeEncapsulatedZusiStream() throws Exception {

        try {
            String testStream = "000000000300000000001400000000000100060000000100313233340600000002000000000006000000030000000000060000000400000000000600000005000000000006000000060000000000060000000700000000000600000008000000000006000000090000000000060000000a0000000000ffffffff000000000100060000000100746573740600000002006b5ba0440600000003002d15d7c4060000000400fe3f28440600000005006b1a1840060000000600469bc5400600000007001bb1a1440600000008001b5dd8c4060000000900fe3f2844060000000a00331b1840ffffffffffffffffffffffff";
            boolean b = service.getZusiProtocolNodeConverterTest().testEncode(testStream);
            LOGGER.log(Level.INFO, "(true)test encode decode encapsulated zusi stream: " + b);
            Assert.assertEquals(true, b);

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Test
    public void testZusiMessageTransfer() throws Exception {

        service.getEndpointFahrpult().init();
        service.getEndpointFahrpult().start();
        service.getEndpointFahrpult().sendMessageRegisterClient();
        service.getEndpointFahrpult().sendMessageNeededData();
        ZusiFahrpultEndpointTcpClientTest testTcp = new ZusiFahrpultEndpointTcpClientTest(service);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testTcp.testStream();
    }

	/**
	 * 
	 */
    @Test
	public void testCabine() throws Exception {
		Re420EndpointUbw32 re420Endpoint = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM30);
		Re420EndpointFabisch re420EndpointFabisch = new Re420EndpointFabisch(EndpointRs232.EnumSerialPorts.COM31);
		Re420BrokerClient re420Impl = new Re420BrokerClient(Broker.getInstance(), re420Endpoint, re420EndpointFabisch);

		//test analog output
		re420Impl.emulateBrokerMessage("a74;o;0;analog-instrument;spannung;fahrdraht;FF;kabinere420;#");	
		re420Impl.emulateBrokerMessage("a79;o;0;analog-instrument;strom;i_max;FF;kabinere420;#");
		re420Impl.emulateBrokerMessage("a79.1;o;0;analog-instrument;strom;i_delta;FF;kabinere420;#");		
		re420Impl.emulateBrokerMessage("d94vi;o;0;analog-instrument;geschwindigkeitsanzeige;ist;FF;kabinere420;#");
	}
}
