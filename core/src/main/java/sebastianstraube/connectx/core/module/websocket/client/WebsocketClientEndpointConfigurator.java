package sebastianstraube.connectx.core.module.websocket.client;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import sebastianstraube.connectx.core.module.server.ServerConfig;

import javax.websocket.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Sebastian on 09.05.2016.
 */
public class WebsocketClientEndpointConfigurator extends ClientEndpointConfig.Configurator {

    public static final String TYRUS_WEBSOCKET_CONTEXT_WEBSOCKET = "/websocket";
    public static final String TYRUS_WEBSOCKET_CONTEXT_GUI = "/gui";
    public static final Integer TYRUS_WEBSOCKET_PORT = 8070;

    public static final String TYRUS_SERVER_WEBSOCKET_URL = String.format(
            "ws://%s:%d%s%s",
            ServerConfig.DEFAULT_HOST,
            TYRUS_WEBSOCKET_PORT,
            TYRUS_WEBSOCKET_CONTEXT_WEBSOCKET,
            TYRUS_WEBSOCKET_CONTEXT_GUI);


    private static final Logger LOGGER = Logger.getLogger(WebsocketClientEndpointConfigurator.class);
    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        //affect the headers before request is sent
        LOGGER.log(Level.INFO, "EndpointWebsocketClientConfigurator beforeRequest");
        logHeader(headers);
        super.beforeRequest(headers);
    }

    @Override
    public void afterResponse(HandshakeResponse hr) {
        //process the handshake response
        LOGGER.log(Level.INFO, "EndpointWebsocketClientConfigurator afterResponse");
        logHeader(hr.getHeaders());
        super.afterResponse(hr);
    }

    private void logHeader(Map<String, List<String>> headers){
        for (Map.Entry<String, List<String>> el: headers.entrySet()) {
            for (String value: el.getValue()) {
                LOGGER.log(Level.INFO, "key: " + el.getKey() + " value: " + value);
            }
        }
    }
}
