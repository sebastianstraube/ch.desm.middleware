package ch.desm.middleware.app.core.communication.endpoint.websocket;

import org.apache.log4j.Logger;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class EndpointWebsocketMessageEncoder implements Encoder.Text<EndpointWebsocketMessage> {

    private static final Logger LOGGER = Logger.getLogger(EndpointWebsocketMessageEncoder.class);

    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(final EndpointWebsocketMessage message) throws EncodeException {

        JsonObjectBuilder builder = Json.createObjectBuilder()
                .add("topic", message.getTopic())
                .add("payload", message.getPayload());

        return builder.build().toString();

    }
}
