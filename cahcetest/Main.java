package com.lysenko.cahcetest;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static final int SIZE = 2;

	public static void main(String[] args) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		Map<Character, Integer> mapa = new LinkedHashMap<>();

		String text = "hello world!";
		char[] charsOfText = text.toLowerCase().toCharArray();
		List<Character> listChars = new LinkedList<>();
		for (char chars : charsOfText) {
			listChars.add(chars);
		}

		map.put('h', 1);
		map.put('e', 1);
		map.put('l', 1);
		map.put('l', 2);
		map.put('o', 1);
		map.put('w', 1);
		map.put('o', 2);
		map.put('r', 1);
		map.put('l', 3);
		map.put('d', 1);
		map.put('!', 1);

		for (Map.Entry<Character, Integer> pair : map.entrySet()) {
			System.out.println(pair.getKey() + " - " + pair.getValue());
		}

		Map<Character, Integer> mapa2 = new LinkedHashMap<>();
		int indexChar = 0;

		List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());

//		List<Character> listCharacter = new LinkedList<>();
//
//		for (indexChar = 0; indexChar < list.size(); indexChar++) {
//			listCharacter.add(list.get(indexChar).getKey());
//		}
		indexChar = 0;
		while (indexChar < list.size()) {
			mapa2.put(list.get(indexChar).getKey(), 0);
			indexChar++;
		}

		List<Map.Entry<Character, Integer>> list1 = new LinkedList<>(mapa2.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		System.out.println();
		for (Map.Entry<Character, Integer> mapa1 : list) {
			System.out.println(mapa1.getKey() + " - " + mapa1.getValue());
		}

		if (list.size() > SIZE) {
			while (list.size() != SIZE) {
				list.remove(list.size() - 1);
			}
		}
		System.out.println();
		for (Map.Entry<Character, Integer> mapa1 : list) {
			System.out.println(mapa1.getKey() + " - " + mapa1.getValue());
			mapa.put(mapa1.getKey(), mapa1.getValue());
		}

		Map<Character, Integer> newMap = new LinkedHashMap<>();
		indexChar = 0;
		while (indexChar < list1.size()) {
			for (Map.Entry<Character, Integer> pair : mapa.entrySet()) {
				if (list1.get(indexChar).getKey().equals(pair.getKey())) {
					newMap.put(list1.get(indexChar).getKey(), pair.getValue());
					System.out.print(" cache ");
				} else {
					newMap.put(list1.get(indexChar).getKey(), countFreqChars(listChars, indexChar));
					System.out.print(" not_cache ");
				}
				indexChar++;
			}
		}
		System.out.println();
		System.out.println(list1);

		System.out.println();
		System.out.println(newMap);

	}

	private static int countFreqChars(List<Character> listChars, int indexChar) {
		return (int) listChars.stream().filter(x -> x == listChars.get(indexChar)).count();
	}

}
