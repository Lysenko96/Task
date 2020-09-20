package com.lysenko.charcounter;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class CachedCharsCounterTest {

	@Mock
	private CharsCounter charsCounter;

	@InjectMocks
	private CachedCharsCounter cacheCharsCounter;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void givenOneWordText_thenCountChars_thenGetCallOne() {
		cacheCharsCounter.countChars("text");
		cacheCharsCounter.countChars("text");

		verify(charsCounter, Mockito.times(1)).countChars("text");
	}

	@Test
	void givenTwoAndMoreWordText_thenCountChars_thenGetCallOne() {
		cacheCharsCounter.countChars("text hello man");
		cacheCharsCounter.countChars("text hello man");

		verify(charsCounter, Mockito.times(1)).countChars("text hello man");
	}
}
