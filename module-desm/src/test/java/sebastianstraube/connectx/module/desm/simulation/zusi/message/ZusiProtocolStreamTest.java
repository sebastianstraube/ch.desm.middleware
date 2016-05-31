package sebastianstraube.connectx.module.desm.simulation.zusi.message;

import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.ZusiProtocolMessageHelper;

/**
 * Created by Sebastian on 02.04.2015.
 */
public class ZusiProtocolStreamTest extends ZusiProtocolMessageHelper {

    public boolean testGetSingleZusiMessageIndex(String message, String compare){
        String tmpCmp = getSingleZusiMessage(message);
        return compare.equalsIgnoreCase(tmpCmp); //message.equalsIgnoreCase();
    }
}
