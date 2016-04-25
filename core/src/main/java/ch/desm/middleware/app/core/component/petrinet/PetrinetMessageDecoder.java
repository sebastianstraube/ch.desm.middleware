package ch.desm.middleware.app.core.component.petrinet;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;

public class PetrinetMessageDecoder implements
		Decoder.Text<Bucket> {
	//@Override
	public void init(final EndpointConfig config) {
	}

	//@Override
	public void destroy() {
	}

	//@Override
	public Bucket decode(final String message) throws DecodeException {
		
		JsonObject obj = Json.createReader(new StringReader(message))
				.readObject();

        Bucket place = new Bucket(
                obj.getString("name"),
                obj.getInt("value")
        );

		return place;
	}

	//@Override
	public boolean willDecode(final String s) {
		return true;
	}
}
