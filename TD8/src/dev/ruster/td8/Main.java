package dev.ruster.td8;

public class Main {

    public static void main(String[] args) {
        EE a = new EE(30, new int[] {2, 3, 8, 11});
        System.out.println("A = " + a);

        EE b = new EE(30, "12 14 8");
        System.out.println("B = " + b);

        System.out.println("A n B = " + a.intersect(b));
        System.out.println("B n A = " + b.intersect(a));
        System.out.println("A u B = " + a.union(b));
        System.out.println("B u A = " + b.union(a));
        System.out.println("A - B = " + a.minus(b));
        System.out.println("B - A = " + b.minus(a));
    }
}