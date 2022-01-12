package dev.ruster.td10;

public class Liste2 {

    private Maillon tete;
    private Maillon last;
    private int size;

    public Liste2() {
        tete = null;
        size = 0;
        last = null;
    }

    public Liste2(int x) {
        tete = new Maillon(x);
        size = 1;
        last = tete;
    }

    public Liste2(Liste2 liste) {
        tete = liste.tete;
        last = liste.last;
        size = liste.size;
    }

    public void updateLast() {
        Maillon courant = tete;

        while(courant.getSuiv() != null) {
            courant = courant.getSuiv();
        }
        last = courant;
    }

    public Maillon getLast() {
        return last;
    }
}
