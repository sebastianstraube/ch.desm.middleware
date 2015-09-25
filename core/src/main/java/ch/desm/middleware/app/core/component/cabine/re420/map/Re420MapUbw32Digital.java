package ch.desm.middleware.app.core.component.cabine.re420.map;

import java.util.Map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

public class Re420MapUbw32Digital extends ComponentMapBase {

	public static final String PINBITMASK_CONFIGURATION_DIGITAL = "17943,65336,16,49152,768,12596,960";
	
	public Re420MapUbw32Digital() {
		super();
	}

	public boolean isKeyAvailable(String id) {
		return map.containsKey(id);
	}

	public boolean isValueAvailable(String id) {
		return map.containsValue(id);
	}

	@Override
	public Map<String, String> getMap() {
		return map;
	}

	protected void init() {

		map.put("s126", "C4"); //Steuerstrom
		map.put("s129", "G8"); //Stromabnehmer
		map.put("s132", "G9"); //Hauptschalter
		map.put("s172.1", "A4"); //Kompressor Automat
		map.put("s172.2", "A14"); //Kompressor direkt
		map.put("s169", "B8"); //Zugsammelschiene
		map.put("s311", "B11"); //Beleuchtung Zug
		map.put("s316_1", "A1"); //Dienstbeleuchtung 1
		map.put("s140a", "E9"); //Wendeschalter 140a vorwärts
		map.put("s140b", "B3"); //Wendeschalter 140b rückwärts
		map.put("s150a", "A9"); //Fahrschalter 150a
		map.put("s150b", "B9"); //Fahrschalter 150b
		map.put("s150d", "B10"); //Fahrschalter 150d
		map.put("s150e", "F13"); //Fahrschalter 150e
		map.put("s150f", "F12"); //Fahrschalter 150f
		map.put("s150g", "B14"); //Fahrschalter 150g
		map.put("s150l", "B15"); //Fahrschalter 150l
		map.put("s189.1", "G7"); //Pfeife Stufe 1
		map.put("s189.2", "A0"); //Pfeife Stufe 2
		map.put("s242.01", "A2"); //Rückstelltaste Zugsicherung
		map.put("s242.03", "G6"); //Rückstelltaste ZUB befreien
		map.put("s242.02", "F5"); //M-Taste
		map.put("s281", "F4"); //Schleuderschutztaste
		map.put("s182.3", "B5"); //Türfreigabe links
		map.put("s182.4", "A10"); //Türfreigabe rechts
		map.put("s182", "B4"); //Türverriegelung
		map.put("s316.1", "D15"); //Stirnlampe links weiss
		map.put("s316.4", "B12"); //Stirnlampe links rot
		map.put("s316.2", "F2"); //Strinlampe oben weiss
		map.put("s316.5", "B13"); //Strinlampe oben rot
		map.put("s316.3", "F8"); //Stirnlampe rechts weiss
		map.put("s316.6", "D14"); //Stirnlampe rechts rot
		map.put("s235", "E8"); //Totmannpedal
		map.put("w238_t", "D6"); //Tiefton (Schnellgang, Signum, Totmann)
		map.put("w238_h", "D4"); //Hochton (Langsamgang)
		map.put("l242b", "E3"); //Signumschalter gelb
		map.put("l242a", "G15"); //Signumschalter rot
		map.put("l281", "C3"); //Lampe Schleuderbremse
		map.put("l281.1", "D12"); //Schleuderbremse von Simulator (ep-Ventil)
		map.put("l83", "C14"); //Lampe Zugsammelschiene
		map.put("l175", "C1"); //Lampe Ventilation/ Oelpumpe
		map.put("l163", "E6"); //Lampe Stufenschalter
		map.put("l181", "G13"); //Lampe Abfahrbefehl / Notbremsanforderung (NBA)
		map.put("l182.3", "A6"); //Lampe Türfreigabe links
		map.put("l185", "G1"); //Lampe Tür offen
		map.put("l182.4", "F0"); //Lampe Türfreigabe rechts
		map.put("l242.2", "G14"); //Lampe M-Taste
		map.put("lm242.2", "E0"); //Magnet M-Taste
	}

}
