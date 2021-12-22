package dev.ruster.td9;

public enum Weapon {

    AXE("Hache", 80, .6F),
    SWORD("Epee", 50, .9F),
    SPEAR("Lance", 60, .8F),
    FLAIL("Fléau", 100, .3F),
    ;

    private final String name;
    private final double damage;
    private final float accuracy;

    Weapon(String name, double damage, float accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public float getAccuracy() {
        return accuracy;
    }
}