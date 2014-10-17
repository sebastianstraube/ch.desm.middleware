package ch.desm.middleware.webapp.websocket;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import ch.desm.middleware.webapp.websocket.MessageWebsocket;

public class EndpointWebsocketMessageDecoder implements
		Decoder.Text<MessageWebsocket> {
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
		
		MessageWebsocket wsMessage = new MessageWebsocket(obj.getString("payload"), obj.getString("topic"));
	
		return wsMessage;
	}

	@Override
	public boolean willDecode(final String s) {
		return true;
	}
}
