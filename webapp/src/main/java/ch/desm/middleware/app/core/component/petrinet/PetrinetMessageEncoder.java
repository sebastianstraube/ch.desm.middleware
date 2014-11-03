package ch.desm.middleware.app.core.component.petrinet;

import ch.desm.middleware.app.core.communication.message.MessageWebsocket;
import ch.desm.middleware.app.core.utility.Pair;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class PetrinetMessageEncoder implements Encoder.Text<Pair<String, Integer>> {
    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(final Pair<String, Integer> message) throws EncodeException {

        JsonObjectBuilder builder = Json.createObjectBuilder()
                .add("name", message.getLeft())
                .add("value", message.getRight());

        return builder.build().toString();

    }
}
