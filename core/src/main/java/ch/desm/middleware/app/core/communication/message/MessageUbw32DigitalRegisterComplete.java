package ch.desm.middleware.app.core.communication.message;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.ubw32.EndpointUbw32RegisterDigital;

import java.util.*;

public class MessageUbw32DigitalRegisterComplete extends MessageUbw32Base {

	private static Logger LOGGER = Logger.getLogger(MessageUbw32DigitalRegisterComplete.class);
	
	private EndpointUbw32RegisterDigital portA;
	private EndpointUbw32RegisterDigital portB;
	private EndpointUbw32RegisterDigital portC;
	private EndpointUbw32RegisterDigital portD;
	private EndpointUbw32RegisterDigital portE;
	private EndpointUbw32RegisterDigital portF;
	private EndpointUbw32RegisterDigital portG;

    private Map<Character, EndpointUbw32RegisterDigital> portsByName = new HashMap<>();
    private Set<String> validSubPorts = new HashSet<>(Arrays.asList(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"));

	public MessageUbw32DigitalRegisterComplete(String payload, String topic) {
		super(payload, topic);

		this.parsePayload(payload);

        portsByName.put('A', portA);
        portsByName.put('B', portB);
        portsByName.put('C', portC);
        portsByName.put('D', portD);
        portsByName.put('E', portE);
        portsByName.put('F', portF);
        portsByName.put('G', portG);
	}

	/**
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

    /**
     * TODO: better return type
     */
	private String isInputOn(int pinBitMask, String pin) {
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
	 * TODO: better return type
	 */
	@Override
	public String getInputValue(String register, String pin) {
        Character portName = register.charAt(0);
        String subPortName = register.substring(1);
        EndpointUbw32RegisterDigital port = portsByName.get(portName);
        if (port == null || !validSubPorts.contains(subPortName)) {
            LOGGER.log(Level.ERROR, "invalid register: " + register);
            return "";
        }

        return isInputOn(port.getPinBitMask(), pin);
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
