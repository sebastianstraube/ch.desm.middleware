package ch.desm.middleware.app.module.simulation.zusi;

import ch.desm.middleware.app.module.simulation.zusi.logic.ZusiLogicIsolierung;

import java.util.ArrayList;

/**
 * Created by Sebastian on 22.04.2015.
 */
public class ZusiEndpointLogic {

    /**
     *
     */
    public ArrayList<String> getIsoMwmFromParameter(ZusiService service, String globalId, String parameterValue){
        ArrayList<String> l = new ArrayList<>();

        if(globalId.equalsIgnoreCase(ZusiLogicIsolierung.LOGIC_GLOBALID_GESAMTWEG)){
            int parameter = Float.valueOf(parameterValue).intValue();
            l = service.getZusiLogicIsolierung().getAllIsoMwm(service, parameter);
        }
        return l;
    }

}
