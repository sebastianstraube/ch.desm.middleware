package ch.desm.middleware.app.core.communication.endpoint.tcp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointThreadBase;

import java.io.IOException;

public class EndpointTcpClientThread extends EndpointThreadBase {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClientThread.class);

	private EndpointTcpClient endpoint;

	public EndpointTcpClientThread(EndpointTcpClient endpoint) {
		super("EndpointTcpClientThread");
		this.endpoint = endpoint;
	}

	@Override
	public void run() {

        String message = "";
        while (!isInterrupted()) {
			try {

				LOGGER.log(Level.TRACE,"Thread active: " + this.getName());

                try {
                    message = endpoint.receiveUTF();
                    if(message!= null && !message.isEmpty()){
                        endpoint.receiveEvent(message);
                        message ="";
                    }
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

}
