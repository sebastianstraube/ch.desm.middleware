package ch.desm.middleware.core.communication.message.translator;

import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.communication.endpoint.websocket.EndpointWebsocketMessage;
import ch.desm.middleware.core.communication.message.MessageCommonEncoder;

/**
 * Created by Sebastian on 23.10.2014.
 */
public class MessageTranslatorWebsocket {

    private final MessageCommonEncoder encoder = new MessageCommonEncoder();

    public EndpointWebsocketMessage toCharacterStream(MessageCommon message){
        return new EndpointWebsocketMessage(message.getTopic(), encoder.encode(message));
    }
}
