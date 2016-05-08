package ch.desm.middleware.module.simulation.zusi.map;

import ch.desm.middleware.core.component.ComponentMapBase;
import ch.desm.middleware.module.simulation.zusi.protocol.ZusiProtocolConstants;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapParameter extends ComponentMapBase {

    @Override
    protected void init(){
        map.put("0200-0a00::0100", ZusiProtocolConstants.MAP_PARAMETER_VALUE_GESCHWINDIGKEIT);
    }

}
