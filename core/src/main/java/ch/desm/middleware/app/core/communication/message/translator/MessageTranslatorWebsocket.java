package ch.desm.middleware.app.core.communication.message.translator;

import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessage;

/**
 * Created by Sebastian on 23.10.2014.
 */
public class MessageTranslatorWebsocket {

    public EndpointWebsocketMessage toCharacterStream(MessageCommon message){
        return new EndpointWebsocketMessage(message.getTopic(), message.getPayload());
    }
}
