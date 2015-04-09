package ch.desm.middleware.app.core.component.simulation.zusi.zusi.protocol;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolMessageHelper;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelperHex;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolMessageHelperTest extends ZusiProtocolMessageHelper {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolMessageHelper.class);

    /**
     *
     * @param message
     * @return
     */
    public boolean testGetSingleZusiMessage(String message, String cmp){
        String test = getSingleZusiMessage(message);
        return test.equalsIgnoreCase(cmp);
    }

    /**
     *
     * @param message
     * @return
     */
    public boolean testGetSingleZusiMessageIndex(String message){

        return false;
    }

    /**
     *
     * @param message
     * @return
     */
    private boolean testHasValidCharacteristic(String message){

        return false;
    }

    /**
     *
     * @param node
     * @param id
     * @return
     */
    private boolean testGetNodeLength(String node, String id){

        return false;
    }
}
