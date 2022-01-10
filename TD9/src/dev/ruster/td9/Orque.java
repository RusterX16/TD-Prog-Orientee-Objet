package dev.ruster.td9;

import java.util.Optional;
import java.util.Random;

public class Orque {

    public static final Orque[] ORQUEARRAY = new Orque[1000];
    public static int count = 0;

    private final int id;
    private final EE weaponSet = new EE(Weapon.values().length);
    private Arena arena;
    private double health = 200;

    public Orque() {
        id = new Random().nextInt(1000);
        ORQUEARRAY[id] = this;
        count++;
    }

    public static Orque getOrqueById(int id) {
        Optional<Orque> op = Optional.empty();

        for(Orque o : ORQUEARRAY) {
            if(o == ORQUEARRAY[id]) {
                op = Optional.of(o);
                break;
            }
        }
        return op.orElse(null);
    }

    public int duel(Arena arena, int index) {
        int looser = new Random().nextBoolean() ? id : index;
        arena.getSet().remove(looser);
        return looser;
    }

    public void damage(double damage) {
        health = (health - damage <= 0 ? 0 : health - damage);
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public double getHealth() {
        return health;
    }

    public int getId() {
        return id;
    }
}