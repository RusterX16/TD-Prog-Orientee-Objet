package dev.ruster.td9;

import dev.ruster.td9.utils.Color;
import dev.ruster.td9.utils.Utils;

import java.util.Arrays;
import java.util.Objects;

import static dev.ruster.td9.Orque.orques;

public class Arena {

    private final EE orqueSet = new EE(1000);

    public Arena(int count) {
        for(int i = 0; i < count; i++) {
            new Orque();
        }
        Arrays.stream(Orque.orques).filter(Objects::nonNull).forEach(o -> {
            orqueSet.add(o.getId());
            o.setArena(this);
        });
    }

    public void battle() {
        System.out.println("Orques en vie dans l'arêne : " + Color.YELLOW + orqueSet + "\n" + Color.RESET);

        while(orqueSet.getCardinal() > 1) {
            int x = orqueSet.selectRandomly();
            int y;

            do {
                y = orqueSet.selectRandomly();
            } while(x == y);

            System.out.println("Un duel est lancé entre Orque " + orques[x].getIdString() + " et Orque " + orques[y].getIdString());
            System.out.println("Orque " + orques[x].getIdString() + " possède " + Color.CYAN + orques[x].getHealth() + Color.RESET +
                    " et décide de se battre avec un(e) " + orques[x].pick().getColoredName() + " tandis que " + orques[y].getIdString() +
                    " a " + Color.CYAN + orques[y].getHealth() + Color.RESET + " s'équipe d'un(e) " + orques[y].pick().getColoredName() + " sur ce round");

            Orque looser;

            while(!orques[x].isKo() && !orques[y].isKo()) {
                int first = Utils.rand.nextInt(2) == 0 ? orques[x].getId() : orques[y].getId();

                if(first == orques[x].getId()) {
                    Utils.pause(3000);
                    System.out.println("Orque " + orques[x].getIdString() + " commence à attaquer");
                    Utils.pause(3000);

                    if(orques[x].attack(orques[y])) {
                        double yHealth = orques[y].getHealth();

                        System.out.println("Orque " + orques[x].getIdString() + " attack son adversaire et lui inflige " + Color.PURPLE + (yHealth - orques[y].getHealth()) +
                                Color.RESET + ". Orque " + orques[y].getIdString() + " a désormais " + Color.CYAN + orques[y].getHealth() + Color.RESET + " points de vie");
                    } else {
                        System.out.println("Orque " + orques[x].getIdString() + " rate son attaque");
                    }
                }
            }
            looser = orques[x].isKo() ? orques[x] : orques[y];
            looser.eliminate(this);

            System.out.println(Color.PURPLE + "Orque " + looser.getIdString() + Color.PURPLE + " est mort" + Color.RESET);
            System.out.println("Orques en vie : " + Color.YELLOW + orqueSet + "\n" + Color.RESET);
            Utils.pause(3000);
        }
        System.out.println(Color.BLUE + "Félicitions à Orque " + orques[orqueSet.getSet()[0]].getIdString() + Color.BLUE + " qui gagne la bataille" + Color.RESET);
    }

    public EE getSet() {
        return orqueSet;
    }
}