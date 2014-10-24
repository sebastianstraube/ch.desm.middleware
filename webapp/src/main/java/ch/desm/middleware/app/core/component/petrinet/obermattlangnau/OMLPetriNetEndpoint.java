package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;

public class OMLPetriNetEndpoint extends EndpointCommon {

    protected static Logger LOGGER = Logger.getLogger(OMLPetriNetEndpoint.class);

    OMLPetriNetThread petriNetThread;

    public OMLPetriNetEndpoint() {
        petriNetThread = new OMLPetriNetThread("PetriNetThread", this);
    }
    
    public void init(){
    	petriNetThread.intialize();
    }
    
    public void start(){
    	petriNetThread.start();
    }
    
    public void stop(){
    	petriNetThread.interrupt();
    }

    protected void onTransitionFired(String message) {
        onIncomingEndpointMessage(message);
    }

    public void setSensor(String message, int value) {
    	petriNetThread.setSensor(message, value);
    }
    
}
