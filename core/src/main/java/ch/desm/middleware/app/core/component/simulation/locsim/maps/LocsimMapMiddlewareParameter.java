package ch.desm.middleware.app.core.component.simulation.locsim.maps;

import java.util.Map;

import ch.desm.middleware.app.common.ComponentMapBase;


public class LocsimMapMiddlewareParameter extends ComponentMapBase {
	
	@Override
	public Map<String, String> getMap() {
		return map;
	}
	
	@Override
	protected void init(){
		map.put("0000", "off");
		map.put("0001", "on");
	}

}
