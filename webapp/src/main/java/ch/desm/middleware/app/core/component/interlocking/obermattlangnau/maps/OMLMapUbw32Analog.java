package ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps;

import java.util.Map;

import ch.desm.middleware.app.core.component.ComponentMap;
import ch.desm.middleware.app.core.component.ComponentMapBase;

public class OMLMapUbw32Analog extends ComponentMap {

	//B0 = AN0, B1 = AN1
	//11bin = 3dez 
	//public static final String PINBITMASK_INPUT_ANALOG = "1";
    public static final String PINBITMASK_INPUT_ANALOG = "0";

    public OMLMapUbw32Analog(){
		super();
	}
	
	@Override
	public Map<String, String> getMap(){
		return this.map;
	}
	
	public void init(){
		
		map.put("8.91.01", "B0"); //FSS Grundstellung
		map.put("8.91.03", "B0"); //FSS 10° F 
		map.put("8.91.04", "B0"); //FSS 30° F 
		map.put("8.91.05", "B0"); //FSS 45° F 
		map.put("8.91.06", "B0"); //FSS 80° F 
		map.put("8.91.07", "B0"); //FSS 90° F 
		map.put("8.91.19", "B0"); //FSS 10° EG 
		map.put("8.91.20", "B0"); //FSS 30° EG 
		map.put("8.91.21", "B0"); //FSS 45° EG 
		map.put("8.91.22", "B0"); //FSS 80° EG 
		map.put("8.91.23", "B0"); //FSS 90° EG 		
	}
}
