package ch.desm.middleware.app.core.communication.endpoint.ubw32;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EndpointUbw32MessageParser {

    private static Logger LOGGER = Logger.getLogger(EndpointUbw32MessageParser.class);

    private static final String[] PORTS = new String[]{"A", "B", "C", "D", "E", "F", "G"};
    private static final String ANALOG_PORT = "B";

    private final int analogPortConfig;

    public EndpointUbw32MessageParser(int analogPortConfig) {
        this.analogPortConfig = analogPortConfig;
    }

    public List<EndpointUbw32Message> parseResponse(String command, String response) {
        List<EndpointUbw32Message> result = new ArrayList<>();

        String[] commandParts = command.split(",");
        String commandName = commandParts[0];

        // NOTE: commands are case sensitive, so we should not need the
        //        toUpperCase here, but better safe than sorry.
        switch (commandName.toUpperCase()) {

            case "C":
                LOGGER.log(Level.DEBUG, "Successfully applied the configuration " + command);
                break;

            case "O":
                // ignore
                break;

            case "I":
                parseDigitalInputs(result, commandParts, response);
                break;

            case "V":
                LOGGER.log(Level.INFO, "Controller Version: " + response);
                break;

            case "R":
                LOGGER.log(Level.DEBUG, "The controller was reset successfully");
                break;

            case "PD": // Pin Direction
                // ignore
                break;

            case "PI": // Pin Input
                parseDigitalInput(result, commandParts, response);
                break;

            case "PO": // Pin Output
                // ignore
                break;

            case "CU":
                // ignore
                break;

            case "BL":
                throw new RuntimeException("DO NOT ENTER BOOT LOADER MODE THROUGH THE MIDDLEWARE");

            case "T1":
            case "T2":
                LOGGER.log(Level.DEBUG, "The controller finished the test " + commandName + " successfully");
                break;

            case "PM": // Set hardware PWM output values
                // TODO: implement me!
                throw new RuntimeException("Parsing of command " + commandName + " not implemented yet!");
                //break;

            case "SP": // Set software PWM output values
                // TODO: implement me!
                throw new RuntimeException("Parsing of command " + commandName + " not implemented yet!");
                //break;

            case "PC": //  Configure software PWM
                // TODO: implement me!
                throw new RuntimeException("Parsing of command " + commandName + " not implemented yet!");
                //break;

            case "CA": //  Configure Analog
                // ignore
                break;

            case "IA":
                parseAnalogInputs(result, commandParts, response);
                break;

            default:
                LOGGER.log(Level.ERROR, "Unable to parse unknown command " + commandName);
                break;
        }

        return result;
    }

    private void parseDigitalInput(List<EndpointUbw32Message> result, String[] commandParts, String response) {
        String[] responseParts = response.split(",");
        if (responseParts.length != 2) {
            throw new RuntimeException("Invalid number of PI response parts");
        }

        final EndpointUbw32Pin pin = parsePin(commandParts[1], commandParts[2]);
        final Boolean pinValue = (responseParts[1] == "1");
        result.add(new EndpointUbw32MessageDigital(pin, pinValue));
    }

    private void parseDigitalInputs(List<EndpointUbw32Message> result, String[] commandParts, String response) {
        String[] responseParts = response.split(",");
        if (responseParts.length != 8) {
            throw new RuntimeException("Invalid number of I response parts");
        }

        for (int i = 0; i < PORTS.length; ++i) {
            final String port = PORTS[i];
            final boolean isAnalogPort = port.equals(ANALOG_PORT);
            final int portMask = Integer.parseInt(responseParts[i + 1]);

            for (int p = 0; p < 16; ++p) {
                final int currentPinMask = 1 << p;

                final boolean isAnalogPin = (analogPortConfig & currentPinMask) > 0;
                // skip if configured as analog pin
                if (isAnalogPort && isAnalogPin) {
                    continue;
                }

                final EndpointUbw32Pin pin = parsePin(port, String.valueOf(p));
                final Boolean pinValue = (portMask & currentPinMask) > 0;
                result.add(new EndpointUbw32MessageDigital(pin, pinValue));
            }
        }
    }

    private void parseAnalogInputs(List<EndpointUbw32Message> result, String[] commandParts, String response) {
        final String[] responseParts = response.split(",");
        final int pinMask = Integer.parseInt(commandParts[1]);
        final int numSamples = Integer.parseInt(commandParts[3]);

        // no bit configured
        if (pinMask == 0) {
            return;
        }

        final int numConfiguredPins = getNumBitsSet(pinMask);
        final List<Integer> values = new ArrayList<>();
        int currentResultPin = 0;
        for (int p = 0; p < 16; ++p) {
            if (((1 << p) & pinMask) == 0) {
                continue;
            }

            values.clear();
            for (int s = 0; s < numSamples; ++s) {
                final int idx = 1 + (s * numConfiguredPins) + currentResultPin;
                final int value = Integer.parseInt(responseParts[idx]);
                values.add(value);
            }

            Double pinValue = calculateAnalagValue(values);
            EndpointUbw32Pin pin = EndpointUbw32Pin.valueOf(ANALOG_PORT + String.valueOf(p));
            result.add(new EndpointUbw32MessageAnalog(pin, pinValue));

            ++currentResultPin;
        }
    }

    private int getNumBitsSet(int mask) {
        int result = 0;
        for (int i = 15; i >= 0; --i) {
            if (((1 << i) & mask) > 0) {
                ++result;
            }
        }
        return result;
    }

    // TODO: calculate median of values instead of mean
    private Double calculateAnalagValue(List<Integer> values) {
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }
        return sum / values.size() / 1023.0;
    }

    private EndpointUbw32Pin parsePin(String port, String pin) {
        return EndpointUbw32Pin.valueOf(port + pin);
    }

}
