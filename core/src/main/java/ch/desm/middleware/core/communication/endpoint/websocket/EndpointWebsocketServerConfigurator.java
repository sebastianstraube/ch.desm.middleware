package ch.desm.middleware.core.communication.endpoint.websocket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.ServerEndpointConfig;
import java.util.List;
import java.util.Map;

/**
 * Created by Sebastian on 09.05.2016.
 */
public class EndpointWebsocketServerConfigurator extends ServerEndpointConfig.Configurator {

    private static final Logger LOGGER = Logger.getLogger(EndpointWebsocketServerConfigurator.class);


    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        LOGGER.log(Level.INFO, "getEndpointInstance class:" + endpointClass);
        return super.getEndpointInstance(endpointClass);
    }

    private void logHeader(Map<String, List<String>> headers){
        for (Map.Entry<String, List<String>> el: headers.entrySet()) {
            LOGGER.log(Level.INFO, "key: " + el.getKey());
            for (String value: el.getValue()) {
                LOGGER.log(Level.INFO, "/t value: " + value);
            }
        }
    }
}
