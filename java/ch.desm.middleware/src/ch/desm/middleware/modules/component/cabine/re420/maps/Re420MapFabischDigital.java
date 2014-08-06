package ch.desm.middleware.modules.component.cabine.re420.maps;

import java.util.Map;

import ch.desm.middleware.modules.component.ComponentMapBase;

public class Re420MapFabischDigital extends ComponentMapBase {

	public Re420MapFabischDigital() {
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

	protected void initialize() {

//		map.put("w238_t","5d5c03");//Tiefton (Schnellgang, Signum, Totmann)
//		map.put("w238_h","5d5c02");//Hochton (Langsamgang)
//		map.put("cabine.zusi.hauptsignalueberfahren","5dc001");//cabine.zusi.hauptsignalueberfahren
//		map.put("cabine.zusi.nachvorgesorgt","5dc002");//cabine.zusi.nachvorgesorgt
//		map.put("cabine.zusi.m","5dc003");//cabine.zusi.m
//		map.put("cabine.zusi.quittiert","5dc004");//cabine.zusi.quittiert
//		map.put("cabine.zusi.vorgesorgt","5dc005");//cabine.zusi.vorgesorgt
//		map.put("cabine.zusi.vorsignalwarnung","5dc006");//cabine.zusi.vorsignalwarnung
//		map.put("d94vi.1","24e000-FF");//Vist-LZB.1
//		map.put("l281","23f002");//Lampe Schleuderbremse
//		map.put("l83","423602");//Lampe Zugsammelschiene
//		map.put("l175","445c02");//Lampe Ventilation/ Oelpumpe
//		map.put("l163","3fac01");//Lampe Stufenschalter
//		map.put("l181","46b402");//Lampe Abfahrbefehl
		map.put("l182.3","4791#01#02");//Lampe Türfreigabe links
		map.put("l185","4844#02#03#01");//Lampe Tür offen
		map.put("l182.4","4787#01#02");//Lampe Türfreigabe rechts
//		map.put("l242.2","5dc003");//Lampe M-Taste
//		map.put("a74","1ce800-FF");//kV-Anzeige
//		map.put("a79","1edc00-FF");//A-Anzeige Motorenstrom
//		map.put("a79.1","1ee600-FF");//A-Anzeige Differenzstrom

		


	}

}