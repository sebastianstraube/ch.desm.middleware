package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.LinkedList;

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
    public boolean testProcessEndpointMessage(ZusiService service, String message, String topic){
        processEndpointMessage(service, message, topic);
        return true;
    }
}
