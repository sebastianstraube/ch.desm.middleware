package sebastianstraube.connectx.core.communication.endpoint;

public interface EndpointCommonListenerInterface<T> {
	void onIncomingEndpointMessage(T message);
}
