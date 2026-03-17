package com.example;

public class IrisClassifier {

    private String className;
    private FuzzySet sepalLengthFeature;
    private FuzzySet sepalWidthFeature;
    private FuzzySet petalLengthFeature;
    private FuzzySet petalWidthFeature;

    public String getClassName() {
        return className;
    }

    public IrisClassifier(String className, FuzzySet sepalLengthFeature, FuzzySet sepalWidthFeature, FuzzySet petalLengthFeature, FuzzySet petalWidthFeature) {
        this.className = className;
        this.sepalLengthFeature = sepalLengthFeature;
        this.sepalWidthFeature = sepalWidthFeature;
        this.petalLengthFeature = petalLengthFeature;
        this.petalWidthFeature = petalWidthFeature;
    }

    public double classify(Iris iris) {
        double sepalLengthMembership = sepalLengthFeature.getMembership(iris.getSepalLength());
        double sepalWidthMembership = sepalWidthFeature.getMembership(iris.getSepalWidth());
        double petalLengthMembership = petalLengthFeature.getMembership(iris.getPetalLength());
        double petalWidthMembership = petalWidthFeature.getMembership(iris.getPetalWidth());

        // średnia z członkostw
        double averageMembership = (sepalLengthMembership + sepalWidthMembership + petalLengthMembership + petalWidthMembership) / 4;

        return averageMembership;
    }

    public String getClassification(Iris iris) {
        double result = classify(iris);

        return String.format("Irys należy do zbioru %s z przynależnością %.2f", this.className, result);
    }

}
