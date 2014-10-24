package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.utility.Pair;

public class OMLPetriNetThread extends DaemonThreadBase {

    protected static Logger LOGGER = Logger.getLogger(OMLPetriNetThread.class);

    private static int SLEEP_INTERVAL = 512;

    private Object pendingSensorEventsLock = new Object();
    private List<Pair<String, Integer>> pendingSensorEvents = new ArrayList<Pair<String, Integer>>();

    private OMLPetriNetEndpoint endpoint;
    private OMLPetriNetAdapter petriNet;

    public OMLPetriNetThread(String threadName, OMLPetriNetEndpoint endpoint) {
        super(threadName);
        this.endpoint = endpoint;
        petriNet = new OMLPetriNetAdapter();
    }
    
    /*
     * initialize sequence
     */
    public void intialize(){
    	petriNet.init();
        petriNet.initMarker();
    }

    public void setSensor(String signalName, int value) {
        synchronized (pendingSensorEvents) {
            pendingSensorEvents.add(new Pair<String, Integer>(signalName, value));
        }
    }

    public void run() {
        while(!isInterrupted()) {

            applySensorEvents();
            simulatePetriNet();
            applyFiredTransitions();

            try {
                Thread.sleep(SLEEP_INTERVAL);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }

    }
    
    private void applySensorEvents() {
    	List<Pair<String, Integer>> pendingSensorEventsCopy = new ArrayList<Pair<String, Integer>>();
        synchronized (pendingSensorEventsLock) {
            pendingSensorEventsCopy.addAll(pendingSensorEvents);
            pendingSensorEvents.clear();
        }

        for (Pair<String, Integer> sensorEvent : pendingSensorEventsCopy) {
            petriNet.setSensor(sensorEvent.getLeft(), sensorEvent.getRight());
        }
    }

    private void simulatePetriNet() {
        while (petriNet.fireOneTransition()) {
            petriNet.writeActors();
        }
    }

    private void applyFiredTransitions() {
        List<String> firedTransitions = new ArrayList<String>();
        firedTransitions.addAll(petriNet.firedTransitions);
        petriNet.firedTransitions.clear();

        for (String firedTransition : firedTransitions) {
            endpoint.onTransitionFired(firedTransition);
        }
    }

}
