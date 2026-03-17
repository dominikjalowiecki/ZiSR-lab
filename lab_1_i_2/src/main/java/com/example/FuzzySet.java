package com.example;

public interface FuzzySet {

        String linguisticVariable = "Ciepło";

        double getMembership(double x);

        default String checkBelonging(double x, double threshold) {
            double membershipValue = getMembership(x);

            if (membershipValue > threshold) {
                return String.format("Wartość %.2f należy do zbioru %s z przynależnością %.2f", x, linguisticVariable, membershipValue);
            } else {
                return String.format("Wartość %.2f nie należy do zbioru %s z przynależnością %.2f", x, linguisticVariable, membershipValue);
            }
        }

}
