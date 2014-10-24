package ch.desm.middleware.app.core.communication.endpoint.websocket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


@ServerEndpoint(value = "/gui/{component}", encoders = EndpointWebsocketMessageEncoder.class, decoders = EndpointWebsocketMessageDecoder.class)
public class EndpointWebsocketServer {
	
	private static final Logger LOGGER = Logger
			.getLogger(EndpointWebsocketServer.class);

	/* Queue for all open WebSocket sessions */
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<>();

    @OnOpen
    public void onWebSocketConnect(Session sess)
    {
        LOGGER.log(Level.INFO, "Socket Connected: " + sess);
    }

    @OnMessage
    public void onWebSocketText(String message)
    {
        LOGGER.log(Level.INFO, "Received TEXT message: " + message);
    }

    @OnClose
    public void onWebSocketClose(CloseReason reason)
    {
        LOGGER.log(Level.INFO, "Socket Closed: " + reason);
    }

    @OnError
    public void onWebSocketError(Throwable cause)
    {
        LOGGER.log(Level.INFO, cause);
    }

	public static void sendMessage(String message) {
		try {
			/* Send messsage to all open WebSocket sessions */
			for (Session session : sessions) {
				session.getBasicRemote().sendText(message);
				LOGGER.log(Level.INFO, "Sent message: " + message +" to Websocket client" + session.getId()+")" );
			}
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, e);
		}
	}


}
