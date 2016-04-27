package ch.desm.middleware.app.core.communication.endpoint.ubw32;

import java.util.Locale;

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

    // TODO: remove again
    @Override
    public String encode() {
        return String.format(Locale.ENGLISH, "A#%s#%f", getRegister().name(), getRegisterValue());
    }

    // TODO: remove again
    public static Double decodeValue(String value) {
        return Double.valueOf(value);
    }
}
