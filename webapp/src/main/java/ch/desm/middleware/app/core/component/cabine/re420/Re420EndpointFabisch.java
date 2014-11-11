package ch.desm.middleware.app.core.component.cabine.re420;

import ch.desm.middleware.app.core.communication.endpoint.EndpointBase;
import ch.desm.middleware.app.core.communication.endpoint.serial.fabisch.EndpointFabisch;
import ch.desm.middleware.app.core.component.cabine.re420.maps.Re420MapFabischAnalog;
import ch.desm.middleware.app.core.component.cabine.re420.maps.Re420MapFabischDigital;

public class Re420EndpointFabisch extends EndpointFabisch {

	protected Re420MapFabischDigital mapDigital;
	protected Re420MapFabischAnalog mapAnalog;
	
	public Re420EndpointFabisch(EnumSerialPorts enumSerialPort) {		
		super(enumSerialPort);
		
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
    protected void registerEndpointListener(EndpointBase listener) {

    }

    /**
	 * test endpoint message handling
	 * @param message
	 */
	public void emulateEndpointMessage(String message) {
		onIncomingEndpointMessage(message);
	}
	

}
