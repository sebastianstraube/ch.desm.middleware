package ch.desm.middleware.module.desm.petrinet.obermatt;

import ch.desm.middleware.core.communication.replay.ReplayEvent;
import org.apache.log4j.Logger;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

public abstract class PetrinetOmTestBaseWithInit extends PetrinetOmTestBase {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmTestBaseWithInit.class);

    public static final List<ReplayEvent> INIT_REPLAY_EVENTS = Arrays.asList(
            new ReplayEvent(0, "mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;management;S;init;#"),
            new ReplayEvent(0, "mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;management;S;start;#")
    );

    @Before
    public void setUpPetrinetOmTestBaseWithInit() throws InterruptedException {
        runReplay(INIT_REPLAY_EVENTS);
        Thread.sleep(2000); // TODO: find better way to detect whether petrinet is stable and has no pending messages
    }
}
