package ch.desm.middleware.modules.communication.endpoint.serial.ubw32;

import ch.desm.middleware.modules.core.daemon.DaemonThread;

/**
 * Inherits the Daeon class to execute polling sequence
 * @author Sebastian
 *
 */
class EndpointUbw32Polling extends DaemonThread {

	private EndpointUbw32 endpoint;
	private int waitTimeMs;
	
	EndpointUbw32Polling(EndpointUbw32 endpoint, int waitTimeMs) {
		super("EndpointUbw32Polling (" + endpoint.getSerialPortName()+")");
		this.endpoint = endpoint;
		this.waitTimeMs = waitTimeMs;
	}

	@Override
	/**
	 * TODO refactoring sleep
	 */
	public void run() {

		try {
			while (!isInterrupted()) {
				System.out.println("Thread: " + this.getName());
				endpoint.sendCommandInputState();
				endpoint.sendCommandInputAnalog(endpoint.getPinBitMaskInputAnalog());
				
				Thread.sleep(waitTimeMs);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
