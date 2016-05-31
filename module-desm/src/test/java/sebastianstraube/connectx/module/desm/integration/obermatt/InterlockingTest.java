package sebastianstraube.connectx.module.desm.integration.obermatt;


import sebastianstraube.connectx.core.communication.broker.Broker;
import sebastianstraube.connectx.core.communication.endpoint.ubw32.EndpointUbw32MessageHandler;
import sebastianstraube.connectx.core.communication.replay.Replay;
import sebastianstraube.connectx.core.communication.replay.ReplayEvent;
import sebastianstraube.connectx.module.desm.DesmServiceConfig;
import sebastianstraube.connectx.module.desm.interlocking.obermatt.OmService;
import sebastianstraube.connectx.module.desm.petrinet.obermatt.PetrinetOmService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InterlockingTest {

    public static final List<ReplayEvent> INIT_REPLAY_EVENTS = Arrays.asList(
            new ReplayEvent(0000, "management.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;management;S;init;#"),
            new ReplayEvent(1000, "management.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;management;S;init;#"),
            new ReplayEvent(5000, "management.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;management;S;start;#"),
            new ReplayEvent(8000, "management.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;management;S;start;#")
    );

    private Broker broker;
    private OmService ubw32OmService;
    private PetrinetOmService petrinetOmService;

    @Before
    public void setUp() throws InterruptedException {
        final DesmServiceConfig config = new DesmServiceConfig();
        broker = new Broker();
        ubw32OmService = new OmService(broker, config.getObermattUbw32ComPort());
        petrinetOmService = new PetrinetOmService(broker);
        Thread.sleep(1000);
        new Replay(INIT_REPLAY_EVENTS).run(broker);
        Thread.sleep(2000);
    }

    @Test
    public void shouldTriggerF4FastEnought() throws InterruptedException {
        final EndpointUbw32MessageHandler handler = ubw32OmService.getEndpoint().getHandler();
        final String command = "PI,D,11";
        final String maskOn =  "PI,1";
        final String maskOff = "PI,1";
        for(int i = 0; i < 20; ++i) {
            handler.processCommandResponse(command, maskOn);
            Thread.sleep(10);
            handler.processCommandResponse(command, maskOff);
            Thread.sleep(10);
        }
        Thread.sleep(2000);
    }
}
