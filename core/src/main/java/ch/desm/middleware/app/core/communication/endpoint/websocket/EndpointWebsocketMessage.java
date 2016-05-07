package ch.desm.middleware.app.core.communication.endpoint.websocket;

public class EndpointWebsocketMessage {

	private final String topic;
	private final String payload;

	public EndpointWebsocketMessage(String topic, String payload) {
		this.topic = topic;
		this.payload = payload;
	}

	public String getTopic() {
		return topic;
	}

	public String getPayload() {
		return payload;
	}
}
