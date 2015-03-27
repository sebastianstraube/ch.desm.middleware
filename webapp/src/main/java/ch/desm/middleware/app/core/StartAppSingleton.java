package ch.desm.middleware.app.core;


import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.component.cabine.re420.Re420BrokerClient;
import ch.desm.middleware.app.core.component.cabine.re420.Re420EndpointFabisch;
import ch.desm.middleware.app.core.component.cabine.re420.Re420EndpointUbw32;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OmlService;
import ch.desm.middleware.app.core.component.management.ManagementService;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.PetrinetOmlService;
import ch.desm.middleware.app.core.component.simulation.locsim.Locsim;
import ch.desm.middleware.app.core.component.simulation.locsim.LocsimEndpointDll;
import ch.desm.middleware.app.core.component.simulation.locsim.LocsimEndpointRs232;
import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiServiceTest;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultEndpointTcpClientTest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class StartAppSingleton extends DaemonThreadBase {

	private static Logger LOGGER = Logger.getLogger(StartAppSingleton.class);
	private static final StartAppSingleton singleton = new StartAppSingleton();
		
	private StartAppSingleton(){
		if (singleton != null)
	        throw new IllegalStateException("Already instantiated");
	}
	
	public static StartAppSingleton getSingleton(){
		return StartAppSingleton.singleton;
	}

	public void run(){
		startManagement("ws://heisenberg:80/gui/management");
		startOmlStellwerk(EndpointRs232.EnumSerialPorts.COM3);
        startOmlPetrinet();
        //startLocsim(EndpointRs232.EnumSerialPorts.COM9);
        //startZusi("192.168.1.19", 1436);
        startZusi("7.94.80.35", 1436);
		//testZusiService("7.94.80.35", 1436);
        //testZusiMessageTransfer("7.94.80.35", 1436);


        startHangout(Integer.MAX_VALUE);

	}

	public void startManagement(String uri){

        ManagementService management = new ManagementService(Broker.getInstance(), uri);
	}
	
	public void startOmlPetrinet(){
        PetrinetOmlService petrinet = new PetrinetOmlService(Broker.getInstance());
	}
	
	public void startOmlStellwerk(EndpointRs232.EnumSerialPorts port){
        OmlService oml = new OmlService(Broker.getInstance(), port);
	}

    public void startZusi(String ip, int port){

        ZusiService serviceFahrpult = new ZusiService(Broker.getInstance(), ip, port);
        serviceFahrpult.getEndpointFahrpult().init();
        serviceFahrpult.getEndpointFahrpult().start();
		serviceFahrpult.getEndpointFahrpult().sendMessageRegisterClient();
        serviceFahrpult.getEndpointFahrpult().sendMessageNeededData();


        ZusiService serviceAusbildung = new ZusiService(Broker.getInstance(), ip, port);

        serviceAusbildung.getEndpointAusbildung().init();
        serviceAusbildung.getEndpointAusbildung().start();
        serviceAusbildung.getEndpointAusbildung().sendMessageRegisterClient();
        serviceAusbildung.getEndpointAusbildung().sendMessageNeededData();
    }

    public void testZusiService(String ip, int port){
        ZusiServiceTest service = new ZusiServiceTest(Broker.getInstance(), ip, port);
        try {
            LOGGER.log(Level.INFO, "(true)test encode decode from middleware message: " + service.getZusiProtocolNodeConverterTest().testGetConvertToInputCommand("0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi;#"));
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(true)test transferred message is complete: " + service.getProtocolMessageChecker().isMessageComplete(service.getZusiProtocolNodeConverterTest().getMessageNeededDataFahrpult()));
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(false)test transferred message is complete: " + service.getProtocolMessageChecker().isMessageComplete(service.getZusiProtocolNodeConverterTest().testStream1()));
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(true)test globale id encode and decode is successful: " + service.getZusiProtocolNodeConverterTest().testGetGlobalId(service.getZusiProtocolNodeConverterTest().testStream3()));
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }


        try {
            LOGGER.log(Level.INFO, "(true)test encode decode is successful: " + service.getZusiProtocolNodeConverterTest().testEncodeDecode());
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(true)test no data package: " + service.getProtocolMessageChecker().isMessageComplete(service.getZusiProtocolNodeConverterTest().testStreamNoData()));
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(true)test encode no data package: " + service.getZusiProtocolNodeConverterTest().testEncode(service.getZusiProtocolNodeConverterTest().testStreamNoData()));
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(false)test encode is successful: " + service.getZusiProtocolNodeConverterTest().testEncode(service.getZusiProtocolNodeConverterTest().testStream1()));
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(false)test encode is successful: " + service.getZusiProtocolNodeConverterTest().testEncode(service.getZusiProtocolNodeConverterTest().testStream2()));

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(true)test encode is successful: " + service.getZusiProtocolNodeConverterTest().testEncode(service.getZusiProtocolNodeConverterTest().testStream3()));

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(true)test get base node from global id is successful: " + service.getZusiProtocolNodeConverterTest().testGetRoot("0003-0113-0001::0001:2B,0002:00,0003:07,0004:1,0005:0"));

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        try {
            LOGGER.log(Level.INFO, "(true)test encode decode needed data packet is complete: " + service.getZusiProtocolNodeConverterTest().testEncodeDecodeNeededData());

        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

    }

    public void testZusiMessageTransfer(String ip, int port){
        ZusiService serviceFahrpult = new ZusiService(Broker.getInstance(), ip, port);
        serviceFahrpult.getEndpointFahrpult().init();
        serviceFahrpult.getEndpointFahrpult().start();
        serviceFahrpult.getEndpointFahrpult().sendMessageRegisterClient();
        serviceFahrpult.getEndpointFahrpult().sendMessageNeededData();

        ZusiFahrpultEndpointTcpClientTest testTcp = new ZusiFahrpultEndpointTcpClientTest(serviceFahrpult);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testTcp.testStream();
    }
	
	public void startLocsim(EndpointRs232.EnumSerialPorts portRs232){
		LocsimEndpointDll endpointDll = new LocsimEndpointDll("dispatcher.json");
		LocsimEndpointRs232 endpointRs232 = new LocsimEndpointRs232(portRs232);
		Locsim locsimImpl = new Locsim(Broker.getInstance(), endpointRs232, endpointDll);
	}

	/**
	 * 
	 */
	public void testCabine(){
		Re420EndpointUbw32 re420Endpoint = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM30);
		Re420EndpointFabisch re420EndpointFabisch = new Re420EndpointFabisch(EndpointRs232.EnumSerialPorts.COM31);
		Re420BrokerClient re420Impl = new Re420BrokerClient(Broker.getInstance(), re420Endpoint, re420EndpointFabisch);

		//test analog output
		re420Impl.emulateBrokerMessage("a74;o;0;analog-instrument;spannung;fahrdraht;FF;kabinere420;#");	
		re420Impl.emulateBrokerMessage("a79;o;0;analog-instrument;strom;i_max;FF;kabinere420;#");
		re420Impl.emulateBrokerMessage("a79.1;o;0;analog-instrument;strom;i_delta;FF;kabinere420;#");		
		re420Impl.emulateBrokerMessage("d94vi;o;0;analog-instrument;geschwindigkeitsanzeige;ist;FF;kabinere420;#");
	}


	/**
	 * The "PM" Command : Set hardware PWM output values command Sets a PWM
	 * value for any of the 5 PWM hardware channels Format:
	 * "PM,<Channel>,<DutyCycle><CR>" <Channel> is required and is 1 through 5,
	 * which correspond to the output compare (OC0 through OC4 = RD0 through
	 * RD4) pins. <DutyCycle> is required and is 0 through 65535. If <DutyCycle>
	 * is 0, then the hardware PWM is shut off. The PWM frequency is 1220Hz
	 * (80MHz/0x10000) Example: "PM,3,512" Return Packet: "OK"
	 */
	public void testPWM(String[] args) {

		args = new String[]{"18"};
		
		String comPort = "18";
		String channel = "1";
		int dutyCycle = Integer.parseInt("1");
		boolean autoCycle = false;
		int stepInkrementation = 1;
		try {
			if (args.length == 0) {
				throw new Exception("no parameter!");
			} else {
				if (Integer.parseInt(comPort) <= 0
						|| Integer.parseInt(comPort) >= 23) {
					throw new Exception("wrong com Port!");
				}

				if (Integer.parseInt(channel) <= 0
						|| Integer.parseInt(channel) >= 6) {
					throw new Exception("wrong channel!");
				}

				if (dutyCycle <= 0 || dutyCycle >= 65535) {
					throw new Exception("wrong duty cycle!");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.ERROR, e);
		}

		if (args.length == 1) {
			comPort = args[0];
		} else if (args.length <= 2) {
			comPort = args[0];
			channel = args[1];
		} else if (args.length <= 3) {
			comPort = args[0];
			channel = args[1];
			dutyCycle = Integer.parseInt(args[2]);
		} else if (args.length <= 4) {
			comPort = args[0];
			channel = args[1];
			dutyCycle = Integer.parseInt(args[2]);
			autoCycle = args[3].equals("1");
		} else if (args.length <= 5) {
			comPort = args[0];
			channel = args[1];
			dutyCycle = Integer.parseInt(args[2]);
			autoCycle = args[3].equals("1");
			stepInkrementation = Integer.parseInt(args[4]);
		}

		Re420EndpointUbw32 re420EndpointUbw32;

        if (comPort.equals("1")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM1);

        } else if (comPort.equals("2")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM2);

        } else if (comPort.equals("3")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM3);

        } else if (comPort.equals("4")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM4);

        } else if (comPort.equals("5")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM5);

        } else if (comPort.equals("6")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM6);

        } else if (comPort.equals("7")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM7);

        } else if (comPort.equals("8")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM8);

        } else if (comPort.equals("9")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM9);

        } else if (comPort.equals("10")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM10);

        } else if (comPort.equals("11")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM11);

        } else if (comPort.equals("12")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM12);

        } else if (comPort.equals("13")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM13);

        } else if (comPort.equals("14")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM14);

        } else if (comPort.equals("15")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM15);

        } else if (comPort.equals("16")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM16);

        } else if (comPort.equals("17")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM17);

        } else if (comPort.equals("18")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM18);

        } else if (comPort.equals("19")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM19);

        } else if (comPort.equals("20")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM20);

        } else if (comPort.equals("21")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM21);

        } else if (comPort.equals("22")) {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM22);

        } else {
            re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM1);

        }

		re420EndpointUbw32.sendCommandPwm(channel, String.valueOf(dutyCycle));

		while (autoCycle) {
			if (dutyCycle > 65535) {
				dutyCycle = 0;
			}
			re420EndpointUbw32.sendCommandPwm(channel,
					String.valueOf(dutyCycle));

			dutyCycle += stepInkrementation;
		}

	}

    //TODO refactoring
    public boolean isHangout = true;
    public void startHangout(long val){

        while(isHangout){
            try {
                Thread.sleep(val);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void stopHangout(){
        isHangout = false;
    }
}
