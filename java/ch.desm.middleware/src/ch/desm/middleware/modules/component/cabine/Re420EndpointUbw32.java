package ch.desm.middleware.modules.component.cabine;

import ch.desm.middleware.modules.communication.endpoint.serial.ubw32.EndpointUbw32;

public class Re420EndpointUbw32 extends EndpointUbw32{

	public Re420EndpointUbw32(EnumSerialPorts enumSerialPort) {
		super(enumSerialPort);
		// TODO Auto-generated constructor stub
	}

	public void setHaupthahn(String message){

		System.out.println("transmit setHaupthahn to : " + this.getClass());	
		this.sendCommand(message);
		
	}
}