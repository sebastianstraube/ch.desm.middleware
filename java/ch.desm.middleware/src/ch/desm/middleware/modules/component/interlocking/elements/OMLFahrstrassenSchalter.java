package ch.desm.middleware.modules.component.interlocking.elements;

import ch.desm.middleware.modules.communication.endpoint.serial.ubw32.EndpointUbw32PortAnalog.EnumEndpointUbw32RegisterAnalog;

public class OMLFahrstrassenSchalter {

	/**
	 * TODO implementation for multi messaging analog
	 * @param register
	 */
	public String getGlobalIdFSS(EnumEndpointUbw32RegisterAnalog register, int value){
		
		String globalId = "";
		
		//Quelle: Verdrahtungsliste - Analog Input Definition
		switch(register){
			case AN0: 	if(value > 235 && value < 246){globalId = "8.91.07";} else //FSS 90� F
						if(value > 296 && value < 308){globalId = "8.91.06";} else //FSS 80� F
						if(value > 349 && value < 362){globalId = "8.91.05";} else //FSS 45� F
						if(value > 390 && value < 402){globalId = "8.91.04";} else //FSS 30� F
						if(value > 417 && value < 429){globalId = "8.91.03";} else //FSS 10� F
						if(value > 461 && value < 474){globalId = "8.91.01";} else //FSS Grundstellung
						if(value > 496 && value < 513){globalId = "8.91.19";} else //FSS 10� EG
						if(value > 522 && value < 534){globalId = "8.91.20";} else //FSS 30� EG
						if(value > 570 && value < 582){globalId = "8.91.21";} else //FSS 45� EG
						if(value > 637 && value < 654){globalId = "8.91.22";} else //FSS 80� EG
						if(value > 667 && value < 682){globalId = "8.91.23";} else //FSS 90� EG 
						{
							System.out.println("the register " + register.name() + " has no mapped value: " + value);
						}
			default: System.err.println("no mapping defined for analog register:" + register.name());
		}
		
		return globalId;
	}
	
}
