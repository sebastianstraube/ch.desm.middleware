package ch.desm.middleware.app.core.communication.endpoint.ubw32;

public abstract class EndpointUbw32Message<T> {

    private final EndpointUbw32Register register;
    private final T value;

    public EndpointUbw32Message(EndpointUbw32Register register, T value) {
        this.register = register;
        this.value = value;
    }

    public EndpointUbw32Register getRegister() {
        return register;
    }

    public T getRegisterValue() {
        return value;
    }

    public boolean isEqual(EndpointUbw32Message<T> other) {
        if (register != other.register) {
            throw new IllegalArgumentException("Cannot compare register value of two different registers");
        }
        return isRegisterValueEqual(other.getRegisterValue());
    }

    protected abstract boolean isRegisterValueEqual(T value);

    // TODO: get rid of String<->Message conversion and fix EndpointCommonListenerInterface instead!
    public abstract String encode();

    public static EndpointUbw32Message decode(String string) {
        String[] parts = string.split("#");
        if (parts.length != 3) {
            throw new RuntimeException("Message must contain three parts");
        }

        EndpointUbw32Register pin = EndpointUbw32Register.valueOf(parts[1]);
        if (pin == null) {
            throw new RuntimeException("unable to detect register for message " + string);
        }

        switch (parts[0]) {
            case "A":
                return new EndpointUbw32MessageAnalog(pin, EndpointUbw32MessageAnalog.decodeValue(parts[2]));
            case "D":
                return new EndpointUbw32MessageDigital(pin, EndpointUbw32MessageDigital.decodeValue(parts[2]));
            default:
                throw new RuntimeException("Received message with unknown type " + string);
        }
    }

    @Override
    public String toString() {
        return "EndpointUbw32Message{" +
                "register=" + register.name() +
                ", value=" + value +
                '}';
    }
}
