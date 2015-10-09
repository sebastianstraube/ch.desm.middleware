package ch.desm.middleware.app.module.simulation.zusi.map;

import ch.desm.middleware.app.common.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapParameterRe420 {

    HashMap<String, Pair<String, String>> map;

    public ZusiMapParameterRe420(){
        this.map = new HashMap();
        this.init();
    }

    public Map<String, Pair<String, String>> getMap() {
        return map;
    }

    //Pair{on, off}
    protected void init(){
        map.put("S129", new Pair<String, String>("02","00")); // Stromabnehmer
        map.put("S132", new Pair<String, String>("02","00")); // Hauptschalter
        map.put("S140a", new Pair<String, String>("02","01")); // Steuerstrom
        map.put("S140b", new Pair<String, String>("00","01")); // Steuerstrom
        map.put("S235", new Pair<String, String>("01","02")); // Steuerstrom

    }

    /**
     *
     * @param key
     * @return
     */
    public Pair<String, String> getValue(String key){
        for(Map.Entry<String, Pair<String, String>> entry : map.entrySet()){
            if(entry.getKey().equalsIgnoreCase(key)){
                return entry.getValue();
            }
        }
        return null;
    }
}
