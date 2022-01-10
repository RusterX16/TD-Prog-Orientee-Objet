package dev.ruster.td9.utils;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility Class");
    }

    public static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
