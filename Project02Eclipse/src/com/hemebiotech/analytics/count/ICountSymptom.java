package com.hemebiotech.analytics.count;

import java.util.List;
import java.util.Map;

public interface ICountSymptom {

	/**
	 * 
	 * @param allSymptoms : Liste des symptomes
	 * @return : le compteur par symptome
	 */
	Map<String, Integer> count(List<String> allSymptoms);

}