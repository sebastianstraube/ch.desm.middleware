package ch.desm.middleware.app.core.communication.endpoint.websocket;

public class MessageWebsocket {

	public MessageWebsocket(String topic, String payload) {
        this.payload = payload;
        this.topic = topic;
	}

    String payload;
    public String getPayload(){
        return payload;
    }

    String topic;
    public String getTopic(){
        return topic;
    }

}
