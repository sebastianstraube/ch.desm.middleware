package ch.desm.middleware.app.core.communication.replay;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddlewareBase;

public class ReplayEvent {
    private final long offset; // in msec
    private final String message;

    public ReplayEvent(long offset, String message) {
        this.offset = offset;
        this.message = message;
    }

    public long getOffset() {
        return offset;
    }

    // TODO: is there a better way than splitting every time?
    public String getTopic() {
        final String[] parts = message.split(MessageBase.MESSAGE_ELEMENT_DELIMITER);
        return parts[MessageTranslatorMiddlewareBase.TOPIC];
    }

    public String getMessage() {
        return message;
    }
}