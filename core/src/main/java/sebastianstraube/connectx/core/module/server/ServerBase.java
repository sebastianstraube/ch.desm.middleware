package sebastianstraube.connectx.core.module.server;

/**
 * Created by Sebastian on 08.05.2016.
 */
public abstract class ServerBase extends Thread {

    public abstract ServerBase startServer();
    public abstract boolean isStarted();

    public boolean waitUntilServerStarted() {
        while (!isStarted()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
