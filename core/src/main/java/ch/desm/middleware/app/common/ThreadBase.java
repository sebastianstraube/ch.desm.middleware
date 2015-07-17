package ch.desm.middleware.app.common;


import ch.desm.middleware.app.common.utility.UtilityRandomGenerator;

/**
 * Abstract Thread Daemon
 * 
 * @author Sebastian
 *
 */
public abstract class ThreadBase extends Thread {

    private int sleepTime = 10;

	public ThreadBase(){
		this.setDaemon(true);
	}
	
	public ThreadBase(String name) {
		this();
		this.setName(name);
	}

    public ThreadBase(String name, int sleepTime) {
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
        doHangout(UtilityRandomGenerator.randInt());
    }

    public int getSleepTime(){
        return sleepTime;
    }

    public void setSleeptTime(int sleepTime){
        this.sleepTime = sleepTime;
    }
}