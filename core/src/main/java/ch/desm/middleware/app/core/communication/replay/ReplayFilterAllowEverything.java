package ch.desm.middleware.app.core.communication.replay;

/**
 * does not filter any ReplayEvent
 * */
public class ReplayFilterAllowEverything implements ReplayFilter {

    @Override
    public boolean isValidReplayEvent(ReplayEvent event) {
        return true;
    }
}
