package ch.desm.middleware.app.core.communication.endpoint.ubw32;

public abstract class EndpointUbw32Message<T> {

    private final EndpointUbw32Pin pin;
    private final T value;

    public EndpointUbw32Message(EndpointUbw32Pin pin, T value) {
        this.pin = pin;
        this.value = value;
    }

    public EndpointUbw32Pin getPin() {
        return pin;
    }

    public T getPinValue() {
        return value;
    }

    public boolean isEqual(EndpointUbw32Message<T> other) {
        if (pin != other.pin) {
            throw new IllegalArgumentException("Cannot compare pin value of two different pins");
        }
        return isPinValueEqual(other.getPinValue());
    }

    protected abstract boolean isPinValueEqual(T value);

    // TODO: get rid of String<->Message conversion and fix EndpointCommonListenerInterface instead!
    public abstract String encode();

    public static EndpointUbw32Message decode(String string) {
        String[] parts = string.split("#");
        if (parts.length != 3) {
            throw new RuntimeException("Message must contain three parts");
        }

        EndpointUbw32Pin pin = EndpointUbw32Pin.valueOf(parts[1]);
        if (pin == null) {
            throw new RuntimeException("unable to detect pin for message " + string);
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
                "pin=" + pin.name() +
                ", value=" + value +
                '}';
    }
}
