package dev.ruster.td9;

import dev.ruster.td9.utils.Color;
import dev.ruster.td9.utils.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Orque {

    public static final Orque[] orques = new Orque[1000];
    public static int count = 0;

    private final EE weaponSet = new EE(Weapon.values().length);
    private Arena arena;

    private final int id;
    private double health = Utils.rand.nextInt(150, 200);
    private Weapon weapon;

    public Orque() {
        id = Utils.rand.nextInt(orques.length);
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
        health = (health - damage <= 0 ? 0 : health - damage);
    }

    public Weapon pick() {
        setWeapon(Weapon.random());
        return weapon;
    }

    public boolean attack(@NotNull Orque orque) {
        if(Utils.rand.nextInt(100) / (double) 100 < weapon.getAccuracy()) {
            orque.damage(weapon.getDamage());
            return true;
        }
        return false;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public double getHealth() {
        return health;
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
}