package ch.desm.middleware.common;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sebastian on 08.05.2016.
 */
public final class Utils {

    private static Logger LOGGER = Logger.getLogger(UtilityHex.class);

    public static void waitForAnyKey() {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(isr);
        try {
            br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean waitForObject(Object obj) {
        while(obj == null){
            try {
                LOGGER.log(Level.INFO, "object not yet created:" + obj);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

}
