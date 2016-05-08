package ch.desm.middleware.core.communication.endpoint.tcp;

import
java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;


import ch.desm.middleware.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.common.UtilityHex;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract class EndpointTcpClient extends EndpointCommon<String> {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClient.class);

    private Object socketLock;
    private Object receiveEventLock;
    private Object sendEventLock;

    protected Socket socket;
    private EndpointTcpClientThread thread;
    protected SocketAddress socketAddress;

    public abstract void connect();
    public abstract void disconnect(String reason);

    public EndpointTcpClient(String ip, int port, String name) {
        LOGGER.log(Level.INFO, "starting client connect to Server with ip:" + ip + " and port: " + port);

        this.socketLock = new Object();
        this.receiveEventLock = new Object();
        this.sendEventLock = new Object();
        this.socketAddress = new InetSocketAddress(ip, port);
        this.socket = new Socket();
        this.thread = new EndpointTcpClientThread(this, this.getClass().getName());

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
        LOGGER.log(Level.INFO, "client thread started");
	}

    @Override
	public void stop() {
		if(thread.isAlive()){
			thread.interrupt();
		}
	}

    /**
     *
     * @param message
     * @throws IOException
     */
    public void receiveEvent(byte[] message) throws IOException {
        synchronized(receiveEventLock){

            //TODO implement
            LOGGER.log(Level.INFO, "Thread active: " + Arrays.toString(message));
            onIncomingEndpointMessage("");
        }
    }

    public synchronized void send(String message) throws IOException{
        synchronized (sendEventLock) {

            if(message != null && !message.isEmpty()){
                byte[] byteStream = UtilityHex.getByteStream(message);
                this.send(byteStream);
            }else{
                LOGGER.log(Level.WARN, "client tried to send malformed endpoint message: " + message);
            }
        }
    }

    public synchronized void send(byte[] stream) throws IOException{
        synchronized (socketLock) {
            try{

                if(socket.isClosed() || !socket.isConnected()){
                    throw new IOException("socket is not ready: " + socket.toString());
                }else if(stream == null || stream.length <= 0){
                    throw new Exception("client tried to send malformed stream: " + stream);
                }

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                LOGGER.log(Level.INFO, "client sending message: " + Arrays.toString(stream)); // message);//Arrays.toString(byteStream));
                out.write(stream);
                LOGGER.log(Level.INFO, "client sended message.");
                out.flush();
                LOGGER.log(Level.INFO, "client flushed socket.");

            }catch(Exception e){
                LOGGER.log(Level.ERROR, "send socket message failed, error: " + e);
            }
        }
    }

    public boolean isConnected(){
        synchronized (socketLock){
            return !socket.isClosed() && socket.isConnected();
        }
    }

    public String toString(){
        return socket.toString();
    }

}
