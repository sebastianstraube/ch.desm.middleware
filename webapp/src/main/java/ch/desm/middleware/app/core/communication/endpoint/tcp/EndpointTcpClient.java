package ch.desm.middleware.app.core.communication.endpoint.tcp;

import
java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;


import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract class EndpointTcpClient extends EndpointCommon {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClient.class);

    private Object socketLock;
	private EndpointTcpClientThread thread;
	protected Socket socket;
	protected SocketAddress socketAddress;

    public abstract void connect();
    public abstract void disconnect();

    public EndpointTcpClient(String ip, int port) {
        this.socketLock = new Object();
		this.thread = new EndpointTcpClientThread(this);
		this.socketAddress = new InetSocketAddress(ip, port);
		this.socket = new Socket();
	}

    public void receiveEvent(String message) throws IOException {
        super.onIncomingEndpointMessage(message);
    }

    @Override
    public void init() {
        this.connect();
    }

    @Override
    public void start() {
		if(!thread.isAlive()){
			thread.start();
		}
	}

    @Override
	public void stop() {
		if(thread.isAlive()){
			thread.interrupt();
		}
	}

    public synchronized void send(String val) throws IOException{
        synchronized (socketLock) {
            PrintWriter printWriter =
                    new PrintWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()));
            val = val.replaceAll("[\u0000-\u001f]", "");

            LOGGER.log(Level.INFO, "sending message: " + val);
            printWriter.print(val);
            printWriter.flush();
            printWriter.close();
        }
    }

    public boolean isConnected(){
        synchronized (socketLock){
            return !socket.isClosed() && socket.isConnected();
        }
    }
}
