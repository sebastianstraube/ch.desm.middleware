package ch.desm.middleware.modules.component.cabine.re420.maps;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import ch.desm.middleware.modules.component.ComponentMapBase;
import ch.desm.middleware.modules.component.simulation.locsim.LocsimBaseImpl;

public class Re420MapBinding extends ComponentMapBase  {

	private static Logger log = Logger.getLogger(LocsimBaseImpl.class);
	
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
	
	@Override
	protected void initialize() {
		
		map.put("s182.3", "l182.3"); //Türfreigabe links
		map.put("s182.4", "l182.4"); //Türfreigabe rechts
		map.put("s182", "l185"); //Türverriegelung
	}

}
