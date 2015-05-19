package ch.desm.middleware.app.core.communication.message;



public class MessageWebsocket extends MessageBase {

	public MessageWebsocket(String topic, String payload) {
		super(payload, topic);
	}	

}
