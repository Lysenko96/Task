package com.lysenko.charcounter;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CharCounter2 {

	public Map<Character, Integer> countCharsAndFreq(String text) {
		LRUCacheNew lruCache = new LRUCacheNew(3);
		char[] charsOfText = text.toLowerCase().toCharArray();
		List<Character> listChars = new LinkedList<>();
		for (char chars : charsOfText) {
			listChars.add(chars);
		}
		int indexChar = 0;
		LinkedHashMap<Character, Integer> mapCharAndCounter = new LinkedHashMap<>();
		while (indexChar < listChars.size()) {

			mapCharAndCounter.put(listChars.get(indexChar), countFreqChars(listChars, indexChar, lruCache));
			indexChar++;
		}
		return mapCharAndCounter;
	}

	private int countFreqChars(List<Character> listChars, int indexChar, LRUCacheNew lruCache) {
		return lruCache.refer((int) listChars.stream().filter(x -> x == listChars.get(indexChar)).count());
	}

}
