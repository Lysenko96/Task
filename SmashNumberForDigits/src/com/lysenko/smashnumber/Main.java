package com.lysenko.smashnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Integer> dividendDigits = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int dividend = scanner.nextInt();
		while (dividend > 0) {
			dividendDigits.add(0, dividend % 10);
			dividend /= 10;
		}
		System.out.println(dividendDigits);
		scanner.close();
		List<Integer> digits = smashNumberForDigits(5748);
		System.out.println(digits);
	}

	static List<Integer> smashNumberForDigits(int number) {
		List<Integer> digits = new ArrayList<>();
		for (; number > 0; number /= 10) {
			digits.add(0, number % 10);
		}
//		for (int index = digits.size() - 1; index >= 0; index--) {
//			System.out.println(digits.get(index));
//		}

		return digits;
	}

}
