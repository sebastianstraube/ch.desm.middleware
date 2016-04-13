package ch.desm.middleware.app.core.communication.endpoint.ubw32;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointThreadBase;

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
		try {

			while (!isInterrupted()) {
				LOGGER.log(Level.TRACE, "Polling Thread active: " + this.getName() + " wait time: " + EndpointUbw32Config.SLEEP_POLLING);
				endpoint.pollingCommand();
				doHangout();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.ERROR, e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.ERROR, e);
		}
	}

}
