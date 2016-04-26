package ch.desm.middleware.app.core.communication.endpoint.ubw32;

import ch.desm.middleware.app.core.communication.endpoint.rs232.EndpointRs232;
import jssc.SerialPortException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;

public class EndpointUbw32MessageHandler implements Runnable {

    private static Logger LOGGER = Logger.getLogger(EndpointUbw32MessageHandler.class);

    // TODO: does the message end with a newline or not?
    private static final String SUCCESSFUL_MESSAGE_SUFFIX = "OK\r\r\n";

    private final EndpointRs232 endpoint;
    private final EndpointUbw32Cache cache;
    private final Queue<String> pendingMessages = new LinkedBlockingDeque<>();

    private CompletableFuture<List<String>> responseFuture;
    private String pendingResponse = "";

    public EndpointUbw32MessageHandler(EndpointRs232 endpoint, EndpointUbw32Cache cache) {
        this.endpoint = endpoint;
        this.cache = cache;
    }

    public void sendMessage(String message) {
        if (message.indexOf('\n') != message.length() - 1) {
            throw new RuntimeException("You must add single messages only!");
        }

        pendingMessages.add(message);
    }

    @Override
    public void run() {

        while (true) {
            String message = pendingMessages.poll();
            if (message == null) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            List<String> rawResponse = sendMessageToEndpoint(message);
            if (rawResponse == null) {
                continue;
            }

            // TODO: hacky hack hack
            if (!message.equals("R\n")) {
                rawResponse.remove(0);
            }

            for (String response : rawResponse) {
                if (response.isEmpty() || response.equals("OK")) {
                    continue;
                }

                // TODO: move message parsing here

                if (!cache.isStateChanged(response)) {
                    continue;
                }

                LOGGER.log(Level.TRACE, "cache state changed on ubw(" + endpoint.getSerialPortName() + "): " + response);

                endpoint.onIncomingEndpointMessage(response);
            }
        }
    }

    private List<String> sendMessageToEndpoint(String message) {
        responseFuture = new CompletableFuture<>();
        try {
            try {
                endpoint.sendStream(message);
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

    public void serialEvent(String partialMessage) {
        pendingResponse += partialMessage;

        if (pendingResponse.charAt(0) == '!') {
            // TODO: handle error!
            throw new RuntimeException("UBW32 returned an error: " + partialMessage);
        }

        if (pendingResponse.indexOf(SUCCESSFUL_MESSAGE_SUFFIX) == -1) {
            // not done yet... waiting for more
            return;
        }

        List<String> response = new ArrayList<>();
        for (String message : pendingResponse.split("\n")) {
            response.add(message.replaceAll("\r\r", "").trim());
        }

        pendingResponse = "";

        if (responseFuture != null) {
            responseFuture.complete(response);
        }
    }
}
