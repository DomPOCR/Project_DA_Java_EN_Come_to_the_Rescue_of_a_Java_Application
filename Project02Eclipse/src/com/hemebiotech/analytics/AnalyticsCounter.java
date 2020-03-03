package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;

public class AnalyticsCounter {
//1ere étape: On déclare une HashMap clé/valeur <> symptoms/occurences
	static Map<String, Integer> symptomsCounter = new HashMap<>();

	public static void main(String args[]) throws Exception {
//2eme étape: On lit le fichier symptoms.txt

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");

		List<String> allSymptoms = reader.GetSymptoms();

//3eme étape: On parcours le fichier en comptant les symptoms avec la map.
		for (String symptom : allSymptoms) {
			if (symptomsCounter.containsKey(symptom)) {
				symptomsCounter.put(symptom, symptomsCounter.get(symptom) + 1);
			} else {
				symptomsCounter.put(symptom, 1);
			}
		}

//4eme étape: On range dans l'ordre alphabétique les symtoms.
		List<String> symptoms = new ArrayList<>(symptomsCounter.keySet());
		Collections.sort(symptoms);

//5eme étape: On écrit le fichier result.out
		FileWriter writer = new FileWriter("result.out");
		for (String symptom : symptoms) {
			writer.write(symptom + "=" + symptomsCounter.get(symptom) + "\n");
		}
		writer.close();
	}
}
