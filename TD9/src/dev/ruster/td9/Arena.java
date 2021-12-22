package dev.ruster.td9;

import java.util.Arrays;
import java.util.Objects;

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
        System.out.println(orqueSet);

        while(orqueSet.getCardinal() > 1) {
            orqueSet.removeRandomly();
            System.out.println(orqueSet);

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Féliciation à l'orque numéro " + Orque.ORQUEARRAY[orqueSet.getSet()[0]].getId() + " qui gagne la bataille");
    }
}