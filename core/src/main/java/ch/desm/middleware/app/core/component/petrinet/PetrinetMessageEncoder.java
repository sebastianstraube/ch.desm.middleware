package ch.desm.middleware.app.core.component.petrinet;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class PetrinetMessageEncoder implements Encoder.Text<Bucket> {
    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(final Bucket message) throws EncodeException {

        JsonObjectBuilder builder = Json.createObjectBuilder()
                .add("name", message.getName())
                .add("value", message.getTokenCount());

        return builder.build().toString();

    }
}
