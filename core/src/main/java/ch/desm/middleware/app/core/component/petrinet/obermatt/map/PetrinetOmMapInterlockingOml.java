package ch.desm.middleware.app.core.component.petrinet.obermatt.map;

import ch.desm.middleware.app.common.ComponentMapBase;

import java.util.Map;

public class PetrinetOmMapInterlockingOml extends ComponentMapBase{

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
	protected void init(){// map.put("OML_BL_OM_LN_$1",""); //
// map.put("OML_BL_OM_LN_$2",""); //
// map.put("OML_BL_OM_LN_$3",""); //
// map.put("OML_BL_OM_LN_$belegt_n",""); //
// map.put("OML_BL_OM_LN_$belegt_v",""); //
// map.put("OML_BL_OM_LN_$Grundstlg_n",""); //
// map.put("OML_BL_OM_LN_$Grundstlg_v",""); //
        map.put("OML_BL_OM_LN_$RMM_nLN","1.91.01"); //
// map.put("OML_BL_OM_LN_$vorgebl_n",""); //
        map.put("OML_BL_OM_LN_$vorgebl_v","11.99.09"); //
// map.put("OML_BL_ZB_OM_$1",""); //
// map.put("OML_BL_ZB_OM_$2",""); //
// map.put("OML_BL_ZB_OM_$3",""); //
// map.put("OML_BL_ZB_OM_$belegt_n",""); //
// map.put("OML_BL_ZB_OM_$belegt_v",""); //
// map.put("OML_BL_ZB_OM_$Grundstlg_n",""); //
// map.put("OML_BL_ZB_OM_$Grundstlg_v",""); //
        map.put("OML_BL_ZB_OM_$RMM_nZB","1.91.22"); //
// map.put("OML_BL_ZB_OM_$vorgebl_n",""); //
        map.put("OML_BL_ZB_OM_$vorgebl_v","11.99.10"); //
// map.put("OML_EMM_$C_aufloesen",""); //
        map.put("OML_EMM_$C_FB1","1.90.14"); //
        map.put("OML_EMM_$C_FB2","1.90.14"); //
        map.put("OML_EMM_$C_Halt","1.90.15"); //
        map.put("OML_EMM_$D_FB1","1.90.13"); //
        map.put("OML_EMM_$D_FB2","1.90.13"); //
        map.put("OML_EMM_$D_Halt","1.90.12"); //
// map.put("OML_EMM_$EMM_Grundstlg",""); //
// map.put("OML_EMM_$EMM_W10_mA3",""); //
// map.put("OML_EMM_$EMM_W10_mA4",""); //
// map.put("OML_EMM_$EMM_W10_mA5",""); //
// map.put("OML_EMM_$EMM_W10_mE3",""); //
// map.put("OML_EMM_$EMM_W10_mE4",""); //
// map.put("OML_EMM_$EMM_W10_mE5",""); //
// map.put("OML_EMM_$EMM_W10_pA1",""); //
// map.put("OML_EMM_$EMM_W10_pA2",""); //
// map.put("OML_EMM_$EMM_W10_pE1",""); //
// map.put("OML_EMM_$EMM_W10_pE2",""); //
// map.put("OML_EMM_$EMM_W7_mA1",""); //
// map.put("OML_EMM_$EMM_W7_mE1",""); //
// map.put("OML_EMM_$EMM_W7_pA2",""); //
// map.put("OML_EMM_$EMM_W7_pE2",""); //
// map.put("OML_EMM_$EMM_W8_mA5",""); //
// map.put("OML_EMM_$EMM_W8_mE5",""); //
// map.put("OML_EMM_$EMM_W8_pA4",""); //
// map.put("OML_EMM_$EMM_W8_pE4",""); //
// map.put("OML_EMM_$EMM_W9_mA4",""); //
// map.put("OML_EMM_$EMM_W9_mA5",""); //
// map.put("OML_EMM_$EMM_W9_mE4",""); //
// map.put("OML_EMM_$EMM_W9_mE5",""); //
// map.put("OML_EMM_$EMM_W9_pA3",""); //
// map.put("OML_EMM_$EMM_W9_pE3",""); //
// map.put("OML_EMM_$geprueft1A1",""); //
// map.put("OML_EMM_$geprueft1A2",""); //
// map.put("OML_EMM_$geprueft1A3",""); //
// map.put("OML_EMM_$geprueft1A4",""); //
// map.put("OML_EMM_$geprueft1A5",""); //
// map.put("OML_EMM_$geprueft1E1",""); //
// map.put("OML_EMM_$geprueft1E2",""); //
// map.put("OML_EMM_$geprueft1E3",""); //
// map.put("OML_EMM_$geprueft1E4",""); //
// map.put("OML_EMM_$geprueft1E5",""); //
// map.put("OML_EMM_$geprueft2A1",""); //
// map.put("OML_EMM_$geprueft2A2",""); //
// map.put("OML_EMM_$geprueft2A3",""); //
// map.put("OML_EMM_$geprueft2A4",""); //
// map.put("OML_EMM_$geprueft2A5",""); //
// map.put("OML_ext_Vb_$abl_nEMM",""); //
// map.put("OML_ext_Vb_$abl_nLN",""); //
// map.put("OML_ext_Vb_$abl_nZB",""); //
// map.put("OML_ext_Vb_$abl_vEMM",""); //
// map.put("OML_ext_Vb_$abl_vLN",""); //
// map.put("OML_ext_Vb_$abl_vZB",""); //
// map.put("OML_ext_Vb_$blocken_vLN",""); //
// map.put("OML_ext_Vb_$blocken_vZB",""); //
// map.put("OML_ext_Vb_$D_Lamt_def",""); //
// map.put("OML_ext_Vb_$E_Lampe_gruenFB1_def",""); //
// map.put("OML_ext_Vb_$E_Lampe_rot_def",""); //
// map.put("OML_ext_Vb_$F_Lampe_gruenFB3_def",""); //
// map.put("OML_ext_Vb_$F_Lampe_rot_def",""); //
// map.put("OML_ext_Vb_$F_VS_Lampe_Fahrt_def",""); //
// map.put("OML_ext_Vb_$F_VS_Lampe_Warn_def",""); //
// map.put("OML_ext_Vb_$FBA_vEMM",""); //
// map.put("OML_ext_Vb_$FBZ_vLN",""); //
// map.put("OML_ext_Vb_$FBZ_vZB",""); //
// map.put("OML_ext_Vb_$G_Lampe_gruenFB3_def",""); //
// map.put("OML_ext_Vb_$G_Lampe_rot_def",""); //
        map.put("OML_ext_Vb_$G_VS_Lampe_Fahrt_def","90.99.15"); //
        map.put("OML_ext_Vb_$G_VS_Lampe_Warn_def","90.99.14"); //
// map.put("OML_ext_Vb_$RM_vLN",""); //
// map.put("OML_ext_Vb_$RM_vZB",""); //
// map.put("OML_ext_Vb_$Stellstrom_def_aus",""); //
// map.put("OML_ext_Vb_$Ueberw_def_aus",""); //
        map.put("OML_ext_Vb_$Ueberw_W1_minus","12.99.02"); //
        map.put("OML_ext_Vb_$Ueberw_W1_plus","12.99.01"); //
// map.put("OML_ext_Vb_$vorblocken_vLN",""); //
// map.put("OML_ext_Vb_$vorblocken_vZB",""); //
// map.put("OML_Fstr_ef_$aufgeloest",""); //
        map.put("OML_Fstr_ef_$E_Fahrt1","1.90.06"); //
        map.put("OML_Fstr_ef_$E_Halt","1.90.07"); //
// map.put("OML_Fstr_ef_$gemerkt_90EB",""); //
// map.put("OML_Fstr_ef_$geprueft1",""); //
// map.put("OML_Fstr_ef_$geprueft2",""); //
// map.put("OML_Fstr_ef_$geprueft3",""); //
// map.put("OML_Fstr_ef_$P6",""); //
// map.put("OML_Fstr_ef_$prison_signal_steller",""); //
// map.put("OML_Fstr_ef_$Pstore_1_ef_belegt",""); //
// map.put("OML_Fstr_ef_$signal_steller",""); //
// map.put("OML_Fstr_ef_$verschlossen",""); //
// map.put("OML_Fstr_ef_$Zug_eingefahren",""); //
// map.put("OML_Fstr_fe_$aufgeloest",""); //
// map.put("OML_Fstr_fe_$F_Fahrt1",""); //
// map.put("OML_Fstr_fe_$F_Halt",""); //
// map.put("OML_Fstr_fe_$gemerkt_90F",""); //
// map.put("OML_Fstr_fe_$geprueft",""); //
// map.put("OML_Fstr_fe_$geprueft3",""); //
// map.put("OML_Fstr_fe_$P2",""); //
// map.put("OML_Fstr_fe_$prison_signal_steller",""); //
// map.put("OML_Fstr_fe_$signal_steller",""); //
// map.put("OML_Fstr_fe_$store_1_egf_belegt",""); //
// map.put("OML_Fstr_fe_$verschlossen",""); //
// map.put("OML_Fstr_fe_$Zug_eingefahren",""); //
// map.put("OML_Fstr_fg_$aufgeloest",""); //
        map.put("OML_Fstr_fg_$F_Fahrt3","1.90.03"); //
// map.put("OML_Fstr_fg_$F_Halt",""); //
// map.put("OML_Fstr_fg_$gemerkt_90F",""); //
// map.put("OML_Fstr_fg_$geprueft0",""); //
// map.put("OML_Fstr_fg_$geprueft1",""); //
// map.put("OML_Fstr_fg_$geprueft2",""); //
// map.put("OML_Fstr_fg_$geprueft3",""); //
// map.put("OML_Fstr_fg_$prison_signal_steller",""); //
// map.put("OML_Fstr_fg_$signal_steller",""); //
// map.put("OML_Fstr_fg_$store_egf_1_belegt",""); //
// map.put("OML_Fstr_fg_$verschlossen",""); //
// map.put("OML_Fstr_fg_$Zug_eingefahren",""); //
// map.put("OML_Fstr_gf_$aufgeloest",""); //
        map.put("OML_Fstr_gf_$G_Fahrt3","1.90.09"); //
// map.put("OML_Fstr_gf_$G_Halt",""); //
// map.put("OML_Fstr_gf_$gemerkt_90EG",""); //
// map.put("OML_Fstr_gf_$geprueft1",""); //
// map.put("OML_Fstr_gf_$geprueft2",""); //
// map.put("OML_Fstr_gf_$geprueft3",""); //
// map.put("OML_Fstr_gf_$P4",""); //
// map.put("OML_Fstr_gf_$prison_signal_steller",""); //
// map.put("OML_Fstr_gf_$signal_steller",""); //
// map.put("OML_Fstr_gf_$store_1_belegt",""); //
// map.put("OML_Fstr_gf_$verschlossen",""); //
// map.put("OML_Fstr_gf_$Zug_eingefahren",""); //
// map.put("OML_ILTIS_$anfordern_vLN",""); //
// map.put("OML_ILTIS_$anfordern_vZB",""); //
// map.put("OML_ILTIS_$EMM_1_833",""); //
// map.put("OML_ILTIS_$EMM_2_833",""); //
// map.put("OML_ILTIS_$EMM_3_833",""); //
// map.put("OML_ILTIS_$EMM_4_833",""); //
// map.put("OML_ILTIS_$EMM_5_833",""); //
// map.put("OML_ILTIS_$EMM_833_1",""); //
// map.put("OML_ILTIS_$EMM_833_2",""); //
// map.put("OML_ILTIS_$EMM_833_3",""); //
// map.put("OML_ILTIS_$EMM_833_4",""); //
// map.put("OML_ILTIS_$EMM_833_5",""); //
// map.put("OML_ILTIS_$festgehalten_v_ZB",""); //
// map.put("OML_ILTIS_$festgehalten_vLN",""); //
// map.put("OML_ILTIS_$festhalten_vLN",""); //
// map.put("OML_ILTIS_$festhalten_vZB",""); //
// map.put("OML_ILTIS_$freigeben_vLN",""); //
// map.put("OML_ILTIS_$freigeben_vZB",""); //
// map.put("OML_ILTIS_$freigegeben_vLN",""); //
// map.put("OML_ILTIS_$freigegeben_vZB",""); //
// map.put("OML_ILTIS_$LN_1_834",""); //
// map.put("OML_ILTIS_$LN_2_834",""); //
// map.put("OML_ILTIS_$LN_3_834",""); //
// map.put("OML_ILTIS_$LN_4_834",""); //
// map.put("OML_ILTIS_$LN_5_834",""); //
// map.put("OML_ILTIS_$LN_6_834",""); //
// map.put("OML_ILTIS_$LN_834_1",""); //
// map.put("OML_ILTIS_$LN_834_2",""); //
// map.put("OML_ILTIS_$LN_834_3",""); //
// map.put("OML_ILTIS_$LN_834_4",""); //
// map.put("OML_ILTIS_$LN_834_5",""); //
// map.put("OML_ILTIS_$LN_834_6",""); //
        map.put("OML_ILTIS_$RM_LN_OM","11.99.04"); //
        map.put("OML_ILTIS_$RM_ZB_OM","11.99.08"); //
// map.put("OML_ILTIS_$ZB_1_138",""); //
// map.put("OML_ILTIS_$ZB_138_1",""); //
// map.put("OML_ILTIS_$ZB_138_2",""); //
// map.put("OML_ILTIS_$ZB_2_138",""); //
// map.put("OML_Iso_1_$belegt",""); //
        map.put("OML_Iso_1_$belegen","10.99.04"); //
// map.put("OML_Iso_1_$frei",""); //
// map.put("OML_Iso_cd_$belegt",""); //
        map.put("OML_Iso_cd_$belegen","10.99.08"); //
// map.put("OML_Iso_cd_$frei",""); //
// map.put("OML_Iso_ef_$belegt",""); //
        map.put("OML_Iso_ef_$belegen","10.99.07"); //
// map.put("OML_Iso_ef_$frei",""); //
// map.put("OML_Iso_egf_$belegt",""); //
        map.put("OML_Iso_egf_$belegen","10.99.01"); //
// map.put("OML_Iso_egf_$frei",""); //
// map.put("OML_Iso_gf_$belegt",""); //
// map.put("OML_Iso_gf_$belegen",""); //
// map.put("OML_Iso_gf_$frei",""); //
// map.put("OML_Kontakte_$6_Anf_Durchf_nEMM",""); //
        map.put("OML_Kontakte_$6_BLU_EG","6.91.07"); //
        map.put("OML_Kontakte_$6_FBA_nLN","6.91.05"); //
        map.put("OML_Kontakte_$6_FBA_nZB","6.91.02"); //
        map.put("OML_Kontakte_$6_FBF_nLN","6.91.06"); //
        map.put("OML_Kontakte_$6_FBF_nZB","6.91.01"); //
        map.put("OML_Kontakte_$6_Gleist_EMM","6.91.08"); //
        map.put("OML_Kontakte_$6_Gleist_ZB","6.91.14"); //
        map.put("OML_Kontakte_$6_ISU_Sign","6.91.15"); //
        map.put("OML_Kontakte_$6_NAL","6.91.13"); //
        map.put("OML_Kontakte_$6_NT_W1","6.91.10"); //
        map.put("OML_Kontakte_$6_RM_nLN","6.91.04"); //
        map.put("OML_Kontakte_$6_RM_nZB","6.91.03"); //
// map.put("OML_Kontakte_$6_Wbel_ein",""); //
// map.put("OML_Kontakte_$6_Wecker_absch",""); //
// map.put("OML_Kontakte_$6_Zeitsch_Umg",""); //
        map.put("OML_Kontakte_$7_WS1_1","7.91.02"); //
// map.put("OML_Kontakte_$7_WS1_minus",""); //
// map.put("OML_Kontakte_$7_WS1_plus",""); //
        map.put("OML_Kontakte_$8_FSS_0EGF","8.91.01"); //
        map.put("OML_Kontakte_$8_FSS_10EG","8.91.19"); //
        map.put("OML_Kontakte_$8_FSS_10F","8.91.03"); //
// map.put("OML_Kontakte_$8_FSS_1EGF",""); //
        map.put("OML_Kontakte_$8_FSS_30EG","8.91.20"); //
        map.put("OML_Kontakte_$8_FSS_30F","8.91.04"); //
        map.put("OML_Kontakte_$8_FSS_45EG","8.91.21"); //
        map.put("OML_Kontakte_$8_FSS_45F","8.91.05"); //
// map.put("OML_Kontakte_$8_FSS_80EG",""); //
// map.put("OML_Kontakte_$8_FSS_80F",""); //
        map.put("OML_Kontakte_$8_FSS_90EG","8.91.23"); //
        map.put("OML_Kontakte_$8_FSS_90F","8.91.07"); //
        map.put("OML_Lampen_Fahrstrasse_$1_Fstr_ef","1.90.37"); //
        map.put("OML_Lampen_Fahrstrasse_$1_Fstr_gf","1.90.40"); //
        map.put("OML_Lampen_Isolierung_$Iso_1_ein","1.90.36"); //
        map.put("OML_Lampen_Isolierung_$Iso_cd_ein","1.90.39"); //
        map.put("OML_Lampen_Isolierung_$Iso_ef_ein","1.90.38"); //
        map.put("OML_Lampen_Isolierung_$Iso_egf_ein","1.90.35"); //
        map.put("OML_Lampen_Signal_E_$1_E_gruenFB1","1.90.06"); //
        map.put("OML_Lampen_Signal_E_$1_E_rot","1.90.07"); //
        map.put("OML_Lampen_Signal_F_$1_F_gruenFB1","1.90.05"); //
        map.put("OML_Lampen_Signal_F_$1_F_gruenFB3","1.90.03"); //
        map.put("OML_Lampen_Signal_F_$1_F_rot","1.90.04"); //
        map.put("OML_Lampen_Signal_G_$1_G_gruenFB1","1.90.09"); //
        map.put("OML_Lampen_Signal_G_$1_G_gruenFB3","1.90.11"); //
        map.put("OML_Lampen_Signal_G_$1_G_rot","1.90.10"); //
        map.put("OML_Lampen_Stoerung_$1_F_VS_Stoer","1.90.01"); //
        map.put("OML_Lampen_Stoerung_$1_G_VS_Stoer","1.90.16"); //
        map.put("OML_Lampen_Stoerung_$1_Stoer_Wecker","1.91.03"); //
        map.put("OML_Lampen_Streckenblock_$1_BL_nLN_rot","1.90.34"); //
        map.put("OML_Lampen_Streckenblock_$1_BL_nLN_weiss","1.90.33"); //
        map.put("OML_Lampen_Streckenblock_$1_BL_nZB_rot","1.90.41"); //
        map.put("OML_Lampen_Streckenblock_$1_BL_nZB_weiss","1.90.42"); //
        map.put("OML_Lampen_Streckenblock_$1_BL_vLN_rot","1.90.31"); //
        map.put("OML_Lampen_Streckenblock_$1_BL_vLN_weiss","1.90.32"); //
        map.put("OML_Lampen_Streckenblock_$1_BL_vZB_rot","1.90.44"); //
        map.put("OML_Lampen_Streckenblock_$1_BL_vZB_weiss","1.90.43"); //
        map.put("OML_Lampen_Streckenblock_$1_FBV_vLN","1.91.02"); //
        map.put("OML_Lampen_Streckenblock_$1_FBV_vZB","1.91.21"); //
// map.put("OML_Lampen_WS1_$1_WS1_Freig",""); //
        map.put("OML_Lampen_WS1_$1_WS1_Ueberw","1.01.02"); //
// map.put("OML_LN_$C1_FB1",""); //
// map.put("OML_LN_$C1_Halt",""); //
// map.put("OML_LN_$C26_FB1",""); //
// map.put("OML_LN_$C26_FB2",""); //
// map.put("OML_LN_$C26_Halt",""); //
// map.put("OML_LN_$ce_belegt",""); //
// map.put("OML_LN_$E_FB1",""); //
// map.put("OML_LN_$E_FB2",""); //
// map.put("OML_LN_$e_Halt",""); //
// map.put("OML_LN_$geprueft1A1",""); //
// map.put("OML_LN_$geprueft1A2",""); //
// map.put("OML_LN_$geprueft1A3",""); //
// map.put("OML_LN_$geprueft1A4",""); //
// map.put("OML_LN_$geprueft1A5",""); //
// map.put("OML_LN_$geprueft1A6",""); //
// map.put("OML_LN_$geprueft1E1",""); //
// map.put("OML_LN_$geprueft1E2",""); //
// map.put("OML_LN_$geprueft1E3",""); //
// map.put("OML_LN_$geprueft1E4",""); //
// map.put("OML_LN_$geprueft1E5",""); //
// map.put("OML_LN_$geprueft1E6",""); //
// map.put("OML_LN_$geprueft2A1",""); //
// map.put("OML_LN_$geprueft2A2",""); //
// map.put("OML_LN_$geprueft2A3",""); //
// map.put("OML_LN_$geprueft2A4",""); //
// map.put("OML_LN_$geprueft2A5",""); //
// map.put("OML_LN_$geprueft2A6",""); //
// map.put("OML_LN_$LN_Grundstlg",""); //
// map.put("OML_LN_$LN_W1_mA1",""); //
// map.put("OML_LN_$LN_W1_mE1",""); //
// map.put("OML_LN_$LN_W1_pA2",""); //
// map.put("OML_LN_$LN_W1_pA3",""); //
// map.put("OML_LN_$LN_W1_pA4",""); //
// map.put("OML_LN_$LN_W1_pA5",""); //
// map.put("OML_LN_$LN_W1_pA6",""); //
// map.put("OML_LN_$LN_W1_pE2",""); //
// map.put("OML_LN_$LN_W1_pE3",""); //
// map.put("OML_LN_$LN_W1_pE4",""); //
// map.put("OML_LN_$LN_W1_pE5",""); //
// map.put("OML_LN_$LN_W1_pE6",""); //
// map.put("OML_LN_$LN_W2_mA3",""); //
// map.put("OML_LN_$LN_W2_mA4",""); //
// map.put("OML_LN_$LN_W2_mA5",""); //
// map.put("OML_LN_$LN_W2_mA6",""); //
// map.put("OML_LN_$LN_W2_mE3",""); //
// map.put("OML_LN_$LN_W2_mE4",""); //
// map.put("OML_LN_$LN_W2_mE5",""); //
// map.put("OML_LN_$LN_W2_mE6",""); //
// map.put("OML_LN_$LN_W2_pA2",""); //
// map.put("OML_LN_$LN_W2_pE2",""); //
// map.put("OML_LN_$LN_W3_mA5",""); //
// map.put("OML_LN_$LN_W3_mA6",""); //
// map.put("OML_LN_$LN_W3_mE5",""); //
// map.put("OML_LN_$LN_W3_mE6",""); //
// map.put("OML_LN_$LN_W3_pA3",""); //
// map.put("OML_LN_$LN_W3_pA4",""); //
// map.put("OML_LN_$LN_W3_pE3",""); //
// map.put("OML_LN_$LN_W3_pE4",""); //
// map.put("OML_LN_$LN_W4_pA5",""); //
// map.put("OML_LN_$LN_W4_pA6",""); //
// map.put("OML_LN_$LN_W4_pE5",""); //
// map.put("OML_LN_$LN_W4_pE6",""); //
// map.put("OML_LN_$LN_W5_mA4",""); //
// map.put("OML_LN_$LN_W5_mE4",""); //
// map.put("OML_LN_$LN_W5_pA3",""); //
// map.put("OML_LN_$LN_W5_pE3",""); //
// map.put("OML_LN_$LN_W6_mA5",""); //
// map.put("OML_LN_$LN_W6_mA6",""); //
// map.put("OML_LN_$LN_W6_mE5",""); //
// map.put("OML_LN_$LN_W6_mE6",""); //
// map.put("OML_LN_Fstr_aufloesen",""); //
// map.put("OML_logic_Kontakte_WS1_$logic_ws1_minus",""); //
// map.put("OML_logic_Kontakte_WS1_$logic_ws1_plus",""); //
        map.put("OML_logic_Kontakte_WS1_$ws1_minus","7.91.04"); //
        map.put("OML_logic_Kontakte_WS1_$ws1_plus","7.91.01"); //
// map.put("OML_Stw_FSS_KSM_$90EG_store",""); //
// map.put("OML_Stw_FSS_KSM_$90F_store",""); //
// map.put("OML_Stw_FSS_KSM_$FSS_Kuppelm_aus",""); //
        map.put("OML_Stw_FSS_KSM_$FSS_Kuppelm_ein","3.04.02"); //
// map.put("OML_Stw_FSS_SM_$FSS_30EG_reached_store",""); //
// map.put("OML_Stw_FSS_SM_$FSS_Sperrm_aus",""); //
        map.put("OML_Stw_FSS_SM_$FSS_Sperrm_ein","3.04.01"); //
// map.put("OML_Stw_FSS_SM_$FSS30F_reached_store",""); //
// map.put("OML_Stw_FSS_SM_$NAL_pressed_store",""); //
// map.put("OML_Stw_W1_$Endlage_minus",""); //
// map.put("OML_Stw_W1_$Endlage_plus",""); //
// map.put("OML_Stw_W1_$Umstellen_minus",""); //
// map.put("OML_Stw_W1_$Umstellen_plus",""); //
// map.put("OML_Stw_WS1_$endlage_minus",""); //
// map.put("OML_Stw_WS1_$endlage_plus",""); //
// map.put("OML_Stw_WS1_$gestoert_m",""); //
// map.put("OML_Stw_WS1_$gestoert_p",""); //
// map.put("OML_Stw_WS1_$keine_Endlage_minus",""); //
// map.put("OML_Stw_WS1_$keine_Endlage_plus",""); //
// map.put("OML_Stw_WS1_SM_$Sperrm_aus",""); //
        map.put("OML_Stw_WS1_SM_$Sperrm_ein","3.01.01"); //
// map.put("OML_Wecker_Block_$2_Block",""); //
// map.put("OML_Wecker_Block_$P135",""); //
// map.put("OML_Wecker_Block_$P27",""); //
// map.put("OML_Wecker_Block_$P39",""); //
// map.put("OML_Wecker_Block_$P40",""); //
// map.put("OML_Wecker_Block_$P48",""); //
// map.put("OML_Wecker_Signal_$2_Signal",""); //
// map.put("OML_Wecker_Signal_$P117",""); //
// map.put("OML_Wecker_Signal_$P12",""); //
// map.put("OML_Wecker_Signal_$P13",""); //
// map.put("OML_Wecker_Signal_$P18",""); //
// map.put("OML_Wecker_Signal_$P21",""); //
// map.put("OML_Wecker_Signal_$P22",""); //
// map.put("OML_Wecker_Signal_$P49",""); //
        map.put("OML_Wecker_Weichen_$2_Weiche","2.92.01"); //
// map.put("OML_ZB_$C_FB1",""); //
// map.put("OML_ZB_$C_FB2",""); //
// map.put("OML_ZB_$C_Halt",""); //
// map.put("OML_ZB_$cd_belegt",""); //
// map.put("OML_ZB_$D_FB1",""); //
// map.put("OML_ZB_$D_FB2",""); //
// map.put("OML_ZB_$D_Halt",""); //
// map.put("OML_ZB_$Fstr_aufloesen",""); //
// map.put("OML_ZB_$geprueft1A1",""); //
// map.put("OML_ZB_$geprueft1A2",""); //
// map.put("OML_ZB_$geprueft1E1",""); //
// map.put("OML_ZB_$geprueft1E2",""); //
// map.put("OML_ZB_$geprueft2A1",""); //
// map.put("OML_ZB_$geprueft2A2",""); //
// map.put("OML_ZB_$ZB_Grundstlg",""); //
// map.put("OML_ZB_$ZB_W1_mA1",""); //
// map.put("OML_ZB_$ZB_W1_mE1",""); //
// map.put("OML_ZB_$ZB_W1_pA2",""); //
// map.put("OML_ZB_$ZB_W1_pE2",""); //
// map.put("OML_ZB_$ZB_W2_mA1",""); //
// map.put("OML_ZB_$ZB_W2_mE1",""); //
// map.put("OML_ZB_$ZB_W2_pA2",""); //
// map.put("OML_ZB_$ZB_W2_pE2",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //

    }

}
