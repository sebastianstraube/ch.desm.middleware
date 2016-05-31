package sebastianstraube.connectx.core.communication.replay;

import sebastianstraube.connectx.core.communication.message.MessageCommon;

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
        final String[] parts = message.split(MessageCommon.MESSAGE_ELEMENT_DELIMITER);
        return parts[MessageCommon.TOPIC];
    }

    public String getMessage() {
        return message;
    }
}
