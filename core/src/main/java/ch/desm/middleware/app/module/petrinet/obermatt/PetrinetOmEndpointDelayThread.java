package ch.desm.middleware.app.module.petrinet.obermatt;

import ch.desm.middleware.app.common.ThreadBase;
import ch.desm.middleware.app.common.Pair;

/**
 * Created by Sebastian on 11.12.2014.
 */
public class PetrinetOmEndpointDelayThread extends ThreadBase {

    private PetrinetOmEndpointExportThread t;
    private Pair<String, Integer> place;
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
                doHangout();
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
