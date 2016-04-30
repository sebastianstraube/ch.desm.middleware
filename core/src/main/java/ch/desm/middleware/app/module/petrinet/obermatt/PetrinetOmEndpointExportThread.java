package ch.desm.middleware.app.module.petrinet.obermatt;

import java.util.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.component.petrinet.Bucket;

import javax.websocket.EncodeException;

public class PetrinetOmEndpointExportThread extends Thread {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmEndpointExportThread.class);

    private Object pendingSensorEventsLock;
    private Object delegateLockBroker;
    private Object delegateLockEndpoint;
    private Map<String, Integer> pendingSensorEvents = new HashMap<>();
    private PetrinetOmService service;
    private PetrinetOmEndpointExportAdapter petrinetAdapter;

    public PetrinetOmEndpointExportThread(String threadName, PetrinetOmService service) {
        super(threadName);
        this.delegateLockBroker = new Object();
        this.delegateLockEndpoint = new Object();
        this.pendingSensorEventsLock = new Object();
        this.service = service;
        this.petrinetAdapter = new PetrinetOmEndpointExportAdapter();
    }

    /*
     * initialize sequence
     */
    public void init() {
        petrinetAdapter.init();
    }

    public void setSensor(String signalName, boolean value) {
        synchronized (pendingSensorEventsLock) {
            final Integer currValue = pendingSensorEvents.get(signalName);
            final Integer actualValue = (currValue != null) ? currValue : 0;
            final Integer diffValue = value ? 1 : -1;
            // TODO: clamp to 1 or allow more than one token per signal/bucket?
            final Integer newValue = clamp(actualValue + diffValue, 0, 1);
            pendingSensorEvents.put(signalName, newValue);
        }
    }

    private int clamp(int value, int min, int max) {
        return Math.min(max, Math.max(min, value));
    }

    public void run() {
        while (!isInterrupted()) {
            simulatePetriNet();
            delegatePendingSensorEvents();
            delegateChangedPlaces();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }

    private void simulatePetriNet() {
        while (petrinetAdapter.fireOneTransition()) {
            petrinetAdapter.writeActors();
        }
    }

    private void delegatePendingSensorEvents() {
        Map<String, Integer> pendingSensorEventsCopy = new HashMap<>();
        synchronized (pendingSensorEventsLock) {
            pendingSensorEventsCopy.putAll(pendingSensorEvents);
            pendingSensorEvents.clear();
        }

        for (Map.Entry<String, Integer> sensorEvent : pendingSensorEventsCopy.entrySet()) {
            delegateToEndpoint(sensorEvent.getKey(), sensorEvent.getValue(), false);
        }
    }

    // TODO: wtf? something is wrong with the delegateLockBroker here!
    private void delegateChangedPlaces() {
        for (Bucket changedPlace : petrinetAdapter.getChangedPlaces()) {
            delegateToBroker(changedPlace, false);
        }
    }

    // TODO: wtf? something is wrong with the delegateLockBroker here!
    public void delegateToBroker(Bucket changedPlace, boolean isAccessedFromDelayThread){
        synchronized(delegateLockBroker){
            service.getEndpoint().onIncomingEndpointMessage(changedPlace);
        }
    }

    public void delegateToEndpoint(String sensor, int tokenCount, boolean isAccessedFromDelayThread){
        synchronized (delegateLockEndpoint){
            petrinetAdapter.setSensor(sensor, tokenCount);
        }
    }
}
