package ch.desm.middleware.app.core.component;

import ch.desm.middleware.app.module.re420.map.Re420MapMiddleware;
import ch.desm.middleware.app.module.obermatt.map.OmMapMiddleware;
import ch.desm.middleware.app.module.gui.map.ManagementMapMiddleware;
import ch.desm.middleware.app.module.petrinet.obermatt.map.PetrinetOmMapMiddleware;
import ch.desm.middleware.app.module.petrinet.re420.map.PetrinetRe420MapMiddleware;
import ch.desm.middleware.app.module.simulation.zusi.map.ZusiMapAusbildungMiddleware;
import ch.desm.middleware.app.module.simulation.zusi.map.ZusiMapFahrpultMiddleware;

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
