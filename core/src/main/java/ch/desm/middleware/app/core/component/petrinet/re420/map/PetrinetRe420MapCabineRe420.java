package ch.desm.middleware.app.core.component.petrinet.re420.map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

import java.util.Map;

public class PetrinetRe420MapCabineRe420 extends ComponentMapBase{

	@Override
	public Map<String, String> getMap() {
		return map;
	}

	@Override
	protected void init(){
		map.put("cabine_re420_stromabnehmer_controller_$S129","S129"); //Stromabnehmer
// map.put("cabine_re420_stromabnehmer_$stromabnehmer_hoch",""); //Stromabnehmer
// map.put("cabine_re420_stromabnehmer_$stromabnehmer_tief",""); //Stromabnehmer
		map.put("cabine_re420_hauptschalter_controller_$S132","S132"); //Hauptschalter
// map.put("cabine_re420_hauptschalter_$hauptschalter_ein",""); //Hauptschalter
// map.put("cabine_re420_hauptschalter_$hauptschalter_aus",""); //Hauptschalter
// map.put("",""); //Kompressor Automat
// map.put("",""); //Kompressor direkt
		map.put("cabine_re420_zugsammelschiene_$S169","S169"); //Zugsammelschiene
// map.put("cabine_re420_zugsammelschiene_$zusammelschiene_ein",""); //Zugsammelschiene
// map.put("cabine_re420_zugsammelschiene_$zusammelschiene_aus",""); //Zugsammelschiene
		map.put("cabine_re420_wendeschalter_controller_$140a","S140a"); //Wendeschalter 140a vorwärts
		map.put("cabine_re420_wendeschalter_controller_$140b","S140b"); //Wendeschalter 140b rückwärts
// map.put("cabine_re420_wendeschalter_$wendeschalter_V",""); //Wendeschalter vorwärts
// map.put("cabine_re420_wendeschalter_$wendeschalter_0",""); //Wendeschalter null
// map.put("cabine_re420_wendeschalter_$wendeschalter_R",""); //Wendeschalter rückwärts
		map.put("cabine_re420_fahrschalter_controller_$s150a","S150a"); //Fahrschalter 150a
		map.put("cabine_re420_fahrschalter_controller_$s150b","S150b"); //Fahrschalter 150b
		map.put("cabine_re420_fahrschalter_controller_$s150d","S150d"); //Fahrschalter 150d
		map.put("cabine_re420_fahrschalter_controller_$s150e","S150e"); //Fahrschalter 150e
		map.put("cabine_re420_fahrschalter_controller_$s150f","S150f"); //Fahrschalter 150f
		map.put("cabine_re420_fahrschalter_controller_$s150g","S150g"); //Fahrschalter 150g
		map.put("cabine_re420_fahrschalter_controller_$s150l","S150l"); //Fahrschalter 150l
// map.put("cabine_re420_fahrschalter_logik_$bremsen_plus",""); //Fahrschalter.bremsen.plus
// map.put("cabine_re420_fahrschalter_logik_$bremsen_punkt",""); //Fahrschalter.bremsen.punkt
// map.put("cabine_re420_fahrschalter_logik_$bremsen_minus",""); //Fahrschalter.bremsen.minus
// map.put("cabine_re420_fahrschalter_logik_$neutral",""); //Fahrschalter.neutral
// map.put("cabine_re420_fahrschalter_logik_$fahren_minus",""); //Fahrschalter.fahren.minus
// map.put("cabine_re420_fahrschalter_logik_$fahren_punkt",""); //Fahrschalter.fahren.punkt
// map.put("cabine_re420_fahrschalter_logik_$fahren_m",""); //Fahrschalter.fahren.m
// map.put("cabine_re420_fahrschalter_logik_$fahren_plus",""); //Fahrschalter.fahren.plus
// map.put("cabine_re420_fahrschalter_logik_$fahren_plusplus",""); //Fahrschalter.fahren.plusplus
// map.put("cabine_re420_fahrschalter_controller_$bremsen_plus",""); //Fahrschalter.bremsen.plus
// map.put("cabine_re420_fahrschalter_controller_$bremsen_punkt",""); //Fahrschalter.bremsen.punkt
// map.put("cabine_re420_fahrschalter_controller_$bremsen_minus",""); //Fahrschalter.bremsen.minus
// map.put("cabine_re420_fahrschalter_controller_$neutral",""); //Fahrschalter.neutral
// map.put("cabine_re420_fahrschalter_controller_$fahren_minus",""); //Fahrschalter.fahren.minus
// map.put("cabine_re420_fahrschalter_controller_$fahren_punkt",""); //Fahrschalter.fahren.punkt
// map.put("cabine_re420_fahrschalter_controller_$fahren_m",""); //Fahrschalter.fahren.m
// map.put("cabine_re420_fahrschalter_controller_$fahren_plus",""); //Fahrschalter.fahren.plus
// map.put("cabine_re420_fahrschalter_controller_$fahren_plusplus",""); //Fahrschalter.fahren.plusplus
// map.put("cabine_re420_fahrschalter_controller_$hasstate",""); //Controller State

    }

}
