package ch.desm.middleware.app.core.component.mgmt.gui;

import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@ClientEndpoint(encoders = EndpointWebsocketMessageEncoder.class, decoders = EndpointWebsocketMessageDecoder.class)
public class ManagementEndpointClientWebsocket {

    private static final Logger LOGGER = Logger.getLogger(ManagementEndpointClientWebsocket.class);

    private final static Set<Session> sessionSet = new HashSet<Session>();
    private static Object sessionLock = new Object();

    @OnMessage
    public void onMessage(String message, Session session) {
        LOGGER.log(Level.INFO, "EndpointWebsocketClient received: " + message);
        ManagementEndpointThread.addMessages(message);
    }

    @OnOpen
    public void onOpen(Session session) {
        this.sessionSet.add(session);
        LOGGER.log(Level.TRACE, "Websocket client is Connected with session: " + session.getId());
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        //delete session
        HashSet<Session> SessionSetCopy = new HashSet<Session>(sessionSet);
        for(Session element : sessionSet){
            if(element.equals(session)){
                sessionSet.remove(element);
                LOGGER.log(Level.INFO, String.format("Session %s closed because of %s.", session.getId(), closeReason));
            }
        }
    }


    public static void sendMessage(String message){
        synchronized (sessionLock){
            LOGGER.log(Level.TRACE, "EndpointWebsocketClient send: " + message);
            try {
                for(Session session : sessionSet)
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
}
