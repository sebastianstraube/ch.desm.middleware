package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import org.junit.Test;

import java.util.LinkedList;

public class ZusiEndpointMessageServiceTest {


    @Test
    public void testEncodeMessage() throws Exception {

        ZusiService service = new ZusiService(Broker.getInstance(), "127.0.0.1", 4136);
        String stream = service.getMessageService().getMessageStreamConnect();

        //get middleware messages
        LinkedList<String> middlewareMessage = service.getMessageService().convertToMiddlewareMessage(stream);

    }

    @Test
    public void testDecodeMessage() throws Exception {

    }
}