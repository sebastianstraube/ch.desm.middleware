package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageWebsocket;
import ch.desm.middleware.app.core.communication.message.converter.MessageConverter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.*;
import java.io.IOException;

@ClientEndpoint(encoders = EndpointWebsocketMessageEncoder.class, decoders = EndpointWebsocketMessageDecoder.class)
public class ManagementEndpointWebsocketClient {

    private static final Logger LOGGER = Logger
            .getLogger(ManagementEndpointWebsocketClient.class);

    private static Session session;
    private EndpointWebsocketMessageEncoder encoder;
    private EndpointWebsocketMessageDecoder decoder;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        encoder = new EndpointWebsocketMessageEncoder();
        decoder = new EndpointWebsocketMessageDecoder();

        LOGGER.info("Websocket client is Connected with session: " + session.getId());
    }

    @OnMessage
    public String onMessage(String message, Session session) {

        LOGGER.info("EndpointWebsocketClient reveived: " + message);
        ManagementEndpoint.onIncomingEndpointMessage(message);
        return "";
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        LOGGER.info(String.format("Session %s close because of %s", session.getId(), closeReason));
        this.session = null;
    }

    public static void sendMessage(String message){
        LOGGER.info("EndpointWebsocketClient send: " + message);
        try {
            if(session != null){
                session.getBasicRemote().sendText(message);
            }else{
                throw new IllegalStateException("session is null");
            }
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
