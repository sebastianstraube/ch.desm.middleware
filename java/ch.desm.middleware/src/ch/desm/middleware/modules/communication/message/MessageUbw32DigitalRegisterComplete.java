package ch.desm.middleware.modules.communication.message;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import ch.desm.middleware.modules.communication.endpoint.serial.ubw32.EndpointUbw32RegisterDigital;

public class MessageUbw32DigitalRegisterComplete extends MessageUbw32Base {

	private static Logger log = Logger.getLogger(MessageUbw32DigitalRegisterComplete.class);
	
	private ArrayList<EndpointUbw32RegisterDigital> list;

	public EndpointUbw32RegisterDigital portA;
	public EndpointUbw32RegisterDigital portB;
	public EndpointUbw32RegisterDigital portC;
	public EndpointUbw32RegisterDigital portD;
	public EndpointUbw32RegisterDigital portE;
	public EndpointUbw32RegisterDigital portF;
	public EndpointUbw32RegisterDigital portG;
	
	public MessageUbw32DigitalRegisterComplete(String payload, String topic) {
		super(payload, topic);

		this.list = new ArrayList<EndpointUbw32RegisterDigital>();
		list.add(portA);
		list.add(portB);
		list.add(portC);
		list.add(portD);
		list.add(portE);
		list.add(portF);
		list.add(portG);
		
		this.parsePayload(payload);
		
	}

	/**
	 * TODO implementation
	 * 
	 * @param payload
	 */
	protected void parsePayload(String payload) {
		
		String parts[] = payload.split(",");
		
		// input digital
		portA = new EndpointUbw32RegisterDigital(parts[1]);
		portB = new EndpointUbw32RegisterDigital(parts[2]);
		portC = new EndpointUbw32RegisterDigital(parts[3]);
		portD = new EndpointUbw32RegisterDigital(parts[4]);
		portE = new EndpointUbw32RegisterDigital(parts[5]);
		portF = new EndpointUbw32RegisterDigital(parts[6]);
		portG = new EndpointUbw32RegisterDigital(parts[7]);		
	}

	public String getInput(int pinBitMask, String pin) {
		String mask = "";
		for (int i = 15; i >= 0; i--) {
			mask = mask + (pinBitMask & 1) ;
			pinBitMask = pinBitMask >>> 1;
		}
		
		int value = Integer.valueOf(pin);
		String isInputOn =String.valueOf(mask.charAt(value));
		

		return isInputOn;
	}
		
	/**
	 * 
	 */
	@Override
	public String getInputValue(String register, String pin) {
		
		String isInputOn = "";

        if (register.equals("A0")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A1")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A2")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A3")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A4")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A5")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A6")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A7")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A8")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A9")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A10")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A11")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A12")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A13")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A14")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("A15")) {
            isInputOn = getInput(portA.getPinBitMask(), pin);
        } else if (register.equals("B0")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B1")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B2")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B3")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B4")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B5")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B6")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B7")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B8")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B9")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B10")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B11")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B12")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B13")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B14")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("B15")) {
            isInputOn = getInput(portB.getPinBitMask(), pin);
        } else if (register.equals("C0")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C1")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C2")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C3")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C4")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C5")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C6")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C7")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C8")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C9")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C10")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C11")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C12")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C13")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C14")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("C15")) {
            isInputOn = getInput(portC.getPinBitMask(), pin);
        } else if (register.equals("D0")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D1")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D2")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D3")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D4")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D5")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D6")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D7")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D8")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D9")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D10")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D11")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D12")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D13")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D14")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("D15")) {
            isInputOn = getInput(portD.getPinBitMask(), pin);
        } else if (register.equals("E0")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        }
        
//        remove blinking green LED on E1
        else if (register.equals("E1")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        }
        
        else if (register.equals("E2")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E3")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E4")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E5")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E6")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E7")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E8")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E9")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E10")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E11")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E12")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E13")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E14")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("E15")) {
            isInputOn = getInput(portE.getPinBitMask(), pin);
        } else if (register.equals("F0")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F1")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F2")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F3")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F4")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F5")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F6")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F7")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F8")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F9")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F10")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F11")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F12")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F13")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F14")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("F15")) {
            isInputOn = getInput(portF.getPinBitMask(), pin);
        } else if (register.equals("G0")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G1")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G2")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G3")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G4")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G5")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G6")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G7")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G8")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G9")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G10")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G11")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G12")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G13")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G14")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else if (register.equals("G15")) {
            isInputOn = getInput(portG.getPinBitMask(), pin);
        } else {
        		log.error("register is not assignable: " + register);
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