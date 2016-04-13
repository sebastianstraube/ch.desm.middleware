package ch.desm.middleware.app.common;

import ch.desm.middleware.app.common.utility.UtilityRandomGenerator;

/**
 * Abstract Thread Daemon
 * 
 * @author Sebastian
 *
 */
public abstract class ThreadBase extends Thread {

	public ThreadBase(){
	}
	
	public ThreadBase(String name) {
		this();
		this.setName(name);
	}

    public ThreadBase(String name, int sleepTime) {
        this(name);
    }
}