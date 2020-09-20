package com.lysenko.char_counter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputText = scanner.nextLine();
		String result = new CharCounter().showResult(inputText);
		System.out.println(result);
		scanner.close();
	}
}
