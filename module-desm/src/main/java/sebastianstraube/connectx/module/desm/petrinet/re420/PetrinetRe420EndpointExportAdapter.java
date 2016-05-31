package sebastianstraube.connectx.module.desm.petrinet.re420;

import sebastianstraube.connectx.core.component.petrinet.Bucket;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.*;

/**
 * wrapper class around the petri net class provided by the pnlm export that is
 * caring about the event communication between enpoint and petri net.
 */
public class PetrinetRe420EndpointExportAdapter extends PetrinetRe420EndpointExportBase {

	private static Logger LOGGER = Logger.getLogger(PetrinetRe420EndpointExportAdapter.class);

	private List<Bucket> basePlaces;
    private List<Bucket> changedPlacesList;
    private Object lockChangedPlacesList;

    public PetrinetRe420EndpointExportAdapter(){
        basePlaces = new LinkedList<Bucket>();
        changedPlacesList = new LinkedList<Bucket>();
        lockChangedPlacesList = new Object();
    }

    @Override
    public void init(){
        super.init();
        addAllPlacesToChangedPlaces(getAllPlaces());
    }

    @Override
	public boolean canFire(String s) {
		LOGGER.log(Level.TRACE, "transition can fire: " + s);
        /*
        if(isDelayedTransition(s)){
            return isTransitionNotDelayed(s);
        }
        */
        return true;
	}

    @Override
	public void fire(String s) {
        LOGGER.log(Level.INFO, "transitions fired: " + s);

        //cleanDelayThread();
        refreshChangedPlacesList(getAllPlaces(), basePlaces);
        basePlaces.clear();
        basePlaces.addAll(getAllPlaces());
    }

    /*
    private boolean isDelayedTransition(String transition){
        synchronized (delayLock){
            String delay = mapDelay.getValueForKey(transition);
            return !delay.isEmpty();
        }
    }

    private boolean isTransitionNotDelayed(String transition) {
        synchronized (listDelayLock) {

            boolean isThreadExisiting = false;
            for (PetrinetRe420EndpointDelayThread t : listDelayThreads) {
                if (t.isAssociated(transition)) {
                    isThreadExisiting = true;
                    if (t.isTimeToDelegate()) {
                        t.setAsDelegated();
                        return true;
                    }
                }
            }


            if (!isThreadExisiting) {
                createDelayTransitionThread(transition);
            }

            return false;
        }
    }

    private void createDelayTransitionThread(String transition){
        synchronized (listDelayLock){
            String delay = mapDelay.getValueForKey(transition);
            PetrinetRe420EndpointDelayThread delayThread = new PetrinetRe420EndpointDelayThread(this, transition, delay);
            listDelayThreads.add(delayThread);
        }
    }

    public void cleanDelayThread(){
        synchronized (listDelayLock){
            for(Iterator<PetrinetRe420EndpointDelayThread> iterator = listDelayThreads.iterator(); iterator.hasNext();){
                PetrinetRe420EndpointDelayThread t = iterator.next();
                if(t.isDelegated()){
                    iterator.remove();
                }
            }
        }
    }
*/
    public void setSensor(String name, int value) {
        try {
            Class<?> petriNetClass = super.getClass();
            Field field = petriNetClass.getField(name);
            field.setInt(this, value);
            addChangedPlace(new Bucket(name, value) );

            LOGGER.log(Level.INFO, "setting sensor: " + name + " to: " + value);
        } catch (NoSuchFieldException e) {
            LOGGER.log(Level.ERROR,"unknown petrinet sensor " + name);
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.ERROR, "unable to set sensor", e);
        }
    }

    public List<Bucket> getChangedPlaces(){
        synchronized (lockChangedPlacesList){
            List<Bucket> changeList = new LinkedList<Bucket>();
            if(!changedPlacesList.isEmpty()){
                changeList.addAll(changedPlacesList);
                changedPlacesList.clear();
                LOGGER.log(Level.TRACE, "list changed places: " + changeList);
            }
            return changeList;
        }
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
