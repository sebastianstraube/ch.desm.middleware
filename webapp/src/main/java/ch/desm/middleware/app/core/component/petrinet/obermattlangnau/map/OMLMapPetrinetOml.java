package ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

import java.util.Map;

public class OMLMapPetrinetOml extends ComponentMapBase{

	@Override
	public Map<String, String> getMap() {
		return map;
	}

    public String mapBrokerToEndpointMessage(String globalId) throws Exception {
        String message = this.getKey(globalId);
        if(message.isEmpty()) {
            throw new Exception("unable to map broker message with globalId\"" + globalId + "\"");
        }
        return message;
    }

	@Override
	protected void init(){
// map.put("W1_keine_Endlage_minus",""); //
        map.put("Fstr_ef_E_Halt","1.90.07"); //
        map.put("Fstr_ef_E_Fahrt1","1.90.06"); //
// map.put("Fstr_ef_aufgeloest",""); //
// map.put("Fstr_ef_verschlossen",""); //
// map.put("Fstr_ef_geprueft2",""); //
// map.put("Fstr_ef_Stoerung_E",""); //
// map.put("BL_OM_LN_3",""); //
// map.put("Fstr_ef_P2",""); //
// map.put("Iso_ef_frei",""); //
// map.put("Fstr_ef_P1",""); //
        map.put("Iso_ef_belegt","10.99.07"); //
// map.put("BL_OM_LN_belegt_n",""); //
// map.put("BL_OM_LN_Grundstlg_v",""); //
// map.put("Iso_ef_Zug_ausfahren",""); //
        map.put("BL_OM_LN_vorgebl_v","11.99.09"); //
// map.put("Fstr_ef_geprueft1",""); //
// map.put("BL_OM_LN_1",""); //
// map.put("BL_OM_LN_2",""); //
// map.put("Fstr_ef_P6",""); //
// map.put("Iso_ef_Zug_einfahren",""); //
// map.put("BL_OM_LN_Grundstlg_n",""); //
// map.put("Fstr_ef_Zug_eingefahren",""); //
// map.put("Fstr_fe_geprueft",""); //
// map.put("Fstr_gf_geprueft2",""); //
// map.put("Fstr_fe_F_Fahrt1",""); //
// map.put("Stw_FSS_Sperrm_aus",""); //
// map.put("BL_ZB_OM_3",""); //
        map.put("BL_ZB_OM_RMM_nZB","1.91.22"); //
// map.put("Stw_WS_Sperrm_aus",""); //
// map.put("BL_ZB_OM_vorgebl_n",""); //
// map.put("Stw_FSS_Kuppelm_aus",""); //
// map.put("BL_OM_LN_belegt_v",""); //
// map.put("BL_ZB_OM_belegt_n",""); //
// map.put("BL_OM_LN_vorgebl_n",""); //
        map.put("Stw_WS_Sperrm_ein","3.01.01"); //
// map.put("Stw_P11",""); //
        map.put("Stw_FSS_Kuppelm_ein","3.04.02"); //
// map.put("Fstr_fe_P1",""); //
// map.put("BL_ZB_OM_Grundstlg_n",""); //
// map.put("BL_ZB_OM_Grundstlg_v",""); //
// map.put("Fstr_fe_verschlossen",""); //
// map.put("BL_ZB_OM_1",""); //
// map.put("BL_ZB_OM_2",""); //
// map.put("Stw_P10",""); //
// map.put("Fstr_fe_P2b",""); //
// map.put("Fstr_fe_Zug_eingefahren",""); //
        map.put("BL_OM_LN_RMM_nLN","1.91.01"); //
        map.put("BL_ZB_OM_vorgebl_v","11.99.10"); //
// map.put("BL_ZB_OM_belegt_v",""); //
// map.put("Fstr_fe_aufgeloest",""); //
// map.put("Fstr_fe_F_Halt",""); //
        map.put("Stw_FSS_Sperrm_ein","3.04.01"); //
// map.put("Fstr_fe_Stoerung_F",""); //
        map.put("Fstr_gf_G_Halt","1.90.10"); //
// map.put("Fstr_gf_aufgeloest",""); //
        map.put("Fstr_gf_G_Fahrt3","1.90.09"); //
// map.put("Fstr_fe_P2",""); //
// map.put("Fstr_gf_Zug_eingefahren",""); //
// map.put("Fstr_gf_verschlossen",""); //
// map.put("Fstr_gf_Stoerung_G",""); //
// map.put("Fstr_gf_geprueft1",""); //
// map.put("Fstr_fg_geprueft0",""); //
        map.put("Lampen_1_F_VS_Stoer","1.90.01"); //
// map.put("Iso_cd_Zug_ausfahren",""); //
        map.put("Lampen_1_F_gruenFB1","1.90.05"); //
        map.put("Lampen_1_G_VS_Stoer","1.90.16"); //
// map.put("Iso_gf_Zug_einfahren",""); //
        map.put("Lampen_1_BL_vZB_weiss","1.90.43"); //
// map.put("Iso_gf_belegt",""); //
// map.put("Iso_egf_Zug_einfahren",""); //
// map.put("Fstr_fg_Zug_eingefahren",""); //
        map.put("Fstr_fg_F_Fahrt3","1.90.03"); //
// map.put("Fstr_fg_verschlossen",""); //
// map.put("Iso_1_Zug_ausfahren",""); //
        map.put("Iso_1_belegt","10.99.04"); //
// map.put("Fstr_fg_geprueft1",""); //
// map.put("Fstr_fg_geprueft2",""); //
// map.put("Fstr_fg_P1",""); //
// map.put("Fstr_fg_P2",""); //
// map.put("Fstr_fg_F_Halt",""); //
// map.put("Fstr_gf_P4",""); //
        map.put("Fstr_fg_Stoerung_F","90.99.04"); //
// map.put("Iso_1_Zug_einfahren",""); //
        map.put("Iso_1_frei","10.99.09"); //
// map.put("Iso_gf_Zug_ausfahren",""); //
        map.put("Iso_egf_belegt","10.99.01"); //
// map.put("Fstr_fg_aufgeloest",""); //
// map.put("Iso_egf_Zug_ausfahren",""); //
        map.put("Iso_egf_frei","10.99.10"); //
// map.put("Iso_gf_frei",""); //
// map.put("Iso_cd_frei",""); //
        map.put("Iso_cd_belegt","10.99.08"); //
// map.put("Iso_cd_Zug_einfahren",""); //
        map.put("Lampen_1_Fstr_gf","1.90.40"); //
        map.put("Lampen_1_BL_nZB_weiss","1.90.42"); //
        map.put("Lampen_1_BL_vZB_rot","1.90.44"); //
        map.put("Lampen_1_BL_nLN_weiss","1.90.33"); //
        map.put("Lampen_1_BL_nZB_rot","1.90.41"); //
        map.put("Lampen_1_BL_vLN_rot","1.90.31"); //
        map.put("Lampen_1_BL_vLN_weiss","1.90.32"); //
// map.put("Lampen_1_BL_nLN_rot",""); //
        map.put("Lampen_1_Fstr_ef","1.90.37"); //
        map.put("ext_Vb_Ueberw_W1_minus","12.99.02"); //
        map.put("ext_Vb_G_VS_Lampe_Fahrt_def","90.99.15"); //
// map.put("EMM_EMM_W10_pA2",""); //
        map.put("ext_Vb_G_VS_Lampe_Warn_def","90.99.14"); //
// map.put("ext_Vb_F_VS_Lampe_Warn_def",""); //
        map.put("ext_Vb_Ueberw_W1_plus","12.99.01"); //
// map.put("ext_Vb_F_VS_Lampe_Fahrt_def",""); //
// map.put("EMM_geprueft1A2",""); //
// map.put("EMM_EMM_W10_pA1",""); //
// map.put("EMM_EMM_Grundstlg",""); //
// map.put("EMM_EMM_W7_mA1",""); //
// map.put("EMM_geprueft2A1",""); //
// map.put("EMM_OM_E_Fahrt",""); //
// map.put("EMM_geprueft2A2",""); //
// map.put("EMM_geprueft1A1",""); //
// map.put("EMM_EMM_W10_mE3",""); //
// map.put("EMM_EMM_W10_pE2",""); //
// map.put("EMM_geprueft2A5",""); //
// map.put("EMM_EMM_W10_mE5",""); //
        map.put("EMM_C_Halt","1.90.15"); //
// map.put("EMM_C_FB1",""); //
// map.put("EMM_EMM_W10_pE1",""); //
// map.put("EMM_geprueft1E1",""); //
// map.put("EMM_EMM_W9_mE4",""); //
// map.put("LN_geprueft1A5",""); //
// map.put("EMM_geprueft1E5",""); //
// map.put("EMM_EMM_W8_pE4",""); //
// map.put("EMM_EMM_W10_mA4",""); //
// map.put("EMM_EMM_W9_pE3",""); //
// map.put("EMM_EMM_W8_mE5",""); //
// map.put("EMM_EMM_W10_mA5",""); //
// map.put("EMM_EMM_W10_mE4",""); //
// map.put("EMM_C_FB2",""); //
        map.put("EMM_D_Halt","1.90.12"); //
// map.put("EMM_D_FB2",""); //
// map.put("EMM_geprueft1E4",""); //
// map.put("EMM_EMM_W8_mA5",""); //
// map.put("EMM_EMM_W9_mE5",""); //
// map.put("EMM_geprueft1E2",""); //
        map.put("EMM_C_Fahrt","1.90.14"); //
// map.put("EMM_geprueft1A5",""); //
// map.put("EMM_geprueft1E3",""); //
        map.put("EMM_D_Fahrt","1.90.13"); //
// map.put("EMM_EMM_W9_mA5",""); //
// map.put("EMM_EMM_W7_mE1",""); //
// map.put("EMM_EMM_W8_pA4",""); //
// map.put("EMM_EMM_W7_pE2",""); //
// map.put("EMM_geprueft1A4",""); //
// map.put("EMM_geprueft2A4",""); //
// map.put("EMM_geprueft2A3",""); //
// map.put("EMM_D_FB1",""); //
// map.put("EMM_EMM_W9_mA4",""); //
// map.put("EMM_geprueft1A3",""); //
// map.put("EMM_EMM_W10_mA3",""); //
// map.put("EMM_EMM_W7_pA2",""); //
// map.put("EMM_EMM_W9_pA3",""); //
// map.put("LN_LN_W1_pE4",""); //
// map.put("LN_LN_W2_pA2",""); //
// map.put("LN_LN_W1_pA2",""); //
// map.put("LN_ce_belegt",""); //
// map.put("LN_geprueft1A2",""); //
// map.put("LN_geprueft1E5",""); //
// map.put("LN_geprueft1A4",""); //
// map.put("LN_geprueft1E2",""); //
// map.put("LN_LN_W2_mA3",""); //
// map.put("LN_LN_W3_pA3",""); //
// map.put("LN_geprueft2A3",""); //
// map.put("LN_geprueft2A4",""); //
// map.put("LN_LN_W2_mA4",""); //
// map.put("LN_LN_W3_pA4",""); //
// map.put("LN_LN_W5_mA4",""); //
// map.put("LN_geprueft2A1",""); //
// map.put("LN_LN_W1_pA3",""); //
// map.put("LN_LN_W1_pA5",""); //
// map.put("LN_LN_W3_mA5",""); //
// map.put("LN_LN_W4_pA5",""); //
// map.put("LN_LN_W1_mA1",""); //
// map.put("LN_geprueft1A3",""); //
// map.put("LN_geprueft2A2",""); //
// map.put("LN_LN_W5_pA3",""); //
// map.put("LN_geprueft1E3",""); //
// map.put("LN_LN_W1_pA4",""); //
// map.put("LN_LN_W2_mA5",""); //
// map.put("LN_EMM_Grundstlg",""); //
// map.put("LN_geprueft1A1",""); //
// map.put("LN_geprueft1E4",""); //
// map.put("LN_geprueft1E1",""); //
// map.put("LN_geprueft2A5",""); //
// map.put("LN_geprueft1A6",""); //
// map.put("LN_LN_W4_pA6",""); //
// map.put("LN_LN_W6_mA6",""); //
// map.put("LN_LN_W2_mA6",""); //
// map.put("LN_LN_W3_mA6",""); //
// map.put("LN_LN_W6_mA5",""); //
// map.put("LN_geprueft2A6",""); //
// map.put("LN_LN_W1_pA6",""); //
// map.put("LN_LN_W3_mE5",""); //
// map.put("ZB_C_Fahrt",""); //
// map.put("ZB_geprueft1A1",""); //
// map.put("LN_C26_Fahrt",""); //
// map.put("LN_LN_W2_mE5",""); //
// map.put("LN_LN_W2_mE4",""); //
// map.put("LN_C1_Halt",""); //
// map.put("LN_LN_W1_pE5",""); //
// map.put("LN_LN_W6_mE6",""); //
// map.put("LN_LN_W3_mE6",""); //
// map.put("LN_LN_W6_mE5",""); //
// map.put("LN_LN_W1_pE3",""); //
// map.put("LN_LN_W5_mE4",""); //
// map.put("LN_C26_FB2",""); //
// map.put("LN_LN_W5_pE3",""); //
// map.put("LN_C26_Halt",""); //
// map.put("LN_C26_FB1",""); //
// map.put("LN_E_FB2",""); //
// map.put("LN_LN_W4_pE6",""); //
// map.put("LN_LN_W2_mE3",""); //
// map.put("LN_C1_Fahrt2",""); //
// map.put("LN_LN_W4_pE5",""); //
// map.put("LN_geprueft1E6",""); //
// map.put("LN_e_Halt",""); //
// map.put("LN_LN_W2_mE6",""); //
// map.put("LN_LN_W1_pE6",""); //
// map.put("LN_LN_W3_pE4",""); //
// map.put("LN_LN_W2_pE2",""); //
// map.put("LN_LN_W3_pE3",""); //
// map.put("LN_E_Fahrt",""); //
// map.put("LN_E_FB1",""); //
// map.put("LN_LN_W1_pE2",""); //
// map.put("LN_LN_W1_mE1",""); //
// map.put("ZB_ZB_W2_mE1",""); //
// map.put("ZB_ZB_W2_pE2",""); //
// map.put("ZB_EMM_Grundstlg",""); //
// map.put("ZB_geprueft1E2",""); //
// map.put("ZB_D_Fahrt",""); //
// map.put("ZB_ZB_W2_mA1",""); //
// map.put("ZB_ZB_W2_pA2",""); //
// map.put("ZB_geprueft1A2",""); //
// map.put("ZB_cd_belegt",""); //
// map.put("W1_keine_Endlage_plus",""); //
// map.put("W1_Endlage_plus",""); //
// map.put("W1_Endlage_minus",""); //
// map.put("W1_gestoert_p",""); //
// map.put("W1_gestoert_m",""); //
        map.put("Lampen_1_F_rot","1.90.04"); //
// map.put("Lampen_P16",""); //
// map.put("Lampen_P17",""); //
// map.put("Lampen_P49",""); //
// map.put("Lampen_P23",""); //
// map.put("Lampen_P32",""); //
// map.put("Lampen_P33",""); //
// map.put("Lampen_P4",""); //
// map.put("Lampen_P48",""); //
// map.put("Lampen_P112",""); //
// map.put("Lampen_2_Signal",""); //
// map.put("Lampen_P26",""); //
// map.put("Lampen_P34",""); //
        map.put("Lampen_1_FBV_vLN","1.91.02"); //
// map.put("Lampen_2_Weiche",""); //
// map.put("Lampen_P30",""); //
// map.put("Lampen_P35",""); //
        map.put("Lampen_1_WS1_Ueberw","1.01.02"); //
// map.put("Lampen_P38",""); //
        map.put("Lampen_1_WS1_Freig","1.01.01"); //
// map.put("Lampen_2_Block",""); //
// map.put("Lampen_P1",""); //
// map.put("Lampen_P12",""); //
// map.put("Lampen_P13",""); //
// map.put("Lampen_P6",""); //
// map.put("Lampen_P8",""); //
// map.put("Lampen_P20",""); //
// map.put("Lampen_Iso_cd_aus",""); //
        map.put("Lampen_1_Stoer_Wecker","1.91.03"); //
// map.put("Lampen_P15",""); //
// map.put("Lampen_P41",""); //
        map.put("Lampen_1_FBV_vZB","1.91.21"); //
// map.put("Lampen_P18",""); //
// map.put("Lampen_P39",""); //
        map.put("Lampen_Iso_cd_ein","1.90.39"); //
// map.put("Lampen_P22",""); //
// map.put("Lampen_P117",""); //
// map.put("Lampen_P21",""); //
// map.put("Lampen_P40",""); //
// map.put("Lampen_P135",""); //
// map.put("Lampen_P27",""); //
        map.put("Kontakte_6_NT_W1","6.91.10"); //
        map.put("Kontakte_6_ISU_Sign","6.91.15"); //
// map.put("Kontakte_6_RM_nLN",""); //
        map.put("Kontakte_7_WS1_minus","7.91.04"); //
        map.put("Kontakte_8_FSS_90EG","8.91.23"); //
        map.put("Kontakte_8_FSS_10F","8.91.03"); //
        map.put("Kontakte_8_FSS_30F","8.91.04"); //
        map.put("Kontakte_6_Gleist_EMM","6.91.08"); //
        map.put("Kontakte_6_NAL","6.91.13"); //
        map.put("Kontakte_7_WS1_1","7.91.02"); //
        map.put("Kontakte_7_WS1_plus","7.91.01"); //
        map.put("Kontakte_8_FSS_30EG","8.91.20"); //
        map.put("Kontakte_8_FSS_45EG","8.91.21"); //
        map.put("Kontakte_6_Gleist_ZB","6.91.14"); //
        map.put("Kontakte_8_FSS_45F","8.91.05"); //
        map.put("Kontakte_8_FSS_90F","8.91.07"); //
        map.put("Kontakte_6_FBF_nLN","6.91.06"); //
        map.put("Kontakte_8_FSS_10EG","8.91.19"); //
        map.put("Kontakte_6_RM_nZB","6.91.03"); //
        map.put("Kontakte_6_FBA_nLN","6.91.04"); //
        map.put("Kontakte_6_BLU_EG","6.91.07"); //
// map.put("Lampen_Iso_egf_aus",""); //
        map.put("Lampen_Iso_egf_ein","1.90.35"); //
        map.put("Kontakte_6_FBA_nZB","6.91.02"); //
// map.put("Lampen_Iso_ef_aus",""); //
        map.put("Kontakte_6_FBF_nZB","6.91.01"); //
// map.put("Lampen_Iso_1_aus",""); //
        map.put("Lampen_Iso_ef_ein","1.90.38"); //
        map.put("Lampen_Iso_1_ein","1.90.36"); //
// map.put("ILTIS_EMM_833_3",""); //
// map.put("ILTIS_EMM_833_5",""); //
// map.put("ILTIS_ZB_1_138",""); //
// map.put("ILTIS_ZB_2_138",""); //
// map.put("ILTIS_ZB_138_1",""); //
// map.put("ILTIS_ZB_138_2",""); //
// map.put("ILTIS_LN_834_2",""); //
// map.put("ILTIS_EMM_3_833",""); //
// map.put("ZB_ZB_W1_pE2",""); //
// map.put("ZB_ZB_W1_mE1",""); //
// map.put("ILTIS_EMM_2_833",""); //
// map.put("ILTIS_LN_834_1",""); //
// map.put("ZB_C_FB1",""); //
// map.put("ILTIS_LN_834_3",""); //
// map.put("ZB_D_Halt",""); //
// map.put("ZB_geprueft2A1",""); //
// map.put("ILTIS_LN_834_4",""); //
// map.put("ZB_ZB_W1_pA2",""); //
// map.put("ZB_ZB_W1_mA1",""); //
// map.put("ILTIS_EMM_833_4",""); //
// map.put("ZB_geprueft2A2",""); //
// map.put("ZB_C_Halt",""); //
// map.put("ZB_geprueft1E1",""); //
// map.put("ZB_D_FB2",""); //
// map.put("ILTIS_EMM_4_833",""); //
// map.put("ILTIS_EMM_5_833",""); //
// map.put("ILTIS_EMM_833_1",""); //
// map.put("ILTIS_EMM_833_2",""); //
// map.put("ILTIS_EMM_1_833",""); //
// map.put("ZB_C_FB2",""); //
// map.put("ZB_D_FB1",""); //
// map.put("ILTIS_LN_834_6",""); //
// map.put("ILTIS_freigeben_vLN",""); //
// map.put("ILTIS_festgehalten_v_ZB",""); //
        map.put("ILTIS_RM_LN_OM","11.99.04"); //
// map.put("ILTIS_anfordern_vLN",""); //
        map.put("ILTIS_RM_ZB_OM","11.99.08"); //
// map.put("ILTIS_LN_5_834",""); //
// map.put("ILTIS_LN_6_834",""); //
// map.put("ILTIS_LN_3_834",""); //
// map.put("ILTIS_rueckmelden_LN_OM",""); //
// map.put("ILTIS_rueckmelden_ZB_OM",""); //
// map.put("ILTIS_festhalten_vLN",""); //
// map.put("ILTIS_RM_moeglich2",""); //
// map.put("ILTIS_freigegeben_vZB",""); //
// map.put("ILTIS_freigeben_vZB",""); //
// map.put("ILTIS_freigegeben_vLN",""); //
// map.put("ILTIS_LN_2_834",""); //
// map.put("ILTIS_festhalten_vZB",""); //
// map.put("ILTIS_P230",""); //
// map.put("ILTIS_RM_moeglich1",""); //
// map.put("ILTIS_LN_834_5",""); //
// map.put("ILTIS_LN_4_834",""); //
// map.put("ILTIS_LN_1_834",""); //
// map.put("ILTIS_anfordern_vZB",""); //
// map.put("ILTIS_P130",""); //
// map.put("ILTIS_festgehalten_vLN",""); //
// map.put("Kontakte_6_Anf_Durchf_nEMM",""); //
// map.put("Kontakte_6_Wecker_absch",""); //
// map.put("Kontakte_6_Wbel_ein",""); //
// map.put("Kontakte_6_Zeitsch_Umg",""); //
// map.put("Kontakte_8_FSS_0EGF",""); //
// map.put("Kontakte_8_FSS_1EGF",""); //
// map.put("Kontakte_8_FSS_80EG",""); //
// map.put("Kontakte_8_FSS_80F",""); //
// map.put("Kontakte_8_FSS_0EGF_1",""); //
// map.put("ext_Vb_FBZ_vLN",""); //
// map.put("ext_Vb_RM_vLN",""); //
// map.put("ext_Vb_FBZ_vZB",""); //
// map.put("ext_Vb_RM_vZB",""); //
// map.put("ext_Vb_FBA_vEMM",""); //
// map.put("ext_Vb_vorblocken_vLN",""); //
// map.put("ext_Vb_abl_vEMM",""); //
// map.put("ext_Vb_abl_vLN",""); //
// map.put("ext_Vb_abl_vZB",""); //
// map.put("ext_Vb_abl_nEMM",""); //
// map.put("ext_Vb_abl_nLN",""); //
// map.put("ext_Vb_abl_nZB",""); //
// map.put("ext_Vb_Ueberw_def_aus",""); //
// map.put("ext_Vb_Stellstrom_def_aus",""); //
// map.put("ext_Vb_F_Lampe_rot_def",""); //
// map.put("ext_Vb_D_Lamt_def",""); //
// map.put("ext_Vb_G_Lampe_gruenFB3_def",""); //
// map.put("ext_Vb_E_Lampe_rot_def",""); //
// map.put("ext_Vb_G_Lampe_rot_def",""); //
// map.put("ext_Vb_F_Lampe_gruenFB3_def",""); //
// map.put("ext_Vb_E_Lampe_gruenFB1_def",""); //
// map.put("ext_Vb_blocken_vLN",""); //
// map.put("ext_Vb_blocken_vZB",""); //
// map.put("ext_Vb_vorblocken_vZB",""); //

    }

}
