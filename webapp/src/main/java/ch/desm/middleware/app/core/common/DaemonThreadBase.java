package ch.desm.middleware.app.core.common;


/**
 * Abstract Thread Daemon
 * 
 * @author Sebastian
 *
 */
public abstract class DaemonThreadBase extends Thread {

    private int sleep = 256;

	public DaemonThreadBase(){
		setDaemon(true);
	}
	
	public DaemonThreadBase(String name) {
		this();
		this.setName(name);
	}

    public DaemonThreadBase(String name, int sleep) {
        this(name);
        this.sleep = sleep;
    }

    public void doHangout() throws InterruptedException {
        this.doHangout(sleep);
    }

    public void doHangout(int sleep) throws InterruptedException {
        Thread.sleep(sleep);
    }
}