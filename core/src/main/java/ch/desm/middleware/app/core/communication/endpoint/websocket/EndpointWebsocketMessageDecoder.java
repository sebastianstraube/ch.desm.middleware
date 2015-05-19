package ch.desm.middleware.app.core.communication.endpoint.websocket;

import ch.desm.middleware.app.core.communication.message.MessageWebsocket;
import org.apache.log4j.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;

public class EndpointWebsocketMessageDecoder implements	Decoder.Text<MessageWebsocket> {

	private static final Logger LOGGER = Logger.getLogger(EndpointWebsocketMessageDecoder.class);

	@Override
	public void init(final EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public MessageWebsocket decode(final String message) throws DecodeException {
		
		JsonObject obj = Json.createReader(new StringReader(message))
				.readObject();

        MessageWebsocket wsMessage = new MessageWebsocket(
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
