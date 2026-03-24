package com.fss;

import fuzzlib.DefuzMethod;
import fuzzlib.FuzzySet;
import fuzzlib.creators.OperationCreator;
import fuzzlib.norms.*;

public class MainControl {
	private static final double OUTPUT_MIN = 0.0;
	private static final double OUTPUT_MAX = 10.0;

	public static void main(String[] args) {
		// Lab. 5
//		FuzzySet f = new FuzzySet();
//		FuzzySet g = new FuzzySet();
//		FuzzySet h = new FuzzySet();
//		f.AddPoint(0, 0);
//		f.AddPoint(2, 1);
//		f.AddPoint(2.001, 0);
//		f.AddPoint(3, 0);
//		f.newGaussian(4, 0.5);
//		g.newGaussian(6, 0.5);
		
//		TNorm t = OperationCreator.newTNorm(TNorm.TN_PRODUCT);
//		FuzzySet.processSetsWithNorm(h, f, g, t);
//		System.out.println("Zbiór f:" + f);
//		System.out.println("Zbiór g:" + g);
//		System.out.println("f *T g:" + h);
//		System.out.println("Wyostrzenie h:" + h.DeFuzzyfy());
//		h.PackFlatSections();
//		System.out.println("f *T g:" + h);
//		System.out.println("Wyostrzenie h:" + h.DeFuzzyfy());
		
		// Sterowanie klimatyzatorem
		FuzzySet lowTemp = new FuzzySet();
		FuzzySet midTemp = new FuzzySet();
		FuzzySet highTemp = new FuzzySet();
		
		FuzzySet lowHum = new FuzzySet();
		FuzzySet midHum = new FuzzySet();
		FuzzySet highHum = new FuzzySet();
		
		FuzzySet lowSpeed = new FuzzySet();
		FuzzySet midSpeed = new FuzzySet();
		FuzzySet highSpeed = new FuzzySet();
		
		FuzzySet lowHeater = new FuzzySet();
		FuzzySet midHeater = new FuzzySet();
		FuzzySet highHeater = new FuzzySet();
		
		lowTemp.newTriangle(0.0, 5.0);
		midTemp.newTriangle(7.0, 3.5);
		highTemp.newTriangle(10.0, 4.0);
		
//		lowTemp.fuzzyfy(1.5);
		
		lowHum.newTriangle(0, 1.5);
		midHum.newTriangle(4.0, 3.0);
		highHum.newTriangle(10.0, 7.0);
		
		lowSpeed.newTriangle(0.0, 3.0);
		midSpeed.newTriangle(5.0, 2.75);
		highSpeed.newTriangle(10.0, 3.0);
		
		lowHeater.newTriangle(0.0, 2.5);
		midHeater.newTriangle(5.5, 3.75);
		highHeater.newTriangle(10.0, 4.25);
		
		System.out.println("LowTemp: " + lowTemp);
		System.out.println("MidTemp: " + midTemp);
		System.out.println("HighTemp: " + highTemp);
		
		System.out.println();
		System.out.println("LowHum: " + lowHum);
		System.out.println("MidHum: " + midHum);
		System.out.println("HighHum: " + highHum);
		
		System.out.println();
		System.out.println("LowSpeed: " + lowSpeed);
		System.out.println("MidSpeed: " + midSpeed);
		System.out.println("HighSpeed: " + highSpeed);

		System.out.println();
		System.out.println("LowHeater: " + lowHeater);
		System.out.println("MidHeater: " + midHeater);
		System.out.println("HighHeater: " + highHeater);
		
		double temp = 4.5; // 0.0 - 10.0
		double hum = 7.25; // 0.0 - 10.0
		
		double lowTempRes = lowTemp.getMembership(temp);
		double midTempRes = midTemp.getMembership(temp);
		double highTempRes = highTemp.getMembership(temp);
		
		double lowHumRes = lowHum.getMembership(hum);
		double midHumRes = midHum.getMembership(hum);
		double highHumRes = highHum.getMembership(hum);
		
//		FuzzySet lowJedi = new FuzzySet();
//		FuzzySet midJedi = new FuzzySet();
//		FuzzySet highJedi = new FuzzySet();
		
//		lowJedi.addPoint(0.0, lowTempRes);
//		midJedi.addPoint(0.0, midTempRes);
//		highJedi.addPoint(0.0, highTempRes);
		
		System.out.println();
		System.out.println("lowTempRes: " + lowTempRes);
		System.out.println("midTempRes: " + midTempRes);
		System.out.println("highTempRes: " + highTempRes);
		
		System.out.println();
		System.out.println("lowHumRes: " + lowHumRes);
		System.out.println("midHumRes: " + midHumRes);
		System.out.println("highHumRes: " + highHumRes);
		
//		TNorm jediNorm = OperationCreator.newTNorm(TNorm.TN_MINIMUM);
		TNorm jediNorm = OperationCreator.newTNorm(TNorm.TN_PRODUCT);
		
//		FuzzySet.processSetsWithNorm(lowSpeed, lowSpeed, lowJedi, jediNorm);
//		FuzzySet.processSetsWithNorm(midSpeed, midSpeed, midJedi, jediNorm);
//		FuzzySet.processSetsWithNorm(highSpeed, highSpeed, highJedi, jediNorm);
		
		lowSpeed.processSetAndMembershipWithNorm(lowTempRes, jediNorm);
		lowSpeed.processSetAndMembershipWithNorm(lowHumRes, jediNorm);
		midSpeed.processSetAndMembershipWithNorm(midTempRes, jediNorm);
		midSpeed.processSetAndMembershipWithNorm(midHumRes, jediNorm);
		highSpeed.processSetAndMembershipWithNorm(highTempRes, jediNorm);
		highSpeed.processSetAndMembershipWithNorm(highHumRes, jediNorm);
		
		lowHeater.processSetAndMembershipWithNorm(lowTempRes, jediNorm);
		lowHeater.processSetAndMembershipWithNorm(lowHumRes, jediNorm);
		midHeater.processSetAndMembershipWithNorm(midTempRes, jediNorm);
		midHeater.processSetAndMembershipWithNorm(midHumRes, jediNorm);
		highHeater.processSetAndMembershipWithNorm(highTempRes, jediNorm);
		highHeater.processSetAndMembershipWithNorm(highHumRes, jediNorm);
		
//		System.out.println();
//		System.out.println("lowSpeedJedi: " + lowSpeed);
//		System.out.println("midSpeedJedi: " + midSpeed);
//		System.out.println("highSpeedJedi: " + highSpeed);
		
		lowSpeed.PackFlatSections();
		midSpeed.PackFlatSections();
		highSpeed.PackFlatSections();
		
		lowHeater.PackFlatSections();
		midHeater.PackFlatSections();
		highHeater.PackFlatSections();
		
		System.out.println();
		System.out.println("lowSpeedJediPackFlat: " + lowSpeed);
		System.out.println("midSpeedJediPackFlat: " + midSpeed);
		System.out.println("highSpeedJediPackFlat: " + highSpeed);
		
		System.out.println();
		System.out.println("lowHeaterJediPackFlat: " + lowHeater);
		System.out.println("midHeaterJediPackFlat: " + midHeater);
		System.out.println("highHeaterJediPackFlat: " + highHeater);
		
		SNorm maxNorm = OperationCreator.newSNorm(SNorm.SN_MAXIMUM);
		
		FuzzySet tmp1Speed = new FuzzySet();
		FuzzySet resSpeed = new FuzzySet();
		
		FuzzySet tmp1Heater = new FuzzySet();
		FuzzySet resHeater = new FuzzySet();
		
		FuzzySet.processSetsWithNorm(tmp1Speed, lowSpeed, midSpeed, maxNorm);
		FuzzySet.processSetsWithNorm(resSpeed, tmp1Speed, highSpeed, maxNorm);
		
		FuzzySet.processSetsWithNorm(tmp1Heater, lowHeater, midHeater, maxNorm);
		FuzzySet.processSetsWithNorm(resHeater, tmp1Heater, highHeater, maxNorm);
		
//		System.out.println();
//		System.out.println("resSpeed: " + resSpeed);

//		System.out.println();
//		System.out.println("resHeater: " + resHeater);
		
		resSpeed.PackFlatSections();
		
		resHeater.PackFlatSections();
		
		System.out.println();
		System.out.println("resSpeedPackFlat: " + resSpeed);
		
		System.out.println();
		System.out.println("resHeaterPackFlat: " + resHeater);
		
//		resSpeed.DeFuzzConf(DefuzMethod.DF_COG, 0.2);
		
		System.out.println();
		double speedPeakRaw = resSpeed.getMax_membership().x;
		double speedRaw = resSpeed.DeFuzzyfy();
		double speedPeakPercent = toPercent(speedPeakRaw, OUTPUT_MIN, OUTPUT_MAX);
		double speedPercent = toPercent(speedRaw, OUTPUT_MIN, OUTPUT_MAX);
		System.out.println("resSpeedRaw: " + speedPeakRaw);
		System.out.println("resSpeedPeakUsagePercent: " + speedPeakPercent + "%");
		System.out.println("resSpeedDeFuzzyfyRaw: " + speedRaw);
		System.out.println("resSpeedUsagePercent: " + speedPercent + "%");
		
		System.out.println();
		double heaterPeakRaw = resHeater.getMax_membership().x;
		double heaterRaw = resHeater.DeFuzzyfy();
		double heaterPeakPercent = toPercent(heaterPeakRaw, OUTPUT_MIN, OUTPUT_MAX);
		double heaterPercent = toPercent(heaterRaw, OUTPUT_MIN, OUTPUT_MAX);
		System.out.println("resHeaterRaw: " + heaterPeakRaw);
		System.out.println("resHeaterPeakUsagePercent: " + heaterPeakPercent + "%");
		System.out.println("resHeaterDeFuzzyfyRaw: " + heaterRaw);
		System.out.println("resHeaterUsagePercent: " + heaterPercent + "%");
	}

	private static double toPercent(double value, double min, double max) {
		if (max <= min) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		double normalized = (value - min) / (max - min);
		double clamped = Math.max(0.0, Math.min(1.0, normalized));
		return clamped * 100.0;
	}

}
