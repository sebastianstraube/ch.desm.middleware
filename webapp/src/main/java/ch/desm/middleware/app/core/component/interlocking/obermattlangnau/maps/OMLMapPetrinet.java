package ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps;

import java.util.Map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

public class OMLMapPetrinet extends ComponentMapBase{

	@Override
	public Map<String, String> getMap() {
		return map;
	}

    public String mapEndpointToBrokerMessage(String message) throws Exception {
        String mappedMessage = this.getKey(message);
        if(mappedMessage.isEmpty()) {
            throw new Exception("unable to map petri net message \"" + message + "\"");
        }
        return mappedMessage;
    }

    public String mapBrokerToEndpointMessage(String message) throws Exception {
        String mappedMessage = this.getKey(message);
        if(mappedMessage.isEmpty()) {
            throw new Exception("unable to map broker message \"" + message + "\"");
        }
        return mappedMessage;
    }

	@Override
	protected void init(){
        map.put("1.90.01","Lampen_1_F_VS_Stoer"); //Störungslampe Einfahrvorsignal F*
// map.put("1.90.02",""); //Einfahrsignal F; Notrot
        map.put("1.90.03","Fstr_fg_F_Fahrt3"); //Einfahrsignal F; Grün FB 3
        map.put("1.90.04","Lampen_1_F_rot"); //Einfahrsignal F; Rot
        map.put("1.90.05","Lampen_1_F_gruenFB1"); //Einfahrsignal F; Grün FB1
        map.put("1.90.06","Fstr_ef_E_Fahrt1"); //Einfahrsignal E; Grün FB1
        map.put("1.90.07","Fstr_ef_E_Halt"); //Einfahrsignal E; Rot
// map.put("1.90.08",""); //Einfahrsignal E; Notrot
        map.put("1.90.09","Fstr_gf_G_Fahrt3"); //Einfahrsignal G; Grün FB1
        map.put("1.90.10","Fstr_gf_G_Halt"); //Einfahrsignal G; Rot
// map.put("1.90.11",""); //Einfahrsignal G; Grün FB3
        map.put("1.90.12","EMM_D_Halt"); //Einfahrsignal D EMM; Rot
// map.put("1.90.13",""); //Einfahrsignal D EMM; Grün
// map.put("1.90.14",""); //Ausfahrsignal C EMM; Grün
// map.put("1.90.15",""); //Ausfahrsingal C EMM; Rot
        map.put("1.90.16","Lampen_1_G_VS_Stoer"); //Störungslampe Einfahrvorsignal G*
        map.put("1.91.21","Lampen_1_FBV_vZB"); //Fahrtrichtung verlangt von Zollbrück
        map.put("1.91.22","BL_ZB_OM_RMM_nZB"); //Rückmelden möglich nach Zollbrück
        map.put("1.90.31","Lampen_1_BL_vLN_rot"); //Block von Langnau, rot
        map.put("1.90.32","Lampen_1_BL_vLN_weiss"); //Block von Langnau, weiss
        map.put("1.90.33","Lampen_1_BL_nLN_weiss"); //Block nach Langnau, weiss
// map.put("1.90.34",""); //Block nach Langnau, rot
        map.put("1.90.35","Lampen_Iso_egf_ein"); //Isolierung egf
        map.put("1.90.36","Lampen_Iso_1_ein"); //Isolierung 1
        map.put("1.90.37","Lampen_1_Fstr_ef"); //Fahrstrasse ef
        map.put("1.90.38","Lampen_Iso_ef_ein"); //Isolierung ef
        map.put("1.90.39","Lampen_Iso_cd_ein"); //Isolierung cd
        map.put("1.90.40","Lampen_1_Fstr_gf"); //Fahrstrasse gf
        map.put("1.90.41","Lampen_1_BL_nZB_rot"); //Block nach Zollbrück, rot
        map.put("1.90.42","Lampen_1_BL_nZB_weiss"); //Block nach Zollbrück, weiss
        map.put("1.90.43","Lampen_1_BL_vZB_weiss"); //Block von Zollbrück, weiss
        map.put("1.90.44","Lampen_1_BL_vZB_rot"); //Block von Zollbrück, rot
        map.put("1.91.01","BL_OM_LN_RMM_nLN"); //Rückmelden möglich nach Langnau
        map.put("1.91.02","Lampen_1_FBV_vLN"); //Fahrtrichtung verlangt von Langnau
        map.put("1.91.03","Lampen_1_Stoer_Wecker"); //Störung, Wecker abschalten
        map.put("1.01.01","Lampen_1_WS1_Freig"); //WS1 Freigabelampe
        map.put("1.01.02","Lampen_1_WS1_Ueberw"); //WS1 Überwachungslampe
// map.put("2.92.01",""); //Weichenwecker
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
        map.put("3.01.01","Stw_WS_Sperrm_ein"); //WS1 Freigabemagnet
        map.put("3.04.01","Stw_FSS_Sperrm_ein"); //FSS Sperrmagnet
        map.put("3.04.02","Stw_FSS_Kuppelm_ein"); //FSS Kuppelstrommagnet
// map.put("9.93.01",""); //Weichenbeleuchtung
// map.put("6.90.01",""); //Anforderung für Durchfahrt nach Emmenmatt
        map.put("6.91.02","Kontakte_6_FBA_nZB"); //Freie Bahn anfordern nach Zollbrück
        map.put("6.91.01","Kontakte_6_FBF_nZB"); //Freie Bahn festhalten nach Zollbrück
        map.put("6.91.03","Kontakte_6_RM_nZB"); //Rückmelden nach Zollbrück
        map.put("6.91.04","Kontakte_6_FBA_nLN"); //Rückmelden nach Langnau
// map.put("6.91.05",""); //Freie Bahn anfordern nach Langnau
        map.put("6.91.06","Kontakte_6_FBF_nLN"); //Freie Bahn festhalten nach Langnau
        map.put("6.91.07","Kontakte_6_BLU_EG"); //Blockumgehung EG
        map.put("6.91.08","Kontakte_6_Gleist_EMM"); //Richtung Emmenmatt
// map.put("6.91.09",""); //Wecker abschalten
        map.put("6.91.10","Kontakte_6_NT_W1"); //Nottaste W1
// map.put("6.91.11",""); //Weichenbeleuchtung aus/ein
// map.put("6.91.12",""); //Zeitschalter-Umgehung Ein/Norm.
        map.put("6.91.13","Kontakte_6_NAL"); //Notauflösung
        map.put("6.91.14","Kontakte_6_Gleist_ZB"); //Richtung Zollbrück
        map.put("6.91.15","Kontakte_6_ISU_Sign"); //Isolierumgehung für Signalfahrtstellung
        map.put("7.91.01","Kontakte_7_WS1_plus"); //WS1 Grundstellung +
        map.put("7.91.02","Kontakte_7_WS1_1"); //WS1 gedrückt
        map.put("7.91.04","Kontakte_7_WS1_minus"); //WS1 in Grundstellung - (45° Lage)
// map.put("8.91.02",""); //FSS Grundstellung gedrückt
// map.put("8.91.01",""); //FSS in Endlage
        map.put("8.91.03","Kontakte_8_FSS_10F"); //FSS in 10°-Lage von Langnau
        map.put("8.91.04","Kontakte_8_FSS_30F"); //FSS in 30°-Lage von Langnau
        map.put("8.91.05","Kontakte_8_FSS_45F"); //FSS in 45°-Lage von Langnau
// map.put("8.91.06",""); //FSS in 80°-Lage von Langnau
        map.put("8.91.07","Kontakte_8_FSS_90F"); //FSS in 90°-Lage von Langnau
        map.put("8.91.19","Kontakte_8_FSS_10EG"); //FSS in 10°-Lage nach Langnau
        map.put("8.91.20","Kontakte_8_FSS_30EG"); //FSS in 30°-Lage nach Langnau
        map.put("8.91.21","Kontakte_8_FSS_45EG"); //FSS in 45°-Lage nach Langnau
// map.put("8.91.22",""); //FSS in 80°-Lage nach Langnau
        map.put("8.91.23","Kontakte_8_FSS_90EG"); //FSS in 90°-Lage nach Langnau
        map.put("10.99.01","Iso_egf_belegt"); //Isolierung egf belegt
// map.put("10.99.02",""); //Isolierung egf direkt nach Isolierung 1 belegt
        map.put("10.99.04","Iso_1_belegt"); //Isolierung 1 belegt
// map.put("10.99.05",""); //Isolierung 1 direkt nach Isolierung ef belegt
// map.put("10.99.06",""); //Isolierung 1 direkt nach Isolierung egf belegt
        map.put("10.99.07","Iso_ef_belegt"); //Isolierung ef belegt
        map.put("10.99.08","Iso_cd_belegt"); //Isolierung cd belegt
        map.put("10.99.09","Iso_1_frei"); //Freigabe Isolierung 1
        map.put("10.99.10","Iso_egf_frei"); //Freigabe Isolierung egf
// map.put("11.99.01",""); //Freie Bahn verlangen von Langnau
// map.put("11.99.02",""); //Freie Bahn zustimmen nach Langnau
// map.put("11.99.03",""); //Freie Bahn festhalten von Langnau
        map.put("11.99.04","ILTIS_RM_LN_OM"); //Rückmelden von Langnau
// map.put("11.99.05",""); //Freie Bahn verlangen von Zollbrück
// map.put("11.99.06",""); //Freie Bahn zustimmen nach Zollbrück
// map.put("11.99.07",""); //Freie Bahn festhalten von Zollbrück
        map.put("11.99.08","ILTIS_RM_ZB_OM"); //Rückmelden von Zollbrück
// map.put("9.99.13",""); //Anfordern von Emmenmatt
// map.put("9.99.14",""); //Ausfahrt von Emmenmatt
// map.put("9.99.15",""); //Zug eingefahren im Emmenmatt
        map.put("11.99.09","BL_OM_LN_vorgebl_v"); //Vorblocken von Langnau
        map.put("11.99.10","BL_ZB_OM_vorgebl_v"); //Vorblocken von Zollbrück
// map.put("9.99.01",""); //Abläuten von Emmenmatt (Zug abgefahren)
// map.put("9.99.02",""); //Abläuten von Langnau (Zug abgefahren)
// map.put("9.99.03",""); //Abläuten von Zollbrück (Zug abgefahren)
// map.put("6.99.01",""); //Abläuten nach Emmenmatt
// map.put("6.99.02",""); //Abläuten nach Langnau
// map.put("6.99.03",""); //Abläuten nach Zollbrück
        map.put("12.99.01","ext_Vb_Ueberw_W1_plus"); //Weichenüberwachung 1+
        map.put("12.99.02","ext_Vb_Ueberw_W1_minus"); //Weichenüberwachung 1 -
// map.put("12.99.03",""); //Überwachungssicherung defekt/aus
// map.put("12.99.04",""); //Stellstromsicherung defekt/aus
// map.put("90.99.01",""); //Signallampe defekt; F* Warnung
// map.put("90.99.02",""); //Signallampe defekt; F* Fahrt
// map.put("90.99.03",""); //Signallampe defekt; F notrot
        map.put("90.99.04","Fstr_fg_Stoerung_F"); //Signallampe defekt; F grün FB3
// map.put("90.99.05",""); //Signallampe defekt; F rot
// map.put("90.99.06",""); //Signallampe defekt; F grün FB 1
// map.put("90.99.07",""); //Signallampe defekt; E grün
// map.put("90.99.08",""); //Signallampe defekt; E rot
// map.put("90.99.09",""); //Signallampe defekt; E notrot
// map.put("90.99.10",""); //Signallampe defekt; D rot
// map.put("90.99.11",""); //Signallampe defekt; D grün
// map.put("90.99.12",""); //Signallampe defekt; C grün
// map.put("90.99.13",""); //Signallampe defekt; C rot
        map.put("90.99.14","ext_Vb_G_VS_Lampe_Warn_def"); //Signallampe defekt; G* Warnung
        map.put("90.99.15","ext_Vb_G_VS_Lampe_Fahrt_def"); //Signallampe defekt; G* Fahrt
// map.put("90.99.16",""); //Signallampe defekt; G grün FB 1
// map.put("90.99.17",""); //Signallampe defekt; G rot
// map.put("90.99.18",""); //Signallampe defekt; G Reserve-rot
// map.put("90.99.19",""); //Signallampe defekt; G grün FB3

    }

}
