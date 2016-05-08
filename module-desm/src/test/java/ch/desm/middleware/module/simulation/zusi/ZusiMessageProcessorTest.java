package ch.desm.middleware.module.simulation.zusi;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 19.04.2015.
 */
public class ZusiMessageProcessorTest extends ZusiMessageProcessor {

    private static Logger LOGGER = Logger.getLogger(ZusiMessageProcessorTest.class);

    /**
     *
     * @param service
     * @param message
     * @param topic
     */
    public void testProcessEndpointMessage(ZusiService service, String message, String topic){
        //processEndpointMessage(service, message, topic);
        processLogicParameter(service, "0200-0a00::1900", "655.8182");
    }


}
