package ch.desm.middleware.core.communication.endpoint.websocket;

import org.apache.log4j.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;

public class EndpointWebsocketMessageDecoder implements	Decoder.Text<EndpointWebsocketMessage> {

	private static final Logger LOGGER = Logger.getLogger(EndpointWebsocketMessageDecoder.class);

	@Override
	public void init(final EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public EndpointWebsocketMessage decode(final String message) throws DecodeException {
		
		JsonObject obj = Json.createReader(new StringReader(message))
				.readObject();

        EndpointWebsocketMessage wsMessage = new EndpointWebsocketMessage(
                obj.getString("topic"),
                //obj.getString("globalId"),
                //obj.getString("externIntern"),
                //obj.getString("element"),
                //obj.getString("function"),
                //obj.getString("instance"),
                //obj.getString("parameter"),
                obj.getString("payload")
                //obj.getString("outputInput")
        );

		return wsMessage;
	}

	@Override
	public boolean willDecode(final String s) {
		return true;
	}
}
