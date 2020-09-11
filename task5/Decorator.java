package net.task5;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Decorator implements ICountable {

	private ICountable countable;
	private Map<String, Map<String, Long>> cacheData = new LinkedHashMap<>();

	public Decorator(ICountable countable) {
		this.countable = countable;
	}

	@Override
	public Map<String, Long> countChar(String text, List<String> list) {

		Map<String, Long> data = cacheData.get(text);
		if (data == null) {
			data = countable.countChar(text, list);
			cacheData.put(text, data);
		}
		return data;
	}
}
