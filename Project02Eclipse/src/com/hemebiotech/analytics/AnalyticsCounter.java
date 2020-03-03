package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.count.ICountSymptom;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.ISortSymptomByName;
import com.hemebiotech.analytics.sort.SortSymptomByName;
import com.hemebiotech.analytics.write.IWriteSymptomDataToFile;
import com.hemebiotech.analytics.write.WriteSymptomDataToFile;

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
		ICountSymptom counter = new CountSymptom();

		Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

		/**
		 * 3eme �tape: On range dans l'ordre alphab�tique les symptoms (package "Sort")
		 * 
		 */
		ISortSymptomByName sorter = new SortSymptomByName();

		List<String> sortList = sorter.Sort(symptomsCounter);

		/**
		 * 4eme �tape: On �crit le fichier result.out (package "Write")
		 * 
		 */
		IWriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out", sortList, symptomsCounter);

		writer.putSymptoms(sortList, symptomsCounter);
	}
}
