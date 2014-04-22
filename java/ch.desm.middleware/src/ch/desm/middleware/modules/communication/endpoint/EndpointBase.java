package ch.desm.middleware.modules.communication.endpoint;

import java.util.HashSet;
import java.util.Set;

import ch.desm.middleware.modules.communication.message.translator.MessageTranslatorMiddleware;

/**
 * 
 * @author Sebastian
 *
 */
public abstract class EndpointBase {

	protected Set<EndpointCommonListenerInterface> listeners;
	protected MessageTranslatorMiddleware messageTranslator;
	
	/**
	 * 
	 */
	public EndpointBase() {
		this.listeners = new HashSet<EndpointCommonListenerInterface>();
		messageTranslator = new MessageTranslatorMiddleware();
	}

	/**
	 * 
	 * @param listener
	 * @throws Exception
	 */
	abstract public void addEndpointListener(EndpointCommonListenerInterface listener) throws Exception;

}