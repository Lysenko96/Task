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
		this.uniqueCharsCounter = new UniqueCharsCounter();
	}

	@Test
	void givenEmptyText_thenCountChars_GetEmpty() {
		Map<Character, Integer> expectedMap = new HashMap<>();
		Map<Character, Integer> actualMap = uniqueCharsCounter.countChar("");
		assertEquals(expectedMap, actualMap);
	}

	@Test
	void givenTextOneWord_thenCountChars_GetResult() {

		Map<Character, Integer> expectedMap = new LinkedHashMap<>();
		expectedMap.put('h', 1);
		expectedMap.put('e', 1);
		expectedMap.put('l', 2);
		expectedMap.put('o', 1);
		Map<Character, Integer> actualMap = uniqueCharsCounter.countChar("hello");
		assertEquals(expectedMap, actualMap);
	}

	@Test
	void givenTextTwoAndMoreWord_thenCountChars_GetResult() {
		Map<Character, Integer> expectedMap = new LinkedHashMap<>();
		expectedMap.put('w', 1);
		expectedMap.put('h', 1);
		expectedMap.put('a', 2);
		expectedMap.put('t', 1);
		expectedMap.put('\'', 1);
		expectedMap.put('s', 1);
		expectedMap.put(' ', 2);
		expectedMap.put('u', 1);
		expectedMap.put('p', 1);
		expectedMap.put('m', 1);
		expectedMap.put('n', 1);
		expectedMap.put('!', 1);
		Map<Character, Integer> actualMap = uniqueCharsCounter.countChar("what's up man!");
		assertEquals(expectedMap, actualMap);
	}

}
