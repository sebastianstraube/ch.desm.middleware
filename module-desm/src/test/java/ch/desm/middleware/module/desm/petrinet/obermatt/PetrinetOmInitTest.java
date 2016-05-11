package ch.desm.middleware.module.desm.petrinet.obermatt;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PetrinetOmInitTest extends PetrinetOmTestBaseWithInit {

    @Test
    public void shouldResetWeichenschalterDuringInitialization() {
        assertTrue(didRecordPetrinetTrigger("OML_Lampen_WS1_$1_WS1_Freig", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_$keine_Endlage_minus", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_SM_$Sperrm_ein", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_$gestoert_m", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_$endlage_plus", true));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_$gestoert_p", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_$keine_Endlage_plus", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_$endlage_minus", false));
        assertTrue(didRecordPetrinetTrigger("OML_Stw_WS1_SM_$Sperrm_aus", true));
        assertTrue(didRecordPetrinetTrigger("OML_Lampen_WS1_$1_WS1_Ueberw", false));
        assertTrue(didRecordPetrinetTrigger("OML_logic_Kontakte_WS1_$ws1_minus", false));
        assertTrue(didRecordPetrinetTrigger("OML_logic_Kontakte_WS1_$logic_ws1_minus", false));
        assertTrue(didRecordPetrinetTrigger("OML_logic_Kontakte_WS1_$logic_ws1_plus", false));
        assertTrue(didRecordPetrinetTrigger("OML_logic_Kontakte_WS1_$ws1_plus", false));
        assertTrue(didRecordPetrinetTrigger("OML_Kontakte_$7_WS1_plus", false));
        assertTrue(didRecordPetrinetTrigger("OML_Kontakte_$7_WS1_minus", false));
        assertTrue(didRecordPetrinetTrigger("OML_Kontakte_$7_WS1_1", false));
        assertTrue(didRecordPetrinetTrigger("OML_Lampen_WS1_$1_WS1_Ueberw", true));
    }
}
