package ch.desm.middleware.modules.component.cabine.re420.elements;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import ch.desm.middleware.modules.component.ComponentMapBase;

public class Re420ElementFahrschalter extends ComponentMapBase {

	private static Logger log = Logger.getLogger(Re420ElementFahrschalter.class);
	
	private Boolean s150a;
	private Boolean s150b;
	private Boolean s150d;
	private Boolean s150e;
	private Boolean s150f;
	private Boolean s150g;
	private Boolean s150l;

	ArrayList<String> disabledList;
	/**
	 * TODO refactoring
	 */
	public ArrayList<String> keyListFahrschalter;
	
	public Re420ElementFahrschalter(){
		super();
		disabledList = new ArrayList<String>();
		initializeFahrschalter();
	}
	
	private boolean isInitialized(){
		
		if (s150a != null
				&& s150b != null
				&& s150d != null
				&& s150e != null
				&& s150f != null
				&& s150g != null
				&& s150l != null){
			
			return true;
		}
		
		return false;
	}
	/**
	 * 
	 * @return the global id (key) from the buffered contacts
	 */
	public String getMessagePositionFahrschalter(String key, boolean isEnabled) {		
		boolean isChanged = isChanged(key, isEnabled);
		boolean isFarschalterInitialized = isInitialized();
		
		if(isChanged && isFarschalterInitialized){
			
			if (!s150a
					&& !s150b
					&& !s150d
					&& !s150e
					&& !s150f
					&& !s150g
					&& !s150l) {
				key = "fahrschalter.neutral";
			}
			else if (s150b
					&& s150d
					&& s150e
					&& s150g
					&& s150l) {
				key = "fahrschalter.fahren.m";
			}
			else if (s150b
					&& s150e
					&& s150f
					&& s150g
					&& s150l) {
				key = "fahrschalter.fahren.plusplus";
			}
			else if (s150a && s150e
					&& s150g
					&& s150l) {
				key = "fahrschalter.bremsen.plus";
			} 
			else if (s150a
					&& s150g) {
				key = "fahrschalter.bremsen.punkt";
			} 
			else if (s150a
					&& s150l) {
				key = "fahrschalter.bremsen.minus";
			}
			
			else if (s150b
					&& s150l) {
				key = "fahrschalter.fahren.minus";
			} 
			else if (s150b
					&& s150g) {
				key = "fahrschalter.fahren.punkt";
			} 
			
			else if (s150b
					&& s150e
					&& s150g) {
				key = "fahrschalter.fahren.plus";
			}
			
			else{
				if(keyListFahrschalter.contains(key)){
					log.trace("fahrschalter position unknown with key " + key);
					key = "";
				}
			}
		}else{
			if(!isChanged || !isFarschalterInitialized){
				key = "";
			}
		}
		
		return key;
	}

	private boolean isChanged(String key, boolean value) {
		boolean isChanged = false;

        if (key.equals("s150a")) {
            if (s150a == null || !s150a.equals(value)) {
                s150a = value;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150b")) {
            if (s150b == null || !s150b.equals(value)) {
                s150b = value;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150d")) {
            if (s150d == null || !s150d.equals(value)) {
                s150d = value;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150e")) {
            if (s150e == null || !s150e.equals(value)) {
                s150e = value;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150f")) {
            if (s150f == null || !s150f.equals(value)) {
                s150f = value;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150g")) {
            if (s150g == null || !s150g.equals(value)) {
                s150g = value;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150l")) {
            if (s150l == null || !s150l.equals(value)) {
                s150l = value;
                isChanged = true;
            } else {
                isChanged = false;
            }
        }
		
		return isChanged;
	}

	@Override
	public Map<String, String> getMap() {
		return map;
	}
	
	private void initializeFahrschalter(){
		keyListFahrschalter = new ArrayList<String>();
		keyListFahrschalter.add("s150a");
		keyListFahrschalter.add("s150b");
		keyListFahrschalter.add("s150d");
		keyListFahrschalter.add("s150e");
		keyListFahrschalter.add("s150f");
		keyListFahrschalter.add("s150g");
		keyListFahrschalter.add("s150l");
	}
	
	@Override
	protected void initialize() {		
		map.put("fahrschalter.bremsen.plus", "fahrschalter.bremsen.plus;i;0;fahrschalter;bremse;plus;?;kabinere420;#");
		map.put("fahrschalter.bremsen.punkt", "fahrschalter.bremsen.punkt;i;0;fahrschalter;bremse;punkt;?;kabinere420;#");
		map.put("fahrschalter.bremsen.minus", "fahrschalter.bremsen.minus;i;0;fahrschalter;bremse;minus;?;kabinere420;#");
		map.put("fahrschalter.neutral", "fahrschalter.neutral;i;0;fahrschalter;neutral;;?;kabinere420;#");
		map.put("fahrschalter.fahren.minus", "fahrschalter.fahren.minus;i;0;fahrschalter;fahren;minus;?;kabinere420;#");
		map.put("fahrschalter.fahren.punkt", "fahrschalter.fahren.punkt;i;0;fahrschalter;fahren;punkt;?;kabinere420;#");
		map.put("fahrschalter.fahren.m", "fahrschalter.fahren.m;i;0;fahrschalter;fahren;m;?;kabinere420;#");
		map.put("fahrschalter.fahren.plus", "fahrschalter.fahren.plus;i;0;fahrschalter;fahren;plus;?;kabinere420;#");
		map.put("fahrschalter.fahren.plusplus", "fahrschalter.fahren.plusplus;i;0;fahrschalter;fahren;plusplus;?;kabinere420;#");
	}

}