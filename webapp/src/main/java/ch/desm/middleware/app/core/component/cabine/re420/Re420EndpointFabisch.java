package ch.desm.middleware.app.core.component.cabine.re420;

import ch.desm.middleware.app.core.communication.endpoint.EndpointBase;
import ch.desm.middleware.app.core.communication.endpoint.serial.fabisch.EndpointFabisch;
import ch.desm.middleware.app.core.component.cabine.re420.maps.Re420MapFabischAnalog;
import ch.desm.middleware.app.core.component.cabine.re420.maps.Re420MapFabischDigital;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Re420EndpointFabisch extends EndpointFabisch {

    private static Logger LOGGER = Logger.getLogger(Re420EndpointFabisch.class);

	protected Re420MapFabischDigital mapDigital;
	protected Re420MapFabischAnalog mapAnalog;
	
	public Re420EndpointFabisch(EnumSerialPorts enumSerialPort) {		
		super(enumSerialPort);
		this.registerEndpointListener();

		mapDigital = new Re420MapFabischDigital();
		mapAnalog = new Re420MapFabischAnalog();
	}
	
	public Re420MapFabischAnalog getMapAnalog(){
		return mapAnalog;
	}
	
	public Re420MapFabischDigital getMapDigital(){
		return mapDigital;
	}

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
	 * test endpoint message handling
	 * @param message
	 */
	public void emulateEndpointMessage(String message) {
		onIncomingEndpointMessage(message);
	}


	@Override
	public void onIncomingEndpointMessage(String message) {

	}
}
