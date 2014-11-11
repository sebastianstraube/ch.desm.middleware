package ch.desm.middleware.app.core;


import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.communication.endpoint.serial.ubw32.EndpointUbw32;
import ch.desm.middleware.app.core.component.cabine.re420.Re420;
import ch.desm.middleware.app.core.component.cabine.re420.Re420EndpointFabisch;
import ch.desm.middleware.app.core.component.cabine.re420.Re420EndpointUbw32;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OML;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OMLEndpointUbw32;
import ch.desm.middleware.app.core.component.management.Management;
import ch.desm.middleware.app.core.component.management.ManagementEndpoint;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.PetrinetOmlBrokerClient;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.PetrinetOmlEndpoint;
import ch.desm.middleware.app.core.component.simulation.locsim.Locsim;
import ch.desm.middleware.app.core.component.simulation.locsim.LocsimEndpointDll;
import ch.desm.middleware.app.core.component.simulation.locsim.LocsimEndpointRs232;
import ch.desm.middleware.app.core.common.DaemonThreadBase;
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
		startManagement();
		startOmlStellwerk(EndpointRs232.EnumSerialPorts.COM10);
        startOmlPetrinet();
        //startLocsim(EndpointRs232.EnumSerialPorts.COM9);

        startHangout(Integer.MAX_VALUE);

	}

	public boolean startManagement(){
		ManagementEndpoint endpoint = new ManagementEndpoint();
		Management mgmt = new Management(Broker.getInstance(), endpoint);
		
		return true;
	}
	
	public boolean startOmlPetrinet(){
        PetrinetOmlEndpoint endpoint = new PetrinetOmlEndpoint();
        PetrinetOmlBrokerClient petriNetBase = new PetrinetOmlBrokerClient(Broker.getInstance(), endpoint);
        
        return true;       
	}
	
	public void startOmlStellwerk(EndpointRs232.EnumSerialPorts port){
		OMLEndpointUbw32 omlEndpoint = new OMLEndpointUbw32(port);
		OML OmlImpl = new OML(Broker.getInstance(), omlEndpoint);
	}
	
	public void startLocsim(EndpointRs232.EnumSerialPorts portRs232){
		LocsimEndpointDll endpointDll = new LocsimEndpointDll("dispatcher.json");
		LocsimEndpointRs232 endpointRs232 = new LocsimEndpointRs232(portRs232);
		Locsim locsimImpl = new Locsim(Broker.getInstance(), endpointRs232, endpointDll);
	}
	
	/**
	 * 
	 */
	public void testCaseLocsimEndpointDllRs232() {
		LOGGER.log(Level.TRACE, System.getProperty("java.library.path"));

		//Test Cabine
		Re420EndpointUbw32 re420EndpointUbw32 = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM13);
