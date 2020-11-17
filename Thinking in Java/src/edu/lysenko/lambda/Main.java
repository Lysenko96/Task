package edu.lysenko.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		String[] words = { "hello", "beautiful", "world", "universe" };
		String[] cars = { "lambarghini", "bmw", "audi", "ferrari" };
		System.out.println(Arrays.toString(words));
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				return arg0.length() - arg1.length();
			}
		});
		System.out.println(Arrays.toString(words));
		System.out.println(Arrays.toString(cars));
		Arrays.parallelSort(cars, (s1, s2) -> s1.length() - s2.length());
		System.out.println(Arrays.toString(cars));

		ICalculate add = (x, y) -> x + y;

		double resultSum = add.calculate(10.3, 7.1);
		System.out.println(resultSum);
		System.out.println(add.show());
		System.out.println(ICalculate.returnObj());
	}

}

@FunctionalInterface
interface ICalculate {
	double calculate(double x, double y);

	default String show() {
		return "Hello!";
	}

	static Object returnObj() {
		return new Object();
	}
}
