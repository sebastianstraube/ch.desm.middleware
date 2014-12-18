package ch.desm.middleware.app.core.communication.endpoint.tcp;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.apache.log4j.Logger;

public abstract class EndpointTcpClient extends EndpointTcpBase {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClient.class);

	private EndpointTcpClientThread thread;
	protected Socket socket;
	protected SocketAddress socketAddress;

    public abstract void connect();
    public abstract void disconnect();

    public EndpointTcpClient(String ip, int port) {
		this.thread = new EndpointTcpClientThread(this);
		this.socketAddress = new InetSocketAddress(ip, port);
		this.socket = new Socket();
	}
	
	public void receiveEvent(String message){
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

    public synchronized void send(byte[] val) throws IOException{
        PrintWriter printWriter =
                new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
        printWriter.print(val);
        printWriter.flush();
        printWriter.close();
    }

    public synchronized void send(String val) throws IOException{
        PrintWriter printWriter =
                new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
        printWriter.print(val);
        printWriter.flush();
        printWriter.close();
    }

    @Override
    public synchronized String receive() throws IOException{
        DataInputStream stream = new DataInputStream(socket.getInputStream());
        String message = stream.readUTF();
        stream.close();

        return message;
    }
}
