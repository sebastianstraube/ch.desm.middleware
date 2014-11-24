package ch.desm.middleware.app.core.utility;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Sebastian on 12.11.2014.
 */
public class Utility {

    private static final int MIN = 256;
    private static final int MAX = 512;

    public static int randInt(){
        return randInt(MIN, MAX);
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = new Random().nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
