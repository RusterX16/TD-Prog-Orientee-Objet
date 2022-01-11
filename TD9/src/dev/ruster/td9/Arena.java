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
                    " a " + Color.CYAN + orques[y].getHealth() + Color.RESET + " s'équipe d'un(e) " + orques[y].pick().getColoredName() + " sur ce round\n");
            Utils.pause(3500);
            Orque looser;

            while(!orques[x].isKo() && !orques[y].isKo()) {
                int first = Utils.rand.nextInt(2) == 0 ? orques[x].getId() : orques[y].getId();

                if(first == orques[x].getId()) {
                    round(x, y);
                } else {
                    round(y, x);
                }
            }
            looser = orques[x].isKo() ? orques[x] : orques[y];
            looser.eliminate(this);

            System.out.println(Color.PURPLE + "Orque " + looser.getIdString() + Color.PURPLE + " est mort" + Color.RESET);
            Utils.pause(3500);
            System.out.println("Orques en vie : " + Color.YELLOW + orqueSet + "\n" + Color.RESET);
            Utils.pause(3500);
        }
        System.out.println(Color.BLUE + "Félicitions à Orque " + orques[orqueSet.getSet()[0]].getIdString() + Color.BLUE + " qui gagne la bataille" + Color.RESET);
    }

    private void round(int i, int j) {
        Utils.pause(3500);

        System.out.println("Orque " + orques[i].getIdString() + " commence à attaquer");
        Utils.pause(3500);
        round(j, i, orques[j]);

        if(orques[j].isKo()) {
            return;
        }
        System.out.println("Orque " + orques[j].getIdString() + " tente de répliquer à son ataque");
        Utils.pause(3500);
        round(i, j, orques[i]);
    }

    private void round(int i, int j, Orque orque) {
        if(orques[j].attack()) {
            double damage = orques[i].getWeapon().getDamage();
            orque.damage(damage);

            System.out.println("Orque " + orques[j].getIdString() + " attaque son adversaire et lui inflige " + Color.PURPLE + damage +
                    Color.RESET + ". Orque " + orque.getIdString() + " a désormais " + Color.CYAN + orque.getHealth() + Color.RESET + " points de vie");
        } else {
            System.out.println("Orque " + orques[j].getIdString() + " rate son attaque");
        }
        System.out.println();
        Utils.pause(3500);
    }

    public EE getSet() {
        return orqueSet;
    }

    @Override
    public String toString() {
        return "Arena{" +
                "orqueSet=" + orqueSet +
                '}';
    }
}