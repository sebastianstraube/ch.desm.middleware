package ch.desm.middleware.app.module.petrinet.re420.map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

import java.util.Map;

public class PetrinetRe420MapMiddleware extends ComponentMapBase{

	@Override
	public Map<String, String> getMap() {
		return map;
	}

	@Override
	protected void init(){

		map.put("cabine_re420_stromabnehmer_controller_$s129", "cabine_re420_stromabnehmer_controller_$s129;i;0;schalter;stromabnehmer;0;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_stromabnehmer_$stromabnehmer_hoch", "cabine_re420_stromabnehmer_$stromabnehmer_hoch;i;0;schalter;stromabnehmer;0;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_stromabnehmer_$stromabnehmer_tief", "cabine_re420_stromabnehmer_$stromabnehmer_tief;i;0;schalter;stromabnehmer;0;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_hauptschalter_controller_$s132", "cabine_re420_hauptschalter_controller_$s132;i;0;schalter;haupt;0;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_hauptschalter_$hauptschalter_ein", "cabine_re420_hauptschalter_$hauptschalter_ein;i;0;schalter;haupt;0;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_hauptschalter_$hauptschalter_aus", "cabine_re420_hauptschalter_$hauptschalter_aus;i;0;schalter;haupt;0;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_zugsammelschiene_$s169", "cabine_re420_zugsammelschiene_$s169;i;0;schalter;zugsammelschiene;0;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_zugsammelschiene_$zusammelschiene_ein", "cabine_re420_zugsammelschiene_$zusammelschiene_ein;i;0;schalter;zugsammelschiene;0;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_zugsammelschiene_$zusammelschiene_aus", "cabine_re420_zugsammelschiene_$zusammelschiene_aus;i;0;schalter;zugsammelschiene;0;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_wendeschalter_controller_$140a", "cabine_re420_wendeschalter_controller_$140a;i;0;schalter;wende;vorwärts;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_wendeschalter_controller_$140b", "cabine_re420_wendeschalter_controller_$140b;i;0;schalter;wende;rückwärts;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_wendeschalter_$wendeschalter_v", "cabine_re420_wendeschalter_$wendeschalter_v;i;0;schalter;wende;vorwärts;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_wendeschalter_$wendeschalter_0", "cabine_re420_wendeschalter_$wendeschalter_0;i;0;schalter;wende;vorwärts;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_wendeschalter_$wendeschalter_r", "cabine_re420_wendeschalter_$wendeschalter_r;i;0;schalter;wende;rückwärts;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$s150a", "cabine_re420_fahrschalter_controller_$s150a;i;;;;;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$s150b", "cabine_re420_fahrschalter_controller_$s150b;i;;;;;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$s150d", "cabine_re420_fahrschalter_controller_$s150d;i;;;;;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$s150e", "cabine_re420_fahrschalter_controller_$s150e;i;;;;;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$s150f", "cabine_re420_fahrschalter_controller_$s150f;i;;;;;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$s150g", "cabine_re420_fahrschalter_controller_$s150g;i;;;;;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$s150l", "cabine_re420_fahrschalter_controller_$s150l;i;;;;;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_logik_$bremsen_plus", "cabine_re420_fahrschalter_logik_$bremsen_plus;i;0;fahrschalter;bremse;plus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_logik_$bremsen_punkt", "cabine_re420_fahrschalter_logik_$bremsen_punkt;i;0;fahrschalter;bremse;punkt;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_logik_$bremsen_minus", "cabine_re420_fahrschalter_logik_$bremsen_minus;i;0;fahrschalter;bremse;minus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_logik_$neutral", "cabine_re420_fahrschalter_logik_$neutral;i;0;fahrschalter;neutral;;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_logik_$fahren_minus", "cabine_re420_fahrschalter_logik_$fahren_minus;i;0;fahrschalter;fahren;minus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_logik_$fahren_punkt", "cabine_re420_fahrschalter_logik_$fahren_punkt;i;0;fahrschalter;fahren;punkt;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_logik_$fahren_m", "cabine_re420_fahrschalter_logik_$fahren_m;i;0;fahrschalter;fahren;m;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_logik_$fahren_plus", "cabine_re420_fahrschalter_logik_$fahren_plus;i;0;fahrschalter;fahren;plus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_logik_$fahren_plusplus", "cabine_re420_fahrschalter_logik_$fahren_plusplus;i;0;fahrschalter;fahren;plusplus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$bremsen_plus", "cabine_re420_fahrschalter_controller_$bremsen_plus;i;0;fahrschalter;bremse;plus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$bremsen_punkt", "cabine_re420_fahrschalter_controller_$bremsen_punkt;i;0;fahrschalter;bremse;punkt;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$bremsen_minus", "cabine_re420_fahrschalter_controller_$bremsen_minus;i;0;fahrschalter;bremse;minus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$neutral", "cabine_re420_fahrschalter_controller_$neutral;i;0;fahrschalter;neutral;;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$fahren_minus", "cabine_re420_fahrschalter_controller_$fahren_minus;i;0;fahrschalter;fahren;minus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$fahren_punkt", "cabine_re420_fahrschalter_controller_$fahren_punkt;i;0;fahrschalter;fahren;punkt;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$fahren_m", "cabine_re420_fahrschalter_controller_$fahren_m;i;0;fahrschalter;fahren;m;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$fahren_plus", "cabine_re420_fahrschalter_controller_$fahren_plus;i;0;fahrschalter;fahren;plus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$fahren_plusplus", "cabine_re420_fahrschalter_controller_$fahren_plusplus;i;0;fahrschalter;fahren;plusplus;?;petrinet_cabine_re420;#");
		map.put("cabine_re420_fahrschalter_controller_$hasstate", "cabine_re420_fahrschalter_controller_$hasstate;i;0;controller;state;settled;?;petrinet_cabine_re420;#");
    }

}
