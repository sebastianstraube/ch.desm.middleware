package ch.desm.middleware.core.component;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ComponentMapBase {

	protected Map<String, String> map;

	public Map<String, String> getMap() {
		return map;
	}

	/**
	 * map initializing
	 */
	protected void init() {
		//implement this method
	}

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
	public String getKeyForValue(String value){
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
	public String getValueForKey(String key){
		for(Entry<String, String> entry : map.entrySet()){
			if(entry.getKey().equalsIgnoreCase(key)){
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
    public boolean isKeyAvailable(String key){
		for(Entry<String, String> entry : map.entrySet()){
			if(entry.getKey().equalsIgnoreCase(key)) return true;
		}
		return false;
    }

	/**
	 *
	 * @param key
	 * @return
	 */
	public String getStartWithKey(String key){
		for(Entry<String, String> entry : map.entrySet()){
			if(entry.getKey().toLowerCase().startsWith(key.toLowerCase())){
				return entry.getValue();
			}
		}
		return "";
	}
}
