package ch.desm.middleware.communication.endpoint.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.apache.log4j.Logger;

import ch.desm.middleware.communication.endpoint.EndpointBaseCommon;

public class EndpointTcpClient extends EndpointBaseCommon {

	private static Logger log = Logger.getLogger(EndpointTcpClient.class);
	public static final int CONNECTION_TIMEOUT = 5096;
	
	private EndpointTcpClientThread thread;
	protected Socket socket;
	private SocketAddress socketAddress;
	
	public EndpointTcpClient(String threadName, String ip, int port) {
		this.thread = new EndpointTcpClientThread(this);
		this.socketAddress = new InetSocketAddress(ip, port);
		this.socket = new Socket();
		this.connect();
	}
	
	public void receiveEvent(String message){
		super.onIncomingEndpointMessage(message);
	}

	public void start() {
		if(!thread.isAlive()){
			thread.run();
		}
	}

	public void stop() {
		if(thread.isAlive()){
			thread.interrupt();
		}
	}
	
	public void disconnect(){
		
		try {
			stop();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
	}
	
	
	public void connect(){
		
		try {
			socket.connect(socketAddress);
			start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
	}
	
}
