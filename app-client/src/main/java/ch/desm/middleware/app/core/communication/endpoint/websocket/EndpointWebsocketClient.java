package ch.desm.middleware.app.core.communication.endpoint.websocket;

import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@ClientEndpoint(encoders = EndpointWebsocketMessageEncoder.class, decoders = EndpointWebsocketMessageDecoder.class)
public class EndpointWebsocketClient {

    private static final Logger LOGGER = Logger
            .getLogger(EndpointWebsocketClient.class);

    @OnOpen
    public void onOpen(Session session) {
        LOGGER.info("Connected ... " + session.getId());
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        LOGGER.info("EndpointWebsocketClient reveived: " + message);

        return message;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        LOGGER.info(String.format("Session %s close because of %s", session.getId(), closeReason));
    }

    public void sendMessage(String message){
        LOGGER.info("EndpointWebsocketClient send: " + message);
    }
}
