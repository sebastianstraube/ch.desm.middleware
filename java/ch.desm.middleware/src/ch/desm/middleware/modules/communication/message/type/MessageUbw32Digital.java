package ch.desm.middleware.modules.communication.message.type;

import java.util.ArrayList;

import ch.desm.middleware.modules.communication.endpoint.serial.ubw32.EndpointUbw32PortDigital;
import ch.desm.middleware.modules.communication.endpoint.serial.ubw32.EndpointUbw32PortDigital.EnumEndpointUbw32PortDigital;
import ch.desm.middleware.modules.communication.endpoint.serial.ubw32.EndpointUbw32PortDigital.EnumEndpointUbw32RegisterDigital;

public class MessageUbw32Digital extends MessageUbw32Base {

	private ArrayList<EndpointUbw32PortDigital> list;

	public EndpointUbw32PortDigital portA;
	public EndpointUbw32PortDigital portB;
	public EndpointUbw32PortDigital portC;
	public EndpointUbw32PortDigital portD;
	public EndpointUbw32PortDigital portE;
	public EndpointUbw32PortDigital portF;
	public EndpointUbw32PortDigital portG;
	
	public MessageUbw32Digital(String payload, String topic) {
		super(payload, topic);

		this.list = new ArrayList<EndpointUbw32PortDigital>();

		payload = this.cleanPayload(payload);
		this.parsePayload(payload);
		this.initialize();
	}

	/**
	 * TODO implementation
	 * 
	 * @param payload
	 */
	protected void parsePayload(String payload) {
		String parts[] = payload.split(",");

		if (parts[0].equals("I")) {
			// input digital
			portA = new EndpointUbw32PortDigital(
					EnumEndpointUbw32PortDigital.A, parts[1]);
			portB = new EndpointUbw32PortDigital(
					EnumEndpointUbw32PortDigital.B, parts[2]);
			portC = new EndpointUbw32PortDigital(
					EnumEndpointUbw32PortDigital.C, parts[3]);
			portD = new EndpointUbw32PortDigital(
					EnumEndpointUbw32PortDigital.D, parts[4]);
			portE = new EndpointUbw32PortDigital(
					EnumEndpointUbw32PortDigital.E, parts[5]);
			portF = new EndpointUbw32PortDigital(
					EnumEndpointUbw32PortDigital.F, parts[6]);
			portG = new EndpointUbw32PortDigital(
					EnumEndpointUbw32PortDigital.G, parts[7]);	
		}
	}

	/**
	 * 
	 */
	@Override
	protected void initialize() {
		list.add(portA);
		list.add(portB);
		list.add(portC);
		list.add(portD);
		list.add(portE);
		list.add(portF);
		list.add(portG);
	}


	public boolean getInput(int pinBitMask, String pin) {
		String mask = "";
		for (int i = 15; i >= 0; i--) {
			mask = (pinBitMask & 1) + mask;
			pinBitMask = pinBitMask >>>= 1;
		}
		boolean isInputOn = mask.charAt(Integer.valueOf(pin)) == '1';

		return isInputOn;
	}
	

	public boolean getInputValue(EnumEndpointUbw32RegisterDigital register) {

		String pin = register.name().substring(1);
		
		boolean isInputOn = false;
	
		switch(register){
			case A0: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A1: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A2: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A3: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A4: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A5: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A6: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A7: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A8: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A9: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A10: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A11: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A12: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A13: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A14: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}	case A15: {isInputOn = getInput(portA.getPinBitMask(), pin); break;}
			case B0: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B1: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B2: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B3: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B4: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B5: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B6: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B7: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B8: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B9: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B10: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B11: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B12: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B13: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B14: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}	case B15: {isInputOn = getInput(portB.getPinBitMask(), pin); break;}
			case C0: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C1: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C2: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C3: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C4: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C5: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C6: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C7: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C8: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C9: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C10: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C11: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C12: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C13: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C14: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}	case C15: {isInputOn = getInput(portC.getPinBitMask(), pin); break;}
			case D0: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D1: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D2: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D3: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D4: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D5: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D6: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D7: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D8: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D9: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D10: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D11: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D12: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D13: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D14: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}	case D15: {isInputOn = getInput(portD.getPinBitMask(), pin); break;}
			case E0: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E1: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E2: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E3: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E4: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E5: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E6: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E7: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E8: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E9: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E10: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E11: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E12: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E13: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E14: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}	case E15: {isInputOn = getInput(portE.getPinBitMask(), pin); break;}
			case F0: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F1: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F2: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F3: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F4: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F5: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F6: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F7: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F8: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F9: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F10: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F11: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F12: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F13: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F14: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}	case F15: {isInputOn = getInput(portF.getPinBitMask(), pin); break;}
			case G0: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G1: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G2: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G3: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G4: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G5: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G6: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G7: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G8: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G9: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G10: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G11: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G12: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G13: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G14: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}	case G15: {isInputOn = getInput(portG.getPinBitMask(), pin); break;}
			default: System.err.println("register is not assignable: "+ register);
		}
	
		return isInputOn;
	}

	
	/**
	 * TODO implementation
	 */
	public String toString() {
		String s = super.toString();
		s += "digital message: ";
		s += "PortA: " + portA.getPinBitMask();
		s += ", ";
		s += "PortB: " + portB.getPinBitMask();
		s += ", ";
		s += "PortC: " + portC.getPinBitMask();
		s += ", ";
		s += "PortD: " + portD.getPinBitMask();
		s += ", ";
		s += "PortE: " + portE.getPinBitMask();
		s += ", ";
		s += "PortF: " + portF.getPinBitMask();
		s += ", ";
		s += "PortG: " + portG.getPinBitMask();
			
		return s;
	}
}
