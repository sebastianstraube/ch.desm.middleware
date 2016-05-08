package ch.desm.middleware.core.communication.endpoint.websocket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@javax.websocket.server.ServerEndpoint(value = "/echo")
public class EndpointWebsocketServerEcho {

    private static final Logger LOGGER = Logger.getLogger(EndpointWebsocketServerEcho.class);

    @OnOpen
    public void onOpen(Session session) {
        LOGGER.log(Level.INFO, "opened Session: " + session.getId() + "; sub protocol:" + session.getNegotiatedSubprotocol() + "; protocol version:" + session.getProtocolVersion());
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        LOGGER.log(Level.INFO, "received message: " + message);
        return "SERVER ECHO >> " + message;
    }

    @OnError
    public void onError(Throwable t){
        LOGGER.log(Level.INFO, "websocket error: " + t);
    }

    /*
     *   TODO Implementation
     *   stay alive: server send ping and all clients send a pong
     */
    public void sendPing(){

    }
}