package com.fss;

import fuzzlib.DefuzMethod;
import fuzzlib.FuzzySet;
import fuzzlib.norms.SNorm;
import fuzzlib.norms.TNorm;
import fuzzlib.reasoning.ReasoningSystem;
import fuzzlib.reasoning.SystemConfig;

public class MainControlReasoningSystemTest {
	private static final double OUTPUT_MIN = 0.0;
	private static final double OUTPUT_MAX = 10.0;

	public static void main(String[] args) {
		double temp = 4.5; // 0.0 - 10.0
		double hum = 7.25; // 0.0 - 10.0
		
		FuzzySet lowTemp = new FuzzySet("lowTemp", "");
		FuzzySet midTemp = new FuzzySet("midTemp", "");
		FuzzySet highTemp = new FuzzySet("highTemp", "");
		
		lowTemp.newTriangle(0.0, 5.0);
		midTemp.newTriangle(7.0, 3.5);
		highTemp.newTriangle(10.0, 4.0);
		
		FuzzySet lowHum = new FuzzySet("lowHum", "");
		FuzzySet midHum = new FuzzySet("midHum", "");
		FuzzySet highHum = new FuzzySet("highHum", "");
		
		lowHum.newTriangle(0, 1.5);
		midHum.newTriangle(4.0, 3.0);
		highHum.newTriangle(10.0, 7.0);
		
		System.out.println("Temperature:");
		System.out.println("LowTemp: " + lowTemp);
		System.out.println("MidTemp: " + midTemp);
		System.out.println("HighTemp: " + highTemp);
		
		System.out.println("\nHumidity:");
		System.out.println("LowHum: " + lowHum);
		System.out.println("MidHum: " + midHum);
		System.out.println("HighHum: " + highHum);
		
		FuzzySet lowSpeed = new FuzzySet("lowSpeed", "");
		FuzzySet midSpeed = new FuzzySet("midSpeed", "");
		FuzzySet highSpeed = new FuzzySet("highSpeed", "");
		
		lowSpeed.newTriangle(0.0, 3.0);
		midSpeed.newTriangle(5.0, 2.75);
		highSpeed.newTriangle(10.0, 3.0);
		
		FuzzySet lowHeater = new FuzzySet("lowHeater", "");
		FuzzySet midHeater = new FuzzySet("midHeater", "");
		FuzzySet highHeater = new FuzzySet("highHeater", "");
		
		lowHeater.newTriangle(0.0, 2.5);
		midHeater.newTriangle(5.5, 3.75);
		highHeater.newTriangle(10.0, 4.25);
		
		System.out.println("\nSpeed Conclusion:");
		System.out.println("LowSpeed: " + lowSpeed);
		System.out.println("MidSpeed: " + midSpeed);
		System.out.println("HighSpeed: " + highSpeed);
		
		System.out.println("\nHeater Conclusion:");
		System.out.println("LowHeater: " + lowHeater);
		System.out.println("MidHeater: " + midHeater);
		System.out.println("HighHeater: " + highHeater);
		
		SystemConfig speedConfig = new SystemConfig();
		speedConfig.setInputWidth(2);
		speedConfig.setOutputWidth(1);
		speedConfig.setNumberOfPremiseSets(6);
		speedConfig.setNumberOfConclusionSets(3);
		speedConfig.setIsOperationType(TNorm.TN_PRODUCT);
		speedConfig.setAndOperationType(TNorm.TN_MINIMUM);
		speedConfig.setOrOperationType(SNorm.SN_MAXIMUM); // SN_PROBABSUM
		speedConfig.setImplicationType(TNorm.TN_PRODUCT); // TN_MINIMUM
		speedConfig.setConclusionAgregationType(SNorm.SN_MAXIMUM); // SN_PROBABSUM
		speedConfig.setAutoDefuzzyfication(false);
		speedConfig.setDefuzzyfication(DefuzMethod.DF_COG);		
		
		ReasoningSystem rsSpeed = new ReasoningSystem(speedConfig);
		rsSpeed.getInputVar(0).id = "temperature";
		rsSpeed.getInputVar(1).id = "humidity";
		rsSpeed.getOutputVar(0).id = "fanSpeed";
		
		rsSpeed.addPremiseSet(lowTemp);
		rsSpeed.addPremiseSet(midTemp);
		rsSpeed.addPremiseSet(highTemp);
		rsSpeed.addPremiseSet(lowHum);
		rsSpeed.addPremiseSet(midHum);
		rsSpeed.addPremiseSet(highHum);
		
		rsSpeed.addConclusionSet(lowSpeed);
		rsSpeed.addConclusionSet(midSpeed);
		rsSpeed.addConclusionSet(highSpeed);
		
		try {
			rsSpeed.addRule(1, 1);
			rsSpeed.addRuleItem("temperature", "lowTemp", "AND", "humidity", "lowHum");
			rsSpeed.addRuleConclusion("fanSpeed", "lowSpeed");
			
			rsSpeed.addRule(1, 1);
			rsSpeed.addRuleItem("temperature", "midTemp", "AND", "humidity", "midHum");
			rsSpeed.addRuleConclusion("fanSpeed", "midSpeed");
			
			rsSpeed.addRule(1, 1);
			rsSpeed.addRuleItem("temperature", "highTemp", "AND", "humidity", "highHum");
			rsSpeed.addRuleConclusion("fanSpeed", "highSpeed");
			
			rsSpeed.addRule(1, 1);
			rsSpeed.addRuleItem("temperature", "highTemp", "AND", "humidity", "midHum");
			rsSpeed.addRuleConclusion("fanSpeed", "highSpeed");
			
			rsSpeed.addRule(1, 1);
			rsSpeed.addRuleItem("temperature", "midTemp", "AND", "humidity", "lowHum");
			rsSpeed.addRuleConclusion("fanSpeed", "midSpeed");
		} catch (Exception e) {
			System.out.println("Error adding speed rules: " + e.getMessage());
		}
		
		SystemConfig heaterConfig = new SystemConfig();
		heaterConfig.setInputWidth(2);
		heaterConfig.setOutputWidth(1);
		heaterConfig.setNumberOfPremiseSets(6);
		heaterConfig.setNumberOfConclusionSets(3);
		heaterConfig.setIsOperationType(TNorm.TN_PRODUCT);
		heaterConfig.setAndOperationType(TNorm.TN_MINIMUM);
		heaterConfig.setOrOperationType(SNorm.SN_MAXIMUM); // SN_PROBABSUM
		heaterConfig.setImplicationType(TNorm.TN_PRODUCT); // TN_MINIMUM
		heaterConfig.setConclusionAgregationType(SNorm.SN_MAXIMUM); // SN_PROBABSUM
		heaterConfig.setAutoDefuzzyfication(false);
		heaterConfig.setDefuzzyfication(DefuzMethod.DF_COG);
		
		ReasoningSystem rsHeater = new ReasoningSystem(heaterConfig);
		rsHeater.getInputVar(0).id = "temperature";
		rsHeater.getInputVar(1).id = "humidity";
		rsHeater.getOutputVar(0).id = "heaterLevel";
		
		rsHeater.addPremiseSet(lowTemp);
		rsHeater.addPremiseSet(midTemp);
		rsHeater.addPremiseSet(highTemp);
		rsHeater.addPremiseSet(lowHum);
		rsHeater.addPremiseSet(midHum);
		rsHeater.addPremiseSet(highHum);
		
		rsHeater.addConclusionSet(lowHeater);
		rsHeater.addConclusionSet(midHeater);
		rsHeater.addConclusionSet(highHeater);
		
		try {
			rsHeater.addRule(1, 1);
			rsHeater.addRuleItem("temperature", "lowTemp", "AND", "humidity", "midHum");
			rsHeater.addRuleConclusion("heaterLevel", "highHeater");
			
			rsHeater.addRule(1, 1);
			rsHeater.addRuleItem("temperature", "midTemp", "AND", "humidity", "midHum");
			rsHeater.addRuleConclusion("heaterLevel", "midHeater");
			
			rsHeater.addRule(1, 1);
			rsHeater.addRuleItem("temperature", "highTemp", "AND", "humidity", "midHum");
			rsHeater.addRuleConclusion("heaterLevel", "lowHeater");
		} catch (Exception e) {
			System.out.println("Error adding heater rules: " + e.getMessage());
		}
		
		System.out.println("\ntemp = " + temp + ", humidity = " + hum + "\n");
		
		rsSpeed.setInput(0, temp);
		rsSpeed.setInput(1, hum);
		rsSpeed.Process();
		
		rsHeater.setInput(0, temp);
		rsHeater.setInput(1, hum);
		rsHeater.Process();
		
		FuzzySet resSpeed = rsSpeed.getOutputVar(0).outset;
		FuzzySet resHeater = rsHeater.getOutputVar(0).outset;
		
		System.out.println("Speed Control Result");
		System.out.println("resSpeedPackFlat: " + resSpeed);
		
		double speedPeakRaw = resSpeed.getMax_membership().x;
		double speedRaw = resSpeed.DeFuzzyfy();
		double speedPeakPercent = toPercent(speedPeakRaw, OUTPUT_MIN, OUTPUT_MAX);
		double speedPercent = toPercent(speedRaw, OUTPUT_MIN, OUTPUT_MAX);
		System.out.println("resSpeedRaw: " + speedPeakRaw);
		System.out.println("resSpeedPeakUsagePercent: " + speedPeakPercent + "%");
		System.out.println("resSpeedDeFuzzyfyRaw: " + speedRaw);
		System.out.println("resSpeedUsagePercent: " + speedPercent + "%");
		
		System.out.println("\nHeater Control Result");
		System.out.println("resHeaterPackFlat: " + resHeater);
		
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
