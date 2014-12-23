package ch.desm.middleware.app.core.communication.endpoint.tcp;

import
java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.util.Arrays;


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
        LOGGER.log(Level.INFO, "starting client connect to Server with ip:" + ip + " and port: " + port);

        this.socketLock = new Object();
		this.thread = new EndpointTcpClientThread(this);
		this.socketAddress = new InetSocketAddress(ip, port);
		this.socket = new Socket();
	}

    public void receiveEvent(String message) throws IOException {
        LOGGER.log(Level.INFO, "client receive message: " + message);
        onIncomingEndpointMessage(message);
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
        LOGGER.log(Level.INFO, "client is ready to receive messages...");
	}

    @Override
	public void stop() {
		if(thread.isAlive()){
			thread.interrupt();
		}
	}

    public synchronized void send(String message) throws IOException{
        synchronized (socketLock) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            message = message.replaceAll("[\u0000-\u001f]", "");

            //int[] byteStream = new int[message.length()];
            byte[] byteStream = new byte[message.length()/2];
            for(int i=0; i<message.length()/2; i++){
                Integer val = Integer.valueOf("" + message.charAt(i*2) + message.charAt(i*2+1), 16);
                byteStream[i] = val.byteValue();
            }

            LOGGER.log(Level.INFO, "client sending message: " + Arrays.toString(byteStream)); // message);//Arrays.toString(byteStream));
            out.write(byteStream);
            LOGGER.log(Level.INFO, "client sended message.");
            out.flush();
            LOGGER.log(Level.INFO, "client flushed socket.");
        }
    }

    public boolean isConnected(){
        synchronized (socketLock){
            return !socket.isClosed() && socket.isConnected();
        }
    }
}
