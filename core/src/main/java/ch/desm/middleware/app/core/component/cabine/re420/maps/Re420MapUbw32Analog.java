package ch.desm.middleware.app.core.component.cabine.re420.maps;

import java.util.Map;

import ch.desm.middleware.app.common.ComponentMapBase;

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
	
	public boolean isValueAvailable(String id){
		return map.containsValue(id);
	}
	
	@Override
	public Map<String, String> getMap(){
		return this.map;
	}
	
	public void init(){
		map.put("a74", "D0"); //kV-Anzeige
		map.put("a79", "D1"); //A-Anzeige Motorenstrom
		map.put("a79.1", "D3"); //A-Anzeige Differenzstrom
		map.put("a94", "D2"); //Anzeige Vist
	}
}
