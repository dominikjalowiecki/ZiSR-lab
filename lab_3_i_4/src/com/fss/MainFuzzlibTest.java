package com.fss;

import fuzzlib.FuzzySet;
import fuzzlib.creators.OperationCreator;
import fuzzlib.norms.*;

public class MainFuzzlibTest {

	public static void main(String[] args) {
		// Lab. 4
		FuzzySet fs = new FuzzySet();
		FuzzySet fs2 = new FuzzySet();
		FuzzySet fs3 = new FuzzySet();
		FuzzySet fs4 = new FuzzySet();

		fs.newTriangle(0.0, 1.0);
		fs2.newGaussian(0.0, 2.0);

		fs.fuzzyfy(-5.0);

		System.out.println(fs);
		System.out.println(fs2);

		Norm op = OperationCreator.newNorm(SNorm.SN_MAXIMUM);

		FuzzySet.processSetsWithNorm(fs4, fs, fs2, op);

		System.out.println(fs4);

		System.out.println(fs4.getMax_membership().y);

		fs4.PackFlatSections();

		System.out.println(fs4);

		// Virginica
		double sepalLength = 7.2;
		double sepalWidth = 3.0;
		double petalLength = 5.8;
		double petalWidth = 1.6;

		FuzzySet setosaSepalLength = new FuzzySet();
		setosaSepalLength.newTriangle(5.05, 2.1);
		FuzzySet setosaSepalWidth = new FuzzySet();
		setosaSepalWidth.newTriangle(3.35, 2.9);
		FuzzySet setosaPetalLength = new FuzzySet();
		setosaPetalLength.newTriangle(1.45, 1.3);
		FuzzySet setosaPetalWidth = new FuzzySet();
		setosaPetalWidth.newTriangle(0.35, 0.7);

		double setosaResult = (
					setosaSepalLength.getMembership(sepalLength) +
					setosaSepalWidth.getMembership(sepalWidth) +
					setosaPetalLength.getMembership(petalLength) +
					setosaPetalWidth.getMembership(petalWidth)
				) / 4;
		System.out.printf("\nSetosa classifier result: %f\n", setosaResult);

		FuzzySet versicolorSepalLength = new FuzzySet();
		versicolorSepalLength.newTriangle(5.95, 3.1);
		FuzzySet versicolorSepalWidth = new FuzzySet();
		versicolorSepalWidth.newTriangle(2.7, 2);
		FuzzySet versicolorPetalLength = new FuzzySet();
		versicolorPetalLength.newTriangle(4.05, 3.1);
		FuzzySet versicolorPetalWidth = new FuzzySet();
		versicolorPetalWidth.newTriangle(1.4, 1.2);

		double versicolorResult = (
				versicolorSepalLength.getMembership(sepalLength) +
				versicolorSepalWidth.getMembership(sepalWidth) +
				versicolorPetalLength.getMembership(petalLength) +
				versicolorPetalWidth.getMembership(petalWidth)
			) / 4;
		System.out.printf("Versicolor classifier result: %f\n", versicolorResult);

		FuzzySet virginicaSepalLength = new FuzzySet();
		virginicaSepalLength.newTriangle(6.4, 4.2);
		FuzzySet virginicaSepalWidth = new FuzzySet();
		virginicaSepalWidth.newTriangle(3.0, 2.2);
		FuzzySet virginicaPetalLength = new FuzzySet();
		virginicaPetalLength.newTriangle(5.7, 3.4);
		FuzzySet virginicaPetalWidth = new FuzzySet();
		virginicaPetalWidth.newTriangle(1.95, 1.7);

		double virginicaResult = (
				virginicaSepalLength.getMembership(sepalLength) +
				virginicaSepalWidth.getMembership(sepalWidth) +
				virginicaPetalLength.getMembership(petalLength) +
				virginicaPetalWidth.getMembership(petalWidth)
			) / 4;
		System.out.printf("Virginica classifier result: %f\n\n", virginicaResult);

		if (setosaResult >= versicolorResult && setosaResult >= virginicaResult) {
            System.out.println("Irys należy do zbioru Setosa");
        } else if (versicolorResult >= setosaResult && versicolorResult >= virginicaResult) {
            System.out.println("Irys należy do zbioru Versicolor");
        } else {
            System.out.println("Irys należy do zbioru Virginica");
        }
	}

}
