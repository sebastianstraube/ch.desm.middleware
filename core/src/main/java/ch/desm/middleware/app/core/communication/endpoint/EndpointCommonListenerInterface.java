package ch.desm.middleware.app.core.communication.endpoint;

// TODO: introduce generic for endpoint message type
public interface EndpointCommonListenerInterface {
	void onIncomingEndpointMessage(String message);
}
