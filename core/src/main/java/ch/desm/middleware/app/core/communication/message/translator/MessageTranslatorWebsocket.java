package ch.desm.middleware.app.core.communication.message.translator;

import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.MessageWebsocket;

/**
 * Created by Sebastian on 23.10.2014.
 */
public class MessageTranslatorWebsocket {

    public MessageWebsocket toCharacterStream(MessageCommon message){
        return new MessageWebsocket(message.getTopic(), message.getPayload());
    }
}
