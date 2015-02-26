package ch.desm.middleware.app.core.communication.endpoint.tcp;

import
java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.app.core.utility.UnicodeFormatter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract class EndpointTcpClient extends EndpointCommon {

	private static Logger LOGGER = Logger.getLogger(EndpointTcpClient.class);

    private Object socketLock;
	private EndpointTcpClientThread thread;
	protected Socket socket;
	protected SocketAddress socketAddress;
    UnicodeFormatter unicodeFormatter;

    public abstract void connect();
    public abstract void disconnect();

    public EndpointTcpClient(String ip, int port) {
        LOGGER.log(Level.INFO, "starting client connect to Server with ip:" + ip + " and port: " + port);

        this.socketLock = new Object();
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

    public void receiveEvent(String message) throws IOException {
        if(message != null && !message.isEmpty()){

            char[] chararray = message.toCharArray();
            String hexMessage = "";

            for(int i=0; i<chararray.length;i++){
                int c = (int) chararray[i];
                String hex = Integer.toHexString(c);
                hexMessage +=  hex;
            }

            LOGGER.log(Level.INFO, "client receive message: " + hexMessage);
            onIncomingEndpointMessage(message);
        }else{
            LOGGER.log(Level.WARN, "received event message is empty.");
        }

    }

    public synchronized void send(String message) throws IOException{
        synchronized (socketLock) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            message = UnicodeFormatter.removeControleCharacter(message);

            byte[] byteStream = getByteStream(message);
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

    public static String convertBytes(byte[] array, String name) {
        String output = "";
        for (int k = 0; k < array.length; k++) {
            String hex = UnicodeFormatter.byteToHex(array[k]);
            output += hex;
            LOGGER.log(Level.INFO, (name + "[" + k + "] = " + "0x" + hex));
        }
        return output;
    }


    private byte[] getByteStream(String hexMessage){

        hexMessage = UnicodeFormatter.removeControleCharacter(hexMessage);

        byte[] byteStream = new byte[hexMessage.length()/2];
        for(int i=0; i<hexMessage.length()/2; i++){
            String value = "" + hexMessage.charAt(i*2) + hexMessage.charAt(i*2+1);
            Integer val = Integer.valueOf(value, 16);
            byteStream[i] = val.byteValue();
        }

        return byteStream;
    }
}
