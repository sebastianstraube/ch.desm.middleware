package ch.desm.middleware.app.module.petrinet.re420;

import ch.desm.middleware.app.common.ThreadBase;
import ch.desm.middleware.app.common.Pair;

/**
 * Created by Sebastian on 11.12.2014.
 */
public class PetrinetRe420EndpointDelayThread extends ThreadBase {

    private PetrinetRe420EndpointExportThread t;
    private Pair<String, Integer> place;
    private long delegateTime;
    private boolean isDelegated;
    private String transition;
    private PetrinetRe420EndpointExportAdapter adapter;

    public PetrinetRe420EndpointDelayThread(PetrinetRe420EndpointExportAdapter adapter, String transition, String delay){
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
