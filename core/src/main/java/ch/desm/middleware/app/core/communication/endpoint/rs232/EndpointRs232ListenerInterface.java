package ch.desm.middleware.app.core.communication.endpoint.rs232;

public interface EndpointRs232ListenerInterface {
    void onData(String data);
}
