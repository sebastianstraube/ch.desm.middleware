package ch.desm.middleware.app.module.tyrusclient.middleware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ManagementServiceStart {


    public static void start(){
        ManagementEndpointClientCreator client = new ManagementEndpointClientCreator();
        client.init();
        client.start();

        waitForAnyKey();
    }

    public static void waitForAnyKey() {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(isr);
        try {
            br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
