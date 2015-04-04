package ch.desm.middleware.app.core.component.cabine.re420;

import ch.desm.middleware.app.core.communication.endpoint.serial.ubw32.EndpointUbw32;
import ch.desm.middleware.app.core.component.cabine.re420.maps.Ubw32MapUbw32Analog;
import ch.desm.middleware.app.core.component.cabine.re420.maps.Ubw32MapUbw32Digital;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Re420EndpointUbw32 extends EndpointUbw32 {

    private static Logger LOGGER = Logger.getLogger(Re420EndpointUbw32.class);

	protected Ubw32MapUbw32Digital re420MapDigital;
	protected Ubw32MapUbw32Analog re420MapAnalog;
	
	public Re420EndpointUbw32(EnumSerialPorts enumSerialPort) {		
		super(enumSerialPort, Ubw32MapUbw32Digital.PINBITMASK_CONFIGURATION_DIGITAL, Ubw32MapUbw32Analog.PINBITMASK_INPUT_ANALOG);
		this.registerEndpointListener();

		re420MapDigital = new Ubw32MapUbw32Digital();
		re420MapAnalog = new Ubw32MapUbw32Analog();
	}
	
	public Ubw32MapUbw32Analog getMapAnalog(){
		return re420MapAnalog;
	}
	
	public Ubw32MapUbw32Digital getMapDigital(){
		return re420MapDigital;
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
