package ch.desm.middleware.app.core.communication.replay;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.broker.BrokerClient;

import java.util.ArrayList;
import java.util.List;

public class Replay {

    private final List<ReplayEvent> messages;

    public Replay(List<ReplayEvent> messages) {
        this.messages = messages;
    }

    public void run(Broker broker) {
        run(broker, new ReplayFilterAllowEverything());
    }

    public void run(Broker broker, ReplayFilter filter) {
        final ReplayBrokerClient brokerClient = new ReplayBrokerClient(broker);
        final List<ReplayEvent> q = new ArrayList<>(messages);
        final long startTs = System.currentTimeMillis();

        while(!q.isEmpty()) {
            final ReplayEvent tm = q.remove(0);
            if (!filter.isValidReplayEvent(tm)) {
                continue;
            }
            waitUntilOffset(startTs, tm.getOffset());
            brokerClient.publish(tm.getMessage(), tm.getTopic());
        }
    }

    private void waitUntilOffset(long startTs, long offset) {
        while(System.currentTimeMillis() - startTs < offset) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class ReplayBrokerClient extends BrokerClient {
        public ReplayBrokerClient(Broker broker) {
            super(broker);
        }

        @Override
        protected void initializeTopicSubscriptions() {}

        @Override
        protected void onIncomingBrokerMessage(String message) {}
    }

}
