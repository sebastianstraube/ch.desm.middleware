package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import java.util.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.common.Pair;

import javax.websocket.EncodeException;

public class PetrinetOmlEndpointExportThread extends DaemonThreadBase {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmlEndpointExportThread.class);

    private Object pendingSensorEventsLock;
    private Object delegateLockBroker;
    private Object delegateLockEndpoint;
    private List<Pair<String, Integer>> pendingSensorEvents;
    private PetrinetOmlService service;
    private PetrinetOmlEndpointExportAdapter petrinetAdapter;

    public PetrinetOmlEndpointExportThread(String threadName, PetrinetOmlService service) {
        super(threadName);
        this.delegateLockBroker = new Object();
        this.delegateLockEndpoint = new Object();
        this.pendingSensorEventsLock = new Object();
        this.pendingSensorEvents = new LinkedList<Pair<String, Integer>>();
        this.service = service;
        this.petrinetAdapter = new PetrinetOmlEndpointExportAdapter();
    }

    /*
     * initialize sequence
     */
    public void init() {
        petrinetAdapter.init();
    }

    public void setSensor(String signalName, int value) {
        synchronized (pendingSensorEventsLock) {
            Pair<String, Integer> pair = new Pair<String, Integer>(signalName, value);
            pendingSensorEvents.add(pair);
        }
    }

    public void run() {
        while (!isInterrupted()) {
            simulatePetriNet();
            delegatePendingSensorEvents();
            delegateChangedPlaces();
            try {
                doHangout();
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
            List<Pair<String, Integer>> pendingSensorEventsCopy = new LinkedList<Pair<String, Integer>>();
            pendingSensorEventsCopy.addAll(pendingSensorEvents);
            pendingSensorEvents.clear();

            for (Pair<String, Integer> sensorEvent : pendingSensorEventsCopy) {
                delegateToEndpoint(sensorEvent, false);
            }
        }
    }

    private void delegateChangedPlaces() {
        for (Pair<String, Integer> changedPlace : petrinetAdapter.getChangedPlaces()) {
            delegateToBroker(changedPlace, false);
        }
    }

    public void delegateToBroker(Pair<String, Integer> changedPlace, boolean isAccessedFromDelayThread){
        synchronized(delegateLockBroker){
            try{
                String encodedMessage = service.getEncoder().encode(changedPlace);
                service.getEndpoint().onIncomingEndpointMessage(encodedMessage);
            } catch (EncodeException e) {
            LOGGER.log(Level.ERROR, e);
            }
        }
    }

    public void delegateToEndpoint(Pair<String, Integer> sensorEvent,  boolean isAccessedFromDelayThread){
        synchronized (delegateLockEndpoint){
            petrinetAdapter.setSensor(sensorEvent.getLeft(), sensorEvent.getRight());
        }
    }
}
