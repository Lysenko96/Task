package com.lysenko.charcounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class UniqueCharsCounterTest {

	private UniqueCharsCounter uniqueCharsCounter;

	@BeforeEach
	void setUp() {
		uniqueCharsCounter = new UniqueCharsCounter();
	}

	@Test
	void givenNull_thenCountChars_thenException() {
		assertThrows(NullPointerException.class, () -> uniqueCharsCounter.countChars(null));
	}

	@Test
	void givenEmptyText_thenCountChars_thenEmptyMap() {
		Map<Character, Long> expectedMap = new HashMap<>();

		Map<Character, Long> actualMap = uniqueCharsCounter.countChars("");

		assertEquals(expectedMap, actualMap);
	}

	@Test
	void givenOneWordText_thenCountChars_thenGetMap() {
		Map<Character, Long> expectedMap = new LinkedHashMap<>();
		expectedMap.put('h', 1l);
		expectedMap.put('e', 1l);
		expectedMap.put('l', 2l);
		expectedMap.put('o', 1l);

		Map<Character, Long> actualMap = uniqueCharsCounter.countChars("hello");

		assertEquals(expectedMap, actualMap);
	}

	@Test
	void givenTwoAndMoreWordText_countChars_thenGetMap() {
		Map<Character, Long> expectedMap = new LinkedHashMap<>();
		expectedMap.put('w', 1l);
		expectedMap.put('h', 1l);
		expectedMap.put('a', 2l);
		expectedMap.put('t', 1l);
		expectedMap.put('\'', 1l);
		expectedMap.put('s', 1l);
		expectedMap.put(' ', 2l);
		expectedMap.put('u', 1l);
		expectedMap.put('p', 1l);
		expectedMap.put('m', 1l);
		expectedMap.put('n', 1l);
		expectedMap.put('!', 1l);

		Map<Character, Long> actualMap = uniqueCharsCounter.countChars("what's up man!");

		assertEquals(expectedMap, actualMap);
	}

}
