package com.example;

public class TriangularFuzzySet implements FuzzySet {

    private double a; // lewa podstawa
    private double b; // szczyt
    private double c; // prawa podstawa

    public TriangularFuzzySet(double a, double b, double c) {
        if (a > b || b > c) {
            throw new IllegalArgumentException("Parametry muszą spełniać a <= b <= c");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getMembership(double x) {
        if (x < a || x > c) {
            return 0.0;
        } else if (x == b) {
            return 1.0;
        } else if (x < b) {
            return (x - a) / (b - a);
        } else { // x > b
            return (c - x) / (c - b);
        }
    }

}
