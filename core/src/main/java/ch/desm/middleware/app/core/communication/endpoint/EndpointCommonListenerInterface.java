package ch.desm.middleware.app.core.communication.endpoint;

public interface EndpointCommonListenerInterface<T> {
	void onIncomingEndpointMessage(T message);
}
