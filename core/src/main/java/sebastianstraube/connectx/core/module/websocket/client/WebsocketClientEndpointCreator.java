package sebastianstraube.connectx.core.module.websocket.client;

import sebastianstraube.connectx.core.communication.endpoint.EndpointCommon;
import sebastianstraube.connectx.core.communication.endpoint.websocket.EndpointWebsocketMessage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.net.URI;
import java.net.URISyntaxException;

class WebsocketClientEndpointCreator extends EndpointCommon<EndpointWebsocketMessage> {

    private static final Logger LOGGER = Logger.getLogger(WebsocketClientEndpointCreator.class);

    private WebsocketClientEndpointThread thread;
    private WebsocketClientService service;
    private WebsocketClientEndpointConnector client;

    public WebsocketClientEndpointCreator(WebsocketClientServiceBase service){
        super();
        this.registerEndpointListener();
        this.thread = new WebsocketClientEndpointThread(this);
        this.service = (WebsocketClientService) service;
    }

    @Override
    public void onIncomingEndpointMessage(EndpointWebsocketMessage message) {
        LOGGER.log(Level.TRACE, "receive endpoint message: " + message);

        service.getProcessor().processEndpointMessage(service.getBrokerClient(), message.getPayload(), message.getTopic());
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
        try {

            String url = service.getServerConfig().getTyrusServerWebsocketUrl();

            client = new WebsocketClientEndpointConnector(new URI(url));
        } catch (URISyntaxException e) {
            LOGGER.log(Level.ERROR, "Endpoint init failed: ", e);
        }
    }

    @Override
    public void start(){
        if(client == null){
            LOGGER.log(Level.TRACE, "Endpoint is not initialized.");
            return;
        }
        client.connect();
    }

    /**
     *
     */
    @Override
    public void reset(){
        //TODO reset implementation
    }

    /**
     * close Websocket Session
     */
    @Override
    public void stop(){

    }
}
