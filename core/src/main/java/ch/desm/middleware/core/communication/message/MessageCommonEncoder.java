package ch.desm.middleware.core.communication.message;

public class MessageCommonEncoder {
    public String encode(MessageCommon messageCommon) {
        try {
            String[] parts = new String[MessageCommon.NUM_PARTS];
            parts[MessageCommon.ID] = messageCommon.getGlobalId();
            parts[MessageCommon.OUTPUT_INPUT] = messageCommon.getOutputInput();
            parts[MessageCommon.EXTERN_INTERN] = messageCommon.getExternIntern();
            parts[MessageCommon.ELEMENT] = messageCommon.getElement();
            parts[MessageCommon.FUNCTION] = messageCommon.getFunction();
            parts[MessageCommon.INSTANCE] = messageCommon.getInstance();
            parts[MessageCommon.TOPIC] = messageCommon.getTopic();
            parts[MessageCommon.TYPE] = encodeType(messageCommon.getType());
            parts[MessageCommon.PARAMETER] = encodeParameterValue(messageCommon);
            final String delimiter = MessageCommon.MESSAGE_ELEMENT_DELIMITER;
            return String.join(delimiter, parts) + delimiter;
        } catch (InvalidParameterTypeException e) {
            e.printStackTrace();
            return null;
        } catch (BadParameterTypeCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String encodeType(MessageCommon.ParameterType type) throws InvalidParameterTypeException {
        switch (type) {
            case NULL:
                return "n";
            case BOOLEAN:
                return "b";
            case INTEGER:
                return "i";
            case DOUBLE:
                return "d";
            case STRING:
                return "s";
            default:
                throw new InvalidParameterTypeException();
        }
    }

    private String encodeParameterValue(MessageCommon messageCommon) throws BadParameterTypeCastException, InvalidParameterTypeException {
        switch (messageCommon.getType()) {
            case NULL:
                return "";
            case BOOLEAN:
                return MessageCommon.mapBoolToOnOffParameter(messageCommon.getParameterAsBoolean());
            case INTEGER:
                return String.valueOf(messageCommon.getParameterAsInteger());
            case DOUBLE:
                return String.valueOf(messageCommon.getParameterAsDouble());
            case STRING:
                return messageCommon.getParameterAsString();
            default:
                throw new InvalidParameterTypeException();
        }
    }
}
