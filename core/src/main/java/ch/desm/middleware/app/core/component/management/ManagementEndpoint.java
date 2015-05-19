package ch.desm.middleware.app.core.component.management;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.app.core.communication.endpoint.websocket.EndpointWebsocketMessageDecoder;
import ch.desm.middleware.app.core.communication.message.MessageWebsocket;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.DecodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ManagementEndpoint extends EndpointCommon {

    private static final Logger LOGGER = Logger
            .getLogger(ManagementEndpoint.class);

    private Session webSocketSession;
    //private WebSocketContainer container;
    private ManagementEndpointThread thread;
    private ManagementService service;
    private URI serverUri;

    public ManagementEndpoint(ManagementService service, String uri){
        super();
        this.registerEndpointListener();

        thread = new ManagementEndpointThread(this);
        serverUri = URI.create(uri);
        this.service = service;
        this.start();
    }

    @Override
    public void onIncomingEndpointMessage(String message) {
        LOGGER.log(Level.TRACE, "receive endpoint message: " + message);

        try {
            //check message syntax
            EndpointWebsocketMessageDecoder decoder = new EndpointWebsocketMessageDecoder();
            MessageWebsocket messageWebsocket = decoder.decode(message);
            //publish message
            service.getProcessor().processEndpointMessage(service.getBrokerClient(), messageWebsocket.getPayload(), messageWebsocket.getTopic());
        } catch (DecodeException e) {
            LOGGER.log(Level.ERROR, "wrong format of endpoint message: " + message, e);
        }

    }

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void init() {

    }

    /**
     * WEBSOCKET JETTY
     **/
    /*
    @Override
    public void start() {
        try {
            container = ContainerProvider.getWebSocketContainer();
            webSocketSession = container.connectToServer(ManagementEndpointWebsocketClient.class, serverUri);
        } catch (DeploymentException e) {
            LOGGER.log(Level.ERROR, e);
            stop();
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
            stop();
        }
    }
     **/

    @Override
    public void start(){

        CountDownLatch messageLatch;
        final String SENT_MESSAGE = "Hello World";

        try {
            messageLatch = new CountDownLatch(1);

            final ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();
            ClientManager client = ClientManager.createClient();
            webSocketSession = client.connectToServer(new ManagementEndpointWebsocketClient(), cec, serverUri);
            messageLatch.await(100, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "Managament Endpoint failed to connect with Websocket Server:" + e);
        }

    }

    /*
    new Endpoint() {

                @Override
                public void onOpen(Session session, EndpointConfig config) {
                    try {
                        session.addMessageHandler(new MessageHandler.Whole<String>() {

                            @Override
                            public void onMessage(String message) {
                                System.out.println("Received message: "+message);
                                messageLatch.countDown();
                            }
                        });

                        session.getBasicRemote().sendText(SENT_MESSAGE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
     */



    /**
     * close Websocket Session
     */
    @Override
    public void stop(){
        try {
            if(webSocketSession != null){
                webSocketSession.close();
            }else{
                throw new IllegalStateException("Websocket Client is null.");
            }
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        } catch (IllegalStateException e){
            LOGGER.log(Level.WARN,e);
        } finally {
            // Force lifecycle stop when done with container.
            // This is to free up threads and resources that the
            // JSR-356 container allocates. But unfortunately
            // the JSR-356 spec does not handle lifecycles (yet)
            /*if (container instanceof LifeCycle) {
                try {
                    ((LifeCycle) container).stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            */
        }
    }



}
