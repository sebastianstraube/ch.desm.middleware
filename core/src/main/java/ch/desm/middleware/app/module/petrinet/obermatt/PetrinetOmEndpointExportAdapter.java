package ch.desm.middleware.app.module.petrinet.obermatt;

import java.lang.reflect.Field;
import java.util.*;

import ch.desm.middleware.app.module.petrinet.obermatt.map.PetrinetOmMapDelay;
import ch.desm.middleware.app.core.component.petrinet.Bucket;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * wrapper class around the petri net class provided by the pnlm export that is
 * caring about the event communication between enpoint and petri net.
 */
public class PetrinetOmEndpointExportAdapter extends PetrinetOmEndpointExportBase {

	private static Logger LOGGER = Logger.getLogger(PetrinetOmEndpointExportAdapter.class);

	private final List<Bucket> basePlaces = new LinkedList<>();
    private final List<Bucket> changedPlacesList = new LinkedList<>();
    private final Object lockChangedPlacesList = new Object();

    @Override
    public void init(){
        super.init();
        addAllPlacesToChangedPlaces(getAllPlaces());
    }

    @Override
	public boolean canFire(String s) {
		LOGGER.log(Level.TRACE, "transition can fire: " + s);
        return true;
	}

    @Override
	public void fire(String s) {
        LOGGER.log(Level.INFO, "transitions fired: " + s);

        refreshChangedPlacesList(getAllPlaces(), basePlaces);
        basePlaces.clear();
        basePlaces.addAll(getAllPlaces());
    }

    public void setSensor(String name, int value) {
        try {
            Class<?> petriNetClass = super.getClass();
            Field field = petriNetClass.getField(name);
            if (field.getInt(this) == value) {
                LOGGER.log(Level.DEBUG, "Ignoring sensor change request for " + name + " as its value is already " + value);
                return;
            }

            field.setInt(this, value);
            addChangedPlace(new Bucket(name, value));

            LOGGER.log(Level.INFO, "setting sensor: " + name + " to: " + value);
        } catch (NoSuchFieldException e) {
            LOGGER.log(Level.ERROR,"unknown petrinet sensor " + name);
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.ERROR, "unable to set sensor", e);
        }
    }

    public List<Bucket> getChangedPlaces(){
        List<Bucket> changeList = new LinkedList<>();
        synchronized (lockChangedPlacesList){
            changeList.addAll(changedPlacesList);
            changedPlacesList.clear();
        }
        return changeList;
    }

    private void addAllPlacesToChangedPlaces(List<Bucket> base){
        refreshChangedPlacesList(base, new LinkedList<Bucket>());
    }

    public void addChangedPlace(Bucket bucket){
        synchronized (lockChangedPlacesList){
            changedPlacesList.add(bucket);
            LOGGER.log(Level.INFO, "changed place: " + bucket.toString());
        }
    }

    public boolean isInChangedPlacesList(Bucket bucket){
        synchronized (lockChangedPlacesList){
            boolean contains = changedPlacesList.contains(bucket);
            if(contains) LOGGER.log(Level.TRACE, "changed place:" + bucket.toString() + "already contained in list: " + lockChangedPlacesList.toString());
            return contains;
        }
    }

    private void refreshChangedPlacesList(List<Bucket> changed, List<Bucket> base){
        for(Bucket actualElement: changed){
            if(!base.contains(actualElement)){
                if(!isInChangedPlacesList(actualElement)) {
                    addChangedPlace(actualElement);
                } else{
                    LOGGER.log(Level.TRACE, "changed place contained:" + actualElement);
                }
            }else{
                LOGGER.log(Level.TRACE, "base not contained place:" +  actualElement);
            }
        }
    }

	private List<Bucket> getAllPlaces() {
        List<Bucket> newPlaces = new LinkedList<Bucket>();
		Class<?> superClass = this.getClass().getSuperclass();
		Field[] fields = superClass.getDeclaredFields();

		for (Field classField : fields) {
			Class<?> c = classField.getType();
			if(c.equals(int.class)){
				try {
					Integer value = Integer.valueOf(String.valueOf(classField.getInt(this)));
                    String name = classField.getName();
                    newPlaces.add(new Bucket(name, value));
                } catch (IllegalArgumentException e) {
                    LOGGER.log(Level.ERROR, e);
				} catch (IllegalAccessException e) {
                    LOGGER.log(Level.ERROR, e);
				}
			}
		}
        return newPlaces;
	}

}
