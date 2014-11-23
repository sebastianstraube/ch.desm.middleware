package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import org.apache.log4j.Logger;

abstract class PetrinetOmlEndpointExportBase {
    public int OML_Stw_FSS_SM_$FSS30F_reached_store;
    public int OML_Stw_FSS_SM_$FSS_30EG_reached_store;
    public int OML_ext_Vb_$F_VS_Lampe_Warn_def;
    public int OML_ext_Vb_$Ueberw_W1_minus;
    public int OML_ext_Vb_$F_VS_Lampe_Fahrt_def;
    public int OML_ext_Vb_$E_Lampe_gruenFB1_def;
    public int OML_ext_Vb_$G_VS_Lampe_Fahrt_def;
    public int OML_ext_Vb_$G_Lampe_gruenFB3_def;
    public int OML_ext_Vb_$F_Lampe_gruenFB3_def;
    public int OML_ext_Vb_$Ueberw_W1_plus;
    public int OML_ext_Vb_$G_VS_Lampe_Warn_def;
    public int OML_Kontakte_$6_FBA_nZB;
    public int OML_Kontakte_$6_RM_nZB;
    public int OML_Kontakte_$6_BLU_EG;
    public int OML_Kontakte_$6_NAL;
    public int OML_Kontakte_$8_FSS_45F;
    public int OML_Kontakte_$6_NT_W1;
    public int OML_Kontakte_$6_RM_nLN;
    public int OML_Kontakte_$6_Gleist_ZB;
    public int OML_Kontakte_$8_FSS_30F;
    public int OML_Kontakte_$8_FSS_0EGF_1;
    public int OML_Wecker_Weichen_$P1;
    public int OML_Wecker_Weichen_$2_Weiche;
    public int OML_Wecker_Signal_$P22;
    public int OML_Kontakte_$8_FSS_90EG;
    public int OML_Wecker_Signal_$P49;
    public int OML_Kontakte_$6_ISU_Sign;
    public int OML_Kontakte_$8_FSS_30EG;
    public int OML_Kontakte_$7_WS1_plus;
    public int OML_Kontakte_$6_FBF_nLN;
    public int OML_Kontakte_$6_FBA_nLN;
    public int OML_Kontakte_$7_WS1_minus;
    public int OML_Kontakte_$8_FSS_10EG;
    public int OML_Kontakte_$6_Gleist_EMM;
    public int OML_Kontakte_$8_FSS_45EG;
    public int OML_Kontakte_$7_WS1_1;
    public int OML_Kontakte_$8_FSS_10F;
    public int OML_Kontakte_$8_FSS_90F;
    public int OML_Wecker_Signal_$P117;
    public int OML_logic_Kontakte_WS1_$ws1_minus;
    public int OML_Wecker_Signal_$P18;
    public int OML_Wecker_Block_$P40;
    public int OML_logic_Kontakte_WS1_$logic_ws1_minus;
    public int OML_logic_Kontakte_WS1_$ws1_plus;
    public int OML_Wecker_Block_$P27;
    public int OML_logic_Kontakte_WS1_$logic_ws1_plus;
    public int OML_Wecker_Signal_$P13;
    public int OML_Wecker_Block_$2_Block;
    public int OML_Wecker_Block_$P39;
    public int OML_Wecker_Block_$P135;
    public int OML_Wecker_Signal_$P21;
    public int OML_Wecker_Block_$P48;
    public int OML_Wecker_Signal_$2_Signal;
    public int OML_Wecker_Signal_$P12;
    public int OML_ILTIS_$LN_1_834;
    public int OML_ILTIS_$LN_2_834;
    public int OML_ILTIS_$LN_834_1;
    public int OML_ILTIS_$festhalten_vLN;
    public int OML_ILTIS_$RM_LN_OM;
    public int OML_ILTIS_$LN_834_2;
    public int OML_ILTIS_$LN_834_5;
    public int OML_ILTIS_$freigegeben_vZB;
    public int OML_ILTIS_$RM_ZB_OM;
    public int OML_ILTIS_$EMM_833_5;
    public int OML_ILTIS_$ZB_138_2;
    public int OML_ILTIS_$ZB_1_138;
    public int OML_ILTIS_$LN_4_834;
    public int OML_ILTIS_$LN_834_4;
    public int OML_ILTIS_$festgehalten_vLN;
    public int OML_ILTIS_$freigegeben_vLN;
    public int OML_ILTIS_$freigeben_vLN;
    public int OML_ILTIS_$freigeben_vZB;
    public int OML_ILTIS_$festhalten_vZB;
    public int OML_ILTIS_$EMM_833_4;
    public int OML_ILTIS_$anfordern_vLN;
    public int OML_ILTIS_$ZB_138_1;
    public int OML_ILTIS_$anfordern_vZB;
    public int OML_ILTIS_$EMM_833_3;
    public int OML_ILTIS_$festgehalten_v_ZB;
    public int OML_ILTIS_$EMM_833_2;
    public int OML_ILTIS_$LN_834_6;
    public int OML_ILTIS_$LN_6_834;
    public int OML_ILTIS_$LN_834_3;
    public int OML_ILTIS_$ZB_2_138;
    public int OML_ILTIS_$LN_3_834;
    public int OML_ILTIS_$EMM_3_833;
    public int OML_ILTIS_$EMM_4_833;
    public int OML_ILTIS_$EMM_5_833;
    public int OML_EMM_$D_Halt;
    public int OML_EMM_$D_FB1;
    public int OML_ILTIS_$EMM_833_1;
    public int OML_ILTIS_$EMM_1_833;
    public int OML_EMM_$D_Fahrt;
    public int OML_ILTIS_$EMM_2_833;
    public int OML_LN_$LN_Grundstlg;
    public int OML_LN_$geprueft1A1;
    public int OML_LN_$LN_W2_mA4;
    public int OML_LN_$LN_W1_pA2;
    public int OML_LN_$LN_W5_mA4;
    public int OML_LN_$LN_W1_pE4;
    public int OML_LN_$LN_W2_mA5;
    public int OML_LN_$ce_belegt;
    public int OML_LN_$geprueft1A5;
    public int OML_LN_$LN_W1_pA4;
    public int OML_LN_$geprueft2A1;
    public int OML_LN_$LN_W2_mA3;
    public int OML_LN_$geprueft2A4;
    public int OML_LN_$geprueft1A3;
    public int OML_LN_$geprueft1A2;
    public int OML_LN_$LN_W1_pA3;
    public int OML_LN_$geprueft1E3;
    public int OML_LN_$LN_W2_pA2;
    public int OML_LN_$geprueft1E2;
    public int OML_LN_$geprueft2A2;
    public int OML_LN_$geprueft1E4;
    public int OML_LN_$geprueft1A4;
    public int OML_LN_$LN_W1_pA5;
    public int OML_LN_$LN_W3_pA3;
    public int OML_LN_$LN_W3_pA4;
    public int OML_LN_$LN_W5_pA3;
    public int OML_LN_$geprueft1E1;
    public int OML_LN_$LN_W4_pA5;
    public int OML_LN_$geprueft1E5;
    public int OML_LN_$LN_W3_mA5;
    public int OML_LN_$geprueft2A3;
    public int OML_LN_$LN_W1_mA1;
    public int OML_LN_$LN_W1_pA6;
    public int OML_LN_$geprueft1A6;
    public int OML_LN_$LN_W6_mA5;
    public int OML_LN_$LN_W4_pA6;
    public int OML_LN_$LN_W3_mA6;
    public int OML_LN_$LN_W6_mA6;
    public int OML_LN_$geprueft2A6;
    public int OML_LN_$LN_W2_mA6;
    public int OML_LN_$geprueft2A5;
    public int OML_LN_$LN_W5_mE4;
    public int OML_LN_$LN_W2_mE3;
    public int OML_LN_$C1_Halt;
    public int OML_LN_$C26_Halt;
    public int OML_LN_$LN_W1_pE3;
    public int OML_LN_$LN_W3_mE6;
    public int OML_LN_$LN_W2_mE6;
    public int OML_LN_$E_FB2;
    public int OML_LN_$E_Fahrt;
    public int OML_LN_$geprueft1E6;
    public int OML_LN_$e_Halt;
    public int OML_LN_$E_FB1;
    public int OML_LN_$LN_W1_mE1;
    public int OML_LN_$C26_FB1;
    public int OML_LN_$C26_FB2;
    public int OML_LN_$LN_W1_pE6;
    public int OML_LN_$C26_Fahrt;
    public int OML_LN_$LN_W4_pE5;
    public int OML_LN_$LN_W2_mE4;
    public int OML_LN_$LN_W3_pE4;
    public int OML_LN_$LN_W2_mE5;
    public int OML_LN_$LN_W3_pE3;
    public int OML_LN_$C1_Fahrt2;
    public int OML_LN_$LN_W1_pE2;
    public int OML_LN_$LN_W3_mE5;
    public int OML_LN_$LN_W4_pE6;
    public int OML_LN_$LN_W6_mE6;
    public int OML_LN_$LN_W5_pE3;
    public int OML_LN_$LN_W2_pE2;
    public int OML_LN_$LN_W1_pE5;
    public int OML_LN_$LN_W6_mE5;
    public int OML_Stw_W1_SM_$WS_Sperrm_aus;
    public int OML_Fstr_ef_$geprueft3;
    public int OML_Stw_W1_$gestoert_p;
    public int OML_Stw_W1_$Endlage_minus;
    public int OML_Fstr_ef_$P1;
    public int OML_Fstr_ef_$E_Halt;
    public int OML_Stw_FSS_SM_$NAL_pressed_store;
    public int OML_Stw_W1_$keine_Endlage_minus;
    public int OML_Stw_W1_$gestoert_m;
    public int OML_Stw_W1_SM_$WS_Sperrm_ein;
    public int OML_Fstr_ef_$geprueft2;
    public int OML_Stw_W1_$keine_Endlage_plus;
    public int OML_Fstr_ef_$P6;
    public int OML_Stw_FSS_KSM_$P324;
    public int OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
    public int OML_Stw_FSS_KSM_$P322;
    public int OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
    public int OML_Stw_W1_$Endlage_plus;
    public int OML_Fstr_ef_$E_Fahrt1;
    public int OML_Fstr_fe_$verschlossen;
    public int OML_Fstr_ef_$geprueft1;
    public int OML_Fstr_fe_$F_Halt;
    public int OML_Fstr_fe_$P1;
    public int OML_Fstr_fe_$geprueft;
    public int OML_Fstr_fe_$F_Fahrt1;
    public int OML_Fstr_fe_$gemerkt_90F;
    public int OML_Fstr_fe_$geprueft3;
    public int OML_Fstr_fe_$aufgeloest;
    public int OML_Fstr_fe_$signal_steller;
    public int OML_Fstr_fe_$prison_signal_steller;
    public int OML_Fstr_ef_$signal_steller;
    public int OML_Fstr_fe_$Zug_eingefahren;
    public int OML_Fstr_gf_$P4;
    public int OML_Fstr_ef_$prison_signal_steller;
    public int OML_Fstr_gf_$verschlossen;
    public int OML_Fstr_ef_$verschlossen;
    public int OML_Fstr_ef_$aufgeloest;
    public int OML_Fstr_ef_$gemerkt_90EB;
    public int OML_Fstr_fe_$P2;
    public int OML_Fstr_fe_$P2b;
    public int OML_Fstr_ef_$Zug_eingefahren;
    public int OML_Fstr_ef_$P2;
    public int OML_Fstr_gf_$G_Halt;
    public int OML_Fstr_gf_$G_Fahrt3;
    public int OML_Fstr_gf_$gemerkt_90EG;
    public int OML_Fstr_gf_$prison_signal_steller;
    public int OML_Fstr_gf_$geprueft2;
    public int OML_Fstr_gf_$geprueft1;
    public int OML_Fstr_gf_$aufgeloest;
    public int OML_Fstr_gf_$Zug_eingefahren;
    public int OML_Fstr_gf_$geprueft3;
    public int OML_Fstr_fg_$gemerkt_90F;
    public int OML_Fstr_fg_$prison_signal_steller;
    public int OML_Iso_ef_$Zug_einfahren;
    public int OML_Fstr_gf_$signal_steller;
    public int OML_Iso_ef_$Zug_ausfahren;
    public int OML_Iso_1_$Zug_ausfahren;
    public int OML_Fstr_fg_$geprueft0;
    public int OML_Iso_ef_$belegt;
    public int OML_Fstr_fg_$aufgeloest;
    public int OML_Fstr_fg_$Zug_eingefahren;
    public int OML_Fstr_fg_$P1;
    public int OML_Fstr_fg_$P2;
    public int OML_Iso_ef_$frei;
    public int OML_Iso_1_$Zug_einfahren;
    public int OML_Iso_1_$frei;
    public int OML_Fstr_fg_$geprueft3;
    public int OML_Fstr_fg_$F_Halt;
    public int OML_Fstr_fg_$signal_steller;
    public int OML_Fstr_fg_$geprueft1;
    public int OML_Iso_gf_$Zug_einfahren;
    public int OML_Iso_gf_$belegt;
    public int OML_Fstr_fg_$geprueft2;
    public int OML_Fstr_fg_$F_Fahrt3;
    public int OML_Iso_1_$belegt;
    public int OML_Fstr_fg_$verschlossen;
    public int OML_Iso_gf_$frei;
    public int OML_Iso_egf_$frei;
    public int OML_Iso_egf_$Zug_einfahren;
    public int OML_Iso_cd_$belegt;
    public int OML_Iso_cd_$frei;
    public int OML_Iso_cd_$Zug_einfahren;
    public int OML_Iso_gf_$Zug_ausfahren;
    public int OML_Iso_egf_$belegt;
    public int OML_Iso_egf_$Zug_ausfahren;
    public int OML_Lampen_Signal_G_$1_G_rot;
    public int OML_ZB_$EMM_Grundstlg;
    public int OML_ZB_$geprueft2A2;
    public int OML_ZB_$D_Fahrt;
    public int OML_ZB_$ZB_W2_pA2;
    public int OML_ZB_$cd_belegt;
    public int OML_Lampen_Isolierung_$Iso_1_ein;
    public int OML_Lampen_Isolierung_$Iso_cd_ein;
    public int OML_ZB_$geprueft1E2;
    public int OML_Lampen_Fahrstrasse_$1_Fstr_gf;
    public int OML_ZB_$geprueft1E1;
    public int OML_Lampen_Signal_F_$1_F_gruenFB1;
    public int OML_ZB_$geprueft1A2;
    public int OML_Lampen_Signal_F_$1_F_gruenFB3;
    public int OML_Lampen_Isolierung_$Iso_ef_ein;
    public int OML_ZB_$ZB_W2_mA1;
    public int OML_ZB_$geprueft1A1;
    public int OML_Lampen_Isolierung_$Iso_egf_ein;
    public int OML_Lampen_Signal_G_$1_G_gruenFB3;
    public int OML_Lampen_Signal_E_$1_E_gruenFB1;
    public int OML_Lampen_Signal_G_$1_G_gruenFB1;
    public int OML_ZB_$C_Fahrt;
    public int OML_ZB_$ZB_W2_mE1;
    public int OML_ZB_$ZB_W2_pE2;
    public int OML_ZB_$D_Halt;
    public int OML_ZB_$C_Halt;
    public int OML_ZB_$geprueft2A1;
    public int OML_ZB_$ZB_W1_pE2;
    public int OML_Lampen_Signal_F_$1_F_rot;
    public int OML_ZB_$ZB_W1_mE1;
    public int OML_Lampen_Signal_E_$1_E_rot;
    public int OML_EMM_$EMM_W10_pA1;
    public int OML_ZB_$ZB_W1_mA1;
    public int OML_EMM_$EMM_W7_mA1;
    public int OML_ZB_$ZB_W1_pA2;
    public int OML_ZB_$D_FB2;
    public int OML_ZB_$C_FB2;
    public int OML_ZB_$D_FB1;
    public int OML_EMM_EMM_Grundstlg;
    public int OML_ZB_$C_FB1;
    public int OML_EMM_$geprueft1A1;
    public int OML_BL_OM_LN_$RMM_nLN;
    public int OML_BL_OM_LN_$belegt_v;
    public int OML_BL_ZB_OM_$belegt_n;
    public int OML_BL_OM_LN_$Grundstlg_v;
    public int OML_BL_ZB_OM_$belegt_v;
    public int OML_BL_ZB_OM_$Grundstlg_v;
    public int OML_BL_OM_LN_$3;
    public int OML_BL_ZB_OM_$vorgebl_n;
    public int OML_Lampen_WS1_$1_WS1_Freig;
    public int OML_BL_ZB_OM_$1;
    public int OML_Lampen_Stoerung_$1_G_VS_Stoer;
    public int OML_Lampen_Fahrstrasse_$1_Fstr_ef;
    public int OML_BL_OM_LN_$vorgebl_n;
    public int OML_BL_ZB_OM_$RMM_nZB;
    public int OML_BL_ZB_OM_$3;
    public int OML_Lampen_WS1_$1_WS1_Ueberw;
    public int OML_BL_OM_LN_$belegt_n;
    public int OML_Lampen_Streckenblock_$1_BL_vLN_weiss;
    public int OML_BL_ZB_OM_$Grundstlg_n;
    public int OML_BL_OM_LN_$Grundstlg_n;
    public int OML_BL_OM_LN_$1;
    public int OML_BL_ZB_OM_$2;
    public int OML_BL_OM_LN_$2;
    public int OML_Lampen_Stoerung_$1_F_VS_Stoer;
    public int OML_BL_ZB_OM_$vorgebl_v;
    public int OML_Iso_cd_$Zug_ausfahren;
    public int OML_BL_OM_LN_$vorgebl_v;
    public int OML_Lampen_Streckenblock_$1_FBV_vZB;
    public int OML_Lampen_Streckenblock_$1_BL_vZB_weiss;
    public int OML_Lampen_Streckenblock_$1_BL_nZB_rot;
    public int OML_Lampen_Streckenblock_$1_BL_vZB_rot;
    public int OML_Lampen_Streckenblock_$1_BL_nZB_weiss;
    public int OML_Lampen_Streckenblock_$1_BL_nLN_weiss;
    public int OML_Lampen_Streckenblock_$1_BL_nLN_rot;
    public int OML_Lampen_Streckenblock_$1_BL_vLN_rot;
    public int OML_Lampen_Streckenblock_$1_FBV_vLN;
    public int OML_EMM_$geprueft1E5;
    public int OML_EMM_$EMM_W8_pE4;
    public int OML_EMM_$C_Halt;
    public int OML_EMM_$EMM_W8_pA4;
    public int OML_EMM_$geprueft1E2;
    public int OML_EMM_$EMM_W9_mE4;
    public int OML_EMM_$geprueft1A4;
    public int OML_EMM_$EMM_W7_mE1;
    public int OML_EMM_$EMM_W9_pE3;
    public int OML_EMM_$geprueft2A5;
    public int OML_EMM_$geprueft1E1;
    public int OML_EMM_$geprueft1E4;
    public int OML_EMM_$EMM_W8_mE5;
    public int OML_EMM_$EMM_W10_mA4;
    public int OML_EMM_$EMM_W10_mE4;
    public int OML_EMM_$EMM_W10_mE5;
    public int OML_EMM_$C_FB1;
    public int OML_EMM_$EMM_W9_mE5;
    public int OML_EMM_$D_FB2;
    public int OML_EMM_$geprueft1A5;
    public int OML_EMM_$EMM_W9_mA4;
    public int OML_EMM_$EMM_W9_mA5;
    public int OML_EMM_$EMM_W8_mA5;
    public int OML_EMM_$EMM_W10_pE1;
    public int OML_EMM_$geprueft1E3;
    public int OML_EMM_$EMM_W10_pE2;
    public int OML_EMM_$EMM_W7_pE2;
    public int OML_EMM_$EMM_W10_mA5;
    public int OML_EMM_$EMM_W10_mE3;
    public int OML_EMM_$C_FB2;
    public int OML_EMM_$C_Fahrt;
    public int OML_EMM_$geprueft2A4;
    public int OML_EMM_$geprueft2A1;
    public int OML_EMM_$geprueft1A3;
    public int OML_EMM_$EMM_W10_pA2;
    public int OML_EMM_$geprueft2A2;
    public int OML_EMM_$EMM_W10_mA3;
    public int OML_EMM_$geprueft2A3;
    public int OML_EMM_$EMM_W9_pA3;
    public int OML_EMM_$geprueft1A2;
    public int OML_EMM_$EMM_W7_pA2;
    public int OML_Stw_FSS_SM_$FSS_Sperrm_ein;
    public int OML_Stw_FSS_SM_$FSS_Sperrm_aus;

    //unused places
    public int OML_Lampen_Stoerung_$1_Stoer_Wecker;
    public int OML_ILTIS_$LN_5_834;
    public int OML_ext_Vb_$FBZ_vLN;
    public int OML_ext_Vb_$RM_vLN;
    public int OML_ext_Vb_$FBZ_vZB;
    public int OML_ext_Vb_$RM_vZB;
    public int OML_ext_Vb_$FBA_vEMM;
    public int OML_ext_Vb_$vorblocken_vLN;
    public int OML_ext_Vb_$abl_vEMM;
    public int OML_ext_Vb_$abl_vLN;
    public int OML_ext_Vb_$abl_vZB;
    public int OML_ext_Vb_$abl_nEMM;
    public int OML_ext_Vb_$abl_nLN;
    public int OML_ext_Vb_$abl_nZB;
    public int OML_ext_Vb_$Ueberw_def_aus;
    public int OML_ext_Vb_$Stellstrom_def_aus;
    public int OML_ext_Vb_$F_Lampe_rot_def;
    public int OML_ext_Vb_$D_Lamt_def;
    public int OML_ext_Vb_$E_Lampe_rot_def;
    public int OML_ext_Vb_$G_Lampe_rot_def;
    public int OML_ext_Vb_$blocken_vLN;
    public int OML_ext_Vb_$blocken_vZB;
    public int OML_ext_Vb_$vorblocken_vZB;
    public int OML_Kontakte_$6_FBF_nZB;
    public int OML_Kontakte_$6_Anf_Durchf_nEMM;
    public int OML_Kontakte_$6_Wecker_absch;
    public int OML_Kontakte_$6_Wbel_ein;
    public int OML_Kontakte_$6_Zeitsch_Umg;
    public int OML_Kontakte_$8_FSS_0EGF;
    public int OML_Kontakte_$8_FSS_1EGF;
    public int OML_Kontakte_$8_FSS_80EG;
    public int OML_Kontakte_$8_FSS_80F;

