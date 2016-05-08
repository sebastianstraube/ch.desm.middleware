package ch.desm.middleware.core.communication.endpoint.ubw32;

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

    @Override
    public String toString() {
        return "EndpointUbw32Message{" +
                "register=" + register.name() +
                ", value=" + value +
                '}';
    }
}
