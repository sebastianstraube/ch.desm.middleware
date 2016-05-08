package ch.desm.middleware.core.communication.endpoint.ubw32;

import java.util.HashMap;
import java.util.Map;

// TODO: replace EndpointUbw32State with this class
public class EndpointUbw32State {

    // TODO: make sure is called from one thread only?
    private final Object lock = new Object();
    private final Map<EndpointUbw32Register, EndpointUbw32Message> registerStates = new HashMap<>();

    public EndpointUbw32Message getCurrentState(EndpointUbw32Register pin) {
        return registerStates.get(pin);
    }

    public boolean updatePinState(EndpointUbw32Message registerState) {
        synchronized (lock) {
            final EndpointUbw32Register register = registerState.getRegister();
            if (!registerStates.containsKey(register)) {
                registerStates.put(register, registerState);
                return true;
            }

            EndpointUbw32Message oldState = registerStates.get(register);
            // nothing changed, but keep old value to detect slowly changing analog values
            if (oldState.isEqual(registerState)) {
                return false;
            }

            registerStates.put(register, registerState);
            return true;
        }
    }

    public void reset() {
        synchronized (lock) {
            registerStates.clear();
        }
    }
}
