package sebastianstraube.connectx.module.desm.cabine.re420.map;

import sebastianstraube.connectx.core.component.ComponentMapBase;

import java.util.Map;

public class Re420MapZusiFahrpult extends ComponentMapBase {

	public Re420MapZusiFahrpult() {
		super();
	}

	public boolean isKeyAvailable(String id) {
		return map.containsKey(id);
	}

	protected void init() {
		// map.put("S126.1",""); //Haupthahn
// map.put("S126",""); //Steuerstrom
// map.put("S129",""); //Stromabnehmer
// map.put("S132",""); //Hauptschalter
// map.put("S172.1",""); //Kompressor Automat
// map.put("S172.2",""); //Kompressor direkt
// map.put("S169",""); //Zugsammelschiene
// map.put("S311",""); //Beleuchtung Zug
// map.put("S316_1",""); //Dienstbeleuchtung 1
// map.put("S316_2",""); //Dienstbeleuchtung 2
// map.put("S140a",""); //Wendeschalter 140a vorwärts
// map.put("S140b",""); //Wendeschalter 140b rückwärts
// map.put("S150a",""); //Fahrschalter 150a
// map.put("S150b",""); //Fahrschalter 150b
// map.put("S150d",""); //Fahrschalter 150d
// map.put("S150e",""); //Fahrschalter 150e
// map.put("S150f",""); //Fahrschalter 150f
// map.put("S150g",""); //Fahrschalter 150g
// map.put("S150l",""); //Fahrschalter 150l
// map.put("S189.1",""); //Pfeife Stufe 1
// map.put("S189.2",""); //Pfeife Stufe 2
// map.put("S242.01",""); //Rückstelltaste Zugsicherung
// map.put("S242.03",""); //Rückstelltaste ZUB befreien
// map.put("S242.02",""); //M-Taste
// map.put("S174",""); //Taste Ventilator AUS
// map.put("S276_1",""); //Umschalter Bremse
// map.put("S276_2",""); //Umschalter Bremse
// map.put("S276_3",""); //Umschalter Bremse
// map.put("S241",""); //Kontakt B/V-Hahn
// map.put("S281",""); //Schleuderschutztaste
// map.put("S182.3",""); //Türfreigabe links
// map.put("S182.4",""); //Türfreigabe rechts
// map.put("S182",""); //Türverriegelung
// map.put("S324.1",""); //Instrumentenbeleuchtung
// map.put("S324.2",""); //Fahrplanbeleuchtung
// map.put("S317",""); //Aufblendung
// map.put("S316.1",""); //Stirnlampe links weiss
// map.put("S316.4",""); //Stirnlampe links rot
// map.put("S316.2",""); //Strinlampe oben weiss
// map.put("S316.5",""); //Strinlampe oben rot
// map.put("S316.3",""); //Stirnlampe rechts weiss
// map.put("S316.6",""); //Stirnlampe rechts rot
// map.put("S324",""); //Führerstandsbeleuchtung
// map.put("S333",""); //Instrumentenbeleuchtung
// map.put("W238_t",""); //Tiefton (Schnellgang, Signum, Totmann)
// map.put("W238_h",""); //Hochton (Langsamgang)
// map.put("L317",""); //Lampe Aufblendung
// map.put("L242b",""); //Signumschalter gelb
// map.put("L242a",""); //Signumschalter rot
// map.put("A94",""); //Vist-LZB
// map.put("D94m",""); //m-Anzeige (LZB, Band)
// map.put("D94u.1",""); //Uhr (hh)
// map.put("D94u.2",""); //Uhr (mm)
// map.put("D94U.3",""); //Uhr
// map.put("D94LZB_Z5",""); //Digitalanzeige LZB 5 Stellen
// map.put("D94LZB_Z3",""); //Digitalanzeige LZB 3 Stellen
// map.put("L94_LZB_r",""); //LZB Lampe rot
// map.put("L94_LZB_gr",""); //LZB Lampe grün
// map.put("L94_LZB_gb",""); //LZB Lampe gelb
// map.put("L94_LZB_w",""); //LZB Lampe weiss
// map.put("A74",""); //kV-Anzeige
// map.put("A79",""); //A-Anzeige Motorenstrom
// map.put("A79.1",""); //A-Anzeige Differenzstrom
// map.put("P13c_HB",""); //Druckanzeige Hauptluftbehälter
// map.put("P13c_HL",""); //Druckanzeige Hauptleitung
// map.put("P13c_BZ",""); //Druckanzeige Bremszylinder
// map.put("AO269",""); //Drucksensor Hauptleitung
// map.put("AO173",""); //Drucksensor Bremszylinder
// map.put("L281",""); //Lampe Schleuderbremse
// map.put("L281.1",""); //Schleuderbremse von Simulator
// map.put("L83",""); //Lampe Zugsammelschiene
// map.put("L175",""); //Lampe Ventilation/ Oelpumpe
// map.put("L163",""); //Lampe Stufenschalter
// map.put("L181",""); //Lampe Abfahrbefehl
// map.put("L182.3",""); //Lampe Türfreigabe links
// map.put("L185",""); //Lampe Tür offen
// map.put("L182.4",""); //Lampe Türfreigabe rechts
// map.put("L242.2",""); //Lampe M-Taste
// map.put("L318a",""); //Dienstbeleuchtung 3 Lampen weiss
// map.put("L318b",""); //Dienstbeleuchtung 3 Lampen rot
// map.put("L325.2",""); //Lampe Fahrplanbeleuchtung
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //

	}

}
