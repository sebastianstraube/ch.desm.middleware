package ch.desm.middleware.core.communication.endpoint;

/**
 * 
 * @author Sebastian
 * 
 */
public abstract class EndpointThreadBase extends Thread {

	public EndpointThreadBase(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * starts the thread
	 */
	public abstract void run();

}