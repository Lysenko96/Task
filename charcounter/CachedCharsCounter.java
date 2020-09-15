package com.lysenko.charcounter;

import java.util.HashMap;
import java.util.Map;

public class CachedCharsCounter implements CharsCounter {

	private CharsCounter charsCounter;
	private Map<String, Map<Character, Integer>> cache = new HashMap<>();

	public CachedCharsCounter(CharsCounter charsCounter) {
		this.charsCounter = charsCounter;
	}

	@Override
	public Map<Character, Integer> countChar(String text) {

		// Map<Character, Integer> valuesCache = cache.get(text);

		cache.putIfAbsent(text, charsCounter.countChar(text));

//		if (valuesCache == null) {
//			valuesCache = charsCounter.countChar(text);
//			cache.put(text, valuesCache);
//		}
		System.out.println(cache);
		return cache.get(text);
	}
}
