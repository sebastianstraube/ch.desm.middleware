package sebastianstraube.connectx.core.module.websocket.client;

import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketMessageEncoder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import javax.websocket.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@ClientEndpoint(
        encoders = EndpointWebsocketMessageEncoder.class,
        decoders = EndpointWebsocketMessageDecoder.class ,
        configurator = WebsocketClientEndpointConfigurator.class)
public class WebsocketClientEndpoint {

    private static final Logger LOGGER = Logger.getLogger(WebsocketClientEndpoint.class);
    private final static ConcurrentLinkedQueue<Session> sessionSet = new ConcurrentLinkedQueue<>();
    private Map<String, Object> properties;

    @OnMessage
    public void onMessage(String message, Session session) {
        LOGGER.log(Level.INFO, "ManagementEndpointClientWebsocket received message: " + message);
        WebsocketClientEndpointThread.addMessages(message);
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.sessionSet.add(session);
        this.properties = new HashMap<String, Object>(config.getUserProperties());
        LOGGER.log(Level.TRACE, "ManagementEndpointClientWebsocket is Connected with session: " + session.getId());
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        //delete session
        for(Session element : sessionSet){
            if(element.equals(session)){
                sessionSet.remove(element);
                LOGGER.log(Level.INFO, String.format("ManagementEndpointClientWebsocket Session %s closed because of %s.", session.getId(), closeReason));
            }
        }
    }

    @OnError
    public void onWebSocketError(Throwable cause, Session session){
        LOGGER.log(Level.INFO, "ManagementEndpointClientWebsocket error: " + cause + " with session:" + session);
    }

    public static void sendMessage(String message){
        LOGGER.log(Level.TRACE, "ManagementEndpointClientWebsocket send: " + message);
        try {
            for(Session session : sessionSet)
                if(session != null){
                    session.getBasicRemote().sendText(message);
                }else{
                    throw new RuntimeException("session is null");
                }
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
