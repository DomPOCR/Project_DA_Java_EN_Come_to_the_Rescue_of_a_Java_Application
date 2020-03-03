package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;

public class AnalyticsCounter {

	// On d�clare une HashMap cl�/valeur <> symptoms/occurences
	static Map<String, Integer> symptomsCounter = new HashMap<>();

	public static void main(String args[]) throws Exception {
		/**
		 * 1ere �tape: On lit le fichier symptoms.txt (package "Read")
		 *
		 */
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");

		List<String> allSymptoms = reader.GetSymptoms();

		/**
		 * 2eme �tape: On parcours le fichier en comptant les symptoms avec la map
		 * (package "Count")
		 *
		 *
		 */
		CountSymptom counter = new CountSymptom();

		Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

//4eme �tape: On range dans l'ordre alphab�tique les symtoms.
		List<String> symptoms = new ArrayList<>(symptomsCounter.keySet());
		Collections.sort(symptoms);

//5eme �tape: On �crit le fichier result.out
		FileWriter writer = new FileWriter("result.out");
		for (String symptom : symptoms) {
			writer.write(symptom + "=" + symptomsCounter.get(symptom) + "\n");
		}
		writer.close();
	}
}
