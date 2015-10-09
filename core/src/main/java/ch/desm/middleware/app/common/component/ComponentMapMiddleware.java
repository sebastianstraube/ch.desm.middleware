package ch.desm.middleware.app.common.component;

import ch.desm.middleware.app.core.component.cabine.re420.map.Re420MapMiddleware;
import ch.desm.middleware.app.core.component.interlocking.obermatt.map.OmMapMiddleware;
import ch.desm.middleware.app.core.component.mgmt.gui.map.ManagementMapMiddleware;
import ch.desm.middleware.app.core.component.petrinet.obermatt.map.PetrinetOmMapMiddleware;
import ch.desm.middleware.app.core.component.petrinet.re420.map.PetrinetRe420MapMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapAusbildungMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.map.ZusiMapFahrpultMiddleware;

import java.util.Map;

public class ComponentMapMiddleware extends ComponentMapBase {

	@Override
	public Map<String, String> getMap() {
		return map;
	}
	
	@Override
	protected void init(){
        //interlocking Obermatt
        map.putAll(new OmMapMiddleware().getMap());

        //petrinet re420
        map.putAll(new PetrinetRe420MapMiddleware().getMap());

        //petrinet Obermat
        map.putAll(new PetrinetOmMapMiddleware().getMap());

        //cabine Re420
        map.putAll(new Re420MapMiddleware().getMap());

        //management Gui
        map.putAll(new ManagementMapMiddleware().getMap());

        //Zusi Fahrpult
        map.putAll(new ZusiMapFahrpultMiddleware().getMap());

        //Zusi Ausbildung
        map.putAll(new ZusiMapAusbildungMiddleware().getMap());
    }
}
