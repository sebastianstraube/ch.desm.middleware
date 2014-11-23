package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import ch.desm.middleware.app.core.utility.Pair;
import ch.desm.middleware.app.core.utility.Utility;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.rmi.CORBA.Util;

/**
 * wrapper class around the petri net class provided by the pnlm export that is
 * caring about the event communication between enpoint and petri net.
 */
public class PetrinetOmlEndpointExportAdapter extends PetrinetOmlEndpointExportBase {

	private static Logger LOGGER = Logger.getLogger(PetrinetOmlEndpointExportAdapter.class);
    private static final int SLEEP_TIMER = 64;

	private List<Pair<String, Integer>> diffPlaces;
    private List<Pair<String, Integer>> changedPlacesList;
    private Object lockChangedPlacesList;

    public PetrinetOmlEndpointExportAdapter(){
        diffPlaces = new LinkedList<Pair<String, Integer>>();
        changedPlacesList = new LinkedList<Pair<String, Integer>>();
        lockChangedPlacesList = new Object();
    }

    @Override
	public boolean canFire(String s) {
		LOGGER.log(Level.TRACE, "transition can fire: " + s);

        diffPlaces.clear();
        diffPlaces.addAll(getPlaces());
		return super.canFire(s);
	}

    @Override
	public void fire(String s) {
        LOGGER.log(Level.INFO, "transitions fired: " + s);

        //TODO refactoring
        //mapping slow down transition
        try {
            Thread.sleep(SLEEP_TIMER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        refreshChangedPlacesList(getPlaces(), diffPlaces);
    }

    @Override
    public void init(){
        super.init();
        addAllPlacesToChangedPlaces(getPlaces());
    }

    public void setSensor(String name, int value) {
        try {
            Class<?> petriNetClass = super.getClass();
            Field field = petriNetClass.getField(name);
            field.setInt(this, value);

            LOGGER.log(Level.INFO, "setting sensor: " + name + " to: " + value);
        } catch (NoSuchFieldException e) {
            LOGGER.log(Level.ERROR,"unknown petrinet sensor " + name);
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.ERROR, "unable to set sensor", e);
        }
    }

    public List<Pair<String, Integer>> getChangedPlaces(){
        List<Pair<String, Integer>> changeList = new LinkedList<>();
        if(!changedPlacesList.isEmpty()){
            synchronized (lockChangedPlacesList){
                changeList.addAll(changedPlacesList);
                changedPlacesList.clear();
            }
            LOGGER.log(Level.TRACE, "move changed places: " + changeList);
        }
        return changeList;
    }

    private void addAllPlacesToChangedPlaces(List<Pair<String, Integer>> base){
        refreshChangedPlacesList(base, new LinkedList<Pair<String, Integer>>());
    }

    private void refreshChangedPlacesList(List<Pair<String, Integer>> base, List<Pair<String, Integer>> compare){
        synchronized (lockChangedPlacesList){
            for(Pair<String, Integer> actualElement: base){
                if(!compare.contains(actualElement)){
                    changedPlacesList.add(actualElement);
                    LOGGER.log(Level.INFO, "changed place: " + actualElement.toString());
                }
            }
        }
    }

	private List<Pair<String, Integer>> getPlaces() {
        List<Pair<String, Integer>> newPlaces = new LinkedList<Pair<String, Integer>>();
		Class<?> superClass = this.getClass().getSuperclass();
		Field[] fields = superClass.getDeclaredFields();

		for (Field classField : fields) {
			Class<?> c = classField.getType();
			if(c.equals(int.class)){
				try {
					Integer value = Integer.valueOf(String.valueOf(classField.getInt(this)));
                    String name = classField.getName();
                    newPlaces.add(new Pair<String, Integer>(name, value));
                } catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        return newPlaces;
	}

}
