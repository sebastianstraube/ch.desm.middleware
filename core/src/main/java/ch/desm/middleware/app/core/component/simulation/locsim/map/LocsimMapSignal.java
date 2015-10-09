package ch.desm.middleware.app.core.component.simulation.locsim.map;

import java.util.Map;
import ch.desm.middleware.app.common.component.ComponentMapBase;


public class LocsimMapSignal extends ComponentMapBase {

	@Override
	public Map<String, String> getMap() {
		return map;
	}
	
	@Override
	protected void init(){
	}
}
