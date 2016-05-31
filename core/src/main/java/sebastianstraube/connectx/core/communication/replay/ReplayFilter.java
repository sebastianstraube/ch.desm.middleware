package sebastianstraube.connectx.core.communication.replay;

public interface ReplayFilter {
    boolean isValidReplayEvent(ReplayEvent event);
}
