package dev.ruster.td6;

import org.jetbrains.annotations.NotNull;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if(denominator == 0) {
            throw new ArithmeticException("Division par zéro interdite !");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(@NotNull String fraction) {
        if(!fraction.contains("/") || Util.hasDuplicate(fraction, '/')) {
            throw new IllegalArgumentException("Mauvaise écriture, veuillez recommencer");
        }
        String[] content = fraction.split("/");
        this.numerator = Integer.parseInt(content[0].trim());
        this.denominator = Integer.parseInt(content[1].trim());
    }

    public Fraction(@NotNull Fraction fraction) {
        this(fraction.numerator, fraction.denominator);
    }

    public double calculate() {
        return numerator / (double) denominator;
    }

    public Fraction reducePermanent() {
        int hcf = Util.hcf(numerator, denominator);

        setNumerator(numerator / hcf);
        setDenominator(denominator / hcf);
        return this;
    }

    public Fraction reduce() {
        return new Fraction(this).reducePermanent();
    }

    public Fraction multiply(@NotNull Fraction fraction) {
        return new Fraction(numerator * fraction.numerator, denominator * fraction.denominator);
    }

    public Fraction divide(@NotNull Fraction fraction) {
        return new Fraction(numerator * fraction.denominator, denominator * fraction.numerator);
    }

    public Fraction add(@NotNull Fraction fraction) {
        int lcm = Util.lcm(denominator, fraction.denominator);
        return new Fraction(numerator * (lcm / denominator) + fraction.numerator * (lcm / fraction.denominator), lcm);
    }

    public Fraction subtract(@NotNull Fraction fraction) {
        int lcm = Util.lcm(denominator, fraction.denominator);
        return new Fraction(numerator * (lcm / denominator) - fraction.numerator * (lcm / fraction.denominator), lcm);
    }

    public Fraction pow(int n) {
        return new Fraction((int) Math.pow(numerator, n), (int) Math.pow(denominator, n));
    }

    public void display() {
        System.out.println(numerator + " / " + denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}