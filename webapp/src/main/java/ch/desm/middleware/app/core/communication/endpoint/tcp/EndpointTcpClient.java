package ch.desm.middleware.app.core.communication.endpoint.tcp;

import
java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;


import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.app.core.common.utility.UtilityConvertingHex;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract class EndpointTcpClient extends EndpointCommon {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClient.class);

    private Object socketLock;
    private Object receiveEventLock;
    private Object sendEventLock;

    protected Socket socket;
    private EndpointTcpClientThread thread;
    protected SocketAddress socketAddress;

    public abstract void connect();
    public abstract void disconnect(String reason);

    public EndpointTcpClient(String ip, int port) {
        LOGGER.log(Level.INFO, "starting client connect to Server with ip:" + ip + " and port: " + port);

        this.socketLock = new Object();
        this.receiveEventLock = new Object();
        this.sendEventLock = new Object();
        this.thread = new EndpointTcpClientThread(this);
        this.socketAddress = new InetSocketAddress(ip, port);
        this.socket = new Socket();
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

    /**
     *
     * @param message
     * @throws IOException
     */
    public void receiveEvent(byte[] message) throws IOException {
        synchronized(receiveEventLock){
            String hexMessage = UtilityConvertingHex.toHex(message);

            LOGGER.log(Level.TRACE, "Thread active: " + hexMessage);
            onIncomingEndpointMessage(hexMessage);
        }
    }

    public synchronized void send(String message) throws IOException{
        synchronized (sendEventLock) {

            if(message != null && !message.isEmpty()){
                byte[] byteStream = getByteStream(message);
                this.send(byteStream);
            }else{
                LOGGER.log(Level.WARN, "client tried to send malformed endpoint message: " + message);
            }
        }
    }

    public synchronized void send(byte[] stream) throws IOException{
        synchronized (socketLock) {

            if(stream != null && stream.length > 0){
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                LOGGER.log(Level.INFO, "client sending message: " + Arrays.toString(stream)); // message);//Arrays.toString(byteStream));
                out.write(stream);
                LOGGER.log(Level.INFO, "client sended message.");
                out.flush();
                LOGGER.log(Level.INFO, "client flushed socket.");
            }else{
                LOGGER.log(Level.WARN, "client tried to send malformed endpoint message: " + stream);
            }
        }
    }

    public boolean isConnected(){
        synchronized (socketLock){
            return !socket.isClosed() && socket.isConnected();
        }
    }

    private byte[] getByteStream(String hexMessage){

        hexMessage = UtilityConvertingHex.removeControleCharacter(hexMessage);

        byte[] byteStream = new byte[hexMessage.length()/2];
        for(int i=0; i<hexMessage.length()/2; i++){
            String value = "" + hexMessage.charAt(i*2) + hexMessage.charAt(i*2+1);
            Integer val = Integer.valueOf(value, 16);
            byteStream[i] = val.byteValue();
        }

        return byteStream;
    }

    public String toString(){
        return socket.toString();
    }

}
