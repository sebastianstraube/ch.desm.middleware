package ch.desm.middleware.app.core.communication.endpoint.ubw32;

import ch.desm.middleware.app.core.communication.endpoint.rs232.EndpointRs232;
import ch.desm.middleware.app.core.communication.endpoint.rs232.EndpointRs232ListenerInterface;
import jssc.SerialPortException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;

public class EndpointUbw32MessageHandler implements Runnable, EndpointRs232ListenerInterface {

    private static Logger LOGGER = Logger.getLogger(EndpointUbw32MessageHandler.class);

    // TODO: does the message end with a newline or not?
    private static final String SUCCESSFUL_MESSAGE_SUFFIX = "OK\r\r\n";

    private final EndpointUbw32Base ubw32Endpoint;
    private final EndpointRs232 serialEndpoint;
    private final EndpointUbw32State boardState;
    private final EndpointUbw32MessageParser parser;
    private final Queue<String> pendingCommands = new LinkedBlockingDeque<>();

    private CompletableFuture<List<String>> responseFuture;
    private String partialResponse = "";

    public EndpointUbw32MessageHandler(EndpointUbw32Base ubw32Endpoint, EndpointRs232 serialEndpoint, EndpointUbw32State boardState, String pinbitMaskInputAnalog) {
        this.ubw32Endpoint = ubw32Endpoint;
        this.serialEndpoint = serialEndpoint;
        this.boardState = boardState;
        final int analogPortMask = Integer.parseInt(pinbitMaskInputAnalog);
        parser = new EndpointUbw32MessageParser(analogPortMask);
    }

    public void sendMessage(String message) {
        if (message.indexOf('\n') != -1) {
            throw new RuntimeException("You must add single messages only!");
        }

        pendingCommands.add(message);
    }

    @Override
    public void run() {

        while (true) {
            String command = pendingCommands.poll();
            if (command == null) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            if (!command.equals("I") && !command.startsWith("IA")) {
                LOGGER.log(Level.INFO, "sending command to ubw " + command);
            }

            List<String> rawResponse = sendMessageToEndpoint(command + EndpointUbw32Config.MESSAGE_TERMINATOR);
            if (rawResponse == null) {
                continue;
            }

            // The reset command "R" is the only command that is not echoed by the controller
            if (!command.equals("R")) {
                rawResponse.remove(0);
            }

            // TODO: move response parsing to separate thread!

            final String response;
            switch (rawResponse.size()) {
                case 1: // raw response is just OK
                    response = null;
                    break;
                case 2: // raw response is some payload followed by OK
                    response = rawResponse.get(0).trim();
                    break;
                default:
                    throw new RuntimeException("Response must be either OK or data with OK");
            }

            List<EndpointUbw32Message> ubw32Messages = parser.parseResponse(command, response);
            for (EndpointUbw32Message ubw32Message : ubw32Messages) {
                if (!boardState.updatePinState(ubw32Message)) {
                    continue;
                }

                // E3 is the blinking usb status led
                if (ubw32Message.getRegister() != EndpointUbw32Register.E3) {
                    LOGGER.log(Level.INFO, "cache state changed on ubw(" + serialEndpoint.getSerialPortName() + "): " + ubw32Message);
                }

                ubw32Endpoint.onIncomingEndpointMessage(ubw32Message.encode());
            }
        }
    }

    private List<String> sendMessageToEndpoint(String message) {
        responseFuture = new CompletableFuture<>();
        try {
            try {
                serialEndpoint.sendStream(message);
            } catch (SerialPortException e) {
                e.printStackTrace();
                return null;
            }

            final List<String> response;
            try {
                response = responseFuture.get();
            } catch (InterruptedException e) {
                // TODO: handle error case
                e.printStackTrace();
                return null;
            } catch (ExecutionException e) {
                // TODO: handle error case
                e.printStackTrace();
                return null;
            }

            return response;
        } finally {
            responseFuture = null;
        }
    }

    public void onData(String chunk) {
        partialResponse += chunk;

        if (responseFuture == null) {
            LOGGER.log(Level.ERROR, "Received serial event without sending a command before! " + partialResponse);
            return;
        }

        // wrap error into the future and notify caller
        // TODO: is exclamation mark really at the beginning or shall we check for any place?
        if (partialResponse.charAt(0) == '!') {
            responseFuture.completeExceptionally(new RuntimeException("UBW32 returned an error: " + partialResponse));
            return;
        }

        if (partialResponse.indexOf(SUCCESSFUL_MESSAGE_SUFFIX) == -1) {
            // not done yet... waiting for more
            return;
        }

        List<String> response = new ArrayList<>();
        for (String message : partialResponse.split("\n")) {
            response.add(message.replaceAll("\r\r", "").trim());
        }

        partialResponse = "";

        responseFuture.complete(response);
    }

}
