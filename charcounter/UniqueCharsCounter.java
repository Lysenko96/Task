package com.lysenko.charcounter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UniqueCharsCounter implements CharsCounter {

	@Override
	public Map<Character, Integer> countChar(String text) {
		List<Character> listCharacters = new ArrayList<>();
		char[] charactersInText = text.toCharArray();
		Map<Character, Integer> valuesCache = new LinkedHashMap<>();
		for (char character : charactersInText) {
			listCharacters.add(character);
			valuesCache.put(character,
					(int) listCharacters.stream().filter(characterFromlist -> characterFromlist == character).count());
		}
		return valuesCache;
	}
}
