package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.common.DaemonThreadBase;
import ch.desm.middleware.app.core.utility.Pair;

import java.security.InvalidParameterException;

/**
 * Created by Sebastian on 11.12.2014.
 */
public class PetrinetOmlEndpointDelayThread extends DaemonThreadBase {

    private PetrinetOmlEndpointExportThread t;
    private Pair<String, Integer> place;
    private long delegateTime;
    private boolean isDelegated;
    private String transition;
    private PetrinetOmlEndpointExportAdapter adapter;

    public PetrinetOmlEndpointDelayThread(PetrinetOmlEndpointExportAdapter adapter, String transition, String delay){
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
