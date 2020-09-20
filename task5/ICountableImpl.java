package net.task5;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ICountableImpl implements ICountable {

	@Override
	public Map<String, Long> countChar(String text, List<String> list) {

		Map<String, Long> map = new LinkedHashMap<>();
		 //map.put(text, System.nanoTime());
		map.put(text, list.stream().filter(x -> x.equals(text)).count());
		return map;
	}
}
