package ch.desm.middleware.core.communication.replay;

public interface ReplayFilter {
    boolean isValidReplayEvent(ReplayEvent event);
}
