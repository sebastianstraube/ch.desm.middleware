package ch.desm.middleware.app.core.component.simulation.locsim;

import ch.desm.middleware.app.core.communication.endpoint.EndpointBase;
import ch.desm.middleware.app.core.communication.endpoint.dll.EndpointDll;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LocsimEndpointDll extends EndpointDll {

    private static Logger LOGGER = Logger.getLogger(LocsimEndpointDll.class);

	public LocsimEndpointDll(String configPath) {
		super(configPath);
        this.registerEndpointListener();
	}

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void onIncomingEndpointMessage(String message) {

    }

    /**
     *
     */
    @Override
    public void reset(){

    }

}
