package dev.ruster.td9;

import dev.ruster.td9.utils.Color;
import dev.ruster.td9.utils.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Orque {

    public static final Orque[] orques = new Orque[1000];
    public static int count = 0;

    private final EE weaponSet = new EE(Weapon.values().length);
    private Arena arena;

    private final int id;
    private double health;
    private Weapon weapon;

    public Orque() {
        id = Utils.rand.nextInt(orques.length);
        health = Utils.rand.nextInt(200 - 150) + 150;
        orques[id] = this;
        count++;
    }

    public static Orque getOrqueById(int id) {
        return Arrays.stream(orques).filter(o -> id == o.getId()).findFirst().orElse(null);
    }

    public void eliminate(@NotNull Arena arena) {
        arena.getSet().remove(id);
    }

    public void damage(double damage) {
        health -= Math.max(0, damage);
    }

    public Weapon pick() {
        setWeapon(Weapon.random());
        return weapon;
    }

    public boolean attack() {
        return Utils.rand.nextInt(100) / (double) 100 < weapon.getAccuracy();
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public double getHealth() {
        return Math.max(0, health);
    }

    public int getId() {
        return id;
    }

    public String getIdString() {
        return Color.GREEN + id + Color.RESET;
    }

    public boolean isKo() {
        return health <= 0;
    }

/*    @Override
    public String toString() {
        return "Orque{" +
                "weaponSet=" + weaponSet +
                ", arena=" + arena +
                ", id=" + id +
                ", health=" + health +
                ", weapon=" + weapon +
                '}';
    }*/
}