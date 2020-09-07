package com.lysenko.charcountertask5;

import static java.lang.System.lineSeparator;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		String result = showResult(text);
		System.out.println(result);
		scanner.close();
	}

	public static String showResult(String text) {

		StringBuilder result = new StringBuilder();
		Map<Character, Integer> mapCharAndCounter = new CharCounter().countCharsAndFreq(text);
		for (Map.Entry<Character, Integer> pair : mapCharAndCounter.entrySet()) {
			result.append("\"" + pair.getKey() + "\"" + " - " + pair.getValue()).append(lineSeparator());
		}
		return result.toString();
	}
}
