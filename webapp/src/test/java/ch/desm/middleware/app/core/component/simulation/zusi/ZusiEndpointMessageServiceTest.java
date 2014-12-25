package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;


public class ZusiEndpointMessageServiceTest {

    private ZusiService service;

    public ZusiEndpointMessageServiceTest(){
        service = new ZusiService(Broker.getInstance(), "127.0.0.1", 4136);
    }

    @Test
    public void testEncodeMessage() throws Exception {
        String stream = service.getMessageService().getMessageStreamConnect();

        //get middleware messages
        LinkedList<String> middlewareMessage = service.getMessageService().convertToMiddlewareMessage(stream);
    }

    @Test
    public void testDecodeMessage() throws Exception {

    }

    @Test
    public void testEncodeDecode(){
        boolean result = service.getMessageService().testEncodeDecode();
        assertEquals("Testing encoding and decoding ... ", true, result);
    }
}