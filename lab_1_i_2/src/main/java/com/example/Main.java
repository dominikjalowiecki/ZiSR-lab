package com.example;

public class Main {

    public static void main(String[] args) {
        // Lab. 1
//        FuzzySet triangularFuzzySet = new TriangularFuzzySet(0, 5, 10);
//        FuzzySet gaussianFuzzySet = new GaussianFuzzySet(5, 2);
//        FuzzySet trapezoidalFuzzySet = new TrapezoidalFuzzySet(0, 3, 7, 10);
//
//        System.out.printf("Triangular Fuzzy Set: %f", triangularFuzzySet.getMembership(7));
//        System.out.println();
//        System.out.printf("Gaussian Fuzzy Set: %f", gaussianFuzzySet.getMembership(5));
//        System.out.println();
//        System.out.printf("Trapezoidal Fuzzy Set: %f", trapezoidalFuzzySet.getMembership(6));
//        System.out.println('\n');
//
//        System.out.println(triangularFuzzySet.checkBelonging(6, 0.5));
//        System.out.println(gaussianFuzzySet.checkBelonging(2.3, 0.5));
//        System.out.println(trapezoidalFuzzySet.checkBelonging(3, 0.5));

        // Lab. 2
        IrisClassifier setosaClassifier = new IrisClassifier(
                "Iris-setosa",
                new TriangularFuzzySet(4, 5.05, 6.1),
                new TriangularFuzzySet(1.9, 3.35, 4.8),
                new TriangularFuzzySet(0.8, 1.45, 2.1),
                new TriangularFuzzySet(0, 0.35, 0.7)
        );

        IrisClassifier versicolorClassifier = new IrisClassifier(
                "Iris-versicolor",
                new TriangularFuzzySet(4.4, 5.95, 7.5),
                new TriangularFuzzySet(1.7, 2.7, 3.7),
                new TriangularFuzzySet(2.5, 4.05, 5.6),
                new TriangularFuzzySet(0.8, 1.4, 2)
        );

        IrisClassifier virginicaClassifier = new IrisClassifier(
                "Iris-virginica",
                new TriangularFuzzySet(4.3, 6.4,8.5),
                new TriangularFuzzySet(1.9, 3.0, 4.1),
                new TriangularFuzzySet(4, 5.7, 7.4),
                new TriangularFuzzySet(1.1, 1.95, 2.8)
        );

//        Iris irisSetosa = new Iris("Iris-setosa", 4.7, 3.2, 1.6, 0.2);
//        Iris irisVersicolor = new Iris("Iris-versicolor", 5.7, 2.6, 3.5, 1);
//        Iris irisVirginica = new Iris("Iris-virginica", 7.2, 3, 5.8, 1.6);
//
//        double setosaResult = setosaClassifier.classify(irisVirginica);
//        double versicolorResult = versicolorClassifier.classify(irisVirginica);
//        double virginicaResult = virginicaClassifier.classify(irisVirginica);
//
//        System.out.println(setosaResult);
//        System.out.println(versicolorResult);
//        System.out.println(virginicaResult);
//
//        System.out.println(setosaClassifier.getClassification(irisVirginica));
//        System.out.println(versicolorClassifier.getClassification(irisVirginica));
//        System.out.println(virginicaClassifier.getClassification(irisVirginica));

//        Iris iris = new Iris("Iris-setosa", 4.7, 3.2, 1.6, 0.2);
//        Iris iris = new Iris("Iris-versicolor", 5.7, 2.6, 3.5, 1);
        Iris iris = new Iris("Iris-virginica", 7.2, 3, 5.8, 1.6);

        double setosaResult = setosaClassifier.classify(iris);
        double versicolorResult = versicolorClassifier.classify(iris);
        double virginicaResult = virginicaClassifier.classify(iris);

        if (setosaResult >= versicolorResult && setosaResult >= virginicaResult) {
            System.out.println(setosaClassifier.getClassification(iris));
        } else if (versicolorResult >= setosaResult && versicolorResult >= virginicaResult) {
            System.out.println(versicolorClassifier.getClassification(iris));
        } else {
            System.out.println(virginicaClassifier.getClassification(iris));
        }
    }

}