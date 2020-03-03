package com.hemebiotech.analytics.write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Dominique Pokrzywa
 *
 */
public class WriteSymptomDataToFile implements IWriteSymptomDataToFile {

	private String filePath;

	/**
	 * 
	 * @param filePath : Nom du fichier résultat
	 * @param List     : liste des symptomes triés
	 * @param Counter  : : compteur des symptomes
	 */
	public WriteSymptomDataToFile(String filePath, List<String> List, Map<String, Integer> Counter) {

		this.filePath = filePath;
	}

	@Override
	public void putSymptoms(List<String> symptom, Map<String, Integer> symptomsCounter) {

		int nbEnr = 0;

		try {
			FileWriter writer = new FileWriter(filePath);

			for (String element : symptom) {

				writer.write(element + " = " + symptomsCounter.get(element) + "\n");
				nbEnr++;
			}

			writer.close();
			System.out.println("Write : " + nbEnr + " enregistrements écrits dans le fichier en sortie : " + filePath);

		} catch (IOException e) {
			System.out.println("Erreur d'écriture pour le fichier : " + filePath);
		}

	}

}
