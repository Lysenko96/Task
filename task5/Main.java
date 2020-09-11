package net.task5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ICountableImpl object = new ICountableImpl();
		List<String> list = new ArrayList<>();
		ICountable decorator = new Decorator(object);
		Map<String, Long> map = new LinkedHashMap<>();
		Scanner scanner = new Scanner(System.in);

		String text = scanner.nextLine();

		String[] arrStr = text.split("");
		for (String s : arrStr) {
			list.add(s);
		}
		for (String s : arrStr) {
			System.out.println(decorator.countChar(s, list));
			map.put(s, decorator.countChar(s, list).get(s));
		}
		System.out.println(map);
		scanner.close();

	}
}
