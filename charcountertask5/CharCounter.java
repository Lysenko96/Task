package com.lysenko.charcountertask5;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CharCounter {

	public Map<Character, Integer> countCharsAndFreq(String text) {

		char[] charsOfText = text.toLowerCase().toCharArray();
		LRUCache lruCache = new LRUCache(charsOfText.length);
		List<Character> listChars = new LinkedList<>();
		for (char chars : charsOfText) {
			listChars.add(chars);
		}
		int indexChar = 0;

		Map<Character, Integer> mapCharAndCounter = new LinkedHashMap<>();

		while (indexChar < listChars.size()) {
			lruCache.putEntry(listChars.get(indexChar), countFreqChars(listChars, indexChar));
			indexChar++;
		}

		indexChar = 0;
		List<Character> list = new LinkedList<>(lruCache.cacheKeys.keySet());
		// System.out.println(lruCache.cacheKeys.keySet());
		for (int index = 0; index < list.size(); index++) {
			if (lruCache.cacheKeys.containsKey(list.get(index))) {
				// System.out.println(lruCache.getEntry(list.get(index)));
				mapCharAndCounter.put(list.get(index), lruCache.getEntry(list.get(index)));
			}
		}
		return mapCharAndCounter;

	}

	private int countFreqChars(List<Character> listChars, int indexChar) {
		return (int) listChars.stream().filter(x -> x == listChars.get(indexChar)).count();
	};

}
