package dev.ruster.td9;

import dev.ruster.td9.utils.Color;
import dev.ruster.td9.utils.Utils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum Weapon {

    AXE("Hache", Color.RED, 80, .6F),
    SWORD("Epee", Color.RED, 50, .9F),
    SPEAR("Lance", Color.RED, 60, .8F),
    FLAIL("Fléau", Color.RED, 100, .5F),
    ;

    private final String name;
    private final String color;
    private final double damage;
    private final float accuracy;

    Weapon(String name, String color, double damage, float accuracy) {
        this.name = name;
        this.color = color;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public static Weapon random() {
        return values()[Utils.rand.nextInt(values().length)];
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Contract(pure = true)
    public @NotNull String getColoredName() {
        return color + name + Color.RESET;
    }

    public double getDamage() {
        return damage;
    }

    public float getAccuracy() {
        return accuracy;
    }
}