package sebastianstraube.connectx.module.desm.simulation.zusi.map;

import sebastianstraube.connectx.core.component.ComponentMapBase;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.ZusiProtocolConstants;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapParameter extends ComponentMapBase {

    @Override
    protected void init(){
        map.put("0200-0a00::0100", ZusiProtocolConstants.MAP_PARAMETER_VALUE_GESCHWINDIGKEIT);
    }

}
