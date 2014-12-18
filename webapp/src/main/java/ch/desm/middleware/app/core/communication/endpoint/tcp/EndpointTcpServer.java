package ch.desm.middleware.app.core.communication.endpoint.tcp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.*;

/**
 * Created by Sebastian on 17.12.2014.
 */
public abstract class EndpointTcpServer extends EndpointTcpBase {

    private static Logger LOGGER = Logger.getLogger(EndpointTcpClient.class);

    private EndpointTcpServerThread thread;
    protected ServerSocket socket;
    private int port;


    public EndpointTcpServer(String ip, int port) {
        this.thread = new EndpointTcpServerThread(this);
        this.port = port;

    }

    private void createSocket(int port){
        try {
            this.socket = new ServerSocket(port);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public void receiveEvent(String message){

        System.out.print("Server received message: " + message);
    }

    public synchronized void send(String val) throws IOException{
    }

    @Override
    public synchronized String receive() throws IOException{

        return null;
    }

    @Override
    public void init() {
        createSocket(port);
    }

    @Override
    public void start() {
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void stop() {

    }

}
