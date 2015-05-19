package ch.desm.middleware.app.core.communication.endpoint.tcp;

import ch.desm.middleware.app.core.communication.endpoint.EndpointThreadBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EndpointTcpServerThread extends EndpointThreadBase {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpServerThread.class);

	private EndpointTcpServer endpoint;

	public EndpointTcpServerThread(EndpointTcpServer endpoint) {
		super("EndpointTcpClientThread");
		this.endpoint = endpoint;
	}

	@Override
	public void run() {

        while (!isInterrupted()) {
			try {
				LOGGER.log(Level.TRACE,"Thread active: " + this.getName());
                handleClientConnection();
                endpoint.checkClientAlive();
                doHangout();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
                e.printStackTrace();
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
