package sebastianstraube.connectx.core.communication.message.translator;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * TODO implementation
 * 
 * @author Sebastian
 *
 */
public class MessageTranslatorMiddleware extends MessageTranslatorMiddlewareBase {

	private static Logger LOGGER = Logger.getLogger(MessageTranslatorMiddleware.class);

	/**
	 *
	 * @param stream
	 * 
	 */
	public List<MessageCommon> toMiddlewareMessageList(String stream){
		return decodeMiddlewareMessages(stream);
	}

    /**
     *
     * @param stream
     *
     */
    public MessageCommon toMiddlewareMessage(String stream){
		try {
			return decodeMiddlewareMessage(stream);
		} catch (MalformedMessageException e) {
			LOGGER.log(Level.ERROR, e);
			return null;
		}
	}
}
