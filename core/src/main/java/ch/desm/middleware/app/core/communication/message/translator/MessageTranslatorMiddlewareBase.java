package ch.desm.middleware.app.core.communication.message.translator;

import java.util.LinkedList;

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
	private static final int PARAMETER = 6;
	private static final int TOPIC = 7;

	protected LinkedList<MessageMiddleware> decodeMiddlewareMessages(String stream) {
		String[] messageArray = stream.split(MessageBase.MESSAGE_MESSAGE_DELIMITER);
		LinkedList<MessageMiddleware> messageList = new LinkedList<MessageMiddleware>();

		for (int i = 0; i < messageArray.length; i++) {
			messageList.add(decodeMiddlewareMessage(messageArray[i]));
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
	protected MessageMiddleware decodeMiddlewareMessage(String message) {
		MessageMiddleware messageCommon = null;
		try {
			if (message == null || message.isEmpty()) {
				throw new Exception("there is no message to translate");
			} else {
				String[] parts = message.split(MessageBase.MESSAGE_ELEMENT_DELIMITER);
				
				messageCommon = new MessageMiddleware(parts[TOPIC], parts[ID], parts[EXTERN_INTERN],
						parts[ELEMENT], parts[FUNCTION], parts[INSTANCE],
						parts[PARAMETER], message, parts[OUTPUT_INPUT]);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.ERROR, e);
		}
		return messageCommon;
	}

	/**
	 * TODO implementation decode to the common middleware message
	 * 
	 * @param
	 * @param
	 */
	protected String encodeMiddlewareMessage(MessageMiddleware message) {

		String endpointMessage = "";
		endpointMessage += message.getGlobalId();
		endpointMessage += MessageBase.MESSAGE_ELEMENT_DELIMITER;
		endpointMessage += message.getGlobalId();
		endpointMessage += MessageBase.MESSAGE_ELEMENT_DELIMITER;
		endpointMessage += message.getExternIntern();
		endpointMessage += MessageBase.MESSAGE_ELEMENT_DELIMITER;
		endpointMessage += message.getElement();
		endpointMessage += MessageBase.MESSAGE_ELEMENT_DELIMITER;
		endpointMessage += message.getFunction();
		endpointMessage += MessageBase.MESSAGE_ELEMENT_DELIMITER;
		endpointMessage += message.getInstance();
		endpointMessage += MessageBase.MESSAGE_ELEMENT_DELIMITER;
		endpointMessage += message.getParameter();
		endpointMessage += MessageBase.MESSAGE_MESSAGE_DELIMITER;

		return endpointMessage;
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
