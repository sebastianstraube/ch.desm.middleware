package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import org.apache.log4j.Logger;

abstract class PetrinetOmlEndpointExportBase {
    public int OML_Stw_FSS_SM_$FSS_30EG_reached_store;
    public int OML_Stw_FSS_SM_$FSS30F_reached_store;
    public int OML_Stw_FSS_SM_$NAL_pressed_store;
    public int OML_Stw_FSS_SM_$FSS_Sperrm_ein;
    public int OML_Stw_FSS_SM_$FSS_Sperrm_aus;
    public int OML_Stw_FSS_KSM_$90EG_store;
    public int OML_LN_$LN_W1_pE6;
    public int OML_LN_$LN_W3_pE3;
    public int OML_LN_$LN_W1_pA6;
    public int OML_LN_$LN_W3_mE6;
    public int OML_LN_$LN_W2_mE6;
    public int OML_LN_$LN_W5_mE4;
    public int OML_LN_$geprueft1E6;
    public int OML_LN_$LN_W4_pE5;
    public int OML_LN_$LN_W3_pE4;
    public int OML_LN_$C26_FB2;
    public int OML_LN_$C1_Halt;
    public int OML_LN_$C26_FB1;
    public int OML_LN_$LN_W6_mE6;
    public int OML_LN_$E_FB2;
    public int OML_LN_$E_FB1;
    public int OML_LN_$geprueft2A6;
    public int OML_LN_$e_Halt;
    public int OML_LN_$LN_W1_mE1;
    public int OML_LN_$LN_W1_pE2;
    public int OML_LN_$LN_W1_pE3;
    public int OML_LN_$LN_W2_pE2;
    public int OML_LN_$LN_W5_pE3;
    public int OML_LN_$LN_W2_mA6;
    public int OML_LN_$LN_W1_pE4;
    public int OML_LN_$LN_W6_mE5;
    public int OML_LN_$LN_W4_pE6;
    public int OML_LN_$geprueft1A6;
    public int OML_LN_$LN_W2_mE3;
    public int OML_LN_$LN_W2_mE5;
    public int OML_LN_$LN_W2_mE4;
    public int OML_LN_$LN_W3_mE5;
    public int OML_LN_$LN_W1_pE5;
    public int OML_LN_$LN_W4_pA6;
    public int OML_LN_$geprueft2A5;
    public int OML_LN_$LN_W3_mA6;
    public int OML_LN_$LN_W6_mA6;
    public int OML_LN_$C1_FB1;
    public int OML_LN_$LN_W3_mA5;
    public int OML_LN_$LN_W2_mA5;
    public int OML_LN_$LN_W4_pA5;
    public int OML_LN_$LN_W6_mA5;
    public int OML_Kontakte_$6_FBF_nZB;
    public int OML_ext_Vb_$F_VS_Lampe_Warn_def;
    public int OML_ext_Vb_$G_Lampe_gruenFB3_def;
    public int OML_ext_Vb_$E_Lampe_gruenFB1_def;
    public int OML_ext_Vb_$G_VS_Lampe_Warn_def;
    public int OML_ext_Vb_$Ueberw_W1_plus;
    public int OML_ext_Vb_$Ueberw_W1_minus;
    public int OML_ext_Vb_$G_VS_Lampe_Fahrt_def;
    public int OML_ext_Vb_$F_Lampe_gruenFB3_def;
    public int OML_ext_Vb_$F_VS_Lampe_Fahrt_def;
    public int OML_Kontakte_$6_FBA_nZB;
    public int OML_LN_$C26_Halt;
    public int OML_LN_Fstr_aufloesen;
    public int OML_Lampen_Streckenblock_$1_FBV_vZB;
    public int OML_Lampen_Streckenblock_$1_BL_nZB_weiss;
    public int OML_Lampen_Stoerung_$1_F_VS_Stoer;
    public int OML_Lampen_Streckenblock_$1_BL_nLN_rot;
    public int OML_Lampen_Isolierung_$Iso_cd_ein;
    public int OML_Lampen_Signal_E_$1_E_gruenFB1;
    public int OML_Lampen_Signal_F_$1_F_rot;
    public int OML_Lampen_Signal_F_$1_F_gruenFB3;
    public int OML_Lampen_Signal_G_$1_G_gruenFB1;
    public int OML_Lampen_Streckenblock_$1_FBV_vLN;
    public int OML_Lampen_Streckenblock_$1_BL_vZB_weiss;
    public int OML_Lampen_Signal_G_$1_G_rot;
    public int OML_Lampen_Streckenblock_$1_BL_nZB_rot;
    public int OML_Lampen_Isolierung_$Iso_ef_ein;
    public int OML_Lampen_Streckenblock_$1_BL_vZB_rot;
    public int OML_Lampen_Fahrstrasse_$1_Fstr_gf;
    public int OML_Lampen_Isolierung_$Iso_1_ein;
    public int OML_ZB_$geprueft1A2;
    public int OML_ZB_$cd_belegt;
    public int OML_Lampen_Streckenblock_$1_BL_nLN_weiss;
    public int OML_Lampen_Fahrstrasse_$1_Fstr_ef;
    public int OML_Lampen_Signal_F_$1_F_gruenFB1;
    public int OML_Lampen_Isolierung_$Iso_egf_ein;
    public int OML_Lampen_Signal_G_$1_G_gruenFB3;
    public int OML_ZB_$ZB_Grundstlg;
    public int OML_Lampen_Signal_E_$1_E_rot;
    public int OML_ZB_$C_Halt;
    public int OML_Lampen_Streckenblock_$1_BL_vLN_weiss;
    public int OML_Lampen_Streckenblock_$1_BL_vLN_rot;
    public int OML_Lampen_Stoerung_$1_G_VS_Stoer;
    public int OML_Lampen_WS1_$1_WS1_Freig;
    public int OML_ZB_$ZB_W2_pE2;
    public int OML_ZB_$D_Halt;
    public int OML_ZB_$geprueft1A1;
    public int OML_ZB_$geprueft1E2;
    public int OML_ZB_$ZB_W2_mE1;
    public int OML_ZB_$geprueft2A2;
    public int OML_ZB_$geprueft1E1;
    public int OML_ZB_$ZB_W2_pA2;
    public int OML_ZB_$ZB_W2_mA1;
    public int Test_OM_Weiche_1_init_minus;
    public int Test_OM_Weiche_1_PW4;
    public int Test_OM_Weiche_1_end_test_w1plus;
    public int Test_OM_Weiche_1_PW12;
    public int Test_OM_Weiche_1_PW15;
    public int Test_OM_Weiche_1_PW14;
    public int Test_OM_Fahrt_ef_Pef1;
    public int Test_OM_start_test;
    public int Test_OM_Weiche_1_PW2;
    public int Test_OM_Weiche_1_PW3;
    public int Test_OM_Weiche_1_PW6;
    public int Test_OM_Fahrt_ef_Pef2;
    public int Test_OM_Fahrt_ef_Pef3;
    public int Test_OM_Fahrt_fe;
    public int Test_OM_P11;
    public int Test_OM_Weiche_1_init_plus;
    public int Test_OM_Fahrt_ef;
    public int Test_OM_Weiche_1_start;
    public int Test_OM_Weiche_1_end_test_w1minus;
    public int Test_OM_Weiche_1_PW5;
    public int Test_OM_Weiche_1_PW11;
    public int Test_OM_W_1_minus;
    public int Test_OM_end_test;
    public int Test_OM_Weiche_1_PW13;
    public int Test_OM_Fahrt_ef_Pef4;
    public int Test_OM_Fahrt_fg;
    public int Test_OM_Fahrt_ef_Pef5;
    public int Test_OM_Fahrt_ef_init;
    public int Test_OM_P12;
    public int Test_OM_W_1_plus;
    public int Test_OM_Weiche_1_PW1;
    public int Test_OM_Fahrt_gf;
    public int OML_Kontakte_$8_FSS_90EG;
    public int OML_Kontakte_$6_RM_nLN;
    public int OML_Kontakte_$6_Gleist_ZB;
    public int OML_Kontakte_$6_ISU_Sign;
    public int OML_Kontakte_$8_FSS_30F;
    public int OML_Kontakte_$8_FSS_45F;
    public int OML_Wecker_Signal_$P22;
    public int OML_Kontakte_$8_FSS_10F;
    public int OML_Kontakte_$6_FBA_nLN;
    public int OML_Kontakte_$8_FSS_90F;
    public int OML_Kontakte_$6_FBF_nLN;
    public int OML_Kontakte_$6_NT_W1;
    public int OML_Kontakte_$7_WS1_minus;
    public int OML_Kontakte_$8_FSS_45EG;
    public int OML_Wecker_Weichen_$2_Weiche;
    public int OML_Wecker_Signal_$P49;
    public int OML_Kontakte_$8_FSS_10EG;
    public int OML_Kontakte_$6_RM_nZB;
    public int OML_Kontakte_$8_FSS_0EGF;
    public int OML_Kontakte_$8_FSS_30EG;
    public int OML_Kontakte_$6_NAL;
    public int OML_Kontakte_$6_BLU_EG;
    public int OML_Kontakte_$6_Gleist_EMM;
    public int OML_Kontakte_$7_WS1_plus;
    public int OML_Kontakte_$7_WS1_1;
    public int OML_logic_Kontakte_WS1_$ws1_minus;
    public int OML_Wecker_Signal_$2_Signal;
    public int Test_OM_Fahrt_ef_Pef7;
    public int OML_Wecker_Signal_$P13;
    public int OML_Wecker_Signal_$P21;
    public int OML_Wecker_Block_$2_Block;
    public int OML_logic_Kontakte_WS1_$logic_ws1_plus;
    public int OML_logic_Kontakte_WS1_$ws1_plus;
    public int OML_Wecker_Block_$P135;
    public int OML_Wecker_Signal_$P12;
    public int OML_Wecker_Block_$P39;
    public int OML_Wecker_Block_$P40;
    public int OML_Wecker_Block_$P27;
    public int OML_Wecker_Signal_$P18;
    public int OML_logic_Kontakte_WS1_$logic_ws1_minus;
    public int OML_Wecker_Block_$P48;
    public int OML_Wecker_Signal_$P117;
    public int Test_OM_Fahrt_fg_Pfg2;
    public int Test_OM_Fahrt_fg_Pfg23;
    public int Test_OM_Fahrt_gf_Pgf24;
    public int Test_OM_Fahrt_fg_Pfg7;
    public int Test_OM_Fahrt_gf_Pgf17;
    public int Test_OM_Fahrt_fg_Pfg1;
    public int Test_OM_Fahrt_gf_Pgf19;
    public int Test_OM_Fahrt_fg_Pfg6;
    public int Test_OM_Fahrt_fg_Pfg24;
    public int Test_OM_Fahrt_fg_Pfg10;
    public int Test_OM_Fahrt_gf_Pgf14;
    public int Test_OM_Fahrt_fg_Pfg13;
    public int Test_OM_Fahrt_gf_Pgf10;
    public int Test_OM_Fahrt_fg_Pfg18;
    public int Test_OM_Fahrt_fg_Pfg15;
    public int Test_OM_Fahrt_gf_Pgf21;
    public int Test_OM_Fahrt_gf_end_test_gf;
    public int Test_OM_Fahrt_fg_Pfg16;
    public int Test_OM_Fahrt_fg_init;
    public int Test_OM_Fahrt_gf_Pgf4;
    public int Test_OM_Fahrt_fg_Pfg17;
    public int Test_OM_Fahrt_fg_Pfg19;
    public int Test_OM_Fahrt_gf_Pgf23;
    public int Test_OM_Fahrt_fg_Pfg5;
    public int Test_OM_Fahrt_gf_Pgf6;
    public int Test_OM_Fahrt_gf_Pgf8;
    public int Test_OM_Fahrt_fg_Pfg8;
    public int Test_OM_Fahrt_fg_Pfg21;
    public int Test_OM_Fahrt_gf_Pgf5;
    public int Test_OM_Fahrt_gf_Pgf15;
    public int Test_OM_Fahrt_fg_Pfg3;
    public int Test_OM_Fahrt_fg_Pfg20;
    public int Test_OM_Fahrt_fe_Pfe2;
    public int Test_OM_Fahrt_ef_Pef10;
    public int Test_OM_Fahrt_fe_Pfe9;
    public int Test_OM_Fahrt_fe_Pfe11;
    public int Test_OM_Fahrt_fe_Pfe3;
    public int Test_OM_Fahrt_fe_Pfe14;
    public int Test_OM_Fahrt_fe_Pfe17;
    public int Test_OM_Fahrt_fe_Pfe19;
    public int Test_OM_Fahrt_fe_Pfe16;
    public int Test_OM_Fahrt_fe_Pfe4;
    public int Test_OM_Fahrt_fe_Pfe5;
    public int Test_OM_Fahrt_fe_Pfe18;
    public int Test_OM_Fahrt_fe_init;
    public int Test_OM_Fahrt_fe_Pfe20;
    public int Test_OM_Fahrt_ef_Pef15;
    public int Test_OM_Fahrt_ef_Pef16;
    public int Test_OM_Fahrt_ef_Pef18;
    public int Test_OM_Fahrt_ef_Pef9;
    public int Test_OM_Fahrt_ef_Pef6;
    public int Test_OM_Fahrt_fe_Pfe12;
    public int Test_OM_Fahrt_fe_Pfe1;
    public int Test_OM_Fahrt_fe_Pfe21;
    public int Test_OM_Fahrt_ef_Pef19;
    public int Test_OM_Fahrt_ef_Pef12;
    public int Test_OM_Fahrt_ef_end_test_ef;
    public int Test_OM_Fahrt_fe_Pfe15;
    public int Test_OM_Fahrt_ef_Pef14;
    public int Test_OM_Fahrt_ef_Pef17;
    public int Test_OM_Fahrt_ef_Pef8;
    public int Test_OM_Fahrt_ef_Pef13;
    public int Test_OM_Fahrt_ef_Pef11;
    public int Test_OM_Fahrt_fe_Pfe7;
    public int Test_OM_Fahrt_gf_Pgf12;
    public int Test_OM_Fahrt_fe_Pfe22;
    public int Test_OM_Fahrt_fe_Pfe6;
    public int Test_OM_Fahrt_gf_init;
    public int Test_OM_Fahrt_gf_Pgf16;
    public int Test_OM_Fahrt_gf_Pgf7;
    public int Test_OM_Fahrt_gf_Pgf13;
    public int Test_OM_Fahrt_gf_Pgf1;
    public int Test_OM_Fahrt_gf_Pgf20;
    public int Test_OM_Fahrt_fe_Pfe8;
    public int Test_OM_Fahrt_fe_Pfe23;
    public int Test_OM_Fahrt_fe_Pfe13;
    public int Test_OM_Fahrt_fe_end_test_fe;
    public int Test_OM_Fahrt_gf_Pgf22;
    public int Test_OM_Fahrt_gf_Pgf18;
    public int Test_OM_Fahrt_gf_Pgf3;
    public int Test_OM_Fahrt_fe_Pfe10;
    public int Test_OM_Fahrt_gf_Pgf9;
    public int Test_OM_Fahrt_gf_Pgf2;
    public int Test_OM_Fahrt_gf_Pgf11;
    public int OML_ZB_$D_FB1;
    public int OML_EMM_$EMM_W8_mA5;
    public int OML_EMM_$geprueft1A4;
    public int OML_EMM_$geprueft1E4;
    public int OML_ZB_$ZB_W1_mE1;
    public int OML_ZB_$C_FB2;
    public int OML_EMM_$geprueft1A1;
    public int OML_EMM_$EMM_W10_pA1;
    public int OML_EMM_$EMM_W10_mA3;
    public int OML_EMM_$EMM_W10_pA2;
    public int OML_EMM_$geprueft2A3;
    public int OML_ZB_$ZB_W1_pA2;
    public int OML_EMM_$EMM_W9_mA4;
    public int OML_EMM_$EMM_W8_pA4;
    public int OML_ZB_$Fstr_aufloesen;
    public int OML_EMM_$geprueft2A1;
    public int OML_EMM_$EMM_W9_pA3;
    public int OML_ZB_$C_FB1;
    public int OML_EMM_$EMM_W7_pA2;
    public int OML_EMM_$EMM_W7_mA1;
    public int OML_EMM_$geprueft2A5;
    public int OML_ZB_$ZB_W1_pE2;
    public int OML_EMM_$geprueft2A2;
    public int OML_EMM_$geprueft1A2;
    public int OML_ZB_$geprueft2A1;
    public int OML_EMM_$geprueft1A3;
    public int OML_ZB_$ZB_W1_mA1;
    public int OML_ZB_$D_FB2;
    public int OML_EMM_$EMM_Grundstlg;
    public int OML_EMM_$geprueft2A4;
    public int OML_EMM_$EMM_W9_mA5;
    public int OML_EMM_$geprueft1A5;
    public int OML_EMM_$EMM_W9_pE3;
    public int OML_EMM_$EMM_W10_pE2;
    public int OML_EMM_$EMM_W10_mE3;
    public int OML_EMM_$EMM_W7_mE1;
    public int OML_EMM_$EMM_W10_pE1;
    public int OML_EMM_$EMM_W7_pE2;
    public int OML_EMM_$geprueft1E2;
    public int OML_EMM_$geprueft1E1;
    public int OML_EMM_$geprueft1E3;
    public int OML_EMM_$C_aufloesen;
    public int OML_ILTIS_$EMM_3_833;
    public int OML_ILTIS_$EMM_833_4;
    public int OML_ILTIS_$EMM_833_5;
    public int OML_ILTIS_$EMM_2_833;
    public int OML_ILTIS_$ZB_1_138;
    public int OML_ILTIS_$ZB_138_2;
    public int OML_EMM_$EMM_W10_mE5;
    public int OML_EMM_$C_FB1;
    public int OML_ILTIS_$LN_1_834;
    public int OML_ILTIS_$EMM_1_833;
    public int OML_EMM_$EMM_W8_mE5;
    public int OML_EMM_$EMM_W10_mA5;
    public int OML_EMM_$EMM_W10_mA4;
    public int OML_ILTIS_$EMM_5_833;
    public int OML_ILTIS_$EMM_833_3;
    public int OML_ILTIS_$EMM_833_1;
    public int OML_ILTIS_$EMM_833_2;
    public int OML_ILTIS_$ZB_2_138;
    public int OML_EMM_$D_FB2;
    public int OML_EMM_$C_FB2;
    public int OML_EMM_$EMM_W9_mE5;
    public int OML_EMM_$EMM_W9_mE4;
    public int OML_EMM_$C_Halt;
    public int OML_ILTIS_$EMM_4_833;
    public int OML_ILTIS_$ZB_138_1;
    public int OML_ILTIS_$LN_834_1;
    public int OML_EMM_$EMM_W10_mE4;
    public int OML_EMM_$D_FB1;
    public int OML_EMM_$geprueft1E5;
    public int OML_EMM_$D_Halt;
    public int OML_EMM_$EMM_W8_pE4;
    public int OML_ILTIS_$LN_2_834;
    public int OML_ILTIS_$LN_6_834;
    public int OML_ILTIS_$LN_4_834;
    public int OML_ILTIS_$LN_3_834;
    public int OML_ILTIS_$LN_834_4;
    public int OML_ILTIS_$LN_834_3;
    public int OML_ILTIS_$LN_834_5;
    public int OML_ILTIS_$LN_834_2;
    public int OML_ILTIS_$LN_834_6;
    public int Test_OM_Fahrt_fg_Pfg9;
    public int Test_OM_Fahrt_fg_Pfg4;
    public int Test_OM_Fahrt_fg_Pfg14;
    public int Test_OM_Fahrt_fg_Pfg22;
    public int Test_OM_Fahrt_fg_end_test_fg;
    public int Test_OM_Fahrt_fg_Pfg12;
    public int Test_OM_Fahrt_fg_Pfg11;
    public int OML_Stw_WS1_$gestoert_m;
    public int OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
    public int OML_Stw_W1_$Umstellen_plus;
    public int OML_Stw_WS1_SM_$Sperrm_aus;
    public int OML_Stw_WS1_SM_$Sperrm_ein;
    public int OML_Stw_WS1_$endlage_minus;
    public int OML_Stw_W1_$Endlage_minus;
    public int OML_Fstr_ef_$geprueft2;
    public int OML_Fstr_ef_$geprueft3;
    public int OML_Stw_W1_$Endlage_plus;
    public int OML_Stw_W1_$Umstellen_minus;
    public int OML_Fstr_ef_$P6;
    public int OML_Fstr_ef_$E_Fahrt1;
    public int OML_Stw_FSS_KSM_$90F_store;
    public int OML_Stw_WS1_$keine_Endlage_minus;
    public int OML_Stw_WS1_$keine_Endlage_plus;
    public int OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
    public int OML_Stw_WS1_$endlage_plus;
    public int OML_Stw_WS1_$gestoert_p;
    public int OML_Fstr_ef_$geprueft1;
    public int OML_Fstr_ef_$Zug_eingefahren;
    public int OML_Fstr_ef_$verschlossen;
    public int OML_Fstr_ef_$aufgeloest;
    public int OML_Fstr_fe_$store_1_egf_belegt;
    public int OML_Fstr_fe_$P2;
    public int OML_Fstr_fe_$verschlossen;
    public int OML_Fstr_fe_$F_Halt;
    public int OML_Fstr_fe_$Zug_eingefahren;
    public int OML_Fstr_fe_$aufgeloest;
    public int OML_Fstr_ef_$prison_signal_steller;
    public int OML_Fstr_ef_$E_Halt;
    public int OML_Fstr_ef_$signal_steller;
    public int OML_Fstr_ef_$Pstore_1_ef_belegt;
    public int OML_Fstr_fe_$geprueft;
    public int OML_Fstr_ef_$gemerkt_90EB;
    public int OML_LN_$geprueft1A2;
    public int OML_LN_$geprueft2A2;
    public int OML_ILTIS_$freigeben_vZB;
    public int OML_ILTIS_$anfordern_vLN;
    public int OML_ILTIS_$festgehalten_vLN;
    public int OML_ILTIS_$RM_LN_OM;
    public int OML_ILTIS_$RM_ZB_OM;
    public int OML_LN_$LN_Grundstlg;
    public int OML_LN_$geprueft2A3;
    public int OML_ILTIS_$freigegeben_vZB;
    public int OML_LN_$ce_belegt;
    public int OML_LN_$LN_W1_mA1;
    public int OML_LN_$geprueft1E5;
    public int OML_LN_$geprueft1E2;
    public int OML_LN_$LN_W2_mA3;
    public int OML_LN_$geprueft1A1;
    public int OML_LN_$geprueft1A4;
    public int OML_LN_$geprueft1A3;
    public int OML_ILTIS_$anfordern_vZB;
    public int OML_LN_$geprueft1A5;
    public int OML_LN_$LN_W1_pA3;
    public int OML_ILTIS_$festgehalten_v_ZB;
    public int OML_LN_$geprueft1E1;
    public int OML_LN_$LN_W1_pA5;
    public int OML_LN_$geprueft1E3;
    public int OML_ILTIS_$festhalten_vLN;
    public int OML_LN_$LN_W1_pA2;
    public int OML_LN_$geprueft1E4;
    public int OML_ILTIS_$freigegeben_vLN;
    public int OML_ILTIS_$festhalten_vZB;
    public int OML_ILTIS_$freigeben_vLN;
    public int OML_LN_$LN_W5_pA3;
    public int OML_LN_$LN_W1_pA4;
    public int OML_LN_$geprueft2A4;
    public int OML_LN_$LN_W2_pA2;
    public int OML_LN_$LN_W3_pA3;
    public int OML_LN_$LN_W5_mA4;
    public int OML_LN_$geprueft2A1;
    public int OML_LN_$LN_W2_mA4;
    public int OML_LN_$LN_W3_pA4;
    public int OML_Fstr_fe_$F_Fahrt1;
    public int OML_Fstr_fe_$signal_steller;
    public int OML_Fstr_fe_$prison_signal_steller;
    public int OML_Fstr_gf_$verschlossen;
    public int OML_Fstr_gf_$P4;
    public int OML_Fstr_gf_$geprueft2;
    public int OML_Fstr_gf_$geprueft1;
    public int OML_Fstr_gf_$Zug_eingefahren;
    public int OML_Fstr_gf_$prison_signal_steller;
    public int OML_Fstr_gf_$gemerkt_90EG;
    public int OML_Fstr_fe_$gemerkt_90F;
    public int OML_Fstr_gf_$G_Fahrt3;
    public int OML_Fstr_gf_$aufgeloest;
    public int OML_Fstr_gf_$signal_steller;
    public int OML_Fstr_gf_$store_1_belegt;
    public int OML_Fstr_fe_$geprueft3;
    public int OML_Fstr_fg_$F_Fahrt3;
    public int OML_Fstr_fg_$geprueft0;
    public int OML_Fstr_fg_$geprueft1;
    public int OML_Fstr_fg_$geprueft3;
    public int OML_Fstr_fg_$Zug_eingefahren;
    public int OML_Fstr_gf_$geprueft3;
    public int OML_Fstr_gf_$G_Halt;
    public int OML_Fstr_fg_$verschlossen;
    public int OML_Fstr_fg_$F_Halt;
    public int OML_Fstr_fg_$geprueft2;
    public int OML_Fstr_fg_$gemerkt_90F;
    public int OML_Fstr_fg_$aufgeloest;
    public int OML_Fstr_fg_$prison_signal_steller;
    public int OML_Fstr_fg_$store_egf_1_belegt;
    public int OML_Fstr_fg_$signal_steller;
    public int OML_Iso_gf_$frei;
    public int OML_Iso_gf_$belegt;
    public int OML_Iso_cd_$belegt;
    public int OML_BL_ZB_OM_$vorgebl_n;
    public int OML_BL_ZB_OM_$3;
    public int OML_Lampen_WS1_$1_WS1_Ueberw;
    public int OML_BL_OM_LN_$vorgebl_v;
    public int OML_Iso_egf_$frei;
    public int OML_BL_OM_LN_$belegt_v;
    public int OML_BL_OM_LN_$2;
    public int OML_BL_OM_LN_$1;
    public int OML_BL_OM_LN_$Grundstlg_n;
    public int OML_Iso_cd_$belegen;
    public int OML_BL_ZB_OM_$belegt_v;
    public int OML_BL_OM_LN_$RMM_nLN;
    public int OML_BL_ZB_OM_$Grundstlg_n;
    public int OML_Iso_egf_$belegen;
    public int OML_Iso_cd_$frei;
    public int OML_BL_ZB_OM_$2;
    public int OML_BL_OM_LN_$vorgebl_n;
    public int OML_Iso_egf_$belegt;
    public int OML_BL_OM_LN_$belegt_n;
    public int OML_BL_OM_LN_$Grundstlg_v;
    public int OML_BL_OM_LN_$3;
    public int OML_BL_ZB_OM_$vorgebl_v;
    public int OML_BL_ZB_OM_$belegt_n;
    public int OML_BL_ZB_OM_$1;
    public int OML_BL_ZB_OM_$Grundstlg_v;
    public int OML_BL_ZB_OM_$RMM_nZB;
    public int OML_Iso_1_$belegen;
    public int OML_Iso_1_$frei;
    public int OML_Iso_ef_$belegt;
    public int OML_Iso_ef_$belegen;
    public int OML_Iso_1_$belegt;
    public int OML_Iso_ef_$frei;
    public int OML_Iso_gf_$belegen;

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
    public int OML_Kontakte_$6_Anf_Durchf_nEMM;
    public int OML_Kontakte_$6_Wecker_absch;
    public int OML_Kontakte_$6_Wbel_ein;
    public int OML_Kontakte_$6_Zeitsch_Umg;
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
        //OML_Kontakte_$6_FBF_nZB = ?
        //OML_ext_Vb_$F_VS_Lampe_Warn_def = ?
        //OML_ext_Vb_$G_Lampe_gruenFB3_def = ?
        //OML_ext_Vb_$E_Lampe_gruenFB1_def = ?
        //OML_ext_Vb_$G_VS_Lampe_Warn_def = ?
        //OML_ext_Vb_$Ueberw_W1_plus = ?
        //OML_ext_Vb_$Ueberw_W1_minus = ?
        //OML_ext_Vb_$G_VS_Lampe_Fahrt_def = ?
        //OML_ext_Vb_$F_Lampe_gruenFB3_def = ?
        //OML_ext_Vb_$F_VS_Lampe_Fahrt_def = ?
        //Test_OM_Weiche_1_init_minus = ?
        //Test_OM_start_test = ?
        //Test_OM_Weiche_1_init_plus = ?
        //Test_OM_Fahrt_ef_init = ?
        //OML_Kontakte_$6_ISU_Sign = ?
        //OML_Kontakte_$6_FBF_nLN = ?
        //OML_Kontakte_$6_NT_W1 = ?
        //OML_Kontakte_$6_NAL = ?
        //OML_Kontakte_$6_BLU_EG = ?
        //Test_OM_Fahrt_fg_init = ?
        //Test_OM_Fahrt_fe_init = ?
        //Test_OM_Fahrt_gf_init = ?
        //OML_ILTIS_$EMM_3_833 = ?
        //OML_ILTIS_$EMM_833_4 = ?
        //OML_ILTIS_$EMM_833_5 = ?
        //OML_ILTIS_$EMM_2_833 = ?
        //OML_ILTIS_$ZB_1_138 = ?
        //OML_ILTIS_$EMM_5_833 = ?
        //OML_ILTIS_$EMM_833_3 = ?
        //OML_ILTIS_$EMM_833_1 = ?
        //OML_ILTIS_$EMM_4_833 = ?
        //OML_ILTIS_$ZB_138_1 = ?
        //OML_ILTIS_$LN_2_834 = ?
        //OML_ILTIS_$LN_6_834 = ?
        //OML_ILTIS_$LN_4_834 = ?
        //OML_ILTIS_$LN_3_834 = ?
        //OML_ILTIS_$LN_834_4 = ?
        //OML_ILTIS_$LN_834_3 = ?
        //OML_ILTIS_$LN_834_5 = ?
        //OML_ILTIS_$LN_834_2 = ?
        //OML_ILTIS_$LN_834_6 = ?
        //OML_ILTIS_$freigeben_vZB = ?
        //OML_ILTIS_$festhalten_vLN = ?
        //OML_ILTIS_$festhalten_vZB = ?
        //OML_ILTIS_$freigeben_vLN = ?
        //OML_Iso_gf_$belegen = ?
    }
    public void writeActors() {
        //myData.Test_OM_end_test = Test_OM_end_test;
        Test_OM_end_test = 0;
    }
    public void init() {
        OML_Stw_FSS_SM_$FSS_30EG_reached_store = 0;
        OML_Stw_FSS_SM_$FSS30F_reached_store = 0;
        OML_Stw_FSS_SM_$NAL_pressed_store = 0;
        OML_Stw_FSS_SM_$FSS_Sperrm_ein = 0;
        OML_Stw_FSS_SM_$FSS_Sperrm_aus = 1;
        OML_Stw_FSS_KSM_$90EG_store = 0;
        OML_LN_$LN_W1_pE6 = 0;
        OML_LN_$LN_W3_pE3 = 0;
        OML_LN_$LN_W1_pA6 = 0;
        OML_LN_$LN_W3_mE6 = 0;
        OML_LN_$LN_W2_mE6 = 0;
        OML_LN_$LN_W5_mE4 = 0;
        OML_LN_$geprueft1E6 = 0;
        OML_LN_$LN_W4_pE5 = 0;
        OML_LN_$LN_W3_pE4 = 0;
        OML_LN_$C26_FB2 = 0;
        OML_LN_$C1_Halt = 1;
        OML_LN_$C26_FB1 = 0;
        OML_LN_$LN_W6_mE6 = 0;
        OML_LN_$E_FB2 = 0;
        OML_LN_$E_FB1 = 0;
        OML_LN_$geprueft2A6 = 0;
        OML_LN_$e_Halt = 1;
        OML_LN_$LN_W1_mE1 = 0;
        OML_LN_$LN_W1_pE2 = 0;
        OML_LN_$LN_W1_pE3 = 0;
        OML_LN_$LN_W2_pE2 = 0;
        OML_LN_$LN_W5_pE3 = 0;
        OML_LN_$LN_W2_mA6 = 0;
        OML_LN_$LN_W1_pE4 = 0;
        OML_LN_$LN_W6_mE5 = 0;
        OML_LN_$LN_W4_pE6 = 0;
        OML_LN_$geprueft1A6 = 0;
        OML_LN_$LN_W2_mE3 = 0;
        OML_LN_$LN_W2_mE5 = 0;
        OML_LN_$LN_W2_mE4 = 0;
        OML_LN_$LN_W3_mE5 = 0;
        OML_LN_$LN_W1_pE5 = 0;
        OML_LN_$LN_W4_pA6 = 0;
        OML_LN_$geprueft2A5 = 0;
        OML_LN_$LN_W3_mA6 = 0;
        OML_LN_$LN_W6_mA6 = 0;
        OML_LN_$C1_FB1 = 0;
        OML_LN_$LN_W3_mA5 = 0;
        OML_LN_$LN_W2_mA5 = 0;
        OML_LN_$LN_W4_pA5 = 0;
        OML_LN_$LN_W6_mA5 = 0;
        OML_Kontakte_$6_FBF_nZB = 0;
        OML_ext_Vb_$F_VS_Lampe_Warn_def = 0;
        OML_ext_Vb_$G_Lampe_gruenFB3_def = 0;
        OML_ext_Vb_$E_Lampe_gruenFB1_def = 0;
        OML_ext_Vb_$G_VS_Lampe_Warn_def = 0;
        OML_ext_Vb_$Ueberw_W1_plus = 1;
        OML_ext_Vb_$Ueberw_W1_minus = 1;
        OML_ext_Vb_$G_VS_Lampe_Fahrt_def = 0;
        OML_ext_Vb_$F_Lampe_gruenFB3_def = 0;
        OML_ext_Vb_$F_VS_Lampe_Fahrt_def = 0;
        OML_Kontakte_$6_FBA_nZB = 0;
        OML_LN_$C26_Halt = 1;
        OML_LN_Fstr_aufloesen = 0;
        OML_Lampen_Streckenblock_$1_FBV_vZB = 0;
        OML_Lampen_Streckenblock_$1_BL_nZB_weiss = 0;
        OML_Lampen_Stoerung_$1_F_VS_Stoer = 0;
        OML_Lampen_Streckenblock_$1_BL_nLN_rot = 0;
        OML_Lampen_Isolierung_$Iso_cd_ein = 0;
        OML_Lampen_Signal_E_$1_E_gruenFB1 = 0;
        OML_Lampen_Signal_F_$1_F_rot = 0;
        OML_Lampen_Signal_F_$1_F_gruenFB3 = 0;
        OML_Lampen_Signal_G_$1_G_gruenFB1 = 0;
        OML_Lampen_Streckenblock_$1_FBV_vLN = 0;
        OML_Lampen_Streckenblock_$1_BL_vZB_weiss = 0;
        OML_Lampen_Signal_G_$1_G_rot = 0;
        OML_Lampen_Streckenblock_$1_BL_nZB_rot = 0;
        OML_Lampen_Isolierung_$Iso_ef_ein = 0;
        OML_Lampen_Streckenblock_$1_BL_vZB_rot = 0;
        OML_Lampen_Fahrstrasse_$1_Fstr_gf = 0;
        OML_Lampen_Isolierung_$Iso_1_ein = 0;
        OML_ZB_$geprueft1A2 = 0;
        OML_ZB_$cd_belegt = 0;
        OML_Lampen_Streckenblock_$1_BL_nLN_weiss = 0;
        OML_Lampen_Fahrstrasse_$1_Fstr_ef = 0;
        OML_Lampen_Signal_F_$1_F_gruenFB1 = 0;
        OML_Lampen_Isolierung_$Iso_egf_ein = 0;
        OML_Lampen_Signal_G_$1_G_gruenFB3 = 0;
        OML_ZB_$ZB_Grundstlg = 1;
        OML_Lampen_Signal_E_$1_E_rot = 0;
        OML_ZB_$C_Halt = 1;
        OML_Lampen_Streckenblock_$1_BL_vLN_weiss = 0;
        OML_Lampen_Streckenblock_$1_BL_vLN_rot = 0;
        OML_Lampen_Stoerung_$1_G_VS_Stoer = 0;
        OML_Lampen_WS1_$1_WS1_Freig = 0;
        OML_ZB_$ZB_W2_pE2 = 0;
        OML_ZB_$D_Halt = 1;
        OML_ZB_$geprueft1A1 = 0;
        OML_ZB_$geprueft1E2 = 0;
        OML_ZB_$ZB_W2_mE1 = 0;
        OML_ZB_$geprueft2A2 = 0;
        OML_ZB_$geprueft1E1 = 0;
        OML_ZB_$ZB_W2_pA2 = 0;
        OML_ZB_$ZB_W2_mA1 = 0;
        Test_OM_Weiche_1_init_minus = 1;
        Test_OM_Weiche_1_PW4 = 0;
        Test_OM_Weiche_1_end_test_w1plus = 0;
        Test_OM_Weiche_1_PW12 = 0;
        Test_OM_Weiche_1_PW15 = 0;
        Test_OM_Weiche_1_PW14 = 0;
        Test_OM_Fahrt_ef_Pef1 = 0;
        Test_OM_start_test = 0;
        Test_OM_Weiche_1_PW2 = 0;
        Test_OM_Weiche_1_PW3 = 0;
        Test_OM_Weiche_1_PW6 = 0;
        Test_OM_Fahrt_ef_Pef2 = 0;
        Test_OM_Fahrt_ef_Pef3 = 0;
        Test_OM_Fahrt_fe = 0;
        Test_OM_P11 = 0;
        Test_OM_Weiche_1_init_plus = 1;
        Test_OM_Fahrt_ef = 0;
        Test_OM_Weiche_1_start = 0;
        Test_OM_Weiche_1_end_test_w1minus = 0;
        Test_OM_Weiche_1_PW5 = 0;
        Test_OM_Weiche_1_PW11 = 0;
        Test_OM_W_1_minus = 0;
        Test_OM_end_test = 0;
        Test_OM_Weiche_1_PW13 = 0;
        Test_OM_Fahrt_ef_Pef4 = 0;
        Test_OM_Fahrt_fg = 0;
        Test_OM_Fahrt_ef_Pef5 = 0;
        Test_OM_Fahrt_ef_init = 1;
        Test_OM_P12 = 0;
        Test_OM_W_1_plus = 0;
        Test_OM_Weiche_1_PW1 = 0;
        Test_OM_Fahrt_gf = 0;
        OML_Kontakte_$8_FSS_90EG = 0;
        OML_Kontakte_$6_RM_nLN = 0;
        OML_Kontakte_$6_Gleist_ZB = 0;
        OML_Kontakte_$6_ISU_Sign = 0;
        OML_Kontakte_$8_FSS_30F = 0;
        OML_Kontakte_$8_FSS_45F = 0;
        OML_Wecker_Signal_$P22 = 0;
        OML_Kontakte_$8_FSS_10F = 0;
        OML_Kontakte_$6_FBA_nLN = 0;
        OML_Kontakte_$8_FSS_90F = 0;
        OML_Kontakte_$6_FBF_nLN = 0;
        OML_Kontakte_$6_NT_W1 = 0;
        OML_Kontakte_$7_WS1_minus = 0;
        OML_Kontakte_$8_FSS_45EG = 0;
        OML_Wecker_Weichen_$2_Weiche = 0;
        OML_Wecker_Signal_$P49 = 0;
        OML_Kontakte_$8_FSS_10EG = 0;
        OML_Kontakte_$6_RM_nZB = 0;
        OML_Kontakte_$8_FSS_0EGF = 0;
        OML_Kontakte_$8_FSS_30EG = 0;
        OML_Kontakte_$6_NAL = 0;
        OML_Kontakte_$6_BLU_EG = 0;
        OML_Kontakte_$6_Gleist_EMM = 0;
        OML_Kontakte_$7_WS1_plus = 0;
        OML_Kontakte_$7_WS1_1 = 0;
        OML_logic_Kontakte_WS1_$ws1_minus = 0;
        OML_Wecker_Signal_$2_Signal = 0;
        Test_OM_Fahrt_ef_Pef7 = 0;
        OML_Wecker_Signal_$P13 = 0;
        OML_Wecker_Signal_$P21 = 0;
        OML_Wecker_Block_$2_Block = 0;
        OML_logic_Kontakte_WS1_$logic_ws1_plus = 0;
        OML_logic_Kontakte_WS1_$ws1_plus = 0;
        OML_Wecker_Block_$P135 = 0;
        OML_Wecker_Signal_$P12 = 0;
        OML_Wecker_Block_$P39 = 0;
        OML_Wecker_Block_$P40 = 0;
        OML_Wecker_Block_$P27 = 0;
        OML_Wecker_Signal_$P18 = 0;
        OML_logic_Kontakte_WS1_$logic_ws1_minus = 0;
        OML_Wecker_Block_$P48 = 0;
        OML_Wecker_Signal_$P117 = 0;
        Test_OM_Fahrt_fg_Pfg2 = 0;
        Test_OM_Fahrt_fg_Pfg23 = 0;
        Test_OM_Fahrt_gf_Pgf24 = 0;
        Test_OM_Fahrt_fg_Pfg7 = 0;
        Test_OM_Fahrt_gf_Pgf17 = 0;
        Test_OM_Fahrt_fg_Pfg1 = 0;
        Test_OM_Fahrt_gf_Pgf19 = 0;
        Test_OM_Fahrt_fg_Pfg6 = 0;
        Test_OM_Fahrt_fg_Pfg24 = 0;
        Test_OM_Fahrt_fg_Pfg10 = 0;
        Test_OM_Fahrt_gf_Pgf14 = 0;
        Test_OM_Fahrt_fg_Pfg13 = 0;
        Test_OM_Fahrt_gf_Pgf10 = 0;
        Test_OM_Fahrt_fg_Pfg18 = 0;
        Test_OM_Fahrt_fg_Pfg15 = 0;
        Test_OM_Fahrt_gf_Pgf21 = 0;
        Test_OM_Fahrt_gf_end_test_gf = 0;
        Test_OM_Fahrt_fg_Pfg16 = 0;
        Test_OM_Fahrt_fg_init = 1;
        Test_OM_Fahrt_gf_Pgf4 = 0;
        Test_OM_Fahrt_fg_Pfg17 = 0;
        Test_OM_Fahrt_fg_Pfg19 = 0;
        Test_OM_Fahrt_gf_Pgf23 = 0;
        Test_OM_Fahrt_fg_Pfg5 = 0;
        Test_OM_Fahrt_gf_Pgf6 = 0;
        Test_OM_Fahrt_gf_Pgf8 = 0;
        Test_OM_Fahrt_fg_Pfg8 = 0;
        Test_OM_Fahrt_fg_Pfg21 = 0;
        Test_OM_Fahrt_gf_Pgf5 = 0;
        Test_OM_Fahrt_gf_Pgf15 = 0;
        Test_OM_Fahrt_fg_Pfg3 = 0;
        Test_OM_Fahrt_fg_Pfg20 = 0;
        Test_OM_Fahrt_fe_Pfe2 = 0;
        Test_OM_Fahrt_ef_Pef10 = 0;
        Test_OM_Fahrt_fe_Pfe9 = 0;
        Test_OM_Fahrt_fe_Pfe11 = 0;
        Test_OM_Fahrt_fe_Pfe3 = 0;
        Test_OM_Fahrt_fe_Pfe14 = 0;
        Test_OM_Fahrt_fe_Pfe17 = 0;
        Test_OM_Fahrt_fe_Pfe19 = 0;
        Test_OM_Fahrt_fe_Pfe16 = 0;
        Test_OM_Fahrt_fe_Pfe4 = 0;
        Test_OM_Fahrt_fe_Pfe5 = 0;
        Test_OM_Fahrt_fe_Pfe18 = 0;
        Test_OM_Fahrt_fe_init = 1;
        Test_OM_Fahrt_fe_Pfe20 = 0;
        Test_OM_Fahrt_ef_Pef15 = 0;
        Test_OM_Fahrt_ef_Pef16 = 0;
        Test_OM_Fahrt_ef_Pef18 = 0;
        Test_OM_Fahrt_ef_Pef9 = 0;
        Test_OM_Fahrt_ef_Pef6 = 0;
        Test_OM_Fahrt_fe_Pfe12 = 0;
        Test_OM_Fahrt_fe_Pfe1 = 0;
        Test_OM_Fahrt_fe_Pfe21 = 0;
        Test_OM_Fahrt_ef_Pef19 = 0;
        Test_OM_Fahrt_ef_Pef12 = 0;
        Test_OM_Fahrt_ef_end_test_ef = 0;
        Test_OM_Fahrt_fe_Pfe15 = 0;
        Test_OM_Fahrt_ef_Pef14 = 0;
        Test_OM_Fahrt_ef_Pef17 = 0;
        Test_OM_Fahrt_ef_Pef8 = 0;
        Test_OM_Fahrt_ef_Pef13 = 0;
        Test_OM_Fahrt_ef_Pef11 = 0;
        Test_OM_Fahrt_fe_Pfe7 = 0;
        Test_OM_Fahrt_gf_Pgf12 = 0;
        Test_OM_Fahrt_fe_Pfe22 = 0;
        Test_OM_Fahrt_fe_Pfe6 = 0;
        Test_OM_Fahrt_gf_init = 1;
        Test_OM_Fahrt_gf_Pgf16 = 0;
        Test_OM_Fahrt_gf_Pgf7 = 0;
        Test_OM_Fahrt_gf_Pgf13 = 0;
        Test_OM_Fahrt_gf_Pgf1 = 0;
        Test_OM_Fahrt_gf_Pgf20 = 0;
        Test_OM_Fahrt_fe_Pfe8 = 0;
        Test_OM_Fahrt_fe_Pfe23 = 0;
        Test_OM_Fahrt_fe_Pfe13 = 0;
        Test_OM_Fahrt_fe_end_test_fe = 0;
        Test_OM_Fahrt_gf_Pgf22 = 0;
        Test_OM_Fahrt_gf_Pgf18 = 0;
        Test_OM_Fahrt_gf_Pgf3 = 0;
        Test_OM_Fahrt_fe_Pfe10 = 0;
        Test_OM_Fahrt_gf_Pgf9 = 0;
        Test_OM_Fahrt_gf_Pgf2 = 0;
        Test_OM_Fahrt_gf_Pgf11 = 0;
        OML_ZB_$D_FB1 = 0;
        OML_EMM_$EMM_W8_mA5 = 0;
        OML_EMM_$geprueft1A4 = 0;
        OML_EMM_$geprueft1E4 = 0;
        OML_ZB_$ZB_W1_mE1 = 0;
        OML_ZB_$C_FB2 = 0;
        OML_EMM_$geprueft1A1 = 0;
        OML_EMM_$EMM_W10_pA1 = 0;
        OML_EMM_$EMM_W10_mA3 = 0;
        OML_EMM_$EMM_W10_pA2 = 0;
        OML_EMM_$geprueft2A3 = 0;
        OML_ZB_$ZB_W1_pA2 = 0;
        OML_EMM_$EMM_W9_mA4 = 0;
        OML_EMM_$EMM_W8_pA4 = 0;
        OML_ZB_$Fstr_aufloesen = 0;
        OML_EMM_$geprueft2A1 = 0;
        OML_EMM_$EMM_W9_pA3 = 0;
        OML_ZB_$C_FB1 = 0;
        OML_EMM_$EMM_W7_pA2 = 0;
        OML_EMM_$EMM_W7_mA1 = 0;
        OML_EMM_$geprueft2A5 = 0;
        OML_ZB_$ZB_W1_pE2 = 0;
        OML_EMM_$geprueft2A2 = 0;
        OML_EMM_$geprueft1A2 = 0;
        OML_ZB_$geprueft2A1 = 0;
        OML_EMM_$geprueft1A3 = 0;
        OML_ZB_$ZB_W1_mA1 = 0;
        OML_ZB_$D_FB2 = 0;
        OML_EMM_$EMM_Grundstlg = 1;
        OML_EMM_$geprueft2A4 = 0;
        OML_EMM_$EMM_W9_mA5 = 0;
        OML_EMM_$geprueft1A5 = 0;
        OML_EMM_$EMM_W9_pE3 = 0;
        OML_EMM_$EMM_W10_pE2 = 0;
        OML_EMM_$EMM_W10_mE3 = 0;
        OML_EMM_$EMM_W7_mE1 = 0;
        OML_EMM_$EMM_W10_pE1 = 0;
        OML_EMM_$EMM_W7_pE2 = 0;
        OML_EMM_$geprueft1E2 = 0;
        OML_EMM_$geprueft1E1 = 0;
        OML_EMM_$geprueft1E3 = 0;
        OML_EMM_$C_aufloesen = 0;
        OML_ILTIS_$EMM_3_833 = 0;
        OML_ILTIS_$EMM_833_4 = 0;
        OML_ILTIS_$EMM_833_5 = 0;
        OML_ILTIS_$EMM_2_833 = 0;
        OML_ILTIS_$ZB_1_138 = 0;
        OML_ILTIS_$ZB_138_2 = 0;
        OML_EMM_$EMM_W10_mE5 = 0;
        OML_EMM_$C_FB1 = 0;
        OML_ILTIS_$LN_1_834 = 0;
        OML_ILTIS_$EMM_1_833 = 0;
        OML_EMM_$EMM_W8_mE5 = 0;
        OML_EMM_$EMM_W10_mA5 = 0;
        OML_EMM_$EMM_W10_mA4 = 0;
        OML_ILTIS_$EMM_5_833 = 0;
        OML_ILTIS_$EMM_833_3 = 0;
        OML_ILTIS_$EMM_833_1 = 0;
        OML_ILTIS_$EMM_833_2 = 0;
        OML_ILTIS_$ZB_2_138 = 0;
        OML_EMM_$D_FB2 = 0;
        OML_EMM_$C_FB2 = 0;
        OML_EMM_$EMM_W9_mE5 = 0;
        OML_EMM_$EMM_W9_mE4 = 0;
        OML_EMM_$C_Halt = 1;
        OML_ILTIS_$EMM_4_833 = 0;
        OML_ILTIS_$ZB_138_1 = 0;
        OML_ILTIS_$LN_834_1 = 0;
        OML_EMM_$EMM_W10_mE4 = 0;
        OML_EMM_$D_FB1 = 0;
        OML_EMM_$geprueft1E5 = 0;
        OML_EMM_$D_Halt = 1;
        OML_EMM_$EMM_W8_pE4 = 0;
        OML_ILTIS_$LN_2_834 = 0;
        OML_ILTIS_$LN_6_834 = 0;
        OML_ILTIS_$LN_4_834 = 0;
        OML_ILTIS_$LN_3_834 = 0;
        OML_ILTIS_$LN_834_4 = 0;
        OML_ILTIS_$LN_834_3 = 0;
        OML_ILTIS_$LN_834_5 = 0;
        OML_ILTIS_$LN_834_2 = 0;
        OML_ILTIS_$LN_834_6 = 0;
        Test_OM_Fahrt_fg_Pfg9 = 0;
        Test_OM_Fahrt_fg_Pfg4 = 0;
        Test_OM_Fahrt_fg_Pfg14 = 0;
        Test_OM_Fahrt_fg_Pfg22 = 0;
        Test_OM_Fahrt_fg_end_test_fg = 0;
        Test_OM_Fahrt_fg_Pfg12 = 0;
        Test_OM_Fahrt_fg_Pfg11 = 0;
        OML_Stw_WS1_$gestoert_m = 0;
        OML_Stw_FSS_KSM_$FSS_Kuppelm_aus = 1;
        OML_Stw_W1_$Umstellen_plus = 0;
        OML_Stw_WS1_SM_$Sperrm_aus = 1;
        OML_Stw_WS1_SM_$Sperrm_ein = 0;
        OML_Stw_WS1_$endlage_minus = 0;
        OML_Stw_W1_$Endlage_minus = 0;
        OML_Fstr_ef_$geprueft2 = 0;
        OML_Fstr_ef_$geprueft3 = 0;
        OML_Stw_W1_$Endlage_plus = 1;
        OML_Stw_W1_$Umstellen_minus = 0;
        OML_Fstr_ef_$P6 = 0;
        OML_Fstr_ef_$E_Fahrt1 = 0;
        OML_Stw_FSS_KSM_$90F_store = 0;
        OML_Stw_WS1_$keine_Endlage_minus = 0;
        OML_Stw_WS1_$keine_Endlage_plus = 0;
        OML_Stw_FSS_KSM_$FSS_Kuppelm_ein = 0;
        OML_Stw_WS1_$endlage_plus = 1;
        OML_Stw_WS1_$gestoert_p = 0;
        OML_Fstr_ef_$geprueft1 = 0;
        OML_Fstr_ef_$Zug_eingefahren = 0;
        OML_Fstr_ef_$verschlossen = 0;
        OML_Fstr_ef_$aufgeloest = 1;
        OML_Fstr_fe_$store_1_egf_belegt = 0;
        OML_Fstr_fe_$P2 = 0;
        OML_Fstr_fe_$verschlossen = 0;
        OML_Fstr_fe_$F_Halt = 1;
        OML_Fstr_fe_$Zug_eingefahren = 0;
        OML_Fstr_fe_$aufgeloest = 1;
        OML_Fstr_ef_$prison_signal_steller = 0;
        OML_Fstr_ef_$E_Halt = 1;
        OML_Fstr_ef_$signal_steller = 0;
        OML_Fstr_ef_$Pstore_1_ef_belegt = 0;
        OML_Fstr_fe_$geprueft = 0;
        OML_Fstr_ef_$gemerkt_90EB = 0;
        OML_LN_$geprueft1A2 = 0;
        OML_LN_$geprueft2A2 = 0;
        OML_ILTIS_$freigeben_vZB = 0;
        OML_ILTIS_$anfordern_vLN = 0;
        OML_ILTIS_$festgehalten_vLN = 0;
        OML_ILTIS_$RM_LN_OM = 0;
        OML_ILTIS_$RM_ZB_OM = 0;
        OML_LN_$LN_Grundstlg = 1;
        OML_LN_$geprueft2A3 = 0;
        OML_ILTIS_$freigegeben_vZB = 1;
        OML_LN_$ce_belegt = 0;
        OML_LN_$LN_W1_mA1 = 0;
        OML_LN_$geprueft1E5 = 0;
        OML_LN_$geprueft1E2 = 0;
        OML_LN_$LN_W2_mA3 = 0;
        OML_LN_$geprueft1A1 = 0;
        OML_LN_$geprueft1A4 = 0;
        OML_LN_$geprueft1A3 = 0;
        OML_ILTIS_$anfordern_vZB = 0;
        OML_LN_$geprueft1A5 = 0;
        OML_LN_$LN_W1_pA3 = 0;
        OML_ILTIS_$festgehalten_v_ZB = 0;
        OML_LN_$geprueft1E1 = 0;
        OML_LN_$LN_W1_pA5 = 0;
        OML_LN_$geprueft1E3 = 0;
        OML_ILTIS_$festhalten_vLN = 0;
        OML_LN_$LN_W1_pA2 = 0;
        OML_LN_$geprueft1E4 = 0;
        OML_ILTIS_$freigegeben_vLN = 1;
        OML_ILTIS_$festhalten_vZB = 0;
        OML_ILTIS_$freigeben_vLN = 0;
        OML_LN_$LN_W5_pA3 = 0;
        OML_LN_$LN_W1_pA4 = 0;
        OML_LN_$geprueft2A4 = 0;
        OML_LN_$LN_W2_pA2 = 0;
        OML_LN_$LN_W3_pA3 = 0;
        OML_LN_$LN_W5_mA4 = 0;
        OML_LN_$geprueft2A1 = 0;
        OML_LN_$LN_W2_mA4 = 0;
        OML_LN_$LN_W3_pA4 = 0;
        OML_Fstr_fe_$F_Fahrt1 = 0;
        OML_Fstr_fe_$signal_steller = 0;
        OML_Fstr_fe_$prison_signal_steller = 0;
        OML_Fstr_gf_$verschlossen = 0;
        OML_Fstr_gf_$P4 = 0;
        OML_Fstr_gf_$geprueft2 = 0;
        OML_Fstr_gf_$geprueft1 = 0;
        OML_Fstr_gf_$Zug_eingefahren = 0;
        OML_Fstr_gf_$prison_signal_steller = 0;
        OML_Fstr_gf_$gemerkt_90EG = 0;
        OML_Fstr_fe_$gemerkt_90F = 0;
        OML_Fstr_gf_$G_Fahrt3 = 0;
        OML_Fstr_gf_$aufgeloest = 1;
        OML_Fstr_gf_$signal_steller = 0;
        OML_Fstr_gf_$store_1_belegt = 0;
        OML_Fstr_fe_$geprueft3 = 0;
        OML_Fstr_fg_$F_Fahrt3 = 0;
        OML_Fstr_fg_$geprueft0 = 0;
        OML_Fstr_fg_$geprueft1 = 0;
        OML_Fstr_fg_$geprueft3 = 0;
        OML_Fstr_fg_$Zug_eingefahren = 0;
        OML_Fstr_gf_$geprueft3 = 0;
        OML_Fstr_gf_$G_Halt = 1;
        OML_Fstr_fg_$verschlossen = 0;
        OML_Fstr_fg_$F_Halt = 1;
        OML_Fstr_fg_$geprueft2 = 0;
        OML_Fstr_fg_$gemerkt_90F = 0;
        OML_Fstr_fg_$aufgeloest = 1;
        OML_Fstr_fg_$prison_signal_steller = 0;
        OML_Fstr_fg_$store_egf_1_belegt = 0;
        OML_Fstr_fg_$signal_steller = 0;
        OML_Iso_gf_$frei = 1;
        OML_Iso_gf_$belegt = 0;
        OML_Iso_cd_$belegt = 0;
        OML_BL_ZB_OM_$vorgebl_n = 0;
        OML_BL_ZB_OM_$3 = 0;
        OML_Lampen_WS1_$1_WS1_Ueberw = 0;
        OML_BL_OM_LN_$vorgebl_v = 0;
        OML_Iso_egf_$frei = 1;
        OML_BL_OM_LN_$belegt_v = 0;
        OML_BL_OM_LN_$2 = 0;
        OML_BL_OM_LN_$1 = 0;
        OML_BL_OM_LN_$Grundstlg_n = 1;
        OML_Iso_cd_$belegen = 0;
        OML_BL_ZB_OM_$belegt_v = 0;
        OML_BL_OM_LN_$RMM_nLN = 0;
        OML_BL_ZB_OM_$Grundstlg_n = 1;
        OML_Iso_egf_$belegen = 0;
        OML_Iso_cd_$frei = 1;
        OML_BL_ZB_OM_$2 = 0;
        OML_BL_OM_LN_$vorgebl_n = 0;
        OML_Iso_egf_$belegt = 0;
        OML_BL_OM_LN_$belegt_n = 0;
        OML_BL_OM_LN_$Grundstlg_v = 0;
        OML_BL_OM_LN_$3 = 0;
        OML_BL_ZB_OM_$vorgebl_v = 0;
        OML_BL_ZB_OM_$belegt_n = 0;
        OML_BL_ZB_OM_$1 = 0;
        OML_BL_ZB_OM_$Grundstlg_v = 0;
        OML_BL_ZB_OM_$RMM_nZB = 0;
        OML_Iso_1_$belegen = 0;
        OML_Iso_1_$frei = 1;
        OML_Iso_ef_$belegt = 0;
        OML_Iso_ef_$belegen = 0;
        OML_Iso_1_$belegt = 0;
        OML_Iso_ef_$frei = 1;
        OML_Iso_gf_$belegen = 0;
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
        OML_Kontakte_$6_Anf_Durchf_nEMM = 0;
        OML_Kontakte_$6_Wecker_absch = 0;
        OML_Kontakte_$6_Wbel_ein = 0;
        OML_Kontakte_$6_Zeitsch_Umg = 0;
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
                (OML_Fstr_gf_$Zug_eingefahren < 1) &&
                (OML_Kontakte_$6_NAL < 1))
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
                (OML_Fstr_ef_$Zug_eingefahren < 1) &&
                (OML_Kontakte_$6_NAL < 1))
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
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Kontakte_$6_NAL < 1))
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
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Kontakte_$6_NAL < 1))
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
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus <= 0) &&
                (OML_Kontakte_$6_NAL < 1))
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
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus <= 0) &&
                (OML_Kontakte_$6_NAL < 1))
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
        if ( (OML_Stw_FSS_KSM_$90F_store <= 0) &&
                (OML_Kontakte_$8_FSS_90F >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_T321"))
            {
                ++OML_Stw_FSS_KSM_$90F_store;
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
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein <= 0) &&
                (OML_Kontakte_$8_FSS_30EG >= 1))
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
        if ( (OML_Stw_FSS_KSM_$90EG_store <= 0) &&
                (OML_Kontakte_$8_FSS_90EG >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_T320"))
            {
                ++OML_Stw_FSS_KSM_$90EG_store;
                fire("OML_Stw_FSS_KSM_T320");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_abfallen_45EG can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$90EG_store >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Kontakte_$8_FSS_45EG >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_abfallen_45EG"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                --OML_Stw_FSS_KSM_$90EG_store;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_KSM_abfallen_45EG");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_abfallen_45F can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$90F_store >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Kontakte_$8_FSS_45F >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_abfallen_45F"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                --OML_Stw_FSS_KSM_$90F_store;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
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
        //check if OML_Stw_FSS_KSM_KSM_10F_ab can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Kontakte_$8_FSS_10F >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_10F_ab"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_KSM_10F_ab");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_NAL_KSM_F can fire
        if ( (OML_Kontakte_$6_NAL >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0))
        {
            if (canFire("OML_Stw_FSS_KSM_NAL_KSM_F"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_NAL_KSM_F");
                return true;
            }
        }
        //check if OML_Stw_FSS_KSM_KSM_10EG_ab can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus <= 0) &&
                (OML_Kontakte_$8_FSS_10EG >= 1))
        {
            if (canFire("OML_Stw_FSS_KSM_KSM_10EG_ab"))
            {
                --OML_Stw_FSS_KSM_$FSS_Kuppelm_ein;
                ++OML_Stw_FSS_KSM_$FSS_Kuppelm_aus;
                fire("OML_Stw_FSS_KSM_KSM_10EG_ab");
                return true;
            }
        }
        //check if OML_Stw_WS1_T9 can fire
        if ( (OML_ext_Vb_$Ueberw_W1_minus >= 1) &&
                (OML_Stw_WS1_$endlage_minus <= 0) &&
                (OML_Stw_WS1_$gestoert_m >= 1))
        {
            if (canFire("OML_Stw_WS1_T9"))
            {
                ++OML_Stw_WS1_$endlage_minus;
                --OML_Stw_WS1_$gestoert_m;
                fire("OML_Stw_WS1_T9");
                return true;
            }
        }
        //check if OML_Stw_WS1_plus_erreichen can fire
        if ( (OML_Kontakte_$7_WS1_plus >= 1) &&
                (OML_Kontakte_$7_WS1_1 < 1) &&
                (OML_Stw_WS1_$keine_Endlage_minus >= 1) &&
                (OML_Stw_WS1_$endlage_plus <= 0))
        {
            if (canFire("OML_Stw_WS1_plus_erreichen"))
            {
                --OML_Stw_WS1_$keine_Endlage_minus;
                ++OML_Stw_WS1_$endlage_plus;
                fire("OML_Stw_WS1_plus_erreichen");
                return true;
            }
        }
        //check if OML_Stw_WS1_T6 can fire
        if ( (OML_Stw_WS1_$endlage_plus >= 1) &&
                (OML_Stw_WS1_$gestoert_p <= 0) &&
                (OML_ext_Vb_$Ueberw_W1_plus < 1))
        {
            if (canFire("OML_Stw_WS1_T6"))
            {
                --OML_Stw_WS1_$endlage_plus;
                ++OML_Stw_WS1_$gestoert_p;
                fire("OML_Stw_WS1_T6");
                return true;
            }
        }
        //check if OML_Stw_WS1_T7 can fire
        if ( (OML_Stw_WS1_$endlage_plus <= 0) &&
                (OML_Stw_WS1_$gestoert_p >= 1) &&
                (OML_ext_Vb_$Ueberw_W1_plus >= 1))
        {
            if (canFire("OML_Stw_WS1_T7"))
            {
                ++OML_Stw_WS1_$endlage_plus;
                --OML_Stw_WS1_$gestoert_p;
                fire("OML_Stw_WS1_T7");
                return true;
            }
        }
        //check if OML_Stw_WS1_T8 can fire
        if ( (OML_Stw_WS1_$endlage_minus >= 1) &&
                (OML_ext_Vb_$Ueberw_W1_minus < 1) &&
                (OML_Stw_WS1_$gestoert_m <= 0))
        {
            if (canFire("OML_Stw_WS1_T8"))
            {
                --OML_Stw_WS1_$endlage_minus;
                ++OML_Stw_WS1_$gestoert_m;
                fire("OML_Stw_WS1_T8");
                return true;
            }
        }
        //check if OML_Stw_WS1_T4 can fire
        if ( (OML_Stw_WS1_$endlage_minus >= 1) &&
                (OML_Kontakte_$7_WS1_1 >= 1) &&
                (OML_Stw_WS1_$keine_Endlage_minus <= 0))
        {
            if (canFire("OML_Stw_WS1_T4"))
            {
                --OML_Stw_WS1_$endlage_minus;
                ++OML_Stw_WS1_$keine_Endlage_minus;
                fire("OML_Stw_WS1_T4");
                return true;
            }
        }
        //check if OML_Stw_WS1_T3 can fire
        if ( (OML_Stw_WS1_$endlage_plus >= 1) &&
                (OML_Stw_WS1_$keine_Endlage_plus <= 0) &&
                (OML_Kontakte_$7_WS1_1 >= 1))
        {
            if (canFire("OML_Stw_WS1_T3"))
            {
                --OML_Stw_WS1_$endlage_plus;
                ++OML_Stw_WS1_$keine_Endlage_plus;
                fire("OML_Stw_WS1_T3");
                return true;
            }
        }
        //check if OML_Stw_WS1_minus_erreichen can fire
        if ( (OML_Stw_WS1_$endlage_minus <= 0) &&
                (OML_Kontakte_$7_WS1_minus >= 1) &&
                (OML_Stw_WS1_$keine_Endlage_plus >= 1) &&
                (OML_Kontakte_$7_WS1_1 < 1))
        {
            if (canFire("OML_Stw_WS1_minus_erreichen"))
            {
                ++OML_Stw_WS1_$endlage_minus;
                --OML_Stw_WS1_$keine_Endlage_plus;
                fire("OML_Stw_WS1_minus_erreichen");
                return true;
            }
        }
        //check if OML_Stw_WS1_zurueckfallen_plus can fire
        if ( (OML_Kontakte_$7_WS1_plus >= 1) &&
                (OML_Stw_WS1_$endlage_plus <= 0) &&
                (OML_Kontakte_$7_WS1_1 < 1) &&
                (OML_Stw_WS1_$keine_Endlage_plus >= 1))
        {
            if (canFire("OML_Stw_WS1_zurueckfallen_plus"))
            {
                ++OML_Stw_WS1_$endlage_plus;
                --OML_Stw_WS1_$keine_Endlage_plus;
                fire("OML_Stw_WS1_zurueckfallen_plus");
                return true;
            }
        }
        //check if OML_Stw_WS1_zurueckfallen_minus can fire
        if ( (OML_Stw_WS1_$keine_Endlage_minus >= 1) &&
                (OML_Stw_WS1_$endlage_minus <= 0) &&
                (OML_Kontakte_$7_WS1_minus >= 1) &&
                (OML_Kontakte_$7_WS1_1 < 1))
        {
            if (canFire("OML_Stw_WS1_zurueckfallen_minus"))
            {
                --OML_Stw_WS1_$keine_Endlage_minus;
                ++OML_Stw_WS1_$endlage_minus;
                fire("OML_Stw_WS1_zurueckfallen_minus");
                return true;
            }
        }
        //check if OML_Stw_WS1_SM_abfallen can fire
        if ( (OML_Stw_WS1_SM_$Sperrm_ein >= 1) &&
                (OML_Stw_WS1_SM_$Sperrm_aus <= 0) &&
                (OML_Kontakte_$7_WS1_1 < 1))
        {
            if (canFire("OML_Stw_WS1_SM_abfallen"))
            {
                --OML_Stw_WS1_SM_$Sperrm_ein;
                ++OML_Stw_WS1_SM_$Sperrm_aus;
                fire("OML_Stw_WS1_SM_abfallen");
                return true;
            }
        }
        //check if OML_Stw_WS1_SM_anziehen2 can fire
        if ( (OML_Stw_WS1_SM_$Sperrm_ein <= 0) &&
                (OML_Stw_WS1_SM_$Sperrm_aus >= 1) &&
                (OML_Kontakte_$7_WS1_1 >= 1) &&
                (OML_Kontakte_$6_NT_W1 >= 1))
        {
            if (canFire("OML_Stw_WS1_SM_anziehen2"))
            {
                ++OML_Stw_WS1_SM_$Sperrm_ein;
                --OML_Stw_WS1_SM_$Sperrm_aus;
                fire("OML_Stw_WS1_SM_anziehen2");
                return true;
            }
        }
        //check if OML_Stw_WS1_SM_anziehen can fire
        if ( (OML_Stw_WS1_SM_$Sperrm_aus >= 1) &&
                (OML_Fstr_fg_$aufgeloest >= 1) &&
                (OML_Fstr_gf_$aufgeloest >= 1) &&
                (OML_Fstr_fe_$aufgeloest >= 1) &&
                (OML_Fstr_ef_$aufgeloest >= 1) &&
                (OML_Iso_1_$frei >= 1) &&
                (OML_Stw_WS1_SM_$Sperrm_ein <= 0) &&
                (OML_Kontakte_$7_WS1_1 >= 1))
        {
            if (canFire("OML_Stw_WS1_SM_anziehen"))
            {
                --OML_Stw_WS1_SM_$Sperrm_aus;
                ++OML_Stw_WS1_SM_$Sperrm_ein;
                fire("OML_Stw_WS1_SM_anziehen");
                return true;
            }
        }
        //check if OML_Stw_W1_T3 can fire
        if ( (OML_Stw_WS1_$endlage_minus >= 1) &&
                (OML_Stw_W1_$Endlage_plus >= 1) &&
                (OML_Stw_W1_$Umstellen_plus <= 0))
        {
            if (canFire("OML_Stw_W1_T3"))
            {
                --OML_Stw_W1_$Endlage_plus;
                ++OML_Stw_W1_$Umstellen_plus;
                fire("OML_Stw_W1_T3");
                return true;
            }
        }
        //check if OML_Stw_W1_T4 can fire
        if ( (OML_Stw_W1_$Endlage_minus <= 0) &&
                (OML_Stw_W1_$Umstellen_plus >= 1))
        {
            if (canFire("OML_Stw_W1_T4"))
            {
                ++OML_Stw_W1_$Endlage_minus;
                --OML_Stw_W1_$Umstellen_plus;
                fire("OML_Stw_W1_T4");
                return true;
            }
        }
        //check if OML_Stw_W1_T5 can fire
        if ( (OML_Stw_W1_$Endlage_minus >= 1) &&
                (OML_Stw_WS1_$endlage_plus >= 1) &&
                (OML_Stw_W1_$Umstellen_minus <= 0))
        {
            if (canFire("OML_Stw_W1_T5"))
            {
                --OML_Stw_W1_$Endlage_minus;
                ++OML_Stw_W1_$Umstellen_minus;
                fire("OML_Stw_W1_T5");
                return true;
            }
        }
        //check if OML_Stw_W1_T6 can fire
        if ( (OML_Stw_W1_$Umstellen_minus >= 1) &&
                (OML_Stw_W1_$Endlage_plus <= 0))
        {
            if (canFire("OML_Stw_W1_T6"))
            {
                --OML_Stw_W1_$Umstellen_minus;
                ++OML_Stw_W1_$Endlage_plus;
                fire("OML_Stw_W1_T6");
                return true;
            }
        }
        //check if OML_Fstr_ef_vorzeitig_aufloesen can fire
        if ( (OML_Fstr_ef_$aufgeloest <= 0) &&
                (OML_Fstr_ef_$geprueft3 >= 1) &&
                (OML_Kontakte_$8_FSS_0EGF >= 1))
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
        if ( (OML_Fstr_ef_$Pstore_1_ef_belegt >= 1) &&
                (OML_Fstr_ef_$Zug_eingefahren <= 0) &&
                (OML_Iso_ef_$frei >= 1))
        {
            if (canFire("OML_Fstr_ef_ef_frei"))
            {
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
                (OML_Fstr_ef_$Pstore_1_ef_belegt >= 1))
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
        if ( (OML_Fstr_ef_$Pstore_1_ef_belegt <= 0) &&
                (OML_Iso_ef_$belegt >= 1) &&
                (OML_Iso_1_$belegt >= 1) &&
                (OML_Fstr_ef_$verschlossen >= 1))
        {
            if (canFire("OML_Fstr_ef_1_belegt"))
            {
                ++OML_Fstr_ef_$Pstore_1_ef_belegt;
                fire("OML_Fstr_ef_1_belegt");
                return true;
            }
        }
        //check if OML_Fstr_ef_pruefen1 can fire
        if ( (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Fstr_ef_$aufgeloest >= 1) &&
                (OML_Stw_WS1_$endlage_plus >= 1) &&
                (OML_Fstr_ef_$P6 <= 0) &&
                (OML_Kontakte_$6_Gleist_EMM >= 1))
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
                (OML_Fstr_ef_$E_Fahrt1 >= 1) &&
                (OML_Kontakte_$8_FSS_45EG >= 1) &&
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
        //check if OML_Fstr_ef_free_store_ef can fire
        if ( (OML_Fstr_ef_$Pstore_1_ef_belegt >= 1) &&
                (OML_Iso_ef_$belegt < 1) &&
                (OML_Iso_1_$belegt < 1))
        {
            if (canFire("OML_Fstr_ef_free_store_ef"))
            {
                --OML_Fstr_ef_$Pstore_1_ef_belegt;
                fire("OML_Fstr_ef_free_store_ef");
                return true;
            }
        }
        //check if OML_Fstr_fe_Signal_haltstellen can fire
        if ( (OML_Fstr_fe_$store_1_egf_belegt >= 1) &&
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
                (OML_Iso_1_$frei >= 1) &&
                (OML_Iso_egf_$frei >= 1) &&
                (OML_Iso_ef_$frei >= 1) &&
                (OML_Iso_cd_$frei >= 1))
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
        if ( (OML_Fstr_fe_$aufgeloest <= 0) &&
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
        if ( (OML_Fstr_fe_$store_1_egf_belegt >= 1) &&
                (OML_Fstr_fe_$Zug_eingefahren <= 0) &&
                (OML_Iso_egf_$frei >= 1))
        {
            if (canFire("OML_Fstr_fe_egf_frei"))
            {
                ++OML_Fstr_fe_$Zug_eingefahren;
                fire("OML_Fstr_fe_egf_frei");
                return true;
            }
        }
        //check if OML_Fstr_fe_vorzeitig_aufloesen can fire
        if ( (OML_Fstr_fe_$geprueft3 >= 1) &&
                (OML_Fstr_fe_$aufgeloest <= 0) &&
                (OML_Kontakte_$8_FSS_0EGF >= 1))
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
                (OML_Fstr_fe_$aufgeloest <= 0) &&
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
        //check if OML_Fstr_fe_1_egf_belegt can fire
        if ( (OML_Iso_egf_$belegt >= 1) &&
                (OML_Fstr_fe_$store_1_egf_belegt <= 0) &&
                (OML_Iso_1_$belegt >= 1) &&
                (OML_Fstr_fe_$verschlossen >= 1))
        {
            if (canFire("OML_Fstr_fe_1_egf_belegt"))
            {
                ++OML_Fstr_fe_$store_1_egf_belegt;
                fire("OML_Fstr_fe_1_egf_belegt");
                return true;
            }
        }
        //check if OML_Fstr_fe_pruefen can fire
        if ( (OML_Fstr_fe_$aufgeloest >= 1) &&
                (OML_Fstr_fe_$P2 <= 0) &&
                (OML_Kontakte_$8_FSS_10F >= 1) &&
                (OML_Stw_WS1_$endlage_plus >= 1) &&
                (OML_Kontakte_$6_Gleist_EMM >= 1))
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
        if ( (OML_Fstr_fe_$F_Fahrt1 >= 1) &&
                (OML_Fstr_fe_$gemerkt_90F >= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Fstr_fe_$F_Halt <= 1))
        {
            if (canFire("OML_Fstr_fe_signal_haltstellen_FSS"))
            {
                --OML_Fstr_fe_$F_Fahrt1;
                --OML_Fstr_fe_$gemerkt_90F;
                ++OML_Fstr_fe_$F_Halt;
                fire("OML_Fstr_fe_signal_haltstellen_FSS");
                return true;
            }
        }
        //check if OML_Fstr_fe_free_store_1_egf can fire
        if ( (OML_Fstr_fe_$store_1_egf_belegt >= 1) &&
                (OML_Iso_egf_$belegt < 1) &&
                (OML_Iso_1_$belegt < 1))
        {
            if (canFire("OML_Fstr_fe_free_store_1_egf"))
            {
                --OML_Fstr_fe_$store_1_egf_belegt;
                fire("OML_Fstr_fe_free_store_1_egf");
                return true;
            }
        }
        //check if OML_Fstr_gf_1_belegt can fire
        if ( (OML_Fstr_gf_$store_1_belegt <= 0) &&
                (OML_Fstr_gf_$verschlossen >= 1) &&
                (OML_Iso_egf_$belegt >= 1) &&
                (OML_Iso_1_$belegt >= 1))
        {
            if (canFire("OML_Fstr_gf_1_belegt"))
            {
                ++OML_Fstr_gf_$store_1_belegt;
                fire("OML_Fstr_gf_1_belegt");
                return true;
            }
        }
        //check if OML_Fstr_gf_T5 can fire
        if ( (OML_Fstr_gf_$geprueft1 <= 0) &&
                (OML_Fstr_gf_$P4 >= 1) &&
                (OML_Iso_egf_$frei >= 1) &&
                (OML_Iso_1_$frei >= 1))
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
        if ( (OML_Fstr_gf_$aufgeloest >= 1) &&
                (OML_Fstr_gf_$P4 <= 0) &&
                (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Stw_WS1_$endlage_minus >= 1) &&
                (OML_Kontakte_$6_Gleist_ZB >= 1))
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
                (OML_Fstr_gf_$aufgeloest <= 0) &&
                (OML_Kontakte_$6_NAL >= 1))
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
                (OML_Kontakte_$8_FSS_30EG >= 1) &&
                (OML_Fstr_gf_$Zug_eingefahren >= 1))
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
        if ( (OML_Fstr_gf_$geprueft2 <= 0) &&
                (OML_Fstr_gf_$geprueft1 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n >= 1))
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
        if ( (OML_Fstr_gf_$geprueft2 <= 0) &&
                (OML_Fstr_gf_$geprueft1 >= 1) &&
                (OML_Kontakte_$6_BLU_EG >= 1))
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
        if ( (OML_Fstr_gf_$G_Halt <= 1) &&
                (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_Fstr_gf_$store_1_belegt >= 1))
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
                (OML_Kontakte_$8_FSS_0EGF >= 1))
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
                (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (OML_Fstr_gf_$G_Halt <= 1))
        {
            if (canFire("OML_Fstr_gf_signal_haltstellen_FSS"))
            {
                --OML_Fstr_gf_$gemerkt_90EG;
                --OML_Fstr_gf_$G_Fahrt3;
                ++OML_Fstr_gf_$G_Halt;
                fire("OML_Fstr_gf_signal_haltstellen_FSS");
                return true;
            }
        }
        //check if OML_Fstr_gf_1_frei can fire
        if ( (OML_Fstr_gf_$Zug_eingefahren <= 0) &&
                (OML_Iso_1_$frei >= 1) &&
                (OML_Fstr_gf_$store_1_belegt >= 1))
        {
            if (canFire("OML_Fstr_gf_1_frei"))
            {
                ++OML_Fstr_gf_$Zug_eingefahren;
                fire("OML_Fstr_gf_1_frei");
                return true;
            }
        }
        //check if OML_Fstr_gf_free_store_1 can fire
        if ( (OML_Fstr_gf_$store_1_belegt >= 1) &&
                (OML_Iso_egf_$belegt < 1) &&
                (OML_Iso_1_$belegt < 1))
        {
            if (canFire("OML_Fstr_gf_free_store_1"))
            {
                --OML_Fstr_gf_$store_1_belegt;
                fire("OML_Fstr_gf_free_store_1");
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
                (OML_Stw_WS1_$endlage_minus >= 1) &&
                (OML_Kontakte_$8_FSS_10F >= 1) &&
                (OML_Kontakte_$6_Gleist_ZB >= 1))
        {
            if (canFire("OML_Fstr_fg_pruefen1"))
            {
                --OML_Fstr_fg_$aufgeloest;
                ++OML_Fstr_fg_$geprueft0;
                fire("OML_Fstr_fg_pruefen1");
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
        if ( (OML_Fstr_fg_$store_egf_1_belegt >= 1) &&
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
        //check if OML_Fstr_fg_1_belegt can fire
        if ( (OML_Iso_1_$belegt >= 1) &&
                (OML_Fstr_fg_$store_egf_1_belegt <= 0) &&
                (OML_Iso_egf_$belegt >= 1) &&
                (OML_Fstr_fg_$verschlossen >= 1))
        {
            if (canFire("OML_Fstr_fg_1_belegt"))
            {
                ++OML_Fstr_fg_$store_egf_1_belegt;
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
                (OML_Kontakte_$8_FSS_0EGF >= 1))
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
        if ( (OML_Kontakte_$8_FSS_90F >= 1) &&
                (OML_Fstr_fg_$gemerkt_90F <= 0))
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
        //check if OML_Fstr_fg_free_store_egf_1 can fire
        if ( (OML_Fstr_fg_$store_egf_1_belegt >= 1) &&
                (OML_Iso_1_$belegt < 1) &&
                (OML_Iso_egf_$belegt < 1))
        {
            if (canFire("OML_Fstr_fg_free_store_egf_1"))
            {
                --OML_Fstr_fg_$store_egf_1_belegt;
                fire("OML_Fstr_fg_free_store_egf_1");
                return true;
            }
        }
        //check if OML_Fstr_fg_egf_frei can fire
        if ( (OML_Fstr_fg_$store_egf_1_belegt >= 1) &&
                (OML_Fstr_fg_$Zug_eingefahren <= 0) &&
                (OML_Iso_egf_$frei >= 1))
        {
            if (canFire("OML_Fstr_fg_egf_frei"))
            {
                ++OML_Fstr_fg_$Zug_eingefahren;
                fire("OML_Fstr_fg_egf_frei");
                return true;
            }
        }
        //check if OML_Fstr_fg_halt_stellen_45 can fire
        if ( (OML_Fstr_fg_$gemerkt_90F >= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Fstr_fg_$F_Fahrt3 >= 1) &&
                (OML_Fstr_fg_$F_Halt <= 1))
        {
            if (canFire("OML_Fstr_fg_halt_stellen_45"))
            {
                --OML_Fstr_fg_$gemerkt_90F;
                --OML_Fstr_fg_$F_Fahrt3;
                ++OML_Fstr_fg_$F_Halt;
                fire("OML_Fstr_fg_halt_stellen_45");
                return true;
            }
        }
        //check if OML_Iso_ef_Ausfahrt_Fz can fire
        if ( (OML_Iso_ef_$belegt >= 1) &&
                (OML_Iso_ef_$frei <= 0) &&
                (OML_Iso_ef_$belegen < 1))
        {
            if (canFire("OML_Iso_ef_Ausfahrt_Fz"))
            {
                --OML_Iso_ef_$belegt;
                ++OML_Iso_ef_$frei;
                fire("OML_Iso_ef_Ausfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_ef_Einfahrt_Fz can fire
        if ( (OML_Iso_ef_$belegt <= 0) &&
                (OML_Iso_ef_$frei >= 1) &&
                (OML_Iso_ef_$belegen >= 1))
        {
            if (canFire("OML_Iso_ef_Einfahrt_Fz"))
            {
                ++OML_Iso_ef_$belegt;
                --OML_Iso_ef_$frei;
                fire("OML_Iso_ef_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_1_Ausfahrt_Fz can fire
        if ( (OML_Iso_1_$belegen < 1) &&
                (OML_Iso_1_$frei <= 0) &&
                (OML_Iso_1_$belegt >= 1))
        {
            if (canFire("OML_Iso_1_Ausfahrt_Fz"))
            {
                ++OML_Iso_1_$frei;
                --OML_Iso_1_$belegt;
                fire("OML_Iso_1_Ausfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_1_Einfahrt_Fz can fire
        if ( (OML_Iso_1_$belegen >= 1) &&
                (OML_Iso_1_$frei >= 1) &&
                (OML_Iso_1_$belegt <= 0))
        {
            if (canFire("OML_Iso_1_Einfahrt_Fz"))
            {
                --OML_Iso_1_$frei;
                ++OML_Iso_1_$belegt;
                fire("OML_Iso_1_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_gf_Einfahrt_Fz can fire
        if ( (OML_Iso_gf_$frei >= 1) &&
                (OML_Iso_gf_$belegt <= 0) &&
                (OML_Iso_gf_$belegen >= 1))
        {
            if (canFire("OML_Iso_gf_Einfahrt_Fz"))
            {
                --OML_Iso_gf_$frei;
                ++OML_Iso_gf_$belegt;
                fire("OML_Iso_gf_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_gf_Ausfahrt_Fz can fire
        if ( (OML_Iso_gf_$belegt >= 1) &&
                (OML_Iso_gf_$frei <= 0) &&
                (OML_Iso_gf_$belegen < 1))
        {
            if (canFire("OML_Iso_gf_Ausfahrt_Fz"))
            {
                --OML_Iso_gf_$belegt;
                ++OML_Iso_gf_$frei;
                fire("OML_Iso_gf_Ausfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_egf_Ausfahrt_Fz can fire
        if ( (OML_Iso_egf_$belegt >= 1) &&
                (OML_Iso_egf_$frei <= 0) &&
                (OML_Iso_egf_$belegen < 1))
        {
            if (canFire("OML_Iso_egf_Ausfahrt_Fz"))
            {
                --OML_Iso_egf_$belegt;
                ++OML_Iso_egf_$frei;
                fire("OML_Iso_egf_Ausfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_egf_Einfahrt_Fz can fire
        if ( (OML_Iso_egf_$frei >= 1) &&
                (OML_Iso_egf_$belegt <= 0) &&
                (OML_Iso_egf_$belegen >= 1))
        {
            if (canFire("OML_Iso_egf_Einfahrt_Fz"))
            {
                --OML_Iso_egf_$frei;
                ++OML_Iso_egf_$belegt;
                fire("OML_Iso_egf_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_cd_Einfahrt_Fz can fire
        if ( (OML_Iso_cd_$belegen >= 1) &&
                (OML_Iso_cd_$belegt <= 0) &&
                (OML_Iso_cd_$frei >= 1))
        {
            if (canFire("OML_Iso_cd_Einfahrt_Fz"))
            {
                ++OML_Iso_cd_$belegt;
                --OML_Iso_cd_$frei;
                fire("OML_Iso_cd_Einfahrt_Fz");
                return true;
            }
        }
        //check if OML_Iso_cd_Ausfahrt_Fz can fire
        if ( (OML_Iso_cd_$belegen < 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_Iso_cd_$frei <= 0))
        {
            if (canFire("OML_Iso_cd_Ausfahrt_Fz"))
            {
                --OML_Iso_cd_$belegt;
                ++OML_Iso_cd_$frei;
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
        //check if OML_BL_OM_LN_vbl_C26_1 can fire
        if ( (OML_LN_$C26_FB1 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_BL_OM_LN_$vorgebl_v <= 0))
        {
            if (canFire("OML_BL_OM_LN_vbl_C26_1"))
            {
                --OML_BL_OM_LN_$Grundstlg_v;
                ++OML_BL_OM_LN_$vorgebl_v;
                fire("OML_BL_OM_LN_vbl_C26_1");
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
        //check if OML_BL_OM_LN_vbl_C26_2 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_LN_$C26_FB2 >= 1) &&
                (OML_BL_OM_LN_$vorgebl_v <= 0))
        {
            if (canFire("OML_BL_OM_LN_vbl_C26_2"))
            {
                --OML_BL_OM_LN_$Grundstlg_v;
                ++OML_BL_OM_LN_$vorgebl_v;
                fire("OML_BL_OM_LN_vbl_C26_2");
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
        //check if OML_BL_OM_LN_vbl_C1 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (OML_BL_OM_LN_$vorgebl_v <= 0) &&
                (OML_LN_$C1_FB1 >= 1))
        {
            if (canFire("OML_BL_OM_LN_vbl_C1"))
            {
                --OML_BL_OM_LN_$Grundstlg_v;
                ++OML_BL_OM_LN_$vorgebl_v;
                fire("OML_BL_OM_LN_vbl_C1");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_1_belegt can fire
        if ( (OML_BL_ZB_OM_$3 <= 0) &&
                (OML_Iso_1_$belegt >= 1) &&
                (OML_BL_ZB_OM_$2 >= 1))
        {
            if (canFire("OML_BL_ZB_OM_1_belegt"))
            {
                ++OML_BL_ZB_OM_$3;
                --OML_BL_ZB_OM_$2;
                fire("OML_BL_ZB_OM_1_belegt");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_vormelden1_v can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
                (OML_ZB_$C_FB1 >= 1) &&
                (OML_BL_ZB_OM_$vorgebl_v <= 0))
        {
            if (canFire("OML_BL_ZB_OM_vormelden1_v"))
            {
                --OML_BL_ZB_OM_$Grundstlg_v;
                ++OML_BL_ZB_OM_$vorgebl_v;
                fire("OML_BL_ZB_OM_vormelden1_v");
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
        if ( (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
                (OML_Kontakte_$6_FBA_nZB >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_n <= 0) &&
                (OML_ILTIS_$festgehalten_v_ZB < 1))
        {
            if (canFire("OML_BL_ZB_OM_Richtungs__wechsel_n"))
            {
                --OML_BL_ZB_OM_$Grundstlg_v;
                ++OML_BL_ZB_OM_$Grundstlg_n;
                fire("OML_BL_ZB_OM_Richtungs__wechsel_n");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_Richtungs__wechsel_v can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_n >= 1) &&
                (OML_Kontakte_$6_FBF_nZB < 1) &&
                (OML_ILTIS_$anfordern_vZB >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v <= 0))
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
        if ( (OML_Iso_1_$frei >= 1) &&
                (OML_BL_ZB_OM_$RMM_nZB <= 0) &&
                (OML_BL_ZB_OM_$3 >= 1))
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
        if ( (OML_Iso_1_$belegt >= 1) &&
                (OML_BL_ZB_OM_$belegt_n <= 0) &&
                (OML_BL_ZB_OM_$vorgebl_n >= 1))
        {
            if (canFire("OML_BL_ZB_OM_blocken_N"))
            {
                ++OML_BL_ZB_OM_$belegt_n;
                --OML_BL_ZB_OM_$vorgebl_n;
                fire("OML_BL_ZB_OM_blocken_N");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_G_Fahrt can fire
        if ( (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_BL_ZB_OM_$belegt_v >= 1) &&
                (OML_BL_ZB_OM_$1 <= 0))
        {
            if (canFire("OML_BL_ZB_OM_G_Fahrt"))
            {
                ++OML_BL_ZB_OM_$1;
                fire("OML_BL_ZB_OM_G_Fahrt");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_rueckmelden_von can fire
        if ( (OML_BL_ZB_OM_$belegt_v >= 1) &&
                (OML_BL_ZB_OM_$RMM_nZB >= 1) &&
                (OML_Kontakte_$6_RM_nZB >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v <= 0))
        {
            if (canFire("OML_BL_ZB_OM_rueckmelden_von"))
            {
                --OML_BL_ZB_OM_$belegt_v;
                --OML_BL_ZB_OM_$RMM_nZB;
                ++OML_BL_ZB_OM_$Grundstlg_v;
                fire("OML_BL_ZB_OM_rueckmelden_von");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_G_Halt can fire
        if ( (OML_BL_ZB_OM_$1 >= 1) &&
                (OML_Fstr_gf_$G_Halt >= 1) &&
                (OML_BL_ZB_OM_$2 <= 0))
        {
            if (canFire("OML_BL_ZB_OM_G_Halt"))
            {
                --OML_BL_ZB_OM_$1;
                ++OML_BL_ZB_OM_$2;
                fire("OML_BL_ZB_OM_G_Halt");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_vormelden_n can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_n >= 1) &&
                (OML_Fstr_fg_$verschlossen >= 1) &&
                (OML_BL_ZB_OM_$vorgebl_n <= 0))
        {
            if (canFire("OML_BL_ZB_OM_vormelden_n"))
            {
                --OML_BL_ZB_OM_$Grundstlg_n;
                ++OML_BL_ZB_OM_$vorgebl_n;
                fire("OML_BL_ZB_OM_vormelden_n");
                return true;
            }
        }
        //check if OML_BL_ZB_OM_vormelden2_v can fire
        if ( (OML_BL_ZB_OM_$vorgebl_v <= 0) &&
                (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
                (OML_ZB_$C_FB2 >= 1))
        {
            if (canFire("OML_BL_ZB_OM_vormelden2_v"))
            {
                ++OML_BL_ZB_OM_$vorgebl_v;
                --OML_BL_ZB_OM_$Grundstlg_v;
                fire("OML_BL_ZB_OM_vormelden2_v");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T117 can fire
        if ( (OML_Stw_WS1_SM_$Sperrm_ein < 1) &&
                (OML_Lampen_WS1_$1_WS1_Freig >= 1))
        {
            if (canFire("OML_Lampen_WS1_T117"))
            {
                --OML_Lampen_WS1_$1_WS1_Freig;
                fire("OML_Lampen_WS1_T117");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T16 can fire
        if ( (OML_Lampen_WS1_$1_WS1_Freig <= 0) &&
                (OML_Stw_WS1_SM_$Sperrm_ein >= 1))
        {
            if (canFire("OML_Lampen_WS1_T16"))
            {
                ++OML_Lampen_WS1_$1_WS1_Freig;
                fire("OML_Lampen_WS1_T16");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T13 can fire
        if ( (OML_Stw_W1_$Endlage_minus < 1) &&
                (OML_Stw_W1_$Endlage_plus < 1) &&
                (OML_Lampen_WS1_$1_WS1_Ueberw >= 1))
        {
            if (canFire("OML_Lampen_WS1_T13"))
            {
                --OML_Lampen_WS1_$1_WS1_Ueberw;
                fire("OML_Lampen_WS1_T13");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T20 can fire
        if ( (OML_Lampen_WS1_$1_WS1_Ueberw <= 0) &&
                (OML_Stw_W1_$Endlage_plus >= 1))
        {
            if (canFire("OML_Lampen_WS1_T20"))
            {
                ++OML_Lampen_WS1_$1_WS1_Ueberw;
                fire("OML_Lampen_WS1_T20");
                return true;
            }
        }
        //check if OML_Lampen_WS1_T412 can fire
        if ( (OML_Lampen_WS1_$1_WS1_Ueberw <= 0) &&
                (OML_Stw_W1_$Endlage_minus >= 1))
        {
            if (canFire("OML_Lampen_WS1_T412"))
            {
                ++OML_Lampen_WS1_$1_WS1_Ueberw;
                fire("OML_Lampen_WS1_T412");
                return true;
            }
        }
        //check if OML_Lampen_Stoerung_T17 can fire
        if ( (OML_ext_Vb_$G_VS_Lampe_Warn_def < 1) &&
                (OML_Lampen_Stoerung_$1_G_VS_Stoer >= 1) &&
                (OML_ext_Vb_$G_VS_Lampe_Fahrt_def < 1))
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
                (OML_Lampen_Stoerung_$1_F_VS_Stoer >= 1) &&
                (OML_ext_Vb_$F_VS_Lampe_Fahrt_def < 1))
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
        //check if OML_Lampen_Streckenblock_T2 can fire
        if ( (OML_Lampen_Streckenblock_$1_FBV_vZB >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
                (OML_ILTIS_$anfordern_vZB < 1))
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
        if ( (OML_Lampen_Streckenblock_$1_FBV_vLN >= 1) &&
                (OML_ILTIS_$anfordern_vLN < 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
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
        if ( (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
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
        if ( (OML_Lampen_Streckenblock_$1_BL_vZB_weiss >= 1) &&
                (OML_BL_ZB_OM_$vorgebl_v < 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v < 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T48"))
            {
                --OML_Lampen_Streckenblock_$1_BL_vZB_weiss;
                fire("OML_Lampen_Streckenblock_T48");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T34 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_n < 1) &&
                (OML_BL_OM_LN_$vorgebl_n < 1) &&
                (OML_Lampen_Streckenblock_$1_BL_nLN_weiss >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T34"))
            {
                --OML_Lampen_Streckenblock_$1_BL_nLN_weiss;
                fire("OML_Lampen_Streckenblock_T34");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T10 can fire
        if ( (OML_ILTIS_$anfordern_vZB >= 1) &&
                (OML_Lampen_Streckenblock_$1_FBV_vZB <= 0))
        {
            if (canFire("OML_Lampen_Streckenblock_T10"))
            {
                ++OML_Lampen_Streckenblock_$1_FBV_vZB;
                fire("OML_Lampen_Streckenblock_T10");
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
        if ( (OML_Lampen_Streckenblock_$1_BL_vLN_weiss >= 1) &&
                (OML_BL_OM_LN_$vorgebl_v < 1) &&
                (OML_BL_OM_LN_$Grundstlg_v < 1))
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
        if ( (OML_BL_ZB_OM_$vorgebl_n < 1) &&
                (OML_Lampen_Streckenblock_$1_BL_nZB_weiss >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_n < 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T55"))
            {
                --OML_Lampen_Streckenblock_$1_BL_nZB_weiss;
                fire("OML_Lampen_Streckenblock_T55");
                return true;
            }
        }
        //check if OML_Lampen_Streckenblock_T1 can fire
        if ( (OML_Lampen_Streckenblock_$1_BL_vZB_weiss >= 1) &&
                (OML_BL_ZB_OM_$belegt_v >= 1))
        {
            if (canFire("OML_Lampen_Streckenblock_T1"))
            {
                --OML_Lampen_Streckenblock_$1_BL_vZB_weiss;
                fire("OML_Lampen_Streckenblock_T1");
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
        if ( (OML_Fstr_ef_$verschlossen >= 1) &&
                (OML_Lampen_Fahrstrasse_$1_Fstr_ef <= 0))
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
                (OML_Fstr_fg_$aufgeloest >= 1) &&
                (OML_Fstr_gf_$aufgeloest >= 1))
        {
            if (canFire("OML_Lampen_Fahrstrasse_T9"))
            {
                --OML_Lampen_Fahrstrasse_$1_Fstr_gf;
                fire("OML_Lampen_Fahrstrasse_T9");
                return true;
            }
        }
        //check if OML_Lampen_Fahrstrasse_T18 can fire
        if ( (OML_Fstr_fe_$verschlossen >= 1) &&
                (OML_Lampen_Fahrstrasse_$1_Fstr_ef <= 0))
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
                (OML_Fstr_fe_$F_Halt >= 1) &&
                (OML_Lampen_Signal_F_$1_F_rot <= 0))
        {
            if (canFire("OML_Lampen_Signal_F_entry_F_rot_fg"))
            {
                ++OML_Lampen_Signal_F_$1_F_rot;
                fire("OML_Lampen_Signal_F_entry_F_rot_fg");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_exit_F_rot_fg can fire
        if ( (OML_Lampen_Signal_F_$1_F_rot >= 1) &&
                (OML_Fstr_fg_$F_Halt < 1))
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
                (OML_Fstr_fg_$F_Fahrt3 < 1) &&
                (OML_Fstr_fe_$F_Fahrt1 < 1))
        {
            if (canFire("OML_Lampen_Signal_F_exit_F_gruenFB1_fe"))
            {
                --OML_Lampen_Signal_F_$1_F_gruenFB1;
                fire("OML_Lampen_Signal_F_exit_F_gruenFB1_fe");
                return true;
            }
        }
        //check if OML_Lampen_Signal_F_exit_F_rot_fe can fire
        if ( (OML_Lampen_Signal_F_$1_F_rot >= 1) &&
                (OML_Fstr_fe_$F_Halt < 1))
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
        if ( (OML_ZB_$ZB_Grundstlg >= 1) &&
                (OML_ZB_$geprueft1E2 <= 0) &&
                (OML_ILTIS_$ZB_138_2 >= 1))
        {
            if (canFire("OML_ZB_T7"))
            {
                --OML_ZB_$ZB_Grundstlg;
                ++OML_ZB_$geprueft1E2;
                fire("OML_ZB_T7");
                return true;
            }
        }
        //check if OML_ZB_SD23 can fire
        if ( (OML_ZB_$D_FB1 >= 1) &&
                (OML_ZB_$D_Halt <= 0) &&
                (OML_ZB_$D_FB2 >= 1) &&
                (OML_ZB_$Fstr_aufloesen >= 1))
        {
            if (canFire("OML_ZB_SD23"))
            {
                --OML_ZB_$D_FB1;
                ++OML_ZB_$D_Halt;
                --OML_ZB_$D_FB2;
                fire("OML_ZB_SD23");
                return true;
            }
        }
        //check if OML_ZB_T1 can fire
        if ( (OML_ZB_$ZB_Grundstlg >= 1) &&
                (OML_ZB_$geprueft1A1 <= 0) &&
                (OML_ILTIS_$ZB_1_138 >= 1))
        {
            if (canFire("OML_ZB_T1"))
            {
                --OML_ZB_$ZB_Grundstlg;
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
        if ( (OML_ZB_$ZB_Grundstlg <= 0) &&
                (OML_ZB_$Fstr_aufloesen >= 1) &&
                (OML_ZB_$C_Halt >= 1) &&
                (OML_ZB_$D_Halt >= 1))
        {
            if (canFire("OML_ZB_Fstr_aufloesen"))
            {
                ++OML_ZB_$ZB_Grundstlg;
                --OML_ZB_$Fstr_aufloesen;
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
        //check if OML_ZB_SC23 can fire
        if ( (OML_ZB_$C_FB2 >= 1) &&
                (OML_ZB_$C_FB1 >= 1) &&
                (OML_ZB_$C_Halt <= 0) &&
                (OML_ZB_$Fstr_aufloesen >= 1))
        {
            if (canFire("OML_ZB_SC23"))
            {
                --OML_ZB_$C_FB2;
                --OML_ZB_$C_FB1;
                ++OML_ZB_$C_Halt;
                fire("OML_ZB_SC23");
                return true;
            }
        }
        //check if OML_ZB_T6 can fire
        if ( (OML_ZB_$ZB_Grundstlg >= 1) &&
                (OML_ZB_$geprueft1E1 <= 0) &&
                (OML_ILTIS_$ZB_138_1 >= 1))
        {
            if (canFire("OML_ZB_T6"))
            {
                --OML_ZB_$ZB_Grundstlg;
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
        if ( (OML_ZB_$ZB_Grundstlg >= 1) &&
                (OML_ZB_$geprueft1A2 <= 0) &&
                (OML_ILTIS_$ZB_2_138 >= 1))
        {
            if (canFire("OML_ZB_T2"))
            {
                --OML_ZB_$ZB_Grundstlg;
                ++OML_ZB_$geprueft1A2;
                fire("OML_ZB_T2");
                return true;
            }
        }
        //check if OML_ZB_SD21 can fire
        if ( (OML_ZB_$ZB_W1_pE2 >= 1) &&
                (OML_ZB_$D_FB1 <= 0) &&
                (OML_ZB_$D_Halt >= 1))
        {
            if (canFire("OML_ZB_SD21"))
            {
                ++OML_ZB_$D_FB1;
                --OML_ZB_$D_Halt;
                fire("OML_ZB_SD21");
                return true;
            }
        }
        //check if OML_ZB_SC21 can fire
        if ( (OML_ZB_$C_Halt >= 1) &&
                (OML_ZB_$ZB_W1_pA2 >= 1) &&
                (OML_ZB_$C_FB1 <= 0) &&
                (OML_ZB_$C_FB2 <= 0))
        {
            if (canFire("OML_ZB_SC21"))
            {
                --OML_ZB_$C_Halt;
                ++OML_ZB_$C_FB1;
                ++OML_ZB_$C_FB2;
                fire("OML_ZB_SC21");
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
        //check if OML_ZB_TD2 can fire
        if ( (OML_ZB_$ZB_W1_pE2 >= 1) &&
                (OML_ZB_$cd_belegt >= 1) &&
                (OML_ZB_$Fstr_aufloesen <= 0))
        {
            if (canFire("OML_ZB_TD2"))
            {
                ++OML_ZB_$Fstr_aufloesen;
                fire("OML_ZB_TD2");
                return true;
            }
        }
        //check if OML_ZB_TD1 can fire
        if ( (OML_ZB_$ZB_W1_mE1 >= 1) &&
                (OML_ZB_$cd_belegt >= 1) &&
                (OML_ZB_$Fstr_aufloesen <= 0))
        {
            if (canFire("OML_ZB_TD1"))
            {
                ++OML_ZB_$Fstr_aufloesen;
                fire("OML_ZB_TD1");
                return true;
            }
        }
        //check if OML_ZB_SC22 can fire
        if ( (OML_ZB_$C_Halt >= 1) &&
                (OML_ZB_$ZB_W1_mA1 >= 1) &&
                (OML_ZB_$C_FB2 <= 0))
        {
            if (canFire("OML_ZB_SC22"))
            {
                --OML_ZB_$C_Halt;
                ++OML_ZB_$C_FB2;
                fire("OML_ZB_SC22");
                return true;
            }
        }
        //check if OML_ZB_TC1 can fire
        if ( (OML_ZB_$ZB_W1_mA1 >= 1) &&
                (OML_ZB_$Fstr_aufloesen <= 0) &&
                (OML_ZB_$cd_belegt >= 1))
        {
            if (canFire("OML_ZB_TC1"))
            {
                --OML_ZB_$ZB_W1_mA1;
                ++OML_ZB_$Fstr_aufloesen;
                fire("OML_ZB_TC1");
                return true;
            }
        }
        //check if OML_ZB_TC2 can fire
        if ( (OML_ZB_$ZB_W1_pA2 >= 1) &&
                (OML_ZB_$Fstr_aufloesen <= 0) &&
                (OML_ZB_$cd_belegt >= 1))
        {
            if (canFire("OML_ZB_TC2"))
            {
                --OML_ZB_$ZB_W1_pA2;
                ++OML_ZB_$Fstr_aufloesen;
                fire("OML_ZB_TC2");
                return true;
            }
        }
        //check if OML_ZB_SD22 can fire
        if ( (OML_ZB_$D_Halt >= 1) &&
                (OML_ZB_$ZB_W1_mE1 >= 1) &&
                (OML_ZB_$D_FB2 <= 0))
        {
            if (canFire("OML_ZB_SD22"))
            {
                --OML_ZB_$D_Halt;
                ++OML_ZB_$D_FB2;
                fire("OML_ZB_SD22");
                return true;
            }
        }
        //check if OML_EMM_T1 can fire
        if ( (OML_EMM_$geprueft1A1 <= 0) &&
                (OML_ILTIS_$EMM_1_833 >= 1) &&
                (OML_EMM_$EMM_Grundstlg >= 1))
        {
            if (canFire("OML_EMM_T1"))
            {
                ++OML_EMM_$geprueft1A1;
                --OML_EMM_$EMM_Grundstlg;
                fire("OML_EMM_T1");
                return true;
            }
        }
        //check if OML_EMM_T2 can fire
        if ( (OML_EMM_$geprueft1A2 <= 0) &&
                (OML_ILTIS_$EMM_2_833 >= 1) &&
                (OML_EMM_$EMM_Grundstlg >= 1))
        {
            if (canFire("OML_EMM_T2"))
            {
                ++OML_EMM_$geprueft1A2;
                --OML_EMM_$EMM_Grundstlg;
                fire("OML_EMM_T2");
                return true;
            }
        }
        //check if OML_EMM_T3 can fire
        if ( (OML_EMM_$geprueft1A3 <= 0) &&
                (OML_ILTIS_$EMM_3_833 >= 1) &&
                (OML_EMM_$EMM_Grundstlg >= 1))
        {
            if (canFire("OML_EMM_T3"))
            {
                ++OML_EMM_$geprueft1A3;
                --OML_EMM_$EMM_Grundstlg;
                fire("OML_EMM_T3");
                return true;
            }
        }
        //check if OML_EMM_T4 can fire
        if ( (OML_EMM_$geprueft1A4 <= 0) &&
                (OML_ILTIS_$EMM_4_833 >= 1) &&
                (OML_EMM_$EMM_Grundstlg >= 1))
        {
            if (canFire("OML_EMM_T4"))
            {
                ++OML_EMM_$geprueft1A4;
                --OML_EMM_$EMM_Grundstlg;
                fire("OML_EMM_T4");
                return true;
            }
        }
        //check if OML_EMM_T5 can fire
        if ( (OML_EMM_$geprueft1A5 <= 0) &&
                (OML_ILTIS_$EMM_5_833 >= 1) &&
                (OML_EMM_$EMM_Grundstlg >= 1))
        {
            if (canFire("OML_EMM_T5"))
            {
                ++OML_EMM_$geprueft1A5;
                --OML_EMM_$EMM_Grundstlg;
                fire("OML_EMM_T5");
                return true;
            }
        }
        //check if OML_EMM_T6 can fire
        if ( (OML_EMM_$EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1E1 <= 0) &&
                (OML_ILTIS_$EMM_833_1 >= 1))
        {
            if (canFire("OML_EMM_T6"))
            {
                --OML_EMM_$EMM_Grundstlg;
                ++OML_EMM_$geprueft1E1;
                fire("OML_EMM_T6");
                return true;
            }
        }
        //check if OML_EMM_T7 can fire
        if ( (OML_EMM_$EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1E2 <= 0) &&
                (OML_ILTIS_$EMM_833_2 >= 1))
        {
            if (canFire("OML_EMM_T7"))
            {
                --OML_EMM_$EMM_Grundstlg;
                ++OML_EMM_$geprueft1E2;
                fire("OML_EMM_T7");
                return true;
            }
        }
        //check if OML_EMM_T8 can fire
        if ( (OML_EMM_$EMM_Grundstlg >= 1) &&
                (OML_ILTIS_$EMM_833_3 >= 1) &&
                (OML_EMM_$geprueft1E3 <= 0))
        {
            if (canFire("OML_EMM_T8"))
            {
                --OML_EMM_$EMM_Grundstlg;
                ++OML_EMM_$geprueft1E3;
                fire("OML_EMM_T8");
                return true;
            }
        }
        //check if OML_EMM_T9 can fire
        if ( (OML_EMM_$EMM_Grundstlg >= 1) &&
                (OML_EMM_$geprueft1E4 <= 0) &&
                (OML_ILTIS_$EMM_833_4 >= 1))
        {
            if (canFire("OML_EMM_T9"))
            {
                --OML_EMM_$EMM_Grundstlg;
                ++OML_EMM_$geprueft1E4;
                fire("OML_EMM_T9");
                return true;
            }
        }
        //check if OML_EMM_T10 can fire
        if ( (OML_EMM_$EMM_Grundstlg >= 1) &&
                (OML_ILTIS_$EMM_833_5 >= 1) &&
                (OML_EMM_$geprueft1E5 <= 0))
        {
            if (canFire("OML_EMM_T10"))
            {
                --OML_EMM_$EMM_Grundstlg;
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
        if ( (OML_EMM_$EMM_W10_pE1 <= 0) &&
                (OML_EMM_$EMM_W7_mE1 >= 1))
        {
            if (canFire("OML_EMM_W10_pE1"))
            {
                ++OML_EMM_$EMM_W10_pE1;
                --OML_EMM_$EMM_W7_mE1;
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
        if ( (OML_EMM_$EMM_W10_pE2 <= 0) &&
                (OML_EMM_$EMM_W7_pE2 >= 1))
        {
            if (canFire("OML_EMM_W10_pE2"))
            {
                ++OML_EMM_$EMM_W10_pE2;
                --OML_EMM_$EMM_W7_pE2;
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
        if ( (OML_EMM_$EMM_W10_mE3 <= 0) &&
                (OML_EMM_$EMM_W9_pE3 >= 1))
        {
            if (canFire("OML_EMM_W10_mE3"))
            {
                ++OML_EMM_$EMM_W10_mE3;
                --OML_EMM_$EMM_W9_pE3;
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
        if ( (OML_EMM_$EMM_Grundstlg <= 0) &&
                (OML_EMM_$C_aufloesen >= 1) &&
                (OML_EMM_$C_Halt >= 1) &&
                (OML_EMM_$D_Halt >= 1))
        {
            if (canFire("OML_EMM_Fstr_aufloesen"))
            {
                ++OML_EMM_$EMM_Grundstlg;
                --OML_EMM_$C_aufloesen;
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
        if ( (OML_EMM_$EMM_W10_mE5 <= 0) &&
                (OML_EMM_$EMM_W9_mE5 >= 1))
        {
            if (canFire("OML_EMM_W10_mE5"))
            {
                ++OML_EMM_$EMM_W10_mE5;
                --OML_EMM_$EMM_W9_mE5;
                fire("OML_EMM_W10_mE5");
                return true;
            }
        }
        //check if OML_EMM_W10_mE4 can fire
        if ( (OML_EMM_$EMM_W10_mE4 <= 0) &&
                (OML_EMM_$EMM_W9_mE4 >= 1))
        {
            if (canFire("OML_EMM_W10_mE4"))
            {
                ++OML_EMM_$EMM_W10_mE4;
                --OML_EMM_$EMM_W9_mE4;
                fire("OML_EMM_W10_mE4");
                return true;
            }
        }
        //check if OML_EMM_S21 can fire
        if ( (OML_EMM_$C_FB1 >= 1) &&
                (OML_EMM_$C_Halt <= 0) &&
                (OML_EMM_$C_aufloesen >= 1))
        {
            if (canFire("OML_EMM_S21"))
            {
                --OML_EMM_$C_FB1;
                ++OML_EMM_$C_Halt;
                fire("OML_EMM_S21");
                return true;
            }
        }
        //check if OML_EMM_S1 can fire
        if ( (OML_EMM_$C_Halt >= 1) &&
                (OML_EMM_$EMM_W10_pA2 >= 1) &&
                (OML_EMM_$C_FB1 <= 0))
        {
            if (canFire("OML_EMM_S1"))
            {
                --OML_EMM_$C_Halt;
                ++OML_EMM_$C_FB1;
                fire("OML_EMM_S1");
                return true;
            }
        }
        //check if OML_EMM_S23 can fire
        if ( (OML_EMM_$D_Halt <= 0) &&
                (OML_EMM_$D_FB1 >= 1) &&
                (OML_EMM_$C_aufloesen >= 1))
        {
            if (canFire("OML_EMM_S23"))
            {
                ++OML_EMM_$D_Halt;
                --OML_EMM_$D_FB1;
                fire("OML_EMM_S23");
                return true;
            }
        }
        //check if OML_EMM_S6 can fire
        if ( (OML_EMM_$D_Halt >= 1) &&
                (OML_EMM_$D_FB1 <= 0) &&
                (OML_EMM_$EMM_W10_pE2 >= 1))
        {
            if (canFire("OML_EMM_S6"))
            {
                --OML_EMM_$D_Halt;
                ++OML_EMM_$D_FB1;
                fire("OML_EMM_S6");
                return true;
            }
        }
        //check if OML_EMM_S2 can fire
        if ( (OML_EMM_$C_Halt >= 1) &&
                (OML_EMM_$EMM_W10_pA1 >= 1) &&
                (OML_EMM_$C_FB2 <= 0))
        {
            if (canFire("OML_EMM_S2"))
            {
                --OML_EMM_$C_Halt;
                ++OML_EMM_$C_FB2;
                fire("OML_EMM_S2");
                return true;
            }
        }
        //check if OML_EMM_S22 can fire
        if ( (OML_EMM_$C_FB2 >= 1) &&
                (OML_EMM_$C_Halt <= 0) &&
                (OML_EMM_$C_aufloesen >= 1))
        {
            if (canFire("OML_EMM_S22"))
            {
                --OML_EMM_$C_FB2;
                ++OML_EMM_$C_Halt;
                fire("OML_EMM_S22");
                return true;
            }
        }
        //check if OML_EMM_A1 can fire
        if ( (OML_EMM_$EMM_W10_pA1 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_A1"))
            {
                --OML_EMM_$EMM_W10_pA1;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_A1");
                return true;
            }
        }
        //check if OML_EMM_A2 can fire
        if ( (OML_EMM_$EMM_W10_pA2 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_A2"))
            {
                --OML_EMM_$EMM_W10_pA2;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_A2");
                return true;
            }
        }
        //check if OML_EMM_A3 can fire
        if ( (OML_EMM_$EMM_W10_mA3 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_A3"))
            {
                --OML_EMM_$EMM_W10_mA3;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_A3");
                return true;
            }
        }
        //check if OML_EMM_A4 can fire
        if ( (OML_EMM_$EMM_W10_mA4 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_A4"))
            {
                --OML_EMM_$EMM_W10_mA4;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_A4");
                return true;
            }
        }
        //check if OML_EMM_A5 can fire
        if ( (OML_EMM_$EMM_W10_mA5 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_A5"))
            {
                --OML_EMM_$EMM_W10_mA5;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_A5");
                return true;
            }
        }
        //check if OML_EMM_S3 can fire
        if ( (OML_EMM_$C_Halt >= 1) &&
                (OML_EMM_$EMM_W10_mA3 >= 1) &&
                (OML_EMM_$C_FB2 <= 0))
        {
            if (canFire("OML_EMM_S3"))
            {
                --OML_EMM_$C_Halt;
                ++OML_EMM_$C_FB2;
                fire("OML_EMM_S3");
                return true;
            }
        }
        //check if OML_EMM_S4 can fire
        if ( (OML_EMM_$C_Halt >= 1) &&
                (OML_EMM_$EMM_W10_mA4 >= 1) &&
                (OML_EMM_$C_FB2 <= 0))
        {
            if (canFire("OML_EMM_S4"))
            {
                --OML_EMM_$C_Halt;
                ++OML_EMM_$C_FB2;
                fire("OML_EMM_S4");
                return true;
            }
        }
        //check if OML_EMM_S5 can fire
        if ( (OML_EMM_$C_Halt >= 1) &&
                (OML_EMM_$EMM_W10_mA5 >= 1) &&
                (OML_EMM_$C_FB2 <= 0))
        {
            if (canFire("OML_EMM_S5"))
            {
                --OML_EMM_$C_Halt;
                ++OML_EMM_$C_FB2;
                fire("OML_EMM_S5");
                return true;
            }
        }
        //check if OML_EMM_S7 can fire
        if ( (OML_EMM_$D_Halt >= 1) &&
                (OML_EMM_$D_FB2 <= 0) &&
                (OML_EMM_$EMM_W10_pE1 >= 1))
        {
            if (canFire("OML_EMM_S7"))
            {
                --OML_EMM_$D_Halt;
                ++OML_EMM_$D_FB2;
                fire("OML_EMM_S7");
                return true;
            }
        }
        //check if OML_EMM_S24 can fire
        if ( (OML_EMM_$D_FB2 >= 1) &&
                (OML_EMM_$D_Halt <= 0) &&
                (OML_EMM_$C_aufloesen >= 1))
        {
            if (canFire("OML_EMM_S24"))
            {
                --OML_EMM_$D_FB2;
                ++OML_EMM_$D_Halt;
                fire("OML_EMM_S24");
                return true;
            }
        }
        //check if OML_EMM_S8 can fire
        if ( (OML_EMM_$EMM_W10_mE3 >= 1) &&
                (OML_EMM_$D_FB2 <= 0) &&
                (OML_EMM_$D_Halt >= 1))
        {
            if (canFire("OML_EMM_S8"))
            {
                ++OML_EMM_$D_FB2;
                --OML_EMM_$D_Halt;
                fire("OML_EMM_S8");
                return true;
            }
        }
        //check if OML_EMM_S9 can fire
        if ( (OML_EMM_$D_Halt >= 1) &&
                (OML_EMM_$D_FB2 <= 0) &&
                (OML_EMM_$EMM_W10_mE4 >= 1))
        {
            if (canFire("OML_EMM_S9"))
            {
                --OML_EMM_$D_Halt;
                ++OML_EMM_$D_FB2;
                fire("OML_EMM_S9");
                return true;
            }
        }
        //check if OML_EMM_S10 can fire
        if ( (OML_EMM_$D_Halt >= 1) &&
                (OML_EMM_$EMM_W10_mE5 >= 1) &&
                (OML_EMM_$D_FB2 <= 0))
        {
            if (canFire("OML_EMM_S10"))
            {
                --OML_EMM_$D_Halt;
                ++OML_EMM_$D_FB2;
                fire("OML_EMM_S10");
                return true;
            }
        }
        //check if OML_EMM_E1 can fire
        if ( (OML_EMM_$EMM_W10_pE1 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_E1"))
            {
                --OML_EMM_$EMM_W10_pE1;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_E1");
                return true;
            }
        }
        //check if OML_EMM_E2 can fire
        if ( (OML_EMM_$EMM_W10_pE2 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_E2"))
            {
                --OML_EMM_$EMM_W10_pE2;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_E2");
                return true;
            }
        }
        //check if OML_EMM_E3 can fire
        if ( (OML_EMM_$EMM_W10_mE3 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_E3"))
            {
                --OML_EMM_$EMM_W10_mE3;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_E3");
                return true;
            }
        }
        //check if OML_EMM_E4 can fire
        if ( (OML_EMM_$EMM_W10_mE4 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_E4"))
            {
                --OML_EMM_$EMM_W10_mE4;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_E4");
                return true;
            }
        }
        //check if OML_EMM_E5 can fire
        if ( (OML_EMM_$EMM_W10_mE5 >= 1) &&
                (OML_Iso_cd_$belegt >= 1) &&
                (OML_EMM_$C_aufloesen <= 0))
        {
            if (canFire("OML_EMM_E5"))
            {
                --OML_EMM_$EMM_W10_mE5;
                ++OML_EMM_$C_aufloesen;
                fire("OML_EMM_E5");
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
        if ( (OML_LN_$geprueft2A5 <= 0) &&
                (OML_LN_$geprueft1A5 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A5"))
            {
                ++OML_LN_$geprueft2A5;
                --OML_LN_$geprueft1A5;
                fire("OML_LN_pruefen2A5");
                return true;
            }
        }
        //check if OML_LN_T8 can fire
        if ( (OML_ILTIS_$LN_834_2 >= 1) &&
                (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_LN_$geprueft1E2 <= 0))
        {
            if (canFire("OML_LN_T8"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1E2;
                fire("OML_LN_T8");
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
        if ( (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_LN_$geprueft1A5 <= 0) &&
                (OML_ILTIS_$LN_834_5 >= 1))
        {
            if (canFire("OML_LN_T5"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1A5;
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
        if ( (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_LN_$geprueft1A4 <= 0) &&
                (OML_ILTIS_$LN_4_834 >= 1))
        {
            if (canFire("OML_LN_T4"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1A4;
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
        if ( (OML_LN_$LN_W1_pA3 <= 0) &&
                (OML_LN_$geprueft2A3 >= 1))
        {
            if (canFire("OML_LN_W1_pA3"))
            {
                ++OML_LN_$LN_W1_pA3;
                --OML_LN_$geprueft2A3;
                fire("OML_LN_W1_pA3");
                return true;
            }
        }
        //check if OML_LN_pruefen2A3 can fire
        if ( (OML_LN_$geprueft1A3 >= 1) &&
                (OML_LN_$geprueft2A3 <= 0) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A3"))
            {
                --OML_LN_$geprueft1A3;
                ++OML_LN_$geprueft2A3;
                fire("OML_LN_pruefen2A3");
                return true;
            }
        }
        //check if OML_LN_W1_mA1 can fire
        if ( (OML_LN_$geprueft2A1 >= 1) &&
                (OML_LN_$LN_W1_mA1 <= 0))
        {
            if (canFire("OML_LN_W1_mA1"))
            {
                --OML_LN_$geprueft2A1;
                ++OML_LN_$LN_W1_mA1;
                fire("OML_LN_W1_mA1");
                return true;
            }
        }
        //check if OML_LN_T10 can fire
        if ( (OML_ILTIS_$LN_834_4 >= 1) &&
                (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_LN_$geprueft1E4 <= 0))
        {
            if (canFire("OML_LN_T10"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1E4;
                fire("OML_LN_T10");
                return true;
            }
        }
        //check if OML_LN_T7 can fire
        if ( (OML_LN_$geprueft1E1 <= 0) &&
                (OML_ILTIS_$LN_834_1 >= 1) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("OML_LN_T7"))
            {
                ++OML_LN_$geprueft1E1;
                --OML_LN_$LN_Grundstlg;
                fire("OML_LN_T7");
                return true;
            }
        }
        //check if OML_LN_T9 can fire
        if ( (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_ILTIS_$LN_834_3 >= 1) &&
                (OML_LN_$geprueft1E3 <= 0))
        {
            if (canFire("OML_LN_T9"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1E3;
                fire("OML_LN_T9");
                return true;
            }
        }
        //check if OML_LN_T11 can fire
        if ( (OML_ILTIS_$LN_834_5 >= 1) &&
                (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_LN_$geprueft1E5 <= 0))
        {
            if (canFire("OML_LN_T11"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1E5;
                fire("OML_LN_T11");
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
        if ( (OML_LN_$geprueft2A2 <= 0) &&
                (OML_LN_$geprueft1A2 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A2"))
            {
                ++OML_LN_$geprueft2A2;
                --OML_LN_$geprueft1A2;
                fire("OML_LN_pruefen2A2");
                return true;
            }
        }
        //check if OML_LN_T2 can fire
        if ( (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_ILTIS_$LN_2_834 >= 1) &&
                (OML_LN_$geprueft1A2 <= 0))
        {
            if (canFire("OML_LN_T2"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1A2;
                fire("OML_LN_T2");
                return true;
            }
        }
        //check if OML_LN_T3 can fire
        if ( (OML_ILTIS_$LN_3_834 >= 1) &&
                (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_LN_$geprueft1A3 <= 0))
        {
            if (canFire("OML_LN_T3"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1A3;
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
        if ( (OML_LN_$LN_W3_pA3 <= 0) &&
                (OML_LN_$LN_W2_mA3 >= 1))
        {
            if (canFire("OML_LN_W3_pA3"))
            {
                ++OML_LN_$LN_W3_pA3;
                --OML_LN_$LN_W2_mA3;
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
        if ( (OML_LN_$LN_W2_mA4 <= 0) &&
                (OML_LN_$LN_W1_pA4 >= 1))
        {
            if (canFire("OML_LN_W2_mA4"))
            {
                ++OML_LN_$LN_W2_mA4;
                --OML_LN_$LN_W1_pA4;
                fire("OML_LN_W2_mA4");
                return true;
            }
        }
        //check if OML_LN_W5_pA3 can fire
        if ( (OML_LN_$LN_W5_pA3 <= 0) &&
                (OML_LN_$LN_W3_pA3 >= 1))
        {
            if (canFire("OML_LN_W5_pA3"))
            {
                ++OML_LN_$LN_W5_pA3;
                --OML_LN_$LN_W3_pA3;
                fire("OML_LN_W5_pA3");
                return true;
            }
        }
        //check if OML_LN_W5_mA4 can fire
        if ( (OML_LN_$LN_W5_mA4 <= 0) &&
                (OML_LN_$LN_W3_pA4 >= 1))
        {
            if (canFire("OML_LN_W5_mA4"))
            {
                ++OML_LN_$LN_W5_mA4;
                --OML_LN_$LN_W3_pA4;
                fire("OML_LN_W5_mA4");
                return true;
            }
        }
        //check if OML_LN_W2_mA5 can fire
        if ( (OML_LN_$LN_W2_mA5 <= 0) &&
                (OML_LN_$LN_W1_pA5 >= 1))
        {
            if (canFire("OML_LN_W2_mA5"))
            {
                ++OML_LN_$LN_W2_mA5;
                --OML_LN_$LN_W1_pA5;
                fire("OML_LN_W2_mA5");
                return true;
            }
        }
        //check if OML_LN_W3_mA5 can fire
        if ( (OML_LN_$LN_W2_mA5 >= 1) &&
                (OML_LN_$LN_W3_mA5 <= 0))
        {
            if (canFire("OML_LN_W3_mA5"))
            {
                --OML_LN_$LN_W2_mA5;
                ++OML_LN_$LN_W3_mA5;
                fire("OML_LN_W3_mA5");
                return true;
            }
        }
        //check if OML_LN_W1_pA5 can fire
        if ( (OML_LN_$geprueft2A5 >= 1) &&
                (OML_LN_$LN_W1_pA5 <= 0))
        {
            if (canFire("OML_LN_W1_pA5"))
            {
                --OML_LN_$geprueft2A5;
                ++OML_LN_$LN_W1_pA5;
                fire("OML_LN_W1_pA5");
                return true;
            }
        }
        //check if OML_LN_W4_pA5 can fire
        if ( (OML_LN_$LN_W4_pA5 <= 0) &&
                (OML_LN_$LN_W3_mA5 >= 1))
        {
            if (canFire("OML_LN_W4_pA5"))
            {
                ++OML_LN_$LN_W4_pA5;
                --OML_LN_$LN_W3_mA5;
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
        if ( (OML_LN_$LN_W1_pA6 >= 1) &&
                (OML_LN_$LN_W2_mA6 <= 0))
        {
            if (canFire("OML_LN_W2_mA6"))
            {
                --OML_LN_$LN_W1_pA6;
                ++OML_LN_$LN_W2_mA6;
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
        if ( (OML_LN_$LN_W4_pA6 <= 0) &&
                (OML_LN_$LN_W3_mA6 >= 1))
        {
            if (canFire("OML_LN_W4_pA6"))
            {
                ++OML_LN_$LN_W4_pA6;
                --OML_LN_$LN_W3_mA6;
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
        if ( (OML_LN_$LN_W3_mA6 <= 0) &&
                (OML_LN_$LN_W2_mA6 >= 1))
        {
            if (canFire("OML_LN_W3_mA6"))
            {
                ++OML_LN_$LN_W3_mA6;
                --OML_LN_$LN_W2_mA6;
                fire("OML_LN_W3_mA6");
                return true;
            }
        }
        //check if OML_LN_pruefen2A6 can fire
        if ( (OML_LN_$geprueft1A6 >= 1) &&
                (OML_LN_$geprueft2A6 <= 0) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("OML_LN_pruefen2A6"))
            {
                --OML_LN_$geprueft1A6;
                ++OML_LN_$geprueft2A6;
                fire("OML_LN_pruefen2A6");
                return true;
            }
        }
        //check if OML_LN_T6 can fire
        if ( (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_LN_$geprueft1A6 <= 0) &&
                (OML_ILTIS_$LN_6_834 >= 1))
        {
            if (canFire("OML_LN_T6"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1A6;
                fire("OML_LN_T6");
                return true;
            }
        }
        //check if OML_LN_W2_mE6 can fire
        if ( (OML_LN_$LN_W2_mE6 <= 0) &&
                (OML_LN_$LN_W1_pE6 >= 1))
        {
            if (canFire("OML_LN_W2_mE6"))
            {
                ++OML_LN_$LN_W2_mE6;
                --OML_LN_$LN_W1_pE6;
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
        if ( (OML_LN_$geprueft1E6 >= 1) &&
                (OML_LN_$LN_W1_pE6 <= 0))
        {
            if (canFire("OML_LN_W1_pE6"))
            {
                --OML_LN_$geprueft1E6;
                ++OML_LN_$LN_W1_pE6;
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
        if ( (OML_LN_$LN_W2_mE3 >= 1) &&
                (OML_LN_$LN_W3_pE3 <= 0))
        {
            if (canFire("OML_LN_W3_pE3"))
            {
                --OML_LN_$LN_W2_mE3;
                ++OML_LN_$LN_W3_pE3;
                fire("OML_LN_W3_pE3");
                return true;
            }
        }
        //check if OML_LN_W4_pE6 can fire
        if ( (OML_LN_$LN_W3_mE6 >= 1) &&
                (OML_LN_$LN_W4_pE6 <= 0))
        {
            if (canFire("OML_LN_W4_pE6"))
            {
                --OML_LN_$LN_W3_mE6;
                ++OML_LN_$LN_W4_pE6;
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
        if ( (OML_LN_$LN_W4_pE5 <= 0) &&
                (OML_LN_$LN_W3_mE5 >= 1))
        {
            if (canFire("OML_LN_W4_pE5"))
            {
                ++OML_LN_$LN_W4_pE5;
                --OML_LN_$LN_W3_mE5;
                fire("OML_LN_W4_pE5");
                return true;
            }
        }
        //check if OML_LN_W1_pE4 can fire
        if ( (OML_LN_$LN_W1_pE4 <= 0) &&
                (OML_LN_$geprueft1E4 >= 1))
        {
            if (canFire("OML_LN_W1_pE4"))
            {
                ++OML_LN_$LN_W1_pE4;
                --OML_LN_$geprueft1E4;
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
        //check if OML_LN_T12 can fire
        if ( (OML_ILTIS_$LN_834_6 >= 1) &&
                (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_LN_$geprueft1E6 <= 0))
        {
            if (canFire("OML_LN_T12"))
            {
                --OML_LN_$LN_Grundstlg;
                ++OML_LN_$geprueft1E6;
                fire("OML_LN_T12");
                return true;
            }
        }
        //check if OML_LN_S21 can fire
        if ( (OML_LN_$C1_FB1 >= 1) &&
                (OML_LN_$C1_Halt <= 0) &&
                (OML_LN_Fstr_aufloesen >= 1))
        {
            if (canFire("OML_LN_S21"))
            {
                --OML_LN_$C1_FB1;
                ++OML_LN_$C1_Halt;
                fire("OML_LN_S21");
                return true;
            }
        }
        //check if OML_LN_S11 can fire
        if ( (OML_LN_$LN_W1_mA1 >= 1) &&
                (OML_LN_$C1_FB1 <= 0) &&
                (OML_LN_$C1_Halt >= 1))
        {
            if (canFire("OML_LN_S11"))
            {
                ++OML_LN_$C1_FB1;
                --OML_LN_$C1_Halt;
                fire("OML_LN_S11");
                return true;
            }
        }
        //check if OML_LN_T325 can fire
        if ( (OML_LN_$E_FB1 >= 1) &&
                (OML_LN_$e_Halt <= 0) &&
                (OML_LN_Fstr_aufloesen >= 1))
        {
            if (canFire("OML_LN_T325"))
            {
                --OML_LN_$E_FB1;
                ++OML_LN_$e_Halt;
                fire("OML_LN_T325");
                return true;
            }
        }
        //check if OML_LN_SE3 can fire
        if ( (OML_LN_$LN_W2_pE2 >= 1) &&
                (OML_LN_$E_FB2 <= 0) &&
                (OML_LN_$e_Halt >= 1))
        {
            if (canFire("OML_LN_SE3"))
            {
                ++OML_LN_$E_FB2;
                --OML_LN_$e_Halt;
                fire("OML_LN_SE3");
                return true;
            }
        }
        //check if OML_LN_SE2 can fire
        if ( (OML_LN_$LN_W1_mE1 >= 1) &&
                (OML_LN_$E_FB2 <= 0) &&
                (OML_LN_$e_Halt >= 1))
        {
            if (canFire("OML_LN_SE2"))
            {
                ++OML_LN_$E_FB2;
                --OML_LN_$e_Halt;
                fire("OML_LN_SE2");
                return true;
            }
        }
        //check if OML_LN_SE1 can fire
        if ( (OML_LN_$LN_W2_pE2 >= 1) &&
                (OML_LN_$E_FB1 <= 0) &&
                (OML_LN_$e_Halt >= 1))
        {
            if (canFire("OML_LN_SE1"))
            {
                ++OML_LN_$E_FB1;
                --OML_LN_$e_Halt;
                fire("OML_LN_SE1");
                return true;
            }
        }
        //check if OML_LN_clear_E_FB2 can fire
        if ( (OML_LN_$E_FB2 >= 1) &&
                (OML_LN_$e_Halt <= 0) &&
                (OML_LN_Fstr_aufloesen >= 1))
        {
            if (canFire("OML_LN_clear_E_FB2"))
            {
                --OML_LN_$E_FB2;
                ++OML_LN_$e_Halt;
                fire("OML_LN_clear_E_FB2");
                return true;
            }
        }
        //check if OML_LN_aufloesen_A1 can fire
        if ( (OML_LN_$LN_W1_mA1 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0))
        {
            if (canFire("OML_LN_aufloesen_A1"))
            {
                --OML_LN_$LN_W1_mA1;
                ++OML_LN_Fstr_aufloesen;
                fire("OML_LN_aufloesen_A1");
                return true;
            }
        }
        //check if OML_LN_aufloesen_A2 can fire
        if ( (OML_LN_$LN_W2_pA2 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0))
        {
            if (canFire("OML_LN_aufloesen_A2"))
            {
                --OML_LN_$LN_W2_pA2;
                ++OML_LN_Fstr_aufloesen;
                fire("OML_LN_aufloesen_A2");
                return true;
            }
        }
        //check if OML_LN_aufloesen_A3 can fire
        if ( (OML_LN_$LN_W5_pA3 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0))
        {
            if (canFire("OML_LN_aufloesen_A3"))
            {
                --OML_LN_$LN_W5_pA3;
                ++OML_LN_Fstr_aufloesen;
                fire("OML_LN_aufloesen_A3");
                return true;
            }
        }
        //check if OML_LN_aufloesen_A4 can fire
        if ( (OML_LN_$LN_W5_mA4 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0))
        {
            if (canFire("OML_LN_aufloesen_A4"))
            {
                --OML_LN_$LN_W5_mA4;
                ++OML_LN_Fstr_aufloesen;
                fire("OML_LN_aufloesen_A4");
                return true;
            }
        }
        //check if OML_LN_aufloesen_A5 can fire
        if ( (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0) &&
                (OML_LN_$LN_W6_mA5 >= 1))
        {
            if (canFire("OML_LN_aufloesen_A5"))
            {
                ++OML_LN_Fstr_aufloesen;
                --OML_LN_$LN_W6_mA5;
                fire("OML_LN_aufloesen_A5");
                return true;
            }
        }
        //check if OML_LN_aufloesen_A6 can fire
        if ( (OML_LN_$LN_W6_mA6 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0))
        {
            if (canFire("OML_LN_aufloesen_A6"))
            {
                --OML_LN_$LN_W6_mA6;
                ++OML_LN_Fstr_aufloesen;
                fire("OML_LN_aufloesen_A6");
                return true;
            }
        }
        //check if OML_LN_aufloesen_E1 can fire
        if ( (OML_LN_$LN_W1_mE1 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0))
        {
            if (canFire("OML_LN_aufloesen_E1"))
            {
                --OML_LN_$LN_W1_mE1;
                ++OML_LN_Fstr_aufloesen;
                fire("OML_LN_aufloesen_E1");
                return true;
            }
        }
        //check if OML_LN_aufloesen_E2 can fire
        if ( (OML_LN_$LN_W2_pE2 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0))
        {
            if (canFire("OML_LN_aufloesen_E2"))
            {
                --OML_LN_$LN_W2_pE2;
                ++OML_LN_Fstr_aufloesen;
                fire("OML_LN_aufloesen_E2");
                return true;
            }
        }
        //check if OML_LN_aufloesen_E3 can fire
        if ( (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0) &&
                (OML_LN_$LN_W5_pE3 >= 1))
        {
            if (canFire("OML_LN_aufloesen_E3"))
            {
                ++OML_LN_Fstr_aufloesen;
                --OML_LN_$LN_W5_pE3;
                fire("OML_LN_aufloesen_E3");
                return true;
            }
        }
        //check if OML_LN_aufloesen_E4 can fire
        if ( (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0) &&
                (OML_LN_$LN_W5_mE4 >= 1))
        {
            if (canFire("OML_LN_aufloesen_E4"))
            {
                ++OML_LN_Fstr_aufloesen;
                --OML_LN_$LN_W5_mE4;
                fire("OML_LN_aufloesen_E4");
                return true;
            }
        }
        //check if OML_LN_aufloesen_E5 can fire
        if ( (OML_LN_$LN_W6_mE5 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0))
        {
            if (canFire("OML_LN_aufloesen_E5"))
            {
                --OML_LN_$LN_W6_mE5;
                ++OML_LN_Fstr_aufloesen;
                fire("OML_LN_aufloesen_E5");
                return true;
            }
        }
        //check if OML_LN_aufloesen_E6 can fire
        if ( (OML_LN_$LN_W6_mE6 >= 1) &&
                (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_Fstr_aufloesen <= 0))
        {
            if (canFire("OML_LN_aufloesen_E6"))
            {
                --OML_LN_$LN_W6_mE6;
                ++OML_LN_Fstr_aufloesen;
                fire("OML_LN_aufloesen_E6");
                return true;
            }
        }
        //check if OML_LN_S1 can fire
        if ( (OML_LN_$C26_Halt >= 1) &&
                (OML_LN_$LN_W2_pA2 >= 1) &&
                (OML_LN_$C26_FB1 <= 0))
        {
            if (canFire("OML_LN_S1"))
            {
                --OML_LN_$C26_Halt;
                ++OML_LN_$C26_FB1;
                fire("OML_LN_S1");
                return true;
            }
        }
        //check if OML_LN_S2 can fire
        if ( (OML_LN_$C26_Halt >= 1) &&
                (OML_LN_$LN_W5_pA3 >= 1) &&
                (OML_LN_$C26_FB2 <= 0))
        {
            if (canFire("OML_LN_S2"))
            {
                --OML_LN_$C26_Halt;
                ++OML_LN_$C26_FB2;
                fire("OML_LN_S2");
                return true;
            }
        }
        //check if OML_LN_S3 can fire
        if ( (OML_LN_$LN_W5_mA4 >= 1) &&
                (OML_LN_$C26_Halt >= 1) &&
                (OML_LN_$C26_FB2 <= 0))
        {
            if (canFire("OML_LN_S3"))
            {
                --OML_LN_$C26_Halt;
                ++OML_LN_$C26_FB2;
                fire("OML_LN_S3");
                return true;
            }
        }
        //check if OML_LN_S4 can fire
        if ( (OML_LN_$C26_Halt >= 1) &&
                (OML_LN_$LN_W6_mA5 >= 1) &&
                (OML_LN_$C26_FB2 <= 0))
        {
            if (canFire("OML_LN_S4"))
            {
                --OML_LN_$C26_Halt;
                ++OML_LN_$C26_FB2;
                fire("OML_LN_S4");
                return true;
            }
        }
        //check if OML_LN_S5 can fire
        if ( (OML_LN_$LN_W6_mA6 >= 1) &&
                (OML_LN_$C26_Halt >= 1) &&
                (OML_LN_$C26_FB2 <= 0))
        {
            if (canFire("OML_LN_S5"))
            {
                --OML_LN_$C26_Halt;
                ++OML_LN_$C26_FB2;
                fire("OML_LN_S5");
                return true;
            }
        }
        //check if OML_LN_S23 can fire
        if ( (OML_LN_$C26_Halt <= 0) &&
                (OML_LN_$C26_FB2 >= 1) &&
                (OML_LN_Fstr_aufloesen >= 1))
        {
            if (canFire("OML_LN_S23"))
            {
                ++OML_LN_$C26_Halt;
                --OML_LN_$C26_FB2;
                fire("OML_LN_S23");
                return true;
            }
        }
        //check if OML_LN_S22 can fire
        if ( (OML_LN_$C26_FB1 >= 1) &&
                (OML_LN_$C26_Halt <= 0) &&
                (OML_LN_Fstr_aufloesen >= 1))
        {
            if (canFire("OML_LN_S22"))
            {
                --OML_LN_$C26_FB1;
                ++OML_LN_$C26_Halt;
                fire("OML_LN_S22");
                return true;
            }
        }
        //check if OML_LN_T13 can fire
        if ( (OML_LN_Fstr_aufloesen >= 1) &&
                (OML_LN_$LN_Grundstlg <= 0) &&
                (OML_LN_$C26_Halt >= 1) &&
                (OML_LN_$C1_Halt >= 1) &&
                (OML_LN_$e_Halt >= 1))
        {
            if (canFire("OML_LN_T13"))
            {
                --OML_LN_Fstr_aufloesen;
                ++OML_LN_$LN_Grundstlg;
                fire("OML_LN_T13");
                return true;
            }
        }
        //check if OML_LN_SE4 can fire
        if ( (OML_LN_$E_FB2 <= 0) &&
                (OML_LN_$LN_W5_pE3 >= 1) &&
                (OML_LN_$e_Halt >= 1))
        {
            if (canFire("OML_LN_SE4"))
            {
                ++OML_LN_$E_FB2;
                --OML_LN_$e_Halt;
                fire("OML_LN_SE4");
                return true;
            }
        }
        //check if OML_LN_SE5 can fire
        if ( (OML_LN_$LN_W5_mE4 >= 1) &&
                (OML_LN_$E_FB2 <= 0) &&
                (OML_LN_$e_Halt >= 1))
        {
            if (canFire("OML_LN_SE5"))
            {
                ++OML_LN_$E_FB2;
                --OML_LN_$e_Halt;
                fire("OML_LN_SE5");
                return true;
            }
        }
        //check if OML_LN_SE6 can fire
        if ( (OML_LN_$LN_W6_mE5 >= 1) &&
                (OML_LN_$E_FB2 <= 0) &&
                (OML_LN_$e_Halt >= 1))
        {
            if (canFire("OML_LN_SE6"))
            {
                ++OML_LN_$E_FB2;
                --OML_LN_$e_Halt;
                fire("OML_LN_SE6");
                return true;
            }
        }
        //check if OML_LN_SE7 can fire
        if ( (OML_LN_$LN_W6_mE6 >= 1) &&
                (OML_LN_$E_FB2 <= 0) &&
                (OML_LN_$e_Halt >= 1))
        {
            if (canFire("OML_LN_SE7"))
            {
                ++OML_LN_$E_FB2;
                --OML_LN_$e_Halt;
                fire("OML_LN_SE7");
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
        if ( (OML_Kontakte_$7_WS1_plus <= 0) &&
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
        //check if OML_Wecker_Weichen_T1 can fire
        if ( (OML_Wecker_Weichen_$2_Weiche <= 0) &&
                (OML_Stw_W1_$Umstellen_plus >= 1))
        {
            if (canFire("OML_Wecker_Weichen_T1"))
            {
                ++OML_Wecker_Weichen_$2_Weiche;
                fire("OML_Wecker_Weichen_T1");
                return true;
            }
        }
        //check if OML_Wecker_Weichen_T2 can fire
        if ( (OML_Wecker_Weichen_$2_Weiche <= 0) &&
                (OML_Stw_W1_$Umstellen_minus >= 1))
        {
            if (canFire("OML_Wecker_Weichen_T2"))
            {
                ++OML_Wecker_Weichen_$2_Weiche;
                fire("OML_Wecker_Weichen_T2");
                return true;
            }
        }
        //check if OML_Wecker_Weichen_T3 can fire
        if ( (OML_Wecker_Weichen_$2_Weiche >= 1) &&
                (OML_Stw_W1_$Endlage_plus <= 0))
        {
            if (canFire("OML_Wecker_Weichen_T3"))
            {
                --OML_Wecker_Weichen_$2_Weiche;
                ++OML_Stw_W1_$Endlage_plus;
                fire("OML_Wecker_Weichen_T3");
                return true;
            }
        }
        //check if OML_Wecker_Weichen_T5 can fire
        if ( (OML_Wecker_Weichen_$2_Weiche >= 1) &&
                (OML_Stw_W1_$Endlage_minus <= 0))
        {
            if (canFire("OML_Wecker_Weichen_T5"))
            {
                --OML_Wecker_Weichen_$2_Weiche;
                ++OML_Stw_W1_$Endlage_minus;
                fire("OML_Wecker_Weichen_T5");
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
        if ( (OML_logic_Kontakte_WS1_$logic_ws1_plus <= 0) &&
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
        //check if Test_OM_Tt2 can fire
        if ( (Test_OM_Fahrt_ef >= 1) &&
                (Test_OM_Fahrt_ef_end_test_ef >= 1) &&
                (Test_OM_Fahrt_fe <= 0))
        {
            if (canFire("Test_OM_Tt2"))
            {
                --Test_OM_Fahrt_ef;
                ++Test_OM_Fahrt_fe;
                fire("Test_OM_Tt2");
                return true;
            }
        }
        //check if Test_OM_Tt3 can fire
        if ( (Test_OM_Fahrt_fe >= 1) &&
                (Test_OM_W_1_minus <= 0) &&
                (Test_OM_Fahrt_fe_end_test_fe >= 1))
        {
            if (canFire("Test_OM_Tt3"))
            {
                --Test_OM_Fahrt_fe;
                ++Test_OM_W_1_minus;
                fire("Test_OM_Tt3");
                return true;
            }
        }
        //check if Test_OM_Tt5 can fire
        if ( (Test_OM_Fahrt_fg <= 0) &&
                (Test_OM_Fahrt_gf >= 1) &&
                (Test_OM_Fahrt_gf_end_test_gf >= 1))
        {
            if (canFire("Test_OM_Tt5"))
            {
                ++Test_OM_Fahrt_fg;
                --Test_OM_Fahrt_gf;
                fire("Test_OM_Tt5");
                return true;
            }
        }
        //check if Test_OM_Tt6 can fire
        if ( (Test_OM_Fahrt_fg >= 1) &&
                (Test_OM_W_1_plus <= 0) &&
                (Test_OM_Fahrt_fg_end_test_fg >= 1))
        {
            if (canFire("Test_OM_Tt6"))
            {
                --Test_OM_Fahrt_fg;
                ++Test_OM_W_1_plus;
                fire("Test_OM_Tt6");
                return true;
            }
        }
        //check if Test_OM_Tt11 can fire
        if ( (Test_OM_P12 <= 0) &&
                (OML_logic_Kontakte_WS1_$ws1_plus <= 0) &&
                (OML_logic_Kontakte_WS1_$ws1_minus <= 0) &&
                (Test_OM_P11 >= 1))
        {
            if (canFire("Test_OM_Tt11"))
            {
                ++Test_OM_P12;
                ++OML_logic_Kontakte_WS1_$ws1_plus;
                ++OML_logic_Kontakte_WS1_$ws1_minus;
                --Test_OM_P11;
                fire("Test_OM_Tt11");
                return true;
            }
        }
        //check if Test_OM_Tt12 can fire
        if ( (OML_Kontakte_$7_WS1_plus >= 1) &&
                (Test_OM_P12 >= 1) &&
                (Test_OM_Fahrt_ef <= 0))
        {
            if (canFire("Test_OM_Tt12"))
            {
                --Test_OM_P12;
                ++Test_OM_Fahrt_ef;
                fire("Test_OM_Tt12");
                return true;
            }
        }
        //check if Test_OM_Tt4 can fire
        if ( (Test_OM_Fahrt_gf <= 0) &&
                (Test_OM_W_1_minus >= 1) &&
                (Test_OM_Weiche_1_end_test_w1minus >= 1))
        {
            if (canFire("Test_OM_Tt4"))
            {
                ++Test_OM_Fahrt_gf;
                --Test_OM_W_1_minus;
                fire("Test_OM_Tt4");
                return true;
            }
        }
        //check if Test_OM_Tt7 can fire
        if ( (Test_OM_W_1_plus >= 1) &&
                (Test_OM_end_test <= 0) &&
                (Test_OM_Weiche_1_end_test_w1plus >= 1))
        {
            if (canFire("Test_OM_Tt7"))
            {
                --Test_OM_W_1_plus;
                ++Test_OM_end_test;
                fire("Test_OM_Tt7");
                return true;
            }
        }
        //check if Test_OM_T5 can fire
        if ( (Test_OM_start_test >= 1) &&
                (Test_OM_P11 <= 0))
        {
            if (canFire("Test_OM_T5"))
            {
                --Test_OM_start_test;
                ++Test_OM_P11;
                fire("Test_OM_T5");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW1 can fire
        if ( (Test_OM_Weiche_1_start <= 0) &&
                (OML_logic_Kontakte_WS1_$ws1_minus <= 0) &&
                (OML_logic_Kontakte_WS1_$ws1_plus <= 0) &&
                (Test_OM_Weiche_1_init_minus >= 1) &&
                (Test_OM_W_1_minus >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW1"))
            {
                ++Test_OM_Weiche_1_start;
                ++OML_logic_Kontakte_WS1_$ws1_minus;
                ++OML_logic_Kontakte_WS1_$ws1_plus;
                --Test_OM_Weiche_1_init_minus;
                fire("Test_OM_Weiche_1_TW1");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW2 can fire
        if ( (Test_OM_Weiche_1_start >= 1) &&
                (OML_Kontakte_$7_WS1_1 <= 0) &&
                (Test_OM_Weiche_1_PW1 <= 0) &&
                (OML_Kontakte_$7_WS1_plus >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW2"))
            {
                --Test_OM_Weiche_1_start;
                ++OML_Kontakte_$7_WS1_1;
                ++Test_OM_Weiche_1_PW1;
                fire("Test_OM_Weiche_1_TW2");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW5 can fire
        if ( (Test_OM_Weiche_1_PW2 >= 1) &&
                (Test_OM_Weiche_1_PW4 <= 0) &&
                (Test_OM_Weiche_1_PW3 <= 0))
        {
            if (canFire("Test_OM_Weiche_1_TW5"))
            {
                --Test_OM_Weiche_1_PW2;
                ++Test_OM_Weiche_1_PW4;
                ++Test_OM_Weiche_1_PW3;
                fire("Test_OM_Weiche_1_TW5");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW8 can fire
        if ( (Test_OM_Weiche_1_PW6 >= 1) &&
                (OML_Stw_W1_$Endlage_minus >= 1) &&
                (Test_OM_Weiche_1_end_test_w1minus <= 0))
        {
            if (canFire("Test_OM_Weiche_1_TW8"))
            {
                --Test_OM_Weiche_1_PW6;
                ++Test_OM_Weiche_1_end_test_w1minus;
                fire("Test_OM_Weiche_1_TW8");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW3 can fire
        if ( (OML_Kontakte_$7_WS1_1 >= 1) &&
                (Test_OM_Weiche_1_PW5 >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW3"))
            {
                --OML_Kontakte_$7_WS1_1;
                fire("Test_OM_Weiche_1_TW3");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW6 can fire
        if ( (Test_OM_Weiche_1_PW4 >= 1) &&
                (OML_Kontakte_$7_WS1_minus >= 1) &&
                (Test_OM_Weiche_1_PW5 <= 0))
        {
            if (canFire("Test_OM_Weiche_1_TW6"))
            {
                --Test_OM_Weiche_1_PW4;
                ++Test_OM_Weiche_1_PW5;
                fire("Test_OM_Weiche_1_TW6");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW4 can fire
        if ( (Test_OM_Weiche_1_PW2 <= 0) &&
                (OML_Stw_WS1_$keine_Endlage_plus >= 1) &&
                (Test_OM_Weiche_1_PW1 >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW4"))
            {
                ++Test_OM_Weiche_1_PW2;
                --Test_OM_Weiche_1_PW1;
                fire("Test_OM_Weiche_1_TW4");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_T11 can fire
        if ( (OML_logic_Kontakte_WS1_$ws1_plus >= 1) &&
                (Test_OM_Weiche_1_PW3 >= 1))
        {
            if (canFire("Test_OM_Weiche_1_T11"))
            {
                --OML_logic_Kontakte_WS1_$ws1_plus;
                --Test_OM_Weiche_1_PW3;
                fire("Test_OM_Weiche_1_T11");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW7 can fire
        if ( (OML_Stw_WS1_$endlage_minus >= 1) &&
                (Test_OM_Weiche_1_PW5 >= 1) &&
                (Test_OM_Weiche_1_PW6 <= 0))
        {
            if (canFire("Test_OM_Weiche_1_TW7"))
            {
                --Test_OM_Weiche_1_PW5;
                ++Test_OM_Weiche_1_PW6;
                fire("Test_OM_Weiche_1_TW7");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW9 can fire
        if ( (OML_Kontakte_$7_WS1_1 <= 0) &&
                (Test_OM_Weiche_1_PW11 <= 0) &&
                (OML_Kontakte_$7_WS1_minus >= 1) &&
                (Test_OM_Weiche_1_init_plus >= 1) &&
                (Test_OM_W_1_plus >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW9"))
            {
                ++OML_Kontakte_$7_WS1_1;
                ++Test_OM_Weiche_1_PW11;
                --Test_OM_Weiche_1_init_plus;
                fire("Test_OM_Weiche_1_TW9");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW10 can fire
        if ( (OML_Kontakte_$7_WS1_1 >= 1) &&
                (Test_OM_Weiche_1_PW14 >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW10"))
            {
                --OML_Kontakte_$7_WS1_1;
                fire("Test_OM_Weiche_1_TW10");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW11 can fire
        if ( (Test_OM_Weiche_1_PW11 >= 1) &&
                (Test_OM_Weiche_1_PW12 <= 0) &&
                (OML_Stw_WS1_$keine_Endlage_minus >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW11"))
            {
                --Test_OM_Weiche_1_PW11;
                ++Test_OM_Weiche_1_PW12;
                fire("Test_OM_Weiche_1_TW11");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW12 can fire
        if ( (Test_OM_Weiche_1_PW12 >= 1) &&
                (Test_OM_Weiche_1_PW13 <= 0) &&
                (OML_logic_Kontakte_WS1_$ws1_plus <= 0))
        {
            if (canFire("Test_OM_Weiche_1_TW12"))
            {
                --Test_OM_Weiche_1_PW12;
                ++Test_OM_Weiche_1_PW13;
                ++OML_logic_Kontakte_WS1_$ws1_plus;
                fire("Test_OM_Weiche_1_TW12");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW13 can fire
        if ( (Test_OM_Weiche_1_PW13 >= 1) &&
                (Test_OM_Weiche_1_PW14 <= 0) &&
                (OML_Kontakte_$7_WS1_plus >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW13"))
            {
                --Test_OM_Weiche_1_PW13;
                ++Test_OM_Weiche_1_PW14;
                fire("Test_OM_Weiche_1_TW13");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW14 can fire
        if ( (Test_OM_Weiche_1_PW14 >= 1) &&
                (Test_OM_Weiche_1_PW15 <= 0) &&
                (OML_Stw_WS1_$endlage_plus >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW14"))
            {
                --Test_OM_Weiche_1_PW14;
                ++Test_OM_Weiche_1_PW15;
                fire("Test_OM_Weiche_1_TW14");
                return true;
            }
        }
        //check if Test_OM_Weiche_1_TW15 can fire
        if ( (Test_OM_Weiche_1_end_test_w1plus <= 0) &&
                (Test_OM_Weiche_1_PW15 >= 1) &&
                (OML_Stw_W1_$Endlage_plus >= 1))
        {
            if (canFire("Test_OM_Weiche_1_TW15"))
            {
                ++Test_OM_Weiche_1_end_test_w1plus;
                --Test_OM_Weiche_1_PW15;
                fire("Test_OM_Weiche_1_TW15");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef1 can fire
        if ( (Test_OM_Fahrt_ef >= 1) &&
                (Test_OM_Fahrt_ef_Pef1 <= 0) &&
                (Test_OM_Fahrt_ef_init >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef1"))
            {
                ++Test_OM_Fahrt_ef_Pef1;
                --Test_OM_Fahrt_ef_init;
                fire("Test_OM_Fahrt_ef_Tef1");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef2 can fire
        if ( (Test_OM_Fahrt_ef_Pef1 >= 1) &&
                (OML_ILTIS_$EMM_1_833 <= 0) &&
                (Test_OM_Fahrt_ef_Pef2 <= 0))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef2"))
            {
                --Test_OM_Fahrt_ef_Pef1;
                ++OML_ILTIS_$EMM_1_833;
                ++Test_OM_Fahrt_ef_Pef2;
                fire("Test_OM_Fahrt_ef_Tef2");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef4 can fire
        if ( (Test_OM_Fahrt_ef_Pef3 <= 0) &&
                (OML_Kontakte_$8_FSS_10EG <= 0) &&
                (OML_Kontakte_$6_Gleist_EMM <= 0) &&
                (OML_EMM_$geprueft1A1 >= 1) &&
                (Test_OM_Fahrt_ef_Pef2 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef4"))
            {
                ++Test_OM_Fahrt_ef_Pef3;
                ++OML_Kontakte_$8_FSS_10EG;
                ++OML_Kontakte_$6_Gleist_EMM;
                --Test_OM_Fahrt_ef_Pef2;
                fire("Test_OM_Fahrt_ef_Tef4");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef6 can fire
        if ( (Test_OM_Fahrt_ef_Pef3 >= 1) &&
                (OML_Kontakte_$8_FSS_30EG <= 0) &&
                (Test_OM_Fahrt_ef_Pef4 <= 0) &&
                (OML_Fstr_ef_$geprueft3 >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef6"))
            {
                --Test_OM_Fahrt_ef_Pef3;
                ++OML_Kontakte_$8_FSS_30EG;
                ++Test_OM_Fahrt_ef_Pef4;
                fire("Test_OM_Fahrt_ef_Tef6");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef8 can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (OML_Kontakte_$8_FSS_45EG <= 0) &&
                (Test_OM_Fahrt_ef_Pef4 >= 1) &&
                (Test_OM_Fahrt_ef_Pef5 <= 0))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef8"))
            {
                ++OML_Kontakte_$8_FSS_45EG;
                --Test_OM_Fahrt_ef_Pef4;
                ++Test_OM_Fahrt_ef_Pef5;
                fire("Test_OM_Fahrt_ef_Tef8");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef12 can fire
        if ( (OML_Fstr_ef_$verschlossen >= 1) &&
                (OML_Fstr_ef_$E_Fahrt1 >= 1) &&
                (OML_EMM_$C_FB2 >= 1) &&
                (Test_OM_Fahrt_ef_Pef6 >= 1) &&
                (Test_OM_Fahrt_ef_Pef7 <= 0) &&
                (OML_Iso_cd_$belegen <= 0))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef12"))
            {
                --Test_OM_Fahrt_ef_Pef6;
                ++Test_OM_Fahrt_ef_Pef7;
                ++OML_Iso_cd_$belegen;
                fire("Test_OM_Fahrt_ef_Tef12");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef14 can fire
        if ( (Test_OM_Fahrt_ef_Pef7 >= 1) &&
                (OML_EMM_$EMM_Grundstlg >= 1) &&
                (Test_OM_Fahrt_ef_Pef8 <= 0) &&
                (OML_Iso_ef_$belegen <= 0))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef14"))
            {
                --Test_OM_Fahrt_ef_Pef7;
                ++Test_OM_Fahrt_ef_Pef8;
                ++OML_Iso_ef_$belegen;
                fire("Test_OM_Fahrt_ef_Tef14");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef22 can fire
        if ( (Test_OM_Fahrt_ef_Pef13 <= 0) &&
                (OML_Kontakte_$8_FSS_45EG <= 0) &&
                (Test_OM_Fahrt_ef_Pef12 >= 1) &&
                (OML_Iso_egf_$frei >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef22"))
            {
                ++Test_OM_Fahrt_ef_Pef13;
                ++OML_Kontakte_$8_FSS_45EG;
                --Test_OM_Fahrt_ef_Pef12;
                fire("Test_OM_Fahrt_ef_Tef22");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef24 can fire
        if ( (Test_OM_Fahrt_ef_Pef13 >= 1) &&
                (Test_OM_Fahrt_ef_Pef14 <= 0) &&
                (OML_Kontakte_$8_FSS_30EG <= 0) &&
                (OML_Kontakte_$8_FSS_90EG < 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef24"))
            {
                --Test_OM_Fahrt_ef_Pef13;
                ++Test_OM_Fahrt_ef_Pef14;
                ++OML_Kontakte_$8_FSS_30EG;
                fire("Test_OM_Fahrt_ef_Tef24");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef26 can fire
        if ( (Test_OM_Fahrt_ef_Pef14 >= 1) &&
                (OML_Kontakte_$8_FSS_10EG <= 0) &&
                (Test_OM_Fahrt_ef_Pef15 <= 0) &&
                (OML_Kontakte_$8_FSS_45EG < 1) &&
                (OML_Fstr_ef_$aufgeloest >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef26"))
            {
                --Test_OM_Fahrt_ef_Pef14;
                ++OML_Kontakte_$8_FSS_10EG;
                ++Test_OM_Fahrt_ef_Pef15;
                fire("Test_OM_Fahrt_ef_Tef26");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef28 can fire
        if ( (OML_Kontakte_$8_FSS_0EGF <= 0) &&
                (Test_OM_Fahrt_ef_Pef16 <= 0) &&
                (Test_OM_Fahrt_ef_Pef15 >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1) &&
                (OML_Kontakte_$8_FSS_30EG < 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef28"))
            {
                ++OML_Kontakte_$8_FSS_0EGF;
                ++Test_OM_Fahrt_ef_Pef16;
                --Test_OM_Fahrt_ef_Pef15;
                fire("Test_OM_Fahrt_ef_Tef28");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef29 can fire
        if ( (OML_ILTIS_$LN_834_1 <= 0) &&
                (Test_OM_Fahrt_ef_Pef16 >= 1) &&
                (Test_OM_Fahrt_ef_Pef17 <= 0) &&
                (OML_Kontakte_$8_FSS_10EG < 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef29"))
            {
                ++OML_ILTIS_$LN_834_1;
                --Test_OM_Fahrt_ef_Pef16;
                ++Test_OM_Fahrt_ef_Pef17;
                fire("Test_OM_Fahrt_ef_Tef29");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef31 can fire
        if ( (OML_LN_$E_FB2 >= 1) &&
                (Test_OM_Fahrt_ef_Pef18 <= 0) &&
                (OML_LN_$ce_belegt <= 0) &&
                (Test_OM_Fahrt_ef_Pef17 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef31"))
            {
                ++Test_OM_Fahrt_ef_Pef18;
                ++OML_LN_$ce_belegt;
                --Test_OM_Fahrt_ef_Pef17;
                fire("Test_OM_Fahrt_ef_Tef31");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef32 can fire
        if ( (Test_OM_Fahrt_ef_Pef18 >= 1) &&
                (OML_LN_$LN_Grundstlg >= 1) &&
                (Test_OM_Fahrt_ef_Pef19 <= 0) &&
                (OML_ILTIS_$RM_LN_OM <= 0))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef32"))
            {
                --Test_OM_Fahrt_ef_Pef18;
                ++Test_OM_Fahrt_ef_Pef19;
                ++OML_ILTIS_$RM_LN_OM;
                fire("Test_OM_Fahrt_ef_Tef32");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef33 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_n >= 1) &&
                (Test_OM_Fahrt_ef_Pef19 >= 1) &&
                (Test_OM_Fahrt_ef_end_test_ef <= 0))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef33"))
            {
                --Test_OM_Fahrt_ef_Pef19;
                ++Test_OM_Fahrt_ef_end_test_ef;
                fire("Test_OM_Fahrt_ef_Tef33");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef5 can fire
        if ( (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Kontakte_$8_FSS_30EG >= 1) &&
                (OML_Kontakte_$6_Gleist_EMM >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef5"))
            {
                --OML_Kontakte_$8_FSS_10EG;
                --OML_Kontakte_$6_Gleist_EMM;
                fire("Test_OM_Fahrt_ef_Tef5");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef13 can fire
        if ( (OML_Iso_cd_$belegen >= 1) &&
                (Test_OM_Fahrt_ef_Pef8 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef13"))
            {
                --OML_Iso_cd_$belegen;
                fire("Test_OM_Fahrt_ef_Tef13");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef16 can fire
        if ( (Test_OM_Fahrt_ef_Pef9 <= 0) &&
                (OML_Iso_1_$belegen <= 0) &&
                (Test_OM_Fahrt_ef_Pef8 >= 1) &&
                (OML_Iso_cd_$frei >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef16"))
            {
                ++Test_OM_Fahrt_ef_Pef9;
                ++OML_Iso_1_$belegen;
                --Test_OM_Fahrt_ef_Pef8;
                fire("Test_OM_Fahrt_ef_Tef16");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef19 can fire
        if ( (Test_OM_Fahrt_ef_Pef10 >= 1) &&
                (Test_OM_Fahrt_ef_Pef11 <= 0) &&
                (OML_Iso_egf_$belegen <= 0) &&
                (OML_Iso_ef_$frei >= 1) &&
                (OML_Fstr_ef_$Zug_eingefahren >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef19"))
            {
                --Test_OM_Fahrt_ef_Pef10;
                ++Test_OM_Fahrt_ef_Pef11;
                ++OML_Iso_egf_$belegen;
                fire("Test_OM_Fahrt_ef_Tef19");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef21 can fire
        if ( (Test_OM_Fahrt_ef_Pef11 >= 1) &&
                (OML_BL_OM_LN_$belegt_n >= 1) &&
                (Test_OM_Fahrt_ef_Pef12 <= 0) &&
                (OML_Iso_1_$frei >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef21"))
            {
                --Test_OM_Fahrt_ef_Pef11;
                ++Test_OM_Fahrt_ef_Pef12;
                fire("Test_OM_Fahrt_ef_Tef21");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef15 can fire
        if ( (OML_Iso_ef_$belegen >= 1) &&
                (Test_OM_Fahrt_ef_Pef10 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef15"))
            {
                --OML_Iso_ef_$belegen;
                fire("Test_OM_Fahrt_ef_Tef15");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef17 can fire
        if ( (OML_Iso_1_$belegen >= 1) &&
                (Test_OM_Fahrt_ef_Pef11 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef17"))
            {
                --OML_Iso_1_$belegen;
                fire("Test_OM_Fahrt_ef_Tef17");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef20 can fire
        if ( (OML_Iso_egf_$belegen >= 1) &&
                (Test_OM_Fahrt_ef_Pef12 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef20"))
            {
                --OML_Iso_egf_$belegen;
                fire("Test_OM_Fahrt_ef_Tef20");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef18 can fire
        if ( (Test_OM_Fahrt_ef_Pef9 >= 1) &&
                (Test_OM_Fahrt_ef_Pef10 <= 0) &&
                (OML_Fstr_ef_$Pstore_1_ef_belegt >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef18"))
            {
                --Test_OM_Fahrt_ef_Pef9;
                ++Test_OM_Fahrt_ef_Pef10;
                fire("Test_OM_Fahrt_ef_Tef18");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef23 can fire
        if ( (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (Test_OM_Fahrt_ef_Pef14 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef23"))
            {
                --OML_Kontakte_$8_FSS_45EG;
                fire("Test_OM_Fahrt_ef_Tef23");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef25 can fire
        if ( (OML_Kontakte_$8_FSS_30EG >= 1) &&
                (Test_OM_Fahrt_ef_Pef15 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef25"))
            {
                --OML_Kontakte_$8_FSS_30EG;
                fire("Test_OM_Fahrt_ef_Tef25");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef27 can fire
        if ( (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Kontakte_$8_FSS_0EGF >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef27"))
            {
                --OML_Kontakte_$8_FSS_10EG;
                fire("Test_OM_Fahrt_ef_Tef27");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef10 can fire
        if ( (Test_OM_Fahrt_ef_Pef6 <= 0) &&
                (OML_Kontakte_$8_FSS_90EG <= 0) &&
                (OML_Fstr_ef_$verschlossen >= 1) &&
                (Test_OM_Fahrt_ef_Pef5 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef10"))
            {
                ++Test_OM_Fahrt_ef_Pef6;
                ++OML_Kontakte_$8_FSS_90EG;
                --Test_OM_Fahrt_ef_Pef5;
                fire("Test_OM_Fahrt_ef_Tef10");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef11 can fire
        if ( (OML_Kontakte_$8_FSS_90EG >= 1) &&
                (Test_OM_Fahrt_ef_Pef13 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef11"))
            {
                --OML_Kontakte_$8_FSS_90EG;
                fire("Test_OM_Fahrt_ef_Tef11");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef9 can fire
        if ( (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (Test_OM_Fahrt_ef_Pef6 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef9"))
            {
                --OML_Kontakte_$8_FSS_45EG;
                fire("Test_OM_Fahrt_ef_Tef9");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef3 can fire
        if ( (OML_ILTIS_$EMM_1_833 >= 1) &&
                (Test_OM_Fahrt_ef_Pef3 >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef3"))
            {
                --OML_ILTIS_$EMM_1_833;
                fire("Test_OM_Fahrt_ef_Tef3");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef7 can fire
        if ( (OML_Kontakte_$8_FSS_30EG >= 1) &&
                (OML_Kontakte_$8_FSS_45EG >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef7"))
            {
                --OML_Kontakte_$8_FSS_30EG;
                fire("Test_OM_Fahrt_ef_Tef7");
                return true;
            }
        }
        //check if Test_OM_Fahrt_ef_Tef30 can fire
        if ( (OML_ILTIS_$LN_834_1 >= 1) &&
                (OML_LN_$ce_belegt >= 1))
        {
            if (canFire("Test_OM_Fahrt_ef_Tef30"))
            {
                --OML_ILTIS_$LN_834_1;
                fire("Test_OM_Fahrt_ef_Tef30");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe33 can fire
        if ( (OML_Kontakte_$8_FSS_10F <= 0) &&
                (Test_OM_Fahrt_fe_Pfe19 >= 1) &&
                (Test_OM_Fahrt_fe_Pfe20 <= 0) &&
                (OML_Fstr_fe_$aufgeloest >= 1) &&
                (OML_Kontakte_$8_FSS_45F < 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe33"))
            {
                ++OML_Kontakte_$8_FSS_10F;
                --Test_OM_Fahrt_fe_Pfe19;
                ++Test_OM_Fahrt_fe_Pfe20;
                fire("Test_OM_Fahrt_fe_Tfe33");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe18 can fire
        if ( (Test_OM_Fahrt_fe_Pfe9 >= 1) &&
                (OML_EMM_$D_FB1 >= 1) &&
                (Test_OM_Fahrt_fe_Pfe10 <= 0) &&
                (Test_OM_Fahrt_fe_Pfe11 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe18"))
            {
                --Test_OM_Fahrt_fe_Pfe9;
                ++Test_OM_Fahrt_fe_Pfe10;
                ++Test_OM_Fahrt_fe_Pfe11;
                fire("Test_OM_Fahrt_fe_Tfe18");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe6 can fire
        if ( (Test_OM_Fahrt_fe_Pfe4 <= 0) &&
                (OML_LN_$ce_belegt <= 0) &&
                (Test_OM_Fahrt_fe_Pfe3 >= 1) &&
                (OML_LN_$C1_FB1 >= 1) &&
                (OML_BL_OM_LN_$vorgebl_v >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe6"))
            {
                ++Test_OM_Fahrt_fe_Pfe4;
                ++OML_LN_$ce_belegt;
                --Test_OM_Fahrt_fe_Pfe3;
                fire("Test_OM_Fahrt_fe_Tfe6");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe2 can fire
        if ( (Test_OM_Fahrt_fe_Pfe2 <= 0) &&
                (Test_OM_Fahrt_fe_Pfe1 >= 1) &&
                (OML_ILTIS_$anfordern_vLN <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe2"))
            {
                ++Test_OM_Fahrt_fe_Pfe2;
                --Test_OM_Fahrt_fe_Pfe1;
                ++OML_ILTIS_$anfordern_vLN;
                fire("Test_OM_Fahrt_fe_Tfe2");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe36 can fire
        if ( (Test_OM_Fahrt_fe_Pfe21 >= 1) &&
                (Test_OM_Fahrt_fe_Pfe22 <= 0) &&
                (OML_Kontakte_$6_RM_nLN <= 0) &&
                (OML_BL_OM_LN_$RMM_nLN >= 1) &&
                (OML_Kontakte_$8_FSS_10F < 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe36"))
            {
                --Test_OM_Fahrt_fe_Pfe21;
                ++Test_OM_Fahrt_fe_Pfe22;
                ++OML_Kontakte_$6_RM_nLN;
                fire("Test_OM_Fahrt_fe_Tfe36");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe14 can fire
        if ( (Test_OM_Fahrt_fe_Pfe8 <= 0) &&
                (OML_Fstr_fe_$verschlossen >= 1) &&
                (Test_OM_Fahrt_fe_Pfe7 >= 1) &&
                (OML_Kontakte_$8_FSS_90F <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe14"))
            {
                ++Test_OM_Fahrt_fe_Pfe8;
                --Test_OM_Fahrt_fe_Pfe7;
                ++OML_Kontakte_$8_FSS_90F;
                fire("Test_OM_Fahrt_fe_Tfe14");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe12 can fire
        if ( (Test_OM_Fahrt_fe_Pfe6 >= 1) &&
                (Test_OM_Fahrt_fe_Pfe7 <= 0) &&
                (OML_Kontakte_$8_FSS_45F <= 0) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe12"))
            {
                --Test_OM_Fahrt_fe_Pfe6;
                ++Test_OM_Fahrt_fe_Pfe7;
                ++OML_Kontakte_$8_FSS_45F;
                fire("Test_OM_Fahrt_fe_Tfe12");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe28 can fire
        if ( (Test_OM_Fahrt_fe_Pfe16 >= 1) &&
                (OML_EMM_$EMM_Grundstlg >= 1) &&
                (OML_Iso_ef_$frei >= 1) &&
                (Test_OM_Fahrt_fe_Pfe17 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe28"))
            {
                --Test_OM_Fahrt_fe_Pfe16;
                ++Test_OM_Fahrt_fe_Pfe17;
                fire("Test_OM_Fahrt_fe_Tfe28");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe31 can fire
        if ( (Test_OM_Fahrt_fe_Pfe18 >= 1) &&
                (OML_Kontakte_$8_FSS_30F <= 0) &&
                (Test_OM_Fahrt_fe_Pfe19 <= 0) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Kontakte_$8_FSS_90F < 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe31"))
            {
                --Test_OM_Fahrt_fe_Pfe18;
                ++OML_Kontakte_$8_FSS_30F;
                ++Test_OM_Fahrt_fe_Pfe19;
                fire("Test_OM_Fahrt_fe_Tfe31");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe24 can fire
        if ( (Test_OM_Fahrt_fe_Pfe14 >= 1) &&
                (OML_Fstr_fe_$Zug_eingefahren >= 1) &&
                (OML_Iso_egf_$frei >= 1) &&
                (OML_Iso_ef_$belegen <= 0) &&
                (Test_OM_Fahrt_fe_Pfe15 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe24"))
            {
                --Test_OM_Fahrt_fe_Pfe14;
                ++OML_Iso_ef_$belegen;
                ++Test_OM_Fahrt_fe_Pfe15;
                fire("Test_OM_Fahrt_fe_Tfe24");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe16 can fire
        if ( (Test_OM_Fahrt_fe_Pfe8 >= 1) &&
                (OML_Fstr_fe_$F_Fahrt1 >= 1) &&
                (Test_OM_Fahrt_fe_Pfe9 <= 0) &&
                (OML_ILTIS_$EMM_833_2 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe16"))
            {
                --Test_OM_Fahrt_fe_Pfe8;
                ++Test_OM_Fahrt_fe_Pfe9;
                ++OML_ILTIS_$EMM_833_2;
                fire("Test_OM_Fahrt_fe_Tfe16");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe1 can fire
        if ( (Test_OM_Fahrt_fe_init >= 1) &&
                (Test_OM_Fahrt_fe >= 1) &&
                (Test_OM_Fahrt_fe_Pfe1 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe1"))
            {
                --Test_OM_Fahrt_fe_init;
                ++Test_OM_Fahrt_fe_Pfe1;
                fire("Test_OM_Fahrt_fe_Tfe1");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe35 can fire
        if ( (Test_OM_Fahrt_fe_Pfe21 <= 0) &&
                (OML_Kontakte_$8_FSS_0EGF <= 0) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1) &&
                (Test_OM_Fahrt_fe_Pfe20 >= 1) &&
                (OML_Kontakte_$8_FSS_30F < 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe35"))
            {
                ++Test_OM_Fahrt_fe_Pfe21;
                ++OML_Kontakte_$8_FSS_0EGF;
                --Test_OM_Fahrt_fe_Pfe20;
                fire("Test_OM_Fahrt_fe_Tfe35");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe10 can fire
        if ( (OML_Fstr_fe_$geprueft3 >= 1) &&
                (Test_OM_Fahrt_fe_Pfe6 <= 0) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Kontakte_$8_FSS_30F <= 0) &&
                (Test_OM_Fahrt_fe_Pfe5 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe10"))
            {
                ++Test_OM_Fahrt_fe_Pfe6;
                ++OML_Kontakte_$8_FSS_30F;
                --Test_OM_Fahrt_fe_Pfe5;
                fire("Test_OM_Fahrt_fe_Tfe10");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe8 can fire
        if ( (OML_BL_OM_LN_$belegt_v >= 1) &&
                (OML_Kontakte_$8_FSS_10F <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_Kontakte_$6_Gleist_EMM <= 0) &&
                (Test_OM_Fahrt_fe_Pfe5 <= 0) &&
                (Test_OM_Fahrt_fe_Pfe4 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe8"))
            {
                ++OML_Kontakte_$8_FSS_10F;
                ++OML_Kontakte_$6_Gleist_EMM;
                ++Test_OM_Fahrt_fe_Pfe5;
                --Test_OM_Fahrt_fe_Pfe4;
                fire("Test_OM_Fahrt_fe_Tfe8");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe21 can fire
        if ( (Test_OM_Fahrt_fe_Pfe12 >= 1) &&
                (OML_Iso_1_$belegen <= 0) &&
                (Test_OM_Fahrt_fe_Pfe13 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe21"))
            {
                --Test_OM_Fahrt_fe_Pfe12;
                ++OML_Iso_1_$belegen;
                ++Test_OM_Fahrt_fe_Pfe13;
                fire("Test_OM_Fahrt_fe_Tfe21");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe29 can fire
        if ( (Test_OM_Fahrt_fe_Pfe18 <= 0) &&
                (OML_Kontakte_$8_FSS_45F <= 0) &&
                (Test_OM_Fahrt_fe_Pfe17 >= 1) &&
                (OML_Iso_cd_$frei >= 1) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_aus >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe29"))
            {
                ++Test_OM_Fahrt_fe_Pfe18;
                ++OML_Kontakte_$8_FSS_45F;
                --Test_OM_Fahrt_fe_Pfe17;
                fire("Test_OM_Fahrt_fe_Tfe29");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe19 can fire
        if ( (Test_OM_Fahrt_fe_Pfe12 <= 0) &&
                (OML_Iso_egf_$belegen <= 0) &&
                (Test_OM_Fahrt_fe_Pfe11 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe19"))
            {
                ++Test_OM_Fahrt_fe_Pfe12;
                ++OML_Iso_egf_$belegen;
                --Test_OM_Fahrt_fe_Pfe11;
                fire("Test_OM_Fahrt_fe_Tfe19");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe4 can fire
        if ( (OML_ILTIS_$LN_1_834 <= 0) &&
                (Test_OM_Fahrt_fe_Pfe2 >= 1) &&
                (Test_OM_Fahrt_fe_Pfe3 <= 0) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe4"))
            {
                ++OML_ILTIS_$LN_1_834;
                --Test_OM_Fahrt_fe_Pfe2;
                ++Test_OM_Fahrt_fe_Pfe3;
                fire("Test_OM_Fahrt_fe_Tfe4");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe26 can fire
        if ( (OML_Iso_1_$frei >= 1) &&
                (Test_OM_Fahrt_fe_Pfe16 <= 0) &&
                (OML_Iso_cd_$belegen <= 0) &&
                (Test_OM_Fahrt_fe_Pfe15 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe26"))
            {
                ++Test_OM_Fahrt_fe_Pfe16;
                ++OML_Iso_cd_$belegen;
                --Test_OM_Fahrt_fe_Pfe15;
                fire("Test_OM_Fahrt_fe_Tfe26");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe7 can fire
        if ( (OML_LN_$LN_Grundstlg >= 1) &&
                (OML_LN_$ce_belegt >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe7"))
            {
                --OML_LN_$ce_belegt;
                fire("Test_OM_Fahrt_fe_Tfe7");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe5 can fire
        if ( (OML_ILTIS_$LN_1_834 >= 1) &&
                (OML_LN_$ce_belegt >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe5"))
            {
                --OML_ILTIS_$LN_1_834;
                fire("Test_OM_Fahrt_fe_Tfe5");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe9 can fire
        if ( (OML_Kontakte_$8_FSS_10F >= 1) &&
                (OML_Kontakte_$8_FSS_30F >= 1) &&
                (OML_Kontakte_$6_Gleist_EMM >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe9"))
            {
                --OML_Kontakte_$8_FSS_10F;
                --OML_Kontakte_$6_Gleist_EMM;
                fire("Test_OM_Fahrt_fe_Tfe9");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe11 can fire
        if ( (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Kontakte_$8_FSS_30F >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe11"))
            {
                --OML_Kontakte_$8_FSS_30F;
                fire("Test_OM_Fahrt_fe_Tfe11");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe13 can fire
        if ( (OML_Kontakte_$8_FSS_45F >= 1) &&
                (Test_OM_Fahrt_fe_Pfe8 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe13"))
            {
                --OML_Kontakte_$8_FSS_45F;
                fire("Test_OM_Fahrt_fe_Tfe13");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe15 can fire
        if ( (OML_Kontakte_$8_FSS_90F >= 1) &&
                (Test_OM_Fahrt_fe_Pfe18 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe15"))
            {
                --OML_Kontakte_$8_FSS_90F;
                fire("Test_OM_Fahrt_fe_Tfe15");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe17 can fire
        if ( (OML_ILTIS_$EMM_833_2 >= 1) &&
                (Test_OM_Fahrt_fe_Pfe10 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe17"))
            {
                --OML_ILTIS_$EMM_833_2;
                --Test_OM_Fahrt_fe_Pfe10;
                fire("Test_OM_Fahrt_fe_Tfe17");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe20 can fire
        if ( (OML_Iso_egf_$belegen >= 1) &&
                (Test_OM_Fahrt_fe_Pfe14 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe20"))
            {
                --OML_Iso_egf_$belegen;
                fire("Test_OM_Fahrt_fe_Tfe20");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe22 can fire
        if ( (OML_Iso_1_$belegen >= 1) &&
                (Test_OM_Fahrt_fe_Pfe15 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe22"))
            {
                --OML_Iso_1_$belegen;
                fire("Test_OM_Fahrt_fe_Tfe22");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe25 can fire
        if ( (OML_Iso_ef_$belegen >= 1) &&
                (Test_OM_Fahrt_fe_Pfe16 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe25"))
            {
                --OML_Iso_ef_$belegen;
                fire("Test_OM_Fahrt_fe_Tfe25");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe27 can fire
        if ( (OML_Iso_cd_$belegen >= 1) &&
                (Test_OM_Fahrt_fe_Pfe17 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe27"))
            {
                --OML_Iso_cd_$belegen;
                fire("Test_OM_Fahrt_fe_Tfe27");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe30 can fire
        if ( (OML_Kontakte_$8_FSS_45F >= 1) &&
                (Test_OM_Fahrt_fe_Pfe19 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe30"))
            {
                --OML_Kontakte_$8_FSS_45F;
                fire("Test_OM_Fahrt_fe_Tfe30");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe32 can fire
        if ( (OML_Kontakte_$8_FSS_30F >= 1) &&
                (Test_OM_Fahrt_fe_Pfe20 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe32"))
            {
                --OML_Kontakte_$8_FSS_30F;
                fire("Test_OM_Fahrt_fe_Tfe32");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe34 can fire
        if ( (OML_Kontakte_$8_FSS_10F >= 1) &&
                (OML_Kontakte_$8_FSS_0EGF >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe34"))
            {
                --OML_Kontakte_$8_FSS_10F;
                fire("Test_OM_Fahrt_fe_Tfe34");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe37 can fire
        if ( (Test_OM_Fahrt_fe_Pfe23 >= 1) &&
                (OML_Kontakte_$6_RM_nLN >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe37"))
            {
                --Test_OM_Fahrt_fe_Pfe23;
                --OML_Kontakte_$6_RM_nLN;
                fire("Test_OM_Fahrt_fe_Tfe37");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe38 can fire
        if ( (Test_OM_Fahrt_fe_Pfe22 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (Test_OM_Fahrt_fe_end_test_fe <= 0) &&
                (Test_OM_Fahrt_fe_Pfe23 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe38"))
            {
                --Test_OM_Fahrt_fe_Pfe22;
                ++Test_OM_Fahrt_fe_end_test_fe;
                ++Test_OM_Fahrt_fe_Pfe23;
                fire("Test_OM_Fahrt_fe_Tfe38");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe23 can fire
        if ( (Test_OM_Fahrt_fe_Pfe13 >= 1) &&
                (OML_Fstr_fe_$store_1_egf_belegt >= 1) &&
                (Test_OM_Fahrt_fe_Pfe14 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe23"))
            {
                --Test_OM_Fahrt_fe_Pfe13;
                ++Test_OM_Fahrt_fe_Pfe14;
                fire("Test_OM_Fahrt_fe_Tfe23");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_Tfe3 can fire
        if ( (OML_ILTIS_$anfordern_vLN >= 1) &&
                (OML_ILTIS_$LN_1_834 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_Tfe3"))
            {
                --OML_ILTIS_$anfordern_vLN;
                fire("Test_OM_Fahrt_fe_Tfe3");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fe_T1 can fire
        if ( (OML_Kontakte_$8_FSS_0EGF >= 1) &&
                (OML_Kontakte_$8_FSS_10F >= 1))
        {
            if (canFire("Test_OM_Fahrt_fe_T1"))
            {
                fire("Test_OM_Fahrt_fe_T1");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf33 can fire
        if ( (Test_OM_Fahrt_gf_Pgf20 >= 1) &&
                (OML_Kontakte_$8_FSS_10EG < 1) &&
                (Test_OM_Fahrt_gf_Pgf21 <= 0) &&
                (OML_ILTIS_$LN_834_1 <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf33"))
            {
                --Test_OM_Fahrt_gf_Pgf20;
                ++Test_OM_Fahrt_gf_Pgf21;
                ++OML_ILTIS_$LN_834_1;
                fire("Test_OM_Fahrt_gf_Tgf33");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf19 can fire
        if ( (Test_OM_Fahrt_gf_Pgf11 >= 1) &&
                (Test_OM_Fahrt_gf_Pgf12 <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf19"))
            {
                --Test_OM_Fahrt_gf_Pgf11;
                ++Test_OM_Fahrt_gf_Pgf12;
                fire("Test_OM_Fahrt_gf_Tgf19");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf7 can fire
        if ( (OML_BL_ZB_OM_$vorgebl_v >= 1) &&
                (OML_ZB_$C_FB1 >= 1) &&
                (Test_OM_Fahrt_gf_Pgf5 >= 1) &&
                (OML_ZB_$cd_belegt <= 0) &&
                (Test_OM_Fahrt_gf_Pgf6 <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf7"))
            {
                --Test_OM_Fahrt_gf_Pgf5;
                ++OML_ZB_$cd_belegt;
                ++Test_OM_Fahrt_gf_Pgf6;
                fire("Test_OM_Fahrt_gf_Tgf7");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf2 can fire
        if ( (Test_OM_Fahrt_gf_Pgf2 <= 0) &&
                (OML_ILTIS_$anfordern_vZB <= 0) &&
                (Test_OM_Fahrt_gf_Pgf1 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf2"))
            {
                ++Test_OM_Fahrt_gf_Pgf2;
                ++OML_ILTIS_$anfordern_vZB;
                --Test_OM_Fahrt_gf_Pgf1;
                fire("Test_OM_Fahrt_gf_Tgf2");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf37 can fire
        if ( (Test_OM_Fahrt_gf_Pgf22 >= 1) &&
                (OML_LN_$LN_Grundstlg >= 1) &&
                (Test_OM_Fahrt_gf_Pgf23 <= 0) &&
                (OML_ILTIS_$RM_LN_OM <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf37"))
            {
                --Test_OM_Fahrt_gf_Pgf22;
                ++Test_OM_Fahrt_gf_Pgf23;
                ++OML_ILTIS_$RM_LN_OM;
                fire("Test_OM_Fahrt_gf_Tgf37");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf15 can fire
        if ( (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1) &&
                (Test_OM_Fahrt_gf_Pgf9 >= 1) &&
                (OML_Kontakte_$8_FSS_45EG <= 0) &&
                (Test_OM_Fahrt_gf_Pgf10 <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf15"))
            {
                --Test_OM_Fahrt_gf_Pgf9;
                ++OML_Kontakte_$8_FSS_45EG;
                ++Test_OM_Fahrt_gf_Pgf10;
                fire("Test_OM_Fahrt_gf_Tgf15");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf13 can fire
        if ( (OML_Fstr_gf_$geprueft3 >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (Test_OM_Fahrt_gf_Pgf8 >= 1) &&
                (OML_Kontakte_$8_FSS_30EG <= 0) &&
                (Test_OM_Fahrt_gf_Pgf9 <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf13"))
            {
                --Test_OM_Fahrt_gf_Pgf8;
                ++OML_Kontakte_$8_FSS_30EG;
                ++Test_OM_Fahrt_gf_Pgf9;
                fire("Test_OM_Fahrt_gf_Tgf13");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf28 can fire
        if ( (Test_OM_Fahrt_gf_Pgf17 >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Kontakte_$8_FSS_90EG < 1) &&
                (Test_OM_Fahrt_gf_Pgf18 <= 0) &&
                (OML_Kontakte_$8_FSS_30EG <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf28"))
            {
                --Test_OM_Fahrt_gf_Pgf17;
                ++Test_OM_Fahrt_gf_Pgf18;
                ++OML_Kontakte_$8_FSS_30EG;
                fire("Test_OM_Fahrt_gf_Tgf28");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf32 can fire
        if ( (Test_OM_Fahrt_gf_Pgf19 >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus < 1) &&
                (OML_Kontakte_$8_FSS_30EG >= 1) &&
                (OML_Kontakte_$8_FSS_0EGF <= 0) &&
                (Test_OM_Fahrt_gf_Pgf20 <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf32"))
            {
                --Test_OM_Fahrt_gf_Pgf19;
                ++OML_Kontakte_$8_FSS_0EGF;
                ++Test_OM_Fahrt_gf_Pgf20;
                fire("Test_OM_Fahrt_gf_Tgf32");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf25 can fire
        if ( (OML_Iso_1_$frei >= 1) &&
                (Test_OM_Fahrt_gf_Pgf15 >= 1) &&
                (OML_Fstr_gf_$Zug_eingefahren >= 1) &&
                (Test_OM_Fahrt_gf_Pgf16 <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf25"))
            {
                --Test_OM_Fahrt_gf_Pgf15;
                ++Test_OM_Fahrt_gf_Pgf16;
                fire("Test_OM_Fahrt_gf_Tgf25");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf17 can fire
        if ( (Test_OM_Fahrt_gf_Pgf10 >= 1) &&
                (OML_Fstr_gf_$verschlossen >= 1) &&
                (Test_OM_Fahrt_gf_Pgf11 <= 0) &&
                (OML_Kontakte_$8_FSS_90EG <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf17"))
            {
                --Test_OM_Fahrt_gf_Pgf10;
                ++Test_OM_Fahrt_gf_Pgf11;
                ++OML_Kontakte_$8_FSS_90EG;
                fire("Test_OM_Fahrt_gf_Tgf17");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf1 can fire
        if ( (Test_OM_Fahrt_gf >= 1) &&
                (Test_OM_Fahrt_gf_Pgf1 <= 0) &&
                (Test_OM_Fahrt_gf_init >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf1"))
            {
                ++Test_OM_Fahrt_gf_Pgf1;
                --Test_OM_Fahrt_gf_init;
                fire("Test_OM_Fahrt_gf_Tgf1");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf35 can fire
        if ( (Test_OM_Fahrt_gf_Pgf21 >= 1) &&
                (OML_LN_$E_FB2 >= 1) &&
                (OML_BL_ZB_OM_$RMM_nZB >= 1) &&
                (Test_OM_Fahrt_gf_Pgf22 <= 0) &&
                (OML_LN_$ce_belegt <= 0) &&
                (OML_Kontakte_$6_RM_nZB <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf35"))
            {
                --Test_OM_Fahrt_gf_Pgf21;
                ++Test_OM_Fahrt_gf_Pgf22;
                ++OML_LN_$ce_belegt;
                ++OML_Kontakte_$6_RM_nZB;
                fire("Test_OM_Fahrt_gf_Tgf35");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf11 can fire
        if ( (Test_OM_Fahrt_gf_Pgf7 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n >= 1) &&
                (OML_Kontakte_$8_FSS_10EG <= 0) &&
                (Test_OM_Fahrt_gf_Pgf8 <= 0) &&
                (OML_Kontakte_$6_Gleist_ZB <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf11"))
            {
                --Test_OM_Fahrt_gf_Pgf7;
                ++OML_Kontakte_$8_FSS_10EG;
                ++Test_OM_Fahrt_gf_Pgf8;
                ++OML_Kontakte_$6_Gleist_ZB;
                fire("Test_OM_Fahrt_gf_Tgf11");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf9 can fire
        if ( (OML_ZB_$ZB_Grundstlg >= 1) &&
                (Test_OM_Fahrt_gf_Pgf7 <= 0) &&
                (OML_Kontakte_$6_FBA_nLN <= 0) &&
                (Test_OM_Fahrt_gf_Pgf6 >= 1) &&
                (OML_BL_ZB_OM_$belegt_v >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf9"))
            {
                ++Test_OM_Fahrt_gf_Pgf7;
                ++OML_Kontakte_$6_FBA_nLN;
                --Test_OM_Fahrt_gf_Pgf6;
                fire("Test_OM_Fahrt_gf_Tgf9");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf22 can fire
        if ( (Test_OM_Fahrt_gf_Pgf13 >= 1) &&
                (OML_Fstr_fg_$F_Halt >= 1) &&
                (Test_OM_Fahrt_gf_Pgf14 <= 0) &&
                (OML_Iso_egf_$belegen <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf22"))
            {
                --Test_OM_Fahrt_gf_Pgf13;
                ++Test_OM_Fahrt_gf_Pgf14;
                ++OML_Iso_egf_$belegen;
                fire("Test_OM_Fahrt_gf_Tgf22");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf30 can fire
        if ( (Test_OM_Fahrt_gf_Pgf18 >= 1) &&
                (OML_Fstr_gf_$aufgeloest >= 1) &&
                (OML_Kontakte_$8_FSS_45EG < 1) &&
                (Test_OM_Fahrt_gf_Pgf19 <= 0) &&
                (OML_Kontakte_$8_FSS_10EG <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf30"))
            {
                --Test_OM_Fahrt_gf_Pgf18;
                ++Test_OM_Fahrt_gf_Pgf19;
                ++OML_Kontakte_$8_FSS_10EG;
                fire("Test_OM_Fahrt_gf_Tgf30");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf20 can fire
        if ( (Test_OM_Fahrt_gf_Pgf12 >= 1) &&
                (OML_Fstr_gf_$G_Fahrt3 >= 1) &&
                (OML_BL_OM_LN_$vorgebl_n >= 1) &&
                (Test_OM_Fahrt_gf_Pgf13 <= 0) &&
                (OML_Iso_1_$belegen <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf20"))
            {
                --Test_OM_Fahrt_gf_Pgf12;
                ++Test_OM_Fahrt_gf_Pgf13;
                ++OML_Iso_1_$belegen;
                fire("Test_OM_Fahrt_gf_Tgf20");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf4 can fire
        if ( (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
                (Test_OM_Fahrt_gf_Pgf3 <= 0) &&
                (OML_ILTIS_$ZB_2_138 <= 0) &&
                (Test_OM_Fahrt_gf_Pgf2 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf4"))
            {
                ++Test_OM_Fahrt_gf_Pgf3;
                ++OML_ILTIS_$ZB_2_138;
                --Test_OM_Fahrt_gf_Pgf2;
                fire("Test_OM_Fahrt_gf_Tgf4");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf26 can fire
        if ( (Test_OM_Fahrt_gf_Pgf16 >= 1) &&
                (OML_Iso_egf_$frei >= 1) &&
                (Test_OM_Fahrt_gf_Pgf17 <= 0) &&
                (OML_Kontakte_$8_FSS_45EG <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf26"))
            {
                --Test_OM_Fahrt_gf_Pgf16;
                ++Test_OM_Fahrt_gf_Pgf17;
                ++OML_Kontakte_$8_FSS_45EG;
                fire("Test_OM_Fahrt_gf_Tgf26");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf5 can fire
        if ( (OML_ILTIS_$ZB_2_138 >= 1) &&
                (Test_OM_Fahrt_gf_Pgf4 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf5"))
            {
                --OML_ILTIS_$ZB_2_138;
                --Test_OM_Fahrt_gf_Pgf4;
                fire("Test_OM_Fahrt_gf_Tgf5");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf3 can fire
        if ( (OML_ILTIS_$ZB_2_138 >= 1) &&
                (OML_ILTIS_$anfordern_vZB >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf3"))
            {
                --OML_ILTIS_$anfordern_vZB;
                fire("Test_OM_Fahrt_gf_Tgf3");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf8 can fire
        if ( (OML_Kontakte_$6_FBA_nLN >= 1) &&
                (OML_ZB_$cd_belegt >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf8"))
            {
                --OML_ZB_$cd_belegt;
                fire("Test_OM_Fahrt_gf_Tgf8");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf10 can fire
        if ( (OML_Kontakte_$6_FBA_nLN >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf10"))
            {
                --OML_Kontakte_$6_FBA_nLN;
                fire("Test_OM_Fahrt_gf_Tgf10");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf12 can fire
        if ( (OML_Kontakte_$6_Gleist_ZB >= 1) &&
                (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Kontakte_$8_FSS_30EG >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf12"))
            {
                --OML_Kontakte_$8_FSS_10EG;
                fire("Test_OM_Fahrt_gf_Tgf12");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf14 can fire
        if ( (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (OML_Kontakte_$8_FSS_30EG >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf14"))
            {
                --OML_Kontakte_$8_FSS_30EG;
                fire("Test_OM_Fahrt_gf_Tgf14");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf16 can fire
        if ( (OML_Kontakte_$8_FSS_45EG >= 1) &&
                (Test_OM_Fahrt_gf_Pgf11 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf16"))
            {
                --OML_Kontakte_$8_FSS_45EG;
                fire("Test_OM_Fahrt_gf_Tgf16");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf18 can fire
        if ( (OML_Kontakte_$8_FSS_90EG >= 1) &&
                (Test_OM_Fahrt_gf_Pgf17 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf18"))
            {
                --OML_Kontakte_$8_FSS_90EG;
                fire("Test_OM_Fahrt_gf_Tgf18");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf21 can fire
        if ( (OML_Iso_1_$belegen >= 1) &&
                (Test_OM_Fahrt_gf_Pgf15 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf21"))
            {
                --OML_Iso_1_$belegen;
                fire("Test_OM_Fahrt_gf_Tgf21");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf23 can fire
        if ( (OML_Iso_egf_$belegen >= 1) &&
                (Test_OM_Fahrt_gf_Pgf16 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf23"))
            {
                --OML_Iso_egf_$belegen;
                fire("Test_OM_Fahrt_gf_Tgf23");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf27 can fire
        if ( (Test_OM_Fahrt_gf_Pgf18 >= 1) &&
                (OML_Kontakte_$8_FSS_45EG >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf27"))
            {
                --OML_Kontakte_$8_FSS_45EG;
                fire("Test_OM_Fahrt_gf_Tgf27");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf29 can fire
        if ( (OML_Kontakte_$8_FSS_30EG >= 1) &&
                (Test_OM_Fahrt_gf_Pgf19 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf29"))
            {
                --OML_Kontakte_$8_FSS_30EG;
                fire("Test_OM_Fahrt_gf_Tgf29");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf31 can fire
        if ( (OML_Kontakte_$8_FSS_10EG >= 1) &&
                (OML_Kontakte_$8_FSS_0EGF >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf31"))
            {
                --OML_Kontakte_$8_FSS_10EG;
                fire("Test_OM_Fahrt_gf_Tgf31");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf39 can fire
        if ( (Test_OM_Fahrt_gf_Pgf23 >= 1) &&
                (OML_BL_OM_LN_$Grundstlg_n >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v >= 1) &&
                (Test_OM_Fahrt_gf_Pgf24 <= 0) &&
                (Test_OM_Fahrt_gf_end_test_gf <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf39"))
            {
                --Test_OM_Fahrt_gf_Pgf23;
                ++Test_OM_Fahrt_gf_Pgf24;
                ++Test_OM_Fahrt_gf_end_test_gf;
                fire("Test_OM_Fahrt_gf_Tgf39");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf34 can fire
        if ( (OML_LN_$ce_belegt >= 1) &&
                (OML_ILTIS_$LN_834_1 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf34"))
            {
                --OML_ILTIS_$LN_834_1;
                fire("Test_OM_Fahrt_gf_Tgf34");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf36 can fire
        if ( (OML_Kontakte_$6_RM_nZB >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_v >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf36"))
            {
                --OML_Kontakte_$6_RM_nZB;
                fire("Test_OM_Fahrt_gf_Tgf36");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf38 can fire
        if ( (OML_ILTIS_$RM_LN_OM >= 1) &&
                (Test_OM_Fahrt_gf_Pgf24 >= 1))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf38"))
            {
                --OML_ILTIS_$RM_LN_OM;
                fire("Test_OM_Fahrt_gf_Tgf38");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf6 can fire
        if ( (Test_OM_Fahrt_gf_Pgf3 >= 1) &&
                (OML_ZB_$ZB_W1_pA2 >= 1) &&
                (Test_OM_Fahrt_gf_Pgf5 <= 0) &&
                (Test_OM_Fahrt_gf_Pgf4 <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf6"))
            {
                --Test_OM_Fahrt_gf_Pgf3;
                ++Test_OM_Fahrt_gf_Pgf5;
                ++Test_OM_Fahrt_gf_Pgf4;
                fire("Test_OM_Fahrt_gf_Tgf6");
                return true;
            }
        }
        //check if Test_OM_Fahrt_gf_Tgf24 can fire
        if ( (Test_OM_Fahrt_gf_Pgf14 >= 1) &&
                (OML_Fstr_gf_$store_1_belegt >= 1) &&
                (Test_OM_Fahrt_gf_Pgf15 <= 0))
        {
            if (canFire("Test_OM_Fahrt_gf_Tgf24"))
            {
                --Test_OM_Fahrt_gf_Pgf14;
                ++Test_OM_Fahrt_gf_Pgf15;
                fire("Test_OM_Fahrt_gf_Tgf24");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg34 can fire
        if ( (Test_OM_Fahrt_fg_Pfg20 >= 1) &&
                (OML_Kontakte_$8_FSS_10F < 1) &&
                (OML_BL_OM_LN_$RMM_nLN >= 1) &&
                (OML_Kontakte_$6_RM_nLN <= 0) &&
                (Test_OM_Fahrt_fg_Pfg21 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg34"))
            {
                --Test_OM_Fahrt_fg_Pfg20;
                ++OML_Kontakte_$6_RM_nLN;
                ++Test_OM_Fahrt_fg_Pfg21;
                fire("Test_OM_Fahrt_fg_Tfg34");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg20 can fire
        if ( (Test_OM_Fahrt_fg_Pfg10 >= 1) &&
                (OML_ZB_$D_FB1 >= 1) &&
                (Test_OM_Fahrt_fg_Pfg11 <= 0) &&
                (Test_OM_Fahrt_fg_Pfg12 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg20"))
            {
                --Test_OM_Fahrt_fg_Pfg10;
                ++Test_OM_Fahrt_fg_Pfg11;
                ++Test_OM_Fahrt_fg_Pfg12;
                fire("Test_OM_Fahrt_fg_Tfg20");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg6 can fire
        if ( (OML_BL_OM_LN_$vorgebl_v >= 1) &&
                (OML_LN_$C1_FB1 >= 1) &&
                (OML_LN_$ce_belegt <= 0) &&
                (Test_OM_Fahrt_fg_Pfg3 >= 1) &&
                (OML_Kontakte_$6_FBA_nZB <= 0) &&
                (Test_OM_Fahrt_fg_Pfg4 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg6"))
            {
                ++OML_LN_$ce_belegt;
                --Test_OM_Fahrt_fg_Pfg3;
                ++OML_Kontakte_$6_FBA_nZB;
                ++Test_OM_Fahrt_fg_Pfg4;
                fire("Test_OM_Fahrt_fg_Tfg6");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg2 can fire
        if ( (Test_OM_Fahrt_fg_Pfg2 <= 0) &&
                (OML_ILTIS_$anfordern_vLN <= 0) &&
                (Test_OM_Fahrt_fg_Pfg1 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg2"))
            {
                ++Test_OM_Fahrt_fg_Pfg2;
                ++OML_ILTIS_$anfordern_vLN;
                --Test_OM_Fahrt_fg_Pfg1;
                fire("Test_OM_Fahrt_fg_Tfg2");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg38 can fire
        if ( (Test_OM_Fahrt_fg_Pfg23 >= 1) &&
                (OML_ZB_$ZB_Grundstlg >= 1) &&
                (OML_ILTIS_$RM_ZB_OM <= 0) &&
                (Test_OM_Fahrt_fg_Pfg24 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg38"))
            {
                --Test_OM_Fahrt_fg_Pfg23;
                ++OML_ILTIS_$RM_ZB_OM;
                ++Test_OM_Fahrt_fg_Pfg24;
                fire("Test_OM_Fahrt_fg_Tfg38");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg16 can fire
        if ( (Test_OM_Fahrt_fg_Pfg8 >= 1) &&
                (OML_Fstr_fg_$verschlossen >= 1) &&
                (Test_OM_Fahrt_fg_Pfg9 <= 0) &&
                (OML_Kontakte_$8_FSS_90F <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg16"))
            {
                --Test_OM_Fahrt_fg_Pfg8;
                ++Test_OM_Fahrt_fg_Pfg9;
                ++OML_Kontakte_$8_FSS_90F;
                fire("Test_OM_Fahrt_fg_Tfg16");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg14 can fire
        if ( (Test_OM_Fahrt_fg_Pfg8 <= 0) &&
                (Test_OM_Fahrt_fg_Pfg7 >= 1) &&
                (OML_Kontakte_$8_FSS_45F <= 0) &&
                (OML_Stw_FSS_KSM_$FSS_Kuppelm_ein >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg14"))
            {
                ++Test_OM_Fahrt_fg_Pfg8;
                --Test_OM_Fahrt_fg_Pfg7;
                ++OML_Kontakte_$8_FSS_45F;
                fire("Test_OM_Fahrt_fg_Tfg14");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg29 can fire
        if ( (Test_OM_Fahrt_fg_Pfg18 <= 0) &&
                (Test_OM_Fahrt_fg_Pfg17 >= 1) &&
                (OML_Kontakte_$8_FSS_30F <= 0) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Kontakte_$8_FSS_90F < 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg29"))
            {
                ++Test_OM_Fahrt_fg_Pfg18;
                --Test_OM_Fahrt_fg_Pfg17;
                ++OML_Kontakte_$8_FSS_30F;
                fire("Test_OM_Fahrt_fg_Tfg29");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg33 can fire
        if ( (Test_OM_Fahrt_fg_Pfg19 >= 1) &&
                (Test_OM_Fahrt_fg_Pfg20 <= 0) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_aus >= 1) &&
                (OML_Kontakte_$8_FSS_30F < 1) &&
                (OML_Kontakte_$8_FSS_0EGF <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg33"))
            {
                --Test_OM_Fahrt_fg_Pfg19;
                ++Test_OM_Fahrt_fg_Pfg20;
                ++OML_Kontakte_$8_FSS_0EGF;
                fire("Test_OM_Fahrt_fg_Tfg33");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg26 can fire
        if ( (Test_OM_Fahrt_fg_Pfg16 <= 0) &&
                (Test_OM_Fahrt_fg_Pfg15 >= 1) &&
                (OML_Iso_egf_$frei >= 1) &&
                (OML_Fstr_fg_$Zug_eingefahren >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg26"))
            {
                ++Test_OM_Fahrt_fg_Pfg16;
                --Test_OM_Fahrt_fg_Pfg15;
                fire("Test_OM_Fahrt_fg_Tfg26");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg18 can fire
        if ( (Test_OM_Fahrt_fg_Pfg9 >= 1) &&
                (Test_OM_Fahrt_fg_Pfg10 <= 0) &&
                (OML_Fstr_fg_$F_Fahrt3 >= 1) &&
                (OML_ILTIS_$ZB_138_2 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg18"))
            {
                --Test_OM_Fahrt_fg_Pfg9;
                ++Test_OM_Fahrt_fg_Pfg10;
                ++OML_ILTIS_$ZB_138_2;
                fire("Test_OM_Fahrt_fg_Tfg18");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg1 can fire
        if ( (Test_OM_Fahrt_fg >= 1) &&
                (Test_OM_Fahrt_fg_Pfg1 <= 0) &&
                (Test_OM_Fahrt_fg_init >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg1"))
            {
                ++Test_OM_Fahrt_fg_Pfg1;
                --Test_OM_Fahrt_fg_init;
                fire("Test_OM_Fahrt_fg_Tfg1");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg36 can fire
        if ( (Test_OM_Fahrt_fg_Pfg21 >= 1) &&
                (Test_OM_Fahrt_fg_Pfg22 <= 0) &&
                (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (Test_OM_Fahrt_fg_Pfg23 <= 0) &&
                (OML_ZB_$cd_belegt <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg36"))
            {
                --Test_OM_Fahrt_fg_Pfg21;
                ++Test_OM_Fahrt_fg_Pfg22;
                ++Test_OM_Fahrt_fg_Pfg23;
                ++OML_ZB_$cd_belegt;
                fire("Test_OM_Fahrt_fg_Tfg36");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg12 can fire
        if ( (Test_OM_Fahrt_fg_Pfg6 >= 1) &&
                (OML_Stw_FSS_SM_$FSS_Sperrm_ein >= 1) &&
                (OML_Fstr_fg_$geprueft3 >= 1) &&
                (Test_OM_Fahrt_fg_Pfg7 <= 0) &&
                (OML_Kontakte_$8_FSS_30F <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg12"))
            {
                --Test_OM_Fahrt_fg_Pfg6;
                ++Test_OM_Fahrt_fg_Pfg7;
                ++OML_Kontakte_$8_FSS_30F;
                fire("Test_OM_Fahrt_fg_Tfg12");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg10 can fire
        if ( (OML_BL_OM_LN_$belegt_v >= 1) &&
                (Test_OM_Fahrt_fg_Pfg6 <= 0) &&
                (OML_Kontakte_$8_FSS_10F <= 0) &&
                (OML_Kontakte_$6_Gleist_ZB <= 0) &&
                (OML_LN_$LN_Grundstlg >= 1) &&
                (Test_OM_Fahrt_fg_Pfg5 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg10"))
            {
                ++Test_OM_Fahrt_fg_Pfg6;
                ++OML_Kontakte_$8_FSS_10F;
                ++OML_Kontakte_$6_Gleist_ZB;
                --Test_OM_Fahrt_fg_Pfg5;
                fire("Test_OM_Fahrt_fg_Tfg10");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg23 can fire
        if ( (Test_OM_Fahrt_fg_Pfg13 >= 1) &&
                (OML_Iso_1_$belegen <= 0) &&
                (Test_OM_Fahrt_fg_Pfg14 <= 0))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg23"))
            {
                --Test_OM_Fahrt_fg_Pfg13;
                ++OML_Iso_1_$belegen;
                ++Test_OM_Fahrt_fg_Pfg14;
                fire("Test_OM_Fahrt_fg_Tfg23");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg31 can fire
        if ( (Test_OM_Fahrt_fg_Pfg18 >= 1) &&
                (Test_OM_Fahrt_fg_Pfg19 <= 0) &&
                (OML_Kontakte_$8_FSS_10F <= 0) &&
                (OML_Fstr_fg_$aufgeloest >= 1) &&
                (OML_Kontakte_$8_FSS_45F < 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg31"))
            {
                --Test_OM_Fahrt_fg_Pfg18;
                ++Test_OM_Fahrt_fg_Pfg19;
                ++OML_Kontakte_$8_FSS_10F;
                fire("Test_OM_Fahrt_fg_Tfg31");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg21 can fire
        if ( (OML_Iso_egf_$belegen <= 0) &&
                (Test_OM_Fahrt_fg_Pfg13 <= 0) &&
                (Test_OM_Fahrt_fg_Pfg12 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg21"))
            {
                ++OML_Iso_egf_$belegen;
                ++Test_OM_Fahrt_fg_Pfg13;
                --Test_OM_Fahrt_fg_Pfg12;
                fire("Test_OM_Fahrt_fg_Tfg21");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg4 can fire
        if ( (OML_BL_OM_LN_$Grundstlg_v >= 1) &&
                (Test_OM_Fahrt_fg_Pfg3 <= 0) &&
                (OML_ILTIS_$LN_1_834 <= 0) &&
                (Test_OM_Fahrt_fg_Pfg2 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg4"))
            {
                ++Test_OM_Fahrt_fg_Pfg3;
                ++OML_ILTIS_$LN_1_834;
                --Test_OM_Fahrt_fg_Pfg2;
                fire("Test_OM_Fahrt_fg_Tfg4");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg27 can fire
        if ( (Test_OM_Fahrt_fg_Pfg17 <= 0) &&
                (Test_OM_Fahrt_fg_Pfg16 >= 1) &&
                (OML_Kontakte_$8_FSS_45F <= 0) &&
                (OML_Iso_1_$frei >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg27"))
            {
                ++Test_OM_Fahrt_fg_Pfg17;
                --Test_OM_Fahrt_fg_Pfg16;
                ++OML_Kontakte_$8_FSS_45F;
                fire("Test_OM_Fahrt_fg_Tfg27");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg3 can fire
        if ( (OML_ILTIS_$anfordern_vLN >= 1) &&
                (OML_ILTIS_$LN_1_834 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg3"))
            {
                --OML_ILTIS_$anfordern_vLN;
                fire("Test_OM_Fahrt_fg_Tfg3");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg5 can fire
        if ( (OML_LN_$ce_belegt >= 1) &&
                (OML_ILTIS_$LN_1_834 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg5"))
            {
                --OML_ILTIS_$LN_1_834;
                fire("Test_OM_Fahrt_fg_Tfg5");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg7 can fire
        if ( (OML_LN_$ce_belegt >= 1) &&
                (OML_LN_$LN_Grundstlg >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg7"))
            {
                --OML_LN_$ce_belegt;
                fire("Test_OM_Fahrt_fg_Tfg7");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg11 can fire
        if ( (OML_Kontakte_$6_Gleist_ZB >= 1) &&
                (OML_Kontakte_$8_FSS_10F >= 1) &&
                (OML_Kontakte_$8_FSS_30F >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg11"))
            {
                --OML_Kontakte_$8_FSS_10F;
                fire("Test_OM_Fahrt_fg_Tfg11");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg13 can fire
        if ( (OML_Kontakte_$8_FSS_45F >= 1) &&
                (OML_Kontakte_$8_FSS_30F >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg13"))
            {
                --OML_Kontakte_$8_FSS_30F;
                fire("Test_OM_Fahrt_fg_Tfg13");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg15 can fire
        if ( (Test_OM_Fahrt_fg_Pfg9 >= 1) &&
                (OML_Kontakte_$8_FSS_45F >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg15"))
            {
                --OML_Kontakte_$8_FSS_45F;
                fire("Test_OM_Fahrt_fg_Tfg15");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg17 can fire
        if ( (Test_OM_Fahrt_fg_Pfg17 >= 1) &&
                (OML_Kontakte_$8_FSS_90F >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg17"))
            {
                --OML_Kontakte_$8_FSS_90F;
                fire("Test_OM_Fahrt_fg_Tfg17");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg19 can fire
        if ( (OML_ILTIS_$ZB_138_2 >= 1) &&
                (Test_OM_Fahrt_fg_Pfg11 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg19"))
            {
                --OML_ILTIS_$ZB_138_2;
                fire("Test_OM_Fahrt_fg_Tfg19");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg22 can fire
        if ( (OML_Iso_egf_$belegen >= 1) &&
                (Test_OM_Fahrt_fg_Pfg15 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg22"))
            {
                --OML_Iso_egf_$belegen;
                fire("Test_OM_Fahrt_fg_Tfg22");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg24 can fire
        if ( (Test_OM_Fahrt_fg_Pfg16 >= 1) &&
                (OML_Iso_1_$belegen >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg24"))
            {
                --OML_Iso_1_$belegen;
                fire("Test_OM_Fahrt_fg_Tfg24");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg28 can fire
        if ( (OML_Kontakte_$8_FSS_45F >= 1) &&
                (Test_OM_Fahrt_fg_Pfg18 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg28"))
            {
                --OML_Kontakte_$8_FSS_45F;
                fire("Test_OM_Fahrt_fg_Tfg28");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg30 can fire
        if ( (OML_Kontakte_$8_FSS_30F >= 1) &&
                (Test_OM_Fahrt_fg_Pfg19 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg30"))
            {
                --OML_Kontakte_$8_FSS_30F;
                fire("Test_OM_Fahrt_fg_Tfg30");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg32 can fire
        if ( (OML_Kontakte_$8_FSS_10F >= 1) &&
                (OML_Kontakte_$8_FSS_0EGF >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg32"))
            {
                --OML_Kontakte_$8_FSS_10F;
                fire("Test_OM_Fahrt_fg_Tfg32");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg25 can fire
        if ( (Test_OM_Fahrt_fg_Pfg14 >= 1) &&
                (Test_OM_Fahrt_fg_Pfg15 <= 0) &&
                (OML_Fstr_fg_$store_egf_1_belegt >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg25"))
            {
                --Test_OM_Fahrt_fg_Pfg14;
                ++Test_OM_Fahrt_fg_Pfg15;
                fire("Test_OM_Fahrt_fg_Tfg25");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg35 can fire
        if ( (OML_Kontakte_$6_RM_nLN >= 1) &&
                (Test_OM_Fahrt_fg_Pfg22 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg35"))
            {
                --OML_Kontakte_$6_RM_nLN;
                fire("Test_OM_Fahrt_fg_Tfg35");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg37 can fire
        if ( (OML_ZB_$cd_belegt >= 1) &&
                (OML_ILTIS_$RM_ZB_OM >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg37"))
            {
                --OML_ZB_$cd_belegt;
                fire("Test_OM_Fahrt_fg_Tfg37");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg39 can fire
        if ( (OML_ILTIS_$RM_ZB_OM >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg39"))
            {
                --OML_ILTIS_$RM_ZB_OM;
                fire("Test_OM_Fahrt_fg_Tfg39");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg40 can fire
        if ( (Test_OM_Fahrt_fg_Pfg24 >= 1) &&
                (Test_OM_Fahrt_fg_end_test_fg <= 0) &&
                (OML_BL_ZB_OM_$Grundstlg_n >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg40"))
            {
                --Test_OM_Fahrt_fg_Pfg24;
                ++Test_OM_Fahrt_fg_end_test_fg;
                fire("Test_OM_Fahrt_fg_Tfg40");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg9 can fire
        if ( (Test_OM_Fahrt_fg_Pfg5 <= 0) &&
                (Test_OM_Fahrt_fg_Pfg4 >= 1) &&
                (OML_BL_ZB_OM_$Grundstlg_n >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg9"))
            {
                ++Test_OM_Fahrt_fg_Pfg5;
                --Test_OM_Fahrt_fg_Pfg4;
                fire("Test_OM_Fahrt_fg_Tfg9");
                return true;
            }
        }
        //check if Test_OM_Fahrt_fg_Tfg8 can fire
        if ( (OML_Kontakte_$6_FBA_nZB >= 1) &&
                (Test_OM_Fahrt_fg_Pfg5 >= 1))
        {
            if (canFire("Test_OM_Fahrt_fg_Tfg8"))
            {
                --OML_Kontakte_$6_FBA_nZB;
                fire("Test_OM_Fahrt_fg_Tfg8");
                return true;
            }
        }
        return false;
    }
}