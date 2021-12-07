package dev.ruster.td6;

public final class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Fraction f = new Fraction("3/4");
        f.pow(3).display();
    }
}