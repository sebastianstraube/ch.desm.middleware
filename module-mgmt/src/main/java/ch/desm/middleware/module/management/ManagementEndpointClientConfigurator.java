package ch.desm.middleware.module.management;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Sebastian on 09.05.2016.
 */
public class ManagementEndpointClientConfigurator extends ClientEndpointConfig.Configurator {

    private static final Logger LOGGER = Logger.getLogger(ManagementEndpointClientConfigurator.class);
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
