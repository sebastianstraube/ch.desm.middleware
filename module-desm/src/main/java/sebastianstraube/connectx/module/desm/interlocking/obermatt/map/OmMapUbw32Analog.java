package sebastianstraube.connectx.module.desm.interlocking.obermatt.map;

import java.util.Map;

import sebastianstraube.connectx.core.component.ComponentMapBase;

public class OmMapUbw32Analog extends ComponentMapBase {

    public static final String PINBITMASK_INPUT_ANALOG = "1";

    public OmMapUbw32Analog(){
		super();
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
