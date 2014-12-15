package ch.desm.middleware.app.core.communication.endpoint.tcp;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;

public abstract class EndpointTcpClient extends EndpointCommon {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClient.class);
	public static final int CONNECTION_TIMEOUT = 5096;
	public static final int BUFFER_RECEIVE_LENGTH = 512;

	private EndpointTcpClientThread thread;
	protected Socket socket;
	protected SocketAddress socketAddress;

    public abstract void connect();
    public abstract void disconnect();

    public EndpointTcpClient(String ip, int port) {
		this.thread = new EndpointTcpClientThread(this);
		this.socketAddress = new InetSocketAddress(ip, port);
		this.socket = new Socket();
		this.init();
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
        DataOutputStream sendBuffer = new DataOutputStream(socket.getOutputStream());
        sendBuffer.write(val);
        sendBuffer.flush();
        sendBuffer.close();
    }

    public synchronized void send(String val) throws IOException{
        DataOutputStream sendBuffer = new DataOutputStream(socket.getOutputStream());
        sendBuffer.writeChars(val);
        sendBuffer.flush();
        sendBuffer.close();
    }

    public synchronized byte[] receive() throws IOException{
        DataInputStream stream = new DataInputStream(socket.getInputStream());
        byte[] b = new byte[stream.read()];
        stream.readFully(b);
        stream.close();

        return b;
    }

    public synchronized String receiveUTF() throws IOException{
        DataInputStream stream = new DataInputStream(socket.getInputStream());
        String message = stream.readUTF();
        stream.close();

        return message;
    }
}
