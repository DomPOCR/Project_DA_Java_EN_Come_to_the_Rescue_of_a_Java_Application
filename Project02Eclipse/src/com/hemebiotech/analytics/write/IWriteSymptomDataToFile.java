package com.hemebiotech.analytics.write;

import java.util.List;
import java.util.Map;

public interface IWriteSymptomDataToFile {

	void putSymptoms(List<String> symptom, Map<String, Integer> symptomsCounter);

}