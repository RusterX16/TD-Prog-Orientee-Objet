package dev.ruster.td10;

public class Liste {

    private Maillon tete;

    /**
     * Constructeur d'une liste vide
     */
    public Liste() {
        tete = null;
    }

    /**
     * Constructeur d'une liste a un seul element
     */
    public Liste(int x) {
        tete = new Maillon(x);
    }

    /**
     * @param tabListe est un tableau contenant les elements de la liste
     *                 Pre-requis : aucun
     */
    public Liste(int[] tabListe) {
        this();

        if(tabListe.length > 0) {
            tete = new Maillon(tabListe[0]);
            Maillon curThis = tete;

            for(int i = 1; i < tabListe.length; i++) {
                curThis.setSuiv(new Maillon(tabListe[i])); // creation et accrochage du maillon suivant
                curThis = curThis.getSuiv();
            }
        }
    }

    /**
     * Prerequis: aucun
     * construit une liste completement disjointe de la liste l
     */
    public Liste(Liste l) { // constructeur par recopie profonde
        this();

        if(!l.estVide()) {
            tete = new Maillon(l.tete.getVal());
            Maillon curThis = tete;
            Maillon curL = l.tete.getSuiv();

            while(curL != null) {
                curThis.setSuiv(new Maillon(curL.getVal())); // creation et accrochage du maillon suivant
                curThis = curThis.getSuiv();
                curL = curL.getSuiv();
            }
        }
    }

    public boolean estVide() {
        return tete == null;
    }

    public void ajoutTete(int x) {
        Maillon m = new Maillon(x);
        m.setSuiv(tete);
        tete = m;
    }

    public boolean contient(int x) {
        Maillon courant = tete;

        while(courant != null && courant.getVal() != x) {
            courant = courant.getSuiv();
        }
        return courant != null;
    }

    public int longueur() {
        Maillon courant = tete;
        int lentgh = 0;

        while(courant != null) {
            courant = courant.getSuiv();
            lentgh++;
        }
        return lentgh;
    }

    public int somme() {
        Maillon courant = tete;
        int sum = 0;

        while(courant != null) {
            sum += courant.getVal();
            courant = courant.getSuiv();
        }
        return sum;
    }

    public int dernierElt() {
        Maillon courant = tete;

        while(courant != null) {
            if(courant.getSuiv() == null) {
                return courant.getVal();
            }
            courant = courant.getSuiv();
        }
        return 0;
    }

    public boolean estSupK(int k) {
        if(k < 0) {
            throw new IllegalArgumentException("k doit être un entier positif");
        }
        return longueur() >= k;
    }

    @Override
    public String toString() {
        String s = "(";
        Maillon courant = tete;

        while(courant != null) {
            s = s.concat(courant.getVal() + ((courant.getSuiv() != null) ? ", " : ""));
            courant = courant.getSuiv();
        }
        return s.concat(")");
    }
}