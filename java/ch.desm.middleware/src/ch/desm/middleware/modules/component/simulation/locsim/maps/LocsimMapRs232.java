package ch.desm.middleware.modules.component.simulation.locsim.maps;

import java.util.Map;
import java.util.Map.Entry;

import ch.desm.middleware.modules.communication.message.store.MessageMapBase;


public class LocsimMapRs232 extends MessageMapBase {
	
	@Override
	public Map<String, String> getMap() {
		return map;
	}
	
	public String getValue(String signalType, String channel){
		
		for(Entry<String, String> entry : map.entrySet()){
			if(entry.getKey().equalsIgnoreCase(signalType+channel)){
				return entry.getValue();
			}
		}
		
		return "";
	}
	
	@Override
	protected void initialize(){
		map.put("V40","S241");
//		map.put("","locsim.auslöseschalter");
//		map.put("","locsim.hauptleitungsdruck");
//		map.put("","locsim.rangierbremse");
//		map.put("","locsim.hldruck");
//		map.put("","locsim.bremszylinderdruck");
//		map.put("","locsim.fahrleitungsspannung");
		map.put("U16","S172.1");
		map.put("U17","S172.2");
		map.put("U08","locsim.fahrschalter.bremsen.plus");
		map.put("U07","locsim.fahrschalter.bremsen.punkt");
		map.put("U06","locsim.fahrschalter.bremsen.minus");
		map.put("U05","locsim.fahrschalter.0.null");
		map.put("U04","locsim.fahrschalter.fahren.minus");
		map.put("U03","locsim.fahrschalter.fahren.punkt");
		map.put("U02","locsim.fahrschalter.fahren.m");
		map.put("U01","locsim.fahrschalter.fahren.plus");
		map.put("U00","locsim.fahrschalter.fahren.plusplus");
		map.put("U09","S140a");
		map.put("U10","S140b");
		map.put("U18","S132");
		map.put("U34","S316.4");
		map.put("U35","S316.1");
		map.put("U36","S316.5");
		map.put("U37","S316.2");
		map.put("U38","S316.6");
		map.put("U39","S316.3");
		map.put("U44","S324");
		map.put("U43","S324.2");
		map.put("U28","S242.02");
		map.put("U23","S182.3");
		map.put("U25","S182.4");
		map.put("U24","S182");
//		map.put("","locsim.wagentürenzustandinfo");
//		map.put("","S311");
		map.put("U15","S169");
		map.put("U30","S189.1");
		map.put("U31","S189.2");
		map.put("U32","S242.01");
		map.put("U22","S281");
		map.put("U00","locsim.schlüsselschalterabfertigungsbefehl");
		map.put("U20","S126");
		map.put("U19","S129");
		map.put("U27","S235");

	}
}

