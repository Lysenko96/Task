package com.lysenko.charcounter;

import java.util.Map;

public interface CharsCounter {

	public Map<Character, Long> countChars(String text);
}
