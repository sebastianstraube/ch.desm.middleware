package ch.desm.middleware.core.communication.endpoint.ubw32;

public class EndpointUbw32Config {

	public static final String MESSAGE_TERMINATOR = "\n";
	public static final float POLLING_FREQ = 20; //12
	public static int SLEEP_SENDING = 64;				//
	public static boolean CACHE_ENABLED = true; 			// at simulation start false, when ini7 received then true
	public static final double ANALOG_DRIFT_MAX = 10;		// 3.9
	public static final int ANALOG_COMMAND_IA_DELAY = 10;	// 10
	public static final int ANALOG_COMMAND_IA_COUNT = 3;	// 3
}
