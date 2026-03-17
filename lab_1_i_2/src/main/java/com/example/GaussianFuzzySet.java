package com.example;

public class GaussianFuzzySet implements FuzzySet {

    private double mean;
    private double sigma;

    public GaussianFuzzySet(double mean, double sigma) {
        if (sigma <= 0) {
            throw new IllegalArgumentException("Sigma musi być liczbą dodatnią");
        }

        this.mean = mean;
        this.sigma = sigma;
    }

    @Override
    public double getMembership(double x) {
        return Math.exp(-Math.pow(x - mean, 2) / (2 * Math.pow(sigma, 2)));
    }

}
