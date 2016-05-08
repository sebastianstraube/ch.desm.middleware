package ch.desm.middleware.module.simulation.zusi.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapParameterRe420 {

    public class OnOffState {
        private final String onState;
        private final String offState;

        public OnOffState(String onState, String offState) {
            this.onState = onState;
            this.offState = offState;
        }

        public String getOffState() {
            return offState;
        }

        public String getOnState() {
            return onState;
        }
    }

    Map<String, OnOffState> map = new HashMap();

    public ZusiMapParameterRe420() {
        map.put("S129", new OnOffState("02","00")); // Stromabnehmer
        map.put("S132", new OnOffState("02","00")); // Hauptschalter
        map.put("S140a", new OnOffState("02","01")); // Steuerstrom
        map.put("S140b", new OnOffState("00","01")); // Steuerstrom
        map.put("S235", new OnOffState("01","02")); // Steuerstrom
    }

    public boolean hasValue(String key) {
        for(Map.Entry<String, OnOffState> entry : map.entrySet()){
            if(entry.getKey().equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }

    public OnOffState getValue(String key){
        for(Map.Entry<String, OnOffState> entry : map.entrySet()){
            if(entry.getKey().equalsIgnoreCase(key)){
                return entry.getValue();
            }
        }
        return null;
    }
}
