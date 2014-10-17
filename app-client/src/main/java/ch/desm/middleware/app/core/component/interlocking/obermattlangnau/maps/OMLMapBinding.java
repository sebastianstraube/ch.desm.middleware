package ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps;

import java.util.Map;

import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.component.ComponentMapBase;
import ch.desm.middleware.app.core.component.simulation.locsim.Locsim;

public class OMLMapBinding extends ComponentMapBase  {

	private static Logger LOGGER = Logger.getLogger(Locsim.class);
	
	@Override
	public Map<String, String> getMap() {
		return this.map;
	}
	
	public boolean isKeyAvailable(String id){
		return map.containsKey(id);
	}
	
	public boolean isValueAvailable(String id){
		return map.containsValue(id);
	}
	
	/**
	 * binding is needed to set a function directly in the component
	 */
	@Override
	protected void initialize() {
		//TODO
	}

}
