package ch.desm.middleware.app.core.common;


import ch.desm.middleware.app.core.utility.Utility;

/**
 * Abstract Thread Daemon
 * 
 * @author Sebastian
 *
 */
public abstract class DaemonThreadBase extends Thread {

    private int sleepTime;

	public DaemonThreadBase(){
		setDaemon(true);
        sleepTime = 32;
	}
	
	public DaemonThreadBase(String name) {
		this();
		this.setName(name);
	}

    public DaemonThreadBase(String name, int sleepTime) {
        this(name);
        this.sleepTime = sleepTime;
    }

    public void doHangout() throws InterruptedException {
        this.doHangout(sleepTime);
    }

    public void doHangout(int sleepTime) throws InterruptedException {
        Thread.sleep(sleepTime);
    }

    public void doRandomHangout() throws InterruptedException{
        doHangout(Utility.randInt());
    }

    public int getSleepTime(){
        return sleepTime;
    }

    public void setSleeptTime(int sleepTime){
        this.sleepTime = sleepTime;
    }
}