package ch.desm.middleware.app.core.communication.message;


import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

public class MessageMiddleware extends MessageCommon {
	
	protected String outputInput;

	/**
	 * TODO: is this one needed?
     */
	public MessageMiddleware(MessageUbw32DigitalRegisterComplete message) {
		super(message);
	}

	/**
	 * TODO: is this one needed?
	 */
    public MessageMiddleware(MessageMiddleware message){
        this(message.getTopic(), message.getGlobalId(), message.getExternIntern(),
                message.getElement(), message.getFunction(), message.getInstance(), message.getParameter(),
                message.getPayload(), message.getOutputInput());
    }

	public MessageMiddleware(String topic, String globalId, String externIntern,
			String element, String function, String instance, String parameter,
			String payload, String outputInput) {
		super(topic, globalId, externIntern,
				element, function, instance, parameter,
				payload);
		
		this.outputInput = outputInput;
	}

	public String getOutputInput() {
		return this.outputInput;
	}

	public String toString() {
		String s = super.toString();
		s += ", ";
		s += "outputInput: " + outputInput;

		return s;
	}
}
