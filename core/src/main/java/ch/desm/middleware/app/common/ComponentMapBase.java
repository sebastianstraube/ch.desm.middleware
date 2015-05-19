package ch.desm.middleware.app.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ComponentMapBase {

	protected Map<String, String> map;

    /**
     *
     * @return initialized map
     */
    public abstract Map<String, String> getMap();

    /**
     * map initializing
     */
    protected abstract void init();

	/**
	 * 
	 */
	public ComponentMapBase() {
        this.map = new HashMap<String, String>();
		this.init();
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public String getKey(String value){
		for(Entry<String, String> entry : map.entrySet()){
			if(entry.getValue().toUpperCase().equalsIgnoreCase(value.toUpperCase())){
				return entry.getKey();
			}
		}
		return "";
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		for(Entry<String, String> entry : map.entrySet()){
			if(entry.getKey().toUpperCase().equalsIgnoreCase(key.toUpperCase())){
				return entry.getValue();
			}
		}
		return "";
	}

    /**
     *
     * @param key
     * @return
     */
    public String getStartWithKey(String key){
        for(Entry<String, String> entry : map.entrySet()){
            if(entry.getKey().toUpperCase().startsWith(key.toUpperCase())){
                return entry.getValue();
            }
        }
        return "";
    }

    public boolean isKeyAvailable(String id){
        return map.containsKey(id);
    }

    public boolean isKeyAvailableIgnoreCase(String id){
        return !getStartWithKey(id).isEmpty();
    }
	
}
