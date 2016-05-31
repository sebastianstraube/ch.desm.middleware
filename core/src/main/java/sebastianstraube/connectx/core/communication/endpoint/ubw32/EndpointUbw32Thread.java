package sebastianstraube.connectx.core.communication.endpoint.ubw32;

import sebastianstraube.connectx.core.common.FrequencyLimiter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import sebastianstraube.connectx.core.communication.endpoint.EndpointThreadBase;

/**
 * Inherits the Daeon class to execute polling
 * @author Sebastian
 *
 */
class EndpointUbw32Thread extends EndpointThreadBase {
	
	private static Logger LOGGER = Logger.getLogger(EndpointUbw32Thread.class);
	
	private EndpointUbw32 endpoint;
	
	EndpointUbw32Thread(EndpointUbw32 endpoint) {
		super("EndpointUbw32Polling (" + endpoint.getSerialPortName()+")");
		
		this.endpoint = endpoint;
	}	
	
	@Override
	public void run() {
		final FrequencyLimiter frequencyLimiter = new FrequencyLimiter(EndpointUbw32Config.POLLING_FREQ);

		try {
			while (!isInterrupted()) {
				final long startMillis = System.currentTimeMillis();

				endpoint.pollingCommand();

				try {
					frequencyLimiter.ensureLimit(startMillis);
				} catch (InterruptedException e) {
					LOGGER.log(Level.ERROR, e);
					break;
				}
			}
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, e);
		}
	}

}
