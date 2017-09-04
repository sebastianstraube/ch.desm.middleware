package sebastianstraube.connectx.module.desm.simulation.zusi;

import sebastianstraube.connectx.module.desm.simulation.zusi.logic.ZusiLogicIsolierung;

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
