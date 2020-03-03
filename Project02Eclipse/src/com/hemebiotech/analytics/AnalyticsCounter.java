package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
//1ere �tape: On d�clare une HashMap cl�/valeur <> symptoms/occurences
	static Map<String, Integer> symptomsCounter = new HashMap<>();

	public static void main(String args[]) throws Exception {
//2eme �tape: On lit le fichier symptoms.txt
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();

//3eme �tape: On parcours le fichier en comptant les symptoms avec la map.
		while (line != null) {
			if (symptomsCounter.containsKey(line)) {
				symptomsCounter.put(line, symptomsCounter.get(line) + 1);
			} else {
				symptomsCounter.put(line, 1);
			}
			line = reader.readLine();
		}
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
