package ch.desm.middleware.app.core.communication.message.translator;


public abstract class MessageTranslatorRs232Base extends MessageTranslatorMiddlewareBase {
	
	public abstract String translateToCommonMiddlewareMessage(String payload, String topic);

}
