package com.hemebiotech.analytics.count;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Dominique Pokrzywa
 *
 */
public class CountSymptom {
	/**
	 * 
	 * @param allSymptoms : Liste des symptomes
	 * @return : le compteur par symptome
	 */
	public Map<String, Integer> count(List<String> allSymptoms) {

		Map<String, Integer> symptomsCounter = new HashMap<String, Integer>();

		for (String symptom : allSymptoms) {
			if (symptomsCounter.containsKey(symptom)) {
				symptomsCounter.put(symptom, symptomsCounter.get(symptom) + 1);
			} else {
				symptomsCounter.put(symptom, 1);
			}
		}
		System.out.println("Count : " + symptomsCounter.size() + " enregistrements. ");
		return symptomsCounter;
	}

}
