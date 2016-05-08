package ch.desm.middleware.module.petrinet.obermatt;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import ch.desm.middleware.common.FrequencyLimiter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.core.component.petrinet.Bucket;

import javax.websocket.EncodeException;

public class PetrinetOmEndpointExportThread extends Thread {

    private final BlockingDeque<Bucket> pendingSensorEventsQueue = new LinkedBlockingDeque<>();
    private PetrinetOmService service;
    private PetrinetOmEndpointExportAdapter petrinetAdapter;

    public PetrinetOmEndpointExportThread(String threadName, PetrinetOmService service) {
        super(threadName);
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
        pendingSensorEventsQueue.add(new Bucket(signalName, value ? 1 : 0));
    }

    private int clamp(int value, int min, int max) {
        return Math.min(max, Math.max(min, value));
    }

    public void run() {
        // one initial petrinet run
        simulatePetriNet();
        delegateChangedPlaces();

        try {
            while (!isInterrupted()) {
                final Bucket bucket = popPendingSensorEvents();
                if (bucket == null) {
                    Thread.sleep(1);
                    continue;
                }

                delegateToEndpoint(bucket.getName(), bucket.getTokenCount(), false);
                simulatePetriNet();
                delegateChangedPlaces();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void simulatePetriNet() {
        while (petrinetAdapter.fireOneTransition()) {
            petrinetAdapter.writeActors();
        }
    }

    private Bucket popPendingSensorEvents() {
        return pendingSensorEventsQueue.poll();
    }

    private void delegateChangedPlaces() {
        for (Bucket changedPlace : petrinetAdapter.getChangedPlaces()) {
            delegateToBroker(changedPlace, false);
        }
    }

    public void delegateToBroker(Bucket changedPlace, boolean isAccessedFromDelayThread){
        service.getEndpoint().onIncomingEndpointMessage(changedPlace);
    }

    public void delegateToEndpoint(String sensor, int tokenCount, boolean isAccessedFromDelayThread){
        petrinetAdapter.setSensor(sensor, tokenCount);
    }
}
