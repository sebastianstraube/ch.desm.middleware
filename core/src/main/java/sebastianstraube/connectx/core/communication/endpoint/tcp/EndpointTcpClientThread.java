package sebastianstraube.connectx.core.communication.endpoint.tcp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import sebastianstraube.connectx.core.communication.endpoint.EndpointThreadBase;

import java.io.IOException;

public class EndpointTcpClientThread extends EndpointThreadBase {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClientThread.class);

    private final int BUFFER = 512;
	private EndpointTcpClient endpoint;

	public EndpointTcpClientThread(EndpointTcpClient endpoint, String name) {
		super(name);
		this.endpoint = endpoint;
	}

    /**
     * TODO socket keep Alive
     */
	@Override
	public void run() {
        byte[] buffer = null;

        while (!isInterrupted()) {
            try {
                LOGGER.log(Level.TRACE, "Thread active: " + this.getName());

                if (endpoint.isConnected()) {
                    buffer = new byte[BUFFER];
                    int j = endpoint.socket.getInputStream().read(buffer);
                    byte[] inBuffer = new byte[j];
                    System.arraycopy(buffer, 0, inBuffer, 0, j);
                    endpoint.receiveEvent(inBuffer);
                }else{
                    LOGGER.log(Level.INFO, "try to receive event in "+this.toString()+", but endpoint is disconnected: " + endpoint.toString());
                    Thread.sleep(1000*10);
                }
            } catch (IOException e) {
                LOGGER.log(Level.ERROR, e);
                if(endpoint.isConnected()) endpoint.disconnect(e.getMessage());
            } catch (NegativeArraySizeException e){
                LOGGER.log(Level.ERROR, e + " at endpoint: " + endpoint.toString());
                if(endpoint.isConnected()) endpoint.disconnect("unexpected read buffer size");
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e + " at endpoint: " + endpoint.toString());
            }
        }
	}
}
