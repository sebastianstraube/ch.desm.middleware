package ch.desm.middleware.app.core.communication.endpoint.tcp;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;

import java.io.IOException;

/**
 * Created by Sebastian on 17.12.2014.
 */
public abstract class EndpointTcpBase extends EndpointCommon {

    abstract String receive() throws IOException;
    abstract void receiveEvent(String message) throws IOException;
}
