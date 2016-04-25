package ch.desm.middleware.app.core.communication.message.translator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;

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
	private static final int TYPE = 7;
	private static final int PARAMETER = 8;
	private static final int NUM_PARTS = 9;

	protected List<MessageCommon> decodeMiddlewareMessages(String stream) {
		String[] messageArray = stream.split(MessageBase.MESSAGE_MESSAGE_DELIMITER);
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
	 * @return {@link MessageBase}
	 */
	protected MessageCommon decodeMiddlewareMessage(String message)throws MalformedMessageException {
		if (message == null || message.isEmpty()) {
			throw new MalformedMessageException("Message must not be empty", message);
		}

		String[] parts = message.split(MessageBase.MESSAGE_ELEMENT_DELIMITER);
		if (parts.length != NUM_PARTS) {
			throw new MalformedMessageException("Message does not contain required number of arguments: " +
                    String.valueOf(parts.length) + " but expected " + String.valueOf(NUM_PARTS), message);
		}

		final MessageCommon.ParameterType type;
		try {
			type = MessageCommon.parseParameterType(parts[TYPE]);
		} catch (MessageCommon.InvalidParameterTypeException e) {
			throw new MalformedMessageException("Message contains invalid parameter type " + parts[TYPE], message);
		}

		return new MessageCommon(message, parts[TOPIC], parts[ID], parts[OUTPUT_INPUT], parts[EXTERN_INTERN],
				parts[ELEMENT], parts[FUNCTION], parts[INSTANCE], type, parts[PARAMETER]);
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

	public class MalformedMessageException extends Exception {
		public MalformedMessageException(String msg, String rawMessage) {
			super(msg + " - " + rawMessage);
		}
	}
}
