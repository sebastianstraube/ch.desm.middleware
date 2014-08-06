package ch.desm.middleware.modules.communication.endpoint.serial.fabisch;

import jssc.SerialPortEvent;
import jssc.SerialPortException;

import org.apache.log4j.Logger;

import ch.desm.middleware.modules.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.modules.communication.endpoint.serial.EndpointRs232Config;
import ch.desm.middleware.modules.communication.endpoint.serial.EndpointRs232ConfigBuilder;

/**
 * send buffer = 256
 * read buffer = 128 
 * @author Jürg
 *
 */
public class EndpointFabisch extends EndpointRs232 {

	private static Logger log = Logger.getLogger(EndpointFabisch.class);
	
	EndpointFabischPolling polling;
	/**
	 * 
	 * @param enumSerialPort
	 */
	public EndpointFabisch(EnumSerialPorts enumSerialPort) {
		super(enumSerialPort, new EndpointRs232ConfigBuilder()
				.setBaudRate(EndpointRs232Config.BAUDRATE_9600)
				.setDataBits(EndpointRs232Config.DATABITS_8)
				.setStopBits(EndpointRs232Config.STOPBITS_1)
				.setParity(EndpointRs232Config.PARITY_NONE)
				.setEventMask(EndpointRs232Config.MASK_RXCHAR)
				.setFlowControl(EndpointRs232Config.FLOWCONTROL_NONE).build());

		this.polling = new EndpointFabischPolling(this, 256);
		this.initialize();
	}


	/**
	 * do work to initialze the controller on constructor call
	 */
	private void initialize() {
		polling.start();
		
		//ping
		this.sendStream("000101");
		
		//reset
		this.sendStream("F76500");
		
		//Systemuhr 
		this.sendStream("F61900"); // Stunden
		this.sendStream("F61A00"); // minuten
		this.sendStream("F61B00"); // sekunden
				
//		//Countdown start
////	this.sendStream("F62205");
//				
//		//modus Simulation
//		this.sendStream("F62D01");
//		
//		//türen links on
//		this.sendStream("479102");
//		
//		//türen links off
//		this.sendStream("479101");
//
//		//magnet of m-taste anziehen
//		this.sendStream("47E102");
//		
//		//magnet of m-taste lösen
//		this.sendStream("47E101");
//
//		//lampe abfertigungsbefehl ein
//		this.sendStream("46B402");
//		
//		//lampe abfertigungsbefehl aus
//		this.sendStream("46B401");
//		
//		
//		//lampe abfertigungsbefehl ein
//		this.sendStream("5D5C02");
//		
//		//lampe abfertigungsbefehl ein
//		this.sendStream("5D5C03");
//	
//		//lampe abfertigungsbefehl ein
//		this.sendStream("5D5C01");

	}

	/**
	 * 
	 */
	public void pollingCommand(){
		
	}

	@Override
	/**
	 * this listener receives a command from UBW32
	 * 
	 * @param SerialPortEvent event
	 */
	public synchronized void serialEvent(SerialPortEvent event) {
		String message = super.getSerialPortMessage(event);
		
		byte[] b = message.getBytes();
		
		String s = "";
		for(int i=0; i< b.length; i++){
			s += (char)b[i];
			
			if(i!=b.length-1){
				s += ",";
			}
		}
		
		log.info("endpoint (" +this.getClass()+ ") received message : [" + message + "], bytes: ["+s+"]");
		
		message += "fabisch#";
	}

	
	/**
	 * TODO refactoring sleep
	 */
	protected void sendStream(int h0, int h1, int h2) {
		try {
			
			try {
				Thread.sleep(12);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int[] intArray = {h0, h1, h2, 0, 0};
			
			log.trace("send stream: " + h0 + ", " + h1 + ", " + h2  + ", 0, 0");
			
			byte[] h = new byte[intArray.length];
			for(int i=0; i<intArray.length; i++){
				int nr = Integer.parseInt(Integer.toString(intArray[i]), 10);
				h[i] = (byte) nr;
			}
			
			super.sendStreamInt(h);

		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	/**
	 * 
	 */
	private void sendStream(String byte0, String byte1, String byte2) {

		int b0 = Integer.parseInt(byte0,16);
		int b1 = Integer.parseInt(byte1,16);
		int b2 = Integer.parseInt(byte2,16);
		
		this.sendStream(b0, b1, b2);
	}
	
	/**
	 * 
	 */
	public void sendStream(String s) {

		sendStream(s.substring(0, 2), s.substring(2, 4), s.substring(4, 6));
	}
}
