package ch.desm.middleware.component.petrinet.obermattlangnau.map;

import java.util.Map;

import org.apache.log4j.Logger;

import ch.desm.middleware.component.ComponentMapBase;
import ch.desm.middleware.component.simulation.locsim.Locsim;

public class OMLMapBinding extends ComponentMapBase  {

	private static Logger log = Logger.getLogger(Locsim.class);
	
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
