package ch.desm.middleware.module.desm.test.petrinet.obermatt;

import ch.desm.middleware.core.communication.replay.ReplayEvent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PetrinetOmWeichenschalterTest extends PetrinetOmTestBaseWithInit {

    @Before
    public void setUp() {
        clearRecordings();
    }

    @Test
    public void shouldActivateSperrmagnetWhilePushed() throws InterruptedException {
        emulateStellwerkMessage("7.91.02;i;0;schalterkontakt;ws1;gedrückt;stellwerkobermattlangnau;b;on;");
        assertTrue(didRecordPetrinetTrigger("OML_Kontakte_$7_WS1_1", true));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_$endlage_plus", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_$keine_Endlage_plus", true));
        assertTrue(didRecordPetrinetTrigger("OML_Kontakte_$7_WS1_1", true));
        // TODO: why were they recorded in the production setup?
        //assertTrue(didRecordPetrinetTrigger("OML_logic_Kontakte_WS1_$ws1_plus", true));
        //assertTrue(didRecordPetrinetTrigger("OML_Kontakte_$6_RM_nLN", true));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_SM_$Sperrm_ein", true));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_SM_$Sperrm_aus", false));
        assertTrue(didRecordPetrinetTrigger("OML_Lampen_WS1_$1_WS1_Freig", true));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_SM_$Sperrm_ein", true));
        // will not be emitted as the ubw32 is not connected in this scenario
        //assertTrue(didRecordMessage("3.01.01;o;0;magnet;ws1;magnet;stellwerkobermattlangnau;b;on;"));

        emulateStellwerkMessage("7.91.02;i;0;schalterkontakt;ws1;gedrückt;stellwerkobermattlangnau;b;off;");
        assertTrue(didRecordPetrinetTrigger("OML_Kontakte_$7_WS1_1", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_SM_$Sperrm_ein", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_SM_$Sperrm_aus", true));
        assertTrue(didRecordPetrinetTrigger("OML_Kontakte_$7_WS1_1", false));
        assertTrue(didRecordPetrinetTrigger("OML_Lampen_WS1_$1_WS1_Freig", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_SM_$Sperrm_ein", false));
        // will not be emitted as the ubw32 is not connected in this scenario
        //assertTrue(didRecordMessage("3.01.01;o;0;magnet;ws1;magnet;stellwerkobermattlangnau;b;off;"));
    }

    private void emulateStellwerkMessage(String message) throws InterruptedException {
        clearRecordings();
        runReplay(new ReplayEvent(0, message));
        Thread.sleep(1000); // TODO: you know it already...
    }
}
