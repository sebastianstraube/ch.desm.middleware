package ch.desm.middleware.app.module.petrinet.re420;

import ch.desm.middleware.app.common.FrequencyLimiter;
import ch.desm.middleware.app.core.component.petrinet.Bucket;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.EncodeException;
import java.util.LinkedList;
import java.util.List;

public class PetrinetRe420EndpointExportThread extends Thread {

    private static Logger LOGGER = Logger.getLogger(PetrinetRe420EndpointExportThread.class);

    private static final Float PETRINET_SIMULATION_FREQ = 25.0f;

    private Object pendingSensorEventsLock;
    private Object delegateLockBroker;
    private Object delegateLockEndpoint;
    private List<Bucket> pendingSensorEvents;
    private PetrinetRe420Service service;
    private PetrinetRe420EndpointExportAdapter petrinetAdapter;

    public PetrinetRe420EndpointExportThread(String threadName, PetrinetRe420Service service) {
        super(threadName);
        this.delegateLockBroker = new Object();
        this.delegateLockEndpoint = new Object();
        this.pendingSensorEventsLock = new Object();
        this.pendingSensorEvents = new LinkedList<Bucket>();
        this.service = service;
        this.petrinetAdapter = new PetrinetRe420EndpointExportAdapter();
    }

    /*
     * initialize sequence
     */
    public void init() {
        petrinetAdapter.init();
    }

    public void setSensor(String signalName, int value) {
        synchronized (pendingSensorEventsLock) {
            Bucket bucket = new Bucket(signalName, value);
            pendingSensorEvents.add(bucket);
        }
    }

    public void run() {
        final FrequencyLimiter frequencyLimiter = new FrequencyLimiter(PETRINET_SIMULATION_FREQ);

        while(!isInterrupted()){
            final long startMillis = System.currentTimeMillis();

            simulatePetriNet();
            delegatePendingSensorEvents();
            delegateChangedPlaces();

            try {
                frequencyLimiter.ensureLimit(startMillis);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
                break;
            }
        }

    }

    private void simulatePetriNet() {
        petrinetAdapter.calcBooleanPlaces();
        while (petrinetAdapter.fireOneTransition()) {
            petrinetAdapter.writeActors();
        }
    }

    private void delegatePendingSensorEvents() {
        synchronized (pendingSensorEventsLock) {
            List<Bucket> pendingSensorEventsCopy = new LinkedList<Bucket>();
            pendingSensorEventsCopy.addAll(pendingSensorEvents);
            pendingSensorEvents.clear();

            for (Bucket sensorEvent : pendingSensorEventsCopy) {
                delegateToEndpoint(sensorEvent, false);
            }
        }
    }

    private void delegateChangedPlaces() {
        for (Bucket changedPlace : petrinetAdapter.getChangedPlaces()) {
            delegateToBroker(changedPlace, false);
        }
    }

    // TODO: why do we need the delegateLockBroker here?
    public void delegateToBroker(Bucket changedPlace, boolean isAccessedFromDelayThread){
        synchronized(delegateLockBroker){
            service.getEndpoint().onIncomingEndpointMessage(changedPlace);
        }
    }

    public void delegateToEndpoint(Bucket sensorEvent, boolean isAccessedFromDelayThread){
        synchronized (delegateLockEndpoint){
            petrinetAdapter.setSensor(sensorEvent.getName(), sensorEvent.getTokenCount());
        }
    }
}
