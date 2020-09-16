package com.lysenko.charcounter;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		cacheRelease(text);
		scanner.close();
	}

	public static void cacheRelease(String text) {
		UniqueCharsCounter charsCounterImpl = new UniqueCharsCounter();
		CharsCounter charsCounter = new CachedCharsCounter(charsCounterImpl);
		for (Map.Entry<Character, Integer> pair : charsCounter.countChar(text).entrySet()) {
			System.out.println("\"" + pair.getKey() + "\" - " + pair.getValue());
		}
	}

}
