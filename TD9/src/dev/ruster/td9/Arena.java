package dev.ruster.td9;

import dev.ruster.td9.utils.Utils;

import java.util.Arrays;
import java.util.Objects;

import static dev.ruster.td9.Orque.*;

public class Arena {

    private final EE orqueSet = new EE(1000);

    public Arena(int count) {
        for(int i = 0; i < count; i++) {
            new Orque();
        }
        Arrays.stream(Orque.ORQUEARRAY).filter(Objects::nonNull).forEach(o -> {
            orqueSet.add(o.getId());
            o.setArena(this);
        });
    }

    public void battle() {
        System.out.println("Orques en vie : " + orqueSet);

        while(orqueSet.getCardinal() > 1) {
            int i1 = orqueSet.selectRandomly();
            int i2 = orqueSet.selectRandomly();

            System.out.println(ORQUEARRAY[i1].getId() + " VS " + ORQUEARRAY[i2].getId());

            while(i1 == i2) {
                i2 = orqueSet.selectRandomly();
            }
            int looser = ORQUEARRAY[i1].duel(this, i2);
            System.out.println("Orque " + ORQUEARRAY[looser].getId() + " est mort");

            System.out.println("Orques en vie : " + orqueSet);
            Utils.pause(2000);
        }
        System.out.println("Féliciation à l'orque numéro " + ORQUEARRAY[orqueSet.getSet()[0]].getId() + " qui gagne la bataille");
    }

    public EE getSet() {
        return orqueSet;
    }
}