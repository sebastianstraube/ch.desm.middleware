package ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map;

import ch.desm.middleware.app.core.component.common.ComponentMapBase;

import java.util.Map;

public class PetrinetMapDelay extends ComponentMapBase{

	@Override
	public Map<String, String> getMap() {
		return map;
	}

	@Override
	protected void init(){
        map.put("OML_Stw_W1_T4", "5500");
        map.put("OML_Stw_W1_T6", "5500");
    }

}
