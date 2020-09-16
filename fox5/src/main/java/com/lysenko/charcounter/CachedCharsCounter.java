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

		cache.put(text, cache.getOrDefault(cache.get(text), charsCounter.countChar(text)));

		return cache.get(text);
	}
}
