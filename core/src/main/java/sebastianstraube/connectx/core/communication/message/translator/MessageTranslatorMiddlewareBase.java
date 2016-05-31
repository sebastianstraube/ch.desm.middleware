package sebastianstraube.connectx.core.communication.message.translator;

import java.util.ArrayList;
import java.util.List;

import sebastianstraube.connectx.core.communication.message.MessageCommonDecoder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import sebastianstraube.connectx.core.communication.message.MessageCommon;

public abstract class MessageTranslatorMiddlewareBase {

	private static Logger LOGGER = Logger.getLogger(MessageTranslatorMiddlewareBase.class);
	private final MessageCommonDecoder decoder = new MessageCommonDecoder();

	protected List<MessageCommon> decodeMiddlewareMessages(String stream) {
		String[] messageArray = stream.split(MessageCommon.MESSAGE_MESSAGE_DELIMITER);
		List<MessageCommon> messageList = new ArrayList<>(messageArray.length);

		for (int i = 0; i < messageArray.length; i++) {
			MessageCommon message = null;
			try {
				message = decodeMiddlewareMessage(messageArray[i]);
			} catch(MalformedMessageException e) {
				LOGGER.log(Level.ERROR, e);
			}
			messageList.add(message);
		}
		return messageList;
	}

	/**
	 * decodes a message to fit the message object
	 *
	 * TODO refactor EnumMessageTopic topic, move it to standard message stream
	 *
	 * @param message
	 * @return {@link MessageCommon}
	 */
	protected MessageCommon decodeMiddlewareMessage(String message)throws MalformedMessageException {
		return decoder.decode(message);
	}

	/**
	 *
	 * @param wildcard
	 * @param replace
	 * @param message
	 * @return
	 */
	protected String replaceMiddlewareMessageParameter(String wildcard, String replace, String message) {
		return message.replaceAll(wildcard, replace);
	}

}
