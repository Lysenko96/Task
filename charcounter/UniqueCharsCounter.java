package com.lysenko.charcounter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueCharsCounter implements CharsCounter {

	@Override
	public Map<Character, Integer> countChar(String text) {

		List<Character> listCharacters = new ArrayList<>();
		char[] charactersInText = text.toCharArray();
		// Map<Character, Integer> valuesCache = new LinkedHashMap<>();
		Stream<Character> charactersStream = text.chars().mapToObj(c -> (char) c);

		Map<Character, Long> valuesCache = charactersStream.collect(Collectors.groupingBy(Function.identity(),
				() -> new LinkedHashMap<Character, Long>(), Collectors.counting()));

		Collection<Long> l = valuesCache.values();
		List<Integer> li = new ArrayList<>();
		for (Long ll : l) {
			li.add(ll.intValue());
		}
		System.out.println(li);
		Map<Character, Integer> m1 = new LinkedHashMap<>();
		// Iterator<Map<Character, Integer>> i = (Iterator<Map<Character, Integer>>)
		// m1.entrySet();
		for (Map.Entry<Character, Long> pair : valuesCache.entrySet()) {
			m1.put(pair.getKey(), pair.getValue().intValue());
		}
		System.out.println(m1);
//		for (char character : charactersInText) {
//			listCharacters.add(character);
//			valuesCache.put(character,
//					(int) listCharacters.stream().filter(characterFromlist -> characterFromlist == character).count());
//		}
		// return valuesCache;
		return m1;
	}
}
