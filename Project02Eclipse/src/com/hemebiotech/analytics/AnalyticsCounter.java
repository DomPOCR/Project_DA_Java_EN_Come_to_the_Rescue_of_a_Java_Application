package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.SortSymptomByName;

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

		/**
		 * 3eme �tape: On range dans l'ordre alphab�tique les symptoms (package "Sort")
		 * 
		 */
		SortSymptomByName sorter = new SortSymptomByName();

		List<String> sortList = sorter.Sort(symptomsCounter);

//5eme �tape: On �crit le fichier result.out
		FileWriter writer = new FileWriter("result.out");
		for (String symptom : sortList) {
			writer.write(symptom + "=" + symptomsCounter.get(symptom) + "\n");
		}
		writer.close();
	}
}
