package ch.desm.middleware.app.core.communication.message.translator;

public class MalformedMessageException extends Exception {
    public MalformedMessageException(String msg, String rawMessage) {
        super(msg + " - " + rawMessage);
    }
}
