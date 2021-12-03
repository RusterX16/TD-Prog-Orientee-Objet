package dev.ruster.td7;

import java.util.Random;

public class Util {

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int randomBetween(int a, int b) {
        return new Random().nextInt(Math.max(a, b) - Math.min(a, b)) + Math.min(a, b);
    }
}