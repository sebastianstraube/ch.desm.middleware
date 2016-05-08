package ch.desm.middleware.module.simulation.zusi;

import ch.desm.middleware.module.simulation.zusi.logic.ZusiLogicIsolierung;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 22.04.2015.
 */
public class ZusiEndpointLogic {

    /**
     *
     */
    public List<String> getIsoMwmFromParameter(ZusiService service, String globalId, String parameterValue){
        if(globalId.equalsIgnoreCase(ZusiLogicIsolierung.LOGIC_GLOBALID_GESAMTWEG)){
            int parameter = Float.valueOf(parameterValue).intValue();
            return service.getZusiLogicIsolierung().getAllIsoMwm(service, parameter);
        }

        return null;
    }

}
