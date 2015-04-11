package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.core.common.Pair;
import ch.desm.middleware.app.core.component.common.ComponentMapBase;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapParameterMiddleware  {

    HashMap<String, Pair<String, String>> map;

    public ZusiMapParameterMiddleware(){
        this.map = new HashMap<>();
        this.init();
    }

    public Map<String, Pair<String, String>> getMap() {
        return map;
    }

    //Pair{on, off}
    protected void init(){
        map.put("0200-0a00::5500", new Pair<>("1","0"));
        map.put("0200-0a00::1300", new Pair<>("1","0"));
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
