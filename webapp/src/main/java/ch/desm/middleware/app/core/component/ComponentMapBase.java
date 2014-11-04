package ch.desm.middleware.app.core.component;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ComponentMapBase {

	protected Map<String, String> map;
	
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
			if(entry.getValue().equalsIgnoreCase(value)){
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
			if(entry.getKey().equalsIgnoreCase(key)){
				return entry.getValue();
			}
		}
		return "";
	}

    /**
     *
     * @param value
     * @return
     */
    public boolean containsValue(String value){
        for(Entry<String, String> entry : map.entrySet()){
            if(entry.getValue().equalsIgnoreCase(value)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param key
     * @return
     */
    public boolean containsKey(String key){
        for(Entry<String, String> entry : map.entrySet()){
            if(entry.getKey().equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;
    }


    public boolean isKeyAvailable(String id){
        return map.containsKey(id);
    }

    public boolean isValueAvailable(String id){
        return map.containsValue(id);
    }

	/**
	 * 
	 * @return initialized map
	 */
	@SuppressWarnings("rawtypes")
	public abstract Map getMap();
	
	/**
	 * map initializing
	 */
	protected abstract void init();
	
}
