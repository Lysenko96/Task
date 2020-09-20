package com.lysenko.charcounter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CachedCharsCounterTest {

	@Mock
	private CharsCounter charsCounter;

	@InjectMocks
	private CachedCharsCounter cacheCharsCounter;

	@Test
	void givenOneWordText_thenCountChars_thenGetCallOne() {
		cacheCharsCounter.countChars("text");
		cacheCharsCounter.countChars("text");

		verify(charsCounter, times(1)).countChars("text");
	}

	@Test
	void givenTwoAndMoreWordText_thenCountChars_thenGetCallOne() {
		cacheCharsCounter.countChars("text hello man");
		cacheCharsCounter.countChars("text hello man");

		verify(charsCounter, times(1)).countChars("text hello man");
	}
}
