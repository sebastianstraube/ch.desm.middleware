package ch.desm.middleware.app.core.component.cabine.re420.map;

import ch.desm.middleware.app.common.component.ComponentMapBase;

import java.util.Map;

public class Re420MapPetrinetCabineRe420 extends ComponentMapBase {

	public Re420MapPetrinetCabineRe420() {
		super();
	}

	public boolean isKeyAvailable(String id) {
		return map.containsKey(id);
	}

	@Override
	public Map<String, String> getMap() {
		return map;
	}

	protected void init() {
		map.put("S235","cabine_re420_totmannpedal_controller_$S235"); //Schalter
		// map.put("S126.1",""); //Schalter
// map.put("S126",""); //Schalter
		map.put("S129","cabine_re420_stromabnehmer_controller_$S129"); //Schalter
		map.put("S132","cabine_re420_hauptschalter_controller_$S132"); //Schalter
// map.put("S172.1",""); //Schalter
// map.put("S172.2",""); //Schalter
// map.put("S169",""); //Schalter
// map.put("S311",""); //Schalter
// map.put("S316_1",""); //Schalter
// map.put("S316_2",""); //Schalter
		map.put("S140a","cabine_re420_wendeschalter_controller_$140a"); //Schalter
		map.put("S140b","cabine_re420_wendeschalter_controller_$140b"); //Schalter
		map.put("S150a","cabine_re420_fahrschalter_controller_$s150a"); //
		map.put("S150b","cabine_re420_fahrschalter_controller_$s150b"); //
		map.put("S150d","cabine_re420_fahrschalter_controller_$s150d"); //
		map.put("S150e","cabine_re420_fahrschalter_controller_$s150e"); //
		map.put("S150f","cabine_re420_fahrschalter_controller_$s150f"); //
		map.put("S150g","cabine_re420_fahrschalter_controller_$s150g"); //
		map.put("S150l","cabine_re420_fahrschalter_controller_$s150l"); //
// map.put("S189.1",""); //Schalter
// map.put("S189.2",""); //Schalter
// map.put("S242.01",""); //Schalter
// map.put("S242.03",""); //Schalter
// map.put("S242.02",""); //Taste
// map.put("S174",""); //Taste
// map.put("S276_1",""); //Schalter
// map.put("S276_2",""); //Schalter
// map.put("S276_3",""); //Schalter
// map.put("S241",""); //Hebel
// map.put("S281",""); //Taste
// map.put("S182.3",""); //Taste
// map.put("S182.4",""); //Taste
// map.put("S182",""); //Taste
// map.put("S324.1",""); //Schalter
// map.put("S324.2",""); //Tastschalter
// map.put("S317",""); //Tastschalter
// map.put("S316.1",""); //Schalter
// map.put("S316.4",""); //Schalter
// map.put("S316.2",""); //Schalter
// map.put("S316.5",""); //Schalter
// map.put("S316.3",""); //Schalter
// map.put("S316.6",""); //Schalter
// map.put("S324",""); //Schalter
// map.put("S333",""); //Tastschalter
// map.put("S235",""); //Schalter
// map.put("W238_t",""); //Warntongeber
// map.put("W238_h",""); //Warntongeber
// map.put("L317",""); //Lampe
// map.put("L242b",""); //Lampe
// map.put("L242a",""); //Lampe
// map.put("A94",""); //Analog-Instrument
// map.put("D94m",""); //Analoganzeige
// map.put("D94u.1",""); //
// map.put("D94u.2",""); //
// map.put("D94U.3",""); //
// map.put("D94LZB_Z5",""); //Ziffernanzeige
// map.put("D94LZB_Z3",""); //Ziffernanzeige
// map.put("L94_LZB_r",""); //Lampe
// map.put("L94_LZB_gr",""); //Lampe
// map.put("L94_LZB_gb",""); //Lampe
// map.put("L94_LZB_w",""); //Lampe
// map.put("A74",""); //Analog-Instrument
// map.put("A79",""); //Analog-Instrument
// map.put("A79.1",""); //Analog-Instrument
// map.put("P13c_HB",""); //0
// map.put("P13c_HL",""); //0
// map.put("P13c_BZ",""); //0
// map.put("AO269",""); //Drucksensor
// map.put("AO173",""); //Drucksensor
// map.put("L281",""); //Lampe
// map.put("L281.1",""); //Taste
// map.put("L83",""); //Lampe
// map.put("L175",""); //Lampe
// map.put("L163",""); //Lampe
// map.put("L181",""); //Lampe
// map.put("L182.3",""); //Lampe
// map.put("L185",""); //Lampe
// map.put("L182.4",""); //Lampe
// map.put("L242.2",""); //Lampe
// map.put("L318a",""); //Lampe
// map.put("L318b",""); //Lampe
// map.put("L325.2",""); //Lampe
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
