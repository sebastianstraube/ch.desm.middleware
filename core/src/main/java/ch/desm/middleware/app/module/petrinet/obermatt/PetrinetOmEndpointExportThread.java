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
    private List<Bucket> pendingSensorEvents;
    private PetrinetOmService service;
    private PetrinetOmEndpointExportAdapter petrinetAdapter;

    public PetrinetOmEndpointExportThread(String threadName, PetrinetOmService service) {
        super(threadName);
        this.delegateLockBroker = new Object();
        this.delegateLockEndpoint = new Object();
        this.pendingSensorEventsLock = new Object();
        this.pendingSensorEvents = new LinkedList<Bucket>();
        this.service = service;
        this.petrinetAdapter = new PetrinetOmEndpointExportAdapter();
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

    public void delegateToBroker(Bucket changedPlace, boolean isAccessedFromDelayThread){
        synchronized(delegateLockBroker){
            try{
                String encodedMessage = service.getEncoder().encode(changedPlace);
                service.getEndpoint().onIncomingEndpointMessage(encodedMessage);
            } catch (EncodeException e) {
            LOGGER.log(Level.ERROR, e);
            }
        }
    }

    public void delegateToEndpoint(Bucket sensorEvent, boolean isAccessedFromDelayThread){
        synchronized (delegateLockEndpoint){
            petrinetAdapter.setSensor(sensorEvent.getName(), sensorEvent.getTokenCount());
        }
    }
}
