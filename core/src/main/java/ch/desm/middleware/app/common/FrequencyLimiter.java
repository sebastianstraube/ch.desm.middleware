package ch.desm.middleware.app.common;

/**
 * This class allows keeping busy loops at a certain frequency.
 * in case the computation took more than zero time - which is usually
 * the case - the check() function will sleep to reach the configured
 * frequency. In case the computation took longer than the configured
 * frequency, the function will not block, but immediately return.
 * This improves responsiveness of busy loops under load especially.
 *
 * Due to the low resolution of milliseconds, the should not be used
 * for frequencies larger than 100 Hz.
 *
 * TODO: track overall frequency to get rid of drift
 */
public class FrequencyLimiter {

    private Float frequency;

    public FrequencyLimiter(Float frequency) {
        this.frequency = frequency;
    }

    public Float getFrequency() {
        return frequency;
    }

    public void setFrequency(Float frequency) {
        this.frequency = frequency;
    }

    /**
     * In case the time elapsed since intervalStartMillis is shorter than
     * the allowed frequency, the function will block until it is garuanteed
     * the interval is below the configured frequency.
     *
     * @param intervalStartMillis
     * @return
     */
    public void ensureLimit(long intervalStartMillis) throws InterruptedException {
        final long interval = Math.round(1000 / frequency);
        final long now = System.currentTimeMillis();
        final long used = now - intervalStartMillis;
        final long remaining = interval - used;
        if (remaining > 0) {
            Thread.sleep(remaining);
        }
    }
}
