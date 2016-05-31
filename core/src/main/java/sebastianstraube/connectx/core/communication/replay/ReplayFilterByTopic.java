package sebastianstraube.connectx.core.communication.replay;

import java.util.HashSet;
import java.util.Set;

public class ReplayFilterByTopic implements ReplayFilter {

    private Set<String> enabledTopics = new HashSet<>();
    private Set<String> disabledTopics = new HashSet<>();

    public void enableTopic(String topic) {
        enabledTopics.add(topic);
    }

    public void disableTopic(String topic) {
        disabledTopics.add(topic);
    }

    @Override
    public boolean isValidReplayEvent(ReplayEvent event) {
        final String topic = event.getTopic();
        if (disabledTopics.contains(topic)) {
            return false;
        }
        return enabledTopics.isEmpty() || enabledTopics.contains(topic);
    }
}
