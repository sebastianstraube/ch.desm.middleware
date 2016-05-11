package ch.desm.middleware.module.management.web;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;

/**
 * Created by Sebastian on 19.05.2015.
 */
@ClientEndpoint
public class TyrusClientAnnotated {

    @OnOpen
    public void onOpen(Session session) {
        try {
            String message = "Das ist eine Test message.";
            System.out.println("Sending message to server endpoint: " + message);
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("receiving message: " + message);
    }
}