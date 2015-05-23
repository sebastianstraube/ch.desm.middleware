package ch.desm.middleware.app.core.component.cabine.re420.state;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ch.desm.middleware.app.common.ComponentServiceBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Re420StateFahrschalter {

	private static Logger LOGGER = Logger.getLogger(Re420StateFahrschalter.class);

	private Boolean s150a;
	private Boolean s150b;
	private Boolean s150d;
	private Boolean s150e;
	private Boolean s150f;
	private Boolean s150g;
	private Boolean s150l;

	public static Set<String> UBW_KEYS = new HashSet<>(Arrays.asList("s150a", "s150b", "s150d", "s150e", "s150f", "s150g", "s150l"));

	public Re420StateFahrschalter(){
		super();
	}

	/**
	 *
	 * @return
	 */
	private boolean isInitialized(ComponentServiceBase service){
		
		if (s150a != null
				&& s150b != null
				&& s150d != null
				&& s150e != null
				&& s150f != null
				&& s150g != null
				&& s150l != null){
			return true;
		}else{
			LOGGER.log(Level.WARN, "Fahrschalter not yet properly initalized:+" +
					"s150a :" + s150a +
					", s150b :" + s150b +
					", s150d :" + s150d +
					", s150e :" + s150e +
					", s150f :" + s150f +
					", s150g :" + s150g +
					", s150l :" + s150l);
		}

		return false;
	}
	/**
	 * 
	 * @return the global id (key) from the stored contacts
	 */
	public String getFahrschalterKey(ComponentServiceBase service, String key, boolean isEnabled) {
		boolean isChanged = isChanged(key, isEnabled);
		boolean isFarschalterInitialized = isInitialized(service);
		
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
				if(UBW_KEYS.contains(key)){
					LOGGER.log(Level.TRACE, "fahrschalter position unknown with key " + key);
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

	private boolean isChanged(String key, boolean b) {
		boolean isChanged = false;

        if (key.equals("s150a")) {
            if (s150a == null || !s150a.equals(b)) {
                s150a = b;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150b")) {
            if (s150b == null || !s150b.equals(b)) {
                s150b = b;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150d")) {
            if (s150d == null || !s150d.equals(b)) {
                s150d = b;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150e")) {
            if (s150e == null || !s150e.equals(b)) {
                s150e = b;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150f")) {
            if (s150f == null || !s150f.equals(b)) {
                s150f = b;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150g")) {
            if (s150g == null || !s150g.equals(b)) {
                s150g = b;
                isChanged = true;
            } else {
                isChanged = false;
            }
        } else if (key.equals("s150l")) {
            if (s150l == null || !s150l.equals(b)) {
                s150l = b;
                isChanged = true;
            } else {
                isChanged = false;
            }
        }
		
		return isChanged;
	}
}