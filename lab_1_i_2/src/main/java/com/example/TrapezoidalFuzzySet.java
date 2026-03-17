package com.example;

public class TrapezoidalFuzzySet implements FuzzySet {

    private double a; // lewa podstawa
    private double b; // lewy szczyt
    private double c; // prawy szczyt
    private double d; // prawa podstawa

    public TrapezoidalFuzzySet(double a, double b, double c, double d) {
        if (a > b || b > c || c > d) {
            throw new IllegalArgumentException("Parametry muszą spełniać a <= b <= c <= d");
        }

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getMembership(double x) {
        if (x < a || x > d) {
            return 0.0;
        } else if (x >= b && x <= c) {
            return 1.0;
        } else if (x >= a && x < b) {
            return (x - a) / (b - a);
        } else { // x > c && x <= d
            return (d - x) / (d - c);
        }
    }

}
