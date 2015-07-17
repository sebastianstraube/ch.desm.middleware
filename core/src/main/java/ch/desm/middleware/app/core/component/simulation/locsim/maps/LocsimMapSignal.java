package ch.desm.middleware.app.core.component.simulation.locsim.maps;

import java.util.Map;

import ch.desm.middleware.app.core.component.ComponentMapBase;


public class LocsimMapSignal extends ComponentMapBase{

	@Override
	public Map<String, String> getMap() {
		return map;
	}
	
	@Override
	protected void init(){
	}
}
