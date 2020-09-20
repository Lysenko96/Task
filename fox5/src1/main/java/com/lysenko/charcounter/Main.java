package com.lysenko.charcounter;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		UniqueCharsCounter charsCounterImpl = new UniqueCharsCounter();
		CharsCounter charsCounter = new CachedCharsCounter(charsCounterImpl);
		showResult(text, charsCounter);
		scanner.close();
	}

	public static void showResult(String text, CharsCounter charsCounter) {
		for (Map.Entry<Character, Long> pair : charsCounter.countChars(text).entrySet()) {
			System.out.println("\"" + pair.getKey() + "\" - " + pair.getValue());
		}
	}

}
