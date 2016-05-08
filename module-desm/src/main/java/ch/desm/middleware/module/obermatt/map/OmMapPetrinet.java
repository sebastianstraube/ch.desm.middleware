package ch.desm.middleware.module.obermatt.map;

import java.util.Map;
import java.util.NoSuchElementException;

import ch.desm.middleware.core.component.ComponentMapBase;

public class OmMapPetrinet extends ComponentMapBase{

    public String mapBrokerToEndpointMessage(String message) throws NoSuchElementException {
        String mappedMessage = this.getKeyForValue(message);
        if(mappedMessage.isEmpty()) {
            throw new NoSuchElementException("unable to map broker message \"" + message + "\"");
        }
        return mappedMessage;
    }

	@Override
	protected void init(){
        map.put("1.90.01","OML_Lampen_Stoerung_$1_F_VS_Stoer"); //Störungslampe Einfahrvorsignal F*
// map.put("1.90.02",""); //Einfahrsignal F; Notrot
        map.put("1.90.03","OML_Lampen_Signal_F_$1_F_gruenFB3"); //Einfahrsignal F; Grün FB 3
        map.put("1.90.04","OML_Lampen_Signal_F_$1_F_rot"); //Einfahrsignal F; Rot
        map.put("1.90.05","OML_Lampen_Signal_F_$1_F_gruenFB1"); //Einfahrsignal F; Grün FB1
        map.put("1.90.06","OML_Fstr_ef_$E_Fahrt1"); //Einfahrsignal E; Grün FB1
        map.put("1.90.07","OML_Fstr_ef_$E_Halt"); //Einfahrsignal E; Rot
// map.put("1.90.08",""); //Einfahrsignal E; Notrot
        map.put("1.90.09","OML_Fstr_gf_$G_Fahrt3"); //Einfahrsignal G; Grün FB1
        map.put("1.90.10","OML_Lampen_Signal_G_$1_G_rot"); //Einfahrsignal G; Rot
        map.put("1.90.11","OML_Lampen_Signal_G_$1_G_gruenFB3"); //Einfahrsignal G; Grün FB3
        map.put("1.90.12","OML_EMM_$D_Halt"); //Einfahrsignal D EMM; Rot
        map.put("1.90.13","OML_EMM_$D_FB1"); //Einfahrsignal D EMM; Grün
        map.put("1.90.14","OML_EMM_$C_FB1"); //Ausfahrsignal C EMM; Grün
        map.put("1.90.15","OML_EMM_$C_Halt"); //Ausfahrsingal C EMM; Rot
        map.put("1.90.16","OML_Lampen_Stoerung_$1_G_VS_Stoer"); //Störungslampe Einfahrvorsignal G*
        map.put("1.91.21","OML_Lampen_Streckenblock_$1_FBV_vZB"); //Fahrtrichtung verlangt von Zollbrück
        map.put("1.91.22","OML_BL_ZB_OM_$RMM_nZB"); //Rückmelden möglich nach Zollbrück
        map.put("1.90.31","OML_Lampen_Streckenblock_$1_BL_vLN_rot"); //Block von Langnau, rot
        map.put("1.90.32","OML_Lampen_Streckenblock_$1_BL_vLN_weiss"); //Block von Langnau, weiss
        map.put("1.90.33","OML_Lampen_Streckenblock_$1_BL_nLN_weiss"); //Block nach Langnau, weiss
        map.put("1.90.34","OML_Lampen_Streckenblock_$1_BL_nLN_rot"); //Block nach Langnau, rot
        map.put("1.90.35","OML_Lampen_Isolierung_$Iso_egf_ein"); //Isolierung egf
        map.put("1.90.36","OML_Lampen_Isolierung_$Iso_1_ein"); //Isolierung 1
        map.put("1.90.37","OML_Lampen_Fahrstrasse_$1_Fstr_ef"); //Fahrstrasse ef
        map.put("1.90.38","OML_Lampen_Isolierung_$Iso_ef_ein"); //Isolierung ef
        map.put("1.90.39","OML_Lampen_Isolierung_$Iso_cd_ein"); //Isolierung cd
        map.put("1.90.40","OML_Lampen_Fahrstrasse_$1_Fstr_gf"); //Fahrstrasse gf
        map.put("1.90.41","OML_Lampen_Streckenblock_$1_BL_nZB_rot"); //Block nach Zollbrück, rot
        map.put("1.90.42","OML_Lampen_Streckenblock_$1_BL_nZB_weiss"); //Block nach Zollbrück, weiss
        map.put("1.90.43","OML_Lampen_Streckenblock_$1_BL_vZB_weiss"); //Block von Zollbrück, weiss
        map.put("1.90.44","OML_Lampen_Streckenblock_$1_BL_vZB_rot"); //Block von Zollbrück, rot
        map.put("1.91.01","OML_BL_OM_LN_$RMM_nLN"); //Rückmelden möglich nach Langnau
        map.put("1.91.02","OML_Lampen_Streckenblock_$1_FBV_vLN"); //Fahrtrichtung verlangt von Langnau
        map.put("1.91.03","OML_Lampen_Stoerung_$1_Stoer_Wecker"); //Störung, Wecker abschalten
        map.put("1.01.02","OML_Lampen_WS1_$1_WS1_Ueberw"); //WS1 Überwachungslampe
        map.put("2.92.01","OML_Wecker_Weichen_$2_Weiche"); //Weichenwecker
// map.put("2.92.02",""); //Blockwecker
// map.put("2.90.01",""); //Signalwecker
// map.put("9.99.04",""); //Abläuten von Emmenmatt
// map.put("9.99.05",""); //Abläuten von Langnau
// map.put("9.99.06",""); //Abläuten von Zollbrück
// map.put("9.99.07",""); //Abläuten nach Emmenmatt
// map.put("9.99.08",""); //Abläuten nach Langnau
// map.put("9.99.09",""); //Abläuten nach Zollbrück
// map.put("9.99.10",""); //Stellstrom
// map.put("9.99.11",""); //Überwachungsstrom
// map.put("9.99.12",""); //Gleisisolierung
        map.put("3.01.01","OML_Stw_WS1_SM_$Sperrm_ein"); //WS1 Freigabemagnet
        map.put("3.04.01","OML_Stw_FSS_SM_$FSS_Sperrm_ein"); //FSS Sperrmagnet
        map.put("3.04.02","OML_Stw_FSS_KSM_$FSS_Kuppelm_ein"); //FSS Kuppelstrommagnet
// map.put("9.93.01",""); //Weichenbeleuchtung
// map.put("6.90.01",""); //Anforderung für Durchfahrt nach Emmenmatt
        map.put("6.91.02","OML_Kontakte_$6_FBA_nZB"); //Freie Bahn anfordern nach Zollbrück
        map.put("6.91.01","OML_Kontakte_$6_FBF_nZB"); //Freie Bahn festhalten nach Zollbrück
        map.put("6.91.03","OML_Kontakte_$6_RM_nZB"); //Rückmelden nach Zollbrück
        map.put("6.91.04","OML_Kontakte_$6_RM_nLN"); //Rückmelden nach Langnau
        map.put("6.91.05","OML_Kontakte_$6_FBA_nLN"); //Freie Bahn anfordern nach Langnau
        map.put("6.91.06","OML_Kontakte_$6_FBF_nLN"); //Freie Bahn festhalten nach Langnau
        map.put("6.91.07","OML_Kontakte_$6_BLU_EG"); //Blockumgehung EG
        map.put("6.91.08","OML_Kontakte_$6_Gleist_EMM"); //Richtung Emmenmatt
// map.put("6.91.09",""); //Wecker abschalten
        map.put("6.91.10","OML_Kontakte_$6_NT_W1"); //Nottaste W1
// map.put("6.91.11",""); //Weichenbeleuchtung aus/ein
// map.put("6.91.12",""); //Zeitschalter-Umgehung Ein/Norm.
        map.put("6.91.13","OML_Kontakte_$6_NAL"); //Notauflösung
        map.put("6.91.14","OML_Kontakte_$6_Gleist_ZB"); //Richtung Zollbrück
        map.put("6.91.15","OML_Kontakte_$6_ISU_Sign"); //Isolierumgehung für Signalfahrtstellung
        map.put("7.91.01","OML_logic_Kontakte_WS1_$ws1_plus"); //WS1 Grundstellung +
        map.put("7.91.02","OML_Kontakte_$7_WS1_1"); //WS1 gedrückt
        map.put("7.91.04","OML_logic_Kontakte_WS1_$ws1_minus"); //WS1 in Grundstellung - (45° Lage)
// map.put("8.91.02",""); //FSS Grundstellung gedrückt
        map.put("8.91.01","OML_Kontakte_$8_FSS_0EGF"); //FSS in Endlage
        map.put("8.91.03","OML_Kontakte_$8_FSS_10F"); //FSS in 10°-Lage von Langnau
        map.put("8.91.04","OML_Kontakte_$8_FSS_30F"); //FSS in 30°-Lage von Langnau
        map.put("8.91.05","OML_Kontakte_$8_FSS_45F"); //FSS in 45°-Lage von Langnau
// map.put("8.91.06",""); //FSS in 80°-Lage von Langnau
        map.put("8.91.07","OML_Kontakte_$8_FSS_90F"); //FSS in 90°-Lage von Langnau
        map.put("8.91.19","OML_Kontakte_$8_FSS_10EG"); //FSS in 10°-Lage nach Langnau
        map.put("8.91.20","OML_Kontakte_$8_FSS_30EG"); //FSS in 30°-Lage nach Langnau
        map.put("8.91.21","OML_Kontakte_$8_FSS_45EG"); //FSS in 45°-Lage nach Langnau
// map.put("8.91.22",""); //FSS in 80°-Lage nach Langnau
        map.put("8.91.23","OML_Kontakte_$8_FSS_90EG"); //FSS in 90°-Lage nach Langnau
        map.put("10.99.01","OML_Iso_egf_$belegen"); //Isolierung egf belegt
// map.put("10.99.02",""); //Isolierung egf direkt nach Isolierung 1 belegt
        map.put("10.99.04","OML_Iso_1_$belegen"); //Isolierung 1 belegt
// map.put("10.99.05",""); //Isolierung 1 direkt nach Isolierung ef belegt
// map.put("10.99.06",""); //Isolierung 1 direkt nach Isolierung egf belegt
        map.put("10.99.07","OML_Iso_ef_$belegen"); //Isolierung ef belegt
        map.put("10.99.08","OML_Iso_cd_$belegen"); //Isolierung cd belegt
        map.put("10.99.09","OML_Iso_1_$frei"); //Freigabe Isolierung 1
        map.put("10.99.10","OML_Iso_egf_$frei"); //Freigabe Isolierung egf
// map.put("11.99.01",""); //Freie Bahn verlangen von Langnau
// map.put("11.99.02",""); //Freie Bahn zustimmen nach Langnau
// map.put("11.99.03",""); //Freie Bahn festhalten von Langnau
        map.put("11.99.04","OML_ILTIS_$RM_LN_OM"); //Rückmelden von Langnau
// map.put("11.99.05",""); //Freie Bahn verlangen von Zollbrück
// map.put("11.99.06",""); //Freie Bahn zustimmen nach Zollbrück
// map.put("11.99.07",""); //Freie Bahn festhalten von Zollbrück
        map.put("11.99.08","OML_ILTIS_$RM_ZB_OM"); //Rückmelden von Zollbrück
// map.put("9.99.13",""); //Anfordern von Emmenmatt
// map.put("9.99.14",""); //Ausfahrt von Emmenmatt
// map.put("9.99.15",""); //Zug eingefahren im Emmenmatt
        map.put("11.99.09","OML_BL_OM_LN_$vorgebl_v"); //Vorblocken von Langnau
        map.put("11.99.10","OML_BL_ZB_OM_$vorgebl_v"); //Vorblocken von Zollbrück
// map.put("9.99.01",""); //Abläuten von Emmenmatt (Zug abgefahren)
// map.put("9.99.02",""); //Abläuten von Langnau (Zug abgefahren)
// map.put("9.99.03",""); //Abläuten von Zollbrück (Zug abgefahren)
// map.put("6.99.01",""); //Abläuten nach Emmenmatt
// map.put("6.99.02",""); //Abläuten nach Langnau
// map.put("6.99.03",""); //Abläuten nach Zollbrück
        map.put("12.99.01","OML_ext_Vb_$Ueberw_W1_plus"); //Weichenüberwachung 1+
        map.put("12.99.02","OML_ext_Vb_$Ueberw_W1_minus"); //Weichenüberwachung 1 -
// map.put("12.99.03",""); //Überwachungssicherung defekt/aus
// map.put("12.99.04",""); //Stellstromsicherung defekt/aus
// map.put("90.99.01",""); //Signallampe defekt; F* Warnung
// map.put("90.99.02",""); //Signallampe defekt; F* Fahrt
// map.put("90.99.03",""); //Signallampe defekt; F notrot
// map.put("90.99.04",""); //Signallampe defekt; F grün FB3
// map.put("90.99.05",""); //Signallampe defekt; F rot
// map.put("90.99.06",""); //Signallampe defekt; F grün FB 1
// map.put("90.99.07",""); //Signallampe defekt; E grün
// map.put("90.99.08",""); //Signallampe defekt; E rot
// map.put("90.99.09",""); //Signallampe defekt; E notrot
// map.put("90.99.10",""); //Signallampe defekt; D rot
// map.put("90.99.11",""); //Signallampe defekt; D grün
// map.put("90.99.12",""); //Signallampe defekt; C grün
// map.put("90.99.13",""); //Signallampe defekt; C rot
        map.put("90.99.14","OML_ext_Vb_$G_VS_Lampe_Warn_def"); //Signallampe defekt; G* Warnung
        map.put("90.99.15","OML_ext_Vb_$G_VS_Lampe_Fahrt_def"); //Signallampe defekt; G* Fahrt
// map.put("90.99.16",""); //Signallampe defekt; G grün FB 1
// map.put("90.99.17",""); //Signallampe defekt; G rot
// map.put("90.99.18",""); //Signallampe defekt; G Reserve-rot
// map.put("90.99.19",""); //Signallampe defekt; G grün FB3

    }

}
