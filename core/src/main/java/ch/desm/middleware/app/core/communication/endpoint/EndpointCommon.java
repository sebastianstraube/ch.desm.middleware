package ch.desm.middleware.app.core.communication.endpoint;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public abstract class EndpointCommon<TMessage> extends EndpointBase implements EndpointCommonListenerInterface<TMessage> {

	private static final Logger LOGGER = Logger.getLogger(EndpointCommon.class);

    public abstract void init();
    public abstract void start() throws InterruptedException;
    public abstract void stop();
    public abstract void reset();

    /**
     * make sure to call addEndpointListener in implementation class
     */
    protected abstract void registerEndpointListener();

	@Override
	public void addEndpointListener(EndpointCommonListenerInterface listener) throws Exception {
		if (!(listener instanceof EndpointCommonListenerInterface)) {
			throw new Exception("Only endpoints with message handling supported.");
		}
        this.listeners.add(listener);
	}
}
