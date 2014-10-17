package ch.desm.middleware.app.core.component.interlocking.obermattlangnau;

import ch.desm.middleware.app.core.communication.endpoint.serial.ubw32.EndpointUbw32;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapUbw32Analog;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.maps.OMLMapUbw32Digital;

public class OMLEndpointUbw32 extends EndpointUbw32 {

	public OMLMapUbw32Digital mapDigital;
	public OMLMapUbw32Analog mapAnalog;
	
	public OMLEndpointUbw32(EnumSerialPorts enumSerialPort) {
		super(enumSerialPort,
				OMLMapUbw32Digital.PINBITMASK_CONFIGURATION_DIGITAL,
				OMLMapUbw32Analog.PINBITMASK_INPUT_ANALOG);
	
	this.mapAnalog = new OMLMapUbw32Analog();
	this.mapDigital = new OMLMapUbw32Digital();
	}
	
}
