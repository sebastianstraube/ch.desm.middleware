package ch.desm.middleware.module.simulation.zusi.message;

import ch.desm.middleware.module.simulation.zusi.protocol.ZusiProtocolMessageHelper;

/**
 * Created by Sebastian on 02.04.2015.
 */
public class ZusiProtocolStreamTest extends ZusiProtocolMessageHelper {

    public boolean testGetSingleZusiMessageIndex(String message, String compare){
        String tmpCmp = getSingleZusiMessage(message);
        return compare.equalsIgnoreCase(tmpCmp); //message.equalsIgnoreCase();
    }
}
