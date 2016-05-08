package ch.desm.middleware.core.communication.endpoint.ubw32;

import java.util.Locale;

public class EndpointUbw32MessageDigital extends EndpointUbw32Message<Boolean> {
    public EndpointUbw32MessageDigital(EndpointUbw32Register pin, Boolean value) {
        super(pin, value);
    }

    @Override
    protected boolean isRegisterValueEqual(Boolean value) {
        return this.getRegisterValue() == value;
    }
}
