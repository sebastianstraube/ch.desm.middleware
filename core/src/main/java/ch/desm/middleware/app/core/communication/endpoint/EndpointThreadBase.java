package ch.desm.middleware.app.core.communication.endpoint;

import ch.desm.middleware.app.common.ThreadBase;

/**
 * 
 * @author Sebastian
 * 
 */
public abstract class EndpointThreadBase extends ThreadBase {

	public EndpointThreadBase(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * starts the thread
	 */
	public abstract void run();

}