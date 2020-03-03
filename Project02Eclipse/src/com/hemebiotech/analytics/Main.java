package com.hemebiotech.analytics;

import com.hemebiotech.analytics.count.CountSymptom;
import com.hemebiotech.analytics.count.ICountSymptom;
import com.hemebiotech.analytics.read.ISymptomReader;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.sort.ISortSymptomByName;
import com.hemebiotech.analytics.sort.SortSymptomByName;
import com.hemebiotech.analytics.write.IWriteSymptomDataToFile;
import com.hemebiotech.analytics.write.WriteSymptomDataToFile;

public class Main {

	public static void main(String[] args) throws Exception {

		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ICountSymptom counter = new CountSymptom();
		ISortSymptomByName sorter = new SortSymptomByName();
		IWriteSymptomDataToFile writer = new WriteSymptomDataToFile("result.out");

		new AnalyticsCounter(reader, counter, sorter, writer).execute();
	}

}
