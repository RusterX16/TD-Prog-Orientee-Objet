package dev.ruster.td6;

public final class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Date d1 = new Date("31/12/2007");
        Date d2 = new Date("29/02/2008");
        System.out.println(d2.daysBetween(d1));
    }
}