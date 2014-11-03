package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.utility.Pair;

public class OMLPetriNetExportThread extends DaemonThreadBase {

    private static Logger LOGGER = Logger.getLogger(OMLPetriNetExportThread.class);
    private static int SLEEP_INTERVAL = 512;

    private Object pendingSensorEventsLock;
    private List<Pair<String, Integer>> pendingSensorEvents;
    private OMLPetriNetExportAdapter petriNet;
    private OMLPetriNetEndpoint endpoint;

    public OMLPetriNetExportThread(String threadName, OMLPetriNetEndpoint endpoint) {
        super(threadName);

        pendingSensorEventsLock = new Object();
        pendingSensorEvents = new ArrayList<Pair<String, Integer>>();
        petriNet = new OMLPetriNetExportAdapter();
        this.endpoint = endpoint;
    }

    /*
     * initialize sequence
     */
    public void intialize() {
        petriNet.init();
    }

    public void setSensor(String signalName, int value) {
        synchronized (pendingSensorEventsLock) {
            Pair<String, Integer> pair = new Pair<String, Integer>(signalName, value);
            pendingSensorEvents.add(pair);
        }
    }

    public void run() {
        while (!isInterrupted()) {

            applySensorEvents();
            simulatePetriNet();
            applyPlaces();

            try {
                Thread.sleep(SLEEP_INTERVAL);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }

    private void applySensorEvents() {
        List<Pair<String, Integer>> pendingSensorEventsCopy = new ArrayList<>();
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

    private void applyPlaces() {
        for (Pair<String, Integer> changedPlace : petriNet.getChangedPlaces()) {
            endpoint.onPlaceChanged(changedPlace);
        }
    }
}
