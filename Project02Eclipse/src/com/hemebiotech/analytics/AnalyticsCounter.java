package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.count.ICountSymptom;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.sort.ISortSymptomByName;
import com.hemebiotech.analytics.write.IWriteSymptomDataToFile;

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ICountSymptom counter;
	private final ISortSymptomByName sorter;
	private final IWriteSymptomDataToFile writer;

	// On déclare une HashMap clé/valeur <> symptoms/occurences
	static Map<String, Integer> symptomsCounter = new HashMap<>();

	public AnalyticsCounter(ISymptomReader reader, ICountSymptom counter, ISortSymptomByName sorter,
			IWriteSymptomDataToFile writer) {

		this.reader = reader;
		this.counter = counter;
		this.sorter = sorter;
		this.writer = writer;
	}

	public void execute() throws Exception {
		/**
		 * 1ere étape: On lit le fichier symptoms.txt (package "Read")
		 *
		 */

		List<String> allSymptoms = reader.getSymptoms();

		/**
		 * 2eme étape: On parcours le fichier en comptant les symptoms avec la map
		 * (package "Count")
		 *
		 *
		 */

		Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

		/**
		 * 3eme étape: On range dans l'ordre alphabétique les symptoms (package "Sort")
		 * 
		 */

		List<String> sortList = sorter.Sort(symptomsCounter);

		/**
		 * 4eme étape: On écrit le fichier result.out (package "Write")
		 * 
		 */

		writer.putSymptoms(sortList, symptomsCounter);
	}
}
