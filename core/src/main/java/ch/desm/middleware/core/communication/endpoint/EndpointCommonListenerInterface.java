package ch.desm.middleware.core.communication.endpoint;

public interface EndpointCommonListenerInterface<T> {
	void onIncomingEndpointMessage(T message);
}
