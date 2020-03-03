package com.hemebiotech.analytics.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Dominique Pokrzywa
 *
 */
public class SortSymptomByName implements ISortSymptomByName {

	@Override
	public List<String> Sort(Map<String, Integer> allSymptoms) {

		List<String> result = new ArrayList<String>(allSymptoms.keySet());

		Collections.sort(result);

		System.out.println("Sort : Le tableau trié est le suivant : " + result);

		return result;

	}

}
