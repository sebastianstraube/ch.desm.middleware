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


    public boolean isKeyAvailable(String id){
        return map.containsKey(id);
    }

	/**
	 * TODO should be protected
	 * @return initialized map
	 */
	@SuppressWarnings("rawtypes")
	public abstract Map getMap();
	
	/**
	 * map initializing
	 */
	protected abstract void init();
	
}
