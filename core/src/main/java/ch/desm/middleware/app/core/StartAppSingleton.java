package ch.desm.middleware.app.core;


import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.component.cabine.re420.Re420EndpointFabisch;
import ch.desm.middleware.app.core.component.cabine.re420.Re420EndpointUbw32;
import ch.desm.middleware.app.core.component.interlocking.obermatt.OmService;
import ch.desm.middleware.app.core.component.management.ManagementService;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.PetrinetOmlService;
import ch.desm.middleware.app.core.component.simulation.locsim.Locsim;
import ch.desm.middleware.app.core.component.simulation.locsim.LocsimEndpointDll;
import ch.desm.middleware.app.core.component.simulation.locsim.LocsimEndpointRs232;
import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.server.JettyServer;
import ch.desm.middleware.app.core.server.TyrusServer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class StartAppSingleton extends DaemonThreadBase {

	private static Logger LOGGER = Logger.getLogger(StartAppSingleton.class);
	private static final StartAppSingleton singleton = new StartAppSingleton();
		
	private StartAppSingleton(){
		if (singleton != null)
	        throw new IllegalStateException("Already instantiated, only use of singleton allowed!");
	}
	
	public static StartAppSingleton getSingleton(){
		return StartAppSingleton.singleton;
	}

	public void run(){

        /************************** Start Server ************************************/
        String jettyPathWin = "C:/svn.it-hotspot.de/share/Dropbox/Dropbox/DESM-Verein/Projekte/DESM-Middleware/code/ch.desm.middleware.app/core";
        String jettyPathPi = "/opt/desm/middleware/code/ch.desm.middleware.app/webapp";
        String hostWin = "heisenberg";
        String hostPi = "raspberrypi";
        JettyServer server = startJettyServer(jettyPathWin);
        TyrusServer tyrusServer = startTyrusServer(hostWin, 8025, "/websocket");

        try {
            doHangout(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        startManagement(server, "ws://"+hostWin+":8025/websocket/gui");
        /***************************************************************************/

        //startOmlStellwerk(EndpointRs232.EnumSerialPorts.COM10);
        //startCabineRe420(EndpointRs232.EnumSerialPorts.COM4, EndpointRs232.EnumSerialPorts.COM8);
        startOmlPetrinet();
        //startLocsim(EndpointRs232.EnumSerialPorts.COM9);
        //startZusi("7.94.80.35", 1436);
    }

    private JettyServer startJettyServer(String path){
        JettyServer server = new JettyServer(path);
        server.start();

        return server;
    }

    private TyrusServer startTyrusServer(String ip, int port, String path){
        TyrusServer server = new TyrusServer(ip, port, path);
        server.start();

        return server;
    }



	public void startManagement(JettyServer server, String uri){
        ManagementService management = isServerStarted(server) ? new ManagementService(Broker.getInstance(), uri) : null;
	}

	public void startOmlPetrinet(){
        PetrinetOmlService petrinet = new PetrinetOmlService(Broker.getInstance());
	}

	public void startOmlStellwerk(EndpointRs232.EnumSerialPorts port){
        OmService oml = new OmService(Broker.getInstance(), port);
	}

    public void startZusi(String ip, int port){

        ZusiService serviceFahrpult = new ZusiService(Broker.getInstance(), ip, port);
        serviceFahrpult.getEndpointFahrpult().init();
        serviceFahrpult.getEndpointFahrpult().start();
        serviceFahrpult.getEndpointFahrpult().sendCommandRegisterClientFahrpult();
        serviceFahrpult.getEndpointFahrpult().sendCommandNeededDataFahrpult();


        ZusiService serviceAusbildung = new ZusiService(Broker.getInstance(), ip, port);
        serviceAusbildung.getEndpointAusbildung().init();
        serviceAusbildung.getEndpointAusbildung().start();
        serviceAusbildung.getEndpointAusbildung().sendCommandRegisterClientAusbildung();
        serviceAusbildung.getEndpointAusbildung().sendCommandNeededDataAusbildung();


        /*
        try {
            doHangout(2000);
            serviceAusbildung.getEndpointAusbildung().sendCommandSignalAspect();
            doHangout(2000);
            serviceAusbildung.getEndpointAusbildung().sendCommandSwitch();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */


    }


	public void startLocsim(EndpointRs232.EnumSerialPorts portRs232){
		LocsimEndpointDll endpointDll = new LocsimEndpointDll("dispatcher.json");
		LocsimEndpointRs232 endpointRs232 = new LocsimEndpointRs232(portRs232);
		Locsim locsimImpl = new Locsim(Broker.getInstance(), endpointRs232, endpointDll);
	}

    public void startCabineRe420(EndpointRs232.EnumSerialPorts comFabisch, EndpointRs232.EnumSerialPorts comUbw){
        Re420EndpointFabisch endpointFabisch = new Re420EndpointFabisch(comFabisch);
        Re420EndpointUbw32 endpointUbw32 = new Re420EndpointUbw32(comUbw);
        //Re420BrokerClient re420 = new Re420BrokerClient(Broker.getInstance(), endpointUbw32, endpointFabisch);
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
	public void startUbw32Pwm(String[] args) {

		String comPort = args[0];
		String channel = args[1];
		String dutyCycle = args[2];
		boolean autoCycle = Boolean.parseBoolean(args[3]);
		int step = Integer.parseInt(args[4]);
        boolean stepPositiv = Boolean.parseBoolean(args[5]);

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

				if (Integer.valueOf(dutyCycle) < 1 || Integer.valueOf(dutyCycle) > 65535) {
					throw new Exception("wrong duty cycle!");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.ERROR, e);
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

        re420EndpointUbw32.init();
		if(!autoCycle)re420EndpointUbw32.sendCommandPwm(channel, dutyCycle);

		while (autoCycle) {
            re420EndpointUbw32.sendCommandPwm(channel, dutyCycle);
            LOGGER.log(Level.INFO, "dutyCiycle: " + dutyCycle);

            if(stepPositiv){
                if (Integer.valueOf(dutyCycle) >= 65535) dutyCycle = "0";
                dutyCycle = String.valueOf(Integer.valueOf(dutyCycle) + Integer.valueOf(step));
            }
            else {
                if (Integer.valueOf(dutyCycle) <= 1) dutyCycle = "65535";
                dutyCycle = String.valueOf(Integer.valueOf(dutyCycle) - Integer.valueOf(step));
            }
		}
	}

     public void doHangout(){

         while(!isInterrupted()){
             try {
                 doHangout(1000*60);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }

    private boolean isServerStarted(JettyServer server){
        while(!server.isStarted()){
            try {
                doHangout(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
