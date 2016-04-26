package ch.desm.middleware.app.core.communication.message;


public abstract class MessageUbw32Base extends MessageBase {

	public MessageUbw32Base(String payload, String topic){
		super(payload, topic);
	}
	
	public abstract String getInputValue(String register, String pin);
	
}
