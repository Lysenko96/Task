package com.lysenko.projectcache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static final int SIZE = 5;

	public static void main(String[] args) {

//		Map<Character, Integer> map = new LinkedHashMap<>();
//		map.put('h', 1);
//		map.put('e', 1);
//		map.put('l', 1);
//		map.put('l', 2);
//		map.put('o', 1);
//		map.put('w', 1);
//		map.put('o', 2);
//		map.put('r', 1);
//		map.put('l', 3);
//		map.put('d', 1);
//		map.put('!', 1);
//
//		for (Map.Entry<Character, Integer> pair : map.entrySet()) {
//			System.out.println(pair.getKey() + " - " + pair.getValue());
//		}
//		List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
//		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
//			@Override
//			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
//				return o2.getValue().compareTo(o1.getValue());
//			}
//		});
//		System.out.println();
//		for (Map.Entry<Character, Integer> mapa : list) {
//			System.out.println(mapa.getKey() + " - " + mapa.getValue());
//		}

//		if (list.size() > SIZE) {
//			while (list.size() != SIZE) {
//				list.remove(list.size() - 1);
//			}
//		}
//		System.out.println();
//		for (Map.Entry<Character, Integer> mapa : list) {
//			System.out.println(mapa.getKey() + " - " + mapa.getValue());
//		}
//
//		System.out.println();
//		int count = 0;
//		for (Map.Entry<Character, Integer> pair : map.entrySet()) {
//			count++;
//			if (count > SIZE) {
//				System.out.println(pair.getKey() + " - " + pair.getValue());
//			}

		// }
		String s = "hello world!";
		char[] chars = s.toCharArray();
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < chars.length; i++) {
			list.add(chars[i]);

		}

		List<Character> list2 = new ArrayList<>(list.subList(0, 5));

		int indexChar = 0;
		LinkedHashMap<Character, Integer> mapCharAndCounter = new LinkedHashMap<>();
		LinkedHashMap<Character, Integer> mapCharAndCounter2 = new LinkedHashMap<>();
		while (indexChar < list2.size()) {
			mapCharAndCounter.put(list2.get(indexChar), countFreqChars(list2, indexChar));
			indexChar++;
		}
		int d = list2.size();
		while (d < list.size()) {
			// mapCharAndCounter2.put(list.get(d), countFreqChars(list, d));
			mapCharAndCounter2.put(list.get(d), 0);
			d++;
		}

		System.out.println(mapCharAndCounter);
		System.out.println(mapCharAndCounter2);
		for (Map.Entry<Character, Integer> pair : mapCharAndCounter.entrySet()) {
			// System.out.print(pair.getKey() + " " + pair.getValue());
			for (Map.Entry<Character, Integer> pair2 : mapCharAndCounter2.entrySet()) {
				if (pair.getKey().equals(pair2.getKey())) {
					int p = pair.getValue();
					p--;
					mapCharAndCounter.put(pair.getKey(), p);
					if (pair.getValue() == 0) {
						mapCharAndCounter.remove(pair.getKey());
						// mapCharAndCounter.put(pair2.getKey(), pair2.getValue());
					}

					int p2 = pair2.getValue();
					p2++;
					mapCharAndCounter2.put(pair2.getKey(), p2);
				}
			}
		}
		d = 0;

		while (d < list.size()) {
			mapCharAndCounter2.put(list.get(d), countFreqChars(list, d));
			d++;
		}
		int b = 0;
		if (mapCharAndCounter.size() < SIZE) {
			for (Map.Entry<Character, Integer> pair2 : mapCharAndCounter2.entrySet()) {
				while (b < 1) {
					mapCharAndCounter.put(pair2.getKey(), pair2.getValue());
					b++;
				}
			}
		}
		int p = 0;
		Iterator<Entry<Character, Integer>> it = mapCharAndCounter2.entrySet().iterator();
		mapCharAndCounter2.remove(it.next().getKey());
		System.out.println(mapCharAndCounter);
		System.out.println(mapCharAndCounter2);

		Map<Character, Integer> l = new LinkedHashMap<>(mapCharAndCounter2);
		List<Map.Entry<Character, Integer>> li = new LinkedList<>(l.entrySet());
		Map<Character, Integer> l2 = new LinkedHashMap<>(mapCharAndCounter);
		List<Map.Entry<Character, Integer>> li2 = new LinkedList<>(l2.entrySet());
		System.out.println(li2.retainAll(li));
	}

	private static int countFreqChars(List<Character> listChars, int indexChar) {
		return (int) listChars.stream().filter(x -> x == listChars.get(indexChar)).count();
	}

}