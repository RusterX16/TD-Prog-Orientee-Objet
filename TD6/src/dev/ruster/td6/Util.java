package dev.ruster.td6;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Util {

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static @NotNull String firstLetterCapital(@NotNull String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

    @Contract(pure = true)
    public static int occurence(@NotNull String string, char c) {
        int occurence = 0;

        for(char ch : string.toCharArray()) {
            if(ch == c) {
                occurence++;
            }
        }
        return occurence;
    }

    @Contract(pure = true)
    public static boolean hasDuplicate(@NotNull String string, char c) {
        return occurence(string, c) > 1;
    }

    public static boolean hasRightDateFormat(String date) {
        return occurence(date, '/') == 2;
    }

    public static int hcf(int var1, int var2) {
        int hfc = 1;

        for(int i = 1; i <= Math.min(var1, var2); i++) {
            if(var1 % i == 0 && var2 % i == 0) {
                hfc = i;
            }
        }
        return hfc;
    }

    public static int lcm(int var1, int var2) {
        int lcm = Math.max(var1, var2);

        while(true) {
            if(lcm % var1 == 0 && lcm % var2 == 0) {
                return lcm;
            }
            lcm++;
        }
    }
}