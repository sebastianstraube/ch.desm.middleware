package sebastianstraube.connectx.core.communication.endpoint.tcp;

import sebastianstraube.connectx.core.common.FrequencyLimiter;
import sebastianstraube.connectx.core.communication.endpoint.EndpointThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

public class EndpointTcpServerThread extends EndpointThreadBase {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpServerThread.class);

	private static final Float POLLING_FREQ = 25.0f;

	private final EndpointTcpServer endpoint;

	public EndpointTcpServerThread(EndpointTcpServer endpoint) {
		super("EndpointTcpClientThread");
		this.endpoint = endpoint;
	}

	@Override
	public void run() {
		final FrequencyLimiter frequencyLimiter = new FrequencyLimiter(POLLING_FREQ);

        while (!isInterrupted()) {
			final long startMillis = System.currentTimeMillis();

			try {
				LOGGER.log(Level.TRACE,"Thread active: " + this.getName());
                handleClientConnection();
                endpoint.checkClientAlive();
			} catch (IOException e) {
                e.printStackTrace();
            }

			try {
				frequencyLimiter.ensureLimit(startMillis);
			} catch (InterruptedException e) {
				LOGGER.log(Level.ERROR, e);
				break;
			}
		}
	}

    private synchronized void handleClientConnection() throws IOException {
        Socket client = endpoint.socket.accept();  //warten auf Client-Anforderung
        handleClientMessage(client);
    }

    private synchronized void handleClientMessage(Socket client) throws IOException {
        endpoint.receiveEvent(client);
    }
}
