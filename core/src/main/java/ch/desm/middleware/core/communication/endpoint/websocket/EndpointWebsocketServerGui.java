package ch.desm.middleware.core.communication.endpoint.websocket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;

@ServerEndpoint(
        value = "/gui"
        /*,
        encoders = EndpointWebsocketMessageEncoder.class,
        decoders = EndpointWebsocketMessageDecoder.class,
        configurator = EndpointWebsocketServerConfigurator.class
        */
        )
public class EndpointWebsocketServerGui {
	
	private static final Logger LOGGER = Logger.getLogger(EndpointWebsocketServerGui.class);

    @OnOpen
    public void onOpen(Session session){
        LOGGER.log(Level.INFO, "Websocket ServerEndpoint connected with session:" + session);
    }

    @OnMessage
    public void onMessage(String message, Session session){
        LOGGER.log(Level.INFO, "Websocket ServerEndpoint got a message:" + message + " with session:" + session);
        if(message == null || message.isEmpty()) {
            LOGGER.log(Level.WARN, "ServerEndpoint message is empty: " + message);
            return;
        }

        try{
            Set<Session> sessions = session.getOpenSessions();
            for (Session element : sessions) {
                if(!element.equals(session)){
                    element.getBasicRemote().sendText(message);
                    LOGGER.log(Level.TRACE, "Websocket ServerEndpoint sent message: " + message +" to Websocket client" + element.getId()+")" );
                }
            }
        }catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }

    }

    @OnClose
    public void onClose(CloseReason reason, Session session){
        LOGGER.log(Level.INFO, "Websocket ServerEndpoint Closed: " + reason + " with session:" + session);
    }

    @OnError
    public void onError(Throwable cause, Session session){
        LOGGER.log(Level.INFO, "Websocket ServerEndpoint error: " + cause + " with session:" + session);
    }
}
