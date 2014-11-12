package ch.desm.middleware.app.core.communication.endpoint.serial.ubw32;

public class EndpointUbw32Config {

	public static final String MESSAGE_TERMINATOR = "\n";
	public static int SLEEP_POLLING = 12;
	public static int SLEEP_SENDING = 64;				//
	public static boolean CACHE_ENABLED = false; 			// at simulation start false, when ini7 received then true
	public static final double ANALOG_DRIFT_MAX = 4;		// 3.9
	public static final int ANALOG_COMMAND_IA_DELAY = 10;	// 10
	public static final int ANALOG_COMMAND_IA_COUNT = 3;	// 3
}
