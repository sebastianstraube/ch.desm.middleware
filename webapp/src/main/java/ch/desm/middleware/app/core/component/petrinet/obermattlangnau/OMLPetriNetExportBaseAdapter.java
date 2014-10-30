package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * wrapper class around the petri net class provided by the pnlm export that is
 * caring about the event communication between enpoint and petri net.
 */
public class OMLPetriNetExportBaseAdapter extends OMLPetriNetExportBase {

	private static Logger LOGGER = Logger.getLogger(OMLPetriNetExportBaseAdapter.class);

	private List<String> firedTransitions = new ArrayList<String>();
    private Object firedTransitionsLock = new Object();

	public boolean canFire(String s) {
		LOGGER.log(Level.TRACE, "can fire: " + s);
		return super.canFire(s);
	}

	public void fire(String s) {
        synchronized (firedTransitionsLock){
            firedTransitions.add(s);
            LOGGER.log(Level.TRACE,"petrinet has fired transition buffer: "
                    + firedTransitions.toString());
        }
	}

    public List<String> moveFiredTransitions(){
        ArrayList<String> firedTransitionsCopy = new ArrayList<String>();
        synchronized (firedTransitionsLock){
            firedTransitionsCopy.addAll(firedTransitions);
            firedTransitions.clear();
        }
        return firedTransitionsCopy;
    }

	public void setSensor(String name) {
		setSensor(name, 1);
	}

	public void setSensor(String name, int value) {
		try {
			LOGGER.log(Level.INFO, "setting sensor: " + name + " to: " + value);

			Class<?> petriNetClass = super.getClass();
			Field field = petriNetClass.getField(name);
			field.setInt(this, value);
		} catch (NoSuchFieldException e) {

			LOGGER.log(Level.WARN,"unknown petrinet sensor " + name);

		} catch (IllegalAccessException e) {

			LOGGER.error("unable to set sensor", e);
		}
	}

	public void initMarker() {
		
		Class<?> superClass = this.getClass().getSuperclass();
		Field[] fields = superClass.getDeclaredFields();

		for (Field classField : fields) {
			Class<?> c = classField.getType();
			if(c.equals(int.class)){
				try {
					
					Integer value = Integer.valueOf(String.valueOf(classField.getInt(this)));
					
					// send marker to broker clients
					// which are initialized with 1
					if(value == 1){
                        String name = classField.getName();
                        fire(name);
                    }
                } catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
