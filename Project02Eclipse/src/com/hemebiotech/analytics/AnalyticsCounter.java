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

	// On d�clare une HashMap cl�/valeur <> symptoms/occurences
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
		 * 1ere �tape: On lit le fichier symptoms.txt (package "Read")
		 *
		 */

		List<String> allSymptoms = reader.getSymptoms();

		/**
		 * 2eme �tape: On parcours le fichier en comptant les symptoms avec la map
		 * (package "Count")
		 *
		 *
		 */

		Map<String, Integer> symptomsCounter = counter.count(allSymptoms);

		/**
		 * 3eme �tape: On range dans l'ordre alphab�tique les symptoms (package "Sort")
		 * 
		 */

		List<String> sortList = sorter.Sort(symptomsCounter);

		/**
		 * 4eme �tape: On �crit le fichier result.out (package "Write")
		 * 
		 */

		writer.putSymptoms(sortList, symptomsCounter);
	}
}
