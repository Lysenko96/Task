package com.lysenko.charcounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharCounter {

	public Map<Character, Integer> countChars(String text) {
		char[] var = text.toLowerCase().toCharArray();
		List<Character> listChars = new LinkedList<>();
		for (char s : var) {
			listChars.add(s);
		}
//		String var2 = ("Some text").toLowerCase().replaceAll("\\s", " ");
//		System.out.println(var2);

//		Map<Character, Integer> countChar = listChars.stream().collect(LinkedHashMap::new, (m, c) -> {
//			if (m.containsKey(c))
//				m.put(c, m.get(c) + 1);
//			else
//				m.put(c, 1);
//		}, LinkedHashMap::putAll);
//() -> new LinkedHashMap<Character, Integer>()
		// (m, c) -> new LinkedHashMap<Character, Integer>().putAll(m)

		Map<Character, Integer> countChar = listChars.stream().collect(() -> new LinkedHashMap<Character, Integer>(),
				(m, c) -> {
					if (m.containsKey(c))
						m.put(c, m.get(c) + 1);
					else
						m.put(c, 1);
				}, (m, c) -> new LinkedHashMap<Character, Integer>().putAll(m));

		Map<Character, Integer> mapCharAndCounter = new LinkedHashMap<>();
		int d = 0;
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		
		while (d < listChars.size()) {
			map.put(listChars.get(d), checkRes(listChars, d));
			d++;
		}
//		for (Map.Entry<Character, Integer> pair : map.entrySet()) {
//			System.out.println(pair.getKey() + " - " + pair.getValue());
//		}

		return map;

	}

	int checkRes(List<Character> listChars, int d) {
		return (int) listChars.stream().filter(x -> x == listChars.get(d)).count();
	}
}

//char[] chars = text.toCharArray();
//Map<Character, Integer> mapCharAndCounter = new LinkedHashMap<>();
//int charIndex = 0;
//int charCounter = 0;
//
//while (charIndex < text.length()) {
//	for (int index = 0; index < text.length(); index++) {
//		if (chars[charIndex] == chars[index]) {
//			charCounter++;
//		}
//	}
//	mapCharAndCounter.put(chars[charIndex], charCounter);
//	charCounter = 0;
//	charIndex++;
//}
//return mapCharAndCounter;
