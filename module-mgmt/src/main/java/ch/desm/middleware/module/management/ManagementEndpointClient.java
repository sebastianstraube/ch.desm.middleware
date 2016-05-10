package ch.desm.middleware.module.management;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import javax.websocket.*;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;


/*      (
        encoders = EndpointWebsocketMessageEncoder.class,
        decoders = EndpointWebsocketMessageDecoder.class
        //,configurator = ManagementEndpointClientConfigurator.class
        )
*/
@ClientEndpoint
class ManagementEndpointClient {

    private static final Logger LOGGER = Logger.getLogger(ManagementEndpointClient.class);
    private final static ConcurrentLinkedQueue<Session> sessionSet = new ConcurrentLinkedQueue<>();
    //private final List<Map<String, Object>> propertiesList = new ArrayList<>();

    @OnMessage
    public void onMessage(String message, Session session) {
        LOGGER.log(Level.INFO, "ManagementEndpointClientWebsocket received message: " + message);
        ManagementEndpointThread.addMessages(message);
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.sessionSet.add(session);
        //this.propertiesList.add(config.getUserProperties());

        try {
            session.getBasicRemote().sendText("TEST");
        } catch (IOException e) {
            e.printStackTrace();
        }

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
