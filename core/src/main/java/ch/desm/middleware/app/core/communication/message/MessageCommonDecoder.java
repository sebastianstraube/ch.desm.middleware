package ch.desm.middleware.app.core.communication.message;

import ch.desm.middleware.app.core.communication.message.translator.MalformedMessageException;

public class MessageCommonDecoder {
    public MessageCommon decode(String message) throws MalformedMessageException {
        if (message == null || message.isEmpty()) {
            throw new MalformedMessageException("Message must not be empty", message);
        }

        String[] parts = message.split(MessageCommon.MESSAGE_ELEMENT_DELIMITER);
        if (parts.length != MessageCommon.NUM_PARTS) {
            throw new MalformedMessageException("Message does not contain required number of arguments: " +
                    String.valueOf(parts.length) + " but expected " + String.valueOf(MessageCommon.NUM_PARTS), message);
        }

        final MessageCommon.ParameterType type;
        try {
            type = decodeType(parts[MessageCommon.TYPE]);
        } catch (InvalidParameterTypeException e) {
            throw new MalformedMessageException("Message contains invalid parameter type " + parts[MessageCommon.TYPE], message);
        }

        final MessageCommonBuilder builder = new MessageCommonBuilder();
        builder.setGlobalId(parts[MessageCommon.ID]);
        builder.setOutputInput(parts[MessageCommon.OUTPUT_INPUT]);
        builder.setExternIntern(parts[MessageCommon.EXTERN_INTERN]);
        builder.setElement(parts[MessageCommon.ELEMENT]);
        builder.setFunction(parts[MessageCommon.FUNCTION]);
        builder.setInstance(parts[MessageCommon.INSTANCE]);
        builder.setTopic(parts[MessageCommon.TOPIC]);
        builder.setType(type);
        builder.setParameter(parts[MessageCommon.PARAMETER]);

        try {
            return builder.build();
        } catch (MessageCommonBuilder.MissingArgumentsException e) {
            throw new MalformedMessageException(String.valueOf(e), message);
        }
    }

    public static MessageCommon.ParameterType decodeType(String type) throws InvalidParameterTypeException {
        if (type.length() != 1) {
            throw new InvalidParameterTypeException();
        }

        switch (type.toLowerCase().charAt(0)) {
            case 'n':
                return MessageCommon.ParameterType.NULL;
            case 'b':
                return MessageCommon.ParameterType.BOOLEAN;
            case 'i':
                return MessageCommon.ParameterType.INTEGER;
            case 'd':
                return MessageCommon.ParameterType.DOUBLE;
            case 's':
                return MessageCommon.ParameterType.STRING;
            default:
                throw new InvalidParameterTypeException();
        }
    }

}
