package com.lysenko.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

public class UniqueCharsCounter implements CharsCounter {

	@Override
	public Map<Character, Long> countChars(String text) {
		return text.chars().mapToObj(charInText -> (char) charInText)
				.collect(groupingBy(Function.identity(), () -> new LinkedHashMap<Character, Long>(), counting()));
	}
}
