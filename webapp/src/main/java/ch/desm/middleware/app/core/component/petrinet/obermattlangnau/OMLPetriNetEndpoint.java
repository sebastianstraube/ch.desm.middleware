package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageDecoder;
import ch.desm.middleware.app.core.component.petrinet.PetrinetMessageEncoder;
import ch.desm.middleware.app.core.utility.Pair;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;

import javax.websocket.EncodeException;

public class OMLPetriNetEndpoint extends EndpointCommon {

    private static Logger LOGGER = Logger.getLogger(OMLPetriNetEndpoint.class);

    private OMLPetriNetExportThread petriNetThread;


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

    public void setSensor(String message, int value) {
    	petriNetThread.setSensor(message, value);
    }
    
}