    public void main() {
        init();
        for(;;) {
            readSensors();
            while(fireOneTransition()) {
                writeActors();
            }
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean canFire(String s) {
        return true;
    }

    public void fire(String s) {
        System.out.println(s);
    }

    public void readSensors() {
        //OML_ext_Vb_$F_VS_Lampe_Warn_def = ?
        //OML_ext_Vb_$Ueberw_W1_minus = ?
        //OML_ext_Vb_$F_VS_Lampe_Fahrt_def = ?
        //OML_ext_Vb_$E_Lampe_gruenFB1_def = ?
        //OML_ext_Vb_$G_VS_Lampe_Fahrt_def = ?
        //OML_ext_Vb_$G_Lampe_gruenFB3_def = ?
        //OML_ext_Vb_$F_Lampe_gruenFB3_def = ?
        //OML_ext_Vb_$Ueberw_W1_plus = ?
        //OML_ext_Vb_$G_VS_Lampe_Warn_def = ?
        //OML_Kontakte_$6_FBA_nZB = ?
        //OML_Kontakte_$6_RM_nZB = ?
        //OML_Kontakte_$6_BLU_EG = ?
        //OML_Kontakte_$6_NAL = ?
        //OML_Kontakte_$8_FSS_45F = ?
        //OML_Kontakte_$6_NT_W1 = ?
        //OML_Kontakte_$6_RM_nLN = ?
        //OML_Kontakte_$6_Gleist_ZB = ?
        //OML_Kontakte_$8_FSS_30F = ?
        //OML_Kontakte_$8_FSS_0EGF_1 = ?
        //OML_Kontakte_$8_FSS_90EG = ?
        //OML_Kontakte_$6_ISU_Sign = ?
        //OML_Kontakte_$8_FSS_30EG = ?
        //OML_Kontakte_$6_FBF_nLN = ?
        //OML_Kontakte_$6_FBA_nLN = ?
        //OML_Kontakte_$8_FSS_10EG = ?
        //OML_Kontakte_$6_Gleist_EMM = ?
        //OML_Kontakte_$8_FSS_45EG = ?
        //OML_Kontakte_$7_WS1_1 = ?
        //OML_Kontakte_$8_FSS_10F = ?
        //OML_Kontakte_$8_FSS_90F = ?
        //OML_logic_Kontakte_WS1_$ws1_minus = ?
        //OML_logic_Kontakte_WS1_$ws1_plus = ?
        //OML_ILTIS_$LN_1_834 = ?
        //OML_ILTIS_$LN_2_834 = ?
        //OML_ILTIS_$LN_834_1 = ?
        //OML_ILTIS_$festhalten_vLN = ?
        //OML_ILTIS_$RM_LN_OM = ?
        //OML_ILTIS_$LN_834_2 = ?
        //OML_ILTIS_$LN_834_5 = ?
        //OML_ILTIS_$RM_ZB_OM = ?
        //OML_ILTIS_$EMM_833_5 = ?
        //OML_ILTIS_$ZB_138_2 = ?
        //OML_ILTIS_$ZB_1_138 = ?
        //OML_ILTIS_$LN_4_834 = ?
        //OML_ILTIS_$LN_834_4 = ?
        //OML_ILTIS_$freigeben_vLN = ?
        //OML_ILTIS_$freigeben_vZB = ?
        //OML_ILTIS_$festhalten_vZB = ?
        //OML_ILTIS_$EMM_833_4 = ?
        //OML_ILTIS_$anfordern_vLN = ?
        //OML_ILTIS_$ZB_138_1 = ?
        //OML_ILTIS_$anfordern_vZB = ?
        //OML_ILTIS_$EMM_833_3 = ?
        //OML_ILTIS_$EMM_833_2 = ?
        //OML_ILTIS_$LN_834_6 = ?
        //OML_ILTIS_$LN_6_834 = ?
        //OML_ILTIS_$LN_834_3 = ?
        //OML_ILTIS_$ZB_2_138 = ?
        //OML_ILTIS_$LN_3_834 = ?
        //OML_ILTIS_$EMM_3_833 = ?
        //OML_ILTIS_$EMM_4_833 = ?
        //OML_ILTIS_$EMM_5_833 = ?
        //OML_ILTIS_$EMM_833_1 = ?
        //OML_ILTIS_$EMM_1_833 = ?
        //OML_ILTIS_$EMM_2_833 = ?
        //OML_LN_$ce_belegt = ?
        //OML_Iso_ef_$Zug_einfahren = ?
        //OML_Iso_ef_$Zug_ausfahren = ?
        //OML_Iso_1_$Zug_ausfahren = ?
        //OML_Iso_1_$Zug_einfahren = ?
        //OML_Iso_gf_$Zug_einfahren = ?
        //OML_Iso_egf_$Zug_einfahren = ?
        //OML_Iso_cd_$Zug_einfahren = ?
        //OML_Iso_gf_$Zug_ausfahren = ?
        //OML_Iso_egf_$Zug_ausfahren = ?
        //OML_ZB_$cd_belegt = ?
        //OML_Iso_cd_$Zug_ausfahren = ?
    }
    public void writeActors() {
        //myData.OML_EMM_$D_FB1 = OML_EMM_$D_FB1;
        OML_EMM_$D_FB1 = 0;
        //myData.OML_LN_$E_FB2 = OML_LN_$E_FB2;
        OML_LN_$E_FB2 = 0;
        //myData.OML_LN_$E_FB1 = OML_LN_$E_FB1;
        OML_LN_$E_FB1 = 0;
        //myData.OML_LN_$C26_FB1 = OML_LN_$C26_FB1;
        OML_LN_$C26_FB1 = 0;
        //myData.OML_LN_$C26_FB2 = OML_LN_$C26_FB2;
        OML_LN_$C26_FB2 = 0;
        //myData.OML_ZB_$D_FB2 = OML_ZB_$D_FB2;
        OML_ZB_$D_FB2 = 0;
        //myData.OML_ZB_$C_FB2 = OML_ZB_$C_FB2;
        OML_ZB_$C_FB2 = 0;
        //myData.OML_ZB_$D_FB1 = OML_ZB_$D_FB1;
        OML_ZB_$D_FB1 = 0;
        //myData.OML_ZB_$C_FB1 = OML_ZB_$C_FB1;
        OML_ZB_$C_FB1 = 0;
        //myData.OML_EMM_$C_FB1 = OML_EMM_$C_FB1;
        OML_EMM_$C_FB1 = 0;
        //myData.OML_EMM_$D_FB2 = OML_EMM_$D_FB2;
        OML_EMM_$D_FB2 = 0;
        //myData.OML_EMM_$C_FB2 = OML_EMM_$C_FB2;
        OML_EMM_$C_FB2 = 0;
    }
    public void init() {
        OML_Stw_FSS_SM_$FSS30F_reached_store = 0;
        OML_Stw_FSS_SM_$FSS_30EG_reached_store = 0;
        OML_ext_Vb_$F_VS_Lampe_Warn_def = 0;
        OML_ext_Vb_$Ueberw_W1_minus = 1;
        OML_ext_Vb_$F_VS_Lampe_Fahrt_def = 0;
        OML_ext_Vb_$E_Lampe_gruenFB1_def = 0;
        OML_ext_Vb_$G_VS_Lampe_Fahrt_def = 0;
        OML_ext_Vb_$G_Lampe_gruenFB3_def = 0;
        OML_ext_Vb_$F_Lampe_gruenFB3_def = 0;
        OML_ext_Vb_$Ueberw_W1_plus = 1;
        OML_ext_Vb_$G_VS_Lampe_Warn_def = 0;
        OML_Kontakte_$6_FBA_nZB = 0;
        OML_Kontakte_$6_RM_nZB = 0;
        OML_Kontakte_$6_BLU_EG = 0;
        OML_Kontakte_$6_NAL = 0;
        OML_Kontakte_$8_FSS_45F = 0;
        OML_Kontakte_$6_NT_W1 = 0;
        OML_Kontakte_$6_RM_nLN = 0;
        OML_Kontakte_$6_Gleist_ZB = 0;
        OML_Kontakte_$8_FSS_30F = 0;
        OML_Kontakte_$8_FSS_0EGF_1 = 0;
        OML_Wecker_Weichen_$P1 = 0;
        OML_Wecker_Weichen_$2_Weiche = 0;
        OML_Wecker_Signal_$P22 = 0;
        OML_Kontakte_$8_FSS_90EG = 0;
        OML_Wecker_Signal_$P49 = 0;
        OML_Kontakte_$6_ISU_Sign = 0;
        OML_Kontakte_$8_FSS_30EG = 0;
        OML_Kontakte_$7_WS1_plus = 0;
        OML_Kontakte_$6_FBF_nLN = 0;
        OML_Kontakte_$6_FBA_nLN = 0;
        OML_Kontakte_$7_WS1_minus = 0;
        OML_Kontakte_$8_FSS_10EG = 0;
        OML_Kontakte_$6_Gleist_EMM = 0;
        OML_Kontakte_$8_FSS_45EG = 0;
        OML_Kontakte_$7_WS1_1 = 0;
        OML_Kontakte_$8_FSS_10F = 0;
        OML_Kontakte_$8_FSS_90F = 0;
        OML_Wecker_Signal_$P117 = 0;
        OML_logic_Kontakte_WS1_$ws1_minus = 0;
        OML_Wecker_Signal_$P18 = 0;
        OML_Wecker_Block_$P40 = 0;
        OML_logic_Kontakte_WS1_$logic_ws1_minus = 0;
        OML_logic_Kontakte_WS1_$ws1_plus = 0;
        OML_Wecker_Block_$P27 = 0;
        OML_logic_Kontakte_WS1_$logic_ws1_plus = 0;
        OML_Wecker_Signal_$P13 = 0;
        OML_Wecker_Block_$2_Block = 0;
        OML_Wecker_Block_$P39 = 0;
        OML_Wecker_Block_$P135 = 0;
        OML_Wecker_Signal_$P21 = 0;
        OML_Wecker_Block_$P48 = 0;
        OML_Wecker_Signal_$2_Signal = 0;
        OML_Wecker_Signal_$P12 = 0;
        OML_ILTIS_$LN_1_834 = 0;
        OML_ILTIS_$LN_2_834 = 0;
        OML_ILTIS_$LN_834_1 = 0;
        OML_ILTIS_$festhalten_vLN = 0;
        OML_ILTIS_$RM_LN_OM = 0;
        OML_ILTIS_$LN_834_2 = 0;
        OML_ILTIS_$LN_834_5 = 0;
        OML_ILTIS_$freigegeben_vZB = 1;
        OML_ILTIS_$RM_ZB_OM = 0;
        OML_ILTIS_$EMM_833_5 = 0;
        OML_ILTIS_$ZB_138_2 = 0;
        OML_ILTIS_$ZB_1_138 = 0;
        OML_ILTIS_$LN_4_834 = 0;
        OML_ILTIS_$LN_834_4 = 0;
        OML_ILTIS_$festgehalten_vLN = 0;
        OML_ILTIS_$freigegeben_vLN = 1;
        OML_ILTIS_$freigeben_vLN = 0;
        OML_ILTIS_$freigeben_vZB = 0;
        OML_ILTIS_$festhalten_vZB = 0;
        OML_ILTIS_$EMM_833_4 = 0;
        OML_ILTIS_$anfordern_vLN = 0;
        OML_ILTIS_$ZB_138_1 = 0;
        OML_ILTIS_$anfordern_vZB = 0;
        OML_ILTIS_$EMM_833_3 = 0;
        OML_ILTIS_$festgehalten_v_ZB = 0;
        OML_ILTIS_$EMM_833_2 = 0;
        OML_ILTIS_$LN_834_6 = 0;
        OML_ILTIS_$LN_6_834 = 0;
        OML_ILTIS_$LN_834_3 = 0;
        OML_ILTIS_$ZB_2_138 = 0;
        OML_ILTIS_$LN_3_834 = 0;
        OML_ILTIS_$EMM_3_833 = 0;
        OML_ILTIS_$EMM_4_833 = 0;
        OML_ILTIS_$EMM_5_833 = 0;
        OML_EMM_$D_Halt = 1;
        OML_EMM_$D_FB1 = 0;
        OML_ILTIS_$EMM_833_1 = 0;
        OML_ILTIS_$EMM_1_833 = 0;
        OML_EMM_$D_Fahrt = 0;
        OML_ILTIS_$EMM_2_833 = 0;
        OML_LN_$LN_Grundstlg = 0;
        OML_LN_$geprueft1A1 = 0;
        OML_LN_$LN_W2_mA4 = 0;
        OML_LN_$LN_W1_pA2 = 0;
        OML_LN_$LN_W5_mA4 = 0;
        OML_LN_$LN_W1_pE4 = 0;
        OML_LN_$LN_W2_mA5 = 0;
        OML_LN_$ce_belegt = 0;
        OML_LN_$geprueft1A5 = 0;
        OML_LN_$LN_W1_pA4 = 0;
        OML_LN_$geprueft2A1 = 0;
        OML_LN_$LN_W2_mA3 = 0;
        OML_LN_$geprueft2A4 = 0;
        OML_LN_$geprueft1A3 = 0;
        OML_LN_$geprueft1A2 = 0;
        OML_LN_$LN_W1_pA3 = 0;
        OML_LN_$geprueft1E3 = 0;
        OML_LN_$LN_W2_pA2 = 0;
        OML_LN_$geprueft1E2 = 0;
        OML_LN_$geprueft2A2 = 0;
        OML_LN_$geprueft1E4 = 0;
        OML_LN_$geprueft1A4 = 0;
        OML_LN_$LN_W1_pA5 = 0;
        OML_LN_$LN_W3_pA3 = 0;
        OML_LN_$LN_W3_pA4 = 0;
        OML_LN_$LN_W5_pA3 = 0;
        OML_LN_$geprueft1E1 = 0;
        OML_LN_$LN_W4_pA5 = 0;
        OML_LN_$geprueft1E5 = 0;
        OML_LN_$LN_W3_mA5 = 0;
        OML_LN_$geprueft2A3 = 0;
        OML_LN_$LN_W1_mA1 = 0;
        OML_LN_$LN_W1_pA6 = 0;
        OML_LN_$geprueft1A6 = 0;
        OML_LN_$LN_W6_mA5 = 0;
        OML_LN_$LN_W4_pA6 = 0;
        OML_LN_$LN_W3_mA6 = 0;
        OML_LN_$LN_W6_mA6 = 0;
        OML_LN_$geprueft2A6 = 0;
        OML_LN_$LN_W2_mA6 = 0;
        OML_LN_$geprueft2A5 = 0;
        OML_LN_$LN_W5_mE4 = 0;
        OML_LN_$LN_W2_mE3 = 0;
        OML_LN_$C1_Halt = 1;
        OML_LN_$C26_Halt = 1;
        OML_LN_$LN_W1_pE3 = 0;
        OML_LN_$LN_W3_mE6 = 0;
        OML_LN_$LN_W2_mE6 = 0;
        OML_LN_$E_FB2 = 0;
        OML_LN_$E_Fahrt = 0;
        OML_LN_$geprueft1E6 = 0;
        OML_LN_$e_Halt = 1;
        OML_LN_$E_FB1 = 0;
        OML_LN_$LN_W1_mE1 = 0;
        OML_LN_$C26_FB1 = 0;
        OML_LN_$C26_FB2 = 0;
        OML_LN_$LN_W1_pE6 = 0;
        OML_LN_$C26_Fahrt = 0;
        OML_LN_$LN_W4_pE5 = 0;
        OML_LN_$LN_W2_mE4 = 0;
        OML_LN_$LN_W3_pE4 = 0;
        OML_LN_$LN_W2_mE5 = 0;
        OML_LN_$LN_W3_pE3 = 0;
        OML_LN_$C1_Fahrt2 = 0;
        OML_LN_$LN_W1_pE2 = 0;
        OML_LN_$LN_W3_mE5 = 0;
        OML_LN_$LN_W4_pE6 = 0;
        OML_LN_$LN_W6_mE6 = 0;
        OML_LN_$LN_W5_pE3 = 0;
        OML_LN_$LN_W2_pE2 = 0;
        OML_LN_$LN_W1_pE5 = 0;
        OML_LN_$LN_W6_mE5 = 0;
        OML_Stw_W1_SM_$WS_Sperrm_aus = 1;
        OML_Fstr_ef_$geprueft3 = 0;
        OML_Stw_W1_$gestoert_p = 0;
        OML_Stw_W1_$Endlage_minus = 0;
        OML_Fstr_ef_$P1 = 0;
        OML_Fstr_ef_$E_Halt = 1;
        OML_Stw_FSS_SM_$NAL_pressed_store = 0;
        OML_Stw_W1_$keine_Endlage_minus = 0;
        OML_Stw_W1_$gestoert_m = 0;
        OML_Stw_W1_SM_$WS_Sperrm_ein = 0;
        OML_Fstr_ef_$geprueft2 = 0;
        OML_Stw_W1_$keine_Endlage_plus = 0;
        OML_Fstr_ef_$P6 = 0;
        OML_Stw_FSS_KSM_$P324 = 0;
        OML_Stw_FSS_KSM_$FSS_Kuppelm_aus = 1;
        OML_Stw_FSS_KSM_$P322 = 0;
        OML_Stw_FSS_KSM_$FSS_Kuppelm_ein = 0;
        OML_Stw_W1_$Endlage_plus = 1;
        OML_Fstr_ef_$E_Fahrt1 = 0;
        OML_Fstr_fe_$verschlossen = 0;
        OML_Fstr_ef_$geprueft1 = 0;
        OML_Fstr_fe_$F_Halt = 1;
        OML_Fstr_fe_$P1 = 0;
        OML_Fstr_fe_$geprueft = 0;
        OML_Fstr_fe_$F_Fahrt1 = 0;
        OML_Fstr_fe_$gemerkt_90F = 0;
        OML_Fstr_fe_$geprueft3 = 0;
        OML_Fstr_fe_$aufgeloest = 1;
        OML_Fstr_fe_$signal_steller = 0;
        OML_Fstr_fe_$prison_signal_steller = 0;
        OML_Fstr_ef_$signal_steller = 0;
        OML_Fstr_fe_$Zug_eingefahren = 0;
        OML_Fstr_gf_$P4 = 0;
        OML_Fstr_ef_$prison_signal_steller = 0;
        OML_Fstr_gf_$verschlossen = 0;
        OML_Fstr_ef_$verschlossen = 0;
        OML_Fstr_ef_$aufgeloest = 1;
        OML_Fstr_ef_$gemerkt_90EB = 0;
        OML_Fstr_fe_$P2 = 0;
        OML_Fstr_fe_$P2b = 0;
        OML_Fstr_ef_$Zug_eingefahren = 0;
        OML_Fstr_ef_$P2 = 0;
        OML_Fstr_gf_$G_Halt = 1;
        OML_Fstr_gf_$G_Fahrt3 = 0;
        OML_Fstr_gf_$gemerkt_90EG = 0;
        OML_Fstr_gf_$prison_signal_steller = 0;
        OML_Fstr_gf_$geprueft2 = 0;
        OML_Fstr_gf_$geprueft1 = 0;
        OML_Fstr_gf_$aufgeloest = 1;
        OML_Fstr_gf_$Zug_eingefahren = 0;
        OML_Fstr_gf_$geprueft3 = 0;
        OML_Fstr_fg_$gemerkt_90F = 0;
        OML_Fstr_fg_$prison_signal_steller = 0;
        OML_Iso_ef_$Zug_einfahren = 0;
        OML_Fstr_gf_$signal_steller = 0;
        OML_Iso_ef_$Zug_ausfahren = 0;
        OML_Iso_1_$Zug_ausfahren = 0;
        OML_Fstr_fg_$geprueft0 = 0;
        OML_Iso_ef_$belegt = 0;
        OML_Fstr_fg_$aufgeloest = 1;
        OML_Fstr_fg_$Zug_eingefahren = 0;
        OML_Fstr_fg_$P1 = 0;
        OML_Fstr_fg_$P2 = 0;
        OML_Iso_ef_$frei = 1;
        OML_Iso_1_$Zug_einfahren = 0;
        OML_Iso_1_$frei = 1;
        OML_Fstr_fg_$geprueft3 = 0;
        OML_Fstr_fg_$F_Halt = 1;
        OML_Fstr_fg_$signal_steller = 0;
        OML_Fstr_fg_$geprueft1 = 0;
        OML_Iso_gf_$Zug_einfahren = 0;
        OML_Iso_gf_$belegt = 0;
        OML_Fstr_fg_$geprueft2 = 0;
        OML_Fstr_fg_$F_Fahrt3 = 0;
        OML_Iso_1_$belegt = 0;
        OML_Fstr_fg_$verschlossen = 0;
        OML_Iso_gf_$frei = 1;
        OML_Iso_egf_$frei = 1;
        OML_Iso_egf_$Zug_einfahren = 0;
        OML_Iso_cd_$belegt = 0;
        OML_Iso_cd_$frei = 1;
        OML_Iso_cd_$Zug_einfahren = 0;
        OML_Iso_gf_$Zug_ausfahren = 0;
        OML_Iso_egf_$belegt = 0;
        OML_Iso_egf_$Zug_ausfahren = 0;
        OML_Lampen_Signal_G_$1_G_rot = 0;
        OML_ZB_$EMM_Grundstlg = 0;
        OML_ZB_$geprueft2A2 = 0;
        OML_ZB_$D_Fahrt = 0;
        OML_ZB_$ZB_W2_pA2 = 0;
        OML_ZB_$cd_belegt = 0;
        OML_Lampen_Isolierung_$Iso_1_ein = 0;
        OML_Lampen_Isolierung_$Iso_cd_ein = 0;
        OML_ZB_$geprueft1E2 = 0;
        OML_Lampen_Fahrstrasse_$1_Fstr_gf = 0;
        OML_ZB_$geprueft1E1 = 0;
        OML_Lampen_Signal_F_$1_F_gruenFB1 = 0;
        OML_ZB_$geprueft1A2 = 0;
        OML_Lampen_Signal_F_$1_F_gruenFB3 = 0;
        OML_Lampen_Isolierung_$Iso_ef_ein = 0;
        OML_ZB_$ZB_W2_mA1 = 0;
        OML_ZB_$geprueft1A1 = 0;
        OML_Lampen_Isolierung_$Iso_egf_ein = 0;
        OML_Lampen_Signal_G_$1_G_gruenFB3 = 0;
        OML_Lampen_Signal_E_$1_E_gruenFB1 = 0;
        OML_Lampen_Signal_G_$1_G_gruenFB1 = 0;
        OML_ZB_$C_Fahrt = 0;
        OML_ZB_$ZB_W2_mE1 = 0;
        OML_ZB_$ZB_W2_pE2 = 0;
        OML_ZB_$D_Halt = 1;
        OML_ZB_$C_Halt = 1;
        OML_ZB_$geprueft2A1 = 0;
        OML_ZB_$ZB_W1_pE2 = 0;
        OML_Lampen_Signal_F_$1_F_rot = 0;
        OML_ZB_$ZB_W1_mE1 = 0;
        OML_Lampen_Signal_E_$1_E_rot = 0;
        OML_EMM_$EMM_W10_pA1 = 0;
        OML_ZB_$ZB_W1_mA1 = 0;
        OML_EMM_$EMM_W7_mA1 = 0;
        OML_ZB_$ZB_W1_pA2 = 0;
        OML_ZB_$D_FB2 = 0;
        OML_ZB_$C_FB2 = 0;
        OML_ZB_$D_FB1 = 0;
        OML_EMM_EMM_Grundstlg = 1;
        OML_ZB_$C_FB1 = 0;
        OML_EMM_$geprueft1A1 = 0;
        OML_BL_OM_LN_$RMM_nLN = 0;
        OML_BL_OM_LN_$belegt_v = 0;
        OML_BL_ZB_OM_$belegt_n = 0;
        OML_BL_OM_LN_$Grundstlg_v = 0;
        OML_BL_ZB_OM_$belegt_v = 0;
        OML_BL_ZB_OM_$Grundstlg_v = 0;
        OML_BL_OM_LN_$3 = 0;
        OML_BL_ZB_OM_$vorgebl_n = 0;
        OML_Lampen_WS1_$1_WS1_Freig = 0;
        OML_BL_ZB_OM_$1 = 0;
        OML_Lampen_Stoerung_$1_G_VS_Stoer = 0;
        OML_Lampen_Fahrstrasse_$1_Fstr_ef = 0;
        OML_BL_OM_LN_$vorgebl_n = 0;
        OML_BL_ZB_OM_$RMM_nZB = 0;
        OML_BL_ZB_OM_$3 = 0;
        OML_Lampen_WS1_$1_WS1_Ueberw = 0;
        OML_BL_OM_LN_$belegt_n = 0;
        OML_Lampen_Streckenblock_$1_BL_vLN_weiss = 0;
        OML_BL_ZB_OM_$Grundstlg_n = 1;
        OML_BL_OM_LN_$Grundstlg_n = 1;
        OML_BL_OM_LN_$1 = 0;
        OML_BL_ZB_OM_$2 = 0;
        OML_BL_OM_LN_$2 = 0;
        OML_Lampen_Stoerung_$1_F_VS_Stoer = 0;
        OML_BL_ZB_OM_$vorgebl_v = 0;
        OML_Iso_cd_$Zug_ausfahren = 0;
        OML_BL_OM_LN_$vorgebl_v = 0;
        OML_Lampen_Streckenblock_$1_FBV_vZB = 0;
        OML_Lampen_Streckenblock_$1_BL_vZB_weiss = 0;
        OML_Lampen_Streckenblock_$1_BL_nZB_rot = 0;
        OML_Lampen_Streckenblock_$1_BL_vZB_rot = 0;
        OML_Lampen_Streckenblock_$1_BL_nZB_weiss = 0;
        OML_Lampen_Streckenblock_$1_BL_nLN_weiss = 0;
        OML_Lampen_Streckenblock_$1_BL_nLN_rot = 0;
        OML_Lampen_Streckenblock_$1_BL_vLN_rot = 0;
        OML_Lampen_Streckenblock_$1_FBV_vLN = 0;
        OML_EMM_$geprueft1E5 = 0;
        OML_EMM_$EMM_W8_pE4 = 0;
        OML_EMM_$C_Halt = 1;
        OML_EMM_$EMM_W8_pA4 = 0;
        OML_EMM_$geprueft1E2 = 0;
        OML_EMM_$EMM_W9_mE4 = 0;
        OML_EMM_$geprueft1A4 = 0;
        OML_EMM_$EMM_W7_mE1 = 0;
        OML_EMM_$EMM_W9_pE3 = 0;
        OML_EMM_$geprueft2A5 = 0;
        OML_EMM_$geprueft1E1 = 0;
        OML_EMM_$geprueft1E4 = 0;
        OML_EMM_$EMM_W8_mE5 = 0;
        OML_EMM_$EMM_W10_mA4 = 0;
        OML_EMM_$EMM_W10_mE4 = 0;
        OML_EMM_$EMM_W10_mE5 = 0;
        OML_EMM_$C_FB1 = 0;
        OML_EMM_$EMM_W9_mE5 = 0;
        OML_EMM_$D_FB2 = 0;
        OML_EMM_$geprueft1A5 = 0;
        OML_EMM_$EMM_W9_mA4 = 0;
        OML_EMM_$EMM_W9_mA5 = 0;
        OML_EMM_$EMM_W8_mA5 = 0;
        OML_EMM_$EMM_W10_pE1 = 0;
        OML_EMM_$geprueft1E3 = 0;
        OML_EMM_$EMM_W10_pE2 = 0;
        OML_EMM_$EMM_W7_pE2 = 0;
        OML_EMM_$EMM_W10_mA5 = 0;
        OML_EMM_$EMM_W10_mE3 = 0;
        OML_EMM_$C_FB2 = 0;
        OML_EMM_$C_Fahrt = 0;
        OML_EMM_$geprueft2A4 = 0;
        OML_EMM_$geprueft2A1 = 0;
        OML_EMM_$geprueft1A3 = 0;
        OML_EMM_$EMM_W10_pA2 = 0;
        OML_EMM_$geprueft2A2 = 0;
        OML_EMM_$EMM_W10_mA3 = 0;
        OML_EMM_$geprueft2A3 = 0;
        OML_EMM_$EMM_W9_pA3 = 0;
        OML_EMM_$geprueft1A2 = 0;
        OML_EMM_$EMM_W7_pA2 = 0;
        OML_Stw_FSS_SM_$FSS_Sperrm_ein = 0;
        OML_Stw_FSS_SM_$FSS_Sperrm_aus = 1;
        OML_Lampen_Stoerung_$1_Stoer_Wecker = 0;
        OML_ILTIS_$LN_5_834 = 0;
        OML_ext_Vb_$FBZ_vLN = 0;
        OML_ext_Vb_$RM_vLN = 0;
        OML_ext_Vb_$FBZ_vZB = 0;
        OML_ext_Vb_$RM_vZB = 0;
        OML_ext_Vb_$FBA_vEMM = 0;
        OML_ext_Vb_$vorblocken_vLN = 0;
        OML_ext_Vb_$abl_vEMM = 0;
        OML_ext_Vb_$abl_vLN = 0;
        OML_ext_Vb_$abl_vZB = 0;
        OML_ext_Vb_$abl_nEMM = 0;
        OML_ext_Vb_$abl_nLN = 0;
        OML_ext_Vb_$abl_nZB = 0;
        OML_ext_Vb_$Ueberw_def_aus = 0;
        OML_ext_Vb_$Stellstrom_def_aus = 0;
        OML_ext_Vb_$F_Lampe_rot_def = 0;
        OML_ext_Vb_$D_Lamt_def = 0;
        OML_ext_Vb_$E_Lampe_rot_def = 0;
        OML_ext_Vb_$G_Lampe_rot_def = 0;
        OML_ext_Vb_$blocken_vLN = 0;
        OML_ext_Vb_$blocken_vZB = 0;
        OML_ext_Vb_$vorblocken_vZB = 0;
        OML_Kontakte_$6_FBF_nZB = 0;
        OML_Kontakte_$6_Anf_Durchf_nEMM = 0;
        OML_Kontakte_$6_Wecker_absch = 0;
        OML_Kontakte_$6_Wbel_ein = 0;
        OML_Kontakte_$6_Zeitsch_Umg = 0;
        OML_Kontakte_$8_FSS_0EGF = 0;
        OML_Kontakte_$8_FSS_1EGF = 0;
        OML_Kontakte_$8_FSS_80EG = 0;
        OML_Kontakte_$8_FSS_80F = 0;
    }
    public boolean fireOneTransition() {
        //check if OML_Stw_FSS_SM_SM_abfallen_gf can fire
        if ( (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (OML_Fstr_gf_$verschlossen >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus <= 0) &&
                (OML_Fstr_gf_$Zug_eingefahren < 1))
        {
            if (canFire("OML_Stw_FSS_SM_SM_abfallen_gf"))
            {
                --OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_SM_abfallen_gf");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_SM_anziehen_ef can fire
        if ( (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein <= 0) &&
                (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Kontakte_$6_Gleist_EMM >= 1) &&
                (OML_Kontakte_$7_WS1_plus >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_SM_anziehen_ef"))
            {
                --OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                fire("OML_Stw_FSS_SM_SM_anziehen_ef");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_T4 can fire
        if ( (OML_Kontakte_$8_FSS_30EG >= 1) &&
                (OML_Stw_FSS_SM_$FSS_30EG_reached_store <= 0))
        {
            if (canFire("OML_Stw_FSS_SM_T4"))
            {
                ++OML_Stw_FSS_SM_$FSS_30EG_reached_store;
                fire("OML_Stw_FSS_SM_T4");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_NAL_SM_ein can fire
        if ( (OML_Stw_FSS_SM_$FSS_Sperrm_ein <= 0) &&
                (OML_Kontakte_$6_NAL >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_NAL_SM_ein"))
            {
                ++OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                --OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_NAL_SM_ein");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_SM_anziehen_fe can fire
        if ( (OML_Kontakte_$7_WS1_plus >= 1) &&
                (OML_Kontakte_$6_Gleist_EMM >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein <= 0) &&
                (OML_Kontakte_$8_FSS_10F >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_SM_anziehen_fe"))
            {
                --OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                fire("OML_Stw_FSS_SM_SM_anziehen_fe");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_SM_anziehen_fg can fire
        if ( (OML_Kontakte_$8_FSS_10F >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein <= 0) &&
                (OML_Kontakte_$7_WS1_minus >= 1) &&
                (OML_Kontakte_$6_Gleist_ZB >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_SM_anziehen_fg"))
            {
                --OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                fire("OML_Stw_FSS_SM_SM_anziehen_fg");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_SM_abfallen_ef can fire
        if ( (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (OML_Fstr_ef_$verschlossen >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus <= 0) &&
                (OML_Fstr_ef_$Zug_eingefahren < 1))
        {
            if (canFire("OML_Stw_FSS_SM_SM_abfallen_ef"))
            {
                --OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_SM_abfallen_ef");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_zurueck_45_fe can fire
        if ( (OML_Stw_FSS_SM_$FSS_Sperrm_ein <= 0) &&
                (OML_Fstr_fe_$Zug_eingefahren >= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_zurueck_45_fe"))
            {
                ++OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                --OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_zurueck_45_fe");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_zurueck_45_gf can fire
        if ( (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein <= 0) &&
                (OML_Fstr_gf_$Zug_eingefahren >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_zurueck_45_gf"))
            {
                ++OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                --OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_zurueck_45_gf");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_T3 can fire
        if ( (OML_Stw_FSS_SM_$FSS30F_reached_store <= 0) &&
                (OML_Kontakte_$8_FSS_30F >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_T3"))
            {
                ++OML_Stw_FSS_SM_$FSS30F_reached_store;
                fire("OML_Stw_FSS_SM_T3");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_zurueck_45_fg can fire
        if ( (OML_Stw_FSS_SM_$FSS_Sperrm_ein <= 0) &&
                (OML_Fstr_fg_$Zug_eingefahren >= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_zurueck_45_fg"))
            {
                ++OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                --OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_zurueck_45_fg");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_SM_abfallen_EG can fire
        if ( (OML_Stw_FSS_SM_$FSS_30EG_reached_store >= 1) &&
                (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus <= 0) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_SM_abfallen_EG"))
            {
                --OML_Stw_FSS_SM_$FSS_30EG_reached_store;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                --OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                fire("OML_Stw_FSS_SM_SM_abfallen_EG");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_T422 can fire
        if ( (OML_Stw_FSS_SM_$NAL_pressed_store >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus <= 0) &&
                (OML_Kontakte_$6_NAL < 1))
        {
            if (canFire("OML_Stw_FSS_SM_T422"))
            {
                --OML_Stw_FSS_SM_$NAL_pressed_store;
                --OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_T422");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_zurueck_45_ef can fire
        if ( (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein <= 0) &&
                (OML_Fstr_ef_$Zug_eingefahren >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_zurueck_45_ef"))
            {
                ++OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                --OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_zurueck_45_ef");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_SM_abfallen_F can fire
        if ( (OML_Stw_FSS_SM_$FSS30F_reached_store >= 1) &&
                (OML_Kontakte_$8_FSS_10F >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus <= 0) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_SM_abfallen_F"))
            {
                --OML_Stw_FSS_SM_$FSS30F_reached_store;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                --OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                fire("OML_Stw_FSS_SM_SM_abfallen_F");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_SM_abfallen_fe can fire
        if ( (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Fstr_fe_$verschlossen >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Fstr_fe_$Zug_eingefahren < 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus <= 0))
        {
            if (canFire("OML_Stw_FSS_SM_SM_abfallen_fe"))
            {
                --OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_SM_abfallen_fe");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_T23 can fire
        if ( (OML_Stw_FSS_SM_$NAL_pressed_store <= 0) &&
                (OML_Kontakte_$6_NAL >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_T23"))
            {
                ++OML_Stw_FSS_SM_$NAL_pressed_store;
                fire("OML_Stw_FSS_SM_T23");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_SM_abfallen_fg can fire
        if ( (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Fstr_fg_$verschlossen >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Fstr_fg_$Zug_eingefahren < 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus <= 0))
        {
            if (canFire("OML_Stw_FSS_SM_SM_abfallen_fg"))
            {
                --OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                fire("OML_Stw_FSS_SM_SM_abfallen_fg");
                return true;
            }
        }
        //check if OML_Stw_FSS_SM_SM_anziehen_gf can fire
        if ( (OML_Kontakte_$7_WS1_minus >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein <= 0) &&
                (OML_Kontakte_$6_Gleist_ZB >= 1) &&
                (OML_Kontakte_$8_FSS_10EG >= 1))
        {
            if (canFire("OML_Stw_FSS_SM_SM_anziehen_gf"))
            {
                --OML_Stw_FSS_SM_$FSS_Sperrm_aus;
                ++OML_Stw_FSS_SM_$FSS_Sperrm_ein;
                fire("OML_Stw_FSS_SM_SM_anziehen_gf");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_ab_ef can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Fstr_ef_$Zug_eingefahren >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_ab_ef"))
            {
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                fire("OML_Stw_FSS_KSM_KSM_ab_ef");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_anziehen can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein <= 0) &&
                (OML_Fstr_ef_$geprueft3 >= 1) &&
                (OML_Kontakte_$8_FSS_30EG >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_anziehen"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                fire("OML_Stw_FSS_KSM_KSM_anziehen");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_T321 can fire
        if ( (OML_Stw_FSS_KSM_$P324 <= 0) &&
                (OML_Kontakte_$8_FSS_90EG >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_T321"))
            {
                ++OML_Stw_FSS_KSM_$P324;
                fire("OML_Stw_FSS_KSM_T321");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_ab_gf can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Fstr_gf_$Zug_eingefahren >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_ab_gf"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_KSM_ab_gf");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_T7 can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus >= 1) &&
                (OML_Fstr_gf_$geprueft3 >= 1) &&
                (OML_Kontakte_$8_FSS_30EG >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein <= 0))
        {
            if (canFire("OML_Stw_FSS_KSM_T7"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                fire("OML_Stw_FSS_KSM_T7");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_T5 can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein <= 0) &&
                (OML_Fstr_fe_$geprueft3 >= 1) &&
                (OML_Kontakte_$8_FSS_30F >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_T5"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                fire("OML_Stw_FSS_KSM_T5");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_NAL_KSM_EG can fire
        if ( (OML_Kontakte_$6_NAL >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0))
        {
            if (canFire("OML_Stw_FSS_KSM_NAL_KSM_EG"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_NAL_KSM_EG");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_ab_fg can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Fstr_fg_$Zug_eingefahren >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_ab_fg"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_KSM_ab_fg");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_T6 can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein <= 0) &&
                (OML_Fstr_fg_$geprueft3 >= 1) &&
                (OML_Kontakte_$8_FSS_30F >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_T6"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                fire("OML_Stw_FSS_KSM_T6");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_T320 can fire
        if ( (OML_Stw_FSS_KSM_$P322 <= 0) &&
                (OML_Kontakte_$8_FSS_90F >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_T320"))
            {
                ++OML_Stw_FSS_KSM_$P322;
                fire("OML_Stw_FSS_KSM_T320");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_abfallen_45EG can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Stw_FSS_KSM_$P322 >= 1) &&
                (OML_Kontakte_$8_FSS_45EG >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_abfallen_45EG"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                --OML_Stw_FSS_KSM_$P322;
                fire("OML_Stw_FSS_KSM_KSM_abfallen_45EG");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_abfallen_45F can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Stw_FSS_KSM_$P324 >= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_abfallen_45F"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                --OML_Stw_FSS_KSM_$P324;
                fire("OML_Stw_FSS_KSM_KSM_abfallen_45F");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_ab_fe can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Fstr_fe_$Zug_eingefahren >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_ab_fe"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_KSM_ab_fe");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_0_ab can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Kontakte_$8_FSS_0EGF_1 >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_0_ab"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_KSM_0_ab");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_NAL_KSM_F can fire
        if ( (OML_Kontakte_$6_NAL >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Kontakte_$8_FSS_45F >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_NAL_KSM_F"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_NAL_KSM_F");
                return true;
            }
        }
        //check if OML_Stw_W1_T9 can fire
        if ( (OML_Stw_W1_$Endlage_minus <= 0) &&
                (OML_Stw_W1_$gestoert_m >= 1) &&
                (OML_ext_Vb_$Ueberw_W1_minus >= 1))
        {
            if (canFire("OML_Stw_W1_T9"))
            {
                ++OML_Stw_W1_$Endlage_minus;
                --OML_Stw_W1_$gestoert_m;
                fire("OML_Stw_W1_T9");
                return true;
            }
        }
        //check if OML_Stw_W1_plus_erreichen can fire
        if ( (OML_Stw_W1_$Endlage_plus <= 0) &&
                (OML_Kontakte_$7_WS1_plus >= 1) &&
                (OML_Kontakte_$7_WS1_1 < 1) &&
                (OML_Stw_W1_$keine_Endlage_minus >= 1) &&
                (OML_Stw_W1_$keine_Endlage_plus >= 1))
        {
            if (canFire("OML_Stw_W1_plus_erreichen"))
            {
                ++OML_Stw_W1_$Endlage_plus;
                --OML_Stw_W1_$keine_Endlage_minus;
                --OML_Stw_W1_$keine_Endlage_plus;
                fire("OML_Stw_W1_plus_erreichen");
                return true;
            }
        }
        //check if OML_Stw_W1_T6 can fire
        if ( (OML_Stw_W1_$Endlage_plus >= 1) &&
                (OML_Stw_W1_$gestoert_p <= 0) &&
                (OML_ext_Vb_$Ueberw_W1_plus < 1))
        {
            if (canFire("OML_Stw_W1_T6"))
            {
                --OML_Stw_W1_$Endlage_plus;
                ++OML_Stw_W1_$gestoert_p;
                fire("OML_Stw_W1_T6");
                return true;
            }
        }
        //check if OML_Stw_W1_T7 can fire
        if ( (OML_Stw_W1_$Endlage_plus <= 0) &&
                (OML_Stw_W1_$gestoert_p >= 1) &&
                (OML_ext_Vb_$Ueberw_W1_plus >= 1))
        {
            if (canFire("OML_Stw_W1_T7"))
            {
                ++OML_Stw_W1_$Endlage_plus;
                --OML_Stw_W1_$gestoert_p;
                fire("OML_Stw_W1_T7");
                return true;
            }
        }
        //check if OML_Stw_W1_T8 can fire
        if ( (OML_Stw_W1_$Endlage_minus >= 1) &&
                (OML_Stw_W1_$gestoert_m <= 0) &&
                (OML_ext_Vb_$Ueberw_W1_minus < 1))
        {
            if (canFire("OML_Stw_W1_T8"))
            {
                --OML_Stw_W1_$Endlage_minus;
                ++OML_Stw_W1_$gestoert_m;
                fire("OML_Stw_W1_T8");
                return true;
            }
        }
        //check if OML_Stw_W1_T4 can fire
        if ( (OML_Stw_W1_$Endlage_minus >= 1) &&
                (OML_Kontakte_$7_WS1_1 >= 1) &&
                (OML_Stw_W1_$keine_Endlage_minus <= 0))
        {
            if (canFire("OML_Stw_W1_T4"))
            {
                --OML_Stw_W1_$Endlage_minus;
                ++OML_Stw_W1_$keine_Endlage_minus;
                fire("OML_Stw_W1_T4");
                return true;
            }
        }
        //check if OML_Stw_W1_T3 can fire
        if ( (OML_Stw_W1_$Endlage_plus >= 1) &&
                (OML_Kontakte_$7_WS1_1 >= 1) &&
                (OML_Stw_W1_$keine_Endlage_plus <= 0))
        {
            if (canFire("OML_Stw_W1_T3"))
            {
                --OML_Stw_W1_$Endlage_plus;
                ++OML_Stw_W1_$keine_Endlage_plus;
                fire("OML_Stw_W1_T3");
                return true;
            }
        }
        //check if OML_Stw_W1_minus_erreichen can fire
        if ( (OML_Stw_W1_$Endlage_minus <= 0) &&
                (OML_Kontakte_$7_WS1_minus >= 1) &&
                (OML_Kontakte_$7_WS1_1 < 1) &&
                (OML_Stw_W1_$keine_Endlage_plus >= 1) &&
                (OML_Stw_W1_$keine_Endlage_minus >= 1))
        {
            if (canFire("OML_Stw_W1_minus_erreichen"))
            {
                ++OML_Stw_W1_$Endlage_minus;
                --OML_Stw_W1_$keine_Endlage_plus;
                --OML_Stw_W1_$keine_Endlage_minus;
                fire("OML_Stw_W1_minus_erreichen");
                return true;
            }
        }
        //check if OML_Stw_W1_SM_WSM_abfallen can fire
        if ( (OML_Stw_W1_SM_$WS_Sperrm_ein >= 1) &&
                (OML_Stw_W1_SM_$WS_Sperrm_aus <= 0) &&
                (OML_Kontakte_$7_WS1_1 < 1))
        {
            if (canFire("OML_Stw_W1_SM_WSM_abfallen"))
            {
                --OML_Stw_W1_SM_$WS_Sperrm_ein;
                ++OML_Stw_W1_SM_$WS_Sperrm_aus;
                fire("OML_Stw_W1_SM_WSM_abfallen");
                return true;
            }
        }
        //check if OML_Stw_W1_SM_T22 can fire
        if ( (OML_Stw_W1_SM_$WS_Sperrm_aus >= 1) &&
                (OML_Stw_W1_SM_$WS_Sperrm_ein <= 0) &&
                (OML_Kontakte_$7_WS1_1 >= 1) &&
                (OML_Kontakte_$6_NT_W1 >= 1))
        {
            if (canFire("OML_Stw_W1_SM_T22"))
            {
                --OML_Stw_W1_SM_$WS_Sperrm_aus;
                ++OML_Stw_W1_SM_$WS_Sperrm_ein;
                fire("OML_Stw_W1_SM_T22");
                return true;
            }
        }
        //check if OML_Stw_W1_SM_WSM_anziehen can fire
        if ( (OML_Stw_W1_SM_$WS_Sperrm_aus >= 1) &&
                (OML_Stw_W1_SM_$WS_Sperrm_ein <= 0) &&
                (OML_Fstr_fg_$aufgeloest >= 1) &&
                (OML_Fstr_gf_$aufgeloest >= 1) &&
                (OML_Fstr_fe_$aufgeloest >= 1) &&
                (OML_Fstr_ef_$aufgeloest >= 1) &&
                (OML_Kontakte_$7_WS1_1 >= 1) &&
                (OML_Iso_1_$frei >= 1))
        {
            if (canFire("OML_Stw_W1_SM_WSM_anziehen"))
            {
                --OML_Stw_W1_SM_$WS_Sperrm_aus;
                ++OML_Stw_W1_SM_$WS_Sperrm_ein;
                fire("OML_Stw_W1_SM_WSM_anziehen");
                return true;
            }
        }
        //check if OML_Fstr_ef_vorzeitig_aufloesen can fire
        if ( (OML_Fstr_ef_$aufgeloest <= 0) &&
                (OML_Fstr_ef_$geprueft3 >= 1) &&
                (OML_Kontakte_$8_FSS_0EGF_1 >= 1))
        {
            if (canFire("OML_Fstr_ef_vorzeitig_aufloesen"))
            {
                ++OML_Fstr_ef_$aufgeloest;
                --OML_Fstr_ef_$geprueft3;
                fire("OML_Fstr_ef_vorzeitig_aufloesen");
                return true;
            }
        }
        //check if OML_Fstr_ef_ef_frei can fire
        if ( (OML_Fstr_ef_$P2 >= 1) &&
                (OML_Fstr_ef_$Zug_eingefahren <= 0))
        {
            if (canFire("OML_Fstr_ef_ef_frei"))
            {
                --OML_Fstr_ef_$P2;
                ++OML_Fstr_ef_$Zug_eingefahren;
                fire("OML_Fstr_ef_ef_frei");
                return true;
            }
        }
        //check if OML_Fstr_ef_T7 can fire
        if ( (OML_Fstr_ef_$P6 >= 1) &&
                (OML_Fstr_ef_$geprueft1 <= 0) &&
                (OML_Kontakte_$6_ISU_Sign >= 1))
        {
            if (canFire("OML_Fstr_ef_T7"))
            {
                --OML_Fstr_ef_$P6;
                ++OML_Fstr_ef_$geprueft1;
                fire("OML_Fstr_ef_T7");
                return true;
            }
        }
        //check if OML_Fstr_ef_notaufloesen can fire
        if ( (OML_Fstr_ef_$aufgeloest <= 0) &&
                (OML_Fstr_ef_$verschlossen >= 1) &&
                (OML_Kontakte_$6_NAL >= 1))
        {
            if (canFire("OML_Fstr_ef_notaufloesen"))
            {
                ++OML_Fstr_ef_$aufgeloest;
                --OML_Fstr_ef_$verschlossen;
                fire("OML_Fstr_ef_notaufloesen");
                return true;
            }
        }
        //check if OML_Fstr_ef_Signal_haltstellen can fire
        if ( (OML_Fstr_ef_$E_Fahrt1 >= 1) &&
                (OML_Fstr_ef_$E_Halt <= 1) &&
                (OML_Fstr_ef_$P2 >= 1))
        {
            if (canFire("OML_Fstr_ef_Signal_haltstellen"))
            {
                --OML_Fstr_ef_$E_Fahrt1;
                ++OML_Fstr_ef_$E_Halt;
                fire("OML_Fstr_ef_Signal_haltstellen");
                return true;
            }
        }
        //check if OML_Fstr_ef_verschliessen can fire
        if ( (OML_Fstr_ef_$geprueft3 >= 1) &&
                (OML_Fstr_ef_$verschlossen <= 0) &&
                (OML_Kontakte_$8_FSS_45EG >= 1))
        {
            if (canFire("OML_Fstr_ef_verschliessen"))
            {
                --OML_Fstr_ef_$geprueft3;
                ++OML_Fstr_ef_$verschlossen;
                fire("OML_Fstr_ef_verschliessen");
                return true;
            }
        }
        //check if OML_Fstr_ef_pruefen3 can fire
        if ( (OML_Fstr_ef_$geprueft2 >= 1) &&
                (OML_Fstr_ef_$geprueft3 <= 0))
        {
            if (canFire("OML_Fstr_ef_pruefen3"))
            {
                --OML_Fstr_ef_$geprueft2;
                ++OML_Fstr_ef_$geprueft3;
                fire("OML_Fstr_ef_pruefen3");
                return true;
            }
        }
        //check if OML_Fstr_ef_1_belegt can fire
        if ( (OML_Fstr_ef_$P1 >= 1) &&
                (OML_Fstr_ef_$P2 <= 0) &&
                (OML_Iso_1_$belegt >= 1))
        {
            if (canFire("OML_Fstr_ef_1_belegt"))
            {
                --OML_Fstr_ef_$P1;
                ++OML_Fstr_ef_$P2;
                fire("OML_Fstr_ef_1_belegt");
                return true;
            }
        }
        //check if OML_Fstr_ef_pruefen1 can fire
        if ( (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Fstr_ef_$aufgeloest >= 1) &&
                (OML_Stw_W1_$Endlage_plus >= 1) &&
                (OML_Fstr_ef_$P6 <= 0))
        {
            if (canFire("OML_Fstr_ef_pruefen1"))
            {
                --OML_Fstr_ef_$aufgeloest;
                ++OML_Fstr_ef_$P6;
                fire("OML_Fstr_ef_pruefen1");
                return true;
            }
        }
        //check if OML_Fstr_ef_aufloesen can fire
        if ( (OML_Kontakte_$8_FSS_30EG >= 1) &&
                (OML_Fstr_ef_$aufgeloest <= 0) &&
                (OML_Fstr_ef_$verschlossen >= 1) &&
                (OML_Fstr_ef_$Zug_eingefahren >= 1))
        {
            if (canFire("OML_Fstr_ef_aufloesen"))
            {
                ++OML_Fstr_ef_$aufgeloest;
                --OML_Fstr_ef_$verschlossen;
                --OML_Fstr_ef_$Zug_eingefahren;
                fire("OML_Fstr_ef_aufloesen");
                return true;
            }
        }
        //check if OML_Fstr_ef_Stoerung can fire
        if ( (OML_Fstr_ef_$E_Fahrt1 >= 1) &&
                (OML_Fstr_ef_$E_Halt <= 1) &&
                (OML_ext_Vb_$E_Lampe_gruenFB1_def >= 1))
        {
            if (canFire("OML_Fstr_ef_Stoerung"))
            {
                --OML_Fstr_ef_$E_Fahrt1;
                ++OML_Fstr_ef_$E_Halt;
                fire("OML_Fstr_ef_Stoerung");
                return true;
            }
        }
        //check if OML_Fstr_ef_T6 can fire
        if ( (OML_Iso_1_$frei >= 1) &&
                (OML_Iso_egf_$frei >= 1) &&
                (OML_Iso_ef_$frei >= 1) &&
                (OML_Fstr_ef_$geprueft1 <= 0) &&
                (OML_Fstr_ef_$P6 >= 1))
        {
            if (canFire("OML_Fstr_ef_T6"))
            {
                ++OML_Fstr_ef_$geprueft1;
                --OML_Fstr_ef_$P6;
                fire("OML_Fstr_ef_T6");
                return true;
            }
        }
        //check if OML_Fstr_ef_ef_belegt can fire
        if ( (OML_Fstr_ef_$P1 <= 0) &&
                (OML_Iso_ef_$belegt >= 1))
        {
            if (canFire("OML_Fstr_ef_ef_belegt"))
            {
                ++OML_Fstr_ef_$P1;
                fire("OML_Fstr_ef_ef_belegt");
                return true;
            }
        }
        //check if OML_Fstr_ef_T2 can fire
        if ( (OML_Fstr_ef_$geprueft1 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n >= 1) &&
                (OML_Fstr_ef_$geprueft2 <= 0))
        {
            if (canFire("OML_Fstr_ef_T2"))
            {
                --OML_Fstr_ef_$geprueft1;
                ++OML_Fstr_ef_$geprueft2;
                fire("OML_Fstr_ef_T2");
                return true;
            }
        }
        //check if OML_Fstr_ef_Signal_fahrtstellen can fire
        if ( (OML_Fstr_ef_$E_Halt >= 1) &&
                (OML_Fstr_ef_$signal_steller >= 1) &&
                (OML_Fstr_ef_$E_Fahrt1 <= 0) &&
                (OML_Fstr_ef_$verschlossen >= 1))
        {
            if (canFire("OML_Fstr_ef_Signal_fahrtstellen"))
            {
                --OML_Fstr_ef_$E_Halt;
                ++OML_Fstr_ef_$E_Fahrt1;
                fire("OML_Fstr_ef_Signal_fahrtstellen");
                return true;
            }
        }
        //check if OML_Fstr_ef_T1 can fire
        if ( (OML_Fstr_ef_$geprueft1 >= 1) &&
                (OML_Kontakte_$6_BLU_EG >= 1) &&
                (OML_Fstr_ef_$geprueft2 <= 0))
        {
            if (canFire("OML_Fstr_ef_T1"))
            {
                --OML_Fstr_ef_$geprueft1;
                ++OML_Fstr_ef_$geprueft2;
                fire("OML_Fstr_ef_T1");
                return true;
            }
        }
        //check if OML_Fstr_ef_merken_90EG can fire
        if ( (OML_Fstr_ef_$gemerkt_90EB <= 0) &&
                (OML_Kontakte_$8_FSS_90EG >= 1))
        {
            if (canFire("OML_Fstr_ef_merken_90EG"))
            {
                ++OML_Fstr_ef_$gemerkt_90EB;
                fire("OML_Fstr_ef_merken_90EG");
                return true;
            }
        }
        //check if OML_Fstr_ef_incoming_signal_steller can fire
        if ( (OML_Fstr_ef_$prison_signal_steller < 1) &&
                (OML_Fstr_ef_$signal_steller <= 0) &&
                (OML_Kontakte_$8_FSS_90EG >= 1))
        {
            if (canFire("OML_Fstr_ef_incoming_signal_steller"))
            {
                ++OML_Fstr_ef_$signal_steller;
                fire("OML_Fstr_ef_incoming_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_ef_delete_signal_steller can fire
        if ( (OML_Fstr_ef_$prison_signal_steller <= 0) &&
                (OML_Fstr_ef_$signal_steller >= 1) &&
                (OML_Fstr_ef_$E_Halt < 1))
        {
            if (canFire("OML_Fstr_ef_delete_signal_steller"))
            {
                ++OML_Fstr_ef_$prison_signal_steller;
                --OML_Fstr_ef_$signal_steller;
                fire("OML_Fstr_ef_delete_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_ef_free_signal_steller can fire
        if ( (OML_Fstr_ef_$prison_signal_steller >= 1) &&
                (OML_Fstr_ef_$verschlossen < 1))
        {
            if (canFire("OML_Fstr_ef_free_signal_steller"))
            {
                --OML_Fstr_ef_$prison_signal_steller;
                fire("OML_Fstr_ef_free_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_ef_signal_haltstellen_FSS can fire
        if ( (OML_Fstr_ef_$gemerkt_90EB >= 1) &&
                (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (OML_Fstr_ef_$E_Fahrt1 >= 1) &&
                (OML_Fstr_ef_$E_Halt <= 1))
        {
            if (canFire("OML_Fstr_ef_signal_haltstellen_FSS"))
            {
                --OML_Fstr_ef_$gemerkt_90EB;
                --OML_Fstr_ef_$E_Fahrt1;
                ++OML_Fstr_ef_$E_Halt;
                fire("OML_Fstr_ef_signal_haltstellen_FSS");
                return true;
            }
        }
        //check if OML_Fstr_fe_Signal_haltstellen can fire
        if ( (OML_Fstr_fe_$P2b >= 1) &&
                (OML_Fstr_fe_$F_Halt <= 1) &&
                (OML_Fstr_fe_$F_Fahrt1 >= 1))
        {
            if (canFire("OML_Fstr_fe_Signal_haltstellen"))
            {
                ++OML_Fstr_fe_$F_Halt;
                --OML_Fstr_fe_$F_Fahrt1;
                fire("OML_Fstr_fe_Signal_haltstellen");
                return true;
            }
        }
        //check if OML_Fstr_fe_T2 can fire
        if ( (OML_Fstr_fe_$P2 >= 1) &&
                (OML_Fstr_fe_$geprueft <= 0) &&
                (OML_Iso_ef_$frei >= 1) &&
                (OML_Iso_1_$frei >= 1) &&
                (OML_Iso_cd_$frei >= 1) &&
                (OML_Iso_egf_$frei >= 1))
        {
            if (canFire("OML_Fstr_fe_T2"))
            {
                --OML_Fstr_fe_$P2;
                ++OML_Fstr_fe_$geprueft;
                fire("OML_Fstr_fe_T2");
                return true;
            }
        }
        //check if OML_Fstr_fe_Stoerung can fire
        if ( (OML_Fstr_fe_$F_Halt <= 1) &&
                (OML_Fstr_fe_$F_Fahrt1 >= 1) &&
                (OML_ext_Vb_$E_Lampe_gruenFB1_def >= 1))
        {
            if (canFire("OML_Fstr_fe_Stoerung"))
            {
                ++OML_Fstr_fe_$F_Halt;
                --OML_Fstr_fe_$F_Fahrt1;
                fire("OML_Fstr_fe_Stoerung");
                return true;
            }
        }
        //check if OML_Fstr_fe_Signal_fahrtstellen can fire
        if ( (OML_Fstr_fe_$F_Halt >= 1) &&
                (OML_Fstr_fe_$F_Fahrt1 <= 0) &&
                (OML_Fstr_fe_$verschlossen >= 1) &&
                (OML_Fstr_fe_$signal_steller >= 1))
        {
            if (canFire("OML_Fstr_fe_Signal_fahrtstellen"))
            {
                --OML_Fstr_fe_$F_Halt;
                ++OML_Fstr_fe_$F_Fahrt1;
                fire("OML_Fstr_fe_Signal_fahrtstellen");
                return true;
            }
        }
        //check if OML_Fstr_fe_aufloesen can fire
        if ( (OML_Fstr_fe_$aufgeloest <= 1) &&
                (OML_Fstr_fe_$verschlossen >= 1) &&
                (OML_Fstr_fe_$Zug_eingefahren >= 1) &&
                (OML_Kontakte_$8_FSS_30F >= 1))
        {
            if (canFire("OML_Fstr_fe_aufloesen"))
            {
                ++OML_Fstr_fe_$aufgeloest;
                --OML_Fstr_fe_$verschlossen;
                --OML_Fstr_fe_$Zug_eingefahren;
                fire("OML_Fstr_fe_aufloesen");
                return true;
            }
        }
        //check if OML_Fstr_fe_verschliessen can fire
        if ( (OML_Fstr_fe_$verschlossen <= 0) &&
                (OML_Fstr_fe_$geprueft3 >= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1))
        {
            if (canFire("OML_Fstr_fe_verschliessen"))
            {
                ++OML_Fstr_fe_$verschlossen;
                --OML_Fstr_fe_$geprueft3;
                fire("OML_Fstr_fe_verschliessen");
                return true;
            }
        }
        //check if OML_Fstr_fe_T1 can fire
        if ( (OML_Fstr_fe_$geprueft >= 1) &&
                (OML_Fstr_fe_$geprueft3 <= 0))
        {
            if (canFire("OML_Fstr_fe_T1"))
            {
                --OML_Fstr_fe_$geprueft;
                ++OML_Fstr_fe_$geprueft3;
                fire("OML_Fstr_fe_T1");
                return true;
            }
        }
        //check if OML_Fstr_fe_egf_frei can fire
        if ( (OML_Fstr_fe_$P2b >= 1) &&
                (OML_Fstr_fe_$Zug_eingefahren <= 0))
        {
            if (canFire("OML_Fstr_fe_egf_frei"))
            {
                --OML_Fstr_fe_$P2b;
                ++OML_Fstr_fe_$Zug_eingefahren;
                fire("OML_Fstr_fe_egf_frei");
                return true;
            }
        }
        //check if OML_Fstr_fe_vorzeitig_aufloesen can fire
        if ( (OML_Fstr_fe_$geprueft3 >= 1) &&
                (OML_Fstr_fe_$aufgeloest <= 1) &&
                (OML_Kontakte_$8_FSS_0EGF_1 >= 1))
        {
            if (canFire("OML_Fstr_fe_vorzeitig_aufloesen"))
            {
                --OML_Fstr_fe_$geprueft3;
                ++OML_Fstr_fe_$aufgeloest;
                fire("OML_Fstr_fe_vorzeitig_aufloesen");
                return true;
            }
        }
        //check if OML_Fstr_fe_notaufloesen can fire
        if ( (OML_Fstr_fe_$verschlossen >= 1) &&
                (OML_Fstr_fe_$aufgeloest <= 1) &&
                (OML_Kontakte_$6_NAL >= 1))
        {
            if (canFire("OML_Fstr_fe_notaufloesen"))
            {
                --OML_Fstr_fe_$verschlossen;
                ++OML_Fstr_fe_$aufgeloest;
                fire("OML_Fstr_fe_notaufloesen");
                return true;
            }
        }
        //check if OML_Fstr_fe_T3 can fire
        if ( (OML_Fstr_fe_$P2 >= 1) &&
                (OML_Fstr_fe_$geprueft <= 0) &&
                (OML_Kontakte_$6_ISU_Sign >= 1))
        {
            if (canFire("OML_Fstr_fe_T3"))
            {
                --OML_Fstr_fe_$P2;
                ++OML_Fstr_fe_$geprueft;
                fire("OML_Fstr_fe_T3");
                return true;
            }
        }
        //check if OML_Fstr_fe_1_belegt can fire
        if ( (OML_Fstr_fe_$P2b <= 0) &&
                (OML_Fstr_fe_$P1 >= 1) &&
                (OML_Iso_1_$belegt >= 1))
        {
            if (canFire("OML_Fstr_fe_1_belegt"))
            {
                ++OML_Fstr_fe_$P2b;
                --OML_Fstr_fe_$P1;
                fire("OML_Fstr_fe_1_belegt");
                return true;
            }
        }
        //check if OML_Fstr_fe_egf_belegt can fire
        if ( (OML_Fstr_fe_$P1 <= 0) &&
                (OML_Iso_egf_$belegt >= 1))
        {
            if (canFire("OML_Fstr_fe_egf_belegt"))
            {
                ++OML_Fstr_fe_$P1;
                fire("OML_Fstr_fe_egf_belegt");
                return true;
            }
        }
        //check if OML_Fstr_fe_pruefen can fire
        if ( (OML_Fstr_fe_$aufgeloest >= 1) &&
                (OML_Fstr_fe_$P2 <= 0) &&
                (OML_Kontakte_$8_FSS_10F >= 1) &&
                (OML_Stw_W1_$Endlage_plus >= 1))
        {
            if (canFire("OML_Fstr_fe_pruefen"))
            {
                --OML_Fstr_fe_$aufgeloest;
                ++OML_Fstr_fe_$P2;
                fire("OML_Fstr_fe_pruefen");
                return true;
            }
        }
        //check if OML_Fstr_fe_merken_90F can fire
        if ( (OML_Fstr_fe_$gemerkt_90F <= 0) &&
                (OML_Kontakte_$8_FSS_90F >= 1))
        {
            if (canFire("OML_Fstr_fe_merken_90F"))
            {
                ++OML_Fstr_fe_$gemerkt_90F;
                fire("OML_Fstr_fe_merken_90F");
                return true;
            }
        }
        //check if OML_Fstr_fe_incoming_signal_steller can fire
        if ( (OML_Fstr_fe_$signal_steller <= 0) &&
                (OML_Fstr_fe_$prison_signal_steller < 1) &&
                (OML_Kontakte_$8_FSS_90F >= 1))
        {
            if (canFire("OML_Fstr_fe_incoming_signal_steller"))
            {
                ++OML_Fstr_fe_$signal_steller;
                fire("OML_Fstr_fe_incoming_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_fe_delete_signal_steller can fire
        if ( (OML_Fstr_fe_$signal_steller >= 1) &&
                (OML_Fstr_fe_$F_Halt < 1) &&
                (OML_Fstr_fe_$prison_signal_steller <= 0))
        {
            if (canFire("OML_Fstr_fe_delete_signal_steller"))
            {
                --OML_Fstr_fe_$signal_steller;
                ++OML_Fstr_fe_$prison_signal_steller;
                fire("OML_Fstr_fe_delete_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_fe_free_signal_steller can fire
        if ( (OML_Fstr_fe_$prison_signal_steller >= 1) &&
                (OML_Fstr_fe_$verschlossen < 1))
        {
            if (canFire("OML_Fstr_fe_free_signal_steller"))
            {
                --OML_Fstr_fe_$prison_signal_steller;
                fire("OML_Fstr_fe_free_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_fe_signal_haltstellen_FSS can fire
        if ( (OML_Fstr_fe_$F_Halt <= 1) &&
                (OML_Fstr_fe_$F_Fahrt1 >= 1) &&
                (OML_Fstr_fe_$gemerkt_90F >= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1))
        {
            if (canFire("OML_Fstr_fe_signal_haltstellen_FSS"))
            {
                ++OML_Fstr_fe_$F_Halt;
                --OML_Fstr_fe_$F_Fahrt1;
                --OML_Fstr_fe_$gemerkt_90F;
                fire("OML_Fstr_fe_signal_haltstellen_FSS");
                return true;
            }
        }
        //check if OML_Fstr_gf_1_belegt can fire
        if ( (OML_Fstr_gf_$Zug_eingefahren <= 0) &&
                (OML_Iso_1_$belegt >= 1))
        {
            if (canFire("OML_Fstr_gf_1_belegt"))
            {
                ++OML_Fstr_gf_$Zug_eingefahren;
                fire("OML_Fstr_gf_1_belegt");
                return true;
            }
        }
        //check if OML_Fstr_gf_T5 can fire
        if ( (OML_Iso_egf_$frei >= 1) &&
                (OML_Iso_1_$frei >= 1) &&
                (OML_Fstr_gf_$geprueft1 <= 0) &&
                (OML_Fstr_gf_$P4 >= 1))
        {
            if (canFire("OML_Fstr_gf_T5"))
            {
                ++OML_Fstr_gf_$geprueft1;
                --OML_Fstr_gf_$P4;
                fire("OML_Fstr_gf_T5");
                return true;
            }
        }
        //check if OML_Fstr_gf_prüfen1 can fire
        if ( (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Fstr_gf_$aufgeloest >= 1) &&
                (OML_Stw_W1_$Endlage_minus >= 1) &&
                (OML_Fstr_gf_$P4 <= 0))
        {
            if (canFire("OML_Fstr_gf_prüfen1"))
            {
                --OML_Fstr_gf_$aufgeloest;
                ++OML_Fstr_gf_$P4;
                fire("OML_Fstr_gf_prüfen1");
                return true;
            }
        }
        //check if OML_Fstr_gf_notaufloesen can fire
        if ( (OML_Fstr_gf_$verschlossen >= 1) &&
                (OML_Kontakte_$6_NAL >= 1) &&
                (OML_Fstr_gf_$aufgeloest <= 0))
        {
            if (canFire("OML_Fstr_gf_notaufloesen"))
            {
                --OML_Fstr_gf_$verschlossen;
                ++OML_Fstr_gf_$aufgeloest;
                fire("OML_Fstr_gf_notaufloesen");
                return true;
            }
        }
        //check if OML_Fstr_gf_Stoerung can fire
        if ( (OML_Fstr_gf_$G_Halt <= 1) &&
                (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_ext_Vb_$G_Lampe_gruenFB3_def >= 1))
        {
            if (canFire("OML_Fstr_gf_Stoerung"))
            {
                ++OML_Fstr_gf_$G_Halt;
                --OML_Fstr_gf_$G_Fahrt3;
                fire("OML_Fstr_gf_Stoerung");
                return true;
            }
        }
        //check if OML_Fstr_gf_Signal_fahrtstellen can fire
        if ( (OML_Fstr_gf_$verschlossen >= 1) &&
                (OML_Fstr_gf_$G_Halt >= 1) &&
                (OML_Fstr_gf_$G_Fahrt3 <= 0) &&
                (OML_Fstr_gf_$signal_steller >= 1))
        {
            if (canFire("OML_Fstr_gf_Signal_fahrtstellen"))
            {
                --OML_Fstr_gf_$G_Halt;
                ++OML_Fstr_gf_$G_Fahrt3;
                fire("OML_Fstr_gf_Signal_fahrtstellen");
                return true;
            }
        }
        //check if OML_Fstr_gf_aufloesen can fire
        if ( (OML_Fstr_gf_$verschlossen >= 1) &&
                (OML_Fstr_gf_$aufgeloest <= 0) &&
                (OML_Fstr_gf_$Zug_eingefahren >= 1) &&
                (OML_Kontakte_$8_FSS_30EG >= 1))
        {
            if (canFire("OML_Fstr_gf_aufloesen"))
            {
                --OML_Fstr_gf_$verschlossen;
                ++OML_Fstr_gf_$aufgeloest;
                --OML_Fstr_gf_$Zug_eingefahren;
                fire("OML_Fstr_gf_aufloesen");
                return true;
            }
        }
        //check if OML_Fstr_gf_T1 can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_n >= 1) &&
                (OML_Fstr_gf_$geprueft2 <= 0) &&
                (OML_Fstr_gf_$geprueft1 >= 1))
        {
            if (canFire("OML_Fstr_gf_T1"))
            {
                ++OML_Fstr_gf_$geprueft2;
                --OML_Fstr_gf_$geprueft1;
                fire("OML_Fstr_gf_T1");
                return true;
            }
        }
        //check if OML_Fstr_gf_T2 can fire
        if ( (OML_Kontakte_$6_BLU_EG >= 1) &&
                (OML_Fstr_gf_$geprueft2 <= 0) &&
                (OML_Fstr_gf_$geprueft1 >= 1))
        {
            if (canFire("OML_Fstr_gf_T2"))
            {
                ++OML_Fstr_gf_$geprueft2;
                --OML_Fstr_gf_$geprueft1;
                fire("OML_Fstr_gf_T2");
                return true;
            }
        }
        //check if OML_Fstr_gf_Signal_haltstellen can fire
        if ( (OML_Fstr_gf_$Zug_eingefahren >= 1) &&
                (OML_Fstr_gf_$G_Halt <= 1) &&
                (OML_Fstr_gf_$G_Fahrt3 >= 1))
        {
            if (canFire("OML_Fstr_gf_Signal_haltstellen"))
            {
                ++OML_Fstr_gf_$G_Halt;
                --OML_Fstr_gf_$G_Fahrt3;
                fire("OML_Fstr_gf_Signal_haltstellen");
                return true;
            }
        }
        //check if OML_Fstr_gf_vorzeitig_aufloesen can fire
        if ( (OML_Fstr_gf_$geprueft3 >= 1) &&
                (OML_Fstr_gf_$aufgeloest <= 0) &&
                (OML_Kontakte_$8_FSS_0EGF_1 >= 1))
        {
            if (canFire("OML_Fstr_gf_vorzeitig_aufloesen"))
            {
                --OML_Fstr_gf_$geprueft3;
                ++OML_Fstr_gf_$aufgeloest;
                fire("OML_Fstr_gf_vorzeitig_aufloesen");
                return true;
            }
        }
        //check if OML_Fstr_gf_pruefen3 can fire
        if ( (OML_Fstr_gf_$geprueft2 >= 1) &&
                (OML_Fstr_gf_$geprueft3 <= 0))
        {
            if (canFire("OML_Fstr_gf_pruefen3"))
            {
                --OML_Fstr_gf_$geprueft2;
                ++OML_Fstr_gf_$geprueft3;
                fire("OML_Fstr_gf_pruefen3");
                return true;
            }
        }
        //check if OML_Fstr_gf_verschliessen can fire
        if ( (OML_Fstr_gf_$geprueft3 >= 1) &&
                (OML_Fstr_gf_$verschlossen <= 0) &&
                (OML_Kontakte_$8_FSS_45EG >= 1))
        {
            if (canFire("OML_Fstr_gf_verschliessen"))
            {
                --OML_Fstr_gf_$geprueft3;
                ++OML_Fstr_gf_$verschlossen;
                fire("OML_Fstr_gf_verschliessen");
                return true;
            }
        }
        //check if OML_Fstr_gf_T6 can fire
        if ( (OML_Fstr_gf_$geprueft1 <= 0) &&
                (OML_Fstr_gf_$P4 >= 1) &&
                (OML_Kontakte_$6_ISU_Sign >= 1))
        {
            if (canFire("OML_Fstr_gf_T6"))
            {
                ++OML_Fstr_gf_$geprueft1;
                --OML_Fstr_gf_$P4;
                fire("OML_Fstr_gf_T6");
                return true;
            }
        }
        //check if OML_Fstr_gf_merken_90EG can fire
        if ( (OML_Fstr_gf_$gemerkt_90EG <= 0) &&
                (OML_Kontakte_$8_FSS_90EG >= 1))
        {
            if (canFire("OML_Fstr_gf_merken_90EG"))
            {
                ++OML_Fstr_gf_$gemerkt_90EG;
                fire("OML_Fstr_gf_merken_90EG");
                return true;
            }
        }
        //check if OML_Fstr_gf_incoming_signal_steller can fire
        if ( (OML_Fstr_gf_$prison_signal_steller < 1) &&
                (OML_Fstr_gf_$signal_steller <= 0) &&
                (OML_Kontakte_$8_FSS_90EG >= 1))
        {
            if (canFire("OML_Fstr_gf_incoming_signal_steller"))
            {
                ++OML_Fstr_gf_$signal_steller;
                fire("OML_Fstr_gf_incoming_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_gf_delete_signal_steller can fire
        if ( (OML_Fstr_gf_$prison_signal_steller <= 0) &&
                (OML_Fstr_gf_$signal_steller >= 1) &&
                (OML_Fstr_gf_$G_Halt < 1))
        {
            if (canFire("OML_Fstr_gf_delete_signal_steller"))
            {
                ++OML_Fstr_gf_$prison_signal_steller;
                --OML_Fstr_gf_$signal_steller;
                fire("OML_Fstr_gf_delete_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_gf_free_signal_steller can fire
        if ( (OML_Fstr_gf_$prison_signal_steller >= 1) &&
                (OML_Fstr_gf_$verschlossen < 1))
        {
            if (canFire("OML_Fstr_gf_free_signal_steller"))
            {
                --OML_Fstr_gf_$prison_signal_steller;
                fire("OML_Fstr_gf_free_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_gf_signal_haltstellen_FSS can fire
        if ( (OML_Fstr_gf_$gemerkt_90EG >= 1) &&
                (OML_Fstr_gf_$G_Halt <= 1) &&
                (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_Kontakte_$8_FSS_45EG >= 1))
        {
            if (canFire("OML_Fstr_gf_signal_haltstellen_FSS"))
            {
                --OML_Fstr_gf_$gemerkt_90EG;
                ++OML_Fstr_gf_$G_Halt;
                --OML_Fstr_gf_$G_Fahrt3;
                fire("OML_Fstr_gf_signal_haltstellen_FSS");
                return true;
            }
        }
        //check if OML_Fstr_fg_Signal_fahrtstellen can fire
        if ( (OML_Fstr_fg_$verschlossen >= 1) &&
                (OML_Fstr_fg_$F_Fahrt3 <= 0) &&
                (OML_Fstr_fg_$F_Halt >= 1) &&
                (OML_Fstr_fg_$signal_steller >= 1))
        {
            if (canFire("OML_Fstr_fg_Signal_fahrtstellen"))
            {
                ++OML_Fstr_fg_$F_Fahrt3;
                --OML_Fstr_fg_$F_Halt;
                fire("OML_Fstr_fg_Signal_fahrtstellen");
                return true;
            }
        }
        //check if OML_Fstr_fg_pruefen1 can fire
        if ( (OML_Fstr_fg_$aufgeloest >= 1) &&
                (OML_Fstr_fg_$geprueft0 <= 0) &&
                (OML_Stw_W1_$Endlage_minus >= 1) &&
                (OML_Kontakte_$8_FSS_10F >= 1))
        {
            if (canFire("OML_Fstr_fg_pruefen1"))
            {
                --OML_Fstr_fg_$aufgeloest;
                ++OML_Fstr_fg_$geprueft0;
                fire("OML_Fstr_fg_pruefen1");
                return true;
            }
        }
        //check if OML_Fstr_fg_egf_frei can fire
        if ( (OML_Fstr_fg_$Zug_eingefahren <= 0) &&
                (OML_Fstr_fg_$P2 >= 1))
        {
            if (canFire("OML_Fstr_fg_egf_frei"))
            {
                ++OML_Fstr_fg_$Zug_eingefahren;
                --OML_Fstr_fg_$P2;
                fire("OML_Fstr_fg_egf_frei");
                return true;
            }
        }
        //check if OML_Fstr_fg_notaufloesen can fire
        if ( (OML_Fstr_fg_$aufgeloest <= 0) &&
                (OML_Fstr_fg_$verschlossen >= 1) &&
                (OML_Kontakte_$6_NAL >= 1))
        {
            if (canFire("OML_Fstr_fg_notaufloesen"))
            {
                ++OML_Fstr_fg_$aufgeloest;
                --OML_Fstr_fg_$verschlossen;
                fire("OML_Fstr_fg_notaufloesen");
                return true;
            }
        }
        //check if OML_Fstr_fg_verschliessen can fire
        if ( (OML_Fstr_fg_$geprueft3 >= 1) &&
                (OML_Fstr_fg_$verschlossen <= 0) &&
                (OML_Kontakte_$8_FSS_45F >= 1))
        {
            if (canFire("OML_Fstr_fg_verschliessen"))
            {
                --OML_Fstr_fg_$geprueft3;
                ++OML_Fstr_fg_$verschlossen;
                fire("OML_Fstr_fg_verschliessen");
                return true;
            }
        }
        //check if OML_Fstr_fg_T5 can fire
        if ( (OML_Fstr_fg_$geprueft0 >= 1) &&
                (OML_Fstr_fg_$geprueft1 <= 0) &&
                (OML_Kontakte_$6_ISU_Sign >= 1))
        {
            if (canFire("OML_Fstr_fg_T5"))
            {
                --OML_Fstr_fg_$geprueft0;
                ++OML_Fstr_fg_$geprueft1;
                fire("OML_Fstr_fg_T5");
                return true;
            }
        }
        //check if OML_Fstr_fg_T1 can fire
        if ( (OML_Fstr_fg_$geprueft2 <= 0) &&
                (OML_Fstr_fg_$geprueft1 >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_n >= 1))
        {
            if (canFire("OML_Fstr_fg_T1"))
            {
                ++OML_Fstr_fg_$geprueft2;
                --OML_Fstr_fg_$geprueft1;
                fire("OML_Fstr_fg_T1");
                return true;
            }
        }
        //check if OML_Fstr_fg_Signal_haltstellen can fire
        if ( (OML_Fstr_fg_$P2 >= 1) &&
                (OML_Fstr_fg_$F_Halt <= 1) &&
                (OML_Fstr_fg_$F_Fahrt3 >= 1))
        {
            if (canFire("OML_Fstr_fg_Signal_haltstellen"))
            {
                ++OML_Fstr_fg_$F_Halt;
                --OML_Fstr_fg_$F_Fahrt3;
                fire("OML_Fstr_fg_Signal_haltstellen");
                return true;
            }
        }
        //check if OML_Fstr_fg_pruefen3 can fire
        if ( (OML_Fstr_fg_$geprueft3 <= 0) &&
                (OML_Fstr_fg_$geprueft2 >= 1))
        {
            if (canFire("OML_Fstr_fg_pruefen3"))
            {
                ++OML_Fstr_fg_$geprueft3;
                --OML_Fstr_fg_$geprueft2;
                fire("OML_Fstr_fg_pruefen3");
                return true;
            }
        }
        //check if OML_Fstr_fg_aufloesen can fire
        if ( (OML_Fstr_fg_$Zug_eingefahren >= 1) &&
                (OML_Fstr_fg_$aufgeloest <= 0) &&
                (OML_Fstr_fg_$verschlossen >= 1) &&
                (OML_Kontakte_$8_FSS_30F >= 1))
        {
            if (canFire("OML_Fstr_fg_aufloesen"))
            {
                --OML_Fstr_fg_$Zug_eingefahren;
                ++OML_Fstr_fg_$aufgeloest;
                --OML_Fstr_fg_$verschlossen;
                fire("OML_Fstr_fg_aufloesen");
                return true;
            }
        }
        //check if OML_Fstr_fg_egf_belegt can fire
        if ( (OML_Fstr_fg_$P1 <= 0) &&
                (OML_Iso_egf_$belegt >= 1))
        {
            if (canFire("OML_Fstr_fg_egf_belegt"))
            {
                ++OML_Fstr_fg_$P1;
                fire("OML_Fstr_fg_egf_belegt");
                return true;
            }
        }
        //check if OML_Fstr_fg_1_belegt can fire
        if ( (OML_Fstr_fg_$P2 <= 0) &&
                (OML_Fstr_fg_$P1 >= 1) &&
                (OML_Iso_1_$belegt >= 1))
        {
            if (canFire("OML_Fstr_fg_1_belegt"))
            {
                ++OML_Fstr_fg_$P2;
                --OML_Fstr_fg_$P1;
                fire("OML_Fstr_fg_1_belegt");
                return true;
            }
        }
        //check if OML_Fstr_fg_Stoerung can fire
        if ( (OML_Fstr_fg_$F_Fahrt3 >= 1) &&
                (OML_Fstr_fg_$F_Halt <= 1) &&
                (OML_ext_Vb_$F_Lampe_gruenFB3_def >= 1))
        {
            if (canFire("OML_Fstr_fg_Stoerung"))
            {
                --OML_Fstr_fg_$F_Fahrt3;
                ++OML_Fstr_fg_$F_Halt;
                fire("OML_Fstr_fg_Stoerung");
                return true;
            }
        }
        //check if OML_Fstr_fg_T4_1 can fire
        if ( (OML_Fstr_fg_$geprueft0 >= 1) &&
                (OML_Iso_1_$frei >= 1) &&
                (OML_Iso_egf_$frei >= 1) &&
                (OML_Fstr_fg_$geprueft1 <= 0))
        {
            if (canFire("OML_Fstr_fg_T4_1"))
            {
                --OML_Fstr_fg_$geprueft0;
                ++OML_Fstr_fg_$geprueft1;
                fire("OML_Fstr_fg_T4_1");
                return true;
            }
        }
        //check if OML_Fstr_fg_vorzeitig_aufloesen can fire
        if ( (OML_Fstr_fg_$geprueft3 >= 1) &&
                (OML_Fstr_fg_$aufgeloest <= 0) &&
                (OML_Kontakte_$8_FSS_0EGF_1 >= 1))
        {
            if (canFire("OML_Fstr_fg_vorzeitig_aufloesen"))
            {
                --OML_Fstr_fg_$geprueft3;
                ++OML_Fstr_fg_$aufgeloest;
                fire("OML_Fstr_fg_vorzeitig_aufloesen");
                return true;
            }
        }
        //check if OML_Fstr_fg_merken_90F can fire
        if ( (OML_Fstr_fg_$gemerkt_90F <= 0) &&
                (OML_Kontakte_$8_FSS_90F >= 1))
        {
            if (canFire("OML_Fstr_fg_merken_90F"))
            {
                ++OML_Fstr_fg_$gemerkt_90F;
                fire("OML_Fstr_fg_merken_90F");
                return true;
            }
        }
        //check if OML_Fstr_fg_incoming_signal_steller can fire
        if ( (OML_Fstr_fg_$signal_steller <= 0) &&
                (OML_Fstr_fg_$prison_signal_steller < 1) &&
                (OML_Kontakte_$8_FSS_90F >= 1))
        {
            if (canFire("OML_Fstr_fg_incoming_signal_steller"))
            {
                ++OML_Fstr_fg_$signal_steller;
                fire("OML_Fstr_fg_incoming_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_fg_delete_signal_steller can fire
        if ( (OML_Fstr_fg_$signal_steller >= 1) &&
                (OML_Fstr_fg_$prison_signal_steller <= 0) &&
                (OML_Fstr_fg_$F_Halt < 1))
        {
            if (canFire("OML_Fstr_fg_delete_signal_steller"))
            {
                --OML_Fstr_fg_$signal_steller;
                ++OML_Fstr_fg_$prison_signal_steller;
                fire("OML_Fstr_fg_delete_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_fg_free_signal_steller can fire
        if ( (OML_Fstr_fg_$prison_signal_steller >= 1) &&
                (OML_Fstr_fg_$verschlossen < 1))
        {
            if (canFire("OML_Fstr_fg_free_signal_steller"))
            {
                --OML_Fstr_fg_$prison_signal_steller;
                fire("OML_Fstr_fg_free_signal_steller");
                return true;
            }
        }
        //check if OML_Fstr_fg_signal_haltstellen_FSS can fire
        if ( (OML_Fstr_fg_$F_Halt <= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Fstr_fg_$gemerkt_90F >= 1))
        {
            if (canFire("OML_Fstr_fg_signal_haltstellen_FSS"))
            {
                ++OML_Fstr_fg_$F_Halt;
                --OML_Fstr_fg_$gemerkt_90F;
                fire("OML_Fstr_fg_signal_haltstellen_FSS");
                return true;
            }
        }
        //check if OML_Iso_ef_Ausfahrt_Fz can fire
        if ( (OML_Iso_ef_$belegt >= 1) &&
                (OML_Iso_ef_$Zug_ausfahren >= 1) &&
                (OML_Iso_ef_$frei <= 0))
        {
            if (canFire("OML_Iso_ef_Ausfahrt_Fz"))
            {
                --OML_Iso_ef_$belegt;
                --OML_Iso_ef_$Zug_ausfahren;
                ++OML_Iso_ef_$frei;
                fire("OML_Iso_ef_Ausfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_ef_Einfahrt_Fz can fire
        if ( (OML_Iso_ef_$belegt <= 0) &&
                (OML_Iso_ef_$Zug_einfahren >= 1) &&
                (OML_Iso_ef_$frei >= 1))
        {
            if (canFire("OML_Iso_ef_Einfahrt_Fz"))
            {
                ++OML_Iso_ef_$belegt;
                --OML_Iso_ef_$Zug_einfahren;
                --OML_Iso_ef_$frei;
                fire("OML_Iso_ef_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_1_Ausfahrt_Fz can fire
        if ( (OML_Iso_1_$belegt >= 1) &&
                (OML_Iso_1_$frei <= 0) &&
                (OML_Iso_1_$Zug_ausfahren >= 1))
        {
            if (canFire("OML_Iso_1_Ausfahrt_Fz"))
            {
                --OML_Iso_1_$belegt;
                ++OML_Iso_1_$frei;
                --OML_Iso_1_$Zug_ausfahren;
                fire("OML_Iso_1_Ausfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_1_Einfahrt_Fz can fire
        if ( (OML_Iso_1_$frei >= 1) &&
                (OML_Iso_1_$Zug_einfahren >= 1) &&
                (OML_Iso_1_$belegt <= 0))
        {
            if (canFire("OML_Iso_1_Einfahrt_Fz"))
            {
                --OML_Iso_1_$frei;
                --OML_Iso_1_$Zug_einfahren;
                ++OML_Iso_1_$belegt;
                fire("OML_Iso_1_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_gf_Einfahrt_Fz can fire
        if ( (OML_Iso_gf_$frei >= 1) &&
                (OML_Iso_gf_$Zug_einfahren >= 1) &&
                (OML_Iso_gf_$belegt <= 0))
        {
            if (canFire("OML_Iso_gf_Einfahrt_Fz"))
            {
                --OML_Iso_gf_$frei;
                --OML_Iso_gf_$Zug_einfahren;
                ++OML_Iso_gf_$belegt;
                fire("OML_Iso_gf_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_gf_Ausfahrt_Fz can fire
        if ( (OML_Iso_gf_$belegt >= 1) &&
                (OML_Iso_gf_$Zug_ausfahren >= 1) &&
                (OML_Iso_gf_$frei <= 0))
        {
            if (canFire("OML_Iso_gf_Ausfahrt_Fz"))
            {
                --OML_Iso_gf_$belegt;
                --OML_Iso_gf_$Zug_ausfahren;
                ++OML_Iso_gf_$frei;
                fire("OML_Iso_gf_Ausfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_egf_Ausfahrt_Fz can fire
        if ( (OML_Iso_egf_$belegt >= 1) &&
                (OML_Iso_egf_$frei <= 0) &&
                (OML_Iso_egf_$Zug_ausfahren >= 1))
        {
            if (canFire("OML_Iso_egf_Ausfahrt_Fz"))
            {
                --OML_Iso_egf_$belegt;
                ++OML_Iso_egf_$frei;
                --OML_Iso_egf_$Zug_ausfahren;
                fire("OML_Iso_egf_Ausfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_egf_Einfahrt_Fz can fire
        if ( (OML_Iso_egf_$frei >= 1) &&
                (OML_Iso_egf_$Zug_einfahren >= 1) &&
                (OML_Iso_egf_$belegt <= 0))
        {
            if (canFire("OML_Iso_egf_Einfahrt_Fz"))
            {
                --OML_Iso_egf_$frei;
                --OML_Iso_egf_$Zug_einfahren;
                ++OML_Iso_egf_$belegt;
                fire("OML_Iso_egf_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_cd_Einfahrt_Fz can fire
        if ( (OML_Iso_cd_$frei >= 1) &&
                (OML_Iso_cd_$belegt <= 0) &&
                (OML_Iso_cd_$Zug_einfahren >= 1))
        {
            if (canFire("OML_Iso_cd_Einfahrt_Fz"))
            {
                --OML_Iso_cd_$frei;
                ++OML_Iso_cd_$belegt;
                --OML_Iso_cd_$Zug_einfahren;
                fire("OML_Iso_cd_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_cd_Ausfahrt_Fz can fire
        if ( (OML_Iso_cd_$Zug_ausfahren >= 1) &&
                (OML_Iso_cd_$frei <= 0) &&
                (OML_Iso_cd_$belegt >= 1))
        {
            if (canFire("OML_Iso_cd_Ausfahrt_Fz"))
            {
                --OML_Iso_cd_$Zug_ausfahren;
                ++OML_Iso_cd_$frei;
                --OML_Iso_cd_$belegt;
                fire("OML_Iso_cd_Ausfahrt_Fz");
                return true;
            }
        }
        //check if OML_BL_OM_LN_blocken_n_gf can fire
        if ( (OML_Iso_egf_$belegt >= 1) &&
                (OML_BL_OM_LN_$vorgebl_n >= 1) &&
                (OML_BL_OM_LN_$belegt_n <= 0) &&
                (OML_Fstr_gf_$G_Halt >= 1))
        {
            if (canFire("OML_BL_OM_LN_blocken_n_gf"))
            {
                --OML_BL_OM_LN_$vorgebl_n;
                ++OML_BL_OM_LN_$belegt_n;
                fire("OML_BL_OM_LN_blocken_n_gf");
                return true;
            }
        }
        //check if OML_BL_OM_LN_1_belegt can fire
        if ( (OML_BL_OM_LN_$2 >= 1) &&
                (OML_BL_OM_LN_$3 <= 0) &&
                (OML_Iso_1_$belegt >= 1))
        {
            if (canFire("OML_BL_OM_LN_1_belegt"))
            {
                --OML_BL_OM_LN_$2;
                ++OML_BL_OM_LN_$3;
                fire("OML_BL_OM_LN_1_belegt");
                return true;
            }
        }
        //check if OML_BL_OM_LN_blocken_n_ef can fire
        if ( (OML_Fstr_ef_$E_Halt >= 1) &&
                (OML_Iso_egf_$belegt >= 1) &&
                (OML_BL_OM_LN_$vorgebl_n >= 1) &&
                (OML_BL_OM_LN_$belegt_n <= 0))
        {
            if (canFire("OML_BL_OM_LN_blocken_n_ef"))
            {
                --OML_BL_OM_LN_$vorgebl_n;
                ++OML_BL_OM_LN_$belegt_n;
                fire("OML_BL_OM_LN_blocken_n_ef");
                return true;
            }
        }
        //check if OML_BL_OM_LN_vormelden_n_gf can fire
        if ( (OML_BL_OM_LN_$vorgebl_n <= 0) &&
                (OML_Fstr_gf_$verschlossen >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n >= 1))
        {
            if (canFire("OML_BL_OM_LN_vormelden_n_gf"))
            {
                ++OML_BL_OM_LN_$vorgebl_n;
                --OML_BL_OM_LN_$Grundstlg_n;
                fire("OML_BL_OM_LN_vormelden_n_gf");
                return true;
            }
        }
        //check if OML_BL_OM_LN_vormelden_von can fire
        if ( (OML_LN_$C26_Fahrt >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_BL_OM_LN_$vorgebl_v <= 0))
        {
            if (canFire("OML_BL_OM_LN_vormelden_von"))
            {
                --OML_BL_OM_LN_$Grundstlg_v;
                ++OML_BL_OM_LN_$vorgebl_v;
                fire("OML_BL_OM_LN_vormelden_von");
                return true;
            }
        }
        //check if OML_BL_OM_LN_rueckmelden_n can fire
        if ( (OML_ILTIS_$RM_LN_OM >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n <= 0) &&
                (OML_BL_OM_LN_$belegt_n >= 1))
        {
            if (canFire("OML_BL_OM_LN_rueckmelden_n"))
            {
                ++OML_BL_OM_LN_$Grundstlg_n;
                --OML_BL_OM_LN_$belegt_n;
                fire("OML_BL_OM_LN_rueckmelden_n");
                return true;
            }
        }
        //check if OML_BL_OM_LN_blocken_von can fire
        if ( (OML_BL_OM_LN_$vorgebl_v >= 1) &&
                (OML_BL_OM_LN_$belegt_v <= 0) &&
                (OML_LN_$ce_belegt >= 1))
        {
            if (canFire("OML_BL_OM_LN_blocken_von"))
            {
                --OML_BL_OM_LN_$vorgebl_v;
                ++OML_BL_OM_LN_$belegt_v;
                fire("OML_BL_OM_LN_blocken_von");
                return true;
            }
        }
        //check if OML_BL_OM_LN_T1 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_LN_$C1_Fahrt2 >= 1) &&
                (OML_BL_OM_LN_$vorgebl_v <= 0))
        {
            if (canFire("OML_BL_OM_LN_T1"))
            {
                --OML_BL_OM_LN_$Grundstlg_v;
                ++OML_BL_OM_LN_$vorgebl_v;
                fire("OML_BL_OM_LN_T1");
                return true;
            }
        }
        //check if OML_BL_OM_LN_Fahrt1_pruefen can fire
        if ( (OML_BL_OM_LN_$1 <= 0) &&
                (OML_Fstr_fe_$F_Fahrt1 >= 1) &&
                (OML_BL_OM_LN_$belegt_v >= 1))
        {
            if (canFire("OML_BL_OM_LN_Fahrt1_pruefen"))
            {
                ++OML_BL_OM_LN_$1;
                fire("OML_BL_OM_LN_Fahrt1_pruefen");
                return true;
            }
        }
        //check if OML_BL_OM_LN_Richtungs__wechsel_v can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v <= 0) &&
                (OML_ILTIS_$anfordern_vLN >= 1) &&
                (OML_Kontakte_$6_FBF_nLN < 1) &&
                (OML_BL_OM_LN_$Grundstlg_n >= 1))
        {
            if (canFire("OML_BL_OM_LN_Richtungs__wechsel_v"))
            {
                ++OML_BL_OM_LN_$Grundstlg_v;
                --OML_BL_OM_LN_$Grundstlg_n;
                fire("OML_BL_OM_LN_Richtungs__wechsel_v");
                return true;
            }
        }
        //check if OML_BL_OM_LN_rueckmelden_von can fire
        if ( (OML_Kontakte_$6_RM_nLN >= 1) &&
                (OML_BL_OM_LN_$belegt_v >= 1) &&
                (OML_BL_OM_LN_$RMM_nLN >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_v <= 0))
        {
            if (canFire("OML_BL_OM_LN_rueckmelden_von"))
            {
                --OML_BL_OM_LN_$belegt_v;
                --OML_BL_OM_LN_$RMM_nLN;
                ++OML_BL_OM_LN_$Grundstlg_v;
                fire("OML_BL_OM_LN_rueckmelden_von");
                return true;
            }
        }
        //check if OML_BL_OM_LN_Fahrt3_pruefen can fire
        if ( (OML_BL_OM_LN_$1 <= 0) &&
                (OML_Fstr_fg_$F_Fahrt3 >= 1) &&
                (OML_BL_OM_LN_$belegt_v >= 1))
        {
            if (canFire("OML_BL_OM_LN_Fahrt3_pruefen"))
            {
                ++OML_BL_OM_LN_$1;
                fire("OML_BL_OM_LN_Fahrt3_pruefen");
                return true;
            }
        }
        //check if OML_BL_OM_LN_vormelden_n_ef can fire
        if ( (OML_BL_OM_LN_$vorgebl_n <= 0) &&
                (OML_Fstr_ef_$verschlossen >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n >= 1))
        {
            if (canFire("OML_BL_OM_LN_vormelden_n_ef"))
            {
                ++OML_BL_OM_LN_$vorgebl_n;
                --OML_BL_OM_LN_$Grundstlg_n;
                fire("OML_BL_OM_LN_vormelden_n_ef");
                return true;
            }
        }
        //check if OML_BL_OM_LN_Richtungs__wechsel_n can fire
        if ( (OML_Kontakte_$6_FBA_nLN >= 1) &&
                (OML_ILTIS_$festgehalten_vLN < 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n <= 0))
        {
            if (canFire("OML_BL_OM_LN_Richtungs__wechsel_n"))
            {
                --OML_BL_OM_LN_$Grundstlg_v;
                ++OML_BL_OM_LN_$Grundstlg_n;
                fire("OML_BL_OM_LN_Richtungs__wechsel_n");
                return true;
            }
        }
        //check if OML_BL_OM_LN_T2 can fire
        if ( (OML_BL_OM_LN_$2 <= 0) &&
                (OML_BL_OM_LN_$1 >= 1) &&
                (OML_Fstr_fe_$F_Halt >= 1))
        {
            if (canFire("OML_BL_OM_LN_T2"))
            {
                ++OML_BL_OM_LN_$2;
                --OML_BL_OM_LN_$1;
                fire("OML_BL_OM_LN_T2");
                return true;
            }
        }
        //check if OML_BL_OM_LN_Signal_Halt can fire
        if ( (OML_BL_OM_LN_$2 <= 0) &&
                (OML_BL_OM_LN_$1 >= 1) &&
                (OML_Fstr_fg_$F_Halt >= 1))
        {
            if (canFire("OML_BL_OM_LN_Signal_Halt"))
            {
                ++OML_BL_OM_LN_$2;
                --OML_BL_OM_LN_$1;
                fire("OML_BL_OM_LN_Signal_Halt");
                return true;
            }
        }
        //check if OML_BL_OM_LN_1_frei can fire
        if ( (OML_BL_OM_LN_$3 >= 1) &&
                (OML_Iso_1_$frei >= 1) &&
                (OML_BL_OM_LN_$RMM_nLN <= 0))
        {
            if (canFire("OML_BL_OM_LN_1_frei"))
            {
                --OML_BL_OM_LN_$3;
                ++OML_BL_OM_LN_$RMM_nLN;
                fire("OML_BL_OM_LN_1_frei");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_1_belegt can fire
        if ( (OML_BL_ZB_OM_$3 <= 0) &&
                (OML_BL_ZB_OM_$2 >= 1) &&
                (OML_Iso_1_$belegt >= 1))
        {
            if (canFire("OML_BL_ZB_OM_1_belegt"))
            {
                ++OML_BL_ZB_OM_$3;
                --OML_BL_ZB_OM_$2;
                fire("OML_BL_ZB_OM_1_belegt");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_vormelden_v can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
                (OML_BL_ZB_OM_$vorgebl_v <= 0) &&
                (OML_ZB_$C_Fahrt >= 1))
        {
            if (canFire("OML_BL_ZB_OM_vormelden_v"))
            {
                --OML_BL_ZB_OM_$Grundstlg_v;
                ++OML_BL_ZB_OM_$vorgebl_v;
                fire("OML_BL_ZB_OM_vormelden_v");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_blocken_v can fire
        if ( (OML_BL_ZB_OM_$vorgebl_v >= 1) &&
                (OML_BL_ZB_OM_$belegt_v <= 0) &&
                (OML_ZB_$cd_belegt >= 1))
        {
            if (canFire("OML_BL_ZB_OM_blocken_v"))
            {
                --OML_BL_ZB_OM_$vorgebl_v;
                ++OML_BL_ZB_OM_$belegt_v;
                fire("OML_BL_ZB_OM_blocken_v");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_Richtungs__wechsel_n can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_n <= 0) &&
                (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
                (OML_Kontakte_$6_FBA_nZB >= 1) &&
                (OML_ILTIS_$festgehalten_v_ZB < 1))
        {
            if (canFire("OML_BL_ZB_OM_Richtungs__wechsel_n"))
            {
                ++OML_BL_ZB_OM_$Grundstlg_n;
                --OML_BL_ZB_OM_$Grundstlg_v;
                fire("OML_BL_ZB_OM_Richtungs__wechsel_n");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_Richtungs__wechsel_v can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_n >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v <= 0) &&
                (OML_Kontakte_$6_FBA_nZB < 1) &&
                (OML_ILTIS_$anfordern_vZB >= 1))
        {
            if (canFire("OML_BL_ZB_OM_Richtungs__wechsel_v"))
            {
                --OML_BL_ZB_OM_$Grundstlg_n;
                ++OML_BL_ZB_OM_$Grundstlg_v;
                fire("OML_BL_ZB_OM_Richtungs__wechsel_v");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_1_frei can fire
        if ( (OML_BL_ZB_OM_$RMM_nZB <= 0) &&
                (OML_BL_ZB_OM_$3 >= 1) &&
                (OML_Iso_1_$frei >= 1))
        {
            if (canFire("OML_BL_ZB_OM_1_frei"))
            {
                ++OML_BL_ZB_OM_$RMM_nZB;
                --OML_BL_ZB_OM_$3;
                fire("OML_BL_ZB_OM_1_frei");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_rueckmelden_n can fire
        if ( (OML_BL_ZB_OM_$belegt_n >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_n <= 0) &&
                (OML_ILTIS_$RM_ZB_OM >= 1))
        {
            if (canFire("OML_BL_ZB_OM_rueckmelden_n"))
            {
                --OML_BL_ZB_OM_$belegt_n;
                ++OML_BL_ZB_OM_$Grundstlg_n;
                fire("OML_BL_ZB_OM_rueckmelden_n");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_blocken_N can fire
        if ( (OML_BL_ZB_OM_$vorgebl_n >= 1) &&
                (OML_BL_ZB_OM_$belegt_n <= 0) &&
                (OML_Iso_1_$belegt >= 1))
        {
            if (canFire("OML_BL_ZB_OM_blocken_N"))
            {
                --OML_BL_ZB_OM_$vorgebl_n;
                ++OML_BL_ZB_OM_$belegt_n;
                fire("OML_BL_ZB_OM_blocken_N");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_G_Fahrt can fire
        if ( (OML_BL_ZB_OM_$1 <= 0) &&
                (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_BL_ZB_OM_$belegt_v >= 1))
        {
            if (canFire("OML_BL_ZB_OM_G_Fahrt"))
            {
                ++OML_BL_ZB_OM_$1;
                fire("OML_BL_ZB_OM_G_Fahrt");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_rueckmelden_von can fire
        if ( (OML_BL_ZB_OM_$RMM_nZB >= 1) &&
                (OML_BL_ZB_OM_$belegt_v >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v <= 0) &&
                (OML_Kontakte_$6_RM_nZB >= 1))
        {
            if (canFire("OML_BL_ZB_OM_rueckmelden_von"))
            {
                --OML_BL_ZB_OM_$RMM_nZB;
                --OML_BL_ZB_OM_$belegt_v;
                ++OML_BL_ZB_OM_$Grundstlg_v;
                fire("OML_BL_ZB_OM_rueckmelden_von");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_G_Halt can fire
        if ( (OML_BL_ZB_OM_$2 <= 0) &&
                (OML_BL_ZB_OM_$1 >= 1) &&
                (OML_Fstr_gf_$G_Halt >= 1))
        {
            if (canFire("OML_BL_ZB_OM_G_Halt"))
            {
                ++OML_BL_ZB_OM_$2;
                --OML_BL_ZB_OM_$1;
                fire("OML_BL_ZB_OM_G_Halt");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_vormelden_n can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_n >= 1) &&
                (OML_BL_ZB_OM_$vorgebl_n <= 0) &&
                (OML_Fstr_fg_$verschlossen >= 1))
        {
            if (canFire("OML_BL_ZB_OM_vormelden_n"))
            {
                --OML_BL_ZB_OM_$Grundstlg_n;
                ++OML_BL_ZB_OM_$vorgebl_n;
                fire("OML_BL_ZB_OM_vormelden_n");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T117 can fire
        if ( (OML_Lampen_WS1_$1_WS1_Freig >= 1) &&
                (OML_Stw_W1_SM_$WS_Sperrm_ein < 1))
        {
            if (canFire("OML_Lampen_WS1_T117"))
            {
                --OML_Lampen_WS1_$1_WS1_Freig;
                fire("OML_Lampen_WS1_T117");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T16 can fire
        if ( (OML_Stw_W1_SM_$WS_Sperrm_ein >= 1) &&
                (OML_Lampen_WS1_$1_WS1_Freig <= 0))
        {
            if (canFire("OML_Lampen_WS1_T16"))
            {
                ++OML_Lampen_WS1_$1_WS1_Freig;
                fire("OML_Lampen_WS1_T16");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T13 can fire
        if ( (OML_Lampen_WS1_$1_WS1_Ueberw >= 1) &&
                (OML_Stw_W1_$Endlage_minus < 1) &&
                (OML_Stw_W1_$Endlage_plus < 1))
        {
            if (canFire("OML_Lampen_WS1_T13"))
            {
                --OML_Lampen_WS1_$1_WS1_Ueberw;
                fire("OML_Lampen_WS1_T13");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T20 can fire
        if ( (OML_Stw_W1_$Endlage_minus >= 1) &&
                (OML_Lampen_WS1_$1_WS1_Ueberw <= 0))
        {
            if (canFire("OML_Lampen_WS1_T20"))
            {
                ++OML_Lampen_WS1_$1_WS1_Ueberw;
                fire("OML_Lampen_WS1_T20");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T412 can fire
        if ( (OML_Stw_W1_$Endlage_plus >= 1) &&
                (OML_Lampen_WS1_$1_WS1_Ueberw <= 0))
        {
            if (canFire("OML_Lampen_WS1_T412"))
            {
                ++OML_Lampen_WS1_$1_WS1_Ueberw;
                fire("OML_Lampen_WS1_T412");
                return true;
            }
        }
        //check if OML_Lampen_Stoerung_T15 can fire
        if ( (OML_ext_Vb_$F_VS_Lampe_Fahrt_def < 1) &&
                (OML_Lampen_Stoerung_$1_F_VS_Stoer >= 1))
        {
            if (canFire("OML_Lampen_Stoerung_T15"))
            {
                --OML_Lampen_Stoerung_$1_F_VS_Stoer;
                fire("OML_Lampen_Stoerung_T15");
                return true;
            }
        }
        //check if OML_Lampen_Stoerung_T17 can fire
        if ( (OML_ext_Vb_$G_VS_Lampe_Warn_def < 1) &&
                (OML_Lampen_Stoerung_$1_G_VS_Stoer >= 1))
        {
            if (canFire("OML_Lampen_Stoerung_T17"))
            {
                --OML_Lampen_Stoerung_$1_G_VS_Stoer;
                fire("OML_Lampen_Stoerung_T17");
                return true;
            }
        }
        //check if OML_Lampen_Stoerung_T14 can fire
        if ( (OML_ext_Vb_$F_VS_Lampe_Warn_def < 1) &&
                (OML_Lampen_Stoerung_$1_F_VS_Stoer >= 1))
        {
            if (canFire("OML_Lampen_Stoerung_T14"))
            {
                --OML_Lampen_Stoerung_$1_F_VS_Stoer;
                fire("OML_Lampen_Stoerung_T14");
                return true;
            }
        }
        //check if OML_Lampen_Stoerung_T1 can fire
        if ( (OML_ext_Vb_$G_VS_Lampe_Warn_def >= 1) &&
                (OML_Lampen_Stoerung_$1_G_VS_Stoer <= 0))
        {
            if (canFire("OML_Lampen_Stoerung_T1"))
            {
                ++OML_Lampen_Stoerung_$1_G_VS_Stoer;
                fire("OML_Lampen_Stoerung_T1");
                return true;
            }
        }
        //check if OML_Lampen_Stoerung_T2 can fire
        if ( (OML_ext_Vb_$G_VS_Lampe_Fahrt_def >= 1) &&
                (OML_Lampen_Stoerung_$1_G_VS_Stoer <= 0))
        {
            if (canFire("OML_Lampen_Stoerung_T2"))
            {
                ++OML_Lampen_Stoerung_$1_G_VS_Stoer;
                fire("OML_Lampen_Stoerung_T2");
                return true;
            }
        }
        //check if OML_Lampen_Stoerung_T3 can fire
        if ( (OML_ext_Vb_$F_VS_Lampe_Warn_def >= 1) &&
                (OML_Lampen_Stoerung_$1_F_VS_Stoer <= 0))
        {
            if (canFire("OML_Lampen_Stoerung_T3"))
            {
                ++OML_Lampen_Stoerung_$1_F_VS_Stoer;
                fire("OML_Lampen_Stoerung_T3");
                return true;
            }
        }
        //check if OML_Lampen_Stoerung_T4 can fire
        if ( (OML_ext_Vb_$F_VS_Lampe_Fahrt_def >= 1) &&
                (OML_Lampen_Stoerung_$1_F_VS_Stoer <= 0))
        {
            if (canFire("OML_Lampen_Stoerung_T4"))
            {
                ++OML_Lampen_Stoerung_$1_F_VS_Stoer;
                fire("OML_Lampen_Stoerung_T4");
                return true;
            }
        }
        //check if OML_Lampen_Stoerung_T6 can fire
        if ( (OML_ext_Vb_$G_VS_Lampe_Fahrt_def < 1) &&
                (OML_Lampen_Stoerung_$1_G_VS_Stoer >= 1))
        {
            if (canFire("OML_Lampen_Stoerung_T6"))
            {
                --OML_Lampen_Stoerung_$1_G_VS_Stoer;
                fire("OML_Lampen_Stoerung_T6");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T2 can fire
        if ( (OML_Lampen_Streckenblock_$1_FBV_vZB >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v < 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T2"))
            {
                --OML_Lampen_Streckenblock_$1_FBV_vZB;
                fire("OML_Lampen_Streckenblock_T2");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T58 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_nZB_weiss <= 0) &&
                (OML_BL_ZB_OM_$vorgebl_n >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T58"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_nZB_weiss;
                fire("OML_Lampen_Streckenblock_T58");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T139 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_vLN_weiss <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T139"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_vLN_weiss;
                fire("OML_Lampen_Streckenblock_T139");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T52 can fire
        if ( (OML_BL_ZB_OM_$belegt_n >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_nZB_rot <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T52"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_nZB_rot;
                fire("OML_Lampen_Streckenblock_T52");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T3 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_ILTIS_$anfordern_vLN < 1) &&
                (OML_Lampen_Streckenblock_$1_FBV_vLN >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T3"))
            {
                --OML_Lampen_Streckenblock_$1_FBV_vLN;
                fire("OML_Lampen_Streckenblock_T3");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T351 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_nZB_rot >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_n >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T351"))
            {
                --OML_Lampen_Streckenblock_$1_BL_nZB_rot;
                fire("OML_Lampen_Streckenblock_T351");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T42 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_vZB_rot >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T42"))
            {
                --OML_Lampen_Streckenblock_$1_BL_vZB_rot;
                fire("OML_Lampen_Streckenblock_T42");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T46 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_vZB_weiss >= 1) &&
                (OML_BL_ZB_OM_$vorgebl_v < 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T46"))
            {
                --OML_Lampen_Streckenblock_$1_BL_vZB_weiss;
                fire("OML_Lampen_Streckenblock_T46");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T25 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_nLN_rot <= 0) &&
                (OML_BL_OM_LN_$belegt_n >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T25"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_nLN_rot;
                fire("OML_Lampen_Streckenblock_T25");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T47 can fire
        if ( (OML_BL_ZB_OM_$belegt_v >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_vZB_weiss <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T47"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_vZB_weiss;
                fire("OML_Lampen_Streckenblock_T47");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T23 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_nLN_rot >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T23"))
            {
                --OML_Lampen_Streckenblock_$1_BL_nLN_rot;
                fire("OML_Lampen_Streckenblock_T23");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T48 can fire
        if ( (OML_BL_ZB_OM_$belegt_v >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_vZB_weiss >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T48"))
            {
                --OML_Lampen_Streckenblock_$1_BL_vZB_weiss;
                fire("OML_Lampen_Streckenblock_T48");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T34 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_nLN_weiss >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n < 1) &&
                (OML_BL_OM_LN_$vorgebl_n < 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T34"))
            {
                --OML_Lampen_Streckenblock_$1_BL_nLN_weiss;
                fire("OML_Lampen_Streckenblock_T34");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T1 can fire
        if ( (OML_ILTIS_$anfordern_vZB >= 1) &&
                (OML_Lampen_Streckenblock_$1_FBV_vZB <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T1"))
            {
                ++OML_Lampen_Streckenblock_$1_FBV_vZB;
                fire("OML_Lampen_Streckenblock_T1");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T35 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_n >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_nLN_weiss <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T35"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_nLN_weiss;
                fire("OML_Lampen_Streckenblock_T35");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T43 can fire
        if ( (OML_BL_ZB_OM_$vorgebl_v >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_vZB_rot <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T43"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_vZB_rot;
                fire("OML_Lampen_Streckenblock_T43");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T141 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_vLN_weiss <= 0) &&
                (OML_BL_OM_LN_$vorgebl_v >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T141"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_vLN_weiss;
                fire("OML_Lampen_Streckenblock_T141");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T49 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_vZB_weiss <= 0) &&
                (OML_BL_ZB_OM_$vorgebl_v >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T49"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_vZB_weiss;
                fire("OML_Lampen_Streckenblock_T49");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T21 can fire
        if ( (OML_BL_OM_LN_$belegt_v >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_vLN_rot <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T21"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_vLN_rot;
                fire("OML_Lampen_Streckenblock_T21");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T138 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v < 1) &&
                (OML_Lampen_Streckenblock_$1_BL_vLN_weiss >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T138"))
            {
                --OML_Lampen_Streckenblock_$1_BL_vLN_weiss;
                fire("OML_Lampen_Streckenblock_T138");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T45 can fire
        if ( (OML_BL_ZB_OM_$belegt_v >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_vZB_rot <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T45"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_vZB_rot;
                fire("OML_Lampen_Streckenblock_T45");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T137 can fire
        if ( (OML_ILTIS_$anfordern_vLN >= 1) &&
                (OML_Lampen_Streckenblock_$1_FBV_vLN <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T137"))
            {
                ++OML_Lampen_Streckenblock_$1_FBV_vLN;
                fire("OML_Lampen_Streckenblock_T137");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T4 can fire
        if ( (OML_BL_OM_LN_$vorgebl_v >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_vLN_rot <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T4"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_vLN_rot;
                fire("OML_Lampen_Streckenblock_T4");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T140 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_vLN_weiss >= 1) &&
                (OML_BL_OM_LN_$belegt_v >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T140"))
            {
                --OML_Lampen_Streckenblock_$1_BL_vLN_weiss;
                fire("OML_Lampen_Streckenblock_T140");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T54 can fire
        if ( (OML_BL_ZB_OM_$vorgebl_n >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_nZB_rot <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T54"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_nZB_rot;
                fire("OML_Lampen_Streckenblock_T54");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T24 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_nLN_rot <= 0) &&
                (OML_BL_OM_LN_$vorgebl_n >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T24"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_nLN_rot;
                fire("OML_Lampen_Streckenblock_T24");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T56 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_nZB_weiss <= 0) &&
                (OML_BL_ZB_OM_$Grundstlg_n >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T56"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_nZB_weiss;
                fire("OML_Lampen_Streckenblock_T56");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T5 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_Lampen_Streckenblock_$1_BL_vLN_rot >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T5"))
            {
                --OML_Lampen_Streckenblock_$1_BL_vLN_rot;
                fire("OML_Lampen_Streckenblock_T5");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T136 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_nLN_weiss <= 0) &&
                (OML_BL_OM_LN_$vorgebl_n >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T136"))
            {
                ++OML_Lampen_Streckenblock_$1_BL_nLN_weiss;
                fire("OML_Lampen_Streckenblock_T136");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T55 can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_n < 1) &&
                (OML_BL_ZB_OM_$vorgebl_n < 1) &&
                (OML_Lampen_Streckenblock_$1_BL_nZB_weiss >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T55"))
            {
                --OML_Lampen_Streckenblock_$1_BL_nZB_weiss;
                fire("OML_Lampen_Streckenblock_T55");
                return true;
            }
        }
        //check if OML_Lampen_Fahrstrasse_T7 can fire
        if ( (OML_Lampen_Fahrstrasse_$1_Fstr_ef >= 1) &&
                (OML_Fstr_ef_$aufgeloest >= 1) &&
                (OML_Fstr_fe_$aufgeloest >= 1))
        {
            if (canFire("OML_Lampen_Fahrstrasse_T7"))
            {
                --OML_Lampen_Fahrstrasse_$1_Fstr_ef;
                fire("OML_Lampen_Fahrstrasse_T7");
                return true;
            }
        }
        //check if OML_Lampen_Fahrstrasse_T6 can fire
        if ( (OML_Lampen_Fahrstrasse_$1_Fstr_ef <= 0) &&
                (OML_Fstr_ef_$verschlossen >= 1))
        {
            if (canFire("OML_Lampen_Fahrstrasse_T6"))
            {
                ++OML_Lampen_Fahrstrasse_$1_Fstr_ef;
                fire("OML_Lampen_Fahrstrasse_T6");
                return true;
            }
        }
        //check if OML_Lampen_Fahrstrasse_T9 can fire
        if ( (OML_Lampen_Fahrstrasse_$1_Fstr_gf >= 1) &&
                (OML_Fstr_gf_$aufgeloest >= 1) &&
                (OML_Fstr_fg_$aufgeloest >= 1))
        {
            if (canFire("OML_Lampen_Fahrstrasse_T9"))
            {
                --OML_Lampen_Fahrstrasse_$1_Fstr_gf;
                fire("OML_Lampen_Fahrstrasse_T9");
                return true;
            }
        }
        //check if OML_Lampen_Fahrstrasse_T18 can fire
        if ( (OML_Lampen_Fahrstrasse_$1_Fstr_ef <= 0) &&
                (OML_Fstr_fe_$verschlossen >= 1))
        {
            if (canFire("OML_Lampen_Fahrstrasse_T18"))
            {
                ++OML_Lampen_Fahrstrasse_$1_Fstr_ef;
                fire("OML_Lampen_Fahrstrasse_T18");
                return true;
            }
        }
        //check if OML_Lampen_Fahrstrasse_T8 can fire
        if ( (OML_Fstr_gf_$verschlossen >= 1) &&
                (OML_Lampen_Fahrstrasse_$1_Fstr_gf <= 0))
        {
            if (canFire("OML_Lampen_Fahrstrasse_T8"))
            {
                ++OML_Lampen_Fahrstrasse_$1_Fstr_gf;
                fire("OML_Lampen_Fahrstrasse_T8");
                return true;
            }
        }
        //check if OML_Lampen_Fahrstrasse_T19 can fire
        if ( (OML_Fstr_fg_$verschlossen >= 1) &&
                (OML_Lampen_Fahrstrasse_$1_Fstr_gf <= 0))
        {
            if (canFire("OML_Lampen_Fahrstrasse_T19"))
            {
                ++OML_Lampen_Fahrstrasse_$1_Fstr_gf;
                fire("OML_Lampen_Fahrstrasse_T19");
                return true;
            }
        }
        //check if OML_Lampen_Isolierung_T92 can fire
        if ( (OML_Iso_cd_$frei >= 1) &&
                (OML_Lampen_Isolierung_$Iso_cd_ein >= 1))
        {
            if (canFire("OML_Lampen_Isolierung_T92"))
            {
                --OML_Lampen_Isolierung_$Iso_cd_ein;
                fire("OML_Lampen_Isolierung_T92");
                return true;
            }
        }
        //check if OML_Lampen_Isolierung_T95 can fire
        if ( (OML_Iso_1_$frei < 1) &&
                (OML_Lampen_Isolierung_$Iso_1_ein <= 0))
        {
            if (canFire("OML_Lampen_Isolierung_T95"))
            {
                ++OML_Lampen_Isolierung_$Iso_1_ein;
                fire("OML_Lampen_Isolierung_T95");
                return true;
            }
        }
        //check if OML_Lampen_Isolierung_T96 can fire
        if ( (OML_Iso_1_$frei >= 1) &&
                (OML_Lampen_Isolierung_$Iso_1_ein >= 1))
        {
            if (canFire("OML_Lampen_Isolierung_T96"))
            {
                --OML_Lampen_Isolierung_$Iso_1_ein;
                fire("OML_Lampen_Isolierung_T96");
                return true;
            }
        }
        //check if OML_Lampen_Isolierung_T97 can fire
        if ( (OML_Iso_ef_$frei < 1) &&
                (OML_Lampen_Isolierung_$Iso_ef_ein <= 0))
        {
            if (canFire("OML_Lampen_Isolierung_T97"))
            {
                ++OML_Lampen_Isolierung_$Iso_ef_ein;
                fire("OML_Lampen_Isolierung_T97");
                return true;
            }
        }
        //check if OML_Lampen_Isolierung_T93 can fire
        if ( (OML_Iso_egf_$frei < 1) &&
                (OML_Lampen_Isolierung_$Iso_egf_ein <= 0))
        {
            if (canFire("OML_Lampen_Isolierung_T93"))
            {
                ++OML_Lampen_Isolierung_$Iso_egf_ein;
                fire("OML_Lampen_Isolierung_T93");
                return true;
            }
        }
        //check if OML_Lampen_Isolierung_T91 can fire
        if ( (OML_Iso_cd_$frei < 1) &&
                (OML_Lampen_Isolierung_$Iso_cd_ein <= 0))
        {
            if (canFire("OML_Lampen_Isolierung_T91"))
            {
                ++OML_Lampen_Isolierung_$Iso_cd_ein;
                fire("OML_Lampen_Isolierung_T91");
                return true;
            }
        }
        //check if OML_Lampen_Isolierung_T94 can fire
        if ( (OML_Iso_egf_$frei >= 1) &&
                (OML_Lampen_Isolierung_$Iso_egf_ein >= 1))
        {
            if (canFire("OML_Lampen_Isolierung_T94"))
            {
                --OML_Lampen_Isolierung_$Iso_egf_ein;
                fire("OML_Lampen_Isolierung_T94");
                return true;
            }
        }
        //check if OML_Lampen_Isolierung_T98 can fire
        if ( (OML_Iso_ef_$frei >= 1) &&
                (OML_Lampen_Isolierung_$Iso_ef_ein >= 1))
        {
            if (canFire("OML_Lampen_Isolierung_T98"))
            {
                --OML_Lampen_Isolierung_$Iso_ef_ein;
                fire("OML_Lampen_Isolierung_T98");
                return true;
            }
        }
        //check if OML_Lampen_Signal_E_entry_E_rot can fire
        if ( (OML_Lampen_Signal_E_$1_E_rot <= 0) &&
                (OML_Fstr_ef_$E_Halt >= 1))
        {
            if (canFire("OML_Lampen_Signal_E_entry_E_rot"))
            {
                ++OML_Lampen_Signal_E_$1_E_rot;
                fire("OML_Lampen_Signal_E_entry_E_rot");
                return true;
            }
        }
        //check if OML_Lampen_Signal_E_entry_E_FB1 can fire
        if ( (OML_Fstr_ef_$E_Fahrt1 >= 1) &&
                (OML_Lampen_Signal_E_$1_E_gruenFB1 <= 0))
        {
            if (canFire("OML_Lampen_Signal_E_entry_E_FB1"))
            {
                ++OML_Lampen_Signal_E_$1_E_gruenFB1;
                fire("OML_Lampen_Signal_E_entry_E_FB1");
                return true;
            }
        }
        //check if OML_Lampen_Signal_E_exit_E_rot can fire
        if ( (OML_Lampen_Signal_E_$1_E_rot >= 1) &&
                (OML_Fstr_ef_$E_Halt < 1))
        {
            if (canFire("OML_Lampen_Signal_E_exit_E_rot"))
            {
                --OML_Lampen_Signal_E_$1_E_rot;
                fire("OML_Lampen_Signal_E_exit_E_rot");
                return true;
            }
        }
        //check if OML_Lampen_Signal_E_exit_E_gruenFB1 can fire
        if ( (OML_Fstr_ef_$E_Fahrt1 < 1) &&
                (OML_Lampen_Signal_E_$1_E_gruenFB1 >= 1))
        {
            if (canFire("OML_Lampen_Signal_E_exit_E_gruenFB1"))
            {
                --OML_Lampen_Signal_E_$1_E_gruenFB1;
                fire("OML_Lampen_Signal_E_exit_E_gruenFB1");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_entry_F_gruenFB3 can fire
        if ( (OML_Fstr_fg_$F_Fahrt3 >= 1) &&
                (OML_Lampen_Signal_F_$1_F_gruenFB1 <= 0))
        {
            if (canFire("OML_Lampen_Signal_F_entry_F_gruenFB3"))
            {
                ++OML_Lampen_Signal_F_$1_F_gruenFB1;
                fire("OML_Lampen_Signal_F_entry_F_gruenFB3");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_entry_F_gruenFB3_2 can fire
        if ( (OML_Fstr_fg_$F_Fahrt3 >= 1) &&
                (OML_Lampen_Signal_F_$1_F_gruenFB3 <= 0))
        {
            if (canFire("OML_Lampen_Signal_F_entry_F_gruenFB3_2"))
            {
                ++OML_Lampen_Signal_F_$1_F_gruenFB3;
                fire("OML_Lampen_Signal_F_entry_F_gruenFB3_2");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_exit_F_gruenFB3_2 can fire
        if ( (OML_Lampen_Signal_F_$1_F_gruenFB3 >= 1) &&
                (OML_Fstr_fg_$F_Fahrt3 < 1))
        {
            if (canFire("OML_Lampen_Signal_F_exit_F_gruenFB3_2"))
            {
                --OML_Lampen_Signal_F_$1_F_gruenFB3;
                fire("OML_Lampen_Signal_F_exit_F_gruenFB3_2");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_entry_F_rot_fg can fire
        if ( (OML_Fstr_fg_$F_Halt >= 1) &&
                (OML_Lampen_Signal_F_$1_F_rot <= 0) &&
                (OML_Fstr_fe_$F_Halt >= 1))
        {
            if (canFire("OML_Lampen_Signal_F_entry_F_rot_fg"))
            {
                ++OML_Lampen_Signal_F_$1_F_rot;
                fire("OML_Lampen_Signal_F_entry_F_rot_fg");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_exit_F_rot_fg can fire
        if ( (OML_Fstr_fg_$F_Halt < 1) &&
                (OML_Lampen_Signal_F_$1_F_rot >= 1))
        {
            if (canFire("OML_Lampen_Signal_F_exit_F_rot_fg"))
            {
                --OML_Lampen_Signal_F_$1_F_rot;
                fire("OML_Lampen_Signal_F_exit_F_rot_fg");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_entry_F_gruenFB1_fe can fire
        if ( (OML_Fstr_fe_$F_Fahrt1 >= 1) &&
                (OML_Lampen_Signal_F_$1_F_gruenFB1 <= 0))
        {
            if (canFire("OML_Lampen_Signal_F_entry_F_gruenFB1_fe"))
            {
                ++OML_Lampen_Signal_F_$1_F_gruenFB1;
                fire("OML_Lampen_Signal_F_entry_F_gruenFB1_fe");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_exit_F_gruenFB1_fe can fire
        if ( (OML_Lampen_Signal_F_$1_F_gruenFB1 >= 1) &&
                (OML_Fstr_fe_$F_Fahrt1 < 1) &&
                (OML_Fstr_fg_$F_Fahrt3 < 1))
        {
            if (canFire("OML_Lampen_Signal_F_exit_F_gruenFB1_fe"))
            {
                --OML_Lampen_Signal_F_$1_F_gruenFB1;
                fire("OML_Lampen_Signal_F_exit_F_gruenFB1_fe");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_exit_F_rot_fe can fire
        if ( (OML_Fstr_fe_$F_Halt < 1) &&
                (OML_Lampen_Signal_F_$1_F_rot >= 1))
        {
            if (canFire("OML_Lampen_Signal_F_exit_F_rot_fe"))
            {
                --OML_Lampen_Signal_F_$1_F_rot;
                fire("OML_Lampen_Signal_F_exit_F_rot_fe");
                return true;
            }
        }
        //check if OML_Lampen_Signal_G_entry_G_FB3 can fire
        if ( (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_Lampen_Signal_G_$1_G_gruenFB3 <= 0))
        {
            if (canFire("OML_Lampen_Signal_G_entry_G_FB3"))
            {
                ++OML_Lampen_Signal_G_$1_G_gruenFB3;
                fire("OML_Lampen_Signal_G_entry_G_FB3");
                return true;
            }
        }
        //check if OML_Lampen_Signal_G_exit_G_rot can fire
        if ( (OML_Fstr_gf_$G_Halt < 1) &&
                (OML_Lampen_Signal_G_$1_G_rot >= 1))
        {
            if (canFire("OML_Lampen_Signal_G_exit_G_rot"))
            {
                --OML_Lampen_Signal_G_$1_G_rot;
                fire("OML_Lampen_Signal_G_exit_G_rot");
                return true;
            }
        }
        //check if OML_Lampen_Signal_G_entry_G_FB1 can fire
        if ( (OML_Lampen_Signal_G_$1_G_gruenFB1 >= 1) &&
                (OML_Fstr_gf_$G_Fahrt3 < 1))
        {
            if (canFire("OML_Lampen_Signal_G_entry_G_FB1"))
            {
                --OML_Lampen_Signal_G_$1_G_gruenFB1;
                fire("OML_Lampen_Signal_G_entry_G_FB1");
                return true;
            }
        }
        //check if OML_Lampen_Signal_G_exit_G_gruenFB1 can fire
        if ( (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_Lampen_Signal_G_$1_G_gruenFB1 <= 0))
        {
            if (canFire("OML_Lampen_Signal_G_exit_G_gruenFB1"))
            {
                ++OML_Lampen_Signal_G_$1_G_gruenFB1;
                fire("OML_Lampen_Signal_G_exit_G_gruenFB1");
                return true;
            }
        }
        //check if OML_Lampen_Signal_G_exit_G_gruenFB3 can fire
        if ( (OML_Lampen_Signal_G_$1_G_gruenFB3 >= 1) &&
                (OML_Fstr_gf_$G_Fahrt3 < 1))
        {
            if (canFire("OML_Lampen_Signal_G_exit_G_gruenFB3"))
            {
                --OML_Lampen_Signal_G_$1_G_gruenFB3;
                fire("OML_Lampen_Signal_G_exit_G_gruenFB3");
                return true;
            }
        }
        //check if OML_Lampen_Signal_G_entry_G_rot can fire
        if ( (OML_Fstr_gf_$G_Halt >= 1) &&
                (OML_Lampen_Signal_G_$1_G_rot <= 0))
        {
            if (canFire("OML_Lampen_Signal_G_entry_G_rot"))
            {
                ++OML_Lampen_Signal_G_$1_G_rot;
                fire("OML_Lampen_Signal_G_entry_G_rot");
                return true;
            }
        }
        //check if OML_ZB_T7 can fire
        if ( (OML_ZB_$EMM_Grundstlg >= 1) &&
                (OML_ZB_$geprueft1E2 <= 0) &&
                (OML_ILTIS_$ZB_138_2 >= 1))
        {
            if (canFire("OML_ZB_T7"))
            {
                --OML_ZB_$EMM_Grundstlg;
                ++OML_ZB_$geprueft1E2;
                fire("OML_ZB_T7");
                return true;
            }
        }
        //check if OML_ZB_T225 can fire
        if ( (OML_ZB_$D_Fahrt >= 1) &&
                (OML_ZB_$D_Halt <= 0) &&
                (OML_ZB_$cd_belegt >= 1))
        {
            if (canFire("OML_ZB_T225"))
            {
                --OML_ZB_$D_Fahrt;
                ++OML_ZB_$D_Halt;
                fire("OML_ZB_T225");
                return true;
            }
        }
        //check if OML_ZB_T1 can fire
        if ( (OML_ZB_$EMM_Grundstlg >= 1) &&
                (OML_ZB_$geprueft1A1 <= 0) &&
                (OML_ILTIS_$ZB_1_138 >= 1))
        {
            if (canFire("OML_ZB_T1"))
            {
                --OML_ZB_$EMM_Grundstlg;
                ++OML_ZB_$geprueft1A1;
                fire("OML_ZB_T1");
                return true;
            }
        }
        //check if OML_ZB_W2_mE2 can fire
        if ( (OML_ZB_$geprueft1E2 >= 1) &&
                (OML_ZB_$ZB_W2_pE2 <= 0))
        {
            if (canFire("OML_ZB_W2_mE2"))
            {
                --OML_ZB_$geprueft1E2;
                ++OML_ZB_$ZB_W2_pE2;
                fire("OML_ZB_W2_mE2");
                return true;
            }
        }
        //check if OML_ZB_pruefen2A1 can fire
        if ( (OML_ZB_$geprueft1A1 >= 1) &&
                (OML_ZB_$geprueft2A1 <= 0) &&
                (OML_BL_ZB_OM_$Grundstlg_v >= 1))
        {
            if (canFire("OML_ZB_pruefen2A1"))
            {
                --OML_ZB_$geprueft1A1;
                ++OML_ZB_$geprueft2A1;
                fire("OML_ZB_pruefen2A1");
                return true;
            }
        }
        //check if OML_ZB_W2_mA1 can fire
        if ( (OML_ZB_$ZB_W2_mA1 <= 0) &&
                (OML_ZB_$geprueft2A1 >= 1))
        {
            if (canFire("OML_ZB_W2_mA1"))
            {
                ++OML_ZB_$ZB_W2_mA1;
                --OML_ZB_$geprueft2A1;
                fire("OML_ZB_W2_mA1");
                return true;
            }
        }
        //check if OML_ZB_Fstr_aufloesen can fire
        if ( (OML_ZB_$cd_belegt >= 1) &&
                (OML_ZB_$EMM_Grundstlg <= 0) &&
                (OML_ZB_$ZB_W1_pE2 >= 1) &&
                (OML_ZB_$ZB_W1_mE1 >= 1) &&
                (OML_ZB_$ZB_W1_pA2 >= 1) &&
                (OML_ZB_$ZB_W1_mA1 >= 1))
        {
            if (canFire("OML_ZB_Fstr_aufloesen"))
            {
                ++OML_ZB_$EMM_Grundstlg;
                --OML_ZB_$ZB_W1_pE2;
                --OML_ZB_$ZB_W1_mE1;
                --OML_ZB_$ZB_W1_pA2;
                --OML_ZB_$ZB_W1_mA1;
                fire("OML_ZB_Fstr_aufloesen");
                return true;
            }
        }
        //check if OML_ZB_W2_mE1 can fire
        if ( (OML_ZB_$ZB_W2_mE1 <= 0) &&
                (OML_ZB_$geprueft1E1 >= 1))
        {
            if (canFire("OML_ZB_W2_mE1"))
            {
                ++OML_ZB_$ZB_W2_mE1;
                --OML_ZB_$geprueft1E1;
                fire("OML_ZB_W2_mE1");
                return true;
            }
        }
        //check if OML_ZB_T125 can fire
        if ( (OML_ZB_$cd_belegt >= 1) &&
                (OML_ZB_$C_Fahrt >= 1) &&
                (OML_ZB_$C_Halt <= 0))
        {
            if (canFire("OML_ZB_T125"))
            {
                --OML_ZB_$C_Fahrt;
                ++OML_ZB_$C_Halt;
                fire("OML_ZB_T125");
                return true;
            }
        }
        //check if OML_ZB_T6 can fire
        if ( (OML_ZB_$EMM_Grundstlg >= 1) &&
                (OML_ZB_$geprueft1E1 <= 0) &&
                (OML_ILTIS_$ZB_138_1 >= 1))
        {
            if (canFire("OML_ZB_T6"))
            {
                --OML_ZB_$EMM_Grundstlg;
                ++OML_ZB_$geprueft1E1;
                fire("OML_ZB_T6");
                return true;
            }
        }
        //check if OML_ZB_W2_pA2 can fire
        if ( (OML_ZB_$geprueft2A2 >= 1) &&
                (OML_ZB_$ZB_W2_pA2 <= 0))
        {
            if (canFire("OML_ZB_W2_pA2"))
            {
                --OML_ZB_$geprueft2A2;
                ++OML_ZB_$ZB_W2_pA2;
                fire("OML_ZB_W2_pA2");
                return true;
            }
        }
        //check if OML_ZB_pruefen2A2 can fire
        if ( (OML_ZB_$geprueft1A2 >= 1) &&
                (OML_ZB_$geprueft2A2 <= 0) &&
                (OML_BL_ZB_OM_$Grundstlg_v >= 1))
        {
            if (canFire("OML_ZB_pruefen2A2"))
            {
                --OML_ZB_$geprueft1A2;
                ++OML_ZB_$geprueft2A2;
                fire("OML_ZB_pruefen2A2");
                return true;
            }
        }
        //check if OML_ZB_T2 can fire
        if ( (OML_ZB_$EMM_Grundstlg >= 1) &&
                (OML_ZB_$geprueft1A2 <= 0) &&
                (OML_ILTIS_$ZB_2_138 >= 1))
        {
            if (canFire("OML_ZB_T2"))
            {
                --OML_ZB_$EMM_Grundstlg;
                ++OML_ZB_$geprueft1A2;
                fire("OML_ZB_T2");
                return true;
            }
        }
        //check if OML_ZB_T224 can fire
        if ( (OML_ZB_$D_Halt >= 1) &&
                (OML_ZB_$D_Fahrt <= 0) &&
                (OML_ZB_$ZB_W1_pE2 >= 1) &&
                (OML_ZB_$ZB_W1_mE1 >= 1))
        {
            if (canFire("OML_ZB_T224"))
            {
                --OML_ZB_$D_Halt;
                ++OML_ZB_$D_Fahrt;
                fire("OML_ZB_T224");
                return true;
            }
        }
        //check if OML_ZB_T124 can fire
        if ( (OML_ZB_$ZB_W1_mA1 >= 1) &&
                (OML_ZB_$ZB_W1_pA2 >= 1) &&
                (OML_ZB_$C_Fahrt <= 0) &&
                (OML_ZB_$C_Halt >= 1))
        {
            if (canFire("OML_ZB_T124"))
            {
                ++OML_ZB_$C_Fahrt;
                --OML_ZB_$C_Halt;
                fire("OML_ZB_T124");
                return true;
            }
        }
        //check if OML_ZB_W1_mE2 can fire
        if ( (OML_ZB_$ZB_W2_pE2 >= 1) &&
                (OML_ZB_$ZB_W1_pE2 <= 0))
        {
            if (canFire("OML_ZB_W1_mE2"))
            {
                --OML_ZB_$ZB_W2_pE2;
                ++OML_ZB_$ZB_W1_pE2;
                fire("OML_ZB_W1_mE2");
                return true;
            }
        }
        //check if OML_ZB_W1_mE1 can fire
        if ( (OML_ZB_$ZB_W2_mE1 >= 1) &&
                (OML_ZB_$ZB_W1_mE1 <= 0))
        {
            if (canFire("OML_ZB_W1_mE1"))
            {
                --OML_ZB_$ZB_W2_mE1;
                ++OML_ZB_$ZB_W1_mE1;
                fire("OML_ZB_W1_mE1");
                return true;
            }
        }
        //check if OML_ZB_W1_mA2 can fire
        if ( (OML_ZB_$ZB_W2_pA2 >= 1) &&
                (OML_ZB_$ZB_W1_pA2 <= 0))
        {
            if (canFire("OML_ZB_W1_mA2"))
            {
                --OML_ZB_$ZB_W2_pA2;
                ++OML_ZB_$ZB_W1_pA2;
                fire("OML_ZB_W1_mA2");
                return true;
            }
        }
        //check if OML_ZB_W1_mA1 can fire
        if ( (OML_ZB_$ZB_W2_mA1 >= 1) &&
                (OML_ZB_$ZB_W1_mA1 <= 0))
        {
            if (canFire("OML_ZB_W1_mA1"))
            {
                --OML_ZB_$ZB_W2_mA1;
                ++OML_ZB_$ZB_W1_mA1;
                fire("OML_ZB_W1_mA1");
                return true;
            }
        }
        //check if OML_ZB_TC1 can fire
        if ( (OML_ZB_$ZB_W1_pA2 >= 1) &&
                (OML_ZB_$C_FB1 <= 0) &&
                (OML_ZB_$C_Fahrt >= 1))
        {
            if (canFire("OML_ZB_TC1"))
            {
                ++OML_ZB_$C_FB1;
                fire("OML_ZB_TC1");
                return true;
            }
        }
        //check if OML_ZB_TC2 can fire
        if ( (OML_ZB_$C_Fahrt >= 1) &&
                (OML_ZB_$ZB_W1_mA1 >= 1) &&
                (OML_ZB_$C_FB2 <= 0))
        {
            if (canFire("OML_ZB_TC2"))
            {
                ++OML_ZB_$C_FB2;
                fire("OML_ZB_TC2");
                return true;
            }
        }
        //check if OML_ZB_TD3 can fire
        if ( (OML_ZB_$ZB_W1_pE2 >= 1) &&
                (OML_ZB_$D_Fahrt >= 1) &&
                (OML_ZB_$D_FB1 <= 0))
        {
            if (canFire("OML_ZB_TD3"))
            {
                ++OML_ZB_$D_FB1;
                fire("OML_ZB_TD3");
                return true;
            }
        }
        //check if OML_ZB_TD4 can fire
        if ( (OML_ZB_$ZB_W1_mE1 >= 1) &&
                (OML_ZB_$D_Fahrt >= 1) &&
                (OML_ZB_$D_FB2 <= 0))
        {
            if (canFire("OML_ZB_TD4"))
            {
                ++OML_ZB_$D_FB2;
                fire("OML_ZB_TD4");
                return true;
            }
        }
        //check if OML_EMM_T1 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1A1 <= 0) &&
                (OML_ILTIS_$EMM_1_833 >= 1))
        {
            if (canFire("OML_EMM_T1"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1A1;
                fire("OML_EMM_T1");
                return true;
            }
        }
        //check if OML_EMM_T2 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1A2 <= 0) &&
                (OML_ILTIS_$EMM_2_833 >= 1))
        {
            if (canFire("OML_EMM_T2"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1A2;
                fire("OML_EMM_T2");
                return true;
            }
        }
        //check if OML_EMM_T3 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1A3 <= 0) &&
                (OML_ILTIS_$EMM_3_833 >= 1))
        {
            if (canFire("OML_EMM_T3"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1A3;
                fire("OML_EMM_T3");
                return true;
            }
        }
        //check if OML_EMM_T4 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1A4 <= 0) &&
                (OML_ILTIS_$EMM_4_833 >= 1))
        {
            if (canFire("OML_EMM_T4"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1A4;
                fire("OML_EMM_T4");
                return true;
            }
        }
        //check if OML_EMM_T5 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1A5 <= 0) &&
                (OML_ILTIS_$EMM_5_833 >= 1))
        {
            if (canFire("OML_EMM_T5"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1A5;
                fire("OML_EMM_T5");
                return true;
            }
        }
        //check if OML_EMM_T6 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1E1 <= 0) &&
                (OML_ILTIS_$EMM_833_1 >= 1))
        {
            if (canFire("OML_EMM_T6"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1E1;
                fire("OML_EMM_T6");
                return true;
            }
        }
        //check if OML_EMM_T7 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1E2 <= 0) &&
                (OML_ILTIS_$EMM_833_2 >= 1))
        {
            if (canFire("OML_EMM_T7"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1E2;
                fire("OML_EMM_T7");
                return true;
            }
        }
        //check if OML_EMM_T8 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1E3 <= 0) &&
                (OML_ILTIS_$EMM_833_3 >= 1))
        {
            if (canFire("OML_EMM_T8"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1E3;
                fire("OML_EMM_T8");
                return true;
            }
        }
        //check if OML_EMM_T9 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1E4 <= 0) &&
                (OML_ILTIS_$EMM_833_4 >= 1))
        {
            if (canFire("OML_EMM_T9"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1E4;
                fire("OML_EMM_T9");
                return true;
            }
        }
        //check if OML_EMM_T10 can fire
        if ( (OML_EMM_EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1E5 <= 0) &&
                (OML_ILTIS_$EMM_833_5 >= 1))
        {
            if (canFire("OML_EMM_T10"))
            {
                --OML_EMM_EMM_Grundstlg;
                ++OML_EMM_$geprueft1E5;
                fire("OML_EMM_T10");
                return true;
            }
        }
        //check if OML_EMM_W7_mA1 can fire
        if ( (OML_EMM_$EMM_W7_mA1 <= 0) &&
                (OML_EMM_$geprueft2A1 >= 1))
        {
            if (canFire("OML_EMM_W7_mA1"))
            {
                ++OML_EMM_$EMM_W7_mA1;
                --OML_EMM_$geprueft2A1;
                fire("OML_EMM_W7_mA1");
                return true;
            }
        }
        //check if OML_EMM_W10_pA1 can fire
        if ( (OML_EMM_$EMM_W7_mA1 >= 1) &&
                (OML_EMM_$EMM_W10_pA1 <= 0))
        {
            if (canFire("OML_EMM_W10_pA1"))
            {
                --OML_EMM_$EMM_W7_mA1;
                ++OML_EMM_$EMM_W10_pA1;
                fire("OML_EMM_W10_pA1");
                return true;
            }
        }
        //check if OML_EMM_pruefen2A1 can fire
        if ( (OML_EMM_$geprueft1A1 >= 1) &&
                (OML_EMM_$geprueft2A1 <= 0) &&
                (OML_Fstr_ef_$E_Fahrt1 >= 1))
        {
            if (canFire("OML_EMM_pruefen2A1"))
            {
                --OML_EMM_$geprueft1A1;
                ++OML_EMM_$geprueft2A1;
                fire("OML_EMM_pruefen2A1");
                return true;
            }
        }
        //check if OML_EMM_W7_pA2 can fire
        if ( (OML_EMM_$geprueft2A2 >= 1) &&
                (OML_EMM_$EMM_W7_pA2 <= 0))
        {
            if (canFire("OML_EMM_W7_pA2"))
            {
                --OML_EMM_$geprueft2A2;
                ++OML_EMM_$EMM_W7_pA2;
                fire("OML_EMM_W7_pA2");
                return true;
            }
        }
        //check if OML_EMM_W10_pA2 can fire
        if ( (OML_EMM_$EMM_W7_pA2 >= 1) &&
                (OML_EMM_$EMM_W10_pA2 <= 0))
        {
            if (canFire("OML_EMM_W10_pA2"))
            {
                --OML_EMM_$EMM_W7_pA2;
                ++OML_EMM_$EMM_W10_pA2;
                fire("OML_EMM_W10_pA2");
                return true;
            }
        }
        //check if OML_EMM_pruefen2A2 can fire
        if ( (OML_EMM_$geprueft1A2 >= 1) &&
                (OML_EMM_$geprueft2A2 <= 0) &&
                (OML_Fstr_ef_$E_Fahrt1 >= 1))
        {
            if (canFire("OML_EMM_pruefen2A2"))
            {
                --OML_EMM_$geprueft1A2;
                ++OML_EMM_$geprueft2A2;
                fire("OML_EMM_pruefen2A2");
                return true;
            }
        }
        //check if OML_EMM_W9_pA3 can fire
        if ( (OML_EMM_$geprueft2A3 >= 1) &&
                (OML_EMM_$EMM_W9_pA3 <= 0))
        {
            if (canFire("OML_EMM_W9_pA3"))
            {
                --OML_EMM_$geprueft2A3;
                ++OML_EMM_$EMM_W9_pA3;
                fire("OML_EMM_W9_pA3");
                return true;
            }
        }
        //check if OML_EMM_W10_mA3 can fire
        if ( (OML_EMM_$EMM_W9_pA3 >= 1) &&
                (OML_EMM_$EMM_W10_mA3 <= 0))
        {
            if (canFire("OML_EMM_W10_mA3"))
            {
                --OML_EMM_$EMM_W9_pA3;
                ++OML_EMM_$EMM_W10_mA3;
                fire("OML_EMM_W10_mA3");
                return true;
            }
        }
        //check if OML_EMM_pruefen2A3 can fire
        if ( (OML_EMM_$geprueft1A3 >= 1) &&
                (OML_EMM_$geprueft2A3 <= 0) &&
                (OML_Fstr_ef_$E_Fahrt1 >= 1))
        {
            if (canFire("OML_EMM_pruefen2A3"))
            {
                --OML_EMM_$geprueft1A3;
                ++OML_EMM_$geprueft2A3;
                fire("OML_EMM_pruefen2A3");
                return true;
            }
        }
        //check if OML_EMM_W8_pA4 can fire
        if ( (OML_EMM_$geprueft2A4 >= 1) &&
                (OML_EMM_$EMM_W8_pA4 <= 0))
        {
            if (canFire("OML_EMM_W8_pA4"))
            {
                --OML_EMM_$geprueft2A4;
                ++OML_EMM_$EMM_W8_pA4;
                fire("OML_EMM_W8_pA4");
                return true;
            }
        }
        //check if OML_EMM_W9_mA4 can fire
        if ( (OML_EMM_$EMM_W9_mA4 <= 0) &&
                (OML_EMM_$EMM_W8_pA4 >= 1))
        {
            if (canFire("OML_EMM_W9_mA4"))
            {
                ++OML_EMM_$EMM_W9_mA4;
                --OML_EMM_$EMM_W8_pA4;
                fire("OML_EMM_W9_mA4");
                return true;
            }
        }
        //check if OML_EMM_pruefen2A4 can fire
        if ( (OML_EMM_$geprueft1A4 >= 1) &&
                (OML_EMM_$geprueft2A4 <= 0) &&
                (OML_Fstr_ef_$E_Fahrt1 >= 1))
        {
            if (canFire("OML_EMM_pruefen2A4"))
            {
                --OML_EMM_$geprueft1A4;
                ++OML_EMM_$geprueft2A4;
                fire("OML_EMM_pruefen2A4");
                return true;
            }
        }
        //check if OML_EMM_W8_mA5 can fire
        if ( (OML_EMM_$geprueft2A5 >= 1) &&
                (OML_EMM_$EMM_W8_mA5 <= 0))
        {
            if (canFire("OML_EMM_W8_mA5"))
            {
                --OML_EMM_$geprueft2A5;
                ++OML_EMM_$EMM_W8_mA5;
                fire("OML_EMM_W8_mA5");
                return true;
            }
        }
        //check if OML_EMM_W9_mA5 can fire
        if ( (OML_EMM_$EMM_W9_mA5 <= 0) &&
                (OML_EMM_$EMM_W8_mA5 >= 1))
        {
            if (canFire("OML_EMM_W9_mA5"))
            {
                ++OML_EMM_$EMM_W9_mA5;
                --OML_EMM_$EMM_W8_mA5;
                fire("OML_EMM_W9_mA5");
                return true;
            }
        }
        //check if OML_EMM_pruefen2A5 can fire
        if ( (OML_EMM_$geprueft1A5 >= 1) &&
                (OML_EMM_$geprueft2A5 <= 0) &&
                (OML_Fstr_ef_$E_Fahrt1 >= 1))
        {
            if (canFire("OML_EMM_pruefen2A5"))
            {
                --OML_EMM_$geprueft1A5;
                ++OML_EMM_$geprueft2A5;
                fire("OML_EMM_pruefen2A5");
                return true;
            }
        }
        //check if OML_EMM_W7_mE1 can fire
        if ( (OML_EMM_$geprueft1E1 >= 1) &&
                (OML_EMM_$EMM_W7_mE1 <= 0))
        {
            if (canFire("OML_EMM_W7_mE1"))
            {
                --OML_EMM_$geprueft1E1;
                ++OML_EMM_$EMM_W7_mE1;
                fire("OML_EMM_W7_mE1");
                return true;
            }
        }
        //check if OML_EMM_W10_pE1 can fire
        if ( (OML_EMM_$EMM_W7_mE1 >= 1) &&
                (OML_EMM_$EMM_W10_pE1 <= 0))
        {
            if (canFire("OML_EMM_W10_pE1"))
            {
                --OML_EMM_$EMM_W7_mE1;
                ++OML_EMM_$EMM_W10_pE1;
                fire("OML_EMM_W10_pE1");
                return true;
            }
        }
        //check if OML_EMM_W7_pE2 can fire
        if ( (OML_EMM_$geprueft1E2 >= 1) &&
                (OML_EMM_$EMM_W7_pE2 <= 0))
        {
            if (canFire("OML_EMM_W7_pE2"))
            {
                --OML_EMM_$geprueft1E2;
                ++OML_EMM_$EMM_W7_pE2;
                fire("OML_EMM_W7_pE2");
                return true;
            }
        }
        //check if OML_EMM_W10_pE2 can fire
        if ( (OML_EMM_$EMM_W7_pE2 >= 1) &&
                (OML_EMM_$EMM_W10_pE2 <= 0))
        {
            if (canFire("OML_EMM_W10_pE2"))
            {
                --OML_EMM_$EMM_W7_pE2;
                ++OML_EMM_$EMM_W10_pE2;
                fire("OML_EMM_W10_pE2");
                return true;
            }
        }
        //check if OML_EMM_W9_pE3 can fire
        if ( (OML_EMM_$geprueft1E3 >= 1) &&
                (OML_EMM_$EMM_W9_pE3 <= 0))
        {
            if (canFire("OML_EMM_W9_pE3"))
            {
                --OML_EMM_$geprueft1E3;
                ++OML_EMM_$EMM_W9_pE3;
                fire("OML_EMM_W9_pE3");
                return true;
            }
        }
        //check if OML_EMM_W10_mE3 can fire
        if ( (OML_EMM_$EMM_W9_pE3 >= 1) &&
                (OML_EMM_$EMM_W10_mE3 <= 0))
        {
            if (canFire("OML_EMM_W10_mE3"))
            {
                --OML_EMM_$EMM_W9_pE3;
                ++OML_EMM_$EMM_W10_mE3;
                fire("OML_EMM_W10_mE3");
                return true;
            }
        }
        //check if OML_EMM_W8_pE4 can fire
        if ( (OML_EMM_$geprueft1E4 >= 1) &&
                (OML_EMM_$EMM_W8_pE4 <= 0))
        {
            if (canFire("OML_EMM_W8_pE4"))
            {
                --OML_EMM_$geprueft1E4;
                ++OML_EMM_$EMM_W8_pE4;
                fire("OML_EMM_W8_pE4");
                return true;
            }
        }
        //check if OML_EMM_w9_mE4 can fire
        if ( (OML_EMM_$EMM_W8_pE4 >= 1) &&
                (OML_EMM_$EMM_W9_mE4 <= 0))
        {
            if (canFire("OML_EMM_w9_mE4"))
            {
                --OML_EMM_$EMM_W8_pE4;
                ++OML_EMM_$EMM_W9_mE4;
                fire("OML_EMM_w9_mE4");
                return true;
            }
        }
        //check if OML_EMM_W8_mE5 can fire
        if ( (OML_EMM_$geprueft1E5 >= 1) &&
                (OML_EMM_$EMM_W8_mE5 <= 0))
        {
            if (canFire("OML_EMM_W8_mE5"))
            {
                --OML_EMM_$geprueft1E5;
                ++OML_EMM_$EMM_W8_mE5;
                fire("OML_EMM_W8_mE5");
                return true;
            }
        }
        //check if OML_EMM_W9_mE5 can fire
        if ( (OML_EMM_$EMM_W8_mE5 >= 1) &&
                (OML_EMM_$EMM_W9_mE5 <= 0))
        {
            if (canFire("OML_EMM_W9_mE5"))
            {
                --OML_EMM_$EMM_W8_mE5;
                ++OML_EMM_$EMM_W9_mE5;
                fire("OML_EMM_W9_mE5");
                return true;
            }
        }
        //check if OML_EMM_Fstr_aufloesen can fire
        if ( (OML_EMM_$EMM_W10_mA4 >= 1) &&
                (OML_EMM_$EMM_W10_mA5 >= 1) &&
                (OML_EMM_EMM_Grundstlg <= 0) &&
                (OML_EMM_$EMM_W10_pA2 >= 1) &&
                (OML_EMM_$EMM_W10_pA1 >= 1) &&
                (OML_EMM_$EMM_W10_mA3 >= 1) &&
                (OML_EMM_$EMM_W10_pE2 >= 1) &&
                (OML_EMM_$EMM_W10_mE4 >= 1) &&
                (OML_EMM_$EMM_W10_mE3 >= 1) &&
                (OML_EMM_$EMM_W10_mE5 >= 1) &&
                (OML_EMM_$EMM_W10_pE1 >= 1) &&
                (OML_Iso_cd_$belegt >= 1))
        {
            if (canFire("OML_EMM_Fstr_aufloesen"))
            {
                --OML_EMM_$EMM_W10_mA4;
                --OML_EMM_$EMM_W10_mA5;
                ++OML_EMM_EMM_Grundstlg;
                --OML_EMM_$EMM_W10_pA2;
                --OML_EMM_$EMM_W10_pA1;
                --OML_EMM_$EMM_W10_mA3;
                --OML_EMM_$EMM_W10_pE2;
                --OML_EMM_$EMM_W10_mE4;
                --OML_EMM_$EMM_W10_mE3;
                --OML_EMM_$EMM_W10_mE5;
                --OML_EMM_$EMM_W10_pE1;
                fire("OML_EMM_Fstr_aufloesen");
                return true;
            }
        }
        //check if OML_EMM_W10_mA4 can fire
        if ( (OML_EMM_$EMM_W9_mA4 >= 1) &&
                (OML_EMM_$EMM_W10_mA4 <= 0))
        {
            if (canFire("OML_EMM_W10_mA4"))
            {
                --OML_EMM_$EMM_W9_mA4;
                ++OML_EMM_$EMM_W10_mA4;
                fire("OML_EMM_W10_mA4");
                return true;
            }
        }
        //check if OML_EMM_W10_mA5 can fire
        if ( (OML_EMM_$EMM_W9_mA5 >= 1) &&
                (OML_EMM_$EMM_W10_mA5 <= 0))
        {
            if (canFire("OML_EMM_W10_mA5"))
            {
                --OML_EMM_$EMM_W9_mA5;
                ++OML_EMM_$EMM_W10_mA5;
                fire("OML_EMM_W10_mA5");
                return true;
            }
        }
        //check if OML_EMM_W10_mE5 can fire
        if ( (OML_EMM_$EMM_W9_mE5 >= 1) &&
                (OML_EMM_$EMM_W10_mE5 <= 0))
        {
            if (canFire("OML_EMM_W10_mE5"))
            {
                --OML_EMM_$EMM_W9_mE5;
                ++OML_EMM_$EMM_W10_mE5;
                fire("OML_EMM_W10_mE5");
                return true;
            }
        }
        //check if OML_EMM_W10_mE4 can fire
        if ( (OML_EMM_$EMM_W9_mE4 >= 1) &&
                (OML_EMM_$EMM_W10_mE4 <= 0))
        {
            if (canFire("OML_EMM_W10_mE4"))
            {
                --OML_EMM_$EMM_W9_mE4;
                ++OML_EMM_$EMM_W10_mE4;
                fire("OML_EMM_W10_mE4");
                return true;
            }
        }
        //check if OML_EMM_T25 can fire
        if ( (OML_EMM_$C_Fahrt >= 1) &&
                (OML_EMM_$C_Halt <= 0) &&
                (OML_Iso_cd_$belegt >= 1))
        {
            if (canFire("OML_EMM_T25"))
            {
                --OML_EMM_$C_Fahrt;
                ++OML_EMM_$C_Halt;
                fire("OML_EMM_T25");
                return true;
            }
        }
        //check if OML_EMM_TC2 can fire
        if ( (OML_EMM_$EMM_W10_pA1 >= 1) &&
                (OML_EMM_$EMM_W10_mA3 >= 1) &&
                (OML_EMM_$EMM_W10_mA5 >= 1) &&
                (OML_EMM_$EMM_W10_mA4 >= 1) &&
                (OML_EMM_$C_Fahrt >= 1) &&
                (OML_EMM_$C_FB2 <= 0))
        {
            if (canFire("OML_EMM_TC2"))
            {
                ++OML_EMM_$C_FB2;
                fire("OML_EMM_TC2");
                return true;
            }
        }
        //check if OML_EMM_TC1 can fire
        if ( (OML_EMM_$EMM_W10_pA2 >= 1) &&
                (OML_EMM_$C_Fahrt >= 1) &&
                (OML_EMM_$C_FB1 <= 0))
        {
            if (canFire("OML_EMM_TC1"))
            {
                ++OML_EMM_$C_FB1;
                fire("OML_EMM_TC1");
                return true;
            }
        }
        //check if OML_EMM_T24 can fire
        if ( (OML_EMM_$EMM_W10_pA1 >= 1) &&
                (OML_EMM_$EMM_W10_mA3 >= 1) &&
                (OML_EMM_$EMM_W10_mA4 >= 1) &&
                (OML_EMM_$EMM_W10_mA5 >= 1) &&
                (OML_EMM_$EMM_W10_pA2 >= 1) &&
                (OML_EMM_$C_Fahrt <= 0) &&
                (OML_EMM_$C_Halt >= 1))
        {
            if (canFire("OML_EMM_T24"))
            {
                ++OML_EMM_$C_Fahrt;
                --OML_EMM_$C_Halt;
                fire("OML_EMM_T24");
                return true;
            }
        }
        //check if OML_EMM_T125 can fire
        if ( (OML_EMM_$D_Fahrt >= 1) &&
                (OML_EMM_$D_Halt <= 0) &&
                (OML_Iso_cd_$belegt >= 1))
        {
            if (canFire("OML_EMM_T125"))
            {
                --OML_EMM_$D_Fahrt;
                ++OML_EMM_$D_Halt;
                fire("OML_EMM_T125");
                return true;
            }
        }
        //check if OML_EMM_TD2 can fire
        if ( (OML_EMM_$EMM_W10_pE1 >= 1) &&
                (OML_EMM_$EMM_W10_mE5 >= 1) &&
                (OML_EMM_$EMM_W10_mE4 >= 1) &&
                (OML_EMM_$EMM_W10_mE3 >= 1) &&
                (OML_EMM_$D_FB2 <= 0) &&
                (OML_EMM_$D_Fahrt >= 1))
        {
            if (canFire("OML_EMM_TD2"))
            {
                ++OML_EMM_$D_FB2;
                fire("OML_EMM_TD2");
                return true;
            }
        }
        //check if OML_EMM_TD1 can fire
        if ( (OML_EMM_$EMM_W10_pE2 >= 1) &&
                (OML_EMM_$D_FB1 <= 0) &&
                (OML_EMM_$D_Fahrt >= 1))
        {
            if (canFire("OML_EMM_TD1"))
            {
                ++OML_EMM_$D_FB1;
                fire("OML_EMM_TD1");
                return true;
            }
        }
        //check if OML_EMM_T124 can fire
        if ( (OML_EMM_$EMM_W10_pE2 >= 1) &&
                (OML_EMM_$EMM_W10_mE3 >= 1) &&
                (OML_EMM_$EMM_W10_mE4 >= 1) &&
                (OML_EMM_$EMM_W10_mE5 >= 1) &&
                (OML_EMM_$EMM_W10_pE1 >= 1) &&
                (OML_EMM_$D_Halt >= 1) &&
                (OML_EMM_$D_Fahrt <= 0))
        {
            if (canFire("OML_EMM_T124"))
            {
                --OML_EMM_$D_Halt;
                ++OML_EMM_$D_Fahrt;
                fire("OML_EMM_T124");
                return true;
            }
        }
        //check if OML_ILTIS_T201 can fire
        if ( (OML_ILTIS_$freigeben_vLN >= 1) &&
                (OML_ILTIS_$festgehalten_vLN >= 1) &&
                (OML_ILTIS_$freigegeben_vLN <= 0))
        {
            if (canFire("OML_ILTIS_T201"))
            {
                --OML_ILTIS_$festgehalten_vLN;
                ++OML_ILTIS_$freigegeben_vLN;
                fire("OML_ILTIS_T201");
                return true;
            }
        }
        //check if OML_ILTIS_T202 can fire
        if ( (OML_ILTIS_$festgehalten_vLN <= 0) &&
                (OML_ILTIS_$festhalten_vLN >= 1) &&
                (OML_ILTIS_$freigegeben_vLN >= 1))
        {
            if (canFire("OML_ILTIS_T202"))
            {
                ++OML_ILTIS_$festgehalten_vLN;
                --OML_ILTIS_$freigegeben_vLN;
                fire("OML_ILTIS_T202");
                return true;
            }
        }
        //check if OML_ILTIS_T101 can fire
        if ( (OML_ILTIS_$festgehalten_v_ZB >= 1) &&
                (OML_ILTIS_$freigeben_vZB >= 1) &&
                (OML_ILTIS_$freigegeben_vZB <= 0))
        {
            if (canFire("OML_ILTIS_T101"))
            {
                --OML_ILTIS_$festgehalten_v_ZB;
                ++OML_ILTIS_$freigegeben_vZB;
                fire("OML_ILTIS_T101");
                return true;
            }
        }
        //check if OML_ILTIS_T102 can fire
        if ( (OML_ILTIS_$festgehalten_v_ZB <= 0) &&
                (OML_ILTIS_$festhalten_vZB >= 1) &&
                (OML_ILTIS_$freigegeben_vZB >= 1))
        {
            if (canFire("OML_ILTIS_T102"))
            {
                ++OML_ILTIS_$festgehalten_v_ZB;
                --OML_ILTIS_$freigegeben_vZB;
                fire("OML_ILTIS_T102");
                return true;
            }
        }
        //check if OML_LN_pruefen2A5 can fire
        if ( (OML_LN_$geprueft1A5 >= 1) &&
                (OML_LN_$geprueft2A5 <= 0) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A5"))
            {
                --OML_LN_$geprueft1A5;
                ++OML_LN_$geprueft2A5;
                fire("OML_LN_pruefen2A5");
                return true;
            }
        }
        //check if OML_LN_T7 can fire
        if ( (OML_ILTIS_$LN_834_2 >= 1) &&
                (OML_LN_$geprueft1E2 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T7"))
            {
                ++OML_LN_$geprueft1E2;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T7");
                return true;
            }
        }
        //check if OML_LN_T1 can fire
        if ( (OML_ILTIS_$LN_1_834 >= 1) &&
                (OML_LN_$geprueft1A1 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T1"))
            {
                ++OML_LN_$geprueft1A1;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T1");
                return true;
            }
        }
        //check if OML_LN_pruefen2A4 can fire
        if ( (OML_LN_$geprueft1A4 >= 1) &&
                (OML_LN_$geprueft2A4 <= 0) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A4"))
            {
                --OML_LN_$geprueft1A4;
                ++OML_LN_$geprueft2A4;
                fire("OML_LN_pruefen2A4");
                return true;
            }
        }
        //check if OML_LN_T5 can fire
        if ( (OML_ILTIS_$LN_834_5 >= 1) &&
                (OML_LN_$geprueft1A5 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T5"))
            {
                ++OML_LN_$geprueft1A5;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T5");
                return true;
            }
        }
        //check if OML_LN_W2_pA2 can fire
        if ( (OML_LN_$LN_W1_pA2 >= 1) &&
                (OML_LN_$LN_W2_pA2 <= 0))
        {
            if (canFire("OML_LN_W2_pA2"))
            {
                --OML_LN_$LN_W1_pA2;
                ++OML_LN_$LN_W2_pA2;
                fire("OML_LN_W2_pA2");
                return true;
            }
        }
        //check if OML_LN_T4 can fire
        if ( (OML_ILTIS_$LN_4_834 >= 1) &&
                (OML_LN_$geprueft1A4 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T4"))
            {
                ++OML_LN_$geprueft1A4;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T4");
                return true;
            }
        }
        //check if OML_LN_pruefen2A1 can fire
        if ( (OML_LN_$geprueft1A1 >= 1) &&
                (OML_LN_$geprueft2A1 <= 0) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A1"))
            {
                --OML_LN_$geprueft1A1;
                ++OML_LN_$geprueft2A1;
                fire("OML_LN_pruefen2A1");
                return true;
            }
        }
        //check if OML_LN_W1_pA3 can fire
        if ( (OML_LN_$geprueft2A3 >= 1) &&
                (OML_LN_$LN_W1_pA3 <= 0))
        {
            if (canFire("OML_LN_W1_pA3"))
            {
                --OML_LN_$geprueft2A3;
                ++OML_LN_$LN_W1_pA3;
                fire("OML_LN_W1_pA3");
                return true;
            }
        }
        //check if OML_LN_pruefen2A3 can fire
        if ( (OML_LN_$geprueft2A3 <= 0) &&
                (OML_LN_$geprueft1A3 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A3"))
            {
                ++OML_LN_$geprueft2A3;
                --OML_LN_$geprueft1A3;
                fire("OML_LN_pruefen2A3");
                return true;
            }
        }
        //check if OML_LN_W1_mA1 can fire
        if ( (OML_LN_$LN_W1_mA1 <= 0) &&
                (OML_LN_$geprueft2A1 >= 1))
        {
            if (canFire("OML_LN_W1_mA1"))
            {
                ++OML_LN_$LN_W1_mA1;
                --OML_LN_$geprueft2A1;
                fire("OML_LN_W1_mA1");
                return true;
            }
        }
        //check if OML_LN_T9 can fire
        if ( (OML_ILTIS_$LN_834_4 >= 1) &&
                (OML_LN_$geprueft1E4 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T9"))
            {
                ++OML_LN_$geprueft1E4;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T9");
                return true;
            }
        }
        //check if OML_LN_Fstr_aufloesen can fire
        if ( (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_$LN_W1_mA1 >= 1) &&
                (OML_LN_$LN_W2_pA2 >= 1) &&
                (OML_LN_$LN_W5_pA3 >= 1) &&
                (OML_LN_$LN_W5_mA4 >= 1) &&
                (OML_LN_$LN_W6_mA5 >= 1) &&
                (OML_LN_$LN_W6_mA6 >= 1) &&
                (OML_LN_$LN_W2_pE2 >= 1) &&
                (OML_LN_$LN_W6_mE6 >= 1) &&
                (OML_LN_$LN_W5_pE3 >= 1) &&
                (OML_LN_$LN_W6_mE5 >= 1) &&
                (OML_LN_$LN_W5_mE4 >= 1) &&
                (OML_LN_$LN_W1_mE1 >= 1) &&
                (OML_LN_$LN_Grundstlg <= 0))
        {
            if (canFire("OML_LN_Fstr_aufloesen"))
            {
                --OML_LN_$LN_W1_mA1;
                --OML_LN_$LN_W2_pA2;
                --OML_LN_$LN_W5_pA3;
                --OML_LN_$LN_W5_mA4;
                --OML_LN_$LN_W6_mA5;
                --OML_LN_$LN_W6_mA6;
                --OML_LN_$LN_W2_pE2;
                --OML_LN_$LN_W6_mE6;
                --OML_LN_$LN_W5_pE3;
                --OML_LN_$LN_W6_mE5;
                --OML_LN_$LN_W5_mE4;
                --OML_LN_$LN_W1_mE1;
                ++OML_LN_$LN_Grundstlg;
                fire("OML_LN_Fstr_aufloesen");
                return true;
            }
        }
        //check if OML_LN_T6 can fire
        if ( (OML_ILTIS_$LN_834_1 >= 1) &&
                (OML_LN_$geprueft1E1 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T6"))
            {
                ++OML_LN_$geprueft1E1;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T6");
                return true;
            }
        }
        //check if OML_LN_T8 can fire
        if ( (OML_ILTIS_$LN_834_3 >= 1) &&
                (OML_LN_$geprueft1E3 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T8"))
            {
                ++OML_LN_$geprueft1E3;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T8");
                return true;
            }
        }
        //check if OML_LN_T10 can fire
        if ( (OML_ILTIS_$LN_834_5 >= 1) &&
                (OML_LN_$geprueft1E5 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T10"))
            {
                ++OML_LN_$geprueft1E5;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T10");
                return true;
            }
        }
        //check if OML_LN_W1_pA2 can fire
        if ( (OML_LN_$geprueft2A2 >= 1) &&
                (OML_LN_$LN_W1_pA2 <= 0))
        {
            if (canFire("OML_LN_W1_pA2"))
            {
                --OML_LN_$geprueft2A2;
                ++OML_LN_$LN_W1_pA2;
                fire("OML_LN_W1_pA2");
                return true;
            }
        }
        //check if OML_LN_pruefen2A2 can fire
        if ( (OML_LN_$geprueft1A2 >= 1) &&
                (OML_LN_$geprueft2A2 <= 0) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A2"))
            {
                --OML_LN_$geprueft1A2;
                ++OML_LN_$geprueft2A2;
                fire("OML_LN_pruefen2A2");
                return true;
            }
        }
        //check if OML_LN_T2 can fire
        if ( (OML_ILTIS_$LN_2_834 >= 1) &&
                (OML_LN_$geprueft1A2 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T2"))
            {
                ++OML_LN_$geprueft1A2;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T2");
                return true;
            }
        }
        //check if OML_LN_T3 can fire
        if ( (OML_ILTIS_$LN_3_834 >= 1) &&
                (OML_LN_$geprueft1A3 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T3"))
            {
                ++OML_LN_$geprueft1A3;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T3");
                return true;
            }
        }
        //check if OML_LN_W2_mA3 can fire
        if ( (OML_LN_$LN_W1_pA3 >= 1) &&
                (OML_LN_$LN_W2_mA3 <= 0))
        {
            if (canFire("OML_LN_W2_mA3"))
            {
                --OML_LN_$LN_W1_pA3;
                ++OML_LN_$LN_W2_mA3;
                fire("OML_LN_W2_mA3");
                return true;
            }
        }
        //check if OML_LN_W3_pA3 can fire
        if ( (OML_LN_$LN_W2_mA3 >= 1) &&
                (OML_LN_$LN_W3_pA3 <= 0))
        {
            if (canFire("OML_LN_W3_pA3"))
            {
                --OML_LN_$LN_W2_mA3;
                ++OML_LN_$LN_W3_pA3;
                fire("OML_LN_W3_pA3");
                return true;
            }
        }
        //check if OML_LN_W3_pA4 can fire
        if ( (OML_LN_$LN_W2_mA4 >= 1) &&
                (OML_LN_$LN_W3_pA4 <= 0))
        {
            if (canFire("OML_LN_W3_pA4"))
            {
                --OML_LN_$LN_W2_mA4;
                ++OML_LN_$LN_W3_pA4;
                fire("OML_LN_W3_pA4");
                return true;
            }
        }
        //check if OML_LN_W1_pA4 can fire
        if ( (OML_LN_$geprueft2A4 >= 1) &&
                (OML_LN_$LN_W1_pA4 <= 0))
        {
            if (canFire("OML_LN_W1_pA4"))
            {
                --OML_LN_$geprueft2A4;
                ++OML_LN_$LN_W1_pA4;
                fire("OML_LN_W1_pA4");
                return true;
            }
        }
        //check if OML_LN_W2_mA4 can fire
        if ( (OML_LN_$LN_W1_pA4 >= 1) &&
                (OML_LN_$LN_W2_mA4 <= 0))
        {
            if (canFire("OML_LN_W2_mA4"))
            {
                --OML_LN_$LN_W1_pA4;
                ++OML_LN_$LN_W2_mA4;
                fire("OML_LN_W2_mA4");
                return true;
            }
        }
        //check if OML_LN_W5_pA3 can fire
        if ( (OML_LN_$LN_W3_pA3 >= 1) &&
                (OML_LN_$LN_W5_pA3 <= 0))
        {
            if (canFire("OML_LN_W5_pA3"))
            {
                --OML_LN_$LN_W3_pA3;
                ++OML_LN_$LN_W5_pA3;
                fire("OML_LN_W5_pA3");
                return true;
            }
        }
        //check if OML_LN_W5_mA4 can fire
        if ( (OML_LN_$LN_W3_pA4 >= 1) &&
                (OML_LN_$LN_W5_mA4 <= 0))
        {
            if (canFire("OML_LN_W5_mA4"))
            {
                --OML_LN_$LN_W3_pA4;
                ++OML_LN_$LN_W5_mA4;
                fire("OML_LN_W5_mA4");
                return true;
            }
        }
        //check if OML_LN_W2_mA5 can fire
        if ( (OML_LN_$LN_W1_pA5 >= 1) &&
                (OML_LN_$LN_W2_mA5 <= 0))
        {
            if (canFire("OML_LN_W2_mA5"))
            {
                --OML_LN_$LN_W1_pA5;
                ++OML_LN_$LN_W2_mA5;
                fire("OML_LN_W2_mA5");
                return true;
            }
        }
        //check if OML_LN_W3_mA5 can fire
        if ( (OML_LN_$LN_W3_mA5 <= 0) &&
                (OML_LN_$LN_W2_mA5 >= 1))
        {
            if (canFire("OML_LN_W3_mA5"))
            {
                ++OML_LN_$LN_W3_mA5;
                --OML_LN_$LN_W2_mA5;
                fire("OML_LN_W3_mA5");
                return true;
            }
        }
        //check if OML_LN_W1_pA5 can fire
        if ( (OML_LN_$LN_W1_pA5 <= 0) &&
                (OML_LN_$geprueft2A5 >= 1))
        {
            if (canFire("OML_LN_W1_pA5"))
            {
                ++OML_LN_$LN_W1_pA5;
                --OML_LN_$geprueft2A5;
                fire("OML_LN_W1_pA5");
                return true;
            }
        }
        //check if OML_LN_W4_pA5 can fire
        if ( (OML_LN_$LN_W3_mA5 >= 1) &&
                (OML_LN_$LN_W4_pA5 <= 0))
        {
            if (canFire("OML_LN_W4_pA5"))
            {
                --OML_LN_$LN_W3_mA5;
                ++OML_LN_$LN_W4_pA5;
                fire("OML_LN_W4_pA5");
                return true;
            }
        }
        //check if OML_LN_W6_mA5 can fire
        if ( (OML_LN_$LN_W4_pA5 >= 1) &&
                (OML_LN_$LN_W6_mA5 <= 0))
        {
            if (canFire("OML_LN_W6_mA5"))
            {
                --OML_LN_$LN_W4_pA5;
                ++OML_LN_$LN_W6_mA5;
                fire("OML_LN_W6_mA5");
                return true;
            }
        }
        //check if OML_LN_W2_mA6 can fire
        if ( (OML_LN_$LN_W2_mA6 <= 0) &&
                (OML_LN_$LN_W1_pA6 >= 1))
        {
            if (canFire("OML_LN_W2_mA6"))
            {
                ++OML_LN_$LN_W2_mA6;
                --OML_LN_$LN_W1_pA6;
                fire("OML_LN_W2_mA6");
                return true;
            }
        }
        //check if OML_LN_W6_mA6 can fire
        if ( (OML_LN_$LN_W4_pA6 >= 1) &&
                (OML_LN_$LN_W6_mA6 <= 0))
        {
            if (canFire("OML_LN_W6_mA6"))
            {
                --OML_LN_$LN_W4_pA6;
                ++OML_LN_$LN_W6_mA6;
                fire("OML_LN_W6_mA6");
                return true;
            }
        }
        //check if OML_LN_W4_pA6 can fire
        if ( (OML_LN_$LN_W3_mA6 >= 1) &&
                (OML_LN_$LN_W4_pA6 <= 0))
        {
            if (canFire("OML_LN_W4_pA6"))
            {
                --OML_LN_$LN_W3_mA6;
                ++OML_LN_$LN_W4_pA6;
                fire("OML_LN_W4_pA6");
                return true;
            }
        }
        //check if OML_LN_W1_pA6 can fire
        if ( (OML_LN_$geprueft2A6 >= 1) &&
                (OML_LN_$LN_W1_pA6 <= 0))
        {
            if (canFire("OML_LN_W1_pA6"))
            {
                --OML_LN_$geprueft2A6;
                ++OML_LN_$LN_W1_pA6;
                fire("OML_LN_W1_pA6");
                return true;
            }
        }
        //check if OML_LN_W3_mA6 can fire
        if ( (OML_LN_$LN_W2_mA6 >= 1) &&
                (OML_LN_$LN_W3_mA6 <= 0))
        {
            if (canFire("OML_LN_W3_mA6"))
            {
                --OML_LN_$LN_W2_mA6;
                ++OML_LN_$LN_W3_mA6;
                fire("OML_LN_W3_mA6");
                return true;
            }
        }
        //check if OML_LN_pruefen2A6 can fire
        if ( (OML_LN_$geprueft2A6 <= 0) &&
                (OML_LN_$geprueft1A6 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A6"))
            {
                ++OML_LN_$geprueft2A6;
                --OML_LN_$geprueft1A6;
                fire("OML_LN_pruefen2A6");
                return true;
            }
        }
        //check if OML_LN_T105 can fire
        if ( (OML_ILTIS_$LN_6_834 >= 1) &&
                (OML_LN_$geprueft1A6 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T105"))
            {
                ++OML_LN_$geprueft1A6;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T105");
                return true;
            }
        }
        //check if OML_LN_W2_mE6 can fire
        if ( (OML_LN_$LN_W1_pE6 >= 1) &&
                (OML_LN_$LN_W2_mE6 <= 0))
        {
            if (canFire("OML_LN_W2_mE6"))
            {
                --OML_LN_$LN_W1_pE6;
                ++OML_LN_$LN_W2_mE6;
                fire("OML_LN_W2_mE6");
                return true;
            }
        }
        //check if OML_LN_W3_pE4 can fire
        if ( (OML_LN_$LN_W2_mE4 >= 1) &&
                (OML_LN_$LN_W3_pE4 <= 0))
        {
            if (canFire("OML_LN_W3_pE4"))
            {
                --OML_LN_$LN_W2_mE4;
                ++OML_LN_$LN_W3_pE4;
                fire("OML_LN_W3_pE4");
                return true;
            }
        }
        //check if OML_LN_W1_mE1 can fire
        if ( (OML_LN_$geprueft1E1 >= 1) &&
                (OML_LN_$LN_W1_mE1 <= 0))
        {
            if (canFire("OML_LN_W1_mE1"))
            {
                --OML_LN_$geprueft1E1;
                ++OML_LN_$LN_W1_mE1;
                fire("OML_LN_W1_mE1");
                return true;
            }
        }
        //check if OML_LN_W1_pE6 can fire
        if ( (OML_LN_$LN_W1_pE6 <= 0) &&
                (OML_LN_$geprueft1E6 >= 1))
        {
            if (canFire("OML_LN_W1_pE6"))
            {
                ++OML_LN_$LN_W1_pE6;
                --OML_LN_$geprueft1E6;
                fire("OML_LN_W1_pE6");
                return true;
            }
        }
        //check if OML_LN_W3_mE6 can fire
        if ( (OML_LN_$LN_W3_mE6 <= 0) &&
                (OML_LN_$LN_W2_mE6 >= 1))
        {
            if (canFire("OML_LN_W3_mE6"))
            {
                ++OML_LN_$LN_W3_mE6;
                --OML_LN_$LN_W2_mE6;
                fire("OML_LN_W3_mE6");
                return true;
            }
        }
        //check if OML_LN_W6_mE6 can fire
        if ( (OML_LN_$LN_W4_pE6 >= 1) &&
                (OML_LN_$LN_W6_mE6 <= 0))
        {
            if (canFire("OML_LN_W6_mE6"))
            {
                --OML_LN_$LN_W4_pE6;
                ++OML_LN_$LN_W6_mE6;
                fire("OML_LN_W6_mE6");
                return true;
            }
        }
        //check if OML_LN_W3_pE3 can fire
        if ( (OML_LN_$LN_W3_pE3 <= 0) &&
                (OML_LN_$LN_W2_mE3 >= 1))
        {
            if (canFire("OML_LN_W3_pE3"))
            {
                ++OML_LN_$LN_W3_pE3;
                --OML_LN_$LN_W2_mE3;
                fire("OML_LN_W3_pE3");
                return true;
            }
        }
        //check if OML_LN_W4_pE6 can fire
        if ( (OML_LN_$LN_W4_pE6 <= 0) &&
                (OML_LN_$LN_W3_mE6 >= 1))
        {
            if (canFire("OML_LN_W4_pE6"))
            {
                ++OML_LN_$LN_W4_pE6;
                --OML_LN_$LN_W3_mE6;
                fire("OML_LN_W4_pE6");
                return true;
            }
        }
        //check if OML_LN_W2_mE4 can fire
        if ( (OML_LN_$LN_W1_pE4 >= 1) &&
                (OML_LN_$LN_W2_mE4 <= 0))
        {
            if (canFire("OML_LN_W2_mE4"))
            {
                --OML_LN_$LN_W1_pE4;
                ++OML_LN_$LN_W2_mE4;
                fire("OML_LN_W2_mE4");
                return true;
            }
        }
        //check if OML_LN_W1_pE3 can fire
        if ( (OML_LN_$geprueft1E3 >= 1) &&
                (OML_LN_$LN_W1_pE3 <= 0))
        {
            if (canFire("OML_LN_W1_pE3"))
            {
                --OML_LN_$geprueft1E3;
                ++OML_LN_$LN_W1_pE3;
                fire("OML_LN_W1_pE3");
                return true;
            }
        }
        //check if OML_LN_W1_pE2 can fire
        if ( (OML_LN_$geprueft1E2 >= 1) &&
                (OML_LN_$LN_W1_pE2 <= 0))
        {
            if (canFire("OML_LN_W1_pE2"))
            {
                --OML_LN_$geprueft1E2;
                ++OML_LN_$LN_W1_pE2;
                fire("OML_LN_W1_pE2");
                return true;
            }
        }
        //check if OML_LN_W3_mE5 can fire
        if ( (OML_LN_$LN_W3_mE5 <= 0) &&
                (OML_LN_$LN_W2_mE5 >= 1))
        {
            if (canFire("OML_LN_W3_mE5"))
            {
                ++OML_LN_$LN_W3_mE5;
                --OML_LN_$LN_W2_mE5;
                fire("OML_LN_W3_mE5");
                return true;
            }
        }
        //check if OML_LN_W2_mE3 can fire
        if ( (OML_LN_$LN_W2_mE3 <= 0) &&
                (OML_LN_$LN_W1_pE3 >= 1))
        {
            if (canFire("OML_LN_W2_mE3"))
            {
                ++OML_LN_$LN_W2_mE3;
                --OML_LN_$LN_W1_pE3;
                fire("OML_LN_W2_mE3");
                return true;
            }
        }
        //check if OML_LN_W1_pE5 can fire
        if ( (OML_LN_$geprueft1E5 >= 1) &&
                (OML_LN_$LN_W1_pE5 <= 0))
        {
            if (canFire("OML_LN_W1_pE5"))
            {
                --OML_LN_$geprueft1E5;
                ++OML_LN_$LN_W1_pE5;
                fire("OML_LN_W1_pE5");
                return true;
            }
        }
        //check if OML_LN_W6_mE5 can fire
        if ( (OML_LN_$LN_W4_pE5 >= 1) &&
                (OML_LN_$LN_W6_mE5 <= 0))
        {
            if (canFire("OML_LN_W6_mE5"))
            {
                --OML_LN_$LN_W4_pE5;
                ++OML_LN_$LN_W6_mE5;
                fire("OML_LN_W6_mE5");
                return true;
            }
        }
        //check if OML_LN_W4_pE5 can fire
        if ( (OML_LN_$LN_W3_mE5 >= 1) &&
                (OML_LN_$LN_W4_pE5 <= 0))
        {
            if (canFire("OML_LN_W4_pE5"))
            {
                --OML_LN_$LN_W3_mE5;
                ++OML_LN_$LN_W4_pE5;
                fire("OML_LN_W4_pE5");
                return true;
            }
        }
        //check if OML_LN_W1_pE4 can fire
        if ( (OML_LN_$geprueft1E4 >= 1) &&
                (OML_LN_$LN_W1_pE4 <= 0))
        {
            if (canFire("OML_LN_W1_pE4"))
            {
                --OML_LN_$geprueft1E4;
                ++OML_LN_$LN_W1_pE4;
                fire("OML_LN_W1_pE4");
                return true;
            }
        }
        //check if OML_LN_W5_mE4 can fire
        if ( (OML_LN_$LN_W3_pE4 >= 1) &&
                (OML_LN_$LN_W5_mE4 <= 0))
        {
            if (canFire("OML_LN_W5_mE4"))
            {
                --OML_LN_$LN_W3_pE4;
                ++OML_LN_$LN_W5_mE4;
                fire("OML_LN_W5_mE4");
                return true;
            }
        }
        //check if OML_LN_W2_pE2 can fire
        if ( (OML_LN_$LN_W1_pE2 >= 1) &&
                (OML_LN_$LN_W2_pE2 <= 0))
        {
            if (canFire("OML_LN_W2_pE2"))
            {
                --OML_LN_$LN_W1_pE2;
                ++OML_LN_$LN_W2_pE2;
                fire("OML_LN_W2_pE2");
                return true;
            }
        }
        //check if OML_LN_W5_pE3 can fire
        if ( (OML_LN_$LN_W3_pE3 >= 1) &&
                (OML_LN_$LN_W5_pE3 <= 0))
        {
            if (canFire("OML_LN_W5_pE3"))
            {
                --OML_LN_$LN_W3_pE3;
                ++OML_LN_$LN_W5_pE3;
                fire("OML_LN_W5_pE3");
                return true;
            }
        }
        //check if OML_LN_W2_mE5 can fire
        if ( (OML_LN_$LN_W1_pE5 >= 1) &&
                (OML_LN_$LN_W2_mE5 <= 0))
        {
            if (canFire("OML_LN_W2_mE5"))
            {
                --OML_LN_$LN_W1_pE5;
                ++OML_LN_$LN_W2_mE5;
                fire("OML_LN_W2_mE5");
                return true;
            }
        }
        //check if OML_LN_T110 can fire
        if ( (OML_ILTIS_$LN_834_6 >= 1) &&
                (OML_LN_$geprueft1E6 <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T110"))
            {
                ++OML_LN_$geprueft1E6;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T110");
                return true;
            }
        }
        //check if OML_LN_T125 can fire
        if ( (OML_LN_$C1_Fahrt2 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_$C1_Halt <= 0))
        {
            if (canFire("OML_LN_T125"))
            {
                --OML_LN_$C1_Fahrt2;
                ++OML_LN_$C1_Halt;
                fire("OML_LN_T125");
                return true;
            }
        }
        //check if OML_LN_T124 can fire
        if ( (OML_LN_$LN_W1_mA1 >= 1) &&
                (OML_LN_$C1_Fahrt2 <= 0) &&
                (OML_LN_$C1_Halt >= 1))
        {
            if (canFire("OML_LN_T124"))
            {
                ++OML_LN_$C1_Fahrt2;
                --OML_LN_$C1_Halt;
                fire("OML_LN_T124");
                return true;
            }
        }
        //check if OML_LN_T225 can fire
        if ( (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_$C26_Halt <= 0) &&
                (OML_LN_$C26_Fahrt >= 1))
        {
            if (canFire("OML_LN_T225"))
            {
                ++OML_LN_$C26_Halt;
                --OML_LN_$C26_Fahrt;
                fire("OML_LN_T225");
                return true;
            }
        }
        //check if OML_LN_TC2 can fire
        if ( (OML_LN_$C26_FB2 <= 0) &&
                (OML_LN_$LN_W6_mA5 >= 1) &&
                (OML_LN_$LN_W5_mA4 >= 1) &&
                (OML_LN_$LN_W6_mA6 >= 1) &&
                (OML_LN_$LN_W5_pA3 >= 1) &&
                (OML_LN_$C26_Fahrt >= 1))
        {
            if (canFire("OML_LN_TC2"))
            {
                ++OML_LN_$C26_FB2;
                fire("OML_LN_TC2");
                return true;
            }
        }
        //check if OML_LN_TC1 can fire
        if ( (OML_LN_$C26_Fahrt >= 1) &&
                (OML_LN_$LN_W2_pA2 >= 1) &&
                (OML_LN_$C26_FB1 <= 0))
        {
            if (canFire("OML_LN_TC1"))
            {
                ++OML_LN_$C26_FB1;
                fire("OML_LN_TC1");
                return true;
            }
        }
        //check if OML_LN_T224 can fire
        if ( (OML_LN_$LN_W2_pA2 >= 1) &&
                (OML_LN_$LN_W5_pA3 >= 1) &&
                (OML_LN_$LN_W5_mA4 >= 1) &&
                (OML_LN_$LN_W6_mA5 >= 1) &&
                (OML_LN_$LN_W6_mA6 >= 1) &&
                (OML_LN_$C26_Halt >= 1) &&
                (OML_LN_$C26_Fahrt <= 0))
        {
            if (canFire("OML_LN_T224"))
            {
                --OML_LN_$C26_Halt;
                ++OML_LN_$C26_Fahrt;
                fire("OML_LN_T224");
                return true;
            }
        }
        //check if OML_LN_T325 can fire
        if ( (OML_LN_$E_Fahrt >= 1) &&
                (OML_LN_$e_Halt <= 0))
        {
            if (canFire("OML_LN_T325"))
            {
                --OML_LN_$E_Fahrt;
                ++OML_LN_$e_Halt;
                fire("OML_LN_T325");
                return true;
            }
        }
        //check if OML_LN_TD2 can fire
        if ( (OML_LN_$LN_W6_mE6 >= 1) &&
                (OML_LN_$LN_W6_mE5 >= 1) &&
                (OML_LN_$LN_W5_mE4 >= 1) &&
                (OML_LN_$LN_W5_pE3 >= 1) &&
                (OML_LN_$LN_W1_mE1 >= 1) &&
                (OML_LN_$E_Fahrt >= 1) &&
                (OML_LN_$E_FB2 <= 0))
        {
            if (canFire("OML_LN_TD2"))
            {
                --OML_LN_$E_Fahrt;
                ++OML_LN_$E_FB2;
                fire("OML_LN_TD2");
                return true;
            }
        }
        //check if OML_LN_TD1 can fire
        if ( (OML_LN_$LN_W2_pE2 >= 1) &&
                (OML_LN_$E_Fahrt >= 1) &&
                (OML_LN_$E_FB1 <= 0))
        {
            if (canFire("OML_LN_TD1"))
            {
                ++OML_LN_$E_FB1;
                fire("OML_LN_TD1");
                return true;
            }
        }
        //check if OML_LN_T324 can fire
        if ( (OML_LN_$LN_W2_pE2 >= 1) &&
                (OML_LN_$LN_W6_mE5 >= 1) &&
                (OML_LN_$LN_W5_pE3 >= 1) &&
                (OML_LN_$LN_W6_mE6 >= 1) &&
                (OML_LN_$LN_W5_mE4 >= 1) &&
                (OML_LN_$LN_W1_mE1 >= 1) &&
                (OML_LN_$E_Fahrt <= 0) &&
                (OML_LN_$e_Halt >= 1))
        {
            if (canFire("OML_LN_T324"))
            {
                ++OML_LN_$E_Fahrt;
                --OML_LN_$e_Halt;
                fire("OML_LN_T324");
                return true;
            }
        }
        //check if OML_Kontakte_T4 can fire
        if ( (OML_Kontakte_$7_WS1_minus <= 0) &&
                (OML_logic_Kontakte_WS1_$logic_ws1_minus >= 1))
        {
            if (canFire("OML_Kontakte_T4"))
            {
                ++OML_Kontakte_$7_WS1_minus;
                fire("OML_Kontakte_T4");
                return true;
            }
        }
        //check if OML_Kontakte_T5 can fire
        if ( (OML_Kontakte_$7_WS1_plus <= 1) &&
                (OML_logic_Kontakte_WS1_$logic_ws1_plus >= 1))
        {
            if (canFire("OML_Kontakte_T5"))
            {
                ++OML_Kontakte_$7_WS1_plus;
                fire("OML_Kontakte_T5");
                return true;
            }
        }
        //check if OML_Kontakte_T9 can fire
        if ( (OML_Kontakte_$7_WS1_minus >= 1) &&
                (OML_logic_Kontakte_WS1_$logic_ws1_minus < 1))
        {
            if (canFire("OML_Kontakte_T9"))
            {
                --OML_Kontakte_$7_WS1_minus;
                fire("OML_Kontakte_T9");
                return true;
            }
        }
        //check if OML_Kontakte_T10 can fire
        if ( (OML_Kontakte_$7_WS1_plus >= 1) &&
                (OML_logic_Kontakte_WS1_$logic_ws1_plus < 1))
        {
            if (canFire("OML_Kontakte_T10"))
            {
                --OML_Kontakte_$7_WS1_plus;
                fire("OML_Kontakte_T10");
                return true;
            }
        }
        //check if OML_Wecker_Weichen_T57 can fire
        if ( (OML_Wecker_Weichen_$2_Weiche <= 0) &&
                (OML_Wecker_Weichen_$P1 >= 1) &&
                (OML_Stw_W1_$Endlage_minus < 1) &&
                (OML_Stw_W1_$Endlage_plus < 1))
        {
            if (canFire("OML_Wecker_Weichen_T57"))
            {
                ++OML_Wecker_Weichen_$2_Weiche;
                --OML_Wecker_Weichen_$P1;
                fire("OML_Wecker_Weichen_T57");
                return true;
            }
        }
        //check if OML_Wecker_Weichen_T302 can fire
        if ( (OML_Wecker_Weichen_$2_Weiche >= 1) &&
                (OML_Wecker_Weichen_$P1 <= 0) &&
                (OML_Stw_W1_$Endlage_plus >= 1))
        {
            if (canFire("OML_Wecker_Weichen_T302"))
            {
                --OML_Wecker_Weichen_$2_Weiche;
                ++OML_Wecker_Weichen_$P1;
                fire("OML_Wecker_Weichen_T302");
                return true;
            }
        }
        //check if OML_Wecker_Weichen_T301 can fire
        if ( (OML_Wecker_Weichen_$2_Weiche >= 1) &&
                (OML_Wecker_Weichen_$P1 <= 0) &&
                (OML_Stw_W1_$Endlage_minus >= 1))
        {
            if (canFire("OML_Wecker_Weichen_T301"))
            {
                --OML_Wecker_Weichen_$2_Weiche;
                ++OML_Wecker_Weichen_$P1;
                fire("OML_Wecker_Weichen_T301");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T123 can fire
        if ( (OML_Fstr_fe_$F_Fahrt1 >= 1) &&
                (OML_Wecker_Signal_$P21 >= 1) &&
                (OML_Wecker_Signal_$P22 <= 0))
        {
            if (canFire("OML_Wecker_Signal_T123"))
            {
                --OML_Wecker_Signal_$P21;
                ++OML_Wecker_Signal_$P22;
                fire("OML_Wecker_Signal_T123");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T121 can fire
        if ( (OML_Wecker_Signal_$P21 >= 1) &&
                (OML_Wecker_Signal_$P22 <= 0) &&
                (OML_Fstr_fe_$F_Halt >= 1))
        {
            if (canFire("OML_Wecker_Signal_T121"))
            {
                --OML_Wecker_Signal_$P21;
                ++OML_Wecker_Signal_$P22;
                fire("OML_Wecker_Signal_T121");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T120 can fire
        if ( (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_Wecker_Signal_$P18 <= 0) &&
                (OML_Wecker_Signal_$P117 >= 1))
        {
            if (canFire("OML_Wecker_Signal_T120"))
            {
                ++OML_Wecker_Signal_$P18;
                --OML_Wecker_Signal_$P117;
                fire("OML_Wecker_Signal_T120");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T10 can fire
        if ( (OML_Wecker_Signal_$P49 >= 1) &&
                (OML_Wecker_Signal_$2_Signal <= 0) &&
                (OML_Wecker_Signal_$P12 >= 1))
        {
            if (canFire("OML_Wecker_Signal_T10"))
            {
                --OML_Wecker_Signal_$P49;
                ++OML_Wecker_Signal_$2_Signal;
                fire("OML_Wecker_Signal_T10");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T119 can fire
        if ( (OML_Wecker_Signal_$P18 >= 1) &&
                (OML_Wecker_Signal_$P117 <= 0) &&
                (OML_Fstr_gf_$G_Halt < 1) &&
                (OML_Fstr_gf_$G_Fahrt3 < 1))
        {
            if (canFire("OML_Wecker_Signal_T119"))
            {
                --OML_Wecker_Signal_$P18;
                ++OML_Wecker_Signal_$P117;
                fire("OML_Wecker_Signal_T119");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T313 can fire
        if ( (OML_Wecker_Signal_$P21 < 1) &&
                (OML_Wecker_Signal_$P49 <= 0) &&
                (OML_Wecker_Signal_$2_Signal >= 1) &&
                (OML_Wecker_Signal_$P12 < 1) &&
                (OML_Wecker_Signal_$P117 < 1))
        {
            if (canFire("OML_Wecker_Signal_T313"))
            {
                ++OML_Wecker_Signal_$P49;
                --OML_Wecker_Signal_$2_Signal;
                fire("OML_Wecker_Signal_T313");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T22 can fire
        if ( (OML_Wecker_Signal_$P22 >= 1) &&
                (OML_Fstr_fg_$F_Fahrt3 < 1) &&
                (OML_Fstr_fe_$F_Fahrt1 < 1) &&
                (OML_Wecker_Signal_$P21 <= 0) &&
                (OML_Fstr_fe_$F_Halt < 1))
        {
            if (canFire("OML_Wecker_Signal_T22"))
            {
                --OML_Wecker_Signal_$P22;
                ++OML_Wecker_Signal_$P21;
                fire("OML_Wecker_Signal_T22");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T124 can fire
        if ( (OML_Wecker_Signal_$P21 >= 1) &&
                (OML_Wecker_Signal_$P22 <= 0) &&
                (OML_Fstr_fg_$F_Fahrt3 >= 1))
        {
            if (canFire("OML_Wecker_Signal_T124"))
            {
                --OML_Wecker_Signal_$P21;
                ++OML_Wecker_Signal_$P22;
                fire("OML_Wecker_Signal_T124");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T314 can fire
        if ( (OML_Wecker_Signal_$P12 >= 1) &&
                (OML_Wecker_Signal_$P13 <= 0) &&
                (OML_Fstr_ef_$E_Halt >= 1))
        {
            if (canFire("OML_Wecker_Signal_T314"))
            {
                --OML_Wecker_Signal_$P12;
                ++OML_Wecker_Signal_$P13;
                fire("OML_Wecker_Signal_T314");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T11 can fire
        if ( (OML_Wecker_Signal_$P49 >= 1) &&
                (OML_Wecker_Signal_$2_Signal <= 0) &&
                (OML_Wecker_Signal_$P117 >= 1))
        {
            if (canFire("OML_Wecker_Signal_T11"))
            {
                --OML_Wecker_Signal_$P49;
                ++OML_Wecker_Signal_$2_Signal;
                fire("OML_Wecker_Signal_T11");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T316 can fire
        if ( (OML_Wecker_Signal_$P12 >= 1) &&
                (OML_Wecker_Signal_$P13 <= 0) &&
                (OML_Fstr_ef_$E_Fahrt1 >= 1))
        {
            if (canFire("OML_Wecker_Signal_T316"))
            {
                --OML_Wecker_Signal_$P12;
                ++OML_Wecker_Signal_$P13;
                fire("OML_Wecker_Signal_T316");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T315 can fire
        if ( (OML_Wecker_Signal_$P12 <= 0) &&
                (OML_Wecker_Signal_$P13 >= 1) &&
                (OML_Fstr_ef_$E_Halt < 1) &&
                (OML_Fstr_ef_$E_Fahrt1 < 1))
        {
            if (canFire("OML_Wecker_Signal_T315"))
            {
                ++OML_Wecker_Signal_$P12;
                --OML_Wecker_Signal_$P13;
                fire("OML_Wecker_Signal_T315");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T118 can fire
        if ( (OML_Wecker_Signal_$P117 >= 1) &&
                (OML_Fstr_gf_$G_Halt >= 1) &&
                (OML_Wecker_Signal_$P18 <= 0))
        {
            if (canFire("OML_Wecker_Signal_T118"))
            {
                --OML_Wecker_Signal_$P117;
                ++OML_Wecker_Signal_$P18;
                fire("OML_Wecker_Signal_T118");
                return true;
            }
        }
        //check if OML_Wecker_Signal_T12 can fire
        if ( (OML_Wecker_Signal_$P21 >= 1) &&
                (OML_Wecker_Signal_$P49 >= 1) &&
                (OML_Wecker_Signal_$2_Signal <= 0))
        {
            if (canFire("OML_Wecker_Signal_T12"))
            {
                --OML_Wecker_Signal_$P49;
                ++OML_Wecker_Signal_$2_Signal;
                fire("OML_Wecker_Signal_T12");
                return true;
            }
        }
        //check if OML_Wecker_Block_T40 can fire
        if ( (OML_BL_ZB_OM_$vorgebl_v >= 1) &&
                (OML_Wecker_Block_$P135 <= 0) &&
                (OML_Wecker_Block_$P39 >= 1))
        {
            if (canFire("OML_Wecker_Block_T40"))
            {
                ++OML_Wecker_Block_$P135;
                --OML_Wecker_Block_$P39;
                fire("OML_Wecker_Block_T40");
                return true;
            }
        }
        //check if OML_Wecker_Block_T37 can fire
        if ( (OML_Wecker_Block_$P39 >= 1) &&
                (OML_BL_ZB_OM_$vorgebl_n >= 1) &&
                (OML_Wecker_Block_$P135 <= 0))
        {
            if (canFire("OML_Wecker_Block_T37"))
            {
                --OML_Wecker_Block_$P39;
                ++OML_Wecker_Block_$P135;
                fire("OML_Wecker_Block_T37");
                return true;
            }
        }
        //check if OML_Wecker_Block_T27 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_n >= 1) &&
                (OML_Wecker_Block_$P40 >= 1) &&
                (OML_Wecker_Block_$P27 <= 0))
        {
            if (canFire("OML_Wecker_Block_T27"))
            {
                --OML_Wecker_Block_$P40;
                ++OML_Wecker_Block_$P27;
                fire("OML_Wecker_Block_T27");
                return true;
            }
        }
        //check if OML_Wecker_Block_T31 can fire
        if ( (OML_Wecker_Block_$P40 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_Wecker_Block_$P27 <= 0))
        {
            if (canFire("OML_Wecker_Block_T31"))
            {
                --OML_Wecker_Block_$P40;
                ++OML_Wecker_Block_$P27;
                fire("OML_Wecker_Block_T31");
                return true;
            }
        }
        //check if OML_Wecker_Block_T26 can fire
        if ( (OML_Wecker_Block_$P40 < 1) &&
                (OML_Wecker_Block_$P39 < 1) &&
                (OML_Wecker_Block_$P48 <= 0) &&
                (OML_Wecker_Block_$2_Block >= 1))
        {
            if (canFire("OML_Wecker_Block_T26"))
            {
                ++OML_Wecker_Block_$P48;
                --OML_Wecker_Block_$2_Block;
                fire("OML_Wecker_Block_T26");
                return true;
            }
        }
        //check if OML_Wecker_Block_T59 can fire
        if ( (OML_Wecker_Block_$P40 >= 1) &&
                (OML_Wecker_Block_$P39 >= 1) &&
                (OML_Wecker_Block_$P48 >= 1) &&
                (OML_Wecker_Block_$2_Block <= 0))
        {
            if (canFire("OML_Wecker_Block_T59"))
            {
                --OML_Wecker_Block_$P48;
                ++OML_Wecker_Block_$2_Block;
                fire("OML_Wecker_Block_T59");
                return true;
            }
        }
        //check if OML_Wecker_Block_T38 can fire
        if ( (OML_Wecker_Block_$P39 >= 1) &&
                (OML_Wecker_Block_$P135 <= 0) &&
                (OML_BL_ZB_OM_$belegt_n >= 1))
        {
            if (canFire("OML_Wecker_Block_T38"))
            {
                --OML_Wecker_Block_$P39;
                ++OML_Wecker_Block_$P135;
                fire("OML_Wecker_Block_T38");
                return true;
            }
        }
        //check if OML_Wecker_Block_T28 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v < 1) &&
                (OML_BL_OM_LN_$Grundstlg_n < 1) &&
                (OML_Wecker_Block_$P40 <= 0) &&
                (OML_Wecker_Block_$P27 >= 1) &&
                (OML_BL_OM_LN_$vorgebl_n < 1) &&
                (OML_BL_OM_LN_$belegt_n < 1) &&
                (OML_BL_OM_LN_$vorgebl_v < 1) &&
                (OML_BL_OM_LN_$belegt_v < 1))
        {
            if (canFire("OML_Wecker_Block_T28"))
            {
                ++OML_Wecker_Block_$P40;
                --OML_Wecker_Block_$P27;
                fire("OML_Wecker_Block_T28");
                return true;
            }
        }
        //check if OML_Wecker_Block_T36 can fire
        if ( (OML_Wecker_Block_$P135 >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v < 1) &&
                (OML_BL_ZB_OM_$vorgebl_n < 1) &&
                (OML_BL_ZB_OM_$vorgebl_v < 1) &&
                (OML_Wecker_Block_$P39 <= 0) &&
                (OML_BL_ZB_OM_$belegt_v < 1) &&
                (OML_BL_ZB_OM_$Grundstlg_n < 1) &&
                (OML_BL_ZB_OM_$belegt_n < 1))
        {
            if (canFire("OML_Wecker_Block_T36"))
            {
                --OML_Wecker_Block_$P135;
                ++OML_Wecker_Block_$P39;
                fire("OML_Wecker_Block_T36");
                return true;
            }
        }
        //check if OML_Wecker_Block_T41 can fire
        if ( (OML_Wecker_Block_$P39 >= 1) &&
                (OML_BL_ZB_OM_$belegt_v >= 1) &&
                (OML_Wecker_Block_$P135 <= 0))
        {
            if (canFire("OML_Wecker_Block_T41"))
            {
                --OML_Wecker_Block_$P39;
                ++OML_Wecker_Block_$P135;
                fire("OML_Wecker_Block_T41");
                return true;
            }
        }
        //check if OML_Wecker_Block_T132 can fire
        if ( (OML_Wecker_Block_$P40 >= 1) &&
                (OML_Wecker_Block_$P27 <= 0) &&
                (OML_BL_OM_LN_$vorgebl_v >= 1))
        {
            if (canFire("OML_Wecker_Block_T132"))
            {
                --OML_Wecker_Block_$P40;
                ++OML_Wecker_Block_$P27;
                fire("OML_Wecker_Block_T132");
                return true;
            }
        }
        //check if OML_Wecker_Block_T133 can fire
        if ( (OML_Wecker_Block_$P40 >= 1) &&
                (OML_Wecker_Block_$P27 <= 0) &&
                (OML_BL_OM_LN_$belegt_v >= 1))
        {
            if (canFire("OML_Wecker_Block_T133"))
            {
                --OML_Wecker_Block_$P40;
                ++OML_Wecker_Block_$P27;
                fire("OML_Wecker_Block_T133");
                return true;
            }
        }
        //check if OML_Wecker_Block_T29 can fire
        if ( (OML_Wecker_Block_$P40 >= 1) &&
                (OML_Wecker_Block_$P27 <= 0) &&
                (OML_BL_OM_LN_$vorgebl_n >= 1))
        {
            if (canFire("OML_Wecker_Block_T29"))
            {
                --OML_Wecker_Block_$P40;
                ++OML_Wecker_Block_$P27;
                fire("OML_Wecker_Block_T29");
                return true;
            }
        }
        //check if OML_Wecker_Block_T135 can fire
        if ( (OML_Wecker_Block_$P39 >= 1) &&
                (OML_Wecker_Block_$P135 <= 0) &&
                (OML_BL_ZB_OM_$Grundstlg_n >= 1))
        {
            if (canFire("OML_Wecker_Block_T135"))
            {
                --OML_Wecker_Block_$P39;
                ++OML_Wecker_Block_$P135;
                fire("OML_Wecker_Block_T135");
                return true;
            }
        }
        //check if OML_Wecker_Block_T30 can fire
        if ( (OML_Wecker_Block_$P40 >= 1) &&
                (OML_BL_OM_LN_$belegt_n >= 1) &&
                (OML_Wecker_Block_$P27 <= 0))
        {
            if (canFire("OML_Wecker_Block_T30"))
            {
                --OML_Wecker_Block_$P40;
                ++OML_Wecker_Block_$P27;
                fire("OML_Wecker_Block_T30");
                return true;
            }
        }
        //check if OML_Wecker_Block_T39 can fire
        if ( (OML_Wecker_Block_$P39 >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
                (OML_Wecker_Block_$P135 <= 0))
        {
            if (canFire("OML_Wecker_Block_T39"))
            {
                --OML_Wecker_Block_$P39;
                ++OML_Wecker_Block_$P135;
                fire("OML_Wecker_Block_T39");
                return true;
            }
        }
        //check if OML_logic_Kontakte_WS1_enter_logic_ws1_minus can fire
        if ( (OML_logic_Kontakte_WS1_$logic_ws1_minus <= 0) &&
                (OML_logic_Kontakte_WS1_$ws1_minus >= 1) &&
                (OML_logic_Kontakte_WS1_$ws1_plus < 1))
        {
            if (canFire("OML_logic_Kontakte_WS1_enter_logic_ws1_minus"))
            {
                ++OML_logic_Kontakte_WS1_$logic_ws1_minus;
                fire("OML_logic_Kontakte_WS1_enter_logic_ws1_minus");
                return true;
            }
        }
        //check if OML_logic_Kontakte_WS1_enter_logic_ws1_plus can fire
        if ( (OML_logic_Kontakte_WS1_$logic_ws1_plus <= 1) &&
                (OML_logic_Kontakte_WS1_$ws1_plus >= 1) &&
                (OML_logic_Kontakte_WS1_$ws1_minus >= 1))
        {
            if (canFire("OML_logic_Kontakte_WS1_enter_logic_ws1_plus"))
            {
                ++OML_logic_Kontakte_WS1_$logic_ws1_plus;
                fire("OML_logic_Kontakte_WS1_enter_logic_ws1_plus");
                return true;
            }
        }
        //check if OML_logic_Kontakte_WS1_exit_logic_ws1_minus can fire
        if ( (OML_logic_Kontakte_WS1_$logic_ws1_minus >= 1) &&
                (OML_logic_Kontakte_WS1_$ws1_minus >= 1) &&
                (OML_logic_Kontakte_WS1_$ws1_plus >= 1))
        {
            if (canFire("OML_logic_Kontakte_WS1_exit_logic_ws1_minus"))
            {
                --OML_logic_Kontakte_WS1_$logic_ws1_minus;
                fire("OML_logic_Kontakte_WS1_exit_logic_ws1_minus");
                return true;
            }
        }
        //check if OML_logic_Kontakte_WS1_exit_logic_ws1_plus can fire
        if ( (OML_logic_Kontakte_WS1_$logic_ws1_plus >= 1) &&
                (OML_logic_Kontakte_WS1_$ws1_plus < 1) &&
                (OML_logic_Kontakte_WS1_$ws1_minus >= 1))
        {
            if (canFire("OML_logic_Kontakte_WS1_exit_logic_ws1_plus"))
            {
                --OML_logic_Kontakte_WS1_$logic_ws1_plus;
                fire("OML_logic_Kontakte_WS1_exit_logic_ws1_plus");
                return true;
            }
        }
        return false;
    }
}