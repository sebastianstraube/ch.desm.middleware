package ch.desm.middleware.app.core.communication.endpoint.ubw32;

import java.util.HashMap;
import java.util.Map;

// TODO: replace EndpointUbw32State with this class
public class EndpointUbw32State {

    // TODO: make sure is called from one thread only?
    private final Object lock = new Object();
    private final Map<EndpointUbw32Pin, EndpointUbw32Message> pinStates = new HashMap<>();

    public EndpointUbw32Message getCurrentState(EndpointUbw32Pin pin) {
        return pinStates.get(pin);
    }

    public boolean updatePinState(EndpointUbw32Message pinState) {
        synchronized (lock) {
            final EndpointUbw32Pin pin = pinState.getPin();
            if (!pinStates.containsKey(pin)) {
                pinStates.put(pin, pinState);
                return true;
            }

            EndpointUbw32Message oldState = pinStates.get(pin);
            // nothing changed, but keep old value to detect slowly changing analog values
            if (oldState.isEqual(pinState)) {
                return false;
            }

            pinStates.put(pin, pinState);
            return true;
        }
    }

    public void reset() {
        synchronized (lock) {
            pinStates.clear();
        }
    }
}
