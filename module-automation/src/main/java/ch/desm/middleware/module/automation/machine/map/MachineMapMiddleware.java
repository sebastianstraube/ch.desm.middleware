package ch.desm.middleware.module.automation.machine.map;

import ch.desm.middleware.core.component.ComponentMapBase;

import java.util.Map;

public class MachineMapMiddleware extends ComponentMapBase {

	public MachineMapMiddleware() {
		super();
	}

	public boolean isKeyAvailable(String id) {
		return map.containsKey(id);
	}

	@Override
	protected void init() {
		map.put("s126.1", "s126.1;;0;schalter;haupthahn;1;kabinere420;b;?;");
		map.put("s126", "s126;i;0;schalter;steuerstrom;0;kabinere420;b;?;");
		map.put("s129", "s129;i;0;schalter;stromabnehmer;0;kabinere420;b;?;");
		map.put("s132", "s132;i;0;schalter;haupt;0;kabinere420;b;?;");
		map.put("s172.1", "s172.1;i;0;schalter;kompressor;a;kabinere420;b;?;");
		map.put("s172.2", "s172.2;i;0;schalter;kompressor;d;kabinere420;b;?;");
		map.put("s169", "s169;i;0;schalter;zugsammelschiene;0;kabinere420;b;?;");
		map.put("s311", "s311;i;0;schalter;zug;0;kabinere420;b;?;");
		map.put("s316_1", "s316_1;i;0;schalter;dienstbel;1;kabinere420;b;?;");
		map.put("s316_2", "s316_2;;0;schalter;dienstbel;2;kabinere420;b;?;");
		map.put("s140a", "s140a;i;0;schalter;wende;vorwärts;kabinere420;b;?;");
		map.put("s140b", "s140b;i;0;schalter;wende;rückwärts;kabinere420;b;?;");
		map.put("s150a", "s150a;i;;;;;kabinere420;b;?;");
		map.put("s150b", "s150b;i;;;;;kabinere420;b;?;");
		map.put("s150d", "s150d;i;;;;;kabinere420;b;?;");
		map.put("s150e", "s150e;i;;;;;kabinere420;b;?;");
		map.put("s150f", "s150f;i;;;;;kabinere420;b;?;");
		map.put("s150g", "s150g;i;;;;;kabinere420;b;?;");
		map.put("s150l", "s150l;i;;;;;kabinere420;b;?;");
		map.put("s189.1", "s189.1;i;0;schalter;pfeife;stufe1;kabinere420;b;?;");
		map.put("s189.2", "s189.2;i;0;schalter;pfeife;stufe2;kabinere420;b;?;");
		map.put("s242.01", "s242.01;i;0;schalter;zugsicherung;zurückstellen;kabinere420;b;?;");
		map.put("s242.03", "s242.03;i;0;schalter;zub;zurückstellen;kabinere420;b;?;");
		map.put("s242.02", "s242.02;i;0;taste;zugsicherung;manöver;kabinere420;b;?;");
		map.put("s174", "s174;;0;taste;ventillator;aus;kabinere420;b;?;");
		map.put("s276_1", "s276_1;;0;schalter;bremse;r;kabinere420;b;?;");
		map.put("s276_2", "s276_2;;0;schalter;bremse;p;kabinere420;b;?;");
		map.put("s276_3", "s276_3;;0;schalter;bremse;g;kabinere420;b;?;");
		map.put("s241", "s241;;0;hebel;bvhahn;0;kabinere420;b;?;");
		map.put("s281", "s281;i;0;taste;schleuderschutz;0;kabinere420;b;?;");
		map.put("s182.3", "s182.3;i;0;taste;türfreigabe;links;kabinere420;b;?;");
		map.put("s182.4", "s182.4;i;0;taste;türfreigabe;rechts;kabinere420;b;?;");
		map.put("s182", "s182;i;0;taste;türverriegelung;0;kabinere420;b;?;");
		map.put("s324.1", "s324.1;;0;schalter;fst;instrumente;kabinere420;b;?;");
		map.put("s324.2", "s324.2;;0;tastschalter;fst;fahrplan;kabinere420;b;?;");
		map.put("s317", "s317;;0;tastschalter;fst;aufblend;kabinere420;b;?;");
		map.put("s316.1", "s316.1;i;0;schalter;stirnlampe;linksweiss;kabinere420;b;?;");
		map.put("s316.4", "s316.4;i;0;schalter;stirnlampe;linksrot;kabinere420;b;?;");
		map.put("s316.2", "s316.2;i;0;schalter;stirnlampe;obenweiss;kabinere420;b;?;");
		map.put("s316.5", "s316.5;i;0;schalter;stirnlampe;obenrot;kabinere420;b;?;");
		map.put("s316.3", "s316.3;i;0;schalter;stirnlampe;rechtsweiss;kabinere420;b;?;");
		map.put("s316.6", "s316.6;i;0;schalter;stirnlampe;rechtsrot;kabinere420;b;?;");
		map.put("s324", "s324;;0;schalter;beleuchtung;führerstand;kabinere420;b;?;");
		map.put("s333", "s333;;0;tastschalter;beleuchtung;instrumente;kabinere420;b;?;");
		map.put("s235", "s235;i;0;schalter;sifa;pedal;kabinere420;b;?;");
		map.put("w238_t", "w238_t;o;0;warntongeber;signum;tief;kabinere420;b;?;");
		map.put("w238_h", "w238_h;o;0;warntongeber;signum;hoch;kabinere420;b;?;");
		map.put("l317", "l317;;0;lampe;fernlicht;dienstbeleuchtung;kabinere420;b;?;");
		map.put("l242b", "l242b;o;0;lampe;zugsicherung;warnung;kabinere420;b;?;");
		map.put("l242a", "l242a;o;0;lampe;zugsicherung;halt;kabinere420;b;?;");
		map.put("a94", "a94;o;0;analog-instrument;geschwindigkeitsanzeige;ist;kabinere420;b;?;");
		map.put("d94m", "d94m;;0;analoganzeige;lzb;weganzeige;kabinere420;b;?;");
		map.put("d94u.1", "d94u.1;o;0;;;;kabinere420;b;?;");
		map.put("d94u.2", "d94u.2;o;0;;;;kabinere420;b;?;");
		map.put("d94u.3", "d94u.3;o;0;;;;kabinere420;b;?;");
		map.put("d94lzb_z5", "d94lzb_z5;;0;ziffernanzeige;lzb;digitalanzeige;kabinere420;b;?;");
		map.put("d94lzb_z3", "d94lzb_z3;;0;ziffernanzeige;lzb;digitalanzeige;kabinere420;b;?;");
		map.put("l94_lzb_r", "l94_lzb_r;;0;lampe;lzb;anzeige ;kabinere420;b;?;");
		map.put("l94_lzb_gr", "l94_lzb_gr;;0;lampe;lzb;anzeige ;kabinere420;b;?;");
		map.put("l94_lzb_gb", "l94_lzb_gb;;0;lampe;lzb;anzeige ;kabinere420;b;?;");
		map.put("l94_lzb_w", "l94_lzb_w;;0;lampe;lzb;anzeige ;kabinere420;b;?;");
		map.put("a74", "a74;o;0;analog-instrument;spannung;fahrdraht;kabinere420;b;?;");
		map.put("a79", "a79;o;0;analog-instrument;strom;i_max;kabinere420;b;?;");
		map.put("a79.1", "a79.1;o;0;analog-instrument;strom;i_delta;kabinere420;b;?;");
		map.put("p13c_hb", "p13c_hb;;0;0;0;0;kabinere420;b;?;");
		map.put("p13c_hl", "p13c_hl;;0;0;0;0;kabinere420;b;?;");
		map.put("p13c_bz", "p13c_bz;;0;0;0;0;kabinere420;b;?;");
		map.put("ao269", "ao269;ia;0;drucksensor;druck;hauptleitung;kabinere420;b;?;");
		map.put("ao173", "ao173;ia;0;drucksensor;druck;bremszylinder;kabinere420;b;?;");
		map.put("l281", "l281;o;0;lampe;meldelampe;schleudern;kabinere420;b;?;");
		map.put("l281.1", "l281.1;o;0;taste;schleuderbremse;kabine;kabinere420;b;?;");
		map.put("l83", "l83;o;0;lampe;meldelampe;zssheizlampe;kabinere420;b;?;");
		map.put("l175", "l175;o;0;lampe;meldelampe;stoeventi;kabinere420;b;?;");
		map.put("l163", "l163;o;0;lampe;meldelampe;stufensch;kabinere420;b;?;");
		map.put("l181", "l181;o;0;lampe;meldelampe;abf;kabinere420;b;?;");
		map.put("l182.3", "l182.3;o;0;lampe;meldelampe;tür_l;kabinere420;b;?;");
		map.put("l185", "l185;o;0;lampe;meldelampe;tür_offen;kabinere420;b;?;");
		map.put("l182.4", "l182.4;o;0;lampe;meldelampe;tür_r;kabinere420;b;?;");
		map.put("l242.2", "l242.2;o;0;lampe;meldelampe;m-taste;kabinere420;b;?;");
		map.put("l318a", "l318a;;0;lampe;dienstbel;weiss;kabinere420;b;?;");
		map.put("l318b", "l318b;;0;lampe;dienstbel;warnsignal;kabinere420;b;?;");
		map.put("l325.2", "l325.2;;0;lampe;fst;fahrplan;kabinere420;b;?;");
	}

}
