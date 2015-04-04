package ch.desm.middleware.app.core.component.simulation.zusi.zusi.message;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolMessageProcessor;

/**
 * Created by Sebastian on 02.04.2015.
 */
public class ZusiProtocolMessageProcessorTest extends ZusiProtocolMessageProcessor {

    public boolean testGetSingleZusiMessageIndex(String message, String compare){
        String tmpCmp = extractSingleZusiMessage(message);
        return compare.equalsIgnoreCase(tmpCmp); //message.equalsIgnoreCase();
    }
}
