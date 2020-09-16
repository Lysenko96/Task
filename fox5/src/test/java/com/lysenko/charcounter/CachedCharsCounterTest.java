package com.lysenko.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

class CachedCharsCounterTest {

	private Map<String, Map<Character, Integer>> cache;

	@Mock
	private CharsCounter charsCounter;

	@InjectMocks
	private CachedCharsCounter cacheCharsCounter;

	@BeforeEach
	void setUp() {
		charsCounter = Mockito.mock(CharsCounter.class);
		cacheCharsCounter = new CachedCharsCounter(charsCounter);
		cache = new HashMap<>();
	}

	@Test
	void givenNull_thenCountChars_getException() {
		assertThrows(NullPointerException.class, () -> charsCounter = Mockito.mock(null));
	}

	@Test
	void givenEmptyText_thenCountChars_getEmpty() {
		Map<Character, Integer> expectedMap = new HashMap<Character, Integer>();
		String text = "";
		Mockito.when(cacheCharsCounter.countChar(text)).thenReturn(expectedMap);
		cache.put(text, cache.getOrDefault(cache.get(text), charsCounter.countChar(text)));
		assertEquals(cache.get(""), cacheCharsCounter.countChar(text));
	}

	@Test
	void givenOneWorld_thenCountChars_getText() {
		Map<Character, Integer> expectedMap = new HashMap<Character, Integer>();
		String text = "text";
		expectedMap.put('t', 2);
		expectedMap.put('e', 1);
		expectedMap.put('x', 1);
		Mockito.when(cacheCharsCounter.countChar("text")).thenReturn(expectedMap);
		cache.put(text, cache.getOrDefault(cache.get(text), charsCounter.countChar(text)));
		assertEquals(cache.get(text), cacheCharsCounter.countChar("text"));
	}

	@Test
	void givenTwoAndMoreWorld_thenCountChars_getText() {
		Map<Character, Integer> expectedMap = new HashMap<Character, Integer>();
		String text = "text hell";
		expectedMap.put('t', 2);
		expectedMap.put('e', 2);
		expectedMap.put('x', 1);
		expectedMap.put(' ', 1);
		expectedMap.put('h', 1);
		expectedMap.put('l', 2);
		Mockito.when(cacheCharsCounter.countChar("text hell")).thenReturn(expectedMap);
		cache.put(text, cache.getOrDefault(cache.get(text), charsCounter.countChar(text)));
		assertEquals(cache.get(text), cacheCharsCounter.countChar("text hell"));
	}

}
