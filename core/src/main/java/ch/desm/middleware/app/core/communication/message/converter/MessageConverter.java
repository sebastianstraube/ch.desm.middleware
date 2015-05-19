package ch.desm.middleware.app.core.communication.message.converter;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.MessageWebsocket;

/**
 * Created by Sebastian on 23.10.2014.
 */
public class MessageConverter {

    public MessageWebsocket toCharacterStream(MessageMiddleware message){
        return new MessageWebsocket(message.getTopic(), message.getPayload());
    }
}
