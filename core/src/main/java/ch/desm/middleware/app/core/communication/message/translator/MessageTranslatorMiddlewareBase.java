package ch.desm.middleware.app.core.communication.message.translator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;

public abstract class MessageTranslatorMiddlewareBase {

	private static Logger LOGGER = Logger.getLogger(MessageTranslatorMiddlewareBase.class);

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
		if (parts.length != MessageCommon.NUM_PARTS) {
			throw new MalformedMessageException("Message does not contain required number of arguments: " +
                    String.valueOf(parts.length) + " but expected " + String.valueOf(MessageCommon.NUM_PARTS), message);
		}

		final MessageCommon.ParameterType type;
		try {
			type = MessageCommon.parseParameterType(parts[MessageCommon.TYPE]);
		} catch (MessageCommon.InvalidParameterTypeException e) {
			throw new MalformedMessageException("Message contains invalid parameter type " + parts[MessageCommon.TYPE], message);
		}

		return new MessageCommon(message,
				parts[MessageCommon.TOPIC],
				parts[MessageCommon.ID],
				parts[MessageCommon.OUTPUT_INPUT],
				parts[MessageCommon.EXTERN_INTERN],
				parts[MessageCommon.ELEMENT],
				parts[MessageCommon.FUNCTION],
				parts[MessageCommon.INSTANCE],
				type,
				parts[MessageCommon.PARAMETER]);
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

	public static class MalformedMessageException extends Exception {
		public MalformedMessageException(String msg, String rawMessage) {
			super(msg + " - " + rawMessage);
		}
	}
}
