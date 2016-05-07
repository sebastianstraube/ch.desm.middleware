package ch.desm.middleware.app.core.communication.replay;

public interface ReplayFilter {
    boolean isValidReplayEvent(ReplayEvent event);
}
