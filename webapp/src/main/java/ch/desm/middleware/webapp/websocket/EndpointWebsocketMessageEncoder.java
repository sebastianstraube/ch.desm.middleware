package ch.desm.middleware.webapp.websocket;

import javax.json.Json;
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
			
			return Json.createObjectBuilder()
					.add("payload", chatMessage.getPayload())
					.add("topic", chatMessage.getTopic()).build()
					.toString();
		}
}
