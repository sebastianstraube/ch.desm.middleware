package ch.desm.middleware.app.core.communication.message;

import java.util.LinkedList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.ubw32.EndpointUbw32RegisterDigital;

public class MessageUbw32DigitalRegisterComplete extends MessageUbw32Base {

	private static Logger LOGGER = Logger.getLogger(MessageUbw32DigitalRegisterComplete.class);
	
	private LinkedList<EndpointUbw32RegisterDigital> list;

	public EndpointUbw32RegisterDigital portA;
	public EndpointUbw32RegisterDigital portB;
	public EndpointUbw32RegisterDigital portC;
	public EndpointUbw32RegisterDigital portD;
	public EndpointUbw32RegisterDigital portE;
	public EndpointUbw32RegisterDigital portF;
	public EndpointUbw32RegisterDigital portG;
	
	public MessageUbw32DigitalRegisterComplete(String payload, String topic) {
		super(payload, topic);

		this.list = new LinkedList<EndpointUbw32RegisterDigital>();
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

	public String isInpuOn(int pinBitMask, String pin) {
		String mask = "";
		for (int i = 15; i >= 0; i--) {
			mask = mask + (pinBitMask & 1) ;
			pinBitMask = pinBitMask >>> 1;
		}
		
		int place = Integer.valueOf(pin);
		String isInputOn = String.valueOf(mask.charAt(place));
		

		return isInputOn;
	}
		
	/**
	 * 
	 */
	@Override
	public String getInputValue(String register, String pin) {
		
		String isInputOn = "";

        if (register.equals("A0")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A1")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A2")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A3")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A4")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A5")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A6")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A7")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A8")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A9")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A10")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A11")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A12")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A13")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A14")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("A15")) {
            isInputOn = isInpuOn(portA.getPinBitMask(), pin);
        } else if (register.equals("B0")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B1")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B2")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B3")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B4")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B5")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B6")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B7")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B8")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B9")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B10")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B11")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B12")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B13")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B14")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("B15")) {
            isInputOn = isInpuOn(portB.getPinBitMask(), pin);
        } else if (register.equals("C0")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C1")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C2")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C3")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C4")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C5")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C6")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C7")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C8")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C9")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C10")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C11")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C12")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C13")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C14")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("C15")) {
            isInputOn = isInpuOn(portC.getPinBitMask(), pin);
        } else if (register.equals("D0")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D1")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D2")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D3")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D4")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D5")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D6")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D7")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D8")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D9")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D10")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D11")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D12")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D13")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D14")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("D15")) {
            isInputOn = isInpuOn(portD.getPinBitMask(), pin);
        } else if (register.equals("E0")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E1")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E2")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E3")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E4")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E5")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E6")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E7")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E8")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E9")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E10")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E11")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E12")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E13")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E14")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("E15")) {
            isInputOn = isInpuOn(portE.getPinBitMask(), pin);
        } else if (register.equals("F0")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F1")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F2")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F3")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F4")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F5")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F6")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F7")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F8")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F9")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F10")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F11")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F12")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F13")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F14")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("F15")) {
            isInputOn = isInpuOn(portF.getPinBitMask(), pin);
        } else if (register.equals("G0")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G1")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G2")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G3")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G4")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G5")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G6")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G7")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G8")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G9")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G10")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G11")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G12")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G13")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G14")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else if (register.equals("G15")) {
            isInputOn = isInpuOn(portG.getPinBitMask(), pin);
        } else {
            try {
                if (isInputOn.equals("")) {
                    throw new IllegalStateException("invalid register: " + register);
                }
            } catch(IllegalStateException e){
                LOGGER.log(Level.ERROR, e);
            }
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
