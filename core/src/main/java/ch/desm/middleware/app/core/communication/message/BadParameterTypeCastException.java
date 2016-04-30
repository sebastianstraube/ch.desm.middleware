package ch.desm.middleware.app.core.communication.message;

public class BadParameterTypeCastException extends Exception {
    public BadParameterTypeCastException(MessageCommon.ParameterType requested, MessageCommon.ParameterType actual) {
        super("Unable to cast message parameter type from " + requested.name() + " to " + actual.name());
    }
}
