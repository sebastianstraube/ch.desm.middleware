package ch.desm.middleware.app.module.petrinet.re420.map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

import java.util.Map;

public class PetrinetRe420MapZusiFahrpult extends ComponentMapBase{

	@Override
	public Map<String, String> getMap() {
		return map;
	}

	@Override
	protected void init(){
		map.put("cabine_re420_totmannpedal_$on","0200-0A01-0100::0100:1000,0200:0000,0300:0100,0400:0000,0500:00000000"); //
		map.put("cabine_re420_totmannpedal_$off","0200-0A01-0100::0100:1000,0200:0000,0300:0200,0400:0000,0500:00000000"); //


// map.put("cabine_re420_stromabnehmer_controller_$S129",""); //Schalter
		map.put("cabine_re420_stromabnehmer_$stromabnehmer_hoch","0200-0A01-0100::0100:2b00,0200:0000,0300:0700,0400:0200,0500:00000000"); //Schalter
		map.put("cabine_re420_stromabnehmer_$stromabnehmer_tief","0200-0A01-0100::0100:2b00,0200:0000,0300:0700,0400:0000,0500:00000000"); //Schalter
// map.put("cabine_re420_hauptschalter_controller_$S132",""); //Schalter
		map.put("cabine_re420_hauptschalter_$hauptschalter_ein","0200-0A01-0100::0100:1100,0200:0000,0300:0700,0400:0200,0500:00000000"); //Schalter
		map.put("cabine_re420_hauptschalter_$hauptschalter_aus","0200-0A01-0100::0100:1100,0200:0000,0300:0700,0400:0000,0500:00000000"); //Schalter
// map.put("",""); //Schalter
// map.put("",""); //Schalter
// map.put("cabine_re420_zugsammelschiene_$zusammelschiene_ein",""); //Schalter
// map.put("cabine_re420_zugsammelschiene_$zusammelschiene_aus",""); //Schalter
// map.put("cabine_re420_wendeschalter_controller_$140a",""); //Schalter
// map.put("cabine_re420_wendeschalter_controller_$140b",""); //Schalter
		map.put("cabine_re420_wendeschalter_$wendeschalter_V","0200-0A01-0100::0100:0700,0200:0000,0300:0700,0400:0200,0500:00000000"); //Schalter
		map.put("cabine_re420_wendeschalter_$wendeschalter_0","0200-0A01-0100::0100:0700,0200:0000,0300:0700,0400:0100,0500:00000000"); //Schalter
		map.put("cabine_re420_wendeschalter_$wendeschalter_R","0200-0A01-0100::0100:0700,0200:0000,0300:0700,0400:0000,0500:00000000"); //Schalter
// map.put("cabine_re420_fahrschalter_controller_$s150a",""); //
// map.put("cabine_re420_fahrschalter_controller_$s150b",""); //
// map.put("cabine_re420_fahrschalter_controller_$s150d",""); //
// map.put("cabine_re420_fahrschalter_controller_$s150e",""); //
// map.put("cabine_re420_fahrschalter_controller_$s150f",""); //
// map.put("cabine_re420_fahrschalter_controller_$s150g",""); //
// map.put("cabine_re420_fahrschalter_controller_$s150l",""); //


		map.put("cabine_re420_fahrschalter_controller_$bremsen_plus",   "0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0800,0500:00000000"); //Fahrschalter
		map.put("cabine_re420_fahrschalter_controller_$bremsen_punkt",  "0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0700,0500:00000000"); //Fahrschalter
		map.put("cabine_re420_fahrschalter_controller_$bremsen_minus",  "0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0600,0500:00000000"); //Fahrschalter
		map.put("cabine_re420_fahrschalter_controller_$neutral",        "0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0500,0500:00000000"); //Fahrschalter
		map.put("cabine_re420_fahrschalter_controller_$fahren_minus",   "0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0400,0500:00000000"); //Fahrschalter
		map.put("cabine_re420_fahrschalter_controller_$fahren_punkt",   "0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0300,0500:00000000"); //Fahrschalter
		map.put("cabine_re420_fahrschalter_controller_$fahren_m",       "0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0200,0500:00000000"); //Fahrschalter
		map.put("cabine_re420_fahrschalter_controller_$fahren_plus",    "0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0100,0500:00000000"); //Fahrschalter
		map.put("cabine_re420_fahrschalter_controller_$fahren_plusplus","0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0000,0500:00000000"); //Fahrschalter
    }

}
