package ch.desm.middleware.module.desm.petrinet.obermatt.map;

import ch.desm.middleware.core.component.ComponentMapBase;

import java.util.Map;

public class PetrinetOmMapDelay extends ComponentMapBase{

	@Override
	protected void init(){
        map.put("OML_Stw_W1_T4", "5500");
        map.put("OML_Stw_W1_T6", "5500");
    }

}
