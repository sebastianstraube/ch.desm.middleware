package ch.desm.middleware.app.core.common;


/**
 * Abstract Thread Daemon
 * 
 * @author Sebastian
 *
 */
public abstract class DaemonThreadBase extends Thread {

	public DaemonThreadBase(){
		setDaemon(true);
	}
	
	public DaemonThreadBase(String name) {
		this();
		this.setName(name);
		
	}
}