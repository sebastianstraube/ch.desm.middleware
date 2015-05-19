package ch.desm.middleware.app.core.communication.endpoint.tcp;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Sebastian on 17.12.2014.
 */
public abstract class EndpointTcpServer  extends EndpointCommon {

    private static Logger LOGGER = Logger.getLogger(EndpointTcpClient.class);

    private EndpointTcpServerThread thread;
    protected ServerSocket socket;
    protected Set<Socket> clients;
    private int port;


    public EndpointTcpServer(String ip, int port) {
        this.thread = new EndpointTcpServerThread(this);
        this.port = port;
        this.clients = new HashSet<Socket>();
    }

    private void createSocket(int port){
        try {
            this.socket = new ServerSocket(port);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public void receiveEvent(Socket client) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                client.getInputStream()));
        char[] buffer = new char[256];
        int anzahlZeichen = bufferedReader.read(buffer, 0, 256); // blockiert bis Nachricht empfangen

        String message = "";

        if(anzahlZeichen != -1){
           message = new String(buffer, 0, anzahlZeichen);
        }

        if(!message.isEmpty()){
            if(message!= null && !message.isEmpty()){
                onIncomingEndpointMessage(message);
                this.send(message);
            }
        }
    }

    public synchronized void send(String val) throws IOException{
        for(Socket client : clients){
            PrintWriter printWriter =
                    new PrintWriter(
                            new OutputStreamWriter(
                                    client.getOutputStream()));
            val = val.replaceAll("[\u0000-\u001f]", "");
            printWriter.print(val);
            printWriter.flush();
            printWriter.close();
        }
    }

    @Override
    public void init() {
        createSocket(port);
    }

    @Override
    public void start() {
        if(thread.isInterrupted()){
            thread.notify();
        }else{
            thread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, e);
            }
        }
    }

    @Override
    public void stop() {
        thread.interrupt();
    }

    public void checkClientAlive(){
        for(Iterator<Socket> iter = clients.iterator(); iter.hasNext();){
            Socket client = iter.next();
            if(client.isConnected() || !client.isBound() || client.isClosed()){
                iter.remove();
            }
        }
    }

    protected void addClient(Socket client){
        try {
            client.setKeepAlive(true);
        } catch (SocketException e) {
            LOGGER.log(Level.ERROR, e);
        }
        clients.add(client);
    }

    protected boolean removeClient(Socket client){
        return clients.remove(client);
    }
}
