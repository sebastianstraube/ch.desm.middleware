package ch.desm.middleware.core.communication.endpoint.ubw32;

public class EndpointUbw32MessageAnalog extends EndpointUbw32Message<Double> {

    // TODO: tweak threshold in lab!
    public static final Double PIN_VALUE_EQUAL_THRESHOLD = 0.1; // in percent to max value

    public EndpointUbw32MessageAnalog(EndpointUbw32Register pin, Double value) {
        super(pin, value);
    }

    @Override
    protected boolean isRegisterValueEqual(Double value) {
        return Math.abs(value - getRegisterValue()) < PIN_VALUE_EQUAL_THRESHOLD;
    }
}
