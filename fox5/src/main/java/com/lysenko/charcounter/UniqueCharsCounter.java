package com.lysenko.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueCharsCounter implements CharsCounter {

	@Override
	public Map<Character, Integer> countChar(String text) {

		Stream<Character> charactersStream = text.chars().mapToObj(c -> (char) c);
		Map<Character, Long> longValuesCache = charactersStream.collect(Collectors.groupingBy(Function.identity(),
				() -> new LinkedHashMap<Character, Long>(), Collectors.counting()));

		Map<Character, Integer> valuesCache = new LinkedHashMap<>();
		for (Map.Entry<Character, Long> pair : longValuesCache.entrySet()) {
			valuesCache.put(pair.getKey(), pair.getValue().intValue());
		}
		return valuesCache;
	}
}
