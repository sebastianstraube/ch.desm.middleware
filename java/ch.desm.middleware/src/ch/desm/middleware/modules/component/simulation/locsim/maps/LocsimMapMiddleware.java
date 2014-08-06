package ch.desm.middleware.modules.component.simulation.locsim.maps;

import java.util.Map;

import ch.desm.middleware.modules.component.ComponentMapBase;


public class LocsimMapMiddleware extends ComponentMapBase {
	
	@Override
	public Map<String, String> getMap() {
		return map;
	}
	
	@Override
	protected void initialize(){
		
		map.put("locsim.initialization.ready.ini1", "locsim.initialization.ready.ini1;os;0;message;initialisiation;ini1;?;locsim-rs232;#");
		map.put("locsim.initialization.ready.ini7", "locsim.initialization.ready.ini7;os;0;message;initialisiation;ini7;?;locsim-rs232;#");
		map.put("locsim.initialization.ready.ini2", "locsim.initialization.ready.ini2;os;0;message;initialisiation;ini2;?;locsim-rs232;#");
		
		
		map.put("S126", "s126;i;0;schalter;steuerstrom;0;?;kabinere420;#");
		map.put("S129", "s129;i;0;schalter;stromabnehmer;0;?;kabinere420;#");
		map.put("S132", "s132;i;0;schalter;haupt;0;?;kabinere420;#");
		map.put("s235", "s235;i;0;schalter;sifa;pedal;?;kabinere420;#");
		
		map.put("s140a", "s140a;i;0;schalter;wende;vorwärts;?;kabinere420;#");
		map.put("s140b", "s140b;i;0;schalter;wende;rückwärts;?;kabinere420;#");

		map.put("fahrschalter.bremsen.plus", "fahrschalter.bremsen.plus;i;0;fahrschalter;bremse;plus;?;kabinere420;#");
		map.put("fahrschalter.bremsen.punkt", "fahrschalter.bremsen.punkt;i;0;fahrschalter;bremse;punkt;?;kabinere420;#");
		map.put("fahrschalter.bremsen.minus", "fahrschalter.bremsen.minus;i;0;fahrschalter;bremse;minus;?;kabinere420;#");
		map.put("fahrschalter.neutral", "fahrschalter.neutral;i;0;fahrschalter;neutral;;?;kabinere420;#");
		map.put("fahrschalter.fahren.minus", "fahrschalter.fahren.minus;i;0;fahrschalter;fahren;minus;?;kabinere420;#");
		map.put("fahrschalter.fahren.punkt", "fahrschalter.fahren.punkt;i;0;fahrschalter;fahren;punkt;?;kabinere420;#");
		map.put("fahrschalter.fahren.m", "fahrschalter.fahren.m;i;0;fahrschalter;fahren;m;?;kabinere420;#");
		map.put("fahrschalter.fahren.plus", "fahrschalter.fahren.plus;i;0;fahrschalter;fahren;plus;?;kabinere420;#");
		map.put("fahrschalter.fahren.plusplus", "fahrschalter.fahren.plusplus;i;0;fahrschalter;fahren;plusplus;?;kabinere420;#");

		//output
//		map.put("s242.02", "s242.02;i;0;taste;zugsicherung;manöver;?;kabinere420;#");
//		map.put("w238_t", "w238_t;o;0;warntongeber;signum;tief;?;kabinere420;#");
//		map.put("w238_h", "w238_h;o;0;warntongeber;signum;hoch;?;kabinere420;#");
//		map.put("l242b", "l242b;o;0;lampe;zugsicherung;warnung;?;kabinere420;#");
//		map.put("l242a", "l242a;o;0;lampe;zugsicherung;halt;?;kabinere420;#");
//
//
//		map.put("a74", "a74;o;0;analog-instrument;spannung;fahrdraht;?;kabinere420;#");
//		map.put("a79", "a79;o;0;analog-instrument;strom;i_max;?;kabinere420;#");
//		map.put("a79.1", "a79.1;o;0;analog-instrument;strom;i_delta;?;kabinere420;#");
//		map.put("l281", "l281;o;0;lampe;meldelampe;schleudern;?;kabinere420;#");
//		map.put("l281.1", "l281.1;o;0;taste;schleuderbremse;kabine;?;kabinere420;#");
//		map.put("l83", "l83;o;0;lampe;meldelampe;zssheizlampe;?;kabinere420;#");
//		map.put("l175", "l175;o;0;lampe;meldelampe;stoeventi;?;kabinere420;#");
//		map.put("l163", "l163;o;0;lampe;meldelampe;stufensch;?;kabinere420;#");
//		map.put("l181", "l181;o;0;lampe;meldelampe;abf;?;kabinere420;#");
		map.put("l182.3", "l182.3;o;0;lampe;meldelampe;tür_l;?;kabinere420;#");
		map.put("l185", "l185;o;0;lampe;meldelampe;tür_offen;?;kabinere420;#");
		map.put("l182.4", "l182.4;o;0;lampe;meldelampe;tür_r;?;kabinere420;#");
		map.put("l242.2", "l242.2;o;0;lampe;meldelampe;m-taste;?;kabinere420;#");


	}
}
