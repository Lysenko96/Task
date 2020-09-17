package com.lysenko.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueCharsCounter implements CharsCounter {

	@Override
	public Map<Character, Long> countChars(String text) {
		Stream<Character> charactersStream = text.chars().mapToObj(c -> (char) c);
		Map<Character, Long> valuesCache = charactersStream.collect(Collectors.groupingBy(Function.identity(),
				() -> new LinkedHashMap<Character, Long>(), Collectors.counting()));
		return valuesCache;
	}
}
