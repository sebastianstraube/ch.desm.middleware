package ch.desm.middleware.module.desm.petrinet.obermatt;

import ch.desm.middleware.core.communication.broker.Broker;
import ch.desm.middleware.core.communication.broker.MessageRecorderBrokerClient;
import ch.desm.middleware.core.communication.message.MessageCommon;
import ch.desm.middleware.core.communication.message.MessageCommonBuilder;
import ch.desm.middleware.core.communication.message.MessageCommonEncoder;
import ch.desm.middleware.core.communication.replay.Replay;
import ch.desm.middleware.core.communication.replay.ReplayEvent;
import ch.desm.middleware.core.communication.replay.ReplayFilterByTopic;
import ch.desm.middleware.module.desm.petrinet.obermatt.PetrinetOmService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class PetrinetOmTestBase {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmTestBase.class);

    public static final List<String> RECORDED_TOPICS = Arrays.asList(
            MessageCommon.MESSAGE_TOPIC_MANAGEMENT,
            MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT,
            MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT
    );

    protected Broker broker;
    protected PetrinetOmService service;
    protected MessageRecorderBrokerClient recorder;

    @Before
    public void setUpPetrinetOmTestBase() throws InterruptedException {
        broker = new Broker();
        service = new PetrinetOmService(broker);
        recorder = new MessageRecorderBrokerClient(broker, getTopicsForRecording());
    }

    // Overwrite if different recordings required
    protected List<String> getTopicsForRecording() {
        return RECORDED_TOPICS;
    }

    protected void runReplay(ReplayEvent event) {
        runReplay(Arrays.asList(event));
    }

    protected void runReplay(List<ReplayEvent> events) {
        final Replay replay = new Replay(events);
        final ReplayFilterByTopic filter = new ReplayFilterByTopic();
        filter.disableTopic(MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT); // in case we copy&paste one accidentally
        replay.run(broker, filter);
    }

    protected void clearRecordings() {
        recorder.clearRecordings();
    }

    protected boolean didRecordPetrinetTrigger(String trigger, Boolean state) {
        final String topic = MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT;
        final String expectedMessage = buildMessage(topic, trigger, state);
        final String triggerLowercase = trigger.toLowerCase();
        String foundTriggerButDifferentMessage = null;
        for (String recordedMessage : recorder.getRecordedMessages()) {
            if (recordedMessage.toLowerCase().startsWith(triggerLowercase)) {
                if (expectedMessage.equalsIgnoreCase(recordedMessage)) {
                    assertEquals(expectedMessage, recordedMessage);
                    return true;
                }
                foundTriggerButDifferentMessage = recordedMessage;

            }
        }

        // used to show the two different messages in the assertion log
        if (foundTriggerButDifferentMessage != null) {
            assertEquals(expectedMessage, foundTriggerButDifferentMessage);
        }

        return false;
    }

    private static String buildMessage(String topic, String triggerName, Boolean triggerState) {
        final MessageCommonBuilder builder = new MessageCommonBuilder();
        final MessageCommonEncoder encoder = new MessageCommonEncoder();
        try {
            return encoder.encode(builder
                    .setTopic(topic)
                    .setGlobalId(triggerName)
                    .setType(MessageCommon.ParameterType.BOOLEAN)
                    .setParameter(MessageCommon.mapBoolToOnOffParameter(triggerState))
                    .setOutputInput(MessageCommon.MESSAGE_CHAR_ONLYSOFTWARE)
                    .build());
        } catch (MessageCommonBuilder.MissingArgumentsException e) {
            LOGGER.log(Level.ERROR, e);
            return null;
        }
    }

    protected boolean didRecordMessage(String message) {
        return recorder.didRecordMessage(message);
    }

}
