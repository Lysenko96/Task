package com.lysenko.charcounter;

import java.util.HashMap;
import java.util.Map;

public class CachedCharsCounter implements CharsCounter {

	private CharsCounter charsCounter;
	private Map<String, Map<Character, Long>> cache = new HashMap<>();

	public CachedCharsCounter(CharsCounter charsCounter) {
		this.charsCounter = charsCounter;
	}

	@Override
	public Map<Character, Long> countChars(String text) {
		return cache.computeIfAbsent(text, key -> charsCounter.countChars(text));
	}
}
