package ch.desm.middleware.app.module.petrinet.obermatt;

import ch.desm.middleware.app.core.component.petrinet.Bucket;

/**
 * Created by Sebastian on 11.12.2014.
 */
public class PetrinetOmEndpointDelayThread extends Thread {

    private PetrinetOmEndpointExportThread t;
    private Bucket place;
    private long delegateTime;
    private boolean isDelegated;
    private String transition;
    private PetrinetOmEndpointExportAdapter adapter;

    public PetrinetOmEndpointDelayThread(PetrinetOmEndpointExportAdapter adapter, String transition, String delay){
        this.transition = transition;
        this.adapter = adapter;
        isDelegated = false;
        this.delegateTime = System.currentTimeMillis() + Integer.valueOf(delay);
        this.start();
    }

    public void run(){
        while(!isDelegated && !isInterrupted()){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isAssociated(String transition){
        return this.transition.equals(transition);
    }

    public boolean isTimeToDelegate(){
        long time = (delegateTime-System.currentTimeMillis());
        return (time <= 0);
    }

    public boolean isDelegated(){
        return this.isDelegated;
    }

    public void setAsDelegated(){
        this.isDelegated = true;
    }
}
