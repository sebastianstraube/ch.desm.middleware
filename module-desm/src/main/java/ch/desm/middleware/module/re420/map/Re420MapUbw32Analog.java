package ch.desm.middleware.module.re420.map;

import java.util.Map;

import ch.desm.middleware.core.component.ComponentMapBase;

public class Re420MapUbw32Analog extends ComponentMapBase {

	//B0 = AN0, B1 = AN1
	//11bin = 3dez 
	public static final String PINBITMASK_INPUT_ANALOG = "3";
	
	public Re420MapUbw32Analog(){
		super();
	}
		
	public boolean isKeyAvailable(String id){
		return map.containsKey(id);
	}

	public void init(){
		/* TODO: fix me!
		map.put("a74", "D0"); //kV-Anzeige
		map.put("a79", "D1"); //A-Anzeige Motorenstrom
		map.put("a79.1", "D3"); //A-Anzeige Differenzstrom
		map.put("a94", "D2"); //Anzeige Vist
		*/
	}
}
