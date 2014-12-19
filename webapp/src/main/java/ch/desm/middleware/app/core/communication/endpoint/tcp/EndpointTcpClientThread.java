package ch.desm.middleware.app.core.communication.endpoint.tcp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointThreadBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EndpointTcpClientThread extends EndpointThreadBase {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClientThread.class);

	private EndpointTcpClient endpoint;

	public EndpointTcpClientThread(EndpointTcpClient endpoint) {
		super("EndpointTcpClientThread");
		this.endpoint = endpoint;
	}

	@Override
	public void run() {

        while (!isInterrupted()) {
			try {

				LOGGER.log(Level.TRACE,"Thread active: " + this.getName());

                try {
                    if(endpoint.isConnected()){
                        BufferedReader bufferedReader =
                                new BufferedReader(
                                        new InputStreamReader(
                                                endpoint.socket.getInputStream()));
                        char[] buffer = new char[256];
                        int anzahlZeichen = bufferedReader.read(buffer, 0, 256); // blockiert bis Nachricht empfangen

                        String message = "";
                        if(anzahlZeichen > 0){
                            message = new String(buffer, 0, anzahlZeichen);
                        }

                        if(!message.isEmpty()){
                            endpoint.receiveEvent(message);
                        }
                    }
                } catch (IOException e) {
                    LOGGER.log(Level.ERROR, e);
                }
                doHangout();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
