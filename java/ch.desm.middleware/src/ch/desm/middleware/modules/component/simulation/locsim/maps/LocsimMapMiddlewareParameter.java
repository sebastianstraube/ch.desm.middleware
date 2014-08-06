package ch.desm.middleware.modules.component.simulation.locsim.maps;

import java.util.Map;

import ch.desm.middleware.modules.component.ComponentMapBase;


public class LocsimMapMiddlewareParameter extends ComponentMapBase {
	
	@Override
	public Map<String, String> getMap() {
		return map;
	}
	
	@Override
	protected void initialize(){
		map.put("0000", "off");
		map.put("0001", "on");
	}

}