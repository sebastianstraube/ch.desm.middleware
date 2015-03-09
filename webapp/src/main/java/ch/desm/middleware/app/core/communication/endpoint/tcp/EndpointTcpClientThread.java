package ch.desm.middleware.app.core.communication.endpoint.tcp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointThreadBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EndpointTcpClientThread extends EndpointThreadBase {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClientThread.class);

    private final int BUFFER = 128;
	private EndpointTcpClient endpoint;

	public EndpointTcpClientThread(EndpointTcpClient endpoint) {
		super("EndpointTcpClientThread");
		this.endpoint = endpoint;
	}

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
                }
            } catch (IOException e) {
                LOGGER.log(Level.ERROR, e);
            } catch (NegativeArraySizeException e){
                LOGGER.log(Level.ERROR, e + " at endpoint: " + endpoint.toString());
                endpoint.disconnect("unexpected read buffer size");
            }
        }
	}
}