//		Re420BaseImpl re420Impl = new Re420BaseImpl(broker, re420EndpointUbw32);
		
		//Test Interlocking
		OMLEndpointUbw32 omlEndpoint = new OMLEndpointUbw32(EndpointRs232.EnumSerialPorts.COM12);
		OML OmlImpl = new OML(Broker.getInstance(), omlEndpoint);
		
		//Test Simulation
		LocsimEndpointDll endpointDll = new LocsimEndpointDll("dispatcher.json");
		LocsimEndpointRs232 endpointRs232 = new LocsimEndpointRs232(EndpointRs232.EnumSerialPorts.COM5);
		Locsim locsimImpl = new Locsim(Broker.getInstance(), endpointRs232, endpointDll);
	}
	
	/**
	 * 
	 */
	public void testCaseOMLEndpointUbw32() {
		
		
		//Test Petrinet
		PetrinetOmlEndpoint petrinetOmlEndpoint = new PetrinetOmlEndpoint();
		PetrinetOmlBrokerClient petrinetOmlBrokerClient = new PetrinetOmlBrokerClient(Broker.getInstance(), petrinetOmlEndpoint);

		
		//Test Interlocking
//		OMLEndpointUbw32 omlEndpoint = new OMLEndpointUbw32(EnumSerialPorts.COM38);
//		OML OmlImpl = new OML(broker, omlEndpoint);

		
		//FSS 10°
		petrinetOmlBrokerClient.emulateBrokerMessage("10.99.07;i;1;kontakt;isolierung;belegt;on;stellwerkobermattlangnau;#");
	}

	/**
	 * 
	 */
	public void testCabine(){
		Re420EndpointUbw32 re420Endpoint = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM30);
		Re420EndpointFabisch re420EndpointFabisch = new Re420EndpointFabisch(EndpointRs232.EnumSerialPorts.COM31);
		Re420 re420Impl = new Re420(Broker.getInstance(), re420Endpoint, re420EndpointFabisch);

		//test analog output
		re420Impl.emulateBrokerMessage("a74;o;0;analog-instrument;spannung;fahrdraht;FF;kabinere420;#");	
		re420Impl.emulateBrokerMessage("a79;o;0;analog-instrument;strom;i_max;FF;kabinere420;#");
		re420Impl.emulateBrokerMessage("a79.1;o;0;analog-instrument;strom;i_delta;FF;kabinere420;#");		
		re420Impl.emulateBrokerMessage("d94vi;o;0;analog-instrument;geschwindigkeitsanzeige;ist;FF;kabinere420;#");
	}
	
	/**
	 * 
	 */
	public void testCaseLocsimEndpointRs232_to_CabineUbw32(Broker broker) {
		//Test Cabine
		Re420EndpointUbw32 re420Endpoint = new Re420EndpointUbw32(EndpointRs232.EnumSerialPorts.COM24);
		Re420EndpointFabisch re420EndpointFabisch = new Re420EndpointFabisch(EndpointRs232.EnumSerialPorts.COM25);
		Re420 re420Impl = new Re420(broker, re420Endpoint, re420EndpointFabisch);
		
		//Test Simulation
		LocsimEndpointDll locsimEndpointDll = new LocsimEndpointDll("dispatcher.json");
		LocsimEndpointRs232 locsimEndpointRs232 = new LocsimEndpointRs232(EndpointRs232.EnumSerialPorts.COM23);
		Locsim locsimImpl = new Locsim(broker, locsimEndpointRs232, locsimEndpointDll);
		
		//Start Test sequence
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			LOGGER.log(Level.ERROR, e);
//		}
//		
//		locsimEndpointRs232.emulateEndpointMessage("INI1");
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			LOGGER.log(Level.ERROR, e);
//		}
//		
//		locsimEndpointRs232.emulateEndpointMessage("INI7");
	}
	
	/**
	 * 
	 */
	public void testEndpointPetriNet(Broker broker){
        PetrinetOmlEndpoint endpoint = new PetrinetOmlEndpoint();
        PetrinetOmlBrokerClient petriNetBase = new PetrinetOmlBrokerClient(broker, endpoint);
        
		//Test Interlocking
		OMLEndpointUbw32 omlEndpoint = new OMLEndpointUbw32(EndpointRs232.EnumSerialPorts.COM9);
		OML OmlImpl = new OML(broker, omlEndpoint);
        
		//test case
//		petriNetBase.emulateBrokerMessage("1.90.04;o;0;lampe;signalf;rot;on;stellwerkobermattlangnau;#");
		
	}
	
	/**
	 * 
	 */
	public void testCaseDll(Broker broker) {
//		LOGGER.log(Level.TRACE,"java.library.path");
		
		LocsimEndpointDll locsimEndpointDll = new LocsimEndpointDll("dispatcher.json");
		LocsimEndpointRs232 locsimEndpointRs232 = new LocsimEndpointRs232(EndpointRs232.EnumSerialPorts.COM22);

		Locsim locsim = new Locsim(broker, locsimEndpointRs232, locsimEndpointDll);
	}
	
	/**
	 * 
	 */
	public void testCaseUbw32(){
		EndpointUbw32 endpoint = new EndpointUbw32(EndpointRs232.EnumSerialPorts.COM33, "192,0,8192,16372,0,1,2", "0");

//		endpoint.sendCommandInputState();
		endpoint.sendCommandPinOutput("G", "8", "1");
		
		endpoint.start();
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
