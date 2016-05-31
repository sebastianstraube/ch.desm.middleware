package sebastianstraube.connectx.module.desm.simulation.zusi.protocol;

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
