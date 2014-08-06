package ch.desm.middleware.modules.component.cabine.re420.maps;

import java.util.Map;

import ch.desm.middleware.modules.component.ComponentMapBase;

public class Re420MapFabischAnalog extends ComponentMapBase {

	public Re420MapFabischAnalog(){
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
	
	public void initialize(){
//		map.put("a74","1ce8");//kV-Anzeige
//		map.put("a79","1edc");//A-Anzeige Motorenstrom
//		map.put("a79.1","1ee6");//A-Anzeige Differenzstrom
//		map.put("d94vi.1","24e0");//Vist-LZB.1



	}
}
