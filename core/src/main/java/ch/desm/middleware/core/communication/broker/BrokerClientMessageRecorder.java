package ch.desm.middleware.core.communication.broker;

import ch.desm.middleware.core.communication.broker.Broker;
import ch.desm.middleware.core.communication.broker.BrokerClient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrokerClientMessageRecorder extends BrokerClient {

    private final List<String> recordedMessages = new ArrayList<>();
    private final Set<String> recordedMessagesLowercase = new HashSet<>();

    public BrokerClientMessageRecorder(Broker broker, List<String> subscribedTopics) {
        super(broker);
        for (String topic : subscribedTopics) {
            subscribeToTopic(topic);
        }
    }

    public List<String> getRecordedMessages() {
        return recordedMessages;
    }

    public void clearRecordings() {
        recordedMessages.clear();
        recordedMessagesLowercase.clear();
    }

    public boolean didRecordMessage(String message) {
        return recordedMessagesLowercase.contains(message.toLowerCase());
    }

    @Override
    protected void initializeTopicSubscriptions() {
        // gets called during `super()` call unfortunately
    }

    @Override
    protected void onIncomingBrokerMessage(String message) {
        recordedMessages.add(message);
        recordedMessagesLowercase.add(message.toLowerCase());
    }

}