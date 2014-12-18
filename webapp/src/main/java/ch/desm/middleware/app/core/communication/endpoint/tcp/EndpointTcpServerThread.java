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

                try {
                    handleClientConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                doHangout();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

    private synchronized void handleClientConnection() throws IOException {
        Socket client = endpoint.socket.accept();  //warten auf Client-Anforderung
        handleClientMessage(client);
    }

    private synchronized void handleClientMessage(Socket client) throws IOException {
        PrintWriter out = null;

        System.out.println( "running service, " + Thread.currentThread() );
        out = new PrintWriter( client.getOutputStream(), true );
        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                client.getInputStream()));
        char[] buffer = new char[256];
        int anzahlZeichen = bufferedReader.read(buffer, 0, 256); // blockiert bis Nachricht empfangen

        String message = new String(buffer, 0, anzahlZeichen);

        if(!message.isEmpty()){
            if(message!= null && !message.isEmpty()){
                endpoint.receiveEvent(message);
                message ="";
            }
        }
    }
}
