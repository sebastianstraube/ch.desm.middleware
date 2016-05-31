package sebastianstraube.connectx.module.desm;

import sebastianstraube.connectx.core.component.ComponentMapBase;
import sebastianstraube.connectx.module.desm.cabine.re420.map.Re420MapMiddleware;
import sebastianstraube.connectx.module.desm.interlocking.obermatt.map.OmMapMiddleware;
import sebastianstraube.connectx.module.desm.petrinet.obermatt.map.PetrinetOmMapMiddleware;
import sebastianstraube.connectx.module.desm.petrinet.re420.map.PetrinetRe420MapMiddleware;
import sebastianstraube.connectx.module.desm.simulation.zusi.map.ZusiMapAusbildungMiddleware;
import sebastianstraube.connectx.module.desm.simulation.zusi.map.ZusiMapFahrpultMiddleware;

public class DesmServiceMapMiddleware extends ComponentMapBase {

	@Override
	protected void init(){
        //petrinet re420
        map.putAll(new PetrinetRe420MapMiddleware().getMap());

        // TODO
        //petrinet re420 - zusi
//        map.putAll(new PetrinetRe420MapZusiFahrpult().getMap());

        //petrinet re420 - cabine
//      map.putAll(new PetrinetRe420MapCabineRe420().getMap());

        //petrinet re420 - om
//        map.putAll(new PetrinetRe420MapInterlockingOm().getMap());


        //interlocking Obermatt - middleware
        map.putAll(new OmMapMiddleware().getMap());


        //petrinet Obermat - middleware
        map.putAll(new PetrinetOmMapMiddleware().getMap());


        //cabine Re420 - middleware
        map.putAll(new Re420MapMiddleware().getMap());



        //Zusi Fahrpult
        map.putAll(new ZusiMapFahrpultMiddleware().getMap());

        //Zusi Ausbildung
        map.putAll(new ZusiMapAusbildungMiddleware().getMap());

        //Zusi Petrinet re420
//        map.putAll(new ZusiMapPetrinetRe420().getMap());

        //Zusi Petrinet re420
  //      map.putAll(new ZusiMapCabineRe420().getMap());


        //TODO put management map into this map
        //management Gui - middleware
        //map.putAll(new ManagementMapMiddleware().getMap());
    }
}
