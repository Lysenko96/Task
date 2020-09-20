package com.lysenko.char_counter;

import static java.lang.System.lineSeparator;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter {

	private Map<Character, Integer> countChars(String inputText) {
		char[] chars = inputText.toCharArray();
		Map<Character, Integer> mapCharAndCounter = new LinkedHashMap<>();
		int charIndex = 0;
		int charCounter = 0;
		while (charIndex < inputText.length()) {
			for (int index = 0; index < inputText.length(); index++) {
				if (chars[charIndex] == chars[index]) {
					charCounter++;
				}
			}
			mapCharAndCounter.put(chars[charIndex], charCounter);
			charCounter = 0;
			charIndex++;
		}
		return mapCharAndCounter;
	}

	public String showResult(String inputText) {
		StringBuilder result = new StringBuilder();
		Map<Character, Integer> mapCharAndCounter = new CharCounter().countChars(inputText);
		for (Map.Entry<Character, Integer> pair : mapCharAndCounter.entrySet()) {
			result.append("\"" + pair.getKey() + "\"" + " - " + pair.getValue()).append(lineSeparator());
		}
		return result.toString();
	}
}
