package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;

public class OMLPetriNetEndpoint extends EndpointCommon {

    private static Logger LOGGER = Logger.getLogger(OMLPetriNetEndpoint.class);

    OMLPetriNetExportThread petriNetThread;

    public void init(){
        petriNetThread = new OMLPetriNetExportThread("OMLPetriNetSimulationThread", this);
    	petriNetThread.intialize();
    }
    
    public void start(){
        petriNetThread.start();
    }

    public void stop(){
    	petriNetThread.interrupt();
    }

    public void onTransitionFired(String message) {
        LOGGER.log(Level.ERROR, "transition: " +message+ " fired to onIncomingEndpointMessage.");
        onIncomingEndpointMessage(message);
    }

    public void setSensor(String message, int value) {
    	petriNetThread.setSensor(message, value);
    }
    
}
