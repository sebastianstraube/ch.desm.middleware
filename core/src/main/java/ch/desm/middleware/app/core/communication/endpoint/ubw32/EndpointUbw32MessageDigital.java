package ch.desm.middleware.app.core.communication.endpoint.ubw32;

import java.util.Locale;

public class EndpointUbw32MessageDigital extends EndpointUbw32Message<Boolean> {
    public EndpointUbw32MessageDigital(EndpointUbw32Register pin, Boolean value) {
        super(pin, value);
    }

    @Override
    protected boolean isRegisterValueEqual(Boolean value) {
        return this.getRegisterValue() == value;
    }

    // TODO: remove again
    @Override
    public String encode() {
        return String.format(Locale.ENGLISH, "D#%s#%d", getRegister().name(), getRegisterValue() ? 1 : 0);
    }

    // TODO: remove again
    public static Boolean decodeValue(String value) {
        int intValue = Integer.parseInt(value);
        return intValue == 1;
    }
}
