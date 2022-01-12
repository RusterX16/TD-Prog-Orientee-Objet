package dev.ruster.td10;

public class Main {

    public static void main(String[] args) {
        Liste l1 = new Liste(3);
        l1.ajoutTete(2);
        l1.ajoutTete(6);

        System.out.println("2 appartient l1 ? " + l1.contient(2));

        int[] tab = {-3, -8, 5, 6, 8, 2, 6};
        Liste l2 = new Liste(tab);

        Liste lvide = new Liste();
        System.out.println("1 appartient lvide ? " + lvide.contient(1));

        Liste l2copie = new Liste(l2);

        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);
        System.out.println("lvide = " + lvide);
        System.out.println("l2copie = " + l2copie);

        System.out.println("Longueur de l1 = " + l1.longueur());
        System.out.println("Longueur de l2 = " + l2.longueur());

        System.out.println("Somme de l1 = " + l1.somme());
        System.out.println("Somme de l2 = " + l2.somme());

        System.out.println("Dernier de l1 = " + l1.dernierElt());
        System.out.println("Dernier de l1 = " + l2.dernierElt()); l2.longueur();

        System.out.println("Somme de l1 = " + l1.somme());
        System.out.println("Somme de l2 = " + l2.somme());

        System.out.println("Dernier de l1 = " + l1.dernierElt());
        System.out.println("Dernier de l1 = " + l2.dernierElt());

/*        System.out.println("l1 lg paire = " + l1.aLgPaire());
        System.out.println("l2 lg paire = " + l2.aLgPaire());*/

        System.out.println("Longueur l1 > 2 ? = " + l1.estSupK(2));
        System.out.println("Longueur l1 > 2 ? = " + l1.estSupK(2));
        System.out.println("Longueur l1 > 3 ? = " + l1.estSupK(3));
        System.out.println("Longueur l1 > 3 ? = " + l1.estSupK(3));

        System.out.println("Max l1 = " + l1.max());
        System.out.println("Max l2 = " + l2.max());

        System.out.println("Occurrences de 3 dans l1 = " + l1.occurrences(3));
        System.out.println("Occurrences de 6 dans l2 = " + l2.occurrences(6));

        l1.ajoutFin(-7);
        System.out.println("Ajout de -7 en fin de l1 = " + l1);
        l1.ajoutFin(-2);
        System.out.println("Ajout de -7 en fin de l1 = " + l1);

        l1.ajoutFinSiAbsent(4);
        System.out.println("Ajout de 4 dans l1 car absent = " + l1);
        l1.ajoutFinSiAbsent(3);
        System.out.println("Non ajout de 4 dans l1 car present = " + l1);
        l2.ajoutFinSiAbsent(2);
        System.out.println("Non ajout de 2 dans l2 car present " + l2);
        lvide.ajoutFinSiAbsent(1);
        System.out.println("Ajout de 1 a une liste vide = " + lvide);

        System.out.println("Extraire impairs tete de l1 = " + l1.extraireImpairsTete());
        System.out.println("Extraire impairs queue de l2 = " + l2.extraireImpairsQueue());

        l1.supprOcc(3);
        System.out.println("Suppr first 3 de l1 = " + l1);
        l2.supprOcc(6);
        System.out.println("Suppr first 6 de l2 = " + l2);
        l2.supprOcc(6);
        System.out.println("Suppr first 6 de l2 = " + l2);
        l2.supprOcc(-3);
        System.out.println("Suppr first -3 de l2 = " + l2);

        l2.tronquerK(2);
        System.out.println("Tronque l2 indice 2 = " + l2);

        int[] tab4 = {1, 2, 3, 4};
        Liste L4 = new Liste(tab4);

        int[] tab5 = {0, 1, 2, 3, 4};
        Liste L5 = new Liste(tab5);

        System.out.println("L4 = " + L4 + " L5 = " + L5);
        System.out.println("L4 clone de L5 = " + L4.estClone(L5));
        Liste L4clone = new Liste(L4);
        System.out.println("L4clone clone de L4 = " + L4.estClone(L4clone));

        int[] tab3 = {-3, -3, -8, -3, -3, 6, -3, 5, -3, 8, -3};
        Liste L3 = new Liste(tab3);
        System.out.println("L3 = " + L3);

        /*
        L3.suppToutesOcc(-3);
        System.out.println("SuppToutesOcc de L3 = " + L3);
        */

        System.out.print("L4 a l'envers = " + L4.inverse());
        System.out.println();

        /*
        System.out.print("Inversion en place de L4 = ");
        L4.inverseRec();
        System.out.println(L4);

        int[] tab6 = {8, 8, 6};
        Liste L6 = new Liste(tab6);
        int[] tab7 = {1, 5, 8, 8, 4, 6, 8, 6, 4};
        Liste L7 = new Liste(tab7);

        System.out.println("L6 = " + L6 + " L7 = " + L7 + " Sous Liste ? "
                + L6.sousListe(L7));

        System.out.println("L6 = " + L6 + " L7 = " + L7 + " Sous Liste une boucle ? "
                + L6.sousListeUneBoucle(L7));

        //System.out.println("L6 = " + L6 + " L7 = " + L7 + " Sous Liste recursif ? "
        //		   + L6.sousListeRec(L7));

        int[] tab8 = {8, 8, 6};
        Liste L8 = new Liste(tab8);

        int[] tab9 = {1, 5, 8, 8, 4, 6, 8, 8, 6, 4};
        Liste L9 = new Liste(tab9);

        System.out.println("L8 = " + L8 + " L9 = " + L9 + " Sous Liste ? "
                + L8.sousListe(L9));

        System.out.println("L8 = " + L8 + " L9 = " + L9 + " Sous Liste une boucle ? "
                + L8.sousListeUneBoucle(L9));

        //System.out.println("L8 = " + L8 + " L9 = " + L9 + " Sous Liste recursif ? "
        //		   + L8.sousListeRec(L9));

        int[] tab10 = {10};
        Liste L10 = new Liste(tab10);
        L10.ajoutFinSiAbsent2(10);
        System.out.println("Ajout de 10 à (10) si 10 absent : L10 = " + L10);
        L10.ajoutFinSiAbsent2(11);
        System.out.println("Ajout de 11 à (10) si 11 absent : L10 = " + L10);
        */
    }
}