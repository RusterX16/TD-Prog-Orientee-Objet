package dev.ruster.td9.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Utils {

    public static Random rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private Utils() {
        throw new IllegalStateException("Utility Class");
    }

    public static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
