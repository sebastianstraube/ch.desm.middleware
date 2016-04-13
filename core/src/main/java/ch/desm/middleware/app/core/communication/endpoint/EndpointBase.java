package ch.desm.middleware.app.core.communication.endpoint;

import java.util.HashSet;
import java.util.Set;

import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorMiddleware;

/**
 * 
 * @author Sebastian
 * 
 */
public abstract class EndpointBase{

	protected Set<EndpointCommonListenerInterface> listeners = new HashSet<>();;

	/**
	 *
	 * @param listener
	 * @throws Exception
	 */
	public abstract void addEndpointListener(EndpointCommonListenerInterface listener) throws Exception;

}