package ch.desm.middleware.module.automation.machine;

import ch.desm.middleware.core.component.ComponentMapBase;
import ch.desm.middleware.module.automation.machine.map.MachineMapPetrinetCabineRe420;
import ch.desm.middleware.module.automation.machine.map.MachineMapUbw32Analog;
import ch.desm.middleware.module.automation.machine.map.MachineMapUbw32Digital;
import ch.desm.middleware.module.automation.machine.map.MachineMapZusiFahrpult;

public class MachineMapMiddleware extends ComponentMapBase {

	@Override
	protected void init(){
        //petrinet re420
        map.putAll(new MachineMapMiddleware().getMap());

        //interlocking Obermatt - middleware
        map.putAll(new MachineMapPetrinetCabineRe420().getMap());


        //petrinet Obermat - middleware
        map.putAll(new MachineMapUbw32Analog().getMap());


        //cabine Re420 - middleware
        map.putAll(new MachineMapUbw32Digital().getMap());



        //Zusi Fahrpult
        map.putAll(new MachineMapZusiFahrpult().getMap());
    }
}
