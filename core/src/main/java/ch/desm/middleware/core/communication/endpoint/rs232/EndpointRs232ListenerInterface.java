package ch.desm.middleware.core.communication.endpoint.rs232;

public interface EndpointRs232ListenerInterface {
    void onData(String data);
}
