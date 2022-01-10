package dev.ruster.td7.utils;

import java.util.Random;

public class Util {

    public static void ln(int count) {
        System.out.println("\n".repeat(count));
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getRandomBetween(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}