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
            lentgh++;
            courant = courant.getSuiv();
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

        if(estVide()) {
            throw new IllegalCallerException("La liste ne peut pas être vide");
        }
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

    public boolean estSupK2(int k) {
        Maillon courant = tete;
        boolean sup = false;

        while(courant != null && !sup) {
            if(k >= 0) {
                sup = true;
            }
            courant = courant.getSuiv();
        }
        return sup;
    }

    public boolean longueurPaire() {
        return longueur() % 2 == 0;
    }

    public int max() {
        Maillon courant = tete;
        int max = 0;

        while(courant != null) {
            max = Math.max(max, courant.getVal());
            courant = courant.getSuiv();
        }
        return max;
    }

    public int occurrences(int n) {
        Maillon courant = tete;
        int occ = 0;

        while(courant != null) {
            if(courant.getVal() == n) {
                occ++;
            }
            courant = courant.getSuiv();
        }
        return occ;
    }

    public void ajoutFin(int n) {
        if(estVide()) {
            tete = new Maillon(n);
            return;
        }
        Maillon courant = tete;

        while(courant.getSuiv() != null) {
            courant = courant.getSuiv();
        }
        courant.setSuiv(new Maillon(n));
    }

    public void ajoutFinSiAbsent(int n) {
        if(!contient(n)) {
            ajoutFin(n);
        }
    }

    public Liste extraireImpairsTete() {
        Liste out = new Liste();
        Maillon courant = tete;

        while(courant.getSuiv() != null) {
            if(courant.getVal() % 2 == 1) {
                out.ajoutTete(courant.getVal());
            }
            courant = courant.getSuiv();
        }
        return out;
    }

    public Liste extraireImpairsQueue() {
        Liste out = new Liste();
        Maillon courant = tete;

        while(courant.getSuiv() != null) {
            if(courant.getVal() % 2 == 1) {
                out.ajoutFin(courant.getVal());
            }
            courant = courant.getSuiv();
        }
        return out;
    }

    public boolean estClone(Liste liste) {
        Maillon courant = tete;
        Maillon courantListe = liste.tete;
        boolean equals = longueur() == liste.longueur();

        while(courant.getSuiv() != null && equals) {
            if(courant.getVal() != courantListe.getVal()) {
                equals = false;
            }
            courant = courant.getSuiv();
            courantListe = courantListe.getSuiv();
        }
        return equals;
    }

    public void supprOcc(int n) {
/*        Maillon courant = tete;
        boolean reached = false;

        while(courant != null) {
            if(courant.getVal() == n && !reached) {
                courant.setVal(-99);
                courant = courant.getSuiv();
                reached = true;
            }
            courant = courant.getSuiv();
        }*/
    }

    public void tronquerK(int k) {
        Maillon courant = tete;
        int length = 0;

        while(courant != null) {
            length++;

            if(length >= k) {
                courant.setSuiv(null);
                break;
            }
            courant = courant.getSuiv();
        }
    }

    public Liste inverse() {
        Liste out = new Liste();
        Maillon courant = tete;

        while(courant != null) {
            out.ajoutTete(courant.getVal());
            courant = courant.getSuiv();
        }
        return out;
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