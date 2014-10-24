package ch.desm.middleware.app.core.communication.endpoint.websocket;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.MessageWebsocket;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class EndpointWebsocketMessageEncoder implements Encoder.Text<MessageWebsocket> {
    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(final MessageWebsocket chatMessage) throws EncodeException {

        JsonObjectBuilder builder = Json.createObjectBuilder()
                .add("topic", chatMessage.getTopic())
                .add("payload", chatMessage.getPayload());

        return builder.build().toString();

    }
}
