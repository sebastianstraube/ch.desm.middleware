package ch.desm.middleware.app.core.communication.message.translator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;

abstract class MessageTranslatorMiddlewareBase {

	private static Logger LOGGER = Logger.getLogger(MessageTranslatorMiddlewareBase.class);

	/**
	 * positions
	 */
	private static final int ID = 0;
	private static final int OUTPUT_INPUT = 1;
	private static final int EXTERN_INTERN = 2;
	private static final int ELEMENT = 3;
	private static final int FUNCTION = 4;
	private static final int INSTANCE = 5;
	private static final int TOPIC = 6;
	private static final int PARAMETER = 7;
	private static final int NUM_PARTS = 8;

	protected List<MessageMiddleware> decodeMiddlewareMessages(String stream) {
		String[] messageArray = stream.split(MessageBase.MESSAGE_MESSAGE_DELIMITER);
		List<MessageMiddleware> messageList = new ArrayList<>(messageArray.length);

		for (int i = 0; i < messageArray.length; i++) {
			MessageMiddleware message = null;
			try {
				message = decodeMiddlewareMessage(messageArray[i]);
			} catch(Exception e) {
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
	 * @return {@link MessageBase}
	 */
	protected MessageMiddleware decodeMiddlewareMessage(String message)throws Exception {
		if (message == null || message.isEmpty()) {
			throw new MalformedMessageException("Message must not be empty", message);
		}

		String[] parts = message.split(MessageBase.MESSAGE_ELEMENT_DELIMITER);
		if (parts.length != NUM_PARTS) {
			throw new MalformedMessageException("Message does not contain required number of arguments: " +
                    String.valueOf(parts.length) + " but expected " + String.valueOf(NUM_PARTS), message);
		}

		return new MessageMiddleware(parts[TOPIC], parts[ID], parts[EXTERN_INTERN],
				parts[ELEMENT], parts[FUNCTION], parts[INSTANCE],
				parts[PARAMETER], message, parts[OUTPUT_INPUT]);
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

	private class MalformedMessageException extends Exception {
		public MalformedMessageException(String msg, String rawMessage) {
			super(msg + " - " + rawMessage);
		}
	}
}
