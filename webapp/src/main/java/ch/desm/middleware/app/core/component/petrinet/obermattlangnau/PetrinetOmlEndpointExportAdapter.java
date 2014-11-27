package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import ch.desm.middleware.app.core.utility.Pair;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * wrapper class around the petri net class provided by the pnlm export that is
 * caring about the event communication between enpoint and petri net.
 */
public class PetrinetOmlEndpointExportAdapter extends PetrinetOmlEndpointExportBase {

	private static Logger LOGGER = Logger.getLogger(PetrinetOmlEndpointExportAdapter.class);

	private List<Pair<String, Integer>> basePlaces;
    private List<Pair<String, Integer>> changedPlacesList;
    private Object lockChangedPlacesList;

    public PetrinetOmlEndpointExportAdapter(){
        basePlaces = new LinkedList<Pair<String, Integer>>();
        changedPlacesList = new LinkedList<Pair<String, Integer>>();
        lockChangedPlacesList = new Object();
    }

    @Override
	public boolean canFire(String s) {
		LOGGER.log(Level.TRACE, "transition can fire: " + s);
		return super.canFire(s);
	}

    @Override
	public void fire(String s) {
        LOGGER.log(Level.INFO, "transitions fired: " + s);

        //TODO mapping slow down transition
        refreshChangedPlacesList(getPlaces(), basePlaces);

        basePlaces.clear();
        basePlaces.addAll(getPlaces());
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
        synchronized (lockChangedPlacesList){
            List<Pair<String, Integer>> changeList = new LinkedList<>();
            if(!changedPlacesList.isEmpty()){
                changeList.addAll(changedPlacesList);
                changedPlacesList.clear();
                LOGGER.log(Level.INFO, "list changed places: " + changeList);
            }
            return changeList;
        }
    }

    private void addAllPlacesToChangedPlaces(List<Pair<String, Integer>> base){
        refreshChangedPlacesList(base, new LinkedList<Pair<String, Integer>>());
    }

    public void addChangedPlaces(Pair<String, Integer> pair){
        synchronized (lockChangedPlacesList){
            changedPlacesList.add(pair);
        }
    }

    private void refreshChangedPlacesList(List<Pair<String, Integer>> changed, List<Pair<String, Integer>> base){
        synchronized (lockChangedPlacesList){
            for(Pair<String, Integer> actualElement: changed){
                if(!base.contains(actualElement)){
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
